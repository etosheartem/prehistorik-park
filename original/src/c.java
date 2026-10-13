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

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class c
extends Canvas {
    boolean a;
    byte a;
    int a;
    int b = 0;
    int c;
    int d;
    int e;
    int f;
    int g = 0;
    int h = 60;
    int i = 7;
    int j = 5;
    int[][] a;
    int[] a = new int[]{(240 - this.h) / 2, 0, (240 + this.h) / 2};

    c(Park park) {
        this.setFullScreenMode(true);
    }

    protected final void paint(Graphics graphics) {
        if (!this.a) {
            graphics.setColor(0xFFFFFF);
            graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
            try {
                Image image = Image.createImage((String)("/splash" + this.a + ".png"));
                this.a = image.getHeight();
                this.b = image.getWidth();
                this.c = this.getWidth() / 2 - this.b / 2;
                this.d = this.getHeight() / 2 - this.a / 2;
                graphics.drawImage(image, this.c, this.d, 20);
                if (this.a == 2) {
                    this.a = true;
                }
            }
            catch (IOException iOException) {}
        }
        if (this.a == 2) {
            this.a[1] = (240 - this.h) / 2 + this.g * this.h / 100;
            this.e = 0;
            while (this.e < 2) {
                this.f = 0;
                while (this.f < this.j) {
                    graphics.setColor(this.a[this.e][this.f]);
                    graphics.drawLine(this.a[this.e], 320 - this.i + this.f, this.a[this.e + 1], 320 - this.i + this.f);
                    ++this.f;
                }
                ++this.e;
            }
            this.e = 0;
            while (this.e < 2) {
                graphics.setColor(0);
                graphics.drawLine(this.a[this.e * 2], 320 - this.i, this.a[this.e * 2], 320 - this.i + this.j - 1);
                ++this.e;
            }
        }
    }
}

