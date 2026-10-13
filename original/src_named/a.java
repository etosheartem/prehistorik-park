/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.media.Manager
 *  javax.microedition.media.Player
 *  javax.microedition.media.control.VolumeControl
 */
import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;

public final class a {
    private static VolumeControl var_javax_microedition_media_control_VolumeControl_a;
    private Player var_javax_microedition_media_Player_a;

    public a(String string, String string2) {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/sound/" + string);
            this.var_javax_microedition_media_Player_a = Manager.createPlayer((InputStream)inputStream, (String)string2);
            this.var_javax_microedition_media_Player_a.realize();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final void a() {
        try {
            if (this.var_javax_microedition_media_Player_a == null) {
                return;
            }
            if (this.var_javax_microedition_media_Player_a.getState() == 300) {
                this.var_javax_microedition_media_Player_a.stop();
            }
            this.var_javax_microedition_media_Player_a.prefetch();
            this.var_javax_microedition_media_Player_a.start();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final void b() {
        try {
            if (this.var_javax_microedition_media_Player_a == null) {
                return;
            }
            try {
                this.var_javax_microedition_media_Player_a.setMediaTime(0L);
            }
            catch (Exception exception) {}
            this.var_javax_microedition_media_Player_a.stop();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final void c() {
        try {
            if (this.var_javax_microedition_media_Player_a == null) {
                return;
            }
            this.var_javax_microedition_media_Player_a.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final void a(int n) {
        try {
            if (this.var_javax_microedition_media_Player_a == null) {
                return;
            }
            this.var_javax_microedition_media_Player_a.setLoopCount(n);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final void a(int n, int n2) {
        try {
            if (this.var_javax_microedition_media_Player_a == null) {
                return;
            }
            var_javax_microedition_media_control_VolumeControl_a = (VolumeControl)this.var_javax_microedition_media_Player_a.getControl("VolumeControl");
            if (n == 0) {
                this.b();
            } else if (n2 == 0) {
                this.a();
            }
            var_javax_microedition_media_control_VolumeControl_a.setLevel(n * 20);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

