/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class c
extends Canvas {
    boolean var_boolean_a = false;
    byte var_byte_a = 0;
    int var_int_a = 0;
    int b = 0;
    int c;
    int d;
    int e;
    int f;
    int g = 0;
    int h = 60;
    int i = 7;
    int j = 5;
    int[][] var_int_arr_arr_a = new int[][]{{0, 15662897, 16762897, 16691973, 0}, {0, 8940804, 8928768, 8859904, 0}};
    int[] var_int_arr_a = new int[]{(240 - this.h) / 2, 0, (240 + this.h) / 2};

    c(Park park) {
        this.setFullScreenMode(true);
    }

    protected final void paint(Graphics graphics) {
        if (!this.var_boolean_a) {
            graphics.setColor(0xFFFFFF);
            graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
            try {
                Image image = Image.createImage((String)("/splash" + this.var_byte_a + ".png"));
                this.var_int_a = image.getHeight();
                this.b = image.getWidth();
                this.c = this.getWidth() / 2 - this.b / 2;
                this.d = this.getHeight() / 2 - this.var_int_a / 2;
                graphics.drawImage(image, this.c, this.d, 20);
                if (this.var_byte_a == 2) {
                    this.var_boolean_a = true;
                }
            }
            catch (IOException iOException) {}
        }
        if (this.var_byte_a == 2) {
            this.var_int_arr_a[1] = (240 - this.h) / 2 + this.g * this.h / 100;
            this.e = 0;
            while (this.e < 2) {
                this.f = 0;
                while (this.f < this.j) {
                    graphics.setColor(this.var_int_arr_arr_a[this.e][this.f]);
                    graphics.drawLine(this.var_int_arr_a[this.e], 320 - this.i + this.f, this.var_int_arr_a[this.e + 1], 320 - this.i + this.f);
                    ++this.f;
                }
                ++this.e;
            }
            this.e = 0;
            while (this.e < 2) {
                graphics.setColor(0);
                graphics.drawLine(this.var_int_arr_a[this.e * 2], 320 - this.i, this.var_int_arr_a[this.e * 2], 320 - this.i + this.j - 1);
                ++this.e;
            }
        }
    }
}

