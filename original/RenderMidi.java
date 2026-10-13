import com.sun.media.sound.AudioSynthesizer;
import com.sun.media.sound.SoftSynthesizer;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import javax.sound.midi.*;
import javax.sound.sampled.*;

/** Offline render using the installed JDK's procedural General MIDI soundbank. */
public class RenderMidi {
    public static void main(String[] args) throws Exception {
        Sequence sequence = MidiSystem.getSequence(new File(args[0]));
        if (sequence.getDivisionType() != Sequence.PPQ) throw new IllegalArgumentException("PPQ required");
        AudioSynthesizer synth = new SoftSynthesizer();
        var properties = new HashMap<String,Object>();
        properties.put("interpolation", "sinc");
        properties.put("reverb", true);
        properties.put("chorus", true);
        AudioFormat format = new AudioFormat(44100, 16, 2, true, false);
        try (AudioInputStream audio = synth.openStream(format, properties)) {
            synth.loadAllInstruments(synth.getDefaultSoundbank());
            Receiver receiver = synth.getReceiver();
            var events = new ArrayList<MidiEvent>();
            for (Track track : sequence.getTracks())
                for (int i = 0; i < track.size(); i++) events.add(track.get(i));
            events.sort(Comparator.comparingLong(MidiEvent::getTick));
            long lastTick = 0, micros = 0;
            int tempo = 500000;
            for (MidiEvent event : events) {
                micros += (event.getTick() - lastTick) * tempo / sequence.getResolution();
                lastTick = event.getTick();
                MidiMessage message = event.getMessage();
                if (message instanceof MetaMessage meta) {
                    byte[] data = meta.getData();
                    if (meta.getType() == 0x51 && data.length == 3)
                        tempo = ((data[0] & 255) << 16) | ((data[1] & 255) << 8) | (data[2] & 255);
                } else receiver.send(message, micros);
            }
            long frames = (long)((micros / 1000000.0 + 2.5) * format.getFrameRate());
            AudioSystem.write(new AudioInputStream(audio, format, frames), AudioFileFormat.Type.WAVE, new File(args[1]));
            System.out.printf("MIDI rendered: %.3f seconds, 44100 Hz stereo, bank %s%n", frames / 44100.0, synth.getDefaultSoundbank().getName());
            receiver.close();
        } finally { synth.close(); }
    }
}
