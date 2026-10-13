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

public class Park
extends MIDlet {
    e var_e_a;
    c var_c_a;
    int[] var_int_arr_a = new int[]{0, 1500, 1500, 100};

    public final void startApp() {
        if (this.var_e_a == null) {
            long l = System.currentTimeMillis();
            int n = 0;
            while (n < 4) {
                long l2 = System.currentTimeMillis();
                if (l2 - l <= (long)this.var_int_arr_a[n]) continue;
                System.gc();
                if (n < 3) {
                    this.var_c_a = new c(this);
                    this.var_c_a.var_byte_a = (byte)n;
                    Display.getDisplay((MIDlet)this).setCurrent((Displayable)this.var_c_a);
                } else {
                    this.var_c_a.g = 0;
                    this.var_c_a.repaint();
                    this.var_e_a = new e(this);
                    System.gc();
                    this.var_e_a.void_a();
                    Display.getDisplay((MIDlet)this).setCurrent((Displayable)this.var_e_a);
                    this.var_c_a = null;
                    System.gc();
                }
                n = (byte)(n + 1);
                l = System.currentTimeMillis();
            }
            return;
        }
        this.var_e_a.var_boolean_b = false;
        this.var_e_a.void_e();
    }

    public final void pauseApp() {
        this.var_e_a.var_a_a.b();
        this.var_e_a.var_boolean_b = true;
    }

    public final void destroyApp(boolean bl) {
        if (this.var_e_a != null) {
            this.var_e_a.void_d();
        }
    }
}

