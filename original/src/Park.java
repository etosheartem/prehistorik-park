/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 *  javax.microedition.midlet.MIDlet
 */
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class Park
extends MIDlet {
    e a;
    c a;
    int[] a = new int[]{0, 1500, 1500, 100};

    public final void startApp() {
        if (this.a == null) {
            long l = System.currentTimeMillis();
            int n = 0;
            while (n < 4) {
                long l2 = System.currentTimeMillis();
                if (l2 - l <= (long)this.a[n]) continue;
                System.gc();
                if (n < 3) {
                    this.a = new c(this);
                    this.a.a = (byte)n;
                    Display.getDisplay((MIDlet)this).setCurrent((Displayable)this.a);
                } else {
                    this.a.g = 0;
                    this.a.repaint();
                    this.a = new e(this);
                    System.gc();
                    this.a.a();
                    Display.getDisplay((MIDlet)this).setCurrent((Displayable)this.a);
                    this.a = null;
                    System.gc();
                }
                n = (byte)(n + 1);
                l = System.currentTimeMillis();
            }
            return;
        }
        this.a.b = false;
        this.a.e();
    }

    public final void pauseApp() {
        this.a.a.b();
        this.a.b = true;
    }

    public final void destroyApp(boolean bl) {
        if (this.a != null) {
            this.a.d();
        }
    }
}

