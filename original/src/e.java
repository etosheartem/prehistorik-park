/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 *  javax.microedition.lcdui.game.GameCanvas
 *  javax.microedition.rms.RecordStore
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.rms.RecordStore;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class e
extends GameCanvas
implements Runnable {
    boolean a;
    Park a;
    boolean b;
    boolean c;
    Thread a;
    Graphics a;
    Image a;
    Graphics b;
    byte a;
    Graphics[] a;
    Random a;
    long a;
    long b;
    int a;
    byte[] a;
    byte b;
    byte c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    byte d;
    byte e;
    byte f;
    byte g;
    byte h;
    byte i;
    byte j;
    boolean j;
    byte k;
    byte l;
    byte m;
    byte n;
    byte o;
    byte p;
    byte q;
    byte r;
    byte s;
    byte t;
    byte u;
    byte v;
    byte w;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    final int[][] a;
    final int[][] b;
    final int[][][] a;
    final int[][][] b;
    byte x;
    byte y;
    byte z;
    byte A;
    byte B;
    byte C;
    int i;
    byte[] b;
    byte D;
    byte E;
    byte F;
    byte G;
    byte H;
    byte I;
    byte J;
    byte K;
    byte L;
    byte M;
    byte N;
    boolean k;
    byte O;
    byte P;
    byte Q;
    byte R;
    byte S;
    byte T;
    final byte[] c;
    final byte[] d;
    final byte[] e;
    final byte[] f;
    final byte[] g;
    final byte[] h;
    final byte[] i;
    final byte[] j;
    final byte[] k;
    final byte[] l;
    final byte[] m;
    final byte[] n;
    final byte[] o;
    final byte[] p;
    final byte[] q;
    final byte[] r;
    final byte[] s;
    final byte[] t;
    final byte[] u;
    final byte[][] a;
    byte[] v;
    final byte[] w;
    byte[] x;
    byte[] y;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    byte U;
    int j;
    int[][] c;
    int[][] d;
    final short[] a;
    int[][] e;
    byte V;
    int k;
    int l;
    int m;
    byte W;
    byte X;
    Image[] a;
    Image[] b;
    Image[] c;
    Image[][] a;
    Image[] d;
    byte[][] b;
    byte[][] c;
    short[][] a;
    byte Y;
    byte Z;
    byte[][] d;
    byte aa;
    int n;
    boolean p;
    byte ab;
    byte[] z;
    int[] a;
    int[][] f;
    short a;
    byte ac;
    byte[] A;
    byte[] B;
    byte[] C;
    byte[] D;
    byte[] E;
    byte[] F;
    byte[] G;
    byte[] H;
    byte[][] e;
    byte[] I;
    byte[] J;
    byte[] K;
    byte[][] f;
    byte[] L;
    short[] b;
    byte[] M;
    byte[] N;
    byte[] O;
    byte[] P;
    byte[] Q;
    byte[] R;
    byte[] S;
    byte[] T;
    byte[] U;
    byte[] V;
    byte ad;
    byte ae;
    byte[] W;
    byte[][] g;
    short[][] b;
    byte af;
    short b;
    byte[][] h;
    byte[] X;
    short[] c;
    short[][] c;
    short[] d;
    short[][] d;
    short c;
    short[] e;
    byte ag;
    byte[][] i;
    byte[] Y;
    byte[][] j;
    byte[][][] a;
    byte ah;
    byte[][] k;
    byte ai;
    byte[] Z;
    byte[] aa;
    byte[][] l;
    byte[][] m;
    byte[][] n;
    byte[] ab;
    byte[] ac;
    short[][] e;
    byte[] ad;
    byte[] ae;
    short[][] f;
    byte[] af;
    byte[] ag;
    byte[] ah;
    byte[] ai;
    byte[] aj;
    boolean[] a;
    boolean[] b;
    boolean[] c;
    byte aj;
    byte ak;
    byte[] ak;
    boolean[] d;
    boolean[] e;
    boolean[] f;
    boolean[] g;
    byte[] al;
    short[] f;
    byte[] am;
    byte[] an;
    byte[] ao;
    byte[] ap;
    byte[] aq;
    byte[] ar;
    byte[] as;
    byte[] at;
    byte[] au;
    byte[] av;
    byte[] aw;
    byte[] ax;
    byte[] ay;
    byte[] az;
    byte[] aA;
    byte[] aB;
    byte[] aC;
    byte[] aD;
    byte al;
    byte[][] o;
    short[][] g;
    byte[] aE;
    short[] g;
    boolean[] h;
    byte[] aF;
    byte[] aG;
    byte[] aH;
    byte[][] p;
    short[][] h;
    boolean[][] a;
    int o;
    byte[] aI;
    short[] h;
    final byte[] aJ;
    byte[][] q;
    byte[] aK;
    byte[][] r;
    int p;
    int q;
    int r;
    int s;
    int t;
    int u;
    int v;
    int w;
    short d;
    int x;
    int y;
    int z;
    int A;
    int B;
    int C;
    int[] b;
    byte am;
    byte an;
    byte ao;
    byte ap;
    byte aq;
    byte ar;
    byte as;
    byte at;
    byte au;
    byte av;
    byte[] aL;
    byte[] aM;
    boolean q;
    boolean r;
    short e;
    byte aw;
    byte ax;
    byte[] aN;
    short[] i;
    byte[] aO;
    short[] j;
    byte[] aP;
    short[] k;
    byte[][] s;
    short[][] i;
    String[] a;
    int D;
    int E = 1;
    byte ay;
    byte az;
    byte[][] t;
    byte[][] u;
    int[] c;
    int[] d;
    int[] e;
    int[] f;
    int[] g;
    short[] l;
    short[] m;
    int F;
    int G;
    byte aA;
    byte aB;
    byte aC;
    int H;
    boolean[] i;
    byte aD;
    boolean[] j;
    byte aE;
    byte aF;
    byte aG;
    byte[][] v;
    byte[][] w;
    int[] h;
    int[] i;
    int[] j;
    int[] k;
    int[] l;
    byte aH;
    byte[][] x;
    byte[] aQ;
    byte[] aR;
    byte[] aS;
    byte aI;
    short f;
    short g;
    short h;
    short i;
    short j = 0;
    short k;
    byte[] aT;
    String a;
    StringBuffer a;
    InputStream a;
    ByteArrayOutputStream a;
    DataOutputStream a;
    DataInputStream a;
    RecordStore a;
    a a = null;
    byte aJ;
    int I;
    int J;
    byte aK;
    byte aL;
    byte aM;
    int K;
    int L;
    int M;
    boolean s;
    boolean t;
    int N = 0;
    int O;
    int P = 0;
    int Q;
    int R;
    int S;
    int T;
    String[] b = (byte)3;
    int U;
    int V;
    int W;
    int X;
    int Y;
    int Z;
    int aa;
    short l = 240;
    short m;
    short n;
    short o;
    int ab;
    int[] m = 320;
    byte aN;
    byte aO;
    byte[] aU;
    byte[] aV;
    byte aP;
    byte aQ;
    byte aR;
    int ac;
    int ad;
    int ae;
    int af;
    byte[] aW;
    byte[] aX;
    int ag;
    boolean u;
    byte[] aY;
    int ah;
    int ai;
    int aj = 0;
    int ak;
    int al;
    int am;
    byte aS;
    byte aT;
    byte aU;
    int[] n = 0;
    byte aV;
    byte aW;
    byte aX;
    byte aY;
    byte aZ;
    int an;
    int ao;
    int ap;
    int[] o = false;
    int[] p;
    int aq;
    int ar;
    int as;
    int at;
    int au;
    int av;
    int aw;
    int ax;
    int ay;
    int az = 0;
    int aA;
    int aB;
    int aC;
    int aD;
    int aE;
    int aF;
    boolean v;
    int[][] g;
    int aG = 0;
    int aH;
    int aI;
    int aJ;
    byte ba;
    int aK;
    int aL;
    int aM;
    int aN;
    int aO;
    int aP;
    int aQ;
    int aR;
    byte bb;
    byte bc;
    byte bd;
    boolean w;
    short p = true;
    short q;
    byte[] aZ;
    int aS;
    int aT;
    int aU;
    int aV;
    byte be;
    byte bf;
    int aW;
    byte bg;
    byte bh;
    int aX;
    byte bi;
    int aY;
    int aZ;
    byte bj;
    int ba;
    int bb;
    int bc;
    int bd;
    int be;
    int bf;
    int bg;
    int bh;
    int bi;
    int bj;
    int bk;
    int bl;
    int bm;
    int bn;
    int bo;
    int bp;
    int bq;
    int br;
    int bs;
    int bt;
    int bu;
    int bv;
    long c = false;
    boolean x;

    public e(Park park) {
        super(false);
        this.f = (byte)-1;
        this.i = (byte)-1;
        this.k = (byte)24;
        this.l = (byte)100;
        this.m = (byte)4;
        this.n = (byte)4;
        this.o = (byte)15;
        this.p = (byte)20;
        this.q = (byte)20;
        this.r = (byte)30;
        this.s = (byte)10;
        this.t = (byte)(this.m * 10);
        this.u = (byte)10;
        this.v = (byte)45;
        this.a = new int[][]{{500, 400, 500, 600, 650, 700}, {500, 300, 350, 400, 450, 500}};
        this.b = new int[][]{{700}, {600}};
        this.a = new int[][][]{new int[][]{{100, 2, 5}, {750, 5, 40}, {1500, 6, 80}, {3000, 7, 120}, {6000, 8, 150}, {10000, 9, 170}}, new int[][]{{100, 2, 5}, {1500, 6, 60}, {3000, 7, 100}, {5000, 8, 150}, {10000, 9, 180}, {15000, 9, 190}}};
        this.b = new int[][][]{this.b, this.a};
        this.x = (byte)7;
        this.b = new byte[19];
        this.F = (byte)-1;
        this.G = (byte)-1;
        this.H = (byte)-1;
        this.I = (byte)-1;
        this.J = (byte)-1;
        this.R = (byte)15;
        this.c = new byte[]{1, 0, 2, 95, 3, 107};
        this.d = new byte[]{21, 4, 6, 2, 3, 5};
        this.e = new byte[]{8, 9};
        this.f = new byte[]{10, 11};
        this.g = new byte[]{12, 11};
        this.h = new byte[]{13};
        this.i = new byte[]{10, 12, 11};
        this.j = new byte[]{12};
        this.k = new byte[]{14, 15, 16, 17, 18, 99};
        this.l = new byte[]{41};
        this.m = new byte[]{21, 22};
        this.n = new byte[]{94, 24, 25, 26, 27, 28};
        this.o = new byte[]{30, 31, 16, 32, 33};
        this.p = new byte[]{35};
        this.q = new byte[]{36};
        this.r = new byte[]{37};
        this.s = new byte[]{108, 109, 110, 111, 112};
        this.t = new byte[]{96, 97};
        this.u = new byte[]{100, 101, 102, 103, 104};
        this.a = new byte[][]{this.c, this.d, new byte[0], new byte[0], this.l, new byte[0], this.m, this.t, this.n, this.s, new byte[0], this.o, {39}, {34}, this.p, this.q, this.r, this.e, this.f, this.g, this.h, this.i, this.j, new byte[0], new byte[0], this.u, this.k};
        this.v = new byte[]{6, 6, 0, 0, 1, 0, 2, 2, this.E, 5, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 1, 3, 1, 0, 0, 0, 6};
        this.w = new byte[]{-1, -1, 3, 95, 2, 20, -1, -1, 23, 107, 0, 29, -1, -1, -1, -1, -1, 7, 0, 0, 0, 0, 0, 19, 38, 98, 0};
        this.x = new byte[3];
        this.y = new byte[3];
        this.c = new int[8][d.k[4] + 2];
        this.d = new int[][]{{0, 500}, {0, 10}, {0, 10}, {0, 50}};
        this.a = new short[]{40, 100, 250, 150, 300, 200, 350, 50, 200, 400, 250, 500, 300, 600};
        this.e = new int[3][2];
        this.a = new Image[11];
        this.b = new Image[13];
        this.c = new Image[12];
        this.a = new Image[][]{this.a, this.b, this.c};
        this.d = new Image[4];
        this.b = new byte[30][30];
        this.c = new byte[30][30];
        this.a = new short[6][6];
        this.d = new byte[10][10];
        this.aa = (byte)5;
        this.z = new byte[4];
        this.a = new int[2];
        this.f = new int[4][2];
        this.A = new byte[222];
        this.B = new byte[222];
        this.C = new byte[222];
        this.D = new byte[222];
        this.E = new byte[222];
        this.F = new byte[222];
        this.G = new byte[222];
        this.H = new byte[222];
        this.e = new byte[][]{this.G, this.H};
        this.I = new byte[222];
        this.J = new byte[222];
        this.K = new byte[]{0, 1, 0, 2};
        this.f = new byte[3][200];
        this.L = new byte[200];
        this.b = new short[200];
        this.M = new byte[200];
        this.N = new byte[200];
        this.O = new byte[200];
        this.P = new byte[200];
        this.Q = new byte[200];
        this.R = new byte[200];
        this.S = new byte[200];
        this.T = new byte[200];
        this.U = new byte[200];
        this.V = new byte[200];
        this.ad = (byte)6;
        this.ae = (byte)7;
        this.W = new byte[222];
        this.g = new byte[][]{this.P, this.Q, this.R, this.S, this.T, this.U, this.V, this.W, this.L};
        this.b = new short[][]{{20, 20, 25, 25, 20, 350, 50}, {12, 12, 16, 16, 12, 150, 25}};
        this.af = (byte)20;
        this.b = (short)2000;
        this.h = new byte[3][222];
        this.X = new byte[222];
        this.c = new short[222];
        this.c = new short[30][30];
        this.d = new short[222];
        this.d = new short[2][200];
        this.e = new short[b.j[3] + 1];
        this.i = new byte[30][2];
        this.Y = new byte[30];
        this.j = new byte[30][20];
        this.a = new byte[30][20][2];
        this.k = new byte[15][2];
        this.Z = new byte[42];
        this.aa = new byte[42];
        this.l = new byte[2][42];
        this.m = new byte[2][42];
        this.n = new byte[2][42];
        this.ab = new byte[42];
        this.ac = new byte[42];
        this.e = new short[42][12];
        this.ad = new byte[42];
        this.ae = new byte[42];
        this.f = new short[42][10];
        this.af = new byte[42];
        this.ag = new byte[42];
        this.ah = new byte[42];
        this.ai = new byte[42];
        this.aj = new byte[42];
        this.a = new boolean[42];
        this.b = new boolean[42];
        this.c = new boolean[42];
        this.ak = new byte[90];
        this.d = new boolean[90];
        this.e = new boolean[90];
        this.f = new boolean[90];
        this.g = new boolean[24];
        this.al = new byte[24];
        this.f = new short[24];
        this.am = new byte[24];
        this.an = new byte[24];
        this.ao = new byte[24];
        this.ap = new byte[24];
        this.aq = new byte[24];
        this.ar = new byte[24];
        this.as = new byte[24];
        this.at = new byte[24];
        this.au = new byte[24];
        this.av = new byte[24];
        this.aw = new byte[24];
        this.ax = new byte[24];
        this.ay = new byte[24];
        this.az = new byte[24];
        this.aA = new byte[24];
        this.aB = new byte[24];
        this.aC = new byte[24];
        this.aD = new byte[25];
        this.al = (byte)114;
        this.o = new byte[24][];
        this.g = new short[24][42];
        this.aE = new byte[27];
        this.g = new short[6];
        this.h = new boolean[27];
        this.aF = new byte[27];
        this.aG = new byte[27];
        this.aH = new byte[27];
        this.p = new byte[27][];
        this.h = new short[27][16];
        this.a = new boolean[][]{this.g, this.h};
        this.h = new short[177];
        this.aJ = new byte[]{24, 27};
        this.q = new byte[][]{{5, 6}, {34}, {7, 8}};
        this.aK = new byte[]{9, 10};
        this.r = new byte[][]{{2, 3, 3, 2}, {3, 2, 2, 3}};
        this.b = new int[2];
        this.aL = new byte[2];
        this.aM = new byte[2];
        this.aN = new byte[1500];
        this.i = new short[500];
        this.aO = new byte[3000];
        this.j = new short[50];
        this.aP = new byte[7000];
        this.k = new short[50];
        this.s = new byte[][]{this.aP, this.aO, this.aN, this.aO};
        this.i = new short[][]{this.k, this.j, this.i, this.j};
        this.a = new String[]{"helptext.da", "warntext.da", "text.da"};
        this.ay = (byte)20;
        this.t = new byte[this.ay][80];
        this.u = new byte[this.ay][80];
        this.c = new int[this.ay];
        this.d = new int[this.ay];
        this.e = new int[this.ay];
        this.f = new int[this.ay];
        this.g = new int[this.ay];
        this.l = new short[250];
        this.m = new short[250];
        this.aB = (byte)-1;
        this.i = new boolean[32];
        this.aD = (byte)2;
        this.j = new boolean[this.aD];
        this.aE = (byte)12;
        this.aF = (byte)100;
        this.v = new byte[this.aF][2];
        this.w = new byte[this.aF][5];
        this.h = new int[this.aF];
        this.i = new int[this.aF];
        this.j = new int[this.aF];
        this.k = new int[this.aF];
        this.l = new int[this.aF];
        this.aH = (byte)20;
        this.x = new byte[this.aH][2];
        this.aQ = new byte[this.aH];
        this.aR = new byte[this.aH];
        this.aS = new byte[this.aH];
        this.aI = (byte)-60;
        this.aT = new byte[2];
        this.a = new StringBuffer(50);
        this.aJ = (byte)2;
        this.b = new String[]{"arrsi.dat", "arr.dat"};
        this.m = new int[3];
        this.aU = new byte[4];
        this.aV = new byte[2];
        this.aW = new byte[4];
        this.aX = new byte[]{0, 1, 1, 2};
        this.aY = new byte[6];
        this.n = new int[4];
        this.o = new int[2];
        this.p = new int[2];
        this.g = new int[2][this.u.length];
        this.aZ = new byte[2];
        this.a = park;
        this.setFullScreenMode(true);
        this.a.a.g = 10;
        this.a.a.repaint();
    }

    final void a() {
        System.gc();
        this.t();
        System.gc();
        this.dG();
        this.a.a.g = 60;
        this.a.a.repaint();
        this.I = 0;
        while (this.I < 32) {
            this.i[this.I] = false;
            ++this.I;
        }
        this.I = 0;
        while (this.I < this.aD) {
            this.j[this.I] = false;
            ++this.I;
        }
        this.a = new a("entry.mid", "audio/midi");
        this.a.a(6000);
        this.a.a(0, 1);
        this.dT();
        this.a.a.g = 80;
        this.a.a.repaint();
        this.b();
        this.d[0] = this.c[7];
        this.d[1] = this.c[7];
        this.d[2] = this.a[0];
        this.d[3] = this.c[7];
        this.I = 0;
        while (this.I < 10) {
            this.J = 0;
            while (this.J < 10) {
                this.d[this.I][this.J] = (byte)(-1 - (this.a.nextInt() & 0xFFFF) % 12);
                ++this.J;
            }
            ++this.I;
        }
        this.ct();
        this.a.a.g = 100;
        this.a.a.repaint();
        this.c();
    }

    final void b() {
        try {
            this.I = 0;
            while (this.I < 3) {
                System.gc();
                this.a = this.getClass().getResourceAsStream("/gpack" + this.I + ".dat");
                if (this.a != null) {
                    this.J = 0;
                    while (this.J < this.a[this.I].length) {
                        System.gc();
                        this.u = this.a.read();
                        this.v = this.a.read();
                        int n = this.v * 256 + this.u;
                        if (n != 0) {
                            byte[] byArray = new byte[n];
                            this.a.read(byArray, 0, n);
                            this.a[this.I][this.J] = Image.createImage((byte[])byArray, (int)0, (int)n);
                        }
                        ++this.J;
                    }
                }
                this.a.close();
                this.a = null;
                this.a.a.g = 85 + this.I * 5;
                this.a.a.repaint();
                ++this.I;
            }
            System.gc();
            this.b[7] = this.a[10];
            this.a = Image.createImage((int)this.l, (int)this.m);
            this.a[1] = this.b = this.a.getGraphics();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public final void c() {
        this.c = true;
        this.a = new Thread(this);
        this.a.start();
    }

    public final void d() {
        this.dS();
        this.c = false;
        this.a.c();
        this.a.notifyDestroyed();
    }

    public final void hideNotify() {
        this.a.b();
        this.b = true;
    }

    public final void showNotify() {
        if (this.b) {
            this.b = false;
            this.e();
        }
    }

    final void e() {
        if (this.b == 3 && this.R == 16) {
            return;
        }
        this.i = (byte)-1;
        this.p = true;
        this.aK = this.b;
        this.aL = this.R;
        this.aM = this.aA;
        this.b = (byte)3;
        this.R = (byte)16;
        this.cu();
        this.aa = (byte)5;
    }

    final void f() {
        this.b = this.aK;
        this.R = this.aL;
        if (this.b == 3) {
            this.cu();
        }
        if (this.b == 2) {
            this.co();
        }
        if (this.b == 1 || this.b == 4) {
            this.aK = this.b;
            this.b = 0;
            this.a = 1;
            this.aa = (byte)5;
            this.x();
            this.al();
            this.a = 0;
            this.b = this.aK;
            this.aa = 0;
        } else {
            this.aa = (byte)5;
        }
        this.aA = this.aM;
        if ((this.b != 3 || this.R != 15) && this.aJ > 0) {
            this.a.a();
        }
    }

    final void g() {
        this.h();
        this.i();
        this.j();
        this.e = 0;
        this.g = 0;
        this.f = (byte)-1;
        this.h = (byte)-1;
        this.K = 0;
        while (this.K < this.aD) {
            this.j[this.K] = false;
            ++this.K;
        }
        this.e[0][0] = this.k = this.b[this.K][this.M][this.L];
        this.e[1][0] = 0;
        this.e[2][0] = 0;
        this.K = 0;
        while (this.K < 8) {
            this.c[this.K][0] = this.K < 3 ? this.e[this.K][0] : 0;
            this.c[this.K][d.k[4]] = 1;
            ++this.K;
        }
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.w = (byte)-1;
        this.V = 0;
        this.b[this.ab][0] = 0;
    }

    final void h() {
        if (this.K == 1) {
            this.c = 0;
            this.O = this.aI[this.h[134] + this.L];
            this.K = 0;
            while (this.K < 2) {
                this.L = 0;
                while (this.L < this.aJ[this.K]) {
                    this.a[this.K][this.L] = this.aI[this.h[40 + this.K] + this.aJ[this.K] * this.L + this.L] == 1;
                    ++this.L;
                }
                ++this.K;
            }
            this.K = 0;
            while (this.K < this.b.length) {
                this.b[this.K] = 0;
                ++this.K;
            }
            this.D = 0;
            this.e[0][1] = this.a[this.M][this.L][0];
            this.e[1][1] = this.a[this.M][this.L][1];
            this.e[2][1] = this.a[this.M][this.L][2];
        } else if (this.K == 0) {
            this.K = 0;
            while (this.K < 2) {
                this.L = 0;
                while (this.L < this.a[this.K].length) {
                    this.a[this.K][this.L] = true;
                    ++this.L;
                }
                ++this.K;
            }
            this.O = (byte)30;
        }
        this.ab = (byte)(this.O / 2);
        this.a[0] = this.ab;
        this.a[1] = 0;
        this.r();
    }

    final void i() {
        this.K = 0;
        while (this.K < this.O) {
            this.L = 0;
            while (this.L < this.O) {
                this.b[this.K][this.L] = (this.a.nextInt() & 0xFFFF) % 20 == 0 ? (byte)(-1 - (this.a.nextInt() & 0xFFFF) % 12) : (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
                this.c[this.K][this.L] = 0;
                this.c[this.K][this.L] = -1;
                if (!((this.K + 1) % 5 != 0 && this.K + 1 != this.O || (this.L + 1) % 5 != 0 && this.L + 1 != this.O)) {
                    this.Y = (byte)(this.K / 5);
                    this.Z = (byte)(this.L / 5);
                    this.cG();
                }
                ++this.L;
            }
            ++this.K;
        }
        this.K = 0;
        while (this.K < 222) {
            this.d[this.K] = -1;
            this.B[this.K] = -1;
            ++this.K;
        }
        this.K = 0;
        while (this.K < 42) {
            this.l[0][this.K] = -1;
            ++this.K;
        }
        this.K = 0;
        while (this.K < 90) {
            this.ak[this.K] = -1;
            ++this.K;
        }
        this.K = 0;
        while (this.K < 30) {
            this.i[this.K][0] = -1;
            ++this.K;
        }
        this.K = 0;
        while (this.K < 15) {
            this.k[this.K][0] = -1;
            ++this.K;
        }
    }

    final void j() {
        this.K = 0;
        while (this.K < this.aF) {
            this.l[this.K] = this.o;
            ++this.K;
        }
        this.K = 0;
        while (this.K < this.aH) {
            this.x[this.K][0] = -1;
            ++this.K;
        }
        this.K = 0;
        while (this.K < 24) {
            this.al[this.K] = (byte)(this.aA[this.K] / b.au[0]);
            this.o = this.K;
            this.cH();
            this.aD[this.K] = 0;
            ++this.K;
        }
        this.aD[24] = 0;
        this.K = 0;
        while (this.K < 6) {
            this.aE[this.K] = b.aq[this.K];
            ++this.K;
        }
        this.K = 0;
        while (this.K < 27) {
            if (this.aI[this.h[57] + this.K] >= 0) {
                this.o = this.K;
                this.cI();
            }
            ++this.K;
        }
        this.ai = 0;
        this.ak = 0;
        this.a = 0;
        this.c[2][d.k[4] + 1] = 0;
        this.ac = 0;
        this.K = 0;
        while (this.K < b.j[3] + 1) {
            this.e[this.K] = 0;
            ++this.K;
        }
        this.K = 0;
        while (this.K < 4) {
            this.aW[this.K] = 0;
            ++this.K;
        }
        this.y = 0;
        this.d = (byte)-1;
        this.W = 0;
        this.X = 0;
        this.d = false;
        this.f = false;
        this.g = false;
    }

    public final void run() {
        try {
            while (this.c) {
                if (this.b) continue;
                Thread.yield();
                this.b = System.currentTimeMillis();
                if (this.b <= this.a + 100L) continue;
                this.aS();
                this.k();
                this.a = 1;
                if (this.aa != 0) {
                    this.x();
                }
                this.a = 0;
                this.a[this.a].drawImage(this.a, 0, 0, 20);
                if (this.i >= 0) {
                    this.i = (byte)(this.i + 1);
                }
                if (this.i >= this.s) {
                    this.i = (byte)-1;
                }
                if (this.b == 0) {
                    this.l();
                    this.m();
                    this.n();
                    if (this.b == 3) {
                        continue;
                    }
                } else {
                    this.o();
                }
                this.p();
                this.a = this.b;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void k() {
        if (this.b == 0) {
            if (this.e % (this.m * 2) == 0 && this.a < 200 - (30 - this.O - 5) * 10 && this.a < 200) {
                this.cR();
            }
            this.e = (byte)(this.e + 1);
            if (this.e >= this.t) {
                this.e = 0;
                this.g = (byte)(this.g + 1);
                if (this.g >= 16) {
                    this.g = 0;
                }
            }
            this.cK();
            this.cJ();
            this.cT();
            if (this.g) {
                if (this.d >= 0) {
                    this.d = (byte)(this.d + 1);
                }
                if (this.d >= 2) {
                    this.d = (byte)-1;
                }
            }
            if (!(!this.f && this.d || this.g)) {
                if (this.d >= 0) {
                    this.d = (byte)(this.d + 1);
                    if (this.d < this.n) {
                        this.W = b.m[this.d];
                        this.X = b.n[this.d];
                        this.aa = (byte)5;
                    } else {
                        this.d = (byte)-1;
                    }
                }
                if (this.f && this.d >= 3) {
                    this.cb();
                    this.cm();
                    this.f = false;
                }
            }
            this.q = 0;
            while (this.q < this.aF) {
                if (this.l[this.q] < this.o) {
                    int n = this.q;
                    this.l[n] = this.l[n] + 1;
                    if (this.l[this.q] == this.o) {
                        this.aG = (byte)(this.aG - 1);
                    }
                }
                ++this.q;
            }
            this.dE();
        }
    }

    final void l() {
        this.aj = (byte)(this.aj + 1);
        if (this.aj >= 3) {
            this.aj = 0;
        }
        if (!this.d) {
            this.a[this.a].drawRegion(this.c[1], 0, 0, b.B[0] - 2, (int)b.B[1], 0, (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W, (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X, 20);
        } else if (this.aW == 1 && this.aV == 26) {
            this.K();
        }
        this.al();
    }

    final void m() {
        if (this.d) {
            this.x = (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W;
            this.y = (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) - this.C / 2 * b.B[1] + this.X;
            if (this.j >= 0) {
                this.y = (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) - this.o[this.aV][this.g[this.aV][0] + 1] / 2 * b.B[1] + this.X;
            }
            if (this.aW == 2) {
                this.x += b.B[0] / 2 - this.aI[this.h[51] + this.C] / 2;
                this.y += b.B[1] / 2 - this.aI[this.h[52] + this.C];
            }
            this.af();
            if (this.aW < 2) {
                this.a[this.a].drawRegion(this.c[7], (int)b.C[1], (int)b.D[1], (int)b.E[1], (int)b.F[1], 0, this.x + this.z / 2 - b.G[1], this.y + b.H[1], 20);
            }
            if (this.aW == 2) {
                this.a[this.a].drawRegion(this.c[7], (int)b.C[2], (int)b.D[2], (int)b.E[2], (int)b.F[2], 0, this.x + this.z / 2 - b.G[2], this.y - b.H[2], 20);
            }
            this.d = (byte)(this.d + 1);
            if (this.d >= this.k) {
                this.d = 0;
                return;
            }
        } else {
            if (this.g) {
                this.q = this.d < 0 ? 0 : (int)this.d;
                this.a[this.a].drawRegion(this.c[7], (int)b.I[this.q], (int)b.J[this.q], (int)b.K[this.q], (int)b.L[this.q], 0, (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W + b.M[this.q], (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X + b.N[this.q], 20);
                return;
            }
            if (this.c[this.a[0]][this.a[1]] > -1 || this.b[this.a[0]][this.a[1]] > 3 && this.b[this.a[0]][this.a[1]] <= 13 || this.b[this.a[0]][this.a[1]] <= -15 && this.b[this.a[0]][this.a[1]] >= -28) {
                this.a[this.a].drawRegion(this.c[7], (int)b.C[0], (int)b.D[0], (int)b.E[0], (int)b.F[0], 0, (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W + b.G[0], (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X + b.H[0], 20);
            }
        }
    }

    final void n() {
        this.aR();
        if (this.e == 1 && this.g == 0 && this.b == 0 && this.K == 1 && this.L == 0) {
            this.q();
        }
        if (this.e == 0) {
            this.t = false;
            if (this.k > 0 && this.w > -1) {
                this.w = (byte)-1;
            }
            if (this.k < -50 && this.w == -1) {
                this.w = 0;
                this.f = 0;
                this.aC = 1;
                this.aB = this.aA = (byte)20;
                this.dH();
                this.t = true;
            }
            if (this.k < 0 && this.w > -1) {
                this.w = (byte)(this.w + 1);
                if (this.w >= 48) {
                    this.a(13);
                }
            }
            this.ad();
            if (this.K == 1 && (this.e[0][0] >= this.e[0][1] && this.e[1][0] >= this.e[1][1] && this.e[2][0] >= this.e[2][1] && this.L != 0 || this.L == 0 && this.D >= 8)) {
                this.a(12);
            }
            if (this.N < 1) {
                if (this.K == 1 && this.L == 0 && this.D < 8) {
                    this.s = true;
                    this.M = this.aI[this.h[142] + this.D];
                    while (this.M < this.aI[this.h[142] + this.D + 1]) {
                        if (this.b[this.M] == 0) {
                            this.s = false;
                            break;
                        }
                        ++this.M;
                    }
                    if (this.s) {
                        this.q();
                    }
                }
            } else {
                this.N = this.N < 8 ? ++this.N : 0;
            }
            if (this.g == 0) {
                ++this.b;
                if (this.e[b.j[3]] > 0) {
                    this.ab();
                    if (!this.t) {
                        this.f = 0;
                        this.aC = 1;
                        this.aB = this.aA = (byte)9;
                        this.dH();
                    }
                }
                this.ac();
                if (this.K == 1 && this.c < this.aI[this.h[161] + this.L] && this.aI[this.h[156 + this.L - 1] + this.c * 3] == this.b) {
                    this.aY = this.aW;
                    this.aX = this.aV;
                    this.aZ = this.at;
                    this.aW = this.aI[this.h[156 + this.L - 1] + this.c * 3 + 1];
                    this.aV = this.aI[this.h[156 + this.L - 1] + this.c * 3 + 2];
                    this.a[this.aW][this.aV] = true;
                    ++this.c;
                    this.a(24);
                }
                if (this.K == 0 && this.b % 12 == 0) {
                    this.a(25);
                    this.V = this.g[0][0] == 0 ? (byte)(this.V + 1) : (byte)0;
                }
            }
        }
        this.dP();
        if (this.f >= 0) {
            if (this.aC != 1 || this.aA != this.aB) {
                this.aC = 1;
                this.aA = this.aB;
                this.dH();
            }
            this.E();
            this.f = (byte)(this.f + 1);
            if (this.f >= this.p) {
                this.f = (byte)-1;
            }
        }
    }

    final void o() {
        if (this.b == 1) {
            this.S();
            return;
        }
        if (this.b == 2) {
            this.ak();
            return;
        }
        if (this.b == 3) {
            this.L();
            return;
        }
        if (this.b == 4) {
            this.T();
            return;
        }
        if (this.b == 5) {
            this.E();
            this.Q();
        }
    }

    final void p() {
        if (this.b != 3 || this.R > 17) {
            this.cF();
            this.ar();
        }
        if (this.b == 0 || this.b == 1) {
            this.cE();
        }
        this.dO();
        this.aq();
        this.flushGraphics(0, 0, this.l, this.m);
    }

    final void a(int n) {
        this.b = (byte)3;
        this.R = (byte)n;
        this.ct();
        this.aa = (byte)5;
        this.i = 0;
    }

    final void q() {
        this.a = 1;
        this.al();
        this.a = 0;
        this.b = (byte)5;
        this.aa = 0;
        this.aC = 1;
        this.aA = (byte)(30 + this.D);
        this.dH();
        this.D = (byte)(this.D + 1);
        if (this.D == 7) {
            this.N = 1;
        }
        this.i = 0;
        this.t = true;
    }

    final void r() {
        this.f[0][0] = this.a[0] - this.m / 2 / b.B[1];
        this.f[0][1] = this.a[1] + this.l / 2 / b.B[0];
        this.f[1][0] = this.f[0][0] + this.l / b.B[0] - 1;
        this.f[1][1] = this.f[0][1] + this.l / b.B[0] - 1;
        this.f[2][0] = this.f[0][0] + this.l / b.B[0] - 1 + this.m / b.B[1] - 1;
        this.f[2][1] = this.f[0][1] + this.l / b.B[0] - this.m / b.B[1];
        this.f[3][0] = this.f[0][0] + this.m / b.B[1] - 1;
        this.f[3][1] = this.f[0][1] + 1 - this.m / b.B[1];
    }

    final void s() {
        this.a[0] = (this.f[0][0] + this.f[1][0] + this.f[2][0] + this.f[3][0]) / 4;
        this.a[1] = (this.f[0][1] + this.f[1][1] + this.f[2][1] + this.f[3][1]) / 4;
    }

    final void t() {
        this.a = null;
        try {
            this.Q = 0;
            while (this.Q < 2) {
                System.gc();
                this.a = this.getClass().getResourceAsStream(this.b[this.Q]);
                if (this.a != null) {
                    this.u();
                    this.v();
                    this.w();
                }
                this.a.close();
                this.a = null;
                System.gc();
                this.a.a.g = 30 + this.Q * 20;
                this.a.a.repaint();
                ++this.Q;
            }
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    final void u() {
        try {
            this.O = 0;
            while (this.O < 24) {
                if (this.Q == 0) {
                    this.am[this.O] = (byte)this.a.read();
                    this.as[this.O] = (byte)this.a.read();
                    this.at[this.O] = (byte)this.a.read();
                    this.an[this.O] = (byte)this.a.read();
                    this.ap[this.O] = (byte)this.a.read();
                    this.ao[this.O] = (byte)this.a.read();
                    this.aq[this.O] = (byte)this.a.read();
                    this.au[this.O] = (byte)this.a.read();
                    this.ar[this.O] = (byte)this.a.read();
                    this.av[this.O] = (byte)this.a.read();
                    this.aw[this.O] = (byte)this.a.read();
                    this.ax[this.O] = (byte)this.a.read();
                    this.ay[this.O] = (byte)this.a.read();
                    this.az[this.O] = (byte)this.a.read();
                    this.aA[this.O] = (byte)this.a.read();
                    this.aB[this.O] = (byte)this.a.read();
                    this.aC[this.O] = (byte)this.a.read();
                    this.R = this.a.read() & 0xFF;
                    this.S = this.a.read() & 0xFF;
                    this.o[this.O] = new byte[this.S * 256 + this.R];
                } else {
                    this.g[this.O][0] = 0;
                    this.P = 0;
                    while (this.P < 42) {
                        this.R = this.a.read() & 0xFF;
                        this.S = this.a.read() & 0xFF;
                        this.T = this.S * 256 + this.R;
                        if (this.P < 41) {
                            this.g[this.O][this.P + 1] = (short)(this.g[this.O][this.P] + this.T);
                        }
                        if (this.T > 0) {
                            this.a.read(this.o[this.O], this.g[this.O][this.P], this.T);
                        }
                        ++this.P;
                    }
                }
                ++this.O;
            }
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    final void v() {
        try {
            this.O = 0;
            while (this.O < 27) {
                if (this.Q == 0) {
                    this.aH[this.O] = (byte)this.a.read();
                    this.aF[this.O] = (byte)this.a.read();
                    this.aG[this.O] = (byte)this.a.read();
                    this.R = this.a.read() & 0xFF;
                    this.S = this.a.read() & 0xFF;
                    this.p[this.O] = new byte[this.S * 256 + this.R];
                } else {
                    this.h[this.O][0] = 0;
                    this.P = 0;
                    while (this.P < 16) {
                        this.R = this.a.read() & 0xFF;
                        this.S = this.a.read() & 0xFF;
                        this.T = this.S * 256 + this.R;
                        if (this.P < 15) {
                            this.h[this.O][this.P + 1] = (short)(this.h[this.O][this.P] + this.T);
                        }
                        if (this.T > 0) {
                            this.a.read(this.p[this.O], this.h[this.O][this.P], this.T);
                        }
                        ++this.P;
                    }
                }
                ++this.O;
            }
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    final void w() {
        try {
            if (this.Q == 0) {
                this.R = this.a.read() & 0xFF;
                this.S = this.a.read() & 0xFF;
                this.aI = new byte[this.S * 256 + this.R];
            } else {
                this.h[0] = 0;
                this.O = 0;
                while (this.O < 177) {
                    this.R = this.a.read() & 0xFF;
                    this.S = this.a.read() & 0xFF;
                    this.T = this.S * 256 + this.R;
                    if (this.O < 176) {
                        this.h[this.O + 1] = (short)(this.h[this.O] + this.T);
                    }
                    if (this.T > 0) {
                        this.a.read(this.aI, this.h[this.O], this.T);
                    }
                    ++this.O;
                }
            }
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    final void x() {
        if (this.b == 0) {
            if (this.aa != 0) {
                this.a[this.a].setColor(0);
                this.a[this.a].fillRect(0, 0, this.l, this.m);
                this.a(0, -(b.B[1] / 2), this.l, this.m);
            }
        } else if (this.b == 2 || this.b == 3) {
            this.y();
            this.z();
        }
        this.aa = 0;
    }

    final void y() {
        this.a[this.a].setColor(d.a[0][0], d.a[0][1], d.a[0][2]);
        this.a[this.a].fillRect(0, 0, this.l, this.m / 2);
        this.q = 0;
        while (this.q < this.m / 4) {
            this.u = d.a[0][0] - (d.a[0][0] - d.a[1][0]) * this.q / (this.m / 4);
            this.v = d.a[0][1] - (d.a[0][1] - d.a[1][1]) * this.q / (this.m / 4);
            this.w = d.a[0][2] - (d.a[0][2] - d.a[1][2]) * this.q / (this.m / 4);
            this.a[this.a].setColor(this.u, this.v, this.w);
            this.a[this.a].drawLine(0, this.m / 2 + this.q, this.l, this.m / 2 + this.q);
            ++this.q;
        }
        this.a[this.a].setColor(d.a[1][0], d.a[1][1], d.a[1][2]);
        this.a[this.a].fillRect(0, this.m * 3 / 4, this.l, this.m / 4);
        this.a[this.a].setColor(14734447);
        this.q = 0;
        while (this.q < 2) {
            this.r = 0;
            while (this.r < 7) {
                if (this.q == 1) {
                    this.a[this.a].fillRect(22 + d.c[0][this.r], (int)d.c[this.r], d.c[1][this.r] - 22 - d.c[0][this.r], this.m - d.c[this.r]);
                }
                this.a[this.a].drawRegion(this.c[4], (int)b.p[this.q], 0, 22, 42, 0, (int)d.c[this.q][this.r], (int)d.c[this.r], 20);
                ++this.r;
            }
            ++this.q;
        }
        this.q = 0;
        while (this.q < 5) {
            this.a[this.a].drawRegion(this.c[8], (int)d.b[this.q], (int)d.c[this.q], (int)d.d[this.q], (int)d.e[this.q], 0, (int)d.d[this.q], (int)d.f[this.q], 20);
            ++this.q;
        }
    }

    final void z() {
        this.w = 0;
        this.Z = 0;
        this.Z = 15;
        this.q = 0;
        while (this.q < 2) {
            this.r = 0;
            while (this.r < 2) {
                this.a[this.a].drawRegion(this.c[5], (int)b.a[this.q][this.r], (int)b.r[this.r], (int)b.q[this.r], (int)b.s[this.r], 0, (int)b.b[this.q][this.r], 0 - this.Z, 20);
                ++this.r;
            }
            ++this.q;
        }
        if ((this.b == 2 || this.b == 3 && ((this.R == 19 || this.R == 21 || this.R == 22) && this.m || this.R == 20 || this.R == 23 || this.R == 24)) && !this.o) {
            this.Y = this.b == 2 ? (this.aW == 2 ? 1 : 0) : (int)((byte)(this.R - 19 + 2));
            this.A();
        }
    }

    final void a(int n, int n2, int n3, int n4) {
        this.U = n2 + this.X;
        while (this.U < n4) {
            this.V = (this.U - this.X) % b.B[1] == 0 ? n + this.W : n - b.B[0] / 2 + this.W;
            while (this.V < n3) {
                this.F();
                this.J();
                this.V += b.B[0];
            }
            this.U += b.B[1] / 2;
        }
    }

    final void A() {
        this.q = 0;
        while (this.q < 4) {
            this.r = 0;
            while (this.r < d.a[d.g[this.Y]][this.q / 2]) {
                this.a[this.a].drawRegion(this.c[6], (int)d.a[d.g[this.Y]][this.q / 2][this.r], (int)d.b[d.g[this.Y]][this.q / 2][this.r], (int)d.c[d.g[this.Y]][this.q / 2][this.r], (int)d.d[d.g[this.Y]][this.q / 2][this.r], 0, d.a[d.g[this.Y]][this.q][this.r] + d.g[this.Y], d.b[d.g[this.Y]][this.q][this.r] + d.h[this.Y], 20);
                ++this.r;
            }
            ++this.q;
        }
    }

    final void B() {
        this.aa = this.b == 2 && this.aW == 2 ? 176 - this.aI[this.h[119] + this.r] / 2 : 196;
        if ((this.b == 2 || this.b == 3 && this.R == 26) && !this.n) {
            this.r = 0;
            while (this.r < 2) {
                this.a[this.a].drawRegion(this.c[3], (int)this.aI[this.h[116] + this.r], (int)this.aI[this.h[117] + this.r], (int)this.aI[this.h[118] + this.r], (int)this.aI[this.h[119] + this.r], 0, d.e[this.r] + this.a[(this.a + this.r * 2) % 4], this.aa, 20);
                ++this.r;
            }
        }
    }

    final void C() {
        if (this.b == 3 && this.w[this.R] >= 0 && this.aI[this.h[93] + this.R] == 0 || this.b == 2) {
            this.s = 0;
            while (this.s < 2) {
                this.t = 0;
                while (this.t < b.u[0]) {
                    this.a[this.a].drawRegion(this.c[8], (int)b.t[this.s], (int)b.b[0][this.t], 50, (int)b.c[0][this.t], 0, (int)d.i[this.s], d.f[2][0] + b.d[0][this.t], 20);
                    ++this.t;
                }
                ++this.s;
            }
        }
    }

    final void D() {
        this.a[this.a].setColor(14734447);
        this.a[this.a].fillRect((int)d.F[0], this.H + d.F[1], (int)d.F[2], (int)d.F[3]);
        this.r = 0;
        while (this.r < 11) {
            this.a[this.a].drawRegion(this.c[8], (int)d.m[this.r], (int)d.n[this.r], (int)d.o[this.r], (int)d.p[this.r], 0, (int)d.D[this.r], this.H + d.E[this.r], 20);
            ++this.r;
        }
        this.q = 0;
        while (this.q < 2) {
            this.r = 0;
            while (this.r < 3) {
                this.a[this.a].drawRegion(this.c[4], (int)b.p[this.q], (int)d.k[this.r], 22, (int)d.l[this.r], 0, (int)d.g[this.q][this.r], this.H + d.C[this.r], 20);
                ++this.r;
            }
            ++this.q;
        }
    }

    final void E() {
        this.D();
        if (this.b != 1 || this.z == 0) {
            this.dQ();
        }
    }

    final void F() {
        this.W = ((this.U - this.X) / (b.B[1] / 2) + (this.V - this.W) / (b.B[0] / 2)) / 2 + this.f[0][0];
        this.X = ((this.V - this.W) / (b.B[0] / 2) - (this.U - this.X) / (b.B[1] / 2)) / 2 + this.f[0][1];
        if (this.W >= 0 && this.X >= 0 && this.W < this.O && this.X < this.O) {
            if (this.b[this.W][this.X] != 0 && this.d && this.ah > 0 && (this.aW == 0 && this.o[this.aV][this.g[this.aV][4] + 3] == 1 || this.aW == 1 && this.aV == 26)) {
                this.u = 0;
                while (this.u < 15) {
                    if (this.k[this.u][0] >= 0 && this.d[this.c[this.k[this.u][0]][this.k[this.u][1]]] && this.W >= this.k[this.u][0] - b.i[0][0] && this.W <= this.k[this.u][0] + b.i[0][1] && this.X >= this.k[this.u][1] - b.i[1][0] && this.X <= this.k[this.u][1] + b.i[1][1]) {
                        this.a[this.a].drawRegion(this.c[1], 0, b.B[1] * 2, b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
                        return;
                    }
                    ++this.u;
                }
            }
            if (this.b[this.W][this.X] == 0) {
                this.a[this.a].drawRegion(this.b[2], (int)b.O[this.c[this.W][this.X] / 4], (int)b.P[this.c[this.W][this.X] / 4], b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
                return;
            }
            if (this.b[this.W][this.X] > 0) {
                this.G();
                return;
            }
            this.H();
            return;
        }
        this.I();
    }

    final void G() {
        if (this.b[this.W][this.X] > 3 && this.b[this.W][this.X] <= 12) {
            this.ak = 0;
            this.aI();
            if (this.b[this.W][this.X] == 7) {
                this.ak = 11;
                this.aI();
            }
            if (this.b[this.W][this.X] == 8) {
                this.ak = 14;
                this.aI();
            }
            if (this.b[this.W][this.X] == 5) {
                this.ak = 13;
                this.aI();
            }
            if (this.b[this.W][this.X] == 6) {
                this.ak = 12;
                this.aI();
                return;
            }
        } else if (this.b[this.W][this.X] <= 3) {
            this.a[this.a].drawRegion(this.c[0], 0, b.B[1] * (this.b[this.W][this.X] - 1), b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
        }
    }

    final void H() {
        if (this.b[this.W][this.X] < 0 && this.b[this.W][this.X] >= -27) {
            if (this.aI[this.h[89] + -1 - this.b[this.W][this.X]] == 0) {
                this.a[this.a].drawRegion(this.b[2], (int)b.O[0], (int)b.P[0], b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
                return;
            }
            this.a[this.a].drawRegion(this.c[0], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
            return;
        }
        this.a[this.a].drawRegion(this.c[0], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
    }

    final void I() {
        if (this.W == this.ab && this.X < 0) {
            this.a[this.a].drawRegion(this.b[2], (int)b.O[0], (int)b.P[0], b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
            this.aw();
        } else {
            this.a[this.a].drawRegion(this.c[0], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
        }
        if (this.W != -1 && this.X != -1 && this.W != this.O && this.X != this.O && (this.W != this.ab || this.X > 0)) {
            this.an = (this.W == this.ab - 1 || this.W == this.ab + 1) && this.X < 0 ? (byte)-11 : (this.X == -2 && this.W >= 0 && this.W < this.O ? (byte)-12 : this.d[(this.W & 0xFFFF) % 10][(this.X & 0xFFFF) % 10]);
            this.aG();
        }
    }

    final void J() {
        this.W = ((this.U - this.X) / (b.B[1] / 2) + (this.V - this.W) / (b.B[0] / 2)) / 2 + this.f[0][0];
        this.X = ((this.V - this.W) / (b.B[0] / 2) - (this.U - this.X) / (b.B[1] / 2)) / 2 + this.f[0][1];
        this.u = 0;
        while (this.u < 4) {
            if ((this.W == this.aI[this.h[39] + this.u * 6 + 0] || this.W == this.O && this.aI[this.h[39] + this.u * 6 + 0] == 30) && (this.X == this.aI[this.h[39] + this.u * 6 + 1] || this.X == this.O && this.aI[this.h[39] + this.u * 6 + 1] == 30)) {
                this.v = 0;
                while (this.v < 2) {
                    this.a[this.a].drawRegion(this.b[2], (int)this.aI[this.h[65] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2]], (int)this.aI[this.h[66] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2]], (int)this.aI[this.h[67] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2]], (int)this.aI[this.h[68] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2]], 0, this.V + this.aI[this.h[69] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2 + 1]], this.U + this.aI[this.h[70] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2 + 1]], 20);
                    ++this.v;
                }
            }
            ++this.u;
        }
        if (this.W == -1 && this.X >= 0 && this.X < this.O) {
            this.ak = 0;
            this.al = 0;
            this.aJ();
        }
        if (this.X == this.O && this.W >= 0 && this.W < this.O) {
            this.ak = 1;
            this.al = 1;
            this.aJ();
        }
        if (this.W == this.O && this.X >= 0 && this.X < this.O) {
            this.ak = 0;
            this.al = 2;
            this.aJ();
        }
        if (this.X == -1 && this.W >= 0 && this.W < this.O && this.W != this.ab) {
            this.ak = 1;
            this.al = 3;
            this.aJ();
        }
    }

    final void K() {
        this.q = -b.i[0][0];
        while (this.q <= b.i[0][1]) {
            if (this.a[0] + this.q >= 0) {
                if (this.a[0] + this.q >= this.O) {
                    return;
                }
                this.r = -b.i[1][0];
                while (this.r <= b.i[1][1]) {
                    if (this.a[1] + this.r >= 0) {
                        if (this.a[1] + this.r >= this.O) break;
                        if (this.b[this.a[0] + this.q][this.a[1] + this.r] != 0) {
                            this.V = (this.a[0] + this.q + this.a[1] + this.r - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W;
                            this.U = (this.a[0] + this.q - this.a[1] - this.r - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X;
                            if (this.V < this.l && this.V + b.B[0] >= 0 && this.U < this.m && this.U + b.B[1] >= 0) {
                                this.a[this.a].drawRegion(this.c[1], 0, b.B[1] * 2, b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
                            }
                        }
                    }
                    ++this.r;
                }
            }
            ++this.q;
        }
    }

    final void L() {
        try {
            this.C();
            this.M();
            this.N();
            this.O();
            this.B();
            if (this.R == 26) {
                switch (this.P) {
                    case 0: 
                    case 1: 
                    case 2: {
                        this.a(this.P, 1, 10);
                        break;
                    }
                    case 5: {
                        this.a(3, 5, 0);
                        break;
                    }
                    case 3: {
                        this.r = 0;
                        while (this.r < b.j[3]) {
                            this.a[this.a].drawRegion(this.a[this.aI[this.h[154] + this.r]], (int)this.aI[this.h[49] + this.r], (int)this.aI[this.h[50] + this.r], (int)this.aI[this.h[51] + this.r], (int)this.aI[this.h[52] + this.r], 0, (int)d.t[this.r], d.u[this.r] - this.aI[this.h[52] + this.r] / 2, 20);
                            ++this.r;
                        }
                        this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[71] + 10], (int)this.aI[this.h[72] + 10], (int)this.aI[this.h[73] + 10], (int)this.aI[this.h[74] + 10], 0, (int)d.t[this.r], d.u[this.r] - this.aI[this.h[74] + 10] / 2, 20);
                        break;
                    }
                    case 4: {
                        this.r = 0;
                        while (this.r < 3) {
                            this.a[this.a].drawRegion(this.d[this.r], (int)this.aI[this.h[98] + this.r], (int)this.aI[this.h[99] + this.r], (int)this.aI[this.h[100] + this.r], (int)this.aI[this.h[101] + this.r], 0, 63 - this.aI[this.h[100] + this.r], d.z[this.r] - this.aI[this.h[101] + this.r] / 2, 20);
                            ++this.r;
                        }
                        break;
                    }
                }
            }
            this.P();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void M() {
        if (this.v[this.R] > 0 && this.R != 26 && !this.o) {
            this.r = 0;
            while (this.r < 2) {
                this.q = this.P;
                if (this.v && this.P > 1) {
                    --this.q;
                }
                if (this.r == 0) {
                    this.v = this.a[this.R][this.P] == 11 ? 55 - this.aI[this.h[118] + 0] : (this.a[this.R][this.P] == 12 && this.m ? 70 - this.aI[this.h[118] + 0] : (this.l - this.d[this.q + this.aI[this.h[94] + this.R]]) / 2 - 12 - this.aI[this.h[118] + 0]);
                    this.v += this.a[this.a % 4];
                    this.u = this.a[this.R][this.P] == 11 || this.a[this.R][this.P] == 10 || this.a[this.R][this.P] == 41 ? 0 : 1;
                }
                if (this.r == 1) {
                    this.v = this.a[this.R][this.P] == 11 ? this.l - 55 : (this.a[this.R][this.P] == 12 && this.m ? this.l - 70 : (this.l + this.d[this.q + this.aI[this.h[94] + this.R]]) / 2 + 12);
                    this.v -= this.a[this.a % 4];
                    this.u = this.a[this.R][this.P] == 11 || this.a[this.R][this.P] == 10 || this.a[this.R][this.P] == 41 ? 1 : 0;
                }
                this.w = this.a[this.R][this.P] == 11 ? d.e[this.R][this.aI[this.h[92] + this.R] - 1] - this.aI[this.h[119] + 0] / 2 : (this.a[this.R][this.P] == 12 ? d.p[this.R] + 2 : d.d[this.R][0] + d.d[this.R][1] * this.P + 2);
                if (this.v) {
                    this.w = this.P < 1 ? (this.w += d.d[this.R][1] / 2) : (this.w -= d.d[this.R][1] / 2);
                }
                this.a[this.a].drawRegion(this.c[3], (int)this.aI[this.h[116] + this.u], (int)this.aI[this.h[117] + this.u], (int)this.aI[this.h[118] + this.u], (int)this.aI[this.h[119] + this.u], 0, this.v, this.w, 20);
                ++this.r;
            }
        }
    }

    final void N() {
        if (!this.o) {
            this.r = 0;
            while (this.r < this.aI[this.h[92] + this.R]) {
                this.l = this.x[this.r];
                this.m = d.e[this.R][this.r];
                this.n = d.h[1];
                this.o = this.y[this.r];
                this.R();
                ++this.r;
            }
        }
        if (this.R != 2 || this.aA != 29) {
            this.r = 0;
            while (!(this.r >= this.aI[this.h[93] + this.R] || this.o && this.r > 0)) {
                this.u = this.aI[this.h[144] + this.aI[this.h[145] + this.R] + this.r];
                this.s = 0;
                while (this.s < 2) {
                    this.t = 0;
                    while (this.t < b.u[this.u]) {
                        this.a[this.a].drawRegion(this.c[8], (int)b.t[this.s], (int)b.b[this.u][this.t], 50, (int)b.c[this.u][this.t], 0, (int)d.i[this.s], d.f[this.R][this.r] + b.d[this.u][this.t], 20);
                        ++this.t;
                    }
                    ++this.s;
                }
                ++this.r;
            }
        }
        if (!this.o && ((this.R == 19 || this.R == 21 || this.R == 22) && this.m || this.R == 20)) {
            this.a[this.a].drawRegion(this.a[this.aI[this.h[154] + this.U]], (int)this.aI[this.h[49] + this.U], (int)this.aI[this.h[50] + this.U], (int)this.aI[this.h[51] + this.U], (int)this.aI[this.h[52] + this.U], 0, (this.l - this.aI[this.h[51] + this.U]) / 2, d.q[this.Y - 2] - this.aI[this.h[52] + this.U] / 2, 20);
        }
    }

    final void O() {
        if (this.R == 23) {
            this.a[this.a].drawRegion(this.a[this.U], (int)this.aI[this.h[1] + this.U * 12 + 0 + 0], (int)this.aI[this.h[19] + this.U * 4 + 0], (int)this.aI[this.h[2] + this.U * 12 + 0 + 0], (int)this.aI[this.h[20] + this.U * 4 + 0], 0, d.x[2] - this.aI[this.h[2] + this.U * 12] / 2, d.y[2] - this.aI[this.h[20] + this.U * 4] / 2, 20);
            this.b(this.j, d.x[2], d.y[2] - this.aI[this.h[20] + this.U * 4] / 2);
            this.r = 0;
            while (this.r < 2) {
                this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[71] + b.aj[this.r]], (int)this.aI[this.h[72] + b.aj[this.r]], (int)this.aI[this.h[73] + b.aj[this.r]], (int)this.aI[this.h[74] + b.aj[this.r]], 0, d.x[this.r] - this.aI[this.h[73] + b.aj[this.r]] - 7, d.y[this.r] - this.aI[this.h[74] + b.aj[this.r]] / 2, 20);
                ++this.r;
            }
        }
        if (this.R == 2 || this.R == 5 || this.o || this.R == 3) {
            this.dQ();
            this.Q();
        }
        if (this.R == 12 || this.R == 13) {
            this.a[this.a].drawRegion(this.c[this.R - 12 + 10], 0, 0, (int)b.c[this.R - 12][0], (int)b.c[this.R - 12][1], 0, (this.l - b.c[this.R - 12][0]) / 2, (this.m - b.c[this.R - 12][1]) / 2, 20);
        }
    }

    final void a(int n, int n2, int n3) {
        this.Y = 8;
        this.A();
        this.a[this.a].drawRegion(this.d[n], (int)this.aI[this.h[98] + n], (int)this.aI[this.h[99] + n], (int)this.aI[this.h[100] + n], (int)this.aI[this.h[101] + n], 0, d.i[0] - this.aI[this.h[100] + n], (int)d.j[0], 20);
        this.r = 0;
        while (this.r < 2) {
            this.a[this.a].drawRegion(this.c[9], (int)this.aI[this.h[13] + 8 + this.r], (int)this.aI[this.h[14] + 8 + this.r], (int)this.aI[this.h[15] + 8 + this.r], (int)this.aI[this.h[16] + 8 + this.r], 0, d.i[1] - this.aI[this.h[15] + 0 + 0] + this.aI[this.h[17] + 8 + this.r], d.j[1] + this.aI[this.h[18] + 8 + this.r], 20);
            ++this.r;
        }
        this.q = n2 - 1;
        while (this.q >= 0) {
            this.r = this.c[n + this.q][d.k[4]] - 1;
            while (this.r > 0) {
                this.s = d.k[1] - this.c[n + this.q][this.r] * d.k[2] / this.d[n][0];
                this.t = d.k[1] - this.c[n + this.q][this.r - 1] * d.k[2] / this.d[n][0];
                if (d.k[3] > Math.abs(this.s - this.t)) {
                    this.a[this.a].setColor(b.a[n3 + this.q * 2 + 1]);
                    this.a[this.a].drawLine(d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - 1 - this.r) + 1, this.s + 1, d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - this.r), this.t + 1);
                    this.a[this.a].drawLine(d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - 1 - this.r) + 1, this.s - 1, d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - this.r), this.t - 1);
                    this.a[this.a].setColor(b.a[n3 + this.q * 2]);
                    this.a[this.a].drawLine(d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - 1 - this.r) + 1, this.s, d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - this.r), this.t);
                } else {
                    this.a[this.a].setColor(b.a[n3 + this.q * 2 + 1]);
                    this.a[this.a].drawLine(d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - 1 - this.r) + 2, this.s, d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - this.r) + 1, this.t);
                    this.a[this.a].drawLine(d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - 1 - this.r), this.s, d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - this.r) - 1, this.t);
                    this.a[this.a].setColor(b.a[n3 + this.q * 2]);
                    this.a[this.a].drawLine(d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - 1 - this.r) + 1, this.s, d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - this.r), this.t);
                }
                --this.r;
            }
            --this.q;
        }
    }

    final void P() {
        if (this.R == 10) {
            if (this.K == 1) {
                this.r = 0;
                while (this.r < 3) {
                    this.a[this.a].drawRegion(this.d[this.r], (int)this.aI[this.h[98] + this.r], (int)this.aI[this.h[99] + this.r], (int)this.aI[this.h[100] + this.r], (int)this.aI[this.h[101] + this.r], 0, this.l / 2 - 7 - this.aI[this.h[100] + this.r], d.d[this.R][0] + (this.r + 1) * d.d[this.R][1] - (this.aI[this.h[101] + this.r] - b.b[0]) / 2, 20);
                    ++this.r;
                }
            } else {
                this.dQ();
                this.Q();
            }
        }
        if (this.R == 20) {
            this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[71] + 10], (int)this.aI[this.h[72] + 10], (int)this.aI[this.h[73] + 10], (int)this.aI[this.h[74] + 10], 0, d.n[0] - this.aI[this.h[73] + 10], d.e[this.R][0] - this.aI[this.h[74] + 10] / 2, 20);
        }
        if (this.R == 25) {
            this.r = 0;
            while (this.r < this.u.length) {
                this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[71] + b.al[this.g[0][this.r]]], (int)this.aI[this.h[72] + b.al[this.g[0][this.r]]], (int)this.aI[this.h[73] + b.al[this.g[0][this.r]]], (int)this.aI[this.h[74] + b.al[this.g[0][this.r]]], 0, (this.l - d.A[0]) / 2 + 10 - this.aI[this.h[73] + b.al[this.g[0][this.r]]], d.d[this.R][0] + d.d[this.R][1] * this.r - (this.aI[this.h[74] + b.al[this.g[0][this.r]]] - b.b[0]) / 2, 20);
                ++this.r;
            }
        }
        if (this.R == 24) {
            this.a.setClip((int)d.f[0], (int)d.f[1], (int)d.f[2], (int)d.f[3]);
            this.af();
            this.a.setClip(0, 0, this.l, this.m);
        }
        this.cD();
        if ((this.R > 17 || this.R == 10 && this.K == 1) && (this.i[this.aI[this.h[171 + this.b] + this.aG]] || this.a / this.m % 2 == 0)) {
            this.a[this.a].drawRegion(this.c[8], 0, 12, 55, 13, 0, (this.l - 55) / 2, this.m - 2 - 13, 20);
        }
    }

    final void Q() {
        if (this.F > 0) {
            this.a[this.a].drawRegion(this.c[8], (int)b.x[0], (int)b.y[0], (int)b.z[0], (int)b.A[0], 0, (int)d.r[this.aC], (int)d.s[this.aC * 2], 20);
        }
        if (this.F + d.j[this.aC] < this.G) {
            this.a[this.a].drawRegion(this.c[8], (int)b.x[1], (int)b.y[1], (int)b.z[1], (int)b.A[1], 0, (int)d.r[this.aC], (int)d.s[this.aC * 2 + 1], 20);
        }
    }

    final void R() {
        try {
            if (this.l == 0 && this.R == 23) {
                this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[71] + 5 - (this.o - 1) / 2], (int)this.aI[this.h[72] + 5 - (this.o - 1) / 2], (int)this.aI[this.h[73] + 5 - (this.o - 1) / 2], (int)this.aI[this.h[74] + 5 - (this.o - 1) / 2], 0, 87 - this.aI[this.h[73] + 5 - (this.o - 1) / 2], this.m - this.aI[this.h[74] + 5 - (this.o - 1) / 2] / 2, 20);
            } else {
                this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[112] + this.l], (int)this.aI[this.h[113] + this.l], (int)this.aI[this.h[114] + this.l], (int)this.aI[this.h[115] + this.l], 0, 87 - this.aI[this.h[114] + this.l], this.m - this.aI[this.h[115] + this.l] / 2, 20);
            }
            this.a[this.a].drawRegion(this.c[6], (int)d.a[0][0][0], (int)d.b[0][0][0], 30, (int)d.d[0][0][0], 0, 90, this.m - d.d[0][0][0] / 2, 20);
            this.a[this.a].drawRegion(this.c[6], d.c[0][0][0] - 30, (int)d.b[0][0][0], 30, (int)d.d[0][0][0], 0, 120, this.m - d.d[0][0][0] / 2 + 1, 20);
            this.s = 0;
            while (this.s < this.o) {
                if (this.l != 2) {
                    this.ab = this.l != 3 && this.l != 4 ? this.o - 1 : 10 - this.o;
                    if (this.l == 0 && this.R != 23) {
                        this.ab = 9;
                    }
                    this.a[this.a].drawRegion(this.c[7], (int)b.v[this.aI[this.h[91] + this.ab]], (int)b.w[this.aI[this.h[91] + this.ab]], 4, 10, 0, d.h[0] + this.n * this.s, this.m - 5, 20);
                } else {
                    this.a[this.a].drawRegion(this.c[7], 63, 11, 8, 8, 0, d.h[0] + this.n * this.s, this.m - 4, 20);
                }
                ++this.s;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void S() {
        this.q = 0;
        while (this.q < this.x) {
            this.r = this.q == 0 && this.z == 0 ? 0 : 1;
            this.a[this.a].drawRegion(this.c[3], (int)b.e[this.r], (int)b.f[this.r], (int)b.g[this.r], (int)b.h[this.r], 0, (int)d.a[this.z][this.q], (int)d.b[this.z][this.q], 20);
            this.r = (this.y + this.q) % this.x;
            this.a[this.a].drawRegion(this.c[3], (int)this.aI[this.h[120] + this.r], (int)this.aI[this.h[121] + this.r], (int)this.aI[this.h[122] + this.r], (int)this.aI[this.h[123] + this.r], 0, d.a[this.z][this.q] + this.aI[this.h[124] + this.r], d.b[this.z][this.q] + this.aI[this.h[125] + this.r], 20);
            ++this.q;
        }
        this.a[this.a].drawRegion(this.c[3], (int)this.aI[this.h[116] + 2], (int)this.aI[this.h[117] + 2], (int)this.aI[this.h[118] + 2], (int)this.aI[this.h[119] + 2], 0, 106, 25 + this.a[this.a % 4], 20);
        this.E();
    }

    final void T() {
        this.q = 0;
        while (this.q < this.O) {
            this.r = 0;
            while (this.r < this.O) {
                if (this.b[this.q][this.r] > 0 && this.b[this.q][this.r] <= 3) {
                    this.s = 0;
                } else if (this.b[this.q][this.r] < 0 && this.b[this.q][this.r] > -15) {
                    this.s = 1;
                } else if (this.b[this.q][this.r] > 3) {
                    this.s = 2;
                } else if (this.b[this.q][this.r] <= -15) {
                    this.s = 3;
                } else if (this.b[this.q][this.r] == 0) {
                    this.s = 4;
                }
                this.a[this.a].drawRegion(this.b[4], b.d[0] + b.d[2] * this.s, (int)b.d[1], (int)b.d[2], (int)b.d[3], 0, this.m[this.aN] + (this.q + this.r) * (b.d[2] / 2 + 1), this.m / 2 + (this.q - this.r - 1) * (b.d[3] / 2), 20);
                ++this.r;
            }
            ++this.q;
        }
        this.a[this.a].setColor(0);
        this.a[this.a].drawLine(this.m[this.aN] - 1, this.m / 2 - 1, this.m[this.aN] + this.O * (b.d[2] / 2 + 1) - 1, this.m / 2 - (this.O + 1) * (b.d[3] / 2) + 1);
        this.a[this.a].drawLine(this.m[this.aN] - 1, this.m / 2, this.m[this.aN] + this.O * (b.d[2] / 2 + 1) - 1, this.m / 2 + this.O * (b.d[3] / 2));
        this.a[this.a].drawLine(this.m[this.aN] + this.O * (b.d[2] + 2) - 2, this.m / 2 - 1, this.m[this.aN] + this.O * (b.d[2] / 2 + 1) - 1, this.m / 2 - (this.O + 1) * (b.d[3] / 2) + 1);
        this.a[this.a].drawLine(this.m[this.aN] + this.O * (b.d[2] + 2) - 2, this.m / 2, this.m[this.aN] + this.O * (b.d[2] / 2 + 1), this.m / 2 + this.O * (b.d[3] / 2) - 1);
    }

    final void U() {
        if (this.aW == 0) {
            this.an = this.o[this.aV][this.g[this.aV][37] + (this.at * this.o[this.aV][this.g[this.aV][0] + 0] + this.W) * this.o[this.aV][this.g[this.aV][0] + 1] + this.X];
        } else if (this.aW == 1) {
            this.an = this.aI[this.h[89] + this.aV];
        } else if (this.aW == 3) {
            this.an = (byte)(this.aV + this.av);
        }
        if (this.aW == 3 && this.an == 13) {
            this.au();
        }
        if (this.aW == 3 && this.an != 13) {
            if ((this.an & 2) != 0) {
                this.ak = 19;
                this.aK();
            } else if ((this.an & 1) != 0) {
                this.ak = 20;
                this.aK();
            } else {
                this.a[this.a].drawRegion(this.b[2], (int)b.O[this.an / 4], (int)b.P[this.an / 4], b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
            }
        } else {
            this.V();
        }
        if (this.aW == 3 && this.an != 2 && this.an != 1) {
            if (this.an != 13) {
                this.au();
            }
            this.av();
        }
    }

    final void V() {
        if (this.an == 0) {
            this.a[this.a].drawRegion(this.b[2], (int)b.O[0], (int)b.P[0], b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
            return;
        }
        if (this.an > 0) {
            if (this.an > 3 && this.an <= 12) {
                this.ak = 0;
                this.aI();
                if (this.an == 7) {
                    this.ak = 11;
                    this.aI();
                }
                if (this.an == 8) {
                    this.ak = 14;
                    this.aI();
                }
                if (this.an == 5) {
                    this.ak = 13;
                    this.aI();
                }
                if (this.an == 6) {
                    this.ak = 12;
                    this.aI();
                    return;
                }
            } else {
                if (this.an <= 3) {
                    this.a[this.a].drawRegion(this.c[0], 0, b.B[1] * (this.an - 1), b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
                    return;
                }
                if (this.an == 13) {
                    this.a[this.a].drawRegion(this.b[5], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
                }
            }
        }
    }

    final void W() {
        this.u = false;
        if (this.b[this.a[0] + this.W][this.a[1] + this.X] >= -13 && this.b[this.a[0] + this.W][this.a[1] + this.X] <= 3) {
            if (this.aW == 0 && this.b[this.a[0] + this.W][this.a[1] + this.X] != 0) {
                if (this.a[0] + this.B <= this.O - 1 && this.at == 1 && (this.o[this.aV][this.g[this.aV][37] + (this.at * this.o[this.aV][this.g[this.aV][0] + 0] + this.W) * this.o[this.aV][this.g[this.aV][0] + 1] + this.X] != 5 && this.o[this.aV][this.g[this.aV][37] + (this.at * this.o[this.aV][this.g[this.aV][0] + 0] + this.W) * this.o[this.aV][this.g[this.aV][0] + 1] + this.X] != 7 || this.b[this.a[0] + this.W + 1][this.a[1] + this.X] != 0 || (this.c[this.a[0] + this.W + 1][this.a[1] + this.X] & 2) == 0)) {
                    this.u = true;
                }
                if (this.a[1] > 0 && this.at == 0 && (this.o[this.aV][this.g[this.aV][37] + (this.at * this.o[this.aV][this.g[this.aV][0] + 0] + this.W) * this.o[this.aV][this.g[this.aV][0] + 1] + this.X] != 6 && this.o[this.aV][this.g[this.aV][37] + (this.at * this.o[this.aV][this.g[this.aV][0] + 0] + this.W) * this.o[this.aV][this.g[this.aV][0] + 1] + this.X] != 8 || this.b[this.a[0] + this.W][this.a[1] + this.X - 1] != 0 || (this.c[this.a[0] + this.W][this.a[1] + this.X - 1] & 1) == 0)) {
                    this.u = true;
                }
                if (this.o[this.aV][this.g[this.aV][37] + (this.at * this.o[this.aV][this.g[this.aV][0] + 0] + this.W) * this.o[this.aV][this.g[this.aV][0] + 1] + this.X] == 13) {
                    this.aO = 1;
                    this.aa();
                }
            } else {
                this.X();
            }
        }
        this.Y();
        if (this.u) {
            this.a[this.a].drawRegion(this.c[1], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
            return;
        }
        this.e = false;
        this.a[this.a].drawRegion(this.c[1], 0, (int)b.B[1], b.B[0] - 2, (int)b.B[1], 0, this.V, this.U, 20);
    }

    final void X() {
        if (this.aW == 1 && this.b[this.a[0] + this.W][this.a[1] + this.X] != 0) {
            this.u = true;
            if (this.aV != 26 && this.aV >= 14) {
                if (this.a[0] < this.O - 1) {
                    if (this.aI[this.h[163] - 1 - this.au] == 1 && this.b[this.a[0] + 1][this.a[1]] == 0 && (this.c[this.a[0] + 1][this.a[1]] & 2) != 0) {
                        this.u = false;
                    }
                } else if (this.aI[this.h[163] - 1 - this.au] == 1 && this.aI[this.h[164] - 1 - this.au] == 0) {
                    this.u = false;
                }
                if (this.a[1] > 0) {
                    if (this.aI[this.h[164] - 1 - this.au] == 1 && this.b[this.a[0]][this.a[1] - 1] == 0 && (this.c[this.a[0]][this.a[1] - 1] & 1) != 0) {
                        this.u = false;
                        return;
                    }
                } else if (this.aI[this.h[164] - 1 - this.au] == 1 && this.aI[this.h[163] - 1 - this.au] == 0) {
                    this.u = false;
                    return;
                }
            } else if (this.au >= -13 && this.b[this.a[0] + this.W][this.a[1] + this.X] < 0) {
                this.u = false;
                return;
            }
        } else if (this.aW == 3) {
            if (this.aV % 4 == 0) {
                this.Z();
                return;
            }
            if (this.aV == 13 && this.b[this.a[0] + this.W][this.a[1] + this.X] != 0) {
                this.aO = (byte)2;
                this.aa();
            }
        }
    }

    final void Y() {
        if (this.aW == 0 && this.aV != 22 && this.o[this.aV][this.g[this.aV][37] + (this.at * this.o[this.aV][this.g[this.aV][0] + 0] + this.W) * this.o[this.aV][this.g[this.aV][0] + 1] + this.X] == 1) {
            this.u = true;
        }
        if (this.aW == 3 && this.b[this.a[0]][this.a[1]] == 0) {
            if (this.aV + this.av == 2 && (this.c[this.a[0]][this.a[1]] & 2) == 0) {
                this.u = true;
                if (this.a[0] > 0) {
                    if (this.b[this.a[0] - 1][this.a[1]] <= -15 && this.b[this.a[0] - 1][this.a[1]] >= -27 && this.aI[this.h[163] - 1 - this.b[this.a[0] - 1][this.a[1]]] == 1) {
                        this.u = false;
                    }
                    if (this.b[this.a[0] - 1][this.a[1]] == 5 || this.b[this.a[0] - 1][this.a[1]] == 7 || this.b[this.a[0] - 1][this.a[1]] == 0) {
                        this.u = false;
                        return;
                    }
                }
            } else if (this.aV + this.av == 1 && (this.c[this.a[0]][this.a[1]] & 1) == 0) {
                this.u = true;
                if (this.a[1] < this.O - 1) {
                    if (this.b[this.a[0]][this.a[1] + 1] <= -15 && this.b[this.a[0]][this.a[1] + 1] >= -27 && this.aI[this.h[164] - 1 - this.b[this.a[0]][this.a[1] + 1]] == 1) {
                        this.u = false;
                    }
                    if (this.b[this.a[0]][this.a[1] + 1] == 6 || this.b[this.a[0]][this.a[1] + 1] == 8 || this.b[this.a[0]][this.a[1] + 1] == 0) {
                        this.u = false;
                    }
                }
            }
        }
    }

    final void Z() {
        if (this.b[this.a[0]][this.a[1]] >= -13 && this.b[this.a[0]][this.a[1]] <= 3) {
            this.u = true;
            if (this.b[this.a[0]][this.a[1]] == 0 && this.aV <= this.c[this.a[0]][this.a[1]]) {
                this.u = false;
            }
            if (this.a[0] < this.O - 1 && this.b[this.a[0] + 1][this.a[1]] == 0 && (this.c[this.a[0] + 1][this.a[1]] & 2) != 0) {
                this.u = false;
            }
            if (this.a[1] > 0 && this.b[this.a[0]][this.a[1] - 1] == 0 && (this.c[this.a[0]][this.a[1] - 1] & 1) != 0) {
                this.u = false;
            }
        }
    }

    final void aa() {
        if (this.b[this.a[0] + this.W][this.a[1] + this.X] >= -13 && this.b[this.a[0] + this.W][this.a[1] + this.X] != 0 && this.b[this.a[0] + this.W][this.a[1] + this.X] <= 3) {
            this.u = true;
            this.aV[0] = (byte)(this.a[0] + this.W);
            this.aV[1] = (byte)(this.a[1] + this.X);
            this.aQ = 0;
            this.aP = 0;
            while (this.aP < 4) {
                if (this.aV[0] + this.aI[this.h[31] + this.aP * 2 + 0] >= this.O || this.aV[1] + this.aI[this.h[31] + this.aP * 2 + 1] >= this.O || this.aV[0] + this.aI[this.h[31] + this.aP * 2 + 0] < 0 || this.aV[1] + this.aI[this.h[31] + this.aP * 2 + 1] < 0) {
                    this.aU[this.aP] = 1;
                } else {
                    this.aU[this.aP] = this.b[this.aV[0] + this.aI[this.h[31] + this.aP * 2 + 0]][this.aV[1] + this.aI[this.h[31] + this.aP * 2 + 1]];
                    if ((this.aU[this.aP] == 7 || this.aU[this.aP] == 5) && this.aP == 1 || (this.aU[this.aP] == 8 || this.aU[this.aP] == 6) && this.aP == 0 || this.aU[this.aP] == 13) {
                        this.aQ = (byte)(this.aQ + 1);
                    }
                }
                this.aP = (byte)(this.aP + 1);
            }
            if (this.aQ > this.aO) {
                this.u = false;
                return;
            }
            this.aR = 0;
            while (this.aR < 4) {
                if (this.aU[this.aR] == 13) {
                    this.aV[0] = (byte)(this.a[0] + this.W + this.aI[this.h[31] + this.aR * 2 + 0]);
                    this.aV[1] = (byte)(this.a[1] + this.X + this.aI[this.h[31] + this.aR * 2 + 1]);
                    this.aQ = 0;
                    this.aP = 0;
                    while (this.aP < 4) {
                        if (this.aV[0] + this.aI[this.h[31] + this.aP * 2 + 0] < this.O && this.aV[1] + this.aI[this.h[31] + this.aP * 2 + 1] < this.O && this.aV[0] + this.aI[this.h[31] + this.aP * 2 + 0] >= 0 && this.aV[1] + this.aI[this.h[31] + this.aP * 2 + 1] >= 0 && ((this.b[this.aV[0] + this.aI[this.h[31] + this.aP * 2 + 0]][this.aV[1] + this.aI[this.h[31] + this.aP * 2 + 1]] == 7 || this.b[this.aV[0] + this.aI[this.h[31] + this.aP * 2 + 0]][this.aV[1] + this.aI[this.h[31] + this.aP * 2 + 1]] == 5) && this.aP == 1 || (this.b[this.aV[0] + this.aI[this.h[31] + this.aP * 2 + 0]][this.aV[1] + this.aI[this.h[31] + this.aP * 2 + 1]] == 8 || this.b[this.aV[0] + this.aI[this.h[31] + this.aP * 2 + 0]][this.aV[1] + this.aI[this.h[31] + this.aP * 2 + 1]] == 6) && this.aP == 0 || this.b[this.aV[0] + this.aI[this.h[31] + this.aP * 2 + 0]][this.aV[1] + this.aI[this.h[31] + this.aP * 2 + 1]] == 13)) {
                            this.aQ = (byte)(this.aQ + 1);
                        }
                        this.aP = (byte)(this.aP + 1);
                    }
                    if (this.aQ > 1) {
                        this.u = false;
                        return;
                    }
                }
                this.aR = (byte)(this.aR + 1);
            }
        }
    }

    final void ab() {
        this.k -= this.e[b.j[3]];
        this.e += this.e[b.j[3]];
        this.ac = 200;
        while (this.ac < 222) {
            if (this.B[this.ac] >= 0) {
                this.aT[0] = this.B[this.ac];
                this.aT[1] = this.C[this.ac];
                this.h = (short)(b.B[0] / 2);
                this.i = 0;
                this.a.delete(0, this.a.length());
                this.a.append("-");
                this.a.append(this.aI[this.h[131] + this.A[this.ac] - 8]);
                this.a = this.a.toString();
                this.dL();
            }
            ++this.ac;
        }
    }

    final void ac() {
        this.ad = 0;
        while (this.ad < 8) {
            this.ae = 0;
            while (this.ae < d.k[4] - 1) {
                this.c[this.ad][d.k[4] - 1 - this.ae] = this.c[this.ad][d.k[4] - 2 - this.ae];
                ++this.ae;
            }
            this.c[this.ad][0] = this.c[this.ad][d.k[4] + 1];
            if (this.c[this.ad][d.k[4]] < d.k[4]) {
                int[] nArray = this.c[this.ad];
                short s = d.k[4];
                nArray[s] = nArray[s] + 1;
            }
            if (this.c[this.ad][0] < 0) {
                this.c[this.ad][0] = 0;
            }
            ++this.ad;
        }
        this.g += this.c[1][0];
        this.c[3][0] = 0;
        this.ad = 0;
        while (this.ad < this.O / 5) {
            this.ae = 0;
            while (this.ae < this.O / 5) {
                int[] nArray = this.c[3];
                nArray[0] = nArray[0] + this.a[this.ad][this.ae];
                ++this.ae;
            }
            ++this.ad;
        }
        int[] nArray = this.c[3];
        nArray[0] = nArray[0] / 10;
        int[] nArray2 = this.c[3];
        nArray2[0] = nArray2[0] + (this.aD[24] + this.ai * 2 + this.ak + this.a);
        int[] nArray3 = this.c[3];
        nArray3[0] = nArray3[0] * this.c[1][0];
        int[] nArray4 = this.c[3];
        nArray4[0] = nArray4[0] / 9;
        this.ad = 4;
        while (this.ad < 8) {
            if (this.b % 3 == 0) {
                this.aW[this.ad - 4] = this.c[this.ad][1] < this.a[this.M * 7 + this.aX[this.ad - 4] * 2 + 1] ? (byte)((this.a.nextInt() & 0xFFFF) % 4) : (this.c[this.ad][1] > this.a[this.M * 7 + this.aX[this.ad - 4] * 2 + 2] ? (byte)((this.a.nextInt() & 0xFFFF) % 4 + 4) : (byte)((this.a.nextInt() & 0xFFFF) % 8));
            }
            if ((this.a.nextInt() & 0xFFFF) % 5 == 0) {
                this.aX[this.ad - 4] = (byte)((this.a.nextInt() & 0xFFFF) % 3);
            }
            this.ae = (this.a.nextInt() & 0xFFFF) % this.a[this.M * 7];
            this.af = this.a[this.M * 7] / 2;
            this.c[this.ad][0] = this.c[this.ad][1] + this.aI[this.h[176] + this.aW[this.ad - 4] * 3 + this.b % 3] + this.ae - this.af;
            if (this.c[this.ad][0] < 0) {
                this.c[this.ad][0] = 0;
            }
            ++this.ad;
        }
    }

    final void ad() {
        this.ad = 0;
        while (this.ad < 3) {
            switch (this.ad) {
                case 0: {
                    this.c[this.ad][d.k[4] + 1] = this.k;
                    break;
                }
                case 1: {
                    if (this.a > 0) {
                        this.c[this.ad][d.k[4] + 1] = 0;
                        this.ae = 0;
                        while (this.ae < 200) {
                            if (this.B[this.ae] >= 0) {
                                int[] nArray = this.c[this.ad];
                                int n = d.k[4] + 1;
                                nArray[n] = nArray[n] + this.P[this.ae];
                            }
                            ++this.ae;
                        }
                        int[] nArray = this.c[this.ad];
                        int n = d.k[4] + 1;
                        nArray[n] = nArray[n] / this.a;
                        int[] nArray2 = this.c[this.ad];
                        int n2 = d.k[4] + 1;
                        nArray2[n2] = nArray2[n2] / 10;
                        break;
                    }
                    this.c[this.ad][d.k[4] + 1] = 0;
                    break;
                }
                case 2: {
                    this.c[this.ad][d.k[4] + 1] = this.a;
                }
            }
            ++this.ad;
        }
        this.ad = 0;
        while (this.ad < 3) {
            this.e[this.ad][0] = this.c[this.ad][d.k[4] + 1];
            ++this.ad;
        }
    }

    final void ae() {
        this.a[this.a].drawRegion(this.b[2], (int)this.aI[this.h[106] + this.d], (int)this.aI[this.h[107] + this.d], (int)this.aI[this.h[108] + this.d], (int)this.aI[this.h[109] + this.d], 0, this.V + this.aI[this.h[110] + this.ak] - this.aI[this.h[108] + this.d] / 2, this.U + this.aI[this.h[111] + this.ak] - this.aI[this.h[109] + this.d] / 2, 20);
    }

    final void af() {
        try {
            if (this.aW != 2) {
                this.aL[0] = 0;
                this.aL[1] = 0;
                this.aM[0] = 1;
                this.aM[1] = 1;
                if (this.aW == 0) {
                    this.ar = this.aV;
                    this.aM[0] = 0;
                    while (this.aM[0] < this.o[this.ar][this.g[this.ar][0] + 0]) {
                        this.aM[1] = 0;
                        while (this.aM[1] < this.o[this.ar][this.g[this.ar][0] + 1] && this.o[this.ar][this.g[this.ar][37] + (this.at * this.o[this.ar][this.g[this.ar][0] + 0] + this.aM[0]) * this.o[this.ar][this.g[this.ar][0] + 1] + this.aM[1]] != 10) {
                            this.aM[1] = (byte)(this.aM[1] + 1);
                        }
                        if (this.aM[1] < this.o[this.ar][this.g[this.ar][0] + 1]) break;
                        this.aM[0] = (byte)(this.aM[0] + 1);
                    }
                }
                this.e = true;
                this.ag();
                this.ah();
            } else {
                this.aj();
                if (this.e && this.b == 0) {
                    this.a[this.a].drawRegion(this.c[7], 52, 32, 7, 7, 0, this.x + b.k[this.d % 3] + this.aI[this.h[51] + this.C], this.y + b.l[this.d % 3], 20);
                }
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void ag() {
        this.U = this.y;
        while (this.U <= this.y + this.A - b.B[1]) {
            this.V = (this.U - this.y) % b.B[1] == 0 ? this.x : this.x + b.B[0] / 2;
            while (this.V <= this.x + this.z - b.B[0]) {
                this.W = ((this.U - this.y) / (b.B[1] / 2) + (this.V - this.x) / (b.B[0] / 2)) / 2 + this.b[0];
                this.X = ((this.V - this.x) / (b.B[0] / 2) - (this.U - this.y) / (b.B[1] / 2)) / 2 + this.b[1];
                if ((this.j != 1 || this.b != 0 || this.W >= b.a[this.at][this.j][0] && this.X >= b.b[this.at][this.j][0]) && this.W >= 0 && this.X >= 0 && this.W < this.B && this.X < this.C) {
                    if (this.f) {
                        if (this.W == 0) {
                            this.ak = 0;
                            this.ae();
                        }
                        if (this.W == this.B - 1) {
                            this.ak = 1;
                            this.ae();
                        }
                        if (this.X == 0) {
                            this.ak = 2;
                            this.ae();
                        }
                        if (this.X == this.C - 1) {
                            this.ak = 3;
                            this.ae();
                        }
                    }
                    if (this.b != 0 || this.f) {
                        this.U();
                    } else {
                        this.W();
                    }
                }
                this.V += b.B[0];
            }
            this.U += b.B[1] / 2;
        }
    }

    final void ah() {
        if (!(this.b == 0 && this.d / this.m % 2 != 0 || this.b != 0 && this.aW == 3)) {
            this.U = this.y;
            while (this.U <= this.y + this.A - b.B[1]) {
                this.V = (this.U - this.y) % b.B[1] == 0 ? this.x : this.x + b.B[0] / 2;
                while (this.V <= this.x + this.z - b.B[0]) {
                    this.W = ((this.U - this.y) / (b.B[1] / 2) + (this.V - this.x) / (b.B[0] / 2)) / 2 + this.b[0];
                    this.X = ((this.V - this.x) / (b.B[0] / 2) - (this.U - this.y) / (b.B[1] / 2)) / 2 + this.b[1];
                    if ((this.j != 1 || this.b != 0 || this.W >= b.a[this.at][this.j][0] && this.X >= b.b[this.at][this.j][0]) && this.W >= 0 && this.X >= 0 && this.W < this.B && this.X < this.C) {
                        if (this.aW < 2) {
                            this.an = this.aW == 0 ? this.o[this.aV][this.g[this.aV][37] + (this.at * this.o[this.aV][this.g[this.aV][0] + 0] + this.W) * this.o[this.aV][this.g[this.aV][0] + 1] + this.X] : (this.b != 0 ? (byte)(-1 - this.aV) : this.au);
                            if (this.an > 3) {
                                this.ai();
                            } else {
                                if (this.aV == 26) {
                                    this.an = b.h[this.W][this.X];
                                }
                                if (this.an < 0 && this.an >= -27) {
                                    this.aq = 0;
                                    this.q = this.b != 0;
                                    this.r = this.b == 0;
                                    this.aH();
                                }
                            }
                        } else {
                            this.U();
                        }
                    }
                    this.V += b.B[0];
                }
                this.U += b.B[1] / 2;
            }
        }
    }

    final void ai() {
        this.as = 0;
        this.am = this.o[this.ar][this.g[this.ar][38] + (this.at * this.o[this.ar][this.g[this.ar][0] + 0] + this.W) * this.o[this.ar][this.g[this.ar][0] + 1] + this.X];
        this.a(true);
        if (this.an == 10) {
            this.aD();
            if (this.o[this.ar][this.g[this.ar][4] + 3] == 1 && this.b != 0) {
                this.q = 0;
                while (this.q < b.am[2]) {
                    this.a[this.a].drawRegion(this.c[3], (int)this.aI[this.h[165] + b.an[2] + this.q], (int)this.aI[this.h[166] + b.an[2] + this.q], (int)this.aI[this.h[167] + b.an[2] + this.q], (int)this.aI[this.h[168] + b.an[2] + this.q], 0, d.a[0][3][0] + b.o[0] + this.aI[this.h[169] + b.an[2] + this.q], d.b[0][0][0] + b.o[1] + this.aI[this.h[170] + b.an[2] + this.q], 20);
                    ++this.q;
                }
            }
        }
        if (this.an == 9 || this.an == 11 || this.an == 12) {
            this.aD();
        }
        this.ao = this.an == 11 ? (byte)1 : 0;
        this.ap = this.an == 12 ? (byte)1 : 0;
        this.b(true);
    }

    final void aj() {
        this.s = this.b == 0 ? this.y : 176 - this.aI[this.h[52] + this.C] / 2;
        this.a[this.a].drawRegion(this.a[this.aV], (int)this.aI[this.h[49] + this.C], (int)this.aI[this.h[50] + this.C], (int)this.aI[this.h[51] + this.C], (int)this.aI[this.h[52] + this.C], 0, this.x, this.s, 20);
        this.e = false;
        switch (this.C) {
            case 0: 
            case 1: {
                if (this.b[this.a[0]][this.a[1]] != 0) break;
                this.e = true;
                return;
            }
            case 2: {
                if (this.b[this.a[0]][this.a[1]] <= 3 || this.Z[this.c[this.a[0]][this.a[1]]] != 23 || this.a[this.c[this.a[0]][this.a[1]]]) break;
                this.e = true;
                return;
            }
            case 3: 
            case 4: 
            case 5: {
                if (this.b[this.a[0]][this.a[1]] >= 0 || this.aI[this.h[56] + -1 - this.b[this.a[0]][this.a[1]]] != this.C || this.d[this.c[this.a[0]][this.a[1]]]) break;
                this.e = true;
            }
        }
    }

    final void ak() {
        if (!this.o) {
            this.ag = 0;
            while (this.ag < this.aI[this.h[132] + this.aW * 2]) {
                this.a[this.a].drawRegion(this.d[this.ag], (int)this.aI[this.h[98] + this.ag], (int)this.aI[this.h[99] + this.ag], (int)this.aI[this.h[100] + this.ag], (int)this.aI[this.h[101] + this.ag], 0, d.n[this.aI[this.h[132] + this.aW * 2 + 1] + this.ag * 2] - this.aI[this.h[100] + this.ag], 105, 20);
                ++this.ag;
            }
            if (this.aW < 2) {
                this.a.setClip((int)d.f[0], (int)d.f[1], (int)d.f[2], (int)d.f[3]);
            }
            this.af();
            if (this.aW < 2) {
                this.a.setClip(0, 0, this.l, this.m);
            }
        } else {
            this.dQ();
        }
        this.B();
        this.C();
        this.cD();
        if (this.i[this.aI[this.h[171 + this.b] + this.aG]] || this.a / this.m % 2 == 0) {
            this.a[this.a].drawRegion(this.c[8], 0, 12, 55, 13, 0, (this.l - 55) / 2, this.m - 2 - 13, 20);
        }
    }

    final void al() {
        this.U = -(b.B[1] / 2) - 1 * b.B[1] + this.X;
        while (this.U < this.m + 4 * b.B[1]) {
            this.V = (this.U - this.X) % b.B[1] == 0 ? -1 * b.B[0] + this.W : -(b.B[0] / 2) - 1 * b.B[0] + this.W;
            while (this.V < this.l + 1 * b.B[0]) {
                this.W = ((this.U - this.X) / (b.B[1] / 2) + (this.V - this.W) / (b.B[0] / 2)) / 2 + this.f[0][0];
                this.X = ((this.V - this.W) / (b.B[0] / 2) - (this.U - this.X) / (b.B[1] / 2)) / 2 + this.f[0][1];
                if (this.W == this.ab - 1 && this.X == -1) {
                    this.as();
                }
                if (this.W == this.ab + 1 && this.X == -1) {
                    this.at();
                }
                if (this.W >= 0 && this.X >= 0 && this.W < this.O && this.X < this.O) {
                    this.an = this.b[this.W][this.X];
                    if (this.an == 0 || this.an > 3) {
                        this.am();
                        this.ap();
                        this.ao();
                    } else {
                        this.an();
                    }
                }
                this.V += b.B[0];
            }
            this.U += b.B[1] / 2;
        }
    }

    final void am() {
        if (this.an != 0 && this.an <= 12) {
            this.ar = this.Z[this.c[this.W][this.X]];
            this.as = this.ab[this.c[this.W][this.X]];
            this.aL[0] = this.l[0][this.c[this.W][this.X]];
            this.aL[1] = this.l[1][this.c[this.W][this.X]];
            this.aM[0] = this.m[0][this.c[this.W][this.X]];
            this.aM[1] = this.m[1][this.c[this.W][this.X]];
            this.ao = 0;
            if (this.an == 11 && (this.ag[this.c[this.W][this.X]] != 1 && this.ag[this.c[this.W][this.X]] != 0 || this.X != this.ae[this.c[this.W][this.X]]) && (this.ag[this.c[this.W][this.X]] != 2 || this.X != this.n[1][this.c[this.W][this.X]])) {
                this.ao = 1;
            }
            this.ap = 0;
            if (this.an == 12 && (this.ag[this.c[this.W][this.X]] != 1 && this.ag[this.c[this.W][this.X]] != 0 || this.W != this.ae[this.c[this.W][this.X]]) && (this.ag[this.c[this.W][this.X]] != 2 || this.W != this.n[0][this.c[this.W][this.X]])) {
                this.ap = 1;
            }
            if (this.ar != 22) {
                this.am = this.o[this.ar][this.g[this.ar][38] + (this.aa[this.c[this.W][this.X]] * this.o[this.ar][this.g[this.ar][0] + 0] + this.W - this.l[0][this.c[this.W][this.X]]) * this.o[this.ar][this.g[this.ar][0] + 1] + this.X - this.l[1][this.c[this.W][this.X]]];
                return;
            }
            if (this.an == 6 || this.an == 8) {
                this.am = (byte)74;
            }
            if (this.an == 5 || this.an == 7) {
                this.am = (byte)-123;
            }
        }
    }

    final void an() {
        if (this.an < 0 && this.an >= -27) {
            if (this.an <= -15) {
                this.aq = this.ak[this.c[this.W][this.X]];
                this.q = this.d[this.c[this.W][this.X]];
                this.r = this.e[this.c[this.W][this.X]];
            }
            this.aH();
            if (this.an <= -15 && this.e / this.m % 2 != 0 && (this.f[this.c[this.W][this.X]] || this.aI[this.h[56] + -1 - this.an] >= 0 && !this.d[this.c[this.W][this.X]])) {
                this.q = this.aI[this.h[163] - 1 - this.an] == 1 ? 1 : 0;
                this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[165] + b.an[this.q] + 0], (int)this.aI[this.h[166] + b.an[this.q] + 0], (int)this.aI[this.h[167] + b.an[this.q] + 0], (int)this.aI[this.h[168] + b.an[this.q] + 0], 0, this.V + this.aI[this.h[169] + b.an[this.q] + 0], this.U + this.aI[this.h[170] + b.an[this.q] + 0], 20);
            }
            if (this.an <= -15 && this.g == 0 && this.e == 0 && this.ak[this.c[this.W][this.X]] >= 0 && this.aI[this.h[56] + -1 - this.an] >= 0 && this.d[this.c[this.W][this.X]]) {
                this.aT[0] = (byte)this.W;
                this.aT[1] = (byte)this.X;
                this.h = (short)(b.B[0] / 2);
                this.i = 0;
                this.a.delete(0, this.a.length());
                this.a.append("-");
                this.a.append(this.aI[this.h[131] + this.aI[this.h[56] + -1 - this.an]]);
                this.a = this.a.toString();
                this.dL();
            }
        }
    }

    final void ao() {
        if (this.an == 9 || this.an == 11 || this.an == 12) {
            this.aD();
        }
        this.aL();
        if (this.U < this.m && this.V + b.B[0] > 0 && this.V < this.l) {
            if (this.an == 0) {
                this.aC();
            } else if (this.an <= 12) {
                this.b(false);
                if ((this.an == 5 || this.an == 6) && this.e / this.m % 2 != 0) {
                    if (!this.a[this.c[this.W][this.X]]) {
                        if (this.an == 5) {
                            this.q = 1;
                        }
                        if (this.an == 6) {
                            this.q = 0;
                        }
                        this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[165] + b.an[this.q] + 0], (int)this.aI[this.h[166] + b.an[this.q] + 0], (int)this.aI[this.h[167] + b.an[this.q] + 0], (int)this.aI[this.h[168] + b.an[this.q] + 0], 0, this.V + this.aI[this.h[169] + b.an[this.q] + 0], this.U + this.aI[this.h[170] + b.an[this.q] + 0], 20);
                    } else if (!this.c[this.c[this.W][this.X]]) {
                        this.r = 0;
                        while (this.r < b.am[3]) {
                            this.a[this.a].drawRegion(this.c[3], (int)this.aI[this.h[165] + b.an[3] + this.r], (int)this.aI[this.h[166] + b.an[3] + this.r], (int)this.aI[this.h[167] + b.an[3] + this.r], (int)this.aI[this.h[168] + b.an[3] + this.r], 0, this.V + this.aI[this.h[169] + b.an[3] + this.r], this.U + this.aI[this.h[170] + b.an[3] + this.r], 20);
                            ++this.r;
                        }
                    }
                }
            }
            this.aB();
        }
    }

    final void ap() {
        if (this.U < this.m && this.V + b.B[0] > 0 && this.V < this.l) {
            if (this.an == 0) {
                this.ax();
            } else if (this.an <= 12) {
                this.a(false);
            }
            this.az();
        }
        if (this.an == 10) {
            this.aD();
            if (!this.b[this.c[this.W][this.X]] && this.e / this.m % 2 == 0) {
                this.q = 0;
                while (this.q < b.am[2]) {
                    this.a[this.a].drawRegion(this.c[3], (int)this.aI[this.h[165] + b.an[2] + this.q], (int)this.aI[this.h[166] + b.an[2] + this.q], (int)this.aI[this.h[167] + b.an[2] + this.q], (int)this.aI[this.h[168] + b.an[2] + this.q], 0, this.V + this.aI[this.h[169] + b.an[2] + this.q], this.U + this.aI[this.h[170] + b.an[2] + this.q], 20);
                    ++this.q;
                }
            }
            if (this.ah[this.c[this.W][this.X]] < 10 && this.e / this.m % 2 == 1) {
                this.q = 0;
                while (this.q < b.am[4]) {
                    this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[165] + b.an[4] + this.q], (int)this.aI[this.h[166] + b.an[4] + this.q], (int)this.aI[this.h[167] + b.an[4] + this.q], (int)this.aI[this.h[168] + b.an[4] + this.q], 0, this.V + this.aI[this.h[169] + b.an[4] + this.q], this.U + this.aI[this.h[170] + b.an[4] + this.q], 20);
                    ++this.q;
                }
            }
        }
    }

    final void aq() {
        if (this.b == 0 && !this.d && !this.g) {
            this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[126] + 0], (int)this.aI[this.h[127] + 0], (int)this.aI[this.h[128] + 0], (int)this.aI[this.h[129] + 0], 0, 0, this.m - this.aI[this.h[129] + 0], 20);
            this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[126] + 1], (int)this.aI[this.h[127] + 1], (int)this.aI[this.h[128] + 1], (int)this.aI[this.h[129] + 1], 0, this.l - this.aI[this.h[128] + 1], this.m - this.aI[this.h[129] + 1], 20);
            return;
        }
        if (this.b == 0 && this.d) {
            if (this.aW != 2 && this.B != 4) {
                this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[126] + 4], (int)this.aI[this.h[127] + 4], (int)this.aI[this.h[128] + 4], (int)this.aI[this.h[129] + 4], 0, 0, this.m - this.aI[this.h[129] + 4], 20);
            }
        } else {
            this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[126] + 2], (int)this.aI[this.h[127] + 2], (int)this.aI[this.h[128] + 2], (int)this.aI[this.h[129] + 2], 0, 0, this.m - this.aI[this.h[129] + 2], 20);
        }
        if ((this.b != 3 || this.aI[this.h[143] + this.R] != 0 && (this.R != 5 || this.aA != 18 && this.aA != 19 && this.aA != 38) || this.R == 0) && this.b != 5 && this.b != 4) {
            this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[126] + 3], (int)this.aI[this.h[127] + 3], (int)this.aI[this.h[128] + 3], (int)this.aI[this.h[129] + 3], 0, this.l - this.aI[this.h[128] + 3], this.m - this.aI[this.h[129] + 3], 20);
        }
    }

    final void ar() {
        this.q = 0;
        while (this.q < 2) {
            this.a[this.a].drawRegion(this.c[9], (int)this.aI[this.h[13] + this.g * 2 + this.q], (int)this.aI[this.h[14] + this.g * 2 + this.q], (int)this.aI[this.h[15] + this.g * 2 + this.q], (int)this.aI[this.h[16] + this.g * 2 + this.q], 0, this.l - this.aI[this.h[15] + 0 + 0] - 2 + this.aI[this.h[17] + this.g * 2 + this.q], 2 + this.aI[this.h[18] + this.g * 2 + this.q], 20);
            ++this.q;
        }
    }

    final void as() {
        this.u = 0;
        while (this.u < b.Q[0]) {
            this.a[this.a].drawRegion(this.b[6], 0, 112, 15, 12, 0, this.V + this.aI[this.h[37] + 0 + this.u], this.U + this.aI[this.h[38] + 0 + this.u], 20);
            ++this.u;
        }
    }

    final void at() {
        this.u = 0;
        while (this.u < b.Q[1]) {
            this.a[this.a].drawRegion(this.b[6], 0, 112, 15, 12, 0, this.V + this.aI[this.h[37] + 3 + this.u], this.U + this.aI[this.h[38] + 3 + this.u], 20);
            ++this.u;
        }
        this.u = 0;
        while (this.u < b.V.length) {
            this.a[this.a].drawRegion(this.b[2], (int)b.R[this.u], (int)b.S[this.u], (int)b.T[this.u], (int)b.U[this.u], 0, this.V + b.V[this.u], this.U + b.W[this.u], 20);
            ++this.u;
        }
    }

    final void au() {
        if (this.an != 13) {
            this.ak = 22;
            this.aK();
            this.ak = 21;
            this.aK();
            return;
        }
        if (this.an == 13) {
            this.ak = 2;
            this.aK();
            this.ak = 1;
            this.aK();
        }
    }

    final void av() {
        if (this.an != 13) {
            this.ak = 23;
            this.aK();
            this.ak = 24;
            this.aK();
            return;
        }
        if (this.an == 13) {
            this.ak = 18;
            this.aK();
            this.ak = 17;
            this.aK();
        }
    }

    final void aw() {
        this.ak = 21;
        this.aK();
        this.ak = 24;
        this.aK();
    }

    final void ax() {
        this.u = this.X == this.O - 1 ? true : this.b[this.W][this.X + 1] != 0 && this.b[this.W][this.X + 1] != 6 && this.b[this.W][this.X + 1] != 8 && this.b[this.W][this.X + 1] != -17 && this.b[this.W][this.X + 1] != -19 && this.b[this.W][this.X + 1] != -22 && this.b[this.W][this.X + 1] != -20 && this.b[this.W][this.X + 1] != -23 && this.b[this.W][this.X + 1] != -24 && this.b[this.W][this.X + 1] != -25 && this.b[this.W][this.X + 1] != -26;
        if (this.u) {
            this.ak = 22;
            this.aK();
        }
        this.u = this.W == 0 ? true : this.b[this.W - 1][this.X] != 0 && this.b[this.W - 1][this.X] != 5 && this.b[this.W - 1][this.X] != 7 && this.b[this.W - 1][this.X] != -15 && this.b[this.W - 1][this.X] != -16 && this.b[this.W - 1][this.X] != -18 && this.b[this.W - 1][this.X] != -21 && this.b[this.W - 1][this.X] != -20 && this.b[this.W - 1][this.X] != -24 && this.b[this.W - 1][this.X] != -25 && this.b[this.W - 1][this.X] != -26;
        if (this.u) {
            this.ak = 21;
            this.aK();
        }
    }

    final void a(boolean bl) {
        if ((this.am & 0x40) != 0) {
            this.ak = 2;
            this.aK();
        }
        if ((this.am & 4) != 0) {
            this.ak = 8;
            this.aK();
        }
        if ((this.am & 0x80) != 0) {
            this.ak = 1;
            this.aK();
        }
        if ((this.am & 8) != 0) {
            this.ak = 7;
            this.aK();
        }
        if ((this.am & 0x4A) == 74) {
            this.ak = 15;
            this.aK();
        }
        if ((this.am & 0x85) == 133) {
            this.ak = 16;
            this.aK();
        }
        this.ay();
    }

    final void ay() {
        if (this.an == 9 && this.ar == 23) {
            this.u = 0;
            while (this.u < 1) {
                this.a[this.a].drawRegion(this.b[this.aI[this.h[88] + 3 + this.u]], (int)this.aI[this.h[80] + 3 + this.u], (int)this.aI[this.h[81] + 3 + this.u], (int)this.aI[this.h[82] + 3 + this.u], (int)this.aI[this.h[83] + 3 + this.u], 0, this.V + this.aI[this.h[84] + 3 + this.u], this.U + this.aI[this.h[85] + 3 + this.u], 20);
                ++this.u;
            }
        }
        if (this.an == 4 && this.ar == 23) {
            this.u = 0;
            while (this.u < 1) {
                this.a[this.a].drawRegion(this.b[this.aI[this.h[88] + 6 + this.u]], (int)this.aI[this.h[80] + 6 + this.u], (int)this.aI[this.h[81] + 6 + this.u], (int)this.aI[this.h[82] + 6 + this.u], (int)this.aI[this.h[83] + 6 + this.u], 0, this.V + this.aI[this.h[84] + 6 + this.u + 3 * (this.W - this.aL[0])], this.U + this.aI[this.h[85] + 6 + this.u + 3 * (this.W - this.aL[0])], 20);
                ++this.u;
            }
            if (this.b == 0) {
                this.u = 0;
                while (this.u < 2) {
                    this.v = this.c[this.W][this.X];
                    if (this.v < 0) {
                        return;
                    }
                    this.c = 0;
                    while (this.v >= 0) {
                        if (this.H[this.v] == this.u && this.W[this.v] == 12) {
                            this.a[this.a].drawRegion(this.a[this.A[this.v]], (int)this.aI[this.h[21] + this.A[this.v] * 2 + 1], (int)this.aI[this.h[42] + this.A[this.v]], (int)this.aI[this.h[43] + this.A[this.v]], (int)this.aI[this.h[44] + this.A[this.v]], 0, this.V + this.aI[this.h[27] + (this.W - this.aL[0]) * 4 + this.u] - this.aI[this.h[43] + this.A[this.v]] / 2, this.U + this.aI[this.h[28] + (this.W - this.aL[0]) * 4 + this.u] - this.aI[this.h[44] + this.A[this.v]], 20);
                            break;
                        }
                        this.v = this.d[this.v];
                        this.c = (short)(this.c + 1);
                    }
                    ++this.u;
                }
            }
        }
    }

    final void az() {
        if (this.an == 13) {
            this.u = false;
            if (this.X == this.O - 1) {
                this.u = true;
            } else if (this.b[this.W][this.X + 1] != 13) {
                this.u = true;
            }
            if (this.u) {
                this.ak = 2;
                this.aK();
            }
            this.aA();
        }
        if (this.an == 0 && this.c[this.W][this.X] > 0) {
            if ((this.c[this.W][this.X] & 2) != 0) {
                this.ak = 19;
                this.aK();
            }
            if ((this.c[this.W][this.X] & 1) != 0) {
                this.ak = 20;
                this.aK();
            }
        }
    }

    final void aA() {
        this.u = false;
        if (this.W == 0) {
            this.u = true;
        } else if (this.b[this.W - 1][this.X] != 13) {
            this.u = true;
        }
        if (this.u) {
            this.ak = 1;
            this.aK();
        }
        this.a[this.a].drawRegion(this.b[5], 0, (b.B[1] - 1) * this.aj, b.B[0] - 2, (int)b.B[1], 0, this.V + 0, this.U + -1, 20);
        if (this.X > 0 && this.c[this.W][this.X] == -1 && this.b[this.W][this.X - 1] == 6) {
            this.a[this.a].drawRegion(this.b[1], 40, 0, 12, 9, 0, this.V + (this.o[22][this.g[22][21] + 33 + this.as[22]] + this.o[22][this.g[22][22] + 33 + this.as[22]]) / b.Y[0] + -6, this.U + b.B[1] / 2 + (this.o[22][this.g[22][21] + 33 + this.as[22]] - this.o[22][this.g[22][22] + 33 + this.as[22]]) / b.Y[1] + -11, 20);
        }
        if (this.W < this.O - 1 && this.c[this.W][this.X] == -1 && this.b[this.W + 1][this.X] == 5) {
            this.a[this.a].drawRegion(this.b[1], 40, 0, 12, 9, 0, this.V + (this.o[22][this.g[22][21] + 22 + this.as[22]] + this.o[22][this.g[22][22] + 22 + this.as[22]]) / b.Y[0] + -6, this.U + b.B[1] / 2 + (this.o[22][this.g[22][21] + 22 + this.as[22]] - this.o[22][this.g[22][22] + 22 + this.as[22]]) / b.Y[1] + -11, 20);
        }
    }

    final void aB() {
        if (this.an == 13) {
            this.u = false;
            if (this.X == 0) {
                this.u = true;
            } else if (this.b[this.W][this.X - 1] != 13) {
                this.u = true;
            }
            if (this.u) {
                this.ak = 18;
                this.aK();
            }
            this.u = false;
            if (this.W == this.O - 1) {
                this.u = true;
            } else if (this.b[this.W + 1][this.X] != 13) {
                this.u = true;
            }
            if (this.u) {
                this.ak = 17;
                this.aK();
            }
        }
    }

    final void aC() {
        if (this.X != 0 || this.W != this.ab) {
            this.u = this.X == 0 ? true : this.b[this.W][this.X - 1] != 0;
            if (this.u) {
                this.ak = 23;
                this.aK();
            }
        }
        this.u = this.W == this.O - 1 ? true : this.b[this.W + 1][this.X] != 0;
        if (this.u) {
            this.ak = 24;
            this.aK();
        }
    }

    final void b(boolean bl) {
        if (this.an == 4 && this.ar == 23) {
            this.u = 0;
            while (this.u < 2) {
                this.a[this.a].drawRegion(this.b[this.aI[this.h[88] + 4 + this.u]], (int)this.aI[this.h[80] + 4 + this.u], (int)this.aI[this.h[81] + 4 + this.u], (int)this.aI[this.h[82] + 4 + this.u], (int)this.aI[this.h[83] + 4 + this.u], 0, this.V + this.aI[this.h[84] + 4 + this.u + 3 * (this.W - this.aL[0])], this.U + this.aI[this.h[85] + 4 + this.u + 3 * (this.W - this.aL[0])], 20);
                ++this.u;
            }
            if (this.b == 0) {
                this.u = 2;
                while (this.u < 4) {
                    this.v = this.c[this.W][this.X];
                    if (this.v < 0) break;
                    this.c = 0;
                    while (this.v >= 0) {
                        if (this.H[this.v] == this.u && this.W[this.v] == 12) {
                            this.a[this.a].drawRegion(this.a[this.A[this.v]], (int)this.aI[this.h[1] + this.A[this.v] * 12 + this.F[this.v] * 3 + this.K[this.J[this.v]]], (int)this.aI[this.h[19] + this.A[this.v] * 4 + this.F[this.v]], (int)this.aI[this.h[2] + this.A[this.v] * 12 + this.F[this.v] * 3 + this.K[this.J[this.v]]], this.aI[this.h[20] + this.A[this.v] * 4 + this.F[this.v]] - 7, 0, this.V + this.aI[this.h[27] + (this.W - this.aL[0]) * 4 + this.u] - this.aI[this.h[2] + this.A[this.v] * 12 + this.F[this.v] * 3 + this.K[this.J[this.v]]] / 2, this.U + this.aI[this.h[28] + (this.W - this.aL[0]) * 4 + this.u] - this.aI[this.h[20] + this.A[this.v] * 4 + this.F[this.v]], 20);
                            break;
                        }
                        this.v = this.d[this.v];
                        this.c = (short)(this.c + 1);
                    }
                    ++this.u;
                }
            }
        }
        if ((this.am & 0x10) != 0) {
            this.ak = 18;
            this.aK();
        }
        this.c(bl);
    }

    final void c(boolean bl) {
        if ((this.am & 1) != 0) {
            this.ak = 10;
            this.aK();
        }
        if ((this.am & 0x20) != 0) {
            this.ak = 17;
            this.aK();
        }
        if ((this.am & 2) != 0) {
            this.ak = 9;
            this.aK();
        }
        if (this.an == 5) {
            this.ak = 3;
            this.aK();
        }
        if (this.an == 6) {
            this.ak = 4;
            this.aK();
        }
        if (this.ao == 1) {
            this.ak = 6;
            this.aK();
        }
        if (this.ap == 1) {
            this.ak = 5;
            this.aK();
        }
    }

    final void aD() {
        this.aE();
        this.aF();
        if (this.W - this.o[this.ar][this.g[this.ar][36] + 0 + 0] == this.aM[0] && this.X - this.o[this.ar][this.g[this.ar][36] + 0 + 1] == this.aM[1]) {
            this.u = 0;
            while (this.u < this.aq[this.ar]) {
                if (!(this.o[this.ar][this.g[this.ar][4] + 2] == 0 && this.u % 2 != 0 || this.U + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 1] >= this.m && this.U + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 3] >= this.m)) {
                    this.a[this.a].setColor(b.b[this.ar][this.u]);
                    this.a[this.a].drawLine(this.V + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2], this.U + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 1], this.V + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 2], this.U + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 3]);
                }
                ++this.u;
            }
        }
        this.w = 0;
        this.u = 0;
        while (this.u < this.ar[this.ar]) {
            if (this.u > 0) {
                this.w += this.o[this.ar][this.g[this.ar][1] + (this.u - 1) * 2 + 1] - this.o[this.ar][this.g[this.ar][1] + (this.u - 1) * 2 + 0] + 1;
            }
            if (this.as % this.at[this.ar] >= this.o[this.ar][this.g[this.ar][1] + this.u * 2 + 0] && this.as % this.at[this.ar] <= this.o[this.ar][this.g[this.ar][1] + this.u * 2 + 1]) {
                this.aY[0] = this.o[this.ar][this.g[this.ar][30] + this.w + this.as % this.at[this.ar] - this.o[this.ar][this.g[this.ar][1] + this.u * 2 + 0]];
                this.aY[1] = this.o[this.ar][this.g[this.ar][31] + this.w + this.as % this.at[this.ar] - this.o[this.ar][this.g[this.ar][1] + this.u * 2 + 0]];
                if (this.U + this.aY[1] < this.m && this.V + this.aY[0] + this.o[this.ar][this.g[this.ar][27] + this.u] > 0 && this.V + this.aY[0] < this.l) {
                    this.u = false;
                    this.v = this.o[this.ar][this.g[this.ar][3] + 3] == 1 ? 0 : this.as % this.at[this.ar];
                    if (this.W == this.aM[0] + this.o[this.ar][this.g[this.ar][36] + this.v * 2 + 0] && this.X == this.aM[1] + this.o[this.ar][this.g[this.ar][36] + this.v * 2 + 1]) {
                        this.u = true;
                    }
                    if (this.u) {
                        this.a[this.a].drawRegion(this.b[this.o[this.ar][this.g[this.ar][29] + this.u]], (int)this.o[this.ar][this.g[this.ar][25] + this.u], (int)this.o[this.ar][this.g[this.ar][26] + this.u], (int)this.o[this.ar][this.g[this.ar][27] + this.u], (int)this.o[this.ar][this.g[this.ar][28] + this.u], 0, this.V + this.aY[0], this.U + this.aY[1], 20);
                    }
                }
            }
            ++this.u;
        }
    }

    final void aE() {
        this.aj = (this.W - this.aL[0]) * (this.o[this.ar][this.g[this.ar][0] + 1] - 1) + this.X - this.aL[1] - 1;
        this.ah = this.o[this.ar][this.g[this.ar][33] + this.aj];
        this.ai = this.o[this.ar][this.g[this.ar][33] + this.aj + 1];
        this.aj = this.ah;
        while (this.aj < this.ai) {
            this.u = this.o[this.ar][this.g[this.ar][32] + this.aj];
            if (this.U + this.o[this.ar][this.g[this.ar][10] + this.u] < this.m && this.V + this.o[this.ar][this.g[this.ar][9] + this.u] + this.o[this.ar][this.g[this.ar][7] + this.u] > 0 && this.V + this.o[this.ar][this.g[this.ar][9] + this.u] < this.l) {
                this.u = this.o[this.ar][this.g[this.ar][4] + 1] == 1 ? true : this.o[this.ar][this.g[this.ar][40] + this.as % this.at[this.ar] * this.an[this.ar] + this.u] == 1;
                if (this.u) {
                    this.v = this.o[this.ar][this.g[this.ar][11] + this.u] == 5 ? (b.B[1] - 1) * this.aj : 0;
                    this.a[this.a].drawRegion(this.b[this.o[this.ar][this.g[this.ar][11] + this.u]], (int)this.o[this.ar][this.g[this.ar][5] + this.u], this.o[this.ar][this.g[this.ar][6] + this.u] + this.v, (int)this.o[this.ar][this.g[this.ar][7] + this.u], (int)this.o[this.ar][this.g[this.ar][8] + this.u], 0, this.V + this.o[this.ar][this.g[this.ar][9] + this.u], this.U + this.o[this.ar][this.g[this.ar][10] + this.u], 20);
                }
            }
            ++this.aj;
        }
        if (this.W - this.o[this.ar][this.g[this.ar][36] + 0 + 0] == this.aM[0] && this.X - this.o[this.ar][this.g[this.ar][36] + 0 + 1] == this.aM[1]) {
            this.u = 0;
            while (this.u < this.ao[this.ar]) {
                if (this.U + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 1] < this.m || this.U + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 3] < this.m) {
                    this.a[this.a].setColor(b.a[this.ar][this.u]);
                    this.a[this.a].drawLine(this.V + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 0], this.U + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 1], this.V + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 2], this.U + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 3]);
                }
                ++this.u;
            }
        }
    }

    final void aF() {
        this.u = 0;
        while (this.u < this.ap[this.ar]) {
            this.aY[0] = this.o[this.ar][this.g[this.ar][2] + 0] == 1 ? this.o[this.ar][this.g[this.ar][17] + this.as % this.at[this.ar] * this.ap[this.ar] + this.u] : this.o[this.ar][this.g[this.ar][17] + 0 * this.ap[this.ar] + this.u];
            this.aY[1] = this.o[this.ar][this.g[this.ar][2] + 1] == 1 ? this.o[this.ar][this.g[this.ar][18] + this.as % this.at[this.ar] * this.ap[this.ar] + this.u] : this.o[this.ar][this.g[this.ar][18] + 0 * this.ap[this.ar] + this.u];
            if (this.U + this.aY[1] < this.m && this.V + this.aY[0] + this.o[this.ar][this.g[this.ar][14] + this.u] > 0 && this.V + this.aY[0] < this.l) {
                this.u = false;
                this.v = this.o[this.ar][this.g[this.ar][3] + 1] == 1 ? 0 : this.as % this.at[this.ar];
                if (this.W == this.aM[0] + this.o[this.ar][this.g[this.ar][34] + this.v * 2 + 0] && this.X == this.aM[1] + this.o[this.ar][this.g[this.ar][34] + this.v * 2 + 1]) {
                    this.u = true;
                }
                if (!this.u) break;
                this.u = this.o[this.ar][this.g[this.ar][4] + 1] == 1 ? true : this.o[this.ar][this.g[this.ar][41] + this.as % this.at[this.ar] * this.ap[this.ar] + this.u] == 1;
                if (this.u) {
                    this.a[this.a].drawRegion(this.b[this.o[this.ar][this.g[this.ar][16] + this.u]], (int)this.o[this.ar][this.g[this.ar][12] + this.u], (int)this.o[this.ar][this.g[this.ar][13] + this.u], (int)this.o[this.ar][this.g[this.ar][14] + this.u], (int)this.o[this.ar][this.g[this.ar][15] + this.u], 0, this.V + this.aY[0], this.U + this.aY[1], 20);
                }
            }
            ++this.u;
        }
    }

    final void aG() {
        this.v = -1 - this.an;
        this.w = this.aH[this.v] > 0 && this.b == 0 ? (this.aq & 0xFF) % this.aH[this.v] : 0;
        this.u = 0;
        while (this.u < this.aF[this.v]) {
            if (this.U + this.p[this.v][this.h[this.v][5] + this.u] < this.m && this.V + this.p[this.v][this.h[this.v][4] + this.u] + this.p[this.v][this.h[this.v][2] + this.u] > 0 && this.V + this.p[this.v][this.h[this.v][4] + this.u] < this.l) {
                this.u = this.an > -15 ? true : (this.aH[this.v] == 0 || !this.q && this.r ? true : this.p[this.v][this.h[this.v][14] + this.w * this.aF[this.v] + this.u] == 1);
                if (this.u) {
                    this.a[this.a].drawRegion(this.b[this.p[this.v][this.h[this.v][6] + this.u]], (int)this.p[this.v][this.h[this.v][0] + this.u], (int)this.p[this.v][this.h[this.v][1] + this.u], (int)this.p[this.v][this.h[this.v][2] + this.u], (int)this.p[this.v][this.h[this.v][3] + this.u], 0, this.V + this.p[this.v][this.h[this.v][4] + this.u], this.U + this.p[this.v][this.h[this.v][5] + this.u], 20);
                }
            }
            ++this.u;
        }
    }

    final void aH() {
        if (this.an < 0 && this.an >= -27) {
            this.aG();
            if (this.an > -15) {
                return;
            }
            if (this.q && !this.r && this.p[this.v][this.h[this.v][2] + this.aF[this.v]] > 0) {
                this.a[this.a].drawRegion(this.b[this.p[this.v][this.h[this.v][6] + this.aF[this.v]]], (int)this.p[this.v][this.h[this.v][0] + this.aF[this.v]], (int)this.p[this.v][this.h[this.v][1] + this.aF[this.v]], (int)this.p[this.v][this.h[this.v][2] + this.aF[this.v]], (int)this.p[this.v][this.h[this.v][3] + this.aF[this.v]], 0, this.V + this.p[this.v][this.h[this.v][4] + this.aF[this.v]], this.U + this.p[this.v][this.h[this.v][5] + this.aF[this.v]], 20);
            } else if (!this.q && this.r && this.p[this.v][this.h[this.v][2] + this.aF[this.v] + 1] > 0) {
                this.a[this.a].drawRegion(this.b[this.p[this.v][this.h[this.v][6] + this.aF[this.v] + 1]], (int)this.p[this.v][this.h[this.v][0] + this.aF[this.v] + 1], (int)this.p[this.v][this.h[this.v][1] + this.aF[this.v] + 1], (int)this.p[this.v][this.h[this.v][2] + this.aF[this.v] + 1], (int)this.p[this.v][this.h[this.v][3] + this.aF[this.v] + 1], 0, this.V + this.p[this.v][this.h[this.v][4] + this.aF[this.v] + 1], this.U + this.p[this.v][this.h[this.v][5] + this.aF[this.v] + 1], 20);
            }
            if (this.q && this.r || this.b != 0 && this.aV == 26) {
                this.u = 0;
                while (this.u < this.aG[this.v]) {
                    if (this.U + this.p[this.v][this.h[this.v][13] + this.w * this.aG[this.v] + this.u] < this.m && this.V + this.p[this.v][this.h[this.v][12] + this.w * this.aG[this.v] + this.u] + this.p[this.v][this.h[this.v][9] + this.u] > 0 && this.V + this.p[this.v][this.h[this.v][12] + this.w * this.aG[this.v] + this.u] < this.l) {
                        this.u = this.p[this.v][this.h[this.v][15] + this.w * this.aG[this.v] + this.u] == 1;
                        if (this.u) {
                            this.a[this.a].drawRegion(this.b[this.p[this.v][this.h[this.v][11] + this.u]], (int)this.p[this.v][this.h[this.v][7] + this.u], (int)this.p[this.v][this.h[this.v][8] + this.u], (int)this.p[this.v][this.h[this.v][9] + this.u], (int)this.p[this.v][this.h[this.v][10] + this.u], 0, this.V + this.p[this.v][this.h[this.v][12] + this.w * this.aG[this.v] + this.u], this.U + this.p[this.v][this.h[this.v][13] + this.w * this.aG[this.v] + this.u], 20);
                        }
                    }
                    ++this.u;
                }
            }
        }
    }

    final void aI() {
        this.a[this.a].drawRegion(this.b[2], (int)this.aI[this.h[59] + this.ak], (int)this.aI[this.h[60] + this.ak], (int)this.aI[this.h[61] + this.ak], (int)this.aI[this.h[62] + this.ak], 0, this.V + this.aI[this.h[63] + this.ak], this.U + this.aI[this.h[64] + this.ak], 20);
    }

    final void aJ() {
        this.a[this.a].drawRegion(this.b[2], (int)this.aI[this.h[65] + this.ak], (int)this.aI[this.h[66] + this.ak], (int)this.aI[this.h[67] + this.ak], (int)this.aI[this.h[68] + this.ak], 0, this.V + this.aI[this.h[69] + this.al], this.U + this.aI[this.h[70] + this.al], 20);
    }

    final void aK() {
        this.am = this.ak == 19 && this.b != 0 ? b.B[0] / 4 : 0;
        this.a[this.a].drawRegion(this.b[2], (int)this.aI[this.h[59] + this.ak], (int)this.aI[this.h[60] + this.ak], (int)this.aI[this.h[61] + this.ak], (int)this.aI[this.h[62] + this.ak], 0, this.V + this.aI[this.h[63] + this.ak] + this.am, this.U + this.aI[this.h[64] + this.ak], 20);
    }

    final void aL() {
        try {
            this.v = this.c[this.W][this.X];
            if (this.v < 0) {
                return;
            }
            if (this.b[this.W][this.X] == 10 && this.ag[this.c[this.W][this.X]] == 4) {
                this.a[this.a].drawRegion(this.a[9], (int)b.af[this.af[this.c[this.W][this.X]] % 2], (int)b.ag[this.af[this.c[this.W][this.X]] % 2], (int)b.ah[this.af[this.c[this.W][this.X]] % 2], (int)b.ai[this.af[this.c[this.W][this.X]] % 2], 0, this.V + this.aB[this.Z[this.c[this.W][this.X]]] - b.ah[this.af[this.c[this.W][this.X]] % 2], this.U + this.aC[this.Z[this.c[this.W][this.X]]] - b.ai[this.af[this.c[this.W][this.X]] % 2], 20);
                return;
            }
            this.aM();
            if (this.c == 0) {
                return;
            }
            this.aN();
            this.u = 0;
            while (this.u < this.c) {
                if (this.W[this.d[0][this.u]] == 15) {
                    this.a[this.a].drawRegion(this.b[2], (int)b.aa[this.J[this.d[0][this.u]] % 2], (int)b.ab[this.J[this.d[0][this.u]] % 2], (int)b.ac[this.J[this.d[0][this.u]] % 2], (int)b.ad[this.J[this.d[0][this.u]] % 2], 0, this.V + b.B[0] / 2 - b.ac[this.J[this.d[0][this.u]] % 2] / 2 + this.h[0][this.d[0][this.u]], this.U + this.d[1][this.u] - b.ad[this.J[this.d[0][this.u]] % 2] + b.ae[this.J[this.d[0][this.u]] % 2], 20);
                } else {
                    this.aO();
                    if (this.V + this.v > -b.B[0] / 2 && this.V + this.v < this.l + b.B[0] / 4) {
                        this.aP();
                        if (this.W[this.d[0][this.u]] == 10) {
                            this.a[this.a].drawRegion(this.b[1], 40, 0, 12, 8, 0, this.V + this.v + -6, this.U + this.d[1][this.u] + -11, 20);
                        }
                        this.a[this.a].drawRegion(this.a[this.A[this.d[0][this.u]]], (int)this.aY[2], (int)this.aY[3], (int)this.aY[4], this.aY[5] - this.aS, 0, this.V + this.v - this.aT, this.U + this.d[1][this.u] - this.aU, 20);
                        this.aQ();
                    }
                }
                ++this.u;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void aM() {
        this.c = 0;
        while (this.v >= 0) {
            if (!(this.W[this.v] > -1 && this.W[this.v] < 7 && this.h[0][this.v] == 1 && this.aI[this.h[this.q[1][0]] + this.W[this.v] * 4] == 2 || this.W[this.v] == 12 || this.W[this.v] == 16 || this.W[this.v] == 13 && this.o[this.Z[this.c[this.W][this.X]]][this.g[this.Z[this.c[this.W][this.X]]][4] + 0] == 0)) {
                this.d[0][this.c] = (short)this.v;
                this.d[1][this.c] = this.W[this.v] == 13 ? (short)this.H[this.v] : (this.W[this.v] == 15 ? (short)(b.B[1] / 2 + this.h[1][this.v]) : (short)(b.B[1] / 2 + (this.G[this.v] - this.H[this.v]) / b.Y[1]));
                if (this.U + this.d[1][this.c] > 0 && this.U + this.d[1][this.c] <= this.m + b.B[1]) {
                    this.c = (short)(this.c + 1);
                }
            }
            this.v = this.d[this.v];
        }
    }

    final void aN() {
        this.u = 0;
        while (this.u < this.c - 1) {
            this.v = this.u + 1;
            while (this.v < this.c) {
                if (this.d[1][this.u] > this.d[1][this.v]) {
                    this.d = this.d[0][this.u];
                    this.d[0][this.u] = this.d[0][this.v];
                    this.d[0][this.v] = this.d;
                    this.d = this.d[1][this.u];
                    this.d[1][this.u] = this.d[1][this.v];
                    this.d[1][this.v] = this.d;
                }
                ++this.v;
            }
            ++this.u;
        }
    }

    final void aO() {
        this.w = this.W[this.d[0][this.u]] == -1 || this.W[this.d[0][this.u]] >= 9 ? this.F[this.d[0][this.u]] : this.X[this.d[0][this.u]];
        this.aS = 0;
        this.aT = 0;
        this.aU = 0;
        if (this.W[this.d[0][this.u]] == 13) {
            this.aY[5] = this.J[this.d[0][this.u]];
            if (this.c[this.d[0][this.u]] % this.at[this.Z[this.c[this.W][this.X]]] >= this.o[this.Z[this.c[this.W][this.X]]][this.g[this.Z[this.c[this.W][this.X]]][39] + 0] && this.c[this.d[0][this.u]] % this.at[this.Z[this.c[this.W][this.X]]] <= this.o[this.Z[this.c[this.W][this.X]]][this.g[this.Z[this.c[this.W][this.X]]][39] + 1]) {
                this.aS = this.ax[this.Z[this.c[this.W][this.X]]];
            }
            if (this.Z[this.c[this.W][this.X]] == 14) {
                this.aU = (byte)(this.aU - this.aI[this.h[20] + this.A[this.d[0][this.u]] * 4 + 0]);
            }
            this.v = this.G[this.d[0][this.u]];
            return;
        }
        if (this.W[this.d[0][this.u]] == 1 && this.h[0][this.d[0][this.u]] == 1) {
            this.w = 4;
            this.aY[5] = this.h[2][this.d[0][this.u]];
        } else {
            this.aY[5] = this.K[this.J[this.d[0][this.u]]];
        }
        if (this.W[this.d[0][this.u]] == 10) {
            this.aS = (byte)7;
        }
        this.v = (this.G[this.d[0][this.u]] + this.H[this.d[0][this.u]]) / b.Y[0];
    }

    final void aP() {
        if (this.w < 4) {
            this.aY[2] = this.aI[this.h[1] + this.A[this.d[0][this.u]] * 12 + this.w * 3 + this.aY[5]];
            this.aY[4] = this.aI[this.h[2] + this.A[this.d[0][this.u]] * 12 + this.w * 3 + this.aY[5]];
            this.aY[3] = this.aI[this.h[19] + this.A[this.d[0][this.u]] * 4 + this.w];
            this.aY[5] = this.aI[this.h[20] + this.A[this.d[0][this.u]] * 4 + this.w];
        } else if (this.w == 4) {
            this.aY[2] = this.aI[this.h[21] + this.A[this.d[0][this.u]] * 2 + this.aY[5]];
            this.aY[4] = this.aI[this.h[43] + this.A[this.d[0][this.u]]];
            this.aY[3] = this.aI[this.h[42] + this.A[this.d[0][this.u]]];
            this.aY[5] = this.aI[this.h[44] + this.A[this.d[0][this.u]]];
        } else if (this.w == 5) {
            if (this.aY[5] == 0) {
                this.aU = this.aI[this.h[25] + this.A[this.d[0][this.u]] * 3 + this.aY[5]];
            }
            this.aY[2] = this.aI[this.h[22] + this.A[this.d[0][this.u]] * 3 + this.aY[5]];
            this.aY[4] = this.aI[this.h[24] + this.A[this.d[0][this.u]] * 3 + this.aY[5]];
            this.aY[3] = this.aI[this.h[23] + this.A[this.d[0][this.u]] * 3 + this.aY[5]];
            this.aY[5] = this.aI[this.h[25] + this.A[this.d[0][this.u]] * 3 + this.aY[5]];
        } else if (this.w == 6) {
            this.aY[2] = this.aI[this.h[45] + this.A[this.d[0][this.u]]];
            this.aY[4] = this.aI[this.h[47] + this.A[this.d[0][this.u]]];
            this.aY[3] = this.aI[this.h[46] + this.A[this.d[0][this.u]]];
            this.aY[5] = this.aI[this.h[48] + this.A[this.d[0][this.u]]];
        } else if (this.w == 7) {
            this.aT = (byte)(this.aT + this.aI[this.h[3] + this.A[this.d[0][this.u]] * 28 + this.aY[5] * 4 + 2] / 2 * this.aI[this.h[26] + this.aY[5] * 2 + 0]);
            this.aU = (byte)(this.aU + this.aI[this.h[3] + this.A[this.d[0][this.u]] * 28 + this.aY[5] * 4 + 3] / 2 * this.aI[this.h[26] + this.aY[5] * 2 + 1]);
            this.aY[2] = this.aI[this.h[3] + this.A[this.d[0][this.u]] * 28 + this.aY[5] * 4 + 0];
            this.aY[4] = this.aI[this.h[3] + this.A[this.d[0][this.u]] * 28 + this.aY[5] * 4 + 2];
            this.aY[3] = this.aI[this.h[3] + this.A[this.d[0][this.u]] * 28 + this.aY[5] * 4 + 1];
            this.aY[5] = this.aI[this.h[3] + this.A[this.d[0][this.u]] * 28 + this.aY[5] * 4 + 3];
        }
        if (this.w != 5 && this.w != 7) {
            this.aT = (byte)(this.aT + this.aY[4] / 2);
            this.aU = (byte)(this.aU + this.aY[5]);
        }
    }

    final void aQ() {
        if (this.W[this.d[0][this.u]] == 13) {
            if (this.Z[this.c[this.W][this.X]] == 0) {
                this.a[this.a].drawRegion(this.b[this.aI[this.h[75] + 0]], (int)this.aI[this.h[75] + 1], (int)this.aI[this.h[75] + 2], (int)this.aI[this.h[75] + 3], (int)this.aI[this.h[75] + 4], 0, this.V + this.v + this.aI[this.h[75] + 5], this.U + this.d[1][this.u] + this.aI[this.h[75] + 6], 20);
            }
            if (this.Z[this.c[this.W][this.X]] == 14 || this.Z[this.c[this.W][this.X]] == 16 && this.c[this.d[0][this.u]] >= this.aI[this.h[76] + 0] && this.c[this.d[0][this.u]] <= this.aI[this.h[76] + 1]) {
                this.a[this.a].drawRegion(this.a[this.A[this.d[0][this.u]]], (int)this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 0], (int)this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 1], (int)this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 2], (int)this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 3], 0, this.V + this.v - this.aT + this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 4], this.U + this.d[1][this.u] - this.aU + this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 5], 20);
                return;
            }
        } else if (this.d[0][this.u] < 200) {
            if (this.M[this.d[0][this.u]] >= 0) {
                this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[71] + this.M[this.d[0][this.u]] + 13], (int)this.aI[this.h[72] + this.M[this.d[0][this.u]] + 13], (int)this.aI[this.h[73] + this.M[this.d[0][this.u]] + 13], (int)this.aI[this.h[74] + this.M[this.d[0][this.u]] + 13], 0, this.V + this.v - this.aI[this.h[73] + this.M[this.d[0][this.u]] + 13] / 2, this.U + this.d[1][this.u] - this.aU - this.aI[this.h[74] + this.M[this.d[0][this.u]] + 13], 20);
            }
            if (this.O[this.d[0][this.u]] >= 0) {
                this.w = this.O[this.d[0][this.u]] % b.e.length;
                this.a[this.a].drawRegion(this.b[2], (int)b.e[this.w][0], (int)b.e[this.w][1], (int)b.e[this.w][2], (int)b.e[this.w][3], 0, this.V + this.v - b.e[this.w][2] / 2 + b.e[this.w][4], this.U + this.d[1][this.u] - this.aU + b.e[this.w][5], 20);
            }
            this.b(this.d[0][this.u], this.V + this.v, this.U + this.d[1][this.u] - this.aU);
        }
    }

    final void b(int n, int n2, int n3) {
        if (this.N[n] >= 0) {
            this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[71] + 0], (int)this.aI[this.h[72] + 0], (int)this.aI[this.h[73] + 0], (int)this.aI[this.h[74] + 0], 0, n2 - this.aI[this.h[73] + 0], n3 - this.aI[this.h[74] + 0], 20);
            this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[71] + this.aI[this.h[96] + this.N[n]]], (int)this.aI[this.h[72] + this.aI[this.h[96] + this.N[n]]], (int)this.aI[this.h[73] + this.aI[this.h[96] + this.N[n]]], (int)this.aI[this.h[74] + this.aI[this.h[96] + this.N[n]]], 0, n2 - this.aI[this.h[73] + 0] + b.ak[0] - this.aI[this.h[73] + this.aI[this.h[96] + this.N[n]]] / 2, n3 - this.aI[this.h[74] + 0] + b.ak[1] - this.aI[this.h[74] + this.aI[this.h[96] + this.N[n]]] / 2, 20);
        }
    }

    final void aR() {
        this.q = 0;
        while (this.q < this.aH) {
            if (this.x[this.q][0] >= 0) {
                this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[71] + this.aS[this.q]], (int)this.aI[this.h[72] + this.aS[this.q]], (int)this.aI[this.h[73] + this.aS[this.q]], (int)this.aI[this.h[74] + this.aS[this.q]], 0, (this.x[this.q][0] + this.x[this.q][1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W + this.aR[this.q], (this.x[this.q][0] - this.x[this.q][1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X + this.aQ[this.q], 20);
            }
            ++this.q;
        }
    }

    final void aS() {
        if (this.f && this.b == 0 || this.i >= 0) {
            this.n = 0;
        }
        if (this.aK > 0 && this.p) {
            this.n = 0;
            this.aK = 0;
        }
        if (this.n == 48) {
            this.aT();
        } else if (this.b == 0) {
            if (this.aK != 1) {
                this.aU();
            }
        } else if (this.b == 1) {
            this.bh();
        } else if (this.b == 2) {
            this.bk();
        } else if (this.b == 3) {
            this.bo();
        } else if (this.b == 4) {
            this.bH();
        } else if (this.b == 5) {
            this.bI();
        }
        if (this.p || this.n == -6 || this.n == -7 || this.n == 48 || this.n == 5 || this.b != 0) {
            this.n = 0;
        }
        if (this.n != 0) {
            ++this.aK;
        }
    }

    final void aT() {
        if ((this.b != 3 || this.R > 17 || this.R == 10 && this.K == 1) && this.b != 4 && this.b != 0 && this.b != 1) {
            this.cC();
            return;
        }
        if (this.b == 0) {
            this.a = 1;
            this.al();
            this.a = 0;
            this.b = (byte)4;
            this.aa = 0;
            this.aN = 1;
            this.m[0] = 2;
            this.m[1] = (this.l - this.O * (b.d[2] + 2)) / 2;
            this.m[2] = this.l - 2 - this.O * (b.d[2] + 2);
            return;
        }
        if (this.b == 4) {
            this.b = 0;
            this.aa = (byte)5;
        }
    }

    final void aU() {
        this.aV();
        switch (this.n) {
            case 1: {
                this.aW();
                return;
            }
            case 2: {
                this.aX();
                return;
            }
            case 4: {
                this.aY();
                return;
            }
            case 3: {
                this.aZ();
                return;
            }
            case 5: {
                if (!this.d && !this.g) {
                    if (this.b[this.a[0]][this.a[1]] >= 4 && this.b[this.a[0]][this.a[1]] <= 13) {
                        this.ba();
                        return;
                    }
                    if (this.b[this.a[0]][this.a[1]] < 0 && this.b[this.a[0]][this.a[1]] >= -28) {
                        this.bb();
                        return;
                    }
                    if (this.c[this.a[0]][this.a[1]] == -1) break;
                    this.bc();
                    return;
                }
                if (this.d) {
                    this.bd();
                    return;
                }
                if (!this.g) break;
                if (this.b[this.a[0]][this.a[1]] > 0 && this.b[this.a[0]][this.a[1]] <= 3) {
                    return;
                }
                this.be();
                return;
            }
            case -6: {
                this.bf();
                return;
            }
            case -7: {
                this.bg();
            }
        }
    }

    final void aV() {
        if (this.aa != 5) {
            this.aa = 0;
        }
        if (this.d) {
            if (this.j >= 0) {
                this.n[0] = b.a[this.at][this.j][0];
                this.n[1] = b.b[this.at][this.j][0];
                this.n[2] = b.a[this.at][this.j][1];
                this.n[3] = b.b[this.at][this.j][1];
                return;
            }
            this.n[0] = 0;
            this.n[1] = 0;
            this.n[2] = this.B;
            this.n[3] = this.C;
        }
    }

    final void aW() {
        this.r = this.a[0] - this.a[1] - this.n[3] - this.f[0][0] + this.f[0][1];
        if (this.d && this.r < 0) {
            this.q = 0;
            while (this.q < 4) {
                int[] nArray = this.f[this.q];
                nArray[0] = nArray[0] + (this.r - 1) / 2;
                int[] nArray2 = this.f[this.q];
                nArray2[1] = nArray2[1] - (this.r - 1) / 2;
                ++this.q;
            }
            this.aa = 1;
            return;
        }
        if (this.a[0] > -this.n[0]) {
            this.a[0] = this.a[0] - 1;
            if (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1] - 2 < 0 || this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1] - 2 < 0 || this.d) {
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[0] = nArray[0] - 1;
                    ++this.q;
                }
                this.aa = 1;
            }
        }
    }

    final void aX() {
        this.r = this.a[0] + this.n[2] - this.a[1] - this.f[3][0] + this.f[3][1] - 2;
        if (this.d && this.r > 0) {
            this.q = 0;
            while (this.q < 4) {
                int[] nArray = this.f[this.q];
                nArray[0] = nArray[0] + (this.r + 1) / 2;
                int[] nArray2 = this.f[this.q];
                nArray2[1] = nArray2[1] - (this.r + 1) / 2;
                ++this.q;
            }
            this.aa = (byte)2;
            return;
        }
        if (this.a[0] < this.O - 1 && !this.d || this.a[0] < this.O - this.n[2] && this.d) {
            this.a[0] = this.a[0] + 1;
            if (this.a[0] + this.a[1] - this.f[1][0] - this.f[1][1] + 1 > 0 || this.a[0] - this.a[1] - this.f[3][0] + this.f[3][1] + 1 > 0 || this.d) {
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[0] = nArray[0] + 1;
                    ++this.q;
                }
                this.aa = (byte)2;
            }
        }
    }

    final void aY() {
        this.r = this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1];
        if (this.d && this.r < 0) {
            this.q = 0;
            while (this.q < 4) {
                int[] nArray = this.f[this.q];
                nArray[0] = nArray[0] + (this.r - 1) / 2;
                int[] nArray2 = this.f[this.q];
                nArray2[1] = nArray2[1] + (this.r - 1) / 2;
                ++this.q;
            }
            this.aa = (byte)4;
            return;
        }
        if (this.a[1] > -this.n[1]) {
            this.a[1] = this.a[1] - 1;
            if (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1] - 2 < 0 || this.a[0] - this.a[1] - this.f[3][0] + this.f[3][1] + 1 > 0 || this.d) {
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[1] = nArray[1] - 1;
                    ++this.q;
                }
                this.aa = (byte)4;
            }
        }
    }

    final void aZ() {
        this.r = this.a[0] + this.n[2] + this.a[1] + this.n[3] - this.f[1][0] - this.f[1][1] - 2;
        if (this.d && this.r > 0) {
            this.q = 0;
            while (this.q < 4) {
                int[] nArray = this.f[this.q];
                nArray[0] = nArray[0] + (this.r + 1) / 2;
                int[] nArray2 = this.f[this.q];
                nArray2[1] = nArray2[1] + (this.r + 1) / 2;
                ++this.q;
            }
            this.aa = (byte)3;
            return;
        }
        if (this.a[1] < this.O - 1 && !this.d || this.a[1] < this.O - this.n[3] && this.d) {
            this.a[1] = this.a[1] + 1;
            if (this.a[0] + this.a[1] - this.f[1][0] - this.f[1][1] + 1 > 0 || this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1] - 2 < 0 || this.d) {
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[1] = nArray[1] + 1;
                    ++this.q;
                }
                this.aa = (byte)3;
            }
        }
    }

    final void ba() {
        this.b = (byte)3;
        if (this.c[this.a[0]][this.a[1]] >= 0) {
            this.ar = this.Z[this.c[this.a[0]][this.a[1]]];
            this.l = this.c[this.c[this.a[0]][this.a[1]]];
            if (this.ar != 23) {
                this.R = (byte)18;
                this.x[0] = 0;
                this.x[1] = 1;
                this.x[2] = 2;
                this.y[0] = (byte)(this.aA[this.ar] / 5);
                if (this.ar == 22) {
                    this.y[0] = (byte)(this.ad[this.c[this.a[0]][this.a[1]]] / 5);
                }
                this.y[1] = (byte)(this.ah[this.c[this.a[0]][this.a[1]]] / 10);
                this.y[2] = this.al[this.ar];
            } else {
                this.R = (byte)21;
                this.an = (byte)28;
                this.m = this.a[this.c[this.a[0]][this.a[1]]];
                this.x[0] = 2;
                this.y[0] = this.aE[this.aI[this.h[57] + this.an]];
                this.U = this.aI[this.h[56] + this.an];
            }
        } else {
            this.ar = (byte)22;
            this.R = (byte)18;
        }
        this.w[this.R] = this.aI[this.h[135] + this.ar];
        this.ct();
        this.aa = (byte)5;
    }

    final void bb() {
        if (this.aI[this.h[57] + -1 - this.b[this.a[0]][this.a[1]]] >= 0) {
            this.b = (byte)3;
            this.R = (byte)19;
            this.an = (byte)(-1 - this.b[this.a[0]][this.a[1]]);
            this.m = this.d[this.c[this.a[0]][this.a[1]]];
            this.x[0] = 0;
            this.x[1] = 2;
            this.y[0] = this.aI[this.h[29] + this.an * (this.ad + 1) + this.ad];
            this.y[1] = this.aE[this.aI[this.h[57] + this.an]];
            this.w[this.R] = this.aI[this.h[136] + this.an];
            this.U = this.aI[this.h[56] + this.an];
            this.ct();
            this.aa = (byte)5;
            return;
        }
        if (this.b[this.a[0]][this.a[1]] <= -27) {
            this.b = (byte)3;
            this.R = (byte)22;
            this.an = (byte)26;
            this.m = this.d[this.c[this.a[0]][this.a[1]]];
            this.w[this.R] = this.aI[this.h[136] + this.an];
            this.U = this.aI[this.h[56] + this.an];
            this.ct();
            this.aa = (byte)5;
        }
    }

    final void bc() {
        this.v = this.c[this.a[0]][this.a[1]];
        while (this.v != -1) {
            if (this.A[this.v] == 8 || this.A[this.v] == 9) {
                this.b = (byte)3;
                this.R = (byte)20;
                this.U = (byte)(this.A[this.v] - 8);
                this.j = this.v;
                this.x[0] = 2;
                this.y[0] = this.aI[this.h[131] + this.U];
                this.w[this.R] = this.aI[this.h[137] + this.U];
                this.ct();
                this.aa = (byte)5;
            }
            this.v = this.d[this.v];
        }
        if (this.b == 0) {
            this.aL = this.v = this.c[this.a[0]][this.a[1]];
            this.e(false);
            this.b = (byte)3;
            this.R = (byte)23;
            this.U = this.A[this.v];
            this.j = this.v;
            this.x[0] = 0;
            this.x[1] = 4;
            this.x[2] = 3;
            this.y[0] = (byte)(this.P[this.v] / 10);
            this.y[1] = (byte)(this.R[this.v] / 10);
            this.y[2] = (byte)(this.Q[this.v] / 10);
            this.ct();
            this.aa = (byte)5;
        }
    }

    final void bd() {
        if (this.e) {
            if (this.k < this.i) {
                this.h = 0;
            }
            if (this.k - -500 >= this.i) {
                if (this.aW == 0) {
                    this.d = 0;
                    this.f = true;
                    this.W = b.m[this.d];
                    this.X = b.n[this.d];
                    return;
                }
                this.cb();
                if (this.aW != 3 && (this.aW != 1 || this.aV >= 14 || this.aV == 13 && this.aW == 1 && this.ag >= 30)) {
                    this.d = (byte)-1;
                    this.d = false;
                }
                if (this.aW == 1 && this.aV < 14) {
                    this.s = (this.a.nextInt() & 0xF) % 4;
                    this.r = 0;
                    while (this.r < this.s) {
                        this.au = (byte)(this.au - this.aI[this.h[162] - 1 - this.au]);
                        ++this.r;
                    }
                }
            }
        }
    }

    final void be() {
        this.d = 0;
        this.bQ();
        if (this.h) {
            if (this.e >= 0) {
                if (this.k - -500 < this.aI[this.h[131] + this.e]) {
                    return;
                }
                this.k -= this.aI[this.h[131] + this.e];
                this.e += this.aI[this.h[131] + this.e];
                this.aT[0] = (byte)this.a[0];
                this.aT[1] = (byte)this.a[1];
                this.h = (short)(b.B[0] / 2);
                this.i = 0;
                this.a.delete(0, this.a.length());
                this.a.append("-");
                this.a.append(this.aI[this.h[131] + this.e]);
                this.a = this.a.toString();
                this.dL();
            }
            this.bW();
            return;
        }
        this.f = 0;
        this.aC = 1;
        this.aB = this.aA;
        this.dH();
    }

    final void bf() {
        if (!this.d && !this.g) {
            this.a = 1;
            this.al();
            this.a = 0;
            this.b = 1;
            this.aa = 0;
            this.z = 0;
            this.A = 0;
            this.aC = 1;
            this.aA = (byte)(23 + this.y);
            this.dH();
            return;
        }
        if (this.d) {
            if (this.aW == 0) {
                this.at = (byte)((this.at + 1) % 2);
                if (this.j >= 0) {
                    this.B = b.a[this.at][this.j][1];
                    this.C = b.b[this.at][this.j][1];
                    if (this.a[0] + b.a[this.at][this.j][0] < 0) {
                        this.aX();
                    }
                    if (this.a[0] + b.a[this.at][this.j][1] > this.O) {
                        this.aW();
                    }
                    if (this.a[1] + b.b[this.at][this.j][0] < 0) {
                        this.aZ();
                    }
                    if (this.a[1] + b.b[this.at][this.j][1] > this.O) {
                        this.aY();
                        return;
                    }
                }
            } else {
                if (this.aW == 1) {
                    this.au = (byte)(this.au - this.aI[this.h[162] - 1 - this.au]);
                    return;
                }
                if (this.aW == 3 && this.aV == 2) {
                    if (this.av == 0) {
                        this.av = (byte)-1;
                        return;
                    }
                    this.av = 0;
                    return;
                }
            }
        } else if (this.g) {
            if (this.b[this.a[0]][this.a[1]] > 0 && this.b[this.a[0]][this.a[1]] <= 3) {
                return;
            }
            this.be();
        }
    }

    final void bg() {
        if (this.d) {
            this.cm();
            this.j = false;
            if (!this.d) {
                this.j = (byte)-1;
                this.d = (byte)-1;
            }
            this.aa = (byte)5;
            return;
        }
        if (this.g) {
            this.d = (byte)-1;
            this.g = false;
            return;
        }
        if (!this.d && !this.g) {
            this.az = 0;
            this.b = (byte)3;
            this.R = 1;
            this.k = false;
            this.ct();
            this.aa = (byte)5;
        }
    }

    final void bh() {
        if (this.z == 0) {
            switch (this.n) {
                case 3: {
                    this.A = (byte)-1;
                    this.z = (byte)3;
                    this.y = (byte)(this.y + 1);
                    if (this.y == this.x) {
                        this.y = 0;
                    }
                    this.aC = 1;
                    this.aA = (byte)(23 + this.y);
                    this.dH();
                    break;
                }
                case 4: {
                    this.A = 1;
                    break;
                }
                case -6: 
                case 5: {
                    this.bi();
                    this.aa = (byte)5;
                    break;
                }
                case -7: {
                    this.b = 0;
                    this.aa = (byte)5;
                }
            }
        }
        this.bj();
    }

    final void bi() {
        if (this.y != 6 && this.y != 3) {
            this.b = (byte)2;
            this.C = 0;
            this.av = 0;
            if (this.y == 1) {
                this.B = 0;
            }
            if (this.y == 2) {
                this.B = 1;
            }
            if (this.y == 5) {
                this.B = (byte)2;
            }
            if (this.y == 4) {
                this.B = (byte)3;
            }
            if (this.y == 0) {
                this.B = (byte)4;
            }
            while (true) {
                this.aV = this.aI[this.h[151 + this.B] + this.C];
                this.aW = this.aI[this.h[146 + this.B] + this.C];
                if (!this.a()) break;
                this.C = (byte)(this.C + 1);
                if (this.C != b.j[this.B]) continue;
                this.C = 0;
            }
            this.co();
            return;
        }
        if (this.y == 6) {
            this.b = 0;
            this.d = (byte)-1;
            this.g = true;
            return;
        }
        if (this.y == 3) {
            this.ad = 0;
            while (this.ad < 8) {
                if (this.ad > 3) {
                    this.af = 3;
                } else {
                    this.af = this.ad;
                    this.d[this.ad][0] = this.d[this.ad][1];
                }
                this.ae = 0;
                while (this.ae < this.c[this.ad][d.k[4]]) {
                    if (this.c[this.ad][this.ae] > this.d[this.af][0]) {
                        this.d[this.af][0] = this.c[this.ad][this.ae];
                    }
                    ++this.ae;
                }
                ++this.ad;
            }
            this.b = (byte)3;
            this.R = (byte)26;
            this.ct();
        }
    }

    final void bj() {
        this.z = (byte)(this.z + this.A);
        if (this.z == 3) {
            if (this.y == 0) {
                this.y = this.x;
            }
            this.y = (byte)(this.y - 1);
            this.aC = 1;
            this.aA = (byte)(23 + this.y);
            this.dH();
            this.z = 0;
            this.A = 0;
        }
        if (this.z == 0 && this.A == -1) {
            this.A = 0;
        }
    }

    final void bk() {
        switch (this.n) {
            case 3: {
                if (this.n) {
                    return;
                }
                do {
                    this.C = (byte)(this.C + 1);
                    if (this.C == b.j[this.B]) {
                        this.C = 0;
                    }
                    this.aV = this.aI[this.h[151 + this.B] + this.C];
                    this.aW = this.aI[this.h[146 + this.B] + this.C];
                } while (this.a());
                this.co();
                return;
            }
            case 4: {
                if (this.n) {
                    return;
                }
                do {
                    this.C = (byte)(this.C - 1);
                    if (this.C < 0) {
                        this.C = (byte)(b.j[this.B] - 1);
                    }
                    this.aV = this.aI[this.h[151 + this.B] + this.C];
                    this.aW = this.aI[this.h[146 + this.B] + this.C];
                } while (this.a());
                this.co();
                return;
            }
            case -6: 
            case 5: {
                if (!this.o) {
                    if (!this.n) {
                        this.bl();
                        return;
                    }
                    if (this.k < this.i) {
                        this.h = 0;
                    }
                    if (this.k - -500 < this.i) break;
                    this.bm();
                }
            }
            case -7: {
                this.bn();
            }
        }
    }

    final boolean a() {
        if (this.aW == 2 && this.K == 1 && (this.C == 2 && !this.a[0][23] || this.C == 5 && !this.a[1][26])) {
            return true;
        }
        if (this.aW > 1 && (this.aW != 3 || this.aV != 13 || this.a[0][22])) {
            return false;
        }
        if (this.aW < 2) {
            if (this.K == 0) {
                return false;
            }
            if (this.a[this.aW][this.aV]) {
                return false;
            }
        }
        return true;
    }

    final void bl() {
        this.d = true;
        this.d = 0;
        this.j = (byte)-1;
        if (this.aW == 1) {
            this.au = (byte)(-1 - this.aV);
        }
        this.cn();
        if (this.aW == 0 && this.aV == 22) {
            this.j = 0;
            this.B = b.a[this.at][this.j][1];
            this.C = b.b[this.at][this.j][1];
        }
        this.az = 0;
        this.b = 0;
        this.aa = (byte)5;
    }

    final void bm() {
        this.k -= this.i;
        this.e += this.i;
        this.m = true;
        this.aT[0] = (byte)this.a[0];
        this.aT[1] = (byte)this.a[1];
        this.h = (short)(b.B[0] / 2);
        this.i = 0;
        this.a.delete(0, this.a.length());
        this.a.append("-");
        this.a.append(this.i);
        this.a = this.a.toString();
        this.dL();
        byte by = this.C;
        this.e[by] = (short)(this.e[by] + 1);
        byte by2 = b.j[3];
        this.e[by2] = (short)(this.e[by2] + this.i);
    }

    final void bn() {
        this.az = 0;
        if (!this.n) {
            this.b = 0;
        } else {
            this.b = (byte)3;
            this.cu();
            this.n = false;
        }
        this.aa = (byte)5;
        this.o = false;
    }

    final void bo() {
        switch (this.n) {
            case 3: {
                this.bp();
                return;
            }
            case 4: {
                this.bq();
                return;
            }
            case 1: {
                this.br();
                return;
            }
            case 2: {
                this.bs();
                return;
            }
            case 5: {
                if (!this.o && this.v[this.R] > 0) {
                    if (this.a[this.R][this.P] == 11) {
                        if (this.y[this.aI[this.h[92] + this.R] - 1] >= 10) break;
                        int n = this.aI[this.h[92] + this.R] - 1;
                        this.y[n] = (byte)(this.y[n] + 1);
                        this.cu();
                        return;
                    }
                    if (this.a[this.R][this.P] == 10) {
                        this.l = !this.l;
                        this.cu();
                        return;
                    }
                    if (this.a[this.R][this.P] == 41) {
                        if (this.aJ >= 5) break;
                        this.aJ = (byte)(this.aJ + 1);
                        this.a.a(this.aJ, this.aJ - 1);
                        this.cu();
                        return;
                    }
                    if (this.a[this.R][this.P] == 12) {
                        this.bt();
                        return;
                    }
                }
            }
            case -6: {
                if (!this.o) {
                    this.bu();
                    return;
                }
            }
            case -7: {
                this.bF();
            }
        }
    }

    final void bp() {
        if (!this.o && this.v[this.R] > 0) {
            if (this.a[this.R][this.P] == 11 && this.y[this.aI[this.h[92] + this.R] - 1] < 10) {
                int n = this.aI[this.h[92] + this.R] - 1;
                this.y[n] = (byte)(this.y[n] + 1);
                this.cu();
                return;
            }
            if (this.a[this.R][this.P] == 10) {
                this.l = !this.l;
                this.cu();
                return;
            }
            if (this.a[this.R][this.P] == 41) {
                if (this.aJ < 5) {
                    this.aJ = (byte)(this.aJ + 1);
                    this.a.a(this.aJ, this.aJ - 1);
                    this.cu();
                    return;
                }
            } else if (this.R == 26) {
                this.P = (byte)(this.P + 1);
                if (this.P == 4 && this.K == 0) {
                    this.P = (byte)(this.P + 1);
                }
                if (this.P >= this.v[this.R] || this.K == 1 && this.P >= this.v[this.R] - 1) {
                    this.P = 0;
                }
                this.cu();
            }
        }
    }

    final void bq() {
        if (!this.o && this.v[this.R] > 0) {
            if (this.a[this.R][this.P] == 11 && this.y[this.aI[this.h[92] + this.R] - 1] > 1) {
                int n = this.aI[this.h[92] + this.R] - 1;
                this.y[n] = (byte)(this.y[n] - 1);
                this.cu();
                return;
            }
            if (this.a[this.R][this.P] == 10) {
                this.l = !this.l;
                this.cu();
                return;
            }
            if (this.a[this.R][this.P] == 41) {
                if (this.aJ > 0) {
                    this.aJ = (byte)(this.aJ - 1);
                    this.a.a(this.aJ, this.aJ + 1);
                    this.cu();
                    return;
                }
            } else if (this.R == 26) {
                this.P = (byte)(this.P - 1);
                if (this.P == 4 && this.K == 0) {
                    this.P = (byte)(this.P - 1);
                }
                if (this.P < 0) {
                    this.P = this.K == 1 ? (byte)(this.v[this.R] - 2) : (byte)(this.v[this.R] - 1);
                }
                this.cu();
            }
        }
    }

    final void br() {
        if (!this.o) {
            if (this.R == 2 || this.R == 5 || this.R == 3 || this.R == 10 && this.K == 0) {
                if (this.F > 0) {
                    this.F -= d.j[this.aC];
                }
                if (this.F < 0) {
                    this.F = 0;
                    return;
                }
            } else if (this.R != 26 && this.v[this.R] > 0) {
                if (this.R == 21) {
                    this.P = (byte)(this.P + 1);
                    if (this.P >= this.v[this.R]) {
                        this.P = 0;
                        return;
                    }
                } else {
                    this.P = (byte)(this.P - 1);
                    if (this.P < 0) {
                        this.P = (byte)(this.v[this.R] - 1);
                    }
                    if (this.v && this.a[this.R][this.P] == 4) {
                        this.P = (byte)(this.P - 1);
                    }
                }
            }
        }
    }

    final void bs() {
        if (!this.o) {
            if (this.R == 2 || this.R == 5 || this.R == 3 || this.R == 10 && this.K == 0) {
                if (this.G > this.F + d.j[this.aC]) {
                    this.F += d.j[this.aC];
                    return;
                }
            } else if (this.R != 26 && this.v[this.R] > 0) {
                if (this.R != 21) {
                    this.P = (byte)(this.P + 1);
                    if (this.P >= this.v[this.R]) {
                        this.P = 0;
                    }
                    if (this.v && this.a[this.R][this.P] == 4) {
                        this.P = (byte)(this.P + 1);
                        return;
                    }
                } else {
                    this.P = (byte)(this.P - 1);
                    if (this.P < 0) {
                        this.P = (byte)(this.v[this.R] - 1);
                    }
                }
            }
        }
    }

    final void bt() {
        this.i = this.aI[this.h[131] + this.aI[this.h[56] + this.an]];
        if (this.m) {
            this.az = 0;
            this.R = (byte)20;
            this.x[0] = 2;
            this.y[0] = (byte)this.i;
            this.w[this.R] = this.aI[this.h[137] + this.aI[this.h[56] + this.an]];
            this.ct();
            this.aa = (byte)5;
            return;
        }
        this.b = (byte)2;
        this.aa = (byte)5;
        this.C = this.U;
        this.B = (byte)3;
        this.aV = this.aI[this.h[151 + this.B] + this.C];
        this.aW = this.aI[this.h[146 + this.B] + this.C];
        this.n = true;
        this.co();
    }

    final void bu() {
        if (this.R == 5) {
            this.bv();
            return;
        }
        if (this.R == 23 || this.R == 26 || this.R == 25 && (this.N == 0 || this.V < 3)) {
            this.az = 0;
            this.b = 0;
            this.aa = (byte)5;
            return;
        }
        if (this.R == 4) {
            this.P = this.Q;
            this.R = this.S;
            this.cu();
            return;
        }
        if (this.R == 3) {
            this.R = 0;
            this.cu();
            return;
        }
        if (this.R == 2) {
            this.b = this.c;
            this.R = this.S;
            if (this.b == 3) {
                this.cu();
            }
            if (this.b == 2) {
                this.co();
            }
            this.aa = (byte)5;
            return;
        }
        if (this.R == 7) {
            this.N = this.P;
            this.R = (byte)17;
            this.ct();
            return;
        }
        if (this.R == 25 && this.N == 1 && this.V >= 3) {
            this.a(12);
            return;
        }
        if (this.R == 12) {
            if (this.b > 0) {
                this.g /= this.b;
            }
            this.R = (byte)11;
            this.ct();
            return;
        }
        if (this.R == 13) {
            this.R = (byte)14;
            this.ct();
            return;
        }
        if (this.R == 14) {
            this.R = (byte)10;
            this.ct();
            return;
        }
        if (this.R == 15) {
            if (this.aJ == 0) {
                this.aJ = (byte)2;
            }
            this.a.a(this.aJ, 0);
            this.R = 0;
            this.ct();
            return;
        }
        if (this.R == 16) {
            this.f();
            return;
        }
        if (this.R == 11) {
            this.bw();
            return;
        }
        if (this.R == 10 || this.R == 24) {
            this.az = 0;
            if (this.R == 10) {
                this.g();
            }
            if (this.R == 24 && this.d) {
                this.aW = this.aY;
                this.aV = this.aX;
                this.cs();
                this.at = this.aZ;
                if (this.aW == 0 && this.aV == 22) {
                    this.B = b.a[this.at][this.j][1];
                    this.C = b.b[this.at][this.j][1];
                }
            }
            this.aa = (byte)5;
            this.b = 0;
            return;
        }
        if (this.a[this.R][this.P] == 5) {
            this.bx();
            return;
        }
        if (this.a[this.R][this.P] == 40) {
            this.S = this.R;
            this.R = (byte)5;
            this.aA = (byte)22;
            this.cu();
            return;
        }
        if (this.a[this.R][this.P] == 0 || this.a[this.R][this.P] == 1) {
            this.bB();
            return;
        }
        if (this.a[this.R][this.P] == 2) {
            this.S = this.R;
            this.Q = this.P;
            this.R = (byte)4;
            this.ct();
            return;
        }
        if (this.a[this.R][this.P] == 21) {
            if (this.R == 1) {
                this.az = 0;
                this.b = 0;
            } else {
                this.dZ();
            }
            this.aa = (byte)5;
            return;
        }
        if (this.a[this.R][this.P] == 22) {
            this.bA();
            return;
        }
        if (this.a[this.R][this.P] == 3) {
            this.cC();
            return;
        }
        if (this.a[this.R][this.P] == 95) {
            this.R = (byte)3;
            this.cu();
            return;
        }
        if (this.a[this.R][this.P] == 107) {
            try {
                this.a.platformRequest(this.a.getAppProperty("Wap-Link"));
                return;
            }
            catch (Exception exception) {
                return;
            }
        }
        if (this.a[this.R][this.P] == 6) {
            this.T = this.R;
            this.S = this.R;
            this.R = (byte)5;
            this.aA = (byte)16;
            this.cu();
            return;
        }
        if (this.a[this.R][this.P] == 4) {
            this.S = this.R;
            this.R = (byte)5;
            this.aA = (byte)15;
            this.cu();
            return;
        }
        if (this.R == 17) {
            this.by();
            return;
        }
        if (this.R == 8) {
            this.bz();
            return;
        }
        if (this.R == 18 || this.R == 19 || this.R == 21 || this.R == 22) {
            this.bC();
            return;
        }
        if (this.R == 20 || this.a[this.R][this.P] == 13) {
            this.bE();
        }
    }

    final void bv() {
        if (this.aA == 15) {
            this.dZ();
            this.aa = (byte)5;
            return;
        }
        if (this.aA == 16) {
            this.dR();
            this.aA = this.x ? (byte)19 : (byte)18;
            this.k = true;
            this.cu();
            return;
        }
        if (this.aA == 22) {
            this.d();
            return;
        }
        if (this.aA == 14) {
            this.F = (byte)-1;
            this.H = (byte)-1;
        }
        this.R = this.T;
        this.ct();
    }

    final void bw() {
        if (this.K == 0) {
            this.R = 0;
        } else if (this.L + 1 >= this.a[8].length) {
            this.cC();
        } else {
            this.F = this.L = (byte)(this.L + 1);
            this.G = this.M;
            if (this.E <= this.L) {
                this.E = (byte)(this.L + 1);
            }
            this.dS();
            this.R = (byte)10;
            this.w[10] = this.n[this.L];
        }
        this.ct();
    }

    final void bx() {
        if (this.R == 1) {
            if (this.k) {
                this.R = 0;
                this.ct();
                return;
            }
            this.T = 0;
            this.S = this.R;
            this.R = (byte)5;
            this.aA = (byte)17;
            this.cu();
        }
    }

    final void by() {
        this.M = (byte)(this.a[this.R][this.P] - 8);
        if (this.K == 0) {
            this.R = (byte)10;
            this.w[10] = this.a[7][this.N];
            this.ct();
            return;
        }
        this.R = (byte)8;
        this.v[8] = this.E;
        this.ct();
        this.P = (byte)(this.v[8] - 1);
    }

    final void bz() {
        this.L = this.P;
        this.F = this.P;
        this.G = this.M;
        this.dS();
        if (this.L == 0) {
            this.az = 0;
            this.g();
            this.aa = (byte)5;
            this.b = 0;
            return;
        }
        this.R = (byte)10;
        this.w[10] = this.n[this.L];
        this.ct();
    }

    final void bA() {
        if (this.K == 1) {
            this.T = (byte)17;
            this.S = this.R;
            this.R = (byte)5;
            this.aA = (byte)14;
            this.cu();
            return;
        }
        this.R = (byte)7;
        this.ct();
    }

    final void bB() {
        this.K = this.a[this.R][this.P];
        this.L = 0;
        this.R = this.K == 0 && this.J != -1 || this.K == 1 && this.F != -1 ? (byte)6 : (this.K == 1 ? (byte)17 : (byte)7);
        this.ct();
    }

    final void bC() {
        this.az = 0;
        this.b = 0;
        if (this.R == 18) {
            this.c[this.c[this.a[0]][this.a[1]]] = this.l;
            this.al[this.Z[this.c[this.a[0]][this.a[1]]]] = this.y[2];
            this.o = this.Z[this.c[this.a[0]][this.a[1]]];
            this.cH();
            if (!this.l && this.Z[this.c[this.a[0]][this.a[1]]] != 22) {
                this.ax = this.c[this.a[0]][this.a[1]];
                this.d(true);
            }
        } else {
            this.bD();
        }
        this.aa = (byte)5;
    }

    final void bD() {
        if (this.R == 19) {
            this.aE[this.aI[this.h[57] + this.an]] = this.y[1];
            this.o = this.an;
            this.cI();
        }
        if (this.m) {
            this.C = this.aI[this.h[56] + this.an];
            this.B = (byte)3;
            if (this.R == 21) {
                if (!this.a[this.c[this.a[0]][this.a[1]]]) {
                    this.ci();
                }
            } else if (!this.d[this.c[this.a[0]][this.a[1]]]) {
                this.ci();
            }
        } else if (this.R == 21) {
            if (this.a[this.c[this.a[0]][this.a[1]]]) {
                this.cl();
            }
        } else {
            if (this.d[this.c[this.a[0]][this.a[1]]]) {
                this.cl();
            }
            if (this.R == 22) {
                this.bL();
            }
        }
        if (this.R == 21) {
            this.aE[this.aI[this.h[57] + this.an]] = this.y[0];
            this.o = 23;
            this.cH();
            this.c[this.c[this.a[0]][this.a[1]]] = this.l;
        }
    }

    final void bE() {
        if (this.k < this.i) {
            this.h = 0;
        }
        if (this.k - -500 >= this.i) {
            this.k -= this.i;
            this.e += this.i;
            this.aT[0] = (byte)this.a[0];
            this.aT[1] = (byte)this.a[1];
            this.h = (short)(b.B[0] / 2);
            this.i = 0;
            this.a.delete(0, this.a.length());
            this.a.append("-");
            this.a.append(this.i);
            this.a = this.a.toString();
            this.dL();
            this.cl();
            this.aa = (byte)5;
            if (this.U > 1) {
                this.m = false;
                this.R = this.U == 2 ? (byte)21 : (this.U == 5 ? (byte)22 : (byte)19);
                if (this.R == 19) {
                    this.x[0] = 0;
                } else if (this.R == 21) {
                    this.x[0] = 2;
                }
                if (this.R == 21) {
                    this.y[0] = this.aE[this.aI[this.h[57] + this.an]];
                } else if (this.R == 19) {
                    this.y[0] = this.aI[this.h[29] + this.an * (this.ad + 1) + this.ad];
                }
                this.cu();
                return;
            }
            this.az = 0;
            this.b = 0;
        }
    }

    final void bF() {
        if (this.R == 17 || this.R == 6 || this.R == 7 || this.R == 8 || this.R == 14 || this.R == 15) {
            if (this.R == 15) {
                this.aJ = 0;
            }
            this.R = 0;
            this.ct();
            return;
        }
        if (this.R == 1) {
            this.az = 0;
            this.b = 0;
            this.aa = (byte)5;
            return;
        }
        if (this.R == 5 && this.aA != 18 && this.aA != 19) {
            this.R = this.S;
            this.cu();
            return;
        }
        if (this.R == 20) {
            this.bG();
            return;
        }
        if ((this.R == 18 || this.R == 19 || this.R == 22 || this.R == 21) && this.o) {
            this.az = 0;
            this.b = 0;
            this.aa = (byte)5;
            this.o = false;
            return;
        }
        if (this.R == 0) {
            this.S = this.R;
            this.R = (byte)5;
            this.aA = (byte)22;
            this.cu();
        }
    }

    final void bG() {
        this.aa = (byte)5;
        if (this.U > 1) {
            this.R = this.U == 2 ? (byte)21 : (this.U == 5 ? (byte)22 : (byte)19);
            if (this.R == 19) {
                this.x[0] = 0;
            } else if (this.R == 21) {
                this.x[0] = 2;
            }
            if (this.R == 21) {
                this.y[0] = this.aE[this.aI[this.h[57] + this.an]];
            } else if (this.R == 19) {
                this.y[0] = this.aI[this.h[29] + this.an * (this.ad + 1) + this.ad];
            }
            this.cu();
            return;
        }
        this.az = 0;
        this.b = 0;
    }

    final void bH() {
        switch (this.n) {
            case 3: {
                if (this.aN >= 2 || this.m[this.aN + 1] >= this.m[this.aN]) break;
                this.aN = (byte)(this.aN + 1);
                return;
            }
            case 4: {
                if (this.aN <= 0 || this.m[this.aN - 1] <= this.m[this.aN]) break;
                this.aN = (byte)(this.aN - 1);
                return;
            }
            case -6: 
            case 5: {
                this.b = 0;
                this.aa = (byte)5;
            }
        }
    }

    final void bI() {
        switch (this.n) {
            case 1: {
                if (this.F > 0) {
                    this.F -= d.j[this.aC];
                }
                if (this.F >= 0) break;
                this.F = 0;
                return;
            }
            case 2: {
                if (this.G <= this.F + d.j[this.aC]) break;
                this.F += d.j[this.aC];
                return;
            }
            case -6: 
            case 5: {
                this.b = 0;
                this.aa = (byte)5;
            }
        }
    }

    final void bJ() {
        if (this.a[0] > 0) {
            if (this.b[this.a[0] - 1][this.a[1]] == 7) {
                this.ap = this.c[this.a[0] - 1][this.a[1]];
                this.bO();
            } else if (this.b[this.a[0] - 1][this.a[1]] <= -15 && this.b[this.a[0] - 1][this.a[1]] >= -27) {
                this.aw = this.c[this.a[0] - 1][this.a[1]];
                this.a[0] = this.a[0] - 1;
                this.bN();
                this.a[0] = this.a[0] + 1;
            }
        }
        if (this.a[1] < this.O - 1) {
            if (this.b[this.a[0]][this.a[1] + 1] == 8) {
                this.ap = this.c[this.a[0]][this.a[1] + 1];
                this.bO();
                return;
            }
            if (this.b[this.a[0]][this.a[1] + 1] <= -15 && this.b[this.a[0]][this.a[1] + 1] >= -27) {
                this.aw = this.c[this.a[0]][this.a[1] + 1];
                this.a[1] = this.a[1] + 1;
                this.bN();
                this.a[1] = this.a[1] - 1;
            }
        }
    }

    final void bK() {
        this.ao = 0;
        while (this.ao < 42) {
            if (this.l[0][this.ao] >= 0 && this.Z[this.ao] == 22) {
                this.ap = this.ao;
                this.bO();
            }
            ++this.ao;
        }
    }

    final void bL() {
        this.ao = 0;
        while (this.ao < 42) {
            if (this.l[0][this.ao] >= 0) {
                if (this.o[this.Z[this.ao]][this.g[this.Z[this.ao]][4] + 3] == 1) {
                    this.ap = this.ao;
                    this.bM();
                } else {
                    this.b[this.ao] = true;
                }
            }
            ++this.ao;
        }
    }

    final void bM() {
        try {
            this.b[this.ap] = false;
            this.an = 0;
            while (this.an < 15) {
                if (this.k[this.an][0] >= 0 && this.d[this.c[this.k[this.an][0]][this.k[this.an][1]]]) {
                    this.b[this.ap] = true;
                    if (this.k[this.an][0] - b.i[0][0] >= this.l[0][this.ap] + this.o[this.Z[this.ap]][this.g[this.Z[this.ap]][0] + 0] || this.k[this.an][1] - b.i[1][0] >= this.l[1][this.ap] + this.o[this.Z[this.ap]][this.g[this.Z[this.ap]][0] + 1] || this.k[this.an][0] + b.i[0][1] < this.l[0][this.ap] || this.k[this.an][1] + b.i[1][1] < this.l[1][this.ap]) {
                        this.b[this.ap] = false;
                    }
                    if (this.b[this.ap]) break;
                }
                ++this.an;
            }
            if (!this.b[this.ap]) {
                this.ax = (byte)this.ap;
                this.d(true);
                if (this.ag[this.ap] == 3) {
                    this.aj[this.ap] = this.af[this.ap] < this.av[this.Z[this.ap]] ? (byte)0 : 1;
                }
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void bN() {
        this.f[this.aw] = false;
        if (this.aI[this.h[163] - 1 - this.b[this.a[0]][this.a[1]]] == 1 || this.aI[this.h[164] - 1 - this.b[this.a[0]][this.a[1]]] == 1) {
            this.f[this.aw] = true;
            if (this.a[0] < this.O - 1 && this.aI[this.h[163] - 1 - this.b[this.a[0]][this.a[1]]] == 1 && this.b[this.a[0] + 1][this.a[1]] == 0) {
                this.f[this.aw] = false;
            }
            if (this.a[1] > 0 && this.aI[this.h[164] - 1 - this.b[this.a[0]][this.a[1]]] == 1 && this.b[this.a[0]][this.a[1] - 1] == 0) {
                this.f[this.aw] = false;
            }
        }
    }

    final void bO() {
        if (this.Z[this.ap] != 22) {
            this.a[this.ap] = false;
            if (this.aa[this.ap] == 0) {
                if (this.b[this.n[0][this.ap]][this.n[1][this.ap] - 1] == 0) {
                    this.a[this.ap] = true;
                    return;
                }
            } else if (this.b[this.n[0][this.ap] + 1][this.n[1][this.ap]] == 0) {
                this.a[this.ap] = true;
                return;
            }
        } else {
            this.a[this.ap] = false;
            if (this.m[0][this.ap] == 0) {
                return;
            }
            this.o[0] = this.l[0][this.ap];
            this.o[1] = this.l[1][this.ap];
            if (this.b[this.o[0]][this.o[1]] != 13) {
                this.o[1] = this.o[1] + 1;
            }
            this.ad[this.ap] = 1;
            this.p[0] = -1;
            this.bP();
            int n = this.ap;
            this.ad[n] = (byte)(this.ad[n] + 5);
        }
    }

    final void bP() {
        do {
            this.an = 0;
            while (this.an < 4) {
                if (this.o[0] + this.aI[this.h[31] + this.an * 2 + 0] < this.O && this.o[1] + this.aI[this.h[31] + this.an * 2 + 1] < this.O && this.o[0] + this.aI[this.h[31] + this.an * 2 + 0] >= 0 && this.o[1] + this.aI[this.h[31] + this.an * 2 + 1] >= 0) {
                    if (this.b[this.o[0] + this.aI[this.h[31] + this.an * 2 + 0]][this.o[1] + this.aI[this.h[31] + this.an * 2 + 1]] == 7 && this.an == 1 || this.b[this.o[0] + this.aI[this.h[31] + this.an * 2 + 0]][this.o[1] + this.aI[this.h[31] + this.an * 2 + 1]] == 8 && this.an == 0) {
                        if (this.m[0][this.c[this.o[0] + this.aI[this.h[31] + this.an * 2 + 0]][this.o[1] + this.aI[this.h[31] + this.an * 2 + 1]]] == 0) {
                            this.l[0][this.c[this.o[0] + this.aI[this.h[31] + this.an * 2 + 0]][this.o[1] + this.aI[this.h[31] + this.an * 2 + 1]]] = -1;
                            this.ai = (byte)(this.ai - 1);
                        } else {
                            this.m[1][this.c[this.o[0] + this.aI[this.h[31] + this.an * 2 + 0]][this.o[1] + this.aI[this.h[31] + this.an * 2 + 1]]] = 0;
                        }
                        this.c[this.o[0] + this.aI[this.h[31] + this.an * 2 + 0]][this.o[1] + this.aI[this.h[31] + this.an * 2 + 1]] = (byte)this.ap;
                        this.m[1][this.ap] = 1;
                        if (this.b[this.o[0] + this.aI[this.h[31] + this.an * 2 + 0] * 2][this.o[1] + this.aI[this.h[31] + this.an * 2 + 1] * 2] == 0) {
                            this.a[this.ap] = true;
                        }
                        this.an = 4;
                        break;
                    }
                    if (this.b[this.o[0] + this.aI[this.h[31] + this.an * 2 + 0]][this.o[1] + this.aI[this.h[31] + this.an * 2 + 1]] == 13 && (this.o[0] + this.aI[this.h[31] + this.an * 2 + 0] != this.p[0] || this.o[1] + this.aI[this.h[31] + this.an * 2 + 1] != this.p[1])) {
                        this.p[0] = this.o[0];
                        this.p[1] = this.o[1];
                        this.o[0] = this.o[0] + this.aI[this.h[31] + this.an * 2 + 0];
                        this.o[1] = this.o[1] + this.aI[this.h[31] + this.an * 2 + 1];
                        this.c[this.o[0]][this.o[1]] = (byte)this.ap;
                        if (this.ad[this.ap] >= 20) break;
                        int n = this.ap;
                        this.ad[n] = (byte)(this.ad[n] + 1);
                        break;
                    }
                }
                ++this.an;
            }
            if (this.an != 4) continue;
            return;
        } while (!this.a[this.ap]);
    }

    /*
     * Enabled aggressive block sorting
     */
    final void bQ() {
        block15: {
            this.h = true;
            this.aA = (byte)5;
            this.e = (short)-1;
            if (this.b[this.a[0]][this.a[1]] > 3 && this.b[this.a[0]][this.a[1]] <= 13) {
                this.bR();
                if (this.ar != 22) {
                    if (this.ac[this.c[this.a[0]][this.a[1]]] > 0) {
                        this.h = false;
                        return;
                    }
                    break block15;
                } else {
                    this.i = false;
                    if (this.c[this.a[0]][this.a[1]] < 0) {
                        return;
                    }
                    if (this.Z[this.c[this.a[0]][this.a[1]]] != 22 || !this.a[this.c[this.a[0]][this.a[1]]]) return;
                    this.bS();
                    return;
                }
            }
            if (this.b[this.a[0]][this.a[1]] == 0) {
                this.bU();
                return;
            }
            if (this.b[this.a[0]][this.a[1]] >= 0) return;
            this.bV();
            return;
        }
        this.aq = this.l[0][this.c[this.a[0]][this.a[1]]];
        while (this.aq < this.l[0][this.c[this.a[0]][this.a[1]]] + this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][0] + 0]) {
            this.ar = this.l[1][this.c[this.a[0]][this.a[1]]];
            while (this.ar < this.l[1][this.c[this.a[0]][this.a[1]]] + this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][0] + 1]) {
                if (this.c[this.aq][this.ar] != -1 && this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][37] + (this.aa[this.c[this.a[0]][this.a[1]]] * this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][0] + 0] + this.aq - this.l[0][this.c[this.a[0]][this.a[1]]]) * this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][0] + 1] + this.ar - this.l[1][this.c[this.a[0]][this.a[1]]]] != 1) {
                    if (this.ar == 23 && this.A[this.c[this.aq][this.ar]] == 10 && this.d[this.c[this.aq][this.ar]] == -1) {
                        this.e = this.c[this.aq][this.ar];
                    } else {
                        this.h = false;
                        return;
                    }
                }
                ++this.ar;
            }
            ++this.aq;
        }
        return;
    }

    final void bR() {
        this.ar = (byte)-1;
        if (this.b[this.a[0]][this.a[1]] == 13) {
            this.ar = (byte)22;
        }
        if ((this.b[this.a[0]][this.a[1]] == 5 || this.b[this.a[0]][this.a[1]] == 7) && this.b[this.a[0] - 1][this.a[1]] == 13) {
            this.ar = (byte)22;
        }
        if ((this.b[this.a[0]][this.a[1]] == 6 || this.b[this.a[0]][this.a[1]] == 8) && this.b[this.a[0]][this.a[1] + 1] == 13) {
            this.ar = (byte)22;
        }
        if (this.ar == -1) {
            this.ar = this.Z[this.c[this.a[0]][this.a[1]]];
        }
    }

    final void bS() {
        this.o[0] = this.l[0][this.c[this.a[0]][this.a[1]]];
        this.o[1] = this.l[1][this.c[this.a[0]][this.a[1]]];
        if (this.b[this.o[0]][this.o[1]] != 13) {
            if (this.c[this.o[0]][this.o[1]] != -1) {
                this.h = false;
            }
            if (this.o[0] == this.a[0] && this.o[1] == this.a[1]) {
                this.i = true;
            }
            this.o[1] = this.o[1] + 1;
        } else {
            if (this.c[this.o[0] + 1][this.o[1]] != -1) {
                this.h = false;
            }
            if (this.o[0] + 1 == this.a[0] && this.o[1] == this.a[1]) {
                this.i = true;
            }
        }
        this.p[0] = -1;
        this.bT();
    }

    final void bT() {
        block0: do {
            if (this.c[this.o[0]][this.o[1]] != -1) {
                this.h = false;
            }
            if (this.o[0] == this.a[0] && this.o[1] == this.a[1]) {
                this.i = true;
            }
            this.an = 0;
            while (this.an < 4) {
                if (this.o[0] + this.aI[this.h[31] + this.an * 2 + 0] < this.O && this.o[1] + this.aI[this.h[31] + this.an * 2 + 1] < this.O && this.o[0] + this.aI[this.h[31] + this.an * 2 + 0] >= 0 && this.o[1] + this.aI[this.h[31] + this.an * 2 + 1] >= 0) {
                    if (this.b[this.o[0] + this.aI[this.h[31] + this.an * 2 + 0]][this.o[1] + this.aI[this.h[31] + this.an * 2 + 1]] == 7 && this.an == 1 || this.b[this.o[0] + this.aI[this.h[31] + this.an * 2 + 0]][this.o[1] + this.aI[this.h[31] + this.an * 2 + 1]] == 8 && this.an == 0) {
                        if (this.c[this.o[0] + this.aI[this.h[31] + this.an * 2 + 0]][this.o[1] + this.aI[this.h[31] + this.an * 2 + 1]] != -1) {
                            this.h = false;
                        }
                        if (this.o[0] + this.aI[this.h[31] + this.an * 2 + 0] == this.a[0] && this.o[1] + this.aI[this.h[31] + this.an * 2 + 1] == this.a[1]) {
                            this.i = true;
                        }
                        this.an = 4;
                        continue block0;
                    }
                    if (this.b[this.o[0] + this.aI[this.h[31] + this.an * 2 + 0]][this.o[1] + this.aI[this.h[31] + this.an * 2 + 1]] == 13 && (this.o[0] + this.aI[this.h[31] + this.an * 2 + 0] != this.p[0] || this.o[1] + this.aI[this.h[31] + this.an * 2 + 1] != this.p[1])) {
                        this.p[0] = this.o[0];
                        this.p[1] = this.o[1];
                        this.o[0] = this.o[0] + this.aI[this.h[31] + this.an * 2 + 0];
                        this.o[1] = this.o[1] + this.aI[this.h[31] + this.an * 2 + 1];
                        continue block0;
                    }
                }
                ++this.an;
            }
        } while (this.an != 4);
        if (!this.i) {
            this.h = true;
        }
    }

    final void bU() {
        if (this.c[this.a[0]][this.a[1]] != -1) {
            this.h = false;
        }
        if (this.c[this.a[0]][this.a[1]] % 4 == 0) {
            if (this.a[0] > 0 && (this.b[this.a[0] - 1][this.a[1]] == 5 || this.b[this.a[0] - 1][this.a[1]] == 7)) {
                this.a[0] = this.a[0] - 1;
                this.bQ();
                this.a[0] = this.a[0] + 1;
            }
            if (this.a[1] < this.O - 1 && (this.b[this.a[0]][this.a[1] + 1] == 6 || this.b[this.a[0]][this.a[1] + 1] == 8)) {
                this.a[1] = this.a[1] + 1;
                this.bQ();
                this.a[1] = this.a[1] - 1;
            }
            if (this.a[0] == this.ab && this.a[1] == 0) {
                this.aA = (byte)8;
                this.h = false;
            }
        }
    }

    final void bV() {
        this.aq = 0;
        while (this.aq < 2) {
            if (!(this.aq == 0 && this.a[0] >= this.O - 1 || this.aq == 1 && this.a[1] <= 0 || this.aI[this.h[163 + this.aq] - 1 - this.b[this.a[0]][this.a[1]]] == 0)) {
                this.ar = this.c[this.a[0] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.aq] * 4 + 2] * 2 + 0]][this.a[1] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.aq] * 4 + 2] * 2 + 1]];
                while (this.ar >= 0) {
                    if (this.ar < 200 && this.W[this.ar] == this.aI[this.h[53] + -1 - this.b[this.a[0]][this.a[1]]] && this.h[2][this.ar] == this.aq && this.h[0][this.ar] < 2) {
                        this.h = false;
                        if (this.h[0][this.ar] != 0) break;
                        this.aA = (byte)10;
                        break;
                    }
                    this.ar = this.d[this.ar];
                }
                if (!this.h) break;
            }
            ++this.aq;
        }
        if (this.aI[this.h[56] + -1 - this.b[this.a[0]][this.a[1]]] != -1 && this.d[this.c[this.a[0]][this.a[1]]]) {
            this.e = 0;
        }
    }

    final void bW() {
        if (this.b[this.a[0]][this.a[1]] > 3 && this.b[this.a[0]][this.a[1]] <= 13) {
            if (this.e != -1) {
                this.ac = (byte)(this.ac - 1);
                this.ay = this.e;
                this.dp();
                this.B[this.e] = -1;
            }
            if (this.ar != 22) {
                this.bZ();
            } else {
                this.bX();
            }
            this.aa = (byte)5;
            return;
        }
        if (this.b[this.a[0]][this.a[1]] == 0) {
            if (this.c[this.a[0]][this.a[1]] % 4 != 0) {
                byte[] byArray = this.c[this.a[0]];
                int n = this.a[1];
                byArray[n] = (byte)(byArray[n] - this.c[this.a[0]][this.a[1]] % 4);
                return;
            }
            this.b[this.a[0]][this.a[1]] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
            this.c[this.a[0]][this.a[1]] = 0;
            this.bJ();
            this.aa = (byte)5;
            return;
        }
        if (this.b[this.a[0]][this.a[1]] < 0) {
            this.bY();
        }
    }

    final void bX() {
        if (this.i) {
            this.a[this.c[this.a[0]][this.a[1]]] = false;
        }
        if (this.b[this.a[0]][this.a[1]] == 5 || this.b[this.a[0]][this.a[1]] == 7) {
            this.b[this.a[0] - 1][this.a[1]] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
            this.c[this.a[0] - 1][this.a[1]] = 0;
            this.at = this.a[0];
            this.au = this.a[1];
            this.ca();
        } else if (this.b[this.a[0]][this.a[1]] == 6 || this.b[this.a[0]][this.a[1]] == 8) {
            this.b[this.a[0]][this.a[1] + 1] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
            this.c[this.a[0]][this.a[1] + 1] = 0;
            this.at = this.a[0];
            this.au = this.a[1];
            this.ca();
        } else {
            if (this.b[this.a[0]][this.a[1]] == 13 && this.a[0] < this.O - 1 && (this.b[this.a[0] + 1][this.a[1]] == 5 || this.b[this.a[0] + 1][this.a[1]] == 7)) {
                this.at = this.a[0] + 1;
                this.au = this.a[1];
                this.ca();
                this.b[this.a[0] + 1][this.a[1]] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
                this.c[this.a[0] + 1][this.a[1]] = 0;
            }
            if (this.b[this.a[0]][this.a[1]] == 13 && this.a[1] > 0 && (this.b[this.a[0]][this.a[1] - 1] == 6 || this.b[this.a[0]][this.a[1] - 1] == 8)) {
                this.at = this.a[0];
                this.au = this.a[1] - 1;
                this.ca();
                this.b[this.a[0]][this.a[1] - 1] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
                this.c[this.a[0]][this.a[1] - 1] = 0;
            }
        }
        this.b[this.a[0]][this.a[1]] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
        this.c[this.a[0]][this.a[1]] = 0;
    }

    final void bY() {
        if (this.b[this.a[0]][this.a[1]] <= -15) {
            this.ak[this.c[this.a[0]][this.a[1]]] = -1;
            this.ak = (byte)(this.ak - 1);
        }
        if (this.b[this.a[0]][this.a[1]] <= -27) {
            this.as = 0;
            while (this.as < 15) {
                if (!(this.a[0] != this.k[this.as][0] && this.a[0] - 1 != this.k[this.as][0] || this.a[1] != this.k[this.as][1] && this.a[1] - 1 != this.k[this.as][1] || this.k[this.as][0] < 0)) {
                    this.aq = this.k[this.as][0];
                    while (this.aq < this.k[this.as][0] + 2) {
                        this.ar = this.k[this.as][1];
                        while (this.ar < this.k[this.as][1] + 2) {
                            this.b[this.aq][this.ar] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
                            this.c[this.aq][this.ar] = 0;
                            ++this.ar;
                        }
                        ++this.aq;
                    }
                    this.k[this.as][0] = -1;
                    this.ah = (byte)(this.ah - 1);
                    break;
                }
                ++this.as;
            }
            this.bL();
        } else {
            if (this.b[this.a[0]][this.a[1]] == -14) {
                this.as = 0;
                while (this.as < 30) {
                    if (this.i[this.as][0] == this.a[0] && this.i[this.as][1] == this.a[1]) {
                        this.i[this.as][0] = -1;
                        this.ag = (byte)(this.ag - 1);
                        break;
                    }
                    ++this.as;
                }
            }
            this.b[this.a[0]][this.a[1]] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
            this.c[this.a[0]][this.a[1]] = 0;
        }
        this.aa = (byte)5;
    }

    final void bZ() {
        this.e = this.c[this.a[0]][this.a[1]];
        this.ai = (byte)(this.ai - 1);
        this.aq = this.l[0][this.e];
        while (this.aq < this.l[0][this.e] + this.o[this.ar][this.g[this.ar][0] + 0]) {
            this.ar = this.l[1][this.e];
            while (this.ar < this.l[1][this.e] + this.o[this.ar][this.g[this.ar][0] + 1]) {
                if (this.o[this.ar][this.g[this.ar][37] + (this.aa[this.e] * this.o[this.ar][this.g[this.ar][0] + 0] + this.aq - this.l[0][this.e]) * this.o[this.ar][this.g[this.ar][0] + 1] + this.ar - this.l[1][this.e]] != 1) {
                    this.b[this.aq][this.ar] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
                    this.c[this.aq][this.ar] = 0;
                }
                ++this.ar;
            }
            ++this.aq;
        }
        this.dx();
        this.l[0][this.e] = -1;
    }

    final void ca() {
        if (this.b[this.at][this.au] == 5 || this.b[this.at][this.au] == 6) {
            this.m[0][this.c[this.at][this.au]] = 0;
            if (this.m[1][this.c[this.at][this.au]] != 0) {
                this.l[0][this.c[this.at][this.au]] = this.n[0][this.c[this.at][this.au]];
                this.l[1][this.c[this.at][this.au]] = this.n[1][this.c[this.at][this.au]];
            }
        } else {
            this.m[1][this.c[this.at][this.au]] = 0;
        }
        if (this.m[0][this.c[this.at][this.au]] == 0 && this.m[1][this.c[this.at][this.au]] == 0) {
            this.ai = (byte)(this.ai - 1);
            this.l[0][this.c[this.at][this.au]] = -1;
            this.dx();
        }
    }

    final void cb() {
        if (this.aW == 0) {
            this.cc();
            this.cd();
            if (this.o[this.Z[this.av]][this.g[this.Z[this.av]][4] + 3] == 1) {
                this.bM();
            } else {
                this.b[this.av] = true;
            }
            if (this.Z[this.av] == 23) {
                this.ag[this.av] = 3;
                this.a[this.av] = false;
            } else if (this.aD[this.Z[this.av]] == 0) {
                this.aD[this.Z[this.av]] = (byte)(this.aA[this.Z[this.av]] / b.au[0]);
                this.aD[24] = (byte)(this.aD[24] + this.aD[this.Z[this.av]]);
            }
            if ((this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W < 0) {
                this.s();
            }
            this.aa = (byte)5;
        } else if (this.aW == 1) {
            this.ce();
            this.cf();
        } else if (this.aW == 2) {
            byte by = this.C;
            this.e[by] = (short)(this.e[by] + 1);
            byte by2 = b.j[3];
            this.e[by2] = (short)(this.e[by2] + this.aI[this.h[131] + this.C]);
            this.ci();
        } else if (this.aW == 3) {
            this.cg();
        }
        this.ch();
    }

    final void cc() {
        if (this.j < 1 || !this.j) {
            this.av = 0;
            while (this.av < 42 && this.l[0][this.av] >= 0) {
                ++this.av;
            }
            this.ai = (byte)(this.ai + 1);
            this.Z[this.av] = this.aV;
            this.aa[this.av] = this.at;
            this.l[0][this.av] = (byte)this.a[0];
            this.l[1][this.av] = (byte)this.a[1];
            this.ab[this.av] = 0;
            this.ac[this.av] = 0;
            this.ad[this.av] = 0;
            this.ae[this.av] = this.aa[this.av] == 0 ? (byte)(this.l[1][this.av] + this.o[this.Z[this.av]][this.g[this.Z[this.av]][0] + 1] - 1) : this.l[0][this.av];
            this.j = true;
            this.m[0][this.av] = 0;
            this.m[1][this.av] = 0;
        }
        if (this.j >= 0) {
            this.aw = b.a[this.at][this.j][0];
            return;
        }
        this.aw = 0;
    }

    final void cd() {
        while (this.aw < this.B) {
            this.ax = this.j >= 0 ? b.b[this.at][this.j][0] : 0;
            while (this.ax < this.C) {
                if (this.o[this.aV][this.g[this.aV][37] + (this.at * this.o[this.aV][this.g[this.aV][0] + 0] + this.aw) * this.o[this.aV][this.g[this.aV][0] + 1] + this.ax] != 1) {
                    this.b[this.a[0] + this.aw][this.a[1] + this.ax] = this.o[this.aV][this.g[this.aV][37] + (this.at * this.o[this.aV][this.g[this.aV][0] + 0] + this.aw) * this.o[this.aV][this.g[this.aV][0] + 1] + this.ax];
                    if (this.b[this.a[0] + this.aw][this.a[1] + this.ax] == 7 || this.b[this.a[0] + this.aw][this.a[1] + this.ax] == 8) {
                        this.n[0][this.av] = (byte)(this.a[0] + this.aw);
                        this.n[1][this.av] = (byte)(this.a[1] + this.ax);
                    }
                    if (this.b[this.a[0] + this.aw][this.a[1] + this.ax] == 10) {
                        this.m[0][this.av] = (byte)(this.a[0] + this.aw);
                        this.m[1][this.av] = (byte)(this.a[1] + this.ax);
                    }
                    this.c[this.a[0] + this.aw][this.a[1] + this.ax] = (byte)this.av;
                }
                ++this.ax;
            }
            ++this.aw;
        }
        this.ah[this.av] = 100;
        this.ai[this.av] = 0;
        this.aj[this.av] = -1;
        this.ag[this.av] = 0;
        this.c[this.av] = true;
        this.a[this.av] = true;
        this.ap = this.av;
        if (this.Z[this.av] != 23 && this.Z[this.av] != 22) {
            this.bO();
        }
        if (this.Z[this.av] == 22) {
            this.m[this.j][this.av] = 1;
            this.bK();
        }
    }

    final void ce() {
        if (this.au > -15) {
            this.b[this.a[0]][this.a[1]] = this.au;
            return;
        }
        this.av = 0;
        while (this.av < 90 && this.ak[this.av] >= 0) {
            ++this.av;
        }
        this.aw = 0;
        while (this.aw < this.B) {
            this.ax = 0;
            while (this.ax < this.C) {
                this.b[this.a[0] + this.aw][this.a[1] + this.ax] = this.au;
                if (this.au == -27) {
                    this.b[this.a[0] + this.aw][this.a[1] + this.ax] = b.h[this.aw][this.ax];
                }
                this.c[this.a[0] + this.aw][this.a[1] + this.ax] = (byte)this.av;
                ++this.ax;
            }
            ++this.aw;
        }
        if (this.au != -21 && this.au != -22 && this.au != -20) {
            this.d[this.av] = false;
            this.e[this.av] = true;
        } else {
            this.d[this.av] = true;
            this.e[this.av] = false;
        }
        this.ak[this.av] = 0;
        this.aw = (byte)this.av;
        this.bN();
        this.ak = (byte)(this.ak + 1);
    }

    final void cf() {
        if (this.au == -14) {
            this.av = 0;
            while (this.av < 30 && this.i[this.av][0] >= 0) {
                ++this.av;
            }
            this.i[this.av][0] = (byte)this.a[0];
            this.i[this.av][1] = (byte)this.a[1];
            this.ag = (byte)(this.ag + 1);
        }
        if (this.au == -27) {
            this.av = 0;
            while (this.av < 15 && this.k[this.av][0] >= 0) {
                ++this.av;
            }
            this.k[this.av][0] = (byte)this.a[0];
            this.k[this.av][1] = (byte)this.a[1];
            this.ah = (byte)(this.ah + 1);
        }
        this.aa = (byte)5;
    }

    final void cg() {
        if (this.aV == 13) {
            this.b[this.a[0]][this.a[1]] = this.aV;
            this.c[this.a[0]][this.a[1]] = -1;
            this.bK();
        } else {
            if (this.aV != 2 && this.aV != 1 && this.b[this.a[0]][this.a[1]] != 0) {
                this.c[this.a[0]][this.a[1]] = 0;
            }
            this.b[this.a[0]][this.a[1]] = 0;
            byte[] byArray = this.c[this.a[0]];
            int n = this.a[1];
            byArray[n] = (byte)(byArray[n] + (this.aV + this.av));
            this.bJ();
        }
        this.aa = (byte)5;
    }

    final void ch() {
        this.dx();
        this.aT[0] = (byte)(this.b[0] + this.a[0]);
        this.aT[1] = (byte)(this.b[1] + this.a[1]);
        this.h = (short)(this.z / 2);
        this.i = 0;
        if (this.j < 0) {
            this.k -= this.i;
            this.e += this.i;
            this.a.delete(0, this.a.length());
            this.a.append("-");
            this.a.append(this.i);
            this.a = this.a.toString();
        } else {
            this.k -= this.i / 2;
            this.e += this.i / 2;
            this.a.delete(0, this.a.length());
            this.a.append("-");
            this.a.append(this.i / 2);
            this.a = this.a.toString();
        }
        this.dL();
        if (this.aW != 2) {
            this.Y = (byte)(this.a[0] / 5);
            while (this.Y <= (byte)((this.a[0] + this.B - 1) / 5)) {
                this.Z = (byte)(this.a[1] / 5);
                while (this.Z <= (byte)((this.a[1] + this.C - 1) / 5)) {
                    this.cG();
                    this.Z = (byte)(this.Z + 1);
                }
                this.Y = (byte)(this.Y + 1);
            }
        }
        if (this.K == 1 && this.L == 0 && this.j < 1) {
            this.ck();
        }
    }

    final void ci() {
        if (this.C < 3) {
            this.cj();
            this.ac = (byte)(this.ac + 1);
        } else {
            this.d[this.c[this.a[0]][this.a[1]]] = true;
            if (this.b[this.a[0]][this.a[1]] != -16 && this.b[this.a[0]][this.a[1]] != -17 && this.b[this.a[0]][this.a[1]] != -27 && this.b[this.a[0]][this.a[1]] != -28) {
                this.e[this.c[this.a[0]][this.a[1]]] = false;
            }
            if (this.b[this.a[0]][this.a[1]] == -24 || this.b[this.a[0]][this.a[1]] == -25) {
                if (this.a[1] > 0 && this.b[this.a[0]][this.a[1] - 1] == 0) {
                    this.b[this.a[0]][this.a[1]] = -25;
                }
                if (this.a[0] < this.O - 1 && this.b[this.a[0] + 1][this.a[1]] == 0) {
                    this.b[this.a[0]][this.a[1]] = -24;
                }
            }
            if (this.b[this.a[0]][this.a[1]] == -27 || this.b[this.a[0]][this.a[1]] == -28) {
                this.bL();
            }
            this.aw = this.c[this.a[0]][this.a[1]];
            this.bN();
        }
        if (this.K == 1 && this.L == 0) {
            this.ck();
        }
    }

    final void cj() {
        this.av = 200;
        while (this.av < 222 && this.B[this.av] >= 0) {
            ++this.av;
        }
        this.A[this.av] = (byte)(8 + this.C);
        if (this.A[this.av] == 10) {
            this.B[this.av] = (byte)(this.l[0][this.c[this.a[0]][this.a[1]]] + this.aI[this.h[78] + 0]);
            this.C[this.av] = (byte)(this.l[1][this.c[this.a[0]][this.a[1]]] + this.aI[this.h[78] + 1]);
            this.F[this.av] = 1;
            this.G[this.av] = this.aI[this.h[78] + 2];
            this.H[this.av] = this.aI[this.h[78] + 3];
            this.aw = 0;
            while (this.aw < 12) {
                this.e[this.c[this.a[0]][this.a[1]]][this.aw] = -1;
                ++this.aw;
            }
            this.ag[this.c[this.a[0]][this.a[1]]] = 3;
            this.a[this.c[this.a[0]][this.a[1]]] = true;
        } else {
            this.B[this.av] = (byte)this.a[0];
            this.C[this.av] = (byte)this.a[1];
            this.F[this.av] = 0;
            this.G[this.av] = b.Z[0];
            this.H[this.av] = 18;
        }
        this.I[this.av] = 2;
        this.J[this.av] = 0;
        this.W[this.av] = -1;
        this.d[this.av] = this.c[this.B[this.av]][this.C[this.av]];
        this.c[this.B[this.av]][this.C[this.av]] = (short)this.av;
        if (this.A[this.av] != 10) {
            this.aL = this.av;
            this.dq();
        }
    }

    final void ck() {
        this.aw = -1;
        if (this.aW < 2) {
            this.aw = this.aV;
        }
        if (this.aW == 2) {
            this.aw = this.C;
        }
        if (this.aW == 3 && this.aV < 10) {
            this.aw = this.aV % 4;
        }
        if (this.aw >= 0) {
            this.av = 0;
            while (this.av < this.b.length) {
                if (this.aI[this.h[140] + this.av] == this.aW && (this.aI[this.h[141] + this.av] == this.aw || this.aI[this.h[141] + this.av] == -1) && this.b[this.av] == 0) {
                    this.b[this.av] = 1;
                    return;
                }
                ++this.av;
            }
        }
    }

    final void cl() {
        if (this.U == 2) {
            this.a[this.c[this.a[0]][this.a[1]]] = false;
            this.av = 200;
            while (this.av < 222) {
                if (this.B[this.av] >= 0 && this.A[this.av] == 10 && this.c[this.a[0]][this.a[1]] == this.c[this.B[this.av]][this.C[this.av]]) {
                    this.ac = (byte)(this.ac - 1);
                    this.ay = this.av;
                    this.dp();
                    this.B[this.av] = -1;
                    break;
                }
                ++this.av;
            }
        } else if (this.U < 2) {
            this.ac = (byte)(this.ac - 1);
            this.ay = this.j;
            this.dp();
            this.B[this.j] = -1;
        } else {
            this.d[this.c[this.a[0]][this.a[1]]] = false;
            this.e[this.c[this.a[0]][this.a[1]]] = true;
        }
        byte by = this.U;
        this.e[by] = (short)(this.e[by] - 1);
        byte by2 = b.j[3];
        this.e[by2] = (short)(this.e[by2] - this.aI[this.h[131] + this.U]);
    }

    final void cm() {
        if (this.j >= 0 && this.j < 2) {
            this.j = (byte)(this.j + 1);
            if (this.j < 2) {
                this.B = b.a[this.at][this.j][1];
                this.C = b.b[this.at][this.j][1];
            }
            if (this.j == 2) {
                this.B = (byte)4;
                this.C = (byte)2;
                this.aV = this.aI[this.h[151 + this.B] + this.C];
                this.aW = this.aI[this.h[146 + this.B] + this.C];
                this.i = this.aI[this.h[133] + this.aV];
                this.B = 1;
                this.C = 1;
                this.z = b.B[0];
                this.A = b.B[1];
                this.b[0] = 0;
                this.b[1] = 0;
                this.cn();
                this.j = (byte)-1;
            }
            if (this.a[0] < 0) {
                this.a[0] = 0;
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[0] = nArray[0] + 1;
                    ++this.q;
                }
            }
            if (this.a[1] < 0) {
                this.a[1] = 0;
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[1] = nArray[1] + 1;
                    ++this.q;
                }
            }
            if (this.a[0] >= this.O - 1) {
                this.a[0] = this.O - 2;
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[0] = nArray[0] - 1;
                    ++this.q;
                }
            }
            if (this.a[1] >= this.O - 1) {
                this.a[1] = this.O - 2;
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[1] = nArray[1] - 1;
                    ++this.q;
                }
            }
        } else {
            this.d = false;
        }
    }

    final void cn() {
        if (this.a[0] + this.B >= this.O) {
            this.a[0] = (byte)(this.O - this.B);
        }
        if (this.a[1] + this.C >= this.O) {
            this.a[1] = (byte)(this.O - this.C);
        }
        this.az = (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + (this.z - this.l) / 2;
        this.aA = (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + (this.B - this.C + 2) * (b.B[1] / 2) / 2 - this.m / 2;
        this.aB = (this.aA / (b.B[1] / 2) + this.az / (b.B[0] / 2)) / 2;
        this.aC = (this.az / (b.B[0] / 2) - this.aA / (b.B[1] / 2)) / 2;
        this.az = 0;
        while (this.az < 4) {
            int[] nArray = this.f[this.az];
            nArray[0] = nArray[0] + this.aB;
            int[] nArray2 = this.f[this.az];
            nArray2[1] = nArray2[1] + this.aC;
            ++this.az;
        }
    }

    final void co() {
        this.cp();
        if (this.aA >= 0) {
            if (!this.o) {
                this.aa = (byte)5;
            }
            this.o = true;
            this.aC = (byte)3;
            this.dH();
            return;
        }
        this.cq();
        this.a.delete(0, this.a.length());
        if (this.aW == 0) {
            if (this.aV != 23) {
                this.a.append(this.aA[this.aV] / 5);
            } else {
                this.a.append(b.aq[5]);
            }
        } else if (this.aW == 1) {
            if (this.aV >= 14) {
                this.a.append(this.aI[this.h[29] + this.aV * (this.ad + 1) + this.ad]);
            } else {
                this.a.append(this.aI[this.h[29] + this.aV * (this.ad + 1) + 0]);
            }
        }
        this.a = this.a.toString();
        this.g = 0;
        this.h = d.n[3 + this.aI[this.h[132] + this.aW * 2 + 1]];
        this.i = (short)(105 - (b.b[1] - this.aI[this.h[74] + 10]) / 2);
        this.dM();
        this.cs();
    }

    final void cp() {
        this.az = 1;
        this.aA = (byte)-1;
        switch (this.aW) {
            case 0: {
                this.f = this.aI[this.h[135] + this.aV];
                if (this.ai < 42) break;
                this.aA = 0;
                break;
            }
            case 1: {
                this.f = this.aI[this.h[136] + this.aV];
                if (-1 - this.aV <= -15 && this.ak >= 90) {
                    this.aA = 1;
                }
                if (-1 - this.aV == -14 && this.ag >= 30) {
                    this.aA = (byte)2;
                }
                if (-1 - this.aV != -27 || this.ah < 15) break;
                this.aA = (byte)3;
                break;
            }
            case 2: {
                this.f = this.aI[this.h[137] + this.C];
                if (this.C >= 3 || this.ac < 22) break;
                this.aA = (byte)4;
                break;
            }
            case 3: {
                this.f = this.aI[this.h[139] + this.aV];
            }
        }
        this.g = 1;
        this.h = (short)(this.l / 2);
        this.i = (short)65;
        this.dK();
    }

    final void cq() {
        if (this.o) {
            this.aa = (byte)5;
        }
        this.o = false;
        if (this.aW == 2) {
            this.f = this.aI[this.h[138] + this.C];
            this.g = 1;
            this.h = (short)(this.l / 2);
            this.i = (short)240;
            this.dK();
        }
        switch (this.aW) {
            case 0: {
                this.i = this.az[this.aV] * 10;
                break;
            }
            case 1: {
                this.i = this.aI[this.h[58] + this.aV];
                break;
            }
            case 2: {
                this.i = this.aI[this.h[131] + this.C];
                break;
            }
            case 3: {
                this.i = this.aI[this.h[133] + this.aV];
            }
        }
        this.a.delete(0, this.a.length());
        this.a.append(this.i);
        this.a = this.a.toString();
        this.g = 0;
        this.h = d.n[1 + this.aI[this.h[132] + this.aW * 2 + 1]];
        this.i = (short)(105 - (b.b[1] - this.aI[this.h[74] + 10]) / 2);
        this.dM();
        if (this.aW == 0) {
            this.a.delete(0, this.a.length());
            this.a.append(this.au[this.aV]);
            this.a = this.a.toString();
            this.g = 0;
            this.h = d.n[5 + this.aI[this.h[132] + this.aW * 2 + 1]];
            this.i = (short)(105 - (b.b[1] - this.aI[this.h[74] + 10]) / 2);
            this.dM();
        }
    }

    final void cr() {
        if (this.aW == 1 && this.aV == 26) {
            this.B = 2;
            this.C = 2;
        } else {
            this.B = 1;
            this.C = 1;
        }
        if (this.aW != 2) {
            this.z = (this.B + this.C) * b.B[0] / 2;
            this.A = (this.B + this.C) * b.B[1] / 2;
        } else {
            this.z = this.aI[this.h[51] + this.C];
            this.A = this.aI[this.h[52] + this.C];
        }
        this.x = 120 - this.z / 2;
        this.y = 230 - this.A / 2;
        if (this.aW == 1) {
            this.y -= (this.C + 1) % 2 * b.B[1] / 2;
            this.A += (this.C + 1) % 2 * b.B[1] / 2;
        }
        this.b[0] = 0;
        this.b[1] = 0;
        if (this.aW == 1) {
            this.b[0] = -(this.C / 2);
            this.b[1] = this.C / 2;
        }
    }

    final void cs() {
        if (this.aW == 0) {
            this.B = this.o[this.aV][this.g[this.aV][0] + 0];
            this.C = this.o[this.aV][this.g[this.aV][0] + 1];
            this.z = (this.B + this.C) * b.B[0] / 2;
            this.A = (this.B + this.C) * b.B[1] / 2;
            this.x = 120 - this.z / 2;
            this.y = d.o[this.aV] - this.A / 2;
            this.y -= (this.C + 1) % 2 * b.B[1] / 2;
            this.A += (this.C + 1) % 2 * b.B[1] / 2;
            this.b[0] = -(this.C / 2);
            this.b[1] = this.C / 2;
            this.at = 0;
            return;
        }
        this.cr();
    }

    final void ct() {
        this.P = 0;
        this.cu();
    }

    final void cu() {
        this.cv();
        if (this.R == 4) {
            this.f = this.l[0];
            this.i = d.d[this.R][0];
            this.h = (short)(this.l / 2 - 6);
            this.g = 1;
            this.dK();
            int n = this.az - 1;
            this.d[n] = this.d[n] + 6;
            this.a.delete(0, this.a.length());
            this.a.append(this.aJ);
            this.a = this.a.toString();
            this.i = d.d[this.R][0];
            this.h = (short)(this.l / 2 + this.d[this.az - 1] / 2);
            this.dM();
        }
        this.cw();
        if (this.R == 26) {
            switch (this.P) {
                case 0: 
                case 1: 
                case 2: 
                case 5: {
                    this.aD = 0;
                    while (this.aD < 2) {
                        this.a.delete(0, this.a.length());
                        if (this.aD == 0) {
                            if (this.P < 3) {
                                this.a.append(this.d[this.P][0]);
                            } else {
                                this.a.append(this.d[3][0]);
                            }
                        } else {
                            this.a.append(0);
                        }
                        this.a = this.a.toString();
                        this.g = 1;
                        this.h = d.l[this.aD];
                        this.i = d.m[this.aD];
                        this.dM();
                        ++this.aD;
                    }
                    break;
                }
                case 3: {
                    this.cx();
                    break;
                }
                case 4: {
                    this.cy();
                }
            }
        }
        this.cz();
        this.cA();
        this.cB();
    }

    final void cv() {
        this.az = this.aI[this.h[94] + this.R];
        if (this.R != 2) {
            if (this.R != 5) {
                this.aA = (byte)-1;
                switch (this.R) {
                    case 18: {
                        if (!(this.ar != 22 || this.c[this.a[0]][this.a[1]] >= 0 && this.a[this.c[this.a[0]][this.a[1]]])) {
                            this.aA = (byte)21;
                            break;
                        }
                        if (!this.b[this.c[this.a[0]][this.a[1]]]) {
                            this.aA = (byte)6;
                            break;
                        }
                        if (!this.a[this.c[this.a[0]][this.a[1]]]) {
                            this.aA = (byte)7;
                            break;
                        }
                        if (this.ah[this.c[this.a[0]][this.a[1]]] >= 10) break;
                        this.aA = (byte)11;
                        break;
                    }
                    case 19: {
                        if (!this.f[this.c[this.a[0]][this.a[1]]]) break;
                        this.aA = (byte)7;
                    }
                }
            }
            if (this.aA >= 0) {
                if (this.R != 5) {
                    this.o = true;
                }
                this.aC = (byte)3;
                this.dH();
            } else {
                this.o = false;
            }
        } else {
            this.o = false;
        }
        this.g = 1;
    }

    final void cw() {
        this.v = this.R == 1 && this.K == 0 && this.J == -1;
        if (!(this.o || this.R == 26 || this.v[this.R] <= 0 && this.R != 14 && this.R != 15 && this.R != 16 && this.R != 12 && this.R != 13)) {
            this.aD = 0;
            while (this.aD < this.a[this.R].length) {
                if (!(this.a[this.R][this.aD] == 11 || this.a[this.R][this.aD] == 12 && this.m || this.R == 4 && this.aD == 0)) {
                    if (this.R == 8 && this.aD >= this.E) break;
                    if (!this.v || this.a[this.R][this.aD] != 4) {
                        this.f = this.a[this.R][this.aD];
                        if (this.a[this.R][this.aD] == 10 && !this.l) {
                            this.f = (short)(this.f + 1);
                        }
                        this.i = this.R == 12 || this.R == 13 ? (short)((this.m + b.c[this.R - 12][1]) / 2 + 3) : (this.a[this.R][this.aD] == 12 ? d.p[this.R] : (short)(d.d[this.R][0] + d.d[this.R][1] * this.aD));
                        if (this.v) {
                            this.i = this.aD < 1 ? (short)(this.i + d.d[this.R][1] / 2) : (short)(this.i - d.d[this.R][1] / 2);
                        }
                        this.h = (short)(this.l / 2);
                        this.dK();
                    }
                }
                ++this.aD;
            }
        }
        if ((this.R != 2 || this.aA != 29) && this.w[this.R] != -1) {
            this.f = this.R != 26 ? (short)this.w[this.R] : (short)this.k[this.P];
            this.i = (short)65;
            this.h = (short)(this.l / 2);
            this.dK();
        }
        if (!this.o) {
            this.aD = 0;
            while (this.aD < this.aI[this.h[92] + this.R]) {
                this.a.delete(0, this.a.length());
                this.a.append(this.y[this.aD]);
                this.a = this.a.toString();
                this.g = 0;
                this.h = (short)153;
                this.i = (short)(d.e[this.R][this.aD] - b.b[0] / 2);
                this.dM();
                ++this.aD;
            }
        }
    }

    final void cx() {
        this.aD = 0;
        while (this.aD < b.j[3] + 1) {
            this.a.delete(0, this.a.length());
            this.a.append(this.e[this.aD]);
            this.a = this.a.toString();
            this.g = 0;
            this.h = d.v[this.aD];
            this.i = d.w[this.aD];
            this.dM();
            ++this.aD;
        }
    }

    final void cy() {
        this.ad();
        this.aD = 0;
        while (this.aD < 3) {
            this.a.delete(0, this.a.length());
            this.a.append(this.e[this.aD][0]);
            this.a.append("/");
            this.a.append(this.e[this.aD][1]);
            this.a = this.a.toString();
            this.g = 0;
            this.h = (short)70;
            this.i = (short)(d.z[this.aD] - b.b[0] / 2);
            this.dM();
            ++this.aD;
        }
    }

    final void cz() {
        if (this.R == 23) {
            this.aD = 0;
            while (this.aD < 2) {
                this.a.delete(0, this.a.length());
                if (this.aD == 0) {
                    this.a.append(this.f[2][this.j]);
                }
                if (this.aD == 1) {
                    this.a.append(this.L[this.j]);
                }
                this.a = this.a.toString();
                this.g = 0;
                this.h = (short)(d.x[this.aD] + 7);
                this.i = (short)(d.y[this.aD] - b.b[0] / 2);
                this.dM();
                ++this.aD;
            }
        }
        if (this.R == 10) {
            if (this.K == 1) {
                this.f = (byte)(8 + this.M);
                this.i = d.d[this.R][0];
                this.h = (short)(this.l / 2);
                this.dK();
                this.aD = 0;
                while (this.aD < 3) {
                    this.a.delete(0, this.a.length());
                    this.a.append(this.a[this.M][this.L][this.aD]);
                    this.a = this.a.toString();
                    this.g = 0;
                    this.h = (short)(this.l / 2);
                    this.i = (short)(d.d[this.R][0] + d.d[this.R][1] * (this.aD + 1));
                    this.dM();
                    ++this.aD;
                }
            } else {
                this.aA = (byte)(33 + this.N);
                this.aC = 0;
                this.dH();
            }
        }
        if (this.R == 3) {
            this.aA = (byte)32;
            this.aC = 0;
            this.dH();
        }
    }

    final void cA() {
        if (this.R == 11) {
            this.h = (this.d * 2 - this.e + this.f * 5) * this.g / 10;
            if (this.h < 0) {
                this.h = 0;
            }
            this.aD = 0;
            while (this.aD < this.o.length) {
                this.g = 0;
                this.f = this.o[this.aD];
                this.i = (short)(d.d[this.R][0] + d.d[this.R][1] * this.aD);
                this.h = (short)((this.l - d.A[0]) / 2 - 2);
                if (this.aD == this.o.length - 1) {
                    this.i = (short)(this.i + 6);
                }
                this.dK();
                this.aE = this.d[this.az - 1];
                this.a.delete(0, this.a.length());
                if (this.aD == 0) {
                    this.a.append(this.d);
                }
                if (this.aD == 1) {
                    this.a.append(this.e);
                }
                if (this.aD == 2) {
                    this.a.append(this.f);
                }
                if (this.aD == 3) {
                    this.a.append(this.g);
                }
                if (this.aD == 4) {
                    this.a.append(this.h);
                }
                this.a = this.a.toString();
                this.g = (short)2;
                this.h = (short)((this.l + d.A[0]) / 2 + 2);
                this.dM();
                while (this.d[this.az - 1] + this.aE < d.A[0]) {
                    this.az = (byte)(this.az - 1);
                    this.a = "." + this.a;
                    this.dM();
                }
                ++this.aD;
            }
        }
        if (this.R == 20) {
            this.a.delete(0, this.a.length());
            this.a.append(this.aI[this.h[131] + this.U]);
            this.a = this.a.toString();
            this.g = 0;
            this.h = d.n[1];
            this.i = (short)(d.e[this.R][0] - b.b[0] / 2);
            this.dM();
        }
        if (this.R == 24) {
            if (this.aW == 0) {
                this.f = this.aI[this.h[135] + this.aV];
            }
            if (this.aW == 1) {
                this.f = this.aI[this.h[136] + this.aV];
            }
            this.g = 1;
            this.h = (short)(this.l / 2);
            this.i = (short)105;
            this.dK();
            this.cs();
        }
    }

    final void cB() {
        if (this.R == 25) {
            this.aD = 0;
            while (this.aD < this.u.length) {
                this.g[1][this.aD] = 0;
                this.aE = 0;
                while (this.aE < d.k[4]) {
                    int[] nArray = this.g[1];
                    int n = this.aD;
                    nArray[n] = nArray[n] + this.c[3 + this.aD][this.aE];
                    ++this.aE;
                }
                int[] nArray = this.g[1];
                int n = this.aD;
                nArray[n] = nArray[n] / d.k[4];
                this.g[0][this.aD] = this.aD;
                ++this.aD;
            }
            this.aD = 0;
            while (this.aD < this.u.length - 1) {
                this.aE = this.aD + 1;
                while (this.aE < this.u.length) {
                    if (this.g[1][this.aD] < this.g[1][this.aE]) {
                        this.aF = this.g[0][this.aD];
                        this.g[0][this.aD] = this.g[0][this.aE];
                        this.g[0][this.aE] = this.aF;
                        this.aF = this.g[1][this.aD];
                        this.g[1][this.aD] = this.g[1][this.aE];
                        this.g[1][this.aE] = this.aF;
                    }
                    ++this.aE;
                }
                ++this.aD;
            }
            this.aD = 0;
            while (this.aD < this.u.length) {
                this.g = 0;
                this.f = this.u[this.g[0][this.aD]];
                this.i = (short)(d.d[this.R][0] + d.d[this.R][1] * this.aD);
                this.h = (short)((this.l - d.A[0]) / 2 + 13);
                this.dK();
                this.aE = this.d[this.az - 1] + 15;
                this.a.delete(0, this.a.length());
                this.a.append(this.g[1][this.aD]);
                this.a = this.a.toString();
                this.g = (short)2;
                this.h = (short)((this.l + d.A[0]) / 2 + 2);
                this.dM();
                while (this.d[this.az - 1] + this.aE < d.A[0]) {
                    this.az = (byte)(this.az - 1);
                    this.a = "." + this.a;
                    this.dM();
                }
                ++this.aD;
            }
        }
    }

    final void cC() {
        this.c = this.b;
        if (this.b == 3 && this.R == 11) {
            this.S = 0;
            this.P = 0;
            this.aA = (byte)29;
        } else {
            this.cD();
            this.S = this.R;
            this.aA = this.aI[this.h[171 + this.c] + this.aG];
        }
        this.b = (byte)3;
        this.R = (byte)2;
        this.aC = 0;
        this.i[this.aA] = true;
        this.dH();
        this.cu();
        this.aa = (byte)5;
    }

    final void cD() {
        this.aG = 0;
        if (this.b == 2) {
            this.aG = this.aI[this.h[175] + this.B] + this.C;
        }
        if (this.b == 3) {
            this.aG = this.R;
            if (this.R == 26) {
                this.aG += this.P;
            }
        }
    }

    final void cE() {
        this.a[this.a].drawRegion(this.c[7], (int)b.i[0], (int)b.i[1], (int)b.i[2], (int)b.i[3], 0, this.l - 40, 2, 20);
        this.aH = this.c[2][d.k[4] + 1] == 0 ? 3 : 5 - (this.c[1][d.k[4] + 1] - 1) / 2;
        this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[71] + this.aH], (int)this.aI[this.h[72] + this.aH], (int)this.aI[this.h[73] + this.aH], (int)this.aI[this.h[74] + this.aH], 0, this.l - 40 + (b.i[2] - this.aI[this.h[73] + this.aH]) / 2, 2 + (b.i[3] - this.aI[this.h[74] + this.aH]) / 2, 20);
    }

    final void cF() {
        this.a[this.a].drawRegion(this.c[7], 73, 0, 16, 13, 0, (int)d.a[0], (int)d.b[0], 20);
        this.j = 1;
        this.a.delete(0, this.a.length());
        this.a.append(this.k);
        this.a = this.a.toString();
        this.g = 0;
        this.h = d.a[1];
        this.i = d.b[1];
        if (this.az == 0) {
            this.dM();
        } else {
            this.k = 0;
            this.dN();
        }
        this.j = 0;
        if (this.h >= 0) {
            this.a[this.a].setColor(0xFF0000);
            this.q = 0;
            while (this.q < 2) {
                this.a[this.a].drawRect(d.a[0] - 2 - this.q, d.b[0] - 2 - this.q, d.a[1] + this.d[0] + this.q * 2 - d.a[0] + 3, 13 + this.q * 2 + 3);
                ++this.q;
            }
            this.h = (byte)(this.h + 1);
            if (this.h >= this.u) {
                this.h = (byte)-1;
            }
        }
    }

    final void cG() {
        this.a[this.Y][this.Z] = 0;
        this.aI = this.Y * 5;
        while (this.aI < (this.Y + 1) * 5) {
            this.aJ = this.Z * 5;
            while (this.aJ < (this.Z + 1) * 5) {
                if (this.b[this.aI][this.aJ] == 0) {
                    short[] sArray = this.a[this.Y];
                    byte by = this.Z;
                    sArray[by] = (short)(sArray[by] + b.as[this.c[this.aI][this.aJ] / 4]);
                    short[] sArray2 = this.a[this.Y];
                    byte by2 = this.Z;
                    sArray2[by2] = (short)(sArray2[by2] + b.at[this.c[this.aI][this.aJ] % 4]);
                } else if (this.b[this.aI][this.aJ] < 0 && this.b[this.aI][this.aJ] > -15) {
                    short[] sArray = this.a[this.Y];
                    byte by = this.Z;
                    sArray[by] = (short)(sArray[by] + this.aI[this.h[90] + -1 - this.b[this.aI][this.aJ]]);
                }
                ++this.aJ;
            }
            ++this.aI;
        }
        short[] sArray = this.a[this.Y];
        byte by = this.Z;
        sArray[by] = (short)(sArray[by] / 3);
    }

    final void cH() {
        if (this.o != 23) {
            this.f[this.o] = (byte)(this.aA[this.o] / b.au[0] - this.al[this.o]);
            if (this.f[this.o] > 0) {
                int n = this.o;
                this.f[n] = (short)(this.f[n] * 10);
                return;
            }
            int n = this.o;
            this.f[n] = (short)(this.f[n] * 25);
            return;
        }
        this.g[5] = (byte)(9 - this.aE[5]);
        if (this.g[5] > 0) {
            this.g[5] = (short)(this.g[5] * 10);
            return;
        }
        this.g[5] = (short)(this.g[5] * 25);
    }

    final void cI() {
        if (this.aI[this.h[57] + this.o] < 0) {
            return;
        }
        this.g[this.aI[this.h[57] + this.o]] = 0;
        this.ba = 0;
        while (this.ba < this.ad) {
            byte by = this.aI[this.h[57] + this.o];
            this.g[by] = (short)(this.g[by] + this.aI[this.h[29] + this.o * (this.ad + 1) + this.ba] / b.au[this.ba]);
            this.ba = (byte)(this.ba + 1);
        }
        byte by = this.aI[this.h[57] + this.o];
        this.g[by] = (short)(this.g[by] - this.aE[this.aI[this.h[57] + this.o]]);
        if (this.g[this.aI[this.h[57] + this.o]] > 0) {
            byte by2 = this.aI[this.h[57] + this.o];
            this.g[by2] = (short)(this.g[by2] * 10);
            return;
        }
        byte by3 = this.aI[this.h[57] + this.o];
        this.g[by3] = (short)(this.g[by3] * 25);
    }

    protected final void keyPressed(int n) {
        if (this.n != 0 || !this.c) {
            return;
        }
        try {
            if (n == -6 || n == 6 || n == 42) {
                this.n = -6;
            } else if (n == -7 || n == 7 || n == 35) {
                this.n = -7;
            } else if (n == 48) {
                this.n = 48;
            } else if (n == 55) {
                this.a = !this.a;
            } else {
                this.p = this.getGameAction(n);
                if (this.p == 8 || n == 53) {
                    this.n = 5;
                } else if (this.p == 1 || n == 50) {
                    this.n = 1;
                } else if (this.p == 6 || n == 56) {
                    this.n = 2;
                } else if (this.p == 2 || n == 52) {
                    this.n = 4;
                } else if (this.p == 5 || n == 54) {
                    this.n = 3;
                }
            }
            this.p = false;
            this.aK = 0;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    protected final void keyReleased(int n) {
        try {
            this.p = true;
            if (this.aK > 0) {
                this.n = 0;
            }
            this.aK = 0;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void cJ() {
        this.aL = 0;
        while (this.aL < 90) {
            if (this.ak[this.aL] >= 0) {
                int n = this.aL;
                this.ak[n] = (byte)(this.ak[n] + 1);
                if (this.ak[this.aL] > 100) {
                    this.ak[this.aL] = 0;
                }
            }
            ++this.aL;
        }
    }

    final void cK() {
        try {
            this.aL = 0;
            while (this.aL < 42) {
                if (this.l[0][this.aL] >= 0) {
                    this.cL();
                    this.cN();
                    if (this.ag[this.aL] == 0 && this.Z[this.aL] != 22) {
                        int n = this.aL;
                        this.af[n] = (byte)(this.af[n] + 1);
                        if (this.ai[this.aL] == 2 && this.ac[this.aL] == 0) {
                            this.aM = 200;
                            while (this.aM < 222) {
                                if (this.A[this.aM] == 9 && this.B[this.aM] == this.n[0][this.aL] && this.C[this.aM] == this.n[1][this.aL]) {
                                    this.ay = this.aM;
                                    this.dp();
                                    this.d[this.aM] = -1;
                                    this.c[this.m[0][this.aL]][this.m[1][this.aL]] = (short)this.aM;
                                    this.ag[this.aL] = 4;
                                    this.ai[this.aL] = 3;
                                    this.af[this.aL] = 0;
                                    break;
                                }
                                ++this.aM;
                            }
                        } else if (this.ad[this.aL] > 0 && this.Z[this.aL] != 14 || this.Z[this.aL] == 14 && this.ad[this.aL] + this.ac[this.aL] > 1) {
                            this.cO();
                            this.af[this.aL] = 0;
                            this.ag[this.aL] = 1;
                        } else if (this.ac[this.aL] > 0 && this.af[this.aL] >= this.aw[this.Z[this.aL]]) {
                            this.af[this.aL] = 0;
                            this.ag[this.aL] = 3;
                        }
                        if (this.Z[this.aL] == 14 && this.af[this.aL] % 100 == 0 && this.ad[this.aL] == 1) {
                            this.ax = (byte)this.aL;
                            this.d(false);
                        }
                    }
                    this.cM();
                }
                ++this.aL;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void cL() {
        if (this.ag[this.aL] == 1 || this.ag[this.aL] == 2) {
            int n = this.aL;
            this.af[n] = (byte)(this.af[n] + 1);
            if (this.af[this.aL] == 5) {
                if (this.ag[this.aL] == 1) {
                    this.ay = this.e[this.aL][this.ac[this.aL] - 1];
                    this.dp();
                    this.d[this.ay] = this.c[this.B[this.ay]][this.C[this.ay]];
                    this.c[this.B[this.ay]][this.C[this.ay]] = (short)this.ay;
                    if (this.ac[this.aL] == this.au[this.Z[this.aL]]) {
                        this.af[this.aL] = 0;
                        this.ag[this.aL] = 3;
                        return;
                    }
                    this.ag[this.aL] = 0;
                    return;
                }
                this.af[this.aL] = 0;
                this.cQ();
                if (this.ac[this.aL] == 0) {
                    if (this.ah[this.aL] < 10) {
                        this.ax = (byte)this.aL;
                        this.d(true);
                        this.bi = 1;
                        this.dC();
                    }
                    this.ag[this.aL] = 0;
                    this.aj[this.aL] = -1;
                    return;
                }
                this.ay = this.e[this.aL][this.ac[this.aL] - 1];
                this.dp();
            }
        }
    }

    final void cM() {
        if (this.ag[this.aL] == 3) {
            int n = this.aL;
            this.af[n] = (byte)(this.af[n] + 1);
            int n2 = this.aL;
            this.ab[n2] = (byte)(this.ab[n2] + 1);
            if (this.ab[this.aL] >= this.as[this.Z[this.aL]]) {
                this.ab[this.aL] = 0;
            }
            if (this.Z[this.aL] != 23) {
                if (this.af[this.aL] >= this.am[this.Z[this.aL]] - 1 || this.aj[this.aL] == 0) {
                    this.ab[this.aL] = 0;
                    this.af[this.aL] = 0;
                    this.ag[this.aL] = 2;
                    this.ay = this.e[this.aL][this.ac[this.aL] - 1];
                    this.dp();
                }
                this.aM = 0;
                while (this.aM < this.ac[this.aL]) {
                    this.c[this.e[this.aL][this.aM]] = this.ab[this.aL];
                    if (this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][2] + 2] == 1) {
                        this.G[this.e[this.aL][this.aM]] = this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][21] + this.ab[this.aL] % this.at[this.Z[this.aL]] * this.au[this.Z[this.aL]] + (this.ab[this.aL] / this.at[this.Z[this.aL]] + this.aM) % this.au[this.Z[this.aL]]];
                    }
                    if (this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][2] + 3] == 1) {
                        this.H[this.e[this.aL][this.aM]] = this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][22] + this.ab[this.aL] % this.at[this.Z[this.aL]] * this.au[this.Z[this.aL]] + (this.ab[this.aL] / this.at[this.Z[this.aL]] + this.aM) % this.au[this.Z[this.aL]]];
                    }
                    if (this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][2] + 4] == 1) {
                        this.F[this.e[this.aL][this.aM]] = this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][23] + this.ab[this.aL] % this.at[this.Z[this.aL]] * this.au[this.Z[this.aL]] + (this.ab[this.aL] / this.at[this.Z[this.aL]] + this.aM) % this.au[this.Z[this.aL]]];
                    }
                    if (this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][2] + 5] == 1) {
                        this.J[this.e[this.aL][this.aM]] = this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][24] + this.ab[this.aL] % this.at[this.Z[this.aL]] * this.au[this.Z[this.aL]] + this.aM];
                    }
                    if (this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][3] + 2] == 0 && this.ag[this.aL] == 3 && (this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][35] + this.ab[this.aL] % this.at[this.Z[this.aL]] * 2 + 0] != 0 || this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][35] + this.ab[this.aL] % this.at[this.Z[this.aL]] * 2 + 1] != 0)) {
                        this.ay = this.e[this.aL][this.aM];
                        this.dp();
                        int n3 = this.ay;
                        this.B[n3] = (byte)(this.B[n3] + this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][35] + this.ab[this.aL] % this.at[this.Z[this.aL]] * 2 + 0]);
                        int n4 = this.ay;
                        this.C[n4] = (byte)(this.C[n4] + this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][35] + this.ab[this.aL] % this.at[this.Z[this.aL]] * 2 + 1]);
                        this.d[this.ay] = this.c[this.B[this.ay]][this.C[this.ay]];
                        this.c[this.B[this.ay]][this.C[this.ay]] = (short)this.ay;
                    }
                    ++this.aM;
                }
            }
        }
    }

    final void cN() {
        if (this.ag[this.aL] == 4) {
            int n = this.aL;
            this.af[n] = (byte)(this.af[n] + 1);
            if (this.af[this.aL] == this.l) {
                this.ag[this.aL] = 0;
                this.ai[this.aL] = 0;
                this.ah[this.aL] = 100;
                this.ay = this.c[this.m[0][this.aL]][this.m[1][this.aL]];
                this.c[this.n[0][this.aL]][this.n[1][this.aL]] = (short)this.ay;
                this.c[this.m[0][this.aL]][this.m[1][this.aL]] = -1;
                this.B[this.ay] = this.n[0][this.aL];
                this.C[this.ay] = this.n[1][this.aL];
                this.F[this.ay] = b.ao[this.aa[this.aL]];
                this.D[this.ay] = (byte)(this.B[this.ay] + this.aI[this.h[31] + this.F[this.ay] * 2 + 0]);
                this.E[this.ay] = (byte)(this.C[this.ay] + this.aI[this.h[31] + this.F[this.ay] * 2 + 1]);
                this.G[this.ay] = b.g[this.aa[this.aL]][0];
                this.H[this.ay] = b.g[this.aa[this.aL]][1];
                this.W[this.ay] = -1;
            }
        }
    }

    final void cO() {
        this.cP();
        this.aO = 1;
        while (this.aO < this.ad[this.aL]) {
            this.W[this.f[this.aL][this.aO]] = 9;
            ++this.aO;
        }
        this.ay = this.e[this.aL][this.ac[this.aL]];
        this.dp();
        this.B[this.ay] = (byte)(this.m[0][this.aL] + this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][35] + 0 + 0]);
        this.C[this.ay] = (byte)(this.m[1][this.aL] + this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][35] + 0 + 1]);
        if (this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][4] + 0] == 1) {
            this.G[this.ay] = this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][21] + 0 * this.au[this.Z[this.aL]] + this.ac[this.aL]];
            this.H[this.ay] = this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][22] + 0 * this.au[this.Z[this.aL]] + this.ac[this.aL]];
            this.F[this.ay] = this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][23] + 0 * this.au[this.Z[this.aL]] + this.ac[this.aL]];
            this.J[this.ay] = this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][2] + 5] == 1 ? this.o[this.Z[this.aL]][this.g[this.Z[this.aL]][24] + 0 * this.au[this.Z[this.aL]] + this.ac[this.aL]] : (byte)0;
        }
        int n = this.aL;
        this.ac[n] = (byte)(this.ac[n] + 1);
        this.ad[this.aL] = 0;
    }

    final void cP() {
        this.P[this.f[this.aL][0]] = this.a(this.P[this.f[this.aL][0]] + this.f[this.Z[this.aL]]);
        this.aT[0] = this.B[this.f[this.aL][0]];
        this.aT[1] = this.C[this.f[this.aL][0]];
        this.h = (short)((this.G[this.f[this.aL][0]] + this.H[this.f[this.aL][0]]) / b.Y[0] - this.aI[this.h[2] + this.A[this.f[this.aL][0]] * 12 + 0 + this.K[this.J[this.f[this.aL][0]]]] / 2);
        this.i = (short)(b.B[1] / 2 + (this.G[this.f[this.aL][0]] - this.H[this.f[this.aL][0]]) / b.Y[1] - this.aI[this.h[20] + this.A[this.f[this.aL][0]] * 4 + 0] - 15);
        this.k += this.b[this.f[this.aL][0]];
        this.d += this.b[this.f[this.aL][0]];
        short s = this.f[this.aL][0];
        this.L[s] = (byte)(this.L[s] - this.b[this.f[this.aL][0]]);
        this.a.delete(0, this.a.length());
        this.a.append("+");
        this.a.append(this.b[this.f[this.aL][0]]);
        this.a = this.a.toString();
        this.dL();
        this.b[this.f[this.aL][0]] = 0;
        this.e[this.aL][this.ac[this.aL]] = this.f[this.aL][0];
        this.c[this.e[this.aL][this.ac[this.aL]]] = 0;
        this.W[this.e[this.aL][this.ac[this.aL]]] = 13;
    }

    final void cQ() {
        int n = this.aL;
        this.ac[n] = (byte)(this.ac[n] - 1);
        this.ay = this.e[this.aL][this.ac[this.aL]];
        this.dp();
        this.B[this.e[this.aL][this.ac[this.aL]]] = this.n[0][this.aL];
        this.C[this.e[this.aL][this.ac[this.aL]]] = this.n[1][this.aL];
        this.d[this.ay] = this.c[this.B[this.ay]][this.C[this.ay]];
        this.c[this.B[this.ay]][this.C[this.ay]] = (short)this.ay;
        this.W[this.ay] = -1;
        this.P[this.ay] = this.a(this.P[this.ay] + this.aA[this.Z[this.aL]] - b.ap[this.aj[this.aL] + 1]);
        this.F[this.ay] = b.ao[this.aa[this.aL]];
        this.D[this.ay] = (byte)(this.B[this.ay] + this.aI[this.h[31] + this.F[this.ay] * 2 + 0]);
        this.E[this.ay] = (byte)(this.C[this.ay] + this.aI[this.h[31] + this.F[this.ay] * 2 + 1]);
        this.G[this.ay] = b.g[this.aa[this.aL]][0];
        this.H[this.ay] = b.g[this.aa[this.aL]][1];
        if (this.aA[this.Z[this.aL]] >= 30 && (this.a.nextInt() & 0xFFFF) % 100 < this.aA[this.Z[this.aL]]) {
            this.O[this.ay] = 0;
        }
        int n2 = this.aL;
        this.ah[n2] = (byte)(this.ah[n2] - (this.a.nextInt() & 0xFFFF) % this.ay[this.Z[this.aL]] / (20 - 7 * this.M));
    }

    final void cR() {
        this.aR = 5 + (this.c[1][d.k[4] + 1] - 6 - this.M) * (this.b * (2 + this.M) / 3) + this.aD[24] * 15 / this.al;
        if (this.ai > 0 && this.a > 0 && this.a > this.ai * 5) {
            this.aR /= this.a / (this.ai * 5);
        }
        if (this.aR < 3) {
            this.aR = 3;
        }
        if (this.aR > 80) {
            this.aR = 80;
        }
        if ((this.a.nextInt() & 0xFFF) % 100 >= this.aR) {
            return;
        }
        this.aL = 0;
        while (this.aL < 200) {
            if (this.B[this.aL] < 0) {
                this.A[this.aL] = (byte)((this.a.nextInt() & 0xFFF) % 8);
                this.B[this.aL] = this.ab;
                this.C[this.aL] = 0;
                this.D[this.aL] = this.ab;
                this.E[this.aL] = 1;
                this.F[this.aL] = 3;
                this.G[this.aL] = this.aI[this.h[36] + this.F[this.aL] * 2 + 0];
                this.H[this.aL] = -100;
                this.I[this.aL] = (byte)((this.a.nextInt() & 0xFFF) % 4 + 1);
                this.J[this.aL] = 1;
                this.W[this.aL] = -1;
                this.L[this.aL] = (byte)(60 + (this.a.nextInt() & 0xFFFF) % 40 - 20);
                this.b[this.aL] = 0;
                this.R[this.aL] = (byte)((this.a.nextInt() & 0xFFFF) % 60);
                this.Q[this.aL] = (byte)((this.a.nextInt() & 0xFFFF) % 60);
                this.P[this.aL] = (byte)(100 - (this.a.nextInt() & 0xFFFF) % 20);
                this.S[this.aL] = (byte)((this.a.nextInt() & 0xFFFF) % 20);
                this.T[this.aL] = (byte)((this.a.nextInt() & 0xFFFF) % 60);
                this.U[this.aL] = (byte)(100 - (this.a.nextInt() & 0xFFFF) % 20);
                this.V[this.aL] = (byte)((this.a.nextInt() & 0xFFFF) % 20);
                this.M[this.aL] = -1;
                this.N[this.aL] = -1;
                this.O[this.aL] = -1;
                this.c[this.aL] = 0;
                this.d[this.aL] = this.c[this.B[this.aL]][this.C[this.aL]];
                this.c[this.B[this.aL]][this.C[this.aL]] = (short)this.aL;
                this.f[0][this.aL] = -1;
                this.f[1][this.aL] = -1;
                this.f[2][this.aL] = 0;
                this.a = (short)(this.a + 1);
                ++this.f;
                return;
            }
            ++this.aL;
        }
    }

    final void cS() {
        this.ay = this.aL;
        this.dp();
        this.B[this.aL] = -1;
        this.a = (short)(this.a - 1);
    }

    final void cT() {
        try {
            this.aL = 0;
            while (this.aL < 222) {
                if (this.B[this.aL] >= 0) {
                    this.cU();
                    if (this.W[this.aL] > -1 && this.W[this.aL] < 9) {
                        this.cV();
                    } else {
                        this.de();
                        if (this.W[this.aL] < 11 || this.W[this.aL] == 18) {
                            this.df();
                            if (this.A[this.aL] != 10) {
                                this.dg();
                            }
                        }
                        this.dh();
                        if (this.W[this.aL] == 10 && this.b[this.D[this.aL]][this.E[this.aL]] != 13) {
                            if (this.b[this.D[this.aL]][this.E[this.aL]] == 7 && this.G[this.aL] > 15) {
                                this.G[this.aL] = 20;
                            }
                            if (this.b[this.D[this.aL]][this.E[this.aL]] == 8 && this.H[this.aL] < 4) {
                                this.H[this.aL] = -1;
                            }
                        }
                        if (this.W[this.aL] == 12 && this.c[this.aL] == 100) {
                            this.di();
                            byte by = this.c[this.B[this.aL]][this.C[this.aL]];
                            this.ac[by] = (byte)(this.ac[by] - 1);
                        } else {
                            this.dj();
                            this.dk();
                            this.dl();
                        }
                    }
                }
                ++this.aL;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void cU() {
        if (this.W[this.aL] != 13) {
            int n = this.aL;
            this.c[n] = (short)(this.c[n] + 1);
        }
        if (this.aL < 200) {
            if (this.O[this.aL] >= 0) {
                int n = this.aL;
                this.O[n] = (byte)(this.O[n] + 1);
            }
            if (this.O[this.aL] >= this.v) {
                this.O[this.aL] = -1;
            }
        }
        if (this.aL < 200 && this.W[this.aL] != 13 && this.W[this.aL] != 18) {
            this.aM = 0;
            while (this.aM < this.ae) {
                this.aP = this.b[this.M][this.aM];
                if (this.aM == 0) {
                    this.aP += this.a[this.B[this.aL] / 5][this.C[this.aL] / 5];
                }
                if (this.c[this.aL] % this.aP == 0) {
                    if (b.ar[this.aM] == 0 && this.g[this.aM][this.aL] > 0) {
                        byte[] byArray = this.g[this.aM];
                        int n = this.aL;
                        byArray[n] = (byte)(byArray[n] - 1);
                    }
                    if (b.ar[this.aM] == 1 && this.g[this.aM][this.aL] < 100) {
                        byte[] byArray = this.g[this.aM];
                        int n = this.aL;
                        byArray[n] = (byte)(byArray[n] + 1);
                    }
                }
                ++this.aM;
            }
            if (this.c[this.aL] % this.q == 0) {
                this.e(true);
            }
        }
    }

    final void cV() {
        if (this.W[this.aL] < 7) {
            this.dc();
            return;
        }
        if (this.W[this.aL] == 7 || this.W[this.aL] == 8) {
            int n = this.aL;
            this.G[n] = (byte)(this.G[n] + this.aI[this.h[31] + this.X[this.aL] * 2 + 0] * this.I[this.aL]);
            int n2 = this.aL;
            this.H[n2] = (byte)(this.H[n2] + this.aI[this.h[31] + this.X[this.aL] * 2 + 1] * this.I[this.aL]);
            int n3 = this.aL;
            this.J[n3] = (byte)(this.J[n3] + 1);
            if (this.J[this.aL] > 3) {
                this.J[this.aL] = 0;
            }
            if (this.W[this.aL] == 7) {
                this.dd();
                return;
            }
            if (this.W[this.aL] == 8) {
                this.aM = (this.H[this.aL] - this.aI[this.h[35] + this.h[1][this.aL] * 4 + this.aI[this.h[104] + this.X[this.aL]] + 1]) * this.aI[this.h[31] + this.X[this.aL] * 2 + this.aI[this.h[104] + this.X[this.aL]]];
                if (this.aM >= 0) {
                    this.H[this.aL] = this.aI[this.h[35] + this.h[1][this.aL] * 4 + this.aI[this.h[104] + this.X[this.aL]] + 1];
                    this.X[this.aL] = this.aI[this.h[35] + this.h[1][this.aL] * 4 + 3];
                    int n4 = this.aL;
                    this.H[n4] = (byte)(this.H[n4] + this.aM * this.aI[this.h[31] + this.X[this.aL] * 2 + this.aI[this.h[104] + this.X[this.aL]]]);
                    byte[] byArray = this.h[1];
                    int n5 = this.aL;
                    byArray[n5] = (byte)(byArray[n5] + 1);
                    if (this.h[1][this.aL] == 4) {
                        this.da();
                        return;
                    }
                }
                this.db();
            }
        }
    }

    final void cW() {
        if (this.aM >= 0) {
            this.e[this.aI[this.h[104] + this.X[this.aL]]][this.aL] = this.aI[this.h[this.q[this.h[0][this.aL]][this.h[2][this.aL]]] + this.aQ * 16 + this.h[1][this.aL] * 4 + this.aI[this.h[104] + this.X[this.aL]] + 1];
            this.X[this.aL] = this.aI[this.h[this.q[this.h[0][this.aL]][this.h[2][this.aL]]] + this.aQ * 16 + this.h[1][this.aL] * 4 + 3];
            byte[] byArray = this.e[this.aI[this.h[104] + this.X[this.aL]]];
            int n = this.aL;
            byArray[n] = (byte)(byArray[n] + this.aM * this.aI[this.h[31] + this.X[this.aL] * 2 + this.aI[this.h[104] + this.X[this.aL]]]);
            byte[] byArray2 = this.h[1];
            int n2 = this.aL;
            byArray2[n2] = (byte)(byArray2[n2] + 1);
            if (this.h[0][this.aL] == 0 && this.h[1][this.aL] == this.r[this.h[2][this.aL]][this.aQ] + this.aI[this.h[102] + this.W[this.aL]]) {
                this.e[this.aI[this.h[104] + this.X[this.aL]]][this.aL] = this.aI[this.h[this.q[this.h[0][this.aL]][this.h[2][this.aL]]] + this.aQ * 16 + (this.h[1][this.aL] - 1) * 4 + this.aI[this.h[104] + this.X[this.aL]] + 1];
                this.h[1][this.aL] = 0;
                byte[] byArray3 = this.h[0];
                int n3 = this.aL;
                byArray3[n3] = (byte)(byArray3[n3] + 1);
                this.c[this.aL] = 0;
                this.J[this.aL] = 0;
                this.cX();
                return;
            }
            if (this.h[0][this.aL] == 2) {
                this.W[this.aL] = -1;
                this.F[this.aL] = this.X[this.aL];
            }
        }
    }

    final void cX() {
        if (this.W[this.aL] == 6 && this.e[this.c[this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 0] * 2 + 0]][this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 0] * 2 + 1]]]) {
            this.X[this.aL] = this.aI[this.h[30] + this.X[this.aL] * 4 + 2];
            this.h[1][this.aL] = 0;
            byte[] byArray = this.h[0];
            int n = this.aL;
            byArray[n] = (byte)(byArray[n] + 1);
        } else if (this.W[this.aL] == 4 || this.W[this.aL] == 6) {
            this.e[this.c[this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 0] * 2 + 0]][this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 0] * 2 + 1]]] = true;
        }
        if (this.W[this.aL] == 4) {
            this.d[this.c[this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 0] * 2 + 0]][this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 0] * 2 + 1]]] = false;
        }
        if (this.W[this.aL] == 1) {
            this.aP = this.c[this.B[this.aL]][this.C[this.aL]];
            this.aQ = 0;
            do {
                if (this.G[this.aP] == this.aI[this.h[11] + this.h[2][this.aL] * 4 + 0 + 0] && this.H[this.aP] == this.aI[this.h[11] + this.h[2][this.aL] * 4 + 0 + 1] && this.aP != this.aL) {
                    ++this.aQ;
                    break;
                }
                this.aP = this.d[this.aP];
            } while (this.aP >= 0);
            this.G[this.aL] = this.aI[this.h[11] + this.h[2][this.aL] * 4 + this.aQ * 2 + 0];
            this.H[this.aL] = this.aI[this.h[11] + this.h[2][this.aL] * 4 + this.aQ * 2 + 1];
        }
    }

    final void cY() {
        if (this.c[this.aL] >= this.aI[this.h[this.q[1][0]] + this.W[this.aL] * 4 + 1]) {
            if (this.W[this.aL] != 1) {
                this.bc = this.b[this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 0] * 2 + 0]][this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 0] * 2 + 1]];
                if (this.W[this.aL] == 4 || this.W[this.aL] == 6) {
                    this.e[this.c[this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 0] * 2 + 0]][this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 0] * 2 + 1]]] = false;
                }
                if (this.W[this.aL] == 4) {
                    this.d[this.c[this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 0] * 2 + 0]][this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 0] * 2 + 1]]] = true;
                }
                this.aM = 0;
                while (this.aM < this.ad) {
                    this.g[this.aM][this.aL] = b.ar[this.aM] == 0 ? this.a(this.g[this.aM][this.aL] + this.aI[this.h[29] + (-1 - this.bc) * (this.ad + 1) + this.aM]) : this.a(this.g[this.aM][this.aL] - this.aI[this.h[29] + (-1 - this.bc) * (this.ad + 1) + this.aM]);
                    ++this.aM;
                }
                if (this.W[this.aL] == 5) {
                    this.M[this.aL] = (byte)((this.a.nextInt() & 0xFFFF) % 5);
                }
            }
            this.X[this.aL] = this.aI[this.h[30] + this.X[this.aL] * 4 + 2];
            this.h[1][this.aL] = 0;
            byte[] byArray = this.h[0];
            int n = this.aL;
            byArray[n] = (byte)(byArray[n] + 1);
            if (this.W[this.aL] == 1) {
                int n2 = this.aL;
                this.Q[n2] = (byte)(this.Q[n2] - 50);
                if (this.h[2][this.aL] == 0) {
                    this.H[this.aL] = this.aI[this.h[this.q[this.h[0][this.aL]][this.h[2][this.aL]]] + this.F[this.aL] * 16 + this.h[1][this.aL] * 4 + 2];
                    return;
                }
                this.G[this.aL] = this.aI[this.h[this.q[this.h[0][this.aL]][this.h[2][this.aL]]] + this.F[this.aL] * 16 + this.h[1][this.aL] * 4 + 1];
            }
        }
    }

    final void cZ() {
        if (this.b[this.aL] > 0 && this.h[0][this.aL] != 1) {
            this.aT[0] = this.B[this.aL];
            this.aT[1] = this.C[this.aL];
            this.h = (short)((this.G[this.aL] + this.H[this.aL]) / b.Y[0] - this.aI[this.h[2] + this.A[this.aL] * 12 + 0 + this.K[this.J[this.aL]]] / 2);
            this.i = (short)(b.B[1] / 2 + (this.G[this.aL] - this.H[this.aL]) / b.Y[1] - this.aI[this.h[20] + this.A[this.aL] * 4 + 0] - 15);
            int n = this.aL;
            this.L[n] = (byte)(this.L[n] - this.b[this.aL]);
            this.k += this.b[this.aL];
            this.d += this.b[this.aL];
            this.a.delete(0, this.a.length());
            this.a.append("+");
            this.a.append(this.b[this.aL]);
            this.a = this.a.toString();
            this.b[this.aL] = 0;
            this.dL();
            this.P[this.aL] = this.a(this.P[this.aL] + this.g[this.aI[this.h[57] + -1 - this.b[this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 2] * 2 + 0]][this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aL] * 4 + 2] * 2 + 1]]]]);
        }
    }

    final void da() {
        this.W[this.aL] = -1;
        this.F[this.aL] = 1;
        this.J[this.aL] = 0;
        this.c[this.aL] = 1;
        this.G[this.aL] = this.aI[this.h[78] + 2];
        this.H[this.aL] = this.aI[this.h[78] + 3];
        this.ay = this.aL;
        this.dp();
        this.B[this.aL] = (byte)(this.l[0][this.c[this.B[this.aL]][this.C[this.aL]]] + this.aI[this.h[78] + 0]);
        this.C[this.aL] = (byte)(this.l[1][this.c[this.B[this.aL]][this.C[this.aL]]] + this.aI[this.h[78] + 1]);
        this.d[this.aL] = this.c[this.B[this.aL]][this.C[this.aL]];
        this.c[this.B[this.aL]][this.C[this.aL]] = (short)this.aL;
    }

    final void db() {
        if (this.G[this.aL] >= 20 || this.H[this.aL] >= 20 || this.G[this.aL] < 0 || this.H[this.aL] < 0) {
            int n = this.aL;
            this.G[n] = (byte)(this.G[n] - 20 * this.aI[this.h[31] + this.X[this.aL] * 2 + 0]);
            int n2 = this.aL;
            this.H[n2] = (byte)(this.H[n2] - 20 * this.aI[this.h[31] + this.X[this.aL] * 2 + 1]);
            this.ay = this.aL;
            this.dp();
            this.B[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.X[this.aL] * 2 + 0]);
            this.C[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.X[this.aL] * 2 + 1]);
            this.d[this.aL] = this.c[this.B[this.aL]][this.C[this.aL]];
            this.c[this.B[this.aL]][this.C[this.aL]] = (short)this.aL;
        }
    }

    final void dc() {
        this.aQ = this.h[0][this.aL] != 1 ? this.F[this.aL] : 0;
        if (this.h[0][this.aL] != 1) {
            int n = this.aL;
            this.G[n] = (byte)(this.G[n] + this.aI[this.h[31] + this.X[this.aL] * 2 + 0] * this.I[this.aL]);
            int n2 = this.aL;
            this.H[n2] = (byte)(this.H[n2] + this.aI[this.h[31] + this.X[this.aL] * 2 + 1] * this.I[this.aL]);
            int n3 = this.aL;
            this.J[n3] = (byte)(this.J[n3] + 1);
            if (this.J[this.aL] > 3) {
                this.J[this.aL] = 0;
            }
            this.aM = (this.e[this.aI[this.h[104] + this.X[this.aL]]][this.aL] - this.aI[this.h[this.q[this.h[0][this.aL]][this.h[2][this.aL]]] + this.aQ * 16 + this.h[1][this.aL] * 4 + this.aI[this.h[104] + this.X[this.aL]] + 1]) * this.aI[this.h[31] + this.X[this.aL] * 2 + this.aI[this.h[104] + this.X[this.aL]]];
            this.cW();
            return;
        }
        this.cY();
        this.cZ();
    }

    final void dd() {
        this.aM = (this.e[this.aI[this.h[104] + this.X[this.aL]]][this.aL] - this.aI[this.h[this.aK[this.h[2][this.aL]]] + this.F[this.aL] * 12 + this.h[1][this.aL] * 4 + this.aI[this.h[104] + this.X[this.aL]] + 1]) * this.aI[this.h[31] + this.X[this.aL] * 2 + this.aI[this.h[104] + this.X[this.aL]]];
        if (this.aM >= 0) {
            this.e[this.aI[this.h[104] + this.X[this.aL]]][this.aL] = this.aI[this.h[this.aK[this.h[2][this.aL]]] + this.F[this.aL] * 12 + this.h[1][this.aL] * 4 + this.aI[this.h[104] + this.X[this.aL]] + 1];
            this.X[this.aL] = this.aI[this.h[this.aK[this.h[2][this.aL]]] + this.F[this.aL] * 12 + this.h[1][this.aL] * 4 + 3];
            byte[] byArray = this.e[this.aI[this.h[104] + this.X[this.aL]]];
            int n = this.aL;
            byArray[n] = (byte)(byArray[n] + this.aM * this.aI[this.h[31] + this.X[this.aL] * 2 + this.aI[this.h[104] + this.X[this.aL]]]);
            byte[] byArray2 = this.h[1];
            int n2 = this.aL;
            byArray2[n2] = (byte)(byArray2[n2] + 1);
            if (this.h[1][this.aL] == this.r[this.h[2][this.aL]][this.F[this.aL]]) {
                this.W[this.aL] = -1;
                this.F[this.aL] = this.X[this.aL];
            }
        }
    }

    final void de() {
        if (this.g / 4 == 0 && this.e == 0 && this.W[this.aL] == -1 && this.aL < 200) {
            this.dy();
        }
        if (this.W[this.aL] == 9) {
            if (this.Z[this.c[this.B[this.aL]][this.C[this.aL]]] != 23) {
                if (this.aa[this.c[this.B[this.aL]][this.C[this.aL]]] == 0) {
                    this.aM = this.G[this.aL] - 4;
                    if (this.C[this.aL] != this.ae[this.c[this.B[this.aL]][this.C[this.aL]]] || this.H[this.aL] != 10) {
                        this.aM += (this.ae[this.c[this.B[this.aL]][this.C[this.aL]]] - this.C[this.aL]) * 20 + 10 - this.H[this.aL];
                    }
                } else {
                    this.aM = 19 - this.H[this.aL] - 4;
                    if (this.B[this.aL] != this.ae[this.c[this.B[this.aL]][this.C[this.aL]]] || this.G[this.aL] != 10) {
                        this.aM += (this.B[this.aL] - this.ae[this.c[this.B[this.aL]][this.C[this.aL]]]) * 20 - 10 + this.G[this.aL];
                    }
                }
                if (this.ad[this.c[this.B[this.aL]][this.C[this.aL]]] * 6 >= this.aM) {
                    this.ds();
                    return;
                }
            } else {
                if (this.b[this.B[this.aL]][this.C[this.aL]] == 5 && this.G[this.aL] < 6) {
                    this.G[this.aL] = -1;
                }
                if (this.b[this.B[this.aL]][this.C[this.aL]] == 6 && this.H[this.aL] > 13) {
                    this.H[this.aL] = 20;
                }
            }
        }
    }

    final void df() {
        if (this.A[this.aL] != 10) {
            if (this.W[this.aL] == 10) {
                this.J[this.aL] = 0;
                int n = this.aL;
                this.G[n] = (byte)(this.G[n] + this.aI[this.h[31] + this.F[this.aL] * 2 + 0] * 2);
                int n2 = this.aL;
                this.H[n2] = (byte)(this.H[n2] + this.aI[this.h[31] + this.F[this.aL] * 2 + 1] * 2);
                return;
            }
            int n = this.aL;
            this.G[n] = (byte)(this.G[n] + this.aI[this.h[31] + this.F[this.aL] * 2 + 0] * this.I[this.aL]);
            int n3 = this.aL;
            this.H[n3] = (byte)(this.H[n3] + this.aI[this.h[31] + this.F[this.aL] * 2 + 1] * this.I[this.aL]);
            int n4 = this.aL;
            this.J[n4] = (byte)(this.J[n4] + 1);
            if (this.J[this.aL] > 3) {
                this.J[this.aL] = 0;
                return;
            }
        } else if (this.ac[this.c[this.B[this.aL]][this.C[this.aL]]] > 0 && this.c[this.aL] % this.aw[23] == 0) {
            this.W[this.aL] = 8;
            this.h[1][this.aL] = 0;
            this.X[this.aL] = 0;
            this.G[this.aL] = this.aI[this.h[79] + 2];
            this.H[this.aL] = this.aI[this.h[79] + 3];
            this.ay = this.aL;
            this.dp();
            this.B[this.aL] = (byte)(this.l[0][this.c[this.B[this.aL]][this.C[this.aL]]] + this.aI[this.h[79] + 0]);
            this.C[this.aL] = (byte)(this.l[1][this.c[this.B[this.aL]][this.C[this.aL]]] + this.aI[this.h[79] + 1]);
            this.d[this.aL] = this.c[this.B[this.aL]][this.C[this.aL]];
            this.c[this.B[this.aL]][this.C[this.aL]] = (short)this.aL;
        }
    }

    final void dg() {
        if (this.W[this.aL] == -1 || this.W[this.aL] == 18) {
            this.aM = (this.e[this.aI[this.h[104] + this.F[this.aL]]][this.aL] - this.aI[this.h[12] + 0 + this.F[this.aL] * 2 + this.aI[this.h[104] + this.F[this.aL]]]) * this.aI[this.h[31] + this.F[this.aL] * 2 + this.aI[this.h[104] + this.F[this.aL]]];
            if (this.aM >= 0 && this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 1] * 2 + 0] == this.D[this.aL] && this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 1] * 2 + 1] == this.E[this.aL]) {
                this.e[this.aI[this.h[104] + this.F[this.aL]]][this.aL] = this.aI[this.h[12] + 0 + this.F[this.aL] * 2 + this.aI[this.h[104] + this.F[this.aL]]];
                this.F[this.aL] = this.aI[this.h[30] + this.F[this.aL] * 4 + 1];
                byte[] byArray = this.e[this.aI[this.h[104] + this.F[this.aL]]];
                int n = this.aL;
                byArray[n] = (byte)(byArray[n] + this.aM * this.aI[this.h[31] + this.F[this.aL] * 2 + this.aI[this.h[104] + this.F[this.aL]]]);
            }
            this.aM = (this.e[this.aI[this.h[104] + this.F[this.aL]]][this.aL] - this.aI[this.h[12] + 8 + this.F[this.aL] * 2 + this.aI[this.h[104] + this.F[this.aL]]]) * this.aI[this.h[31] + this.F[this.aL] * 2 + this.aI[this.h[104] + this.F[this.aL]]];
            if (this.aM >= 0 && (this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 3] * 2 + 0] == this.D[this.aL] && this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 3] * 2 + 1] == this.E[this.aL] || this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 2] * 2 + 0] == this.D[this.aL] && this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 2] * 2 + 1] == this.E[this.aL] || this.D[this.aL] < 0)) {
                this.e[this.aI[this.h[104] + this.F[this.aL]]][this.aL] = this.aI[this.h[12] + 8 + this.F[this.aL] * 2 + this.aI[this.h[104] + this.F[this.aL]]];
                this.F[this.aL] = this.aI[this.h[30] + this.F[this.aL] * 4 + 3];
                byte[] byArray = this.e[this.aI[this.h[104] + this.F[this.aL]]];
                int n = this.aL;
                byArray[n] = (byte)(byArray[n] + this.aM * this.aI[this.h[31] + this.F[this.aL] * 2 + this.aI[this.h[104] + this.F[this.aL]]]);
                if (this.D[this.aL] < 0) {
                    this.dq();
                    return;
                }
            }
        } else {
            this.aM = (this.e[this.aI[this.h[104] + this.F[this.aL]]][this.aL] - 10) * this.aI[this.h[31] + this.F[this.aL] * 2 + this.aI[this.h[104] + this.F[this.aL]]];
            if (this.aM >= 0) {
                if (this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 1] * 2 + 0] == this.D[this.aL] && this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 1] * 2 + 1] == this.E[this.aL]) {
                    this.e[this.aI[this.h[104] + this.F[this.aL]]][this.aL] = 10;
                    this.F[this.aL] = this.aI[this.h[30] + this.F[this.aL] * 4 + 1];
                    byte[] byArray = this.e[this.aI[this.h[104] + this.F[this.aL]]];
                    int n = this.aL;
                    byArray[n] = (byte)(byArray[n] + this.aM * this.aI[this.h[31] + this.F[this.aL] * 2 + this.aI[this.h[104] + this.F[this.aL]]]);
                }
                if (this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 3] * 2 + 0] == this.D[this.aL] && this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 3] * 2 + 1] == this.E[this.aL]) {
                    this.e[this.aI[this.h[104] + this.F[this.aL]]][this.aL] = 10;
                    this.F[this.aL] = this.aI[this.h[30] + this.F[this.aL] * 4 + 3];
                    byte[] byArray = this.e[this.aI[this.h[104] + this.F[this.aL]]];
                    int n = this.aL;
                    byArray[n] = (byte)(byArray[n] + this.aM * this.aI[this.h[31] + this.F[this.aL] * 2 + this.aI[this.h[104] + this.F[this.aL]]]);
                }
            }
        }
    }

    final void dh() {
        if (this.W[this.aL] == 14) {
            this.G[this.aL] = this.o[22][this.g[22][21] + this.F[this.aL] * 11 + this.c[this.aL]];
            this.H[this.aL] = this.o[22][this.g[22][22] + this.F[this.aL] * 11 + this.c[this.aL]];
            int n = this.aL;
            this.J[n] = (byte)(this.J[n] + 1);
            if (this.J[this.aL] > 3) {
                this.J[this.aL] = 0;
            }
            if (this.c[this.aL] >= this.as[22]) {
                this.ay = this.aL;
                this.dp();
                this.B[this.aL] = this.D[this.aL];
                this.C[this.aL] = this.E[this.aL];
                this.d[this.aL] = this.c[this.B[this.aL]][this.C[this.aL]];
                this.c[this.B[this.aL]][this.C[this.aL]] = (short)this.aL;
                if (this.b[this.B[this.aL]][this.C[this.aL]] == 13) {
                    this.P[this.aL] = this.a(this.P[this.aL] + this.f[22]);
                    this.W[this.aL] = 10;
                    this.aT[0] = this.B[this.aL];
                    this.aT[1] = this.C[this.aL];
                    this.h = (short)((this.G[this.aL] + this.H[this.aL]) / b.Y[0] - this.aI[this.h[2] + this.A[this.aL] * 12 + 0 + this.K[this.J[this.aL]]] / 2);
                    this.i = (short)(b.B[1] / 2 + (this.G[this.aL] - this.H[this.aL]) / b.Y[1] - this.aI[this.h[20] + this.A[this.aL] * 4 + 0] - 15);
                    this.k += this.b[this.aL];
                    this.d += this.b[this.aL];
                    int n2 = this.aL;
                    this.L[n2] = (byte)(this.L[n2] - this.b[this.aL]);
                    this.a.delete(0, this.a.length());
                    this.a.append("+");
                    this.a.append(this.b[this.aL]);
                    this.a = this.a.toString();
                    this.dL();
                    this.b[this.aL] = 0;
                } else {
                    this.W[this.aL] = -1;
                }
                this.dq();
            }
        }
    }

    final void di() {
        this.ay = this.aL;
        this.dp();
        this.aT[0] = this.B[this.aL];
        this.aT[1] = this.C[this.aL];
        this.h = (short)(this.aI[this.h[27] + (this.B[this.aL] - this.l[0][this.c[this.B[this.aL]][this.C[this.aL]]]) * 4 + this.H[this.aL]] - this.aI[this.h[43] + this.A[this.aL]] / 2);
        this.i = (short)(this.aI[this.h[28] + (this.B[this.aL] - this.l[0][this.c[this.B[this.aL]][this.C[this.aL]]]) * 4 + this.H[this.aL]] - this.aI[this.h[44] + this.A[this.aL]] - 15);
        int n = this.aL;
        this.L[n] = (byte)(this.L[n] - this.b[this.aL]);
        this.k += this.b[this.aL];
        this.d += this.b[this.aL];
        this.a.delete(0, this.a.length());
        this.a.append("+");
        this.a.append(this.b[this.aL]);
        this.a = this.a.toString();
        this.b[this.aL] = 0;
        this.dL();
        this.F[this.aL] = this.aa[this.c[this.B[this.aL]][this.C[this.aL]]];
        this.B[this.aL] = (byte)(this.l[0][this.c[this.B[this.aL]][this.C[this.aL]]] + this.aI[this.h[77] + 0]);
        this.C[this.aL] = (byte)(this.l[1][this.c[this.B[this.aL]][this.C[this.aL]]] + this.aI[this.h[77] + 1]);
        this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.F[this.aL] * 2 + 0]);
        this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.F[this.aL] * 2 + 1]);
        this.d[this.aL] = this.c[this.B[this.aL]][this.C[this.aL]];
        this.c[this.B[this.aL]][this.C[this.aL]] = (short)this.aL;
        this.G[this.aL] = b.f[this.F[this.aL]][0];
        this.H[this.aL] = b.f[this.F[this.aL]][1];
        this.Q[this.aL] = this.a(this.Q[this.aL] - 50);
        this.R[this.aL] = this.a(this.R[this.aL] - 60);
        this.T[this.aL] = this.a(this.T[this.aL] - 60);
        this.W[this.aL] = -1;
        this.aO = 0;
        while (this.aO < this.au[23]) {
            if (this.e[this.c[this.B[this.aL]][this.C[this.aL]]][this.aO] == this.aL) {
                this.e[this.c[this.B[this.aL]][this.C[this.aL]]][this.aO] = -1;
                return;
            }
            ++this.aO;
        }
    }

    final void dj() {
        if (this.W[this.aL] == 15 || this.W[this.aL] == 16) {
            int n = this.aL;
            this.J[n] = (byte)(this.J[n] + 1);
            if (this.J[this.aL] > 3) {
                this.J[this.aL] = 0;
            }
            if (this.W[this.aL] == 15) {
                byte[] byArray = this.h[0];
                int n2 = this.aL;
                byArray[n2] = (byte)(byArray[n2] + ((this.a.nextInt() & 0xFFFF) % 3 - 1));
                byte[] byArray2 = this.h[1];
                int n3 = this.aL;
                byArray2[n3] = (byte)(byArray2[n3] + ((this.a.nextInt() & 0xFFFF) % 3 - 1));
                if (this.h[0][this.aL] < -2) {
                    this.h[0][this.aL] = -2;
                }
                if (this.h[0][this.aL] > 2) {
                    this.h[0][this.aL] = 2;
                }
                if (this.h[1][this.aL] < -2) {
                    this.h[1][this.aL] = -2;
                }
                if (this.h[1][this.aL] > 2) {
                    this.h[1][this.aL] = 2;
                }
            }
            if (this.c[this.aL] >= this.r) {
                if (this.W[this.aL] == 15) {
                    this.aN = this.aL;
                    this.aL = this.c[this.B[this.aN]][this.C[this.aN]];
                    while (this.aL >= 0) {
                        if (this.W[this.aL] == 17) {
                            this.W[this.aL] = -1;
                            this.bj = 1;
                            this.dF();
                            this.dq();
                        }
                        this.aL = this.d[this.aL];
                    }
                    this.aL = this.aN;
                }
                this.W[this.aL] = -1;
                this.V[this.aL] = 0;
                this.bj = 0;
                this.dF();
            }
        }
    }

    final void dk() {
        if (this.A[this.aL] == 8) {
            this.aM = this.c[this.B[this.aL]][this.C[this.aL]];
            while (this.aM >= 0) {
                if (this.aM < 200) {
                    if (this.W[this.aM] == 15 || this.W[this.aM] == 16) {
                        this.c[this.aM] = this.r;
                    } else {
                        this.V[this.aM] = 0;
                    }
                }
                this.aM = this.d[this.aM];
            }
        }
        if (this.A[this.aL] == 9 && this.W[this.aL] == -1 && this.b[this.B[this.aL]][this.C[this.aL]] > 3 && this.F[this.aL] > 1 && (this.aa[this.c[this.B[this.aL]][this.C[this.aL]]] == 0 && this.H[this.aL] >= 15 || this.aa[this.c[this.B[this.aL]][this.C[this.aL]]] == 1 && this.G[this.aL] <= 4)) {
            this.J[this.aL] = 0;
            this.W[this.aL] = 17;
            this.ai[this.c[this.B[this.aL]][this.C[this.aL]]] = 2;
        }
    }

    final void dl() {
        if (!(this.W[this.aL] >= 11 && this.W[this.aL] != 18 || this.A[this.aL] == 10 || this.G[this.aL] < 20 && this.H[this.aL] < 20 && this.G[this.aL] >= 0 && this.H[this.aL] >= 0)) {
            if (this.B[this.aL] != this.ab || this.C[this.aL] != 0 || this.H[this.aL] >= 0) {
                if (this.G[this.aL] == 10 || this.H[this.aL] == 10) {
                    if (this.b[this.B[this.aL]][this.C[this.aL]] == 0 && (this.F[this.aL] == 2 && this.b[this.D[this.aL]][this.E[this.aL]] != 5 || this.F[this.aL] == 3 && this.b[this.D[this.aL]][this.E[this.aL]] != 6 || this.f[0][this.aL] != this.Z[this.c[this.D[this.aL]][this.E[this.aL]]])) {
                        this.dw();
                        return;
                    }
                    if (!(this.c[this.c[this.D[this.aL]][this.E[this.aL]]] && this.b[this.c[this.D[this.aL]][this.E[this.aL]]] && this.a[this.c[this.D[this.aL]][this.E[this.aL]]] && this.ah[this.c[this.D[this.aL]][this.E[this.aL]]] >= 10 || this.W[this.aL] != 9)) {
                        this.W[this.aL] = -1;
                        this.dw();
                        return;
                    }
                } else if (this.b[this.B[this.aL]][this.C[this.aL]] == 0 && this.b[this.D[this.aL]][this.E[this.aL]] != 0) {
                    if (this.A[this.aL] != 9) {
                        this.dw();
                        return;
                    }
                    this.w = true;
                    if (this.b[this.D[this.aL]][this.E[this.aL]] != 7 && this.b[this.D[this.aL]][this.E[this.aL]] != 8) {
                        this.w = false;
                    } else if (this.ah[this.c[this.D[this.aL]][this.E[this.aL]]] > 50) {
                        this.w = false;
                    }
                    if (!this.w) {
                        this.dw();
                        return;
                    }
                }
                this.dm();
                return;
            }
            if (this.H[this.aL] <= -100 && this.W[this.aL] == 18) {
                this.cS();
                return;
            }
            if (this.H[this.aL] >= -3 && this.W[this.aL] == -1) {
                this.dq();
            }
        }
    }

    final void dm() {
        int n = this.aL;
        this.G[n] = (byte)(this.G[n] - 20 * this.aI[this.h[31] + this.F[this.aL] * 2 + 0]);
        int n2 = this.aL;
        this.H[n2] = (byte)(this.H[n2] - 20 * this.aI[this.h[31] + this.F[this.aL] * 2 + 1]);
        if (this.W[this.aL] == 9 && this.Z[this.c[this.B[this.aL]][this.C[this.aL]]] == 23) {
            if (this.ac[this.c[this.B[this.aL]][this.C[this.aL]]] >= this.au[23]) {
                this.F[this.aL] = this.aa[this.c[this.B[this.aL]][this.C[this.aL]]];
                this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.F[this.aL] * 2 + 0]);
                this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.F[this.aL] * 2 + 1]);
                this.G[this.aL] = b.f[this.F[this.aL]][0];
                this.H[this.aL] = b.f[this.F[this.aL]][1];
                this.W[this.aL] = -1;
                return;
            }
            this.do();
        }
        this.dn();
    }

    final void dn() {
        this.ay = this.aL;
        this.dp();
        this.B[this.aL] = this.D[this.aL];
        this.C[this.aL] = this.E[this.aL];
        this.d[this.aL] = this.c[this.B[this.aL]][this.C[this.aL]];
        this.c[this.B[this.aL]][this.C[this.aL]] = (short)this.aL;
        if (this.aL < 200 && this.b[this.B[this.aL]][this.C[this.aL]] > 3 && this.W[this.aL] == -1 && this.F[this.aL] > 1) {
            if (this.Z[this.c[this.B[this.aL]][this.C[this.aL]]] == 22) {
                this.aZ = this.aL;
                this.dD();
                this.W[this.aL] = 14;
                this.c[this.aL] = 0;
            } else {
                this.aZ = this.aL;
                this.dD();
                this.W[this.aL] = 9;
            }
        }
        if (this.b[this.B[this.aL]][this.C[this.aL]] != 13 && this.W[this.aL] == 10) {
            this.W[this.aL] = 14;
            this.c[this.aL] = 0;
            this.G[this.aL] = this.o[22][this.g[22][21] + this.F[this.aL] * 11 + this.c[this.aL]];
            this.H[this.aL] = this.o[22][this.g[22][22] + this.F[this.aL] * 11 + this.c[this.aL]];
            this.P[this.aL] = this.a(this.P[this.aL] + this.ad[this.c[this.B[this.aL]][this.C[this.aL]]]);
        }
        if (this.W[this.aL] != 12) {
            this.dq();
        }
        this.dB();
    }

    final void do() {
        byte by = this.c[this.B[this.aL]][this.C[this.aL]];
        this.ac[by] = (byte)(this.ac[by] + 1);
        this.aO = 0;
        while (this.aO < this.au[23]) {
            if (this.e[this.c[this.B[this.aL]][this.C[this.aL]]][this.aO] < 0) {
                this.D[this.aL] = (byte)(this.l[0][this.c[this.B[this.aL]][this.C[this.aL]]] + this.aI[this.h[4] + this.aa[this.c[this.B[this.aL]][this.C[this.aL]]] * 6 + this.aO % 3 * 2 + 0]);
                this.E[this.aL] = (byte)(this.l[1][this.c[this.B[this.aL]][this.C[this.aL]]] + this.aI[this.h[4] + this.aa[this.c[this.B[this.aL]][this.C[this.aL]]] * 6 + this.aO % 3 * 2 + 1]);
                this.H[this.aL] = this.aI[this.h[87] + this.aO / 3];
                this.e[this.c[this.B[this.aL]][this.C[this.aL]]][this.aO] = (short)this.aL;
                break;
            }
            ++this.aO;
        }
        this.F[this.aL] = this.aI[this.h[86] + this.H[this.aL]];
        this.J[this.aL] = 0;
        this.c[this.aL] = 0;
        this.W[this.aL] = 12;
        this.P[this.aL] = this.a(this.P[this.aL] + this.g[5]);
    }

    final void dp() {
        this.aP = this.c[this.B[this.ay]][this.C[this.ay]];
        if (this.aP == this.ay) {
            this.c[this.B[this.ay]][this.C[this.ay]] = this.d[this.ay];
            return;
        }
        while (this.aP >= 0) {
            if (this.d[this.aP] == this.ay) {
                this.d[this.aP] = this.d[this.ay];
                return;
            }
            this.aP = this.d[this.aP];
        }
    }

    final void dq() {
        try {
            if (this.A[this.aL] != 8 && this.A[this.aL] != 9) {
                if (this.b()) {
                    return;
                }
                if (this.c()) {
                    return;
                }
                if (this.d()) {
                    return;
                }
                if (this.e()) {
                    return;
                }
                if (this.i()) {
                    return;
                }
            } else if (this.A[this.aL] == 9 && this.k()) {
                return;
            }
            this.aO = 0;
            while (this.aO < 4) {
                this.z[this.aO] = this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 0] >= this.O || this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 1] >= this.O || this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 0] < 0 || this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 1] < 0 ? (byte)1 : this.b[this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 0]][this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 1]];
                ++this.aO;
            }
            if (this.l()) {
                return;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final boolean b() {
        if (this.W[this.aL] == 14 || this.W[this.aL] == -1 && this.b[this.B[this.aL]][this.C[this.aL]] > 3 && this.Z[this.c[this.B[this.aL]][this.C[this.aL]]] == 22) {
            this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 0] * 2 + 0]);
            this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 0] * 2 + 1]);
            return true;
        }
        if (this.W[this.aL] == 18 && this.B[this.aL] == this.ab && this.C[this.aL] == 0) {
            this.D[this.aL] = this.ab;
            this.E[this.aL] = -1;
            return true;
        }
        return false;
    }

    final boolean c() {
        if (this.W[this.aL] == 10) {
            this.aO = 0;
            while (this.aO < 4) {
                if (this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 0] >= this.O || this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 1] >= this.O || this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 0] < 0 || this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 1] < 0) {
                    this.z[this.aO] = 1;
                } else {
                    this.z[this.aO] = this.b[this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 0]][this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 1]];
                    if (this.z[this.aO] == 7 && this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] == 1 || this.z[this.aO] == 8 && this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] == 0) {
                        this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 0]);
                        this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + this.aO] * 2 + 1]);
                        return true;
                    }
                }
                ++this.aO;
            }
            if (this.z[0] == 13) {
                this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 0] * 2 + 0]);
                this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 0] * 2 + 1]);
                return true;
            }
            if (this.z[1] == 13) {
                this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 1] * 2 + 0]);
                this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 1] * 2 + 1]);
                return true;
            }
            if (this.z[3] == 13) {
                this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 3] * 2 + 0]);
                this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 3] * 2 + 1]);
                return true;
            }
            this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 2] * 2 + 0]);
            this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 2] * 2 + 1]);
            return true;
        }
        return false;
    }

    final boolean d() {
        if (this.W[this.aL] == 9) {
            if (this.aa[this.c[this.B[this.aL]][this.C[this.aL]]] == 0) {
                if (this.C[this.aL] == this.ae[this.c[this.B[this.aL]][this.C[this.aL]]]) {
                    this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + 4 + 0]);
                    this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + 4 + 1]);
                } else {
                    this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + 6 + 0]);
                    this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + 6 + 1]);
                }
            } else if (this.B[this.aL] == this.ae[this.c[this.B[this.aL]][this.C[this.aL]]]) {
                this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + 6 + 0]);
                this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + 6 + 1]);
            } else {
                this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + 4 + 0]);
                this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + 4 + 1]);
            }
            return true;
        }
        if ((this.W[this.aL] == -1 || this.W[this.aL] == 18) && this.b[this.B[this.aL]][this.C[this.aL]] >= 4 && this.b[this.B[this.aL]][this.C[this.aL]] <= 6) {
            this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aa[this.c[this.B[this.aL]][this.C[this.aL]]] * 2 + 0]);
            this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aa[this.c[this.B[this.aL]][this.C[this.aL]]] * 2 + 1]);
            return true;
        }
        return false;
    }

    final boolean e() {
        if (this.W[this.aL] != 18) {
            if (this.Q[this.aL] > 50) {
                this.aO = 0;
                while (this.aO < 2) {
                    if (this.b[this.B[this.aL]][this.C[this.aL]] == 0 && (this.c[this.B[this.aL]][this.C[this.aL]] & b.X[this.aO]) != 0) {
                        this.aQ = 0;
                        this.aP = this.c[this.B[this.aL]][this.C[this.aL]];
                        while (this.aP >= 0) {
                            if (this.W[this.aP] == 1 && this.h[2][this.aP] == this.aO && this.h[0][this.aP] < 2) {
                                ++this.aQ;
                            }
                            this.aP = this.d[this.aP];
                        }
                        if (this.aQ < 2) {
                            this.W[this.aL] = 1;
                            this.h[0][this.aL] = 0;
                            this.h[1][this.aL] = 0;
                            this.h[2][this.aL] = (byte)this.aO;
                            this.X[this.aL] = this.F[this.aL];
                            this.b[this.aL] = 0;
                            break;
                        }
                    }
                    ++this.aO;
                }
            }
            if (this.f()) {
                return true;
            }
        }
        return false;
    }

    final boolean f() {
        this.aQ = 0;
        while (this.aQ < 2) {
            if (!(this.aQ == 0 && this.B[this.aL] == 0 || this.aQ == 1 && this.C[this.aL] == this.O - 1)) {
                this.aZ[0] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.aQ] * 4 + 0] * 2 + 0]);
                this.aZ[1] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.aQ] * 4 + 0] * 2 + 1]);
                this.bc = this.b[this.aZ[0]][this.aZ[1]];
                this.bd = this.c[this.aZ[0]][this.aZ[1]];
                if (this.bc <= -15 && this.bc >= -27) {
                    this.w = false;
                    if (this.d[this.bd]) {
                        if (this.g()) {
                            return true;
                        }
                        if (this.w) {
                            this.W[this.aL] = this.aI[this.h[53] + -1 - this.bc];
                            this.h[0][this.aL] = 0;
                            this.h[1][this.aL] = 0;
                            this.h[2][this.aL] = (byte)this.aQ;
                            this.X[this.aL] = this.F[this.aL];
                            break;
                        }
                    }
                }
                this.w = false;
                if (this.h()) {
                    return true;
                }
                if (this.w) {
                    this.D[this.aL] = this.aZ[0];
                    this.E[this.aL] = this.aZ[1];
                    this.f[1][this.aL] = this.f[0][this.aL];
                    this.f[0][this.aL] = this.Z[this.bd];
                    byte[] byArray = this.f[2];
                    int n = this.aL;
                    byArray[n] = (byte)(byArray[n] + 1);
                    this.h[0][this.aL] = 0;
                    this.h[1][this.aL] = 0;
                    this.h[2][this.aL] = (byte)this.aQ;
                    this.X[this.aL] = this.F[this.aL];
                    if (this.Z[this.bd] != 23) {
                        this.b[this.aL] = this.al[this.Z[this.bd]];
                    }
                    this.W[this.aL] = 7;
                    return true;
                }
            }
            ++this.aQ;
        }
        return false;
    }

    final boolean g() {
        if (this.aI[this.h[163 + this.aQ] - 1 - this.bc] == 1 && (this.aI[this.h[55] + -1 - this.bc] >= this.g[this.aI[this.h[54] + -1 - this.bc]][this.aL] && b.ar[this.aI[this.h[54] + -1 - this.bc]] == 0 || this.aI[this.h[55] + -1 - this.bc] <= this.g[this.aI[this.h[54] + -1 - this.bc]][this.aL] && b.ar[this.aI[this.h[54] + -1 - this.bc]] == 1)) {
            if (this.aI[this.h[57] + -1 - this.bc] >= 0) {
                if (this.L[this.aL] >= this.aE[this.aI[this.h[57] + -1 - this.bc]]) {
                    this.b[this.aL] = this.aE[this.aI[this.h[57] + -1 - this.bc]];
                    this.w = true;
                }
            } else {
                this.b[this.aL] = 0;
                this.w = true;
            }
        }
        if ((this.bc == -21 || this.bc == -22 || this.bc == -26) && this.w) {
            if (this.e[this.bd]) {
                this.w = false;
            } else {
                this.aP = this.c[this.B[this.aL]][this.C[this.aL]];
                do {
                    if ((this.W[this.aP] == 4 || this.W[this.aP] == 6) && this.h[2][this.aP] == this.aQ && this.aP != this.aL) {
                        this.w = false;
                        break;
                    }
                    this.aP = this.d[this.aP];
                } while (this.aP >= 0);
            }
        }
        if (this.aI[this.h[53] + -1 - this.bc] == 5 && this.M[this.aL] > -1 && this.w) {
            this.b[this.aL] = 0;
            this.w = false;
        }
        return false;
    }

    final boolean h() {
        if (this.bc == 5 + this.aQ && this.a[this.bd] && this.b[this.bd] && this.c[this.bd] && this.ah[this.bd] >= 10 && (this.Z[this.bd] == 23 || this.L[this.aL] >= this.al[this.Z[this.bd]])) {
            this.q = this.bd;
            if (this.Z[this.bd] != 22 && this.Z[this.bd] != 23 && this.ad[this.bd] < 10) {
                this.dA();
                this.q = (short)((this.a.nextInt() & 0xFFFF) % 100);
                if (this.q < this.p) {
                    this.w = true;
                }
            } else if (this.Z[this.bd] == 22 && this.c[this.aZ[0]][this.aZ[1]] == -1) {
                this.dA();
                this.q = (short)((this.a.nextInt() & 0xFFFF) % 100);
                if (this.q < this.p) {
                    this.w = true;
                }
                if (this.w) {
                    this.aP = this.c[this.B[this.aL]][this.C[this.aL]];
                    do {
                        if (this.W[this.aP] == 7 && this.h[2][this.aP] == this.aQ && this.aP != this.aL) {
                            this.w = false;
                            break;
                        }
                        this.aP = this.d[this.aP];
                    } while (this.aP >= 0);
                }
            } else if (this.Z[this.bd] == 23 && this.ac[this.bd] < this.au[23] && (this.Q[this.aL] > 50 || this.R[this.aL] > 50 || this.T[this.aL] > 50) && this.L[this.aL] >= this.aE[this.aI[this.h[57] + 27 + 1]]) {
                this.b[this.aL] = this.aE[this.aI[this.h[57] + 27 + 1]];
                this.w = true;
            }
        }
        return false;
    }

    final boolean i() {
        this.aQ = 0;
        this.aO = 0;
        while (this.aO < 4) {
            if (this.B[this.aL] + this.aI[this.h[31] + this.aO * 2 + 0] >= this.O || this.C[this.aL] + this.aI[this.h[31] + this.aO * 2 + 1] >= this.O || this.B[this.aL] + this.aI[this.h[31] + this.aO * 2 + 0] < 0 || this.C[this.aL] + this.aI[this.h[31] + this.aO * 2 + 1] < 0) {
                this.z[this.aO] = 1;
            } else {
                this.z[this.aO] = this.b[this.B[this.aL] + this.aI[this.h[31] + this.aO * 2 + 0]][this.C[this.aL] + this.aI[this.h[31] + this.aO * 2 + 1]];
                if (this.z[this.aO] == 0) {
                    ++this.aQ;
                }
            }
            ++this.aO;
        }
        if (this.aQ > 2) {
            if (this.W[this.aL] == 18) {
                this.dr();
                this.aO = 0;
                while (this.aO < 4) {
                    if (this.z[this.aI[this.h[32] + this.bb * 4 + this.aO]] == 0 && this.aI[this.h[32] + this.bb * 4 + this.aO] != this.aI[this.h[30] + this.F[this.aL] * 4 + 2]) {
                        this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[32] + this.bb * 4 + this.aO] * 2 + 0]);
                        this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[32] + this.bb * 4 + this.aO] * 2 + 1]);
                        return true;
                    }
                    ++this.aO;
                }
            }
            if (this.j()) {
                return true;
            }
        }
        return false;
    }

    final boolean j() {
        this.aO = this.B[this.aL] - 1;
        while (this.aO <= this.B[this.aL] + 1) {
            if (this.aO >= 0) {
                if (this.aO >= this.O) break;
                this.aP = this.C[this.aL] - 1;
                while (this.aP <= this.C[this.aL] + 1) {
                    if (this.aP >= 0) {
                        if (this.aP >= this.O) break;
                        if (this.b[this.aO][this.aP] == -14 && this.Y[this.c[this.aO][this.aP]] > 0) {
                            this.aQ = 0;
                            while (this.aQ < this.Y[this.c[this.aO][this.aP]]) {
                                this.w = false;
                                if (this.j[this.c[this.aO][this.aP]][this.aQ] >= 0) {
                                    if (this.j[this.c[this.aO][this.aP]][this.aQ] != 23) {
                                        this.bg = this.j[this.c[this.aO][this.aP]][this.aQ];
                                        this.dz();
                                        if (this.p >= 50) {
                                            this.w = true;
                                        }
                                    } else if (this.Q[this.aL] > 50 || this.R[this.aL] > 50) {
                                        this.w = true;
                                    }
                                } else if (this.aI[this.h[55] + -1 - this.j[this.c[this.aO][this.aP]][this.aQ]] >= this.g[this.aI[this.h[54] + -1 - this.j[this.c[this.aO][this.aP]][this.aQ]]][this.aL] && b.ar[this.aI[this.h[54] + -1 - this.j[this.c[this.aO][this.aP]][this.aQ]]] == 0 || this.aI[this.h[55] + -1 - this.j[this.c[this.aO][this.aP]][this.aQ]] <= this.g[this.aI[this.h[54] + -1 - this.j[this.c[this.aO][this.aP]][this.aQ]]][this.aL] && b.ar[this.aI[this.h[54] + -1 - this.j[this.c[this.aO][this.aP]][this.aQ]]] == 1 && this.aI[this.h[53] + this.j[this.c[this.aO][this.aP]][this.aQ]] != -2) {
                                    this.w = true;
                                }
                                if (this.w) {
                                    this.dr();
                                    this.aO = 0;
                                    while (this.aO < 4) {
                                        if (this.z[this.aI[this.h[32] + this.bb * 4 + this.aO]] == 0 && this.aI[this.h[32] + this.bb * 4 + this.aO] != this.aI[this.h[30] + this.F[this.aL] * 4 + 2]) {
                                            this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[32] + this.bb * 4 + this.aO] * 2 + 0]);
                                            this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[32] + this.bb * 4 + this.aO] * 2 + 1]);
                                            return true;
                                        }
                                        ++this.aO;
                                    }
                                }
                                ++this.aQ;
                            }
                        }
                    }
                    ++this.aP;
                }
            }
            ++this.aO;
        }
        return false;
    }

    final boolean k() {
        if (this.b[this.B[this.aL]][this.C[this.aL]] > 3) {
            this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.F[this.aL] * 2 + 0]);
            this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.F[this.aL] * 2 + 1]);
            if (this.F[this.aL] > 1) {
                this.ai[this.c[this.B[this.aL]][this.C[this.aL]]] = 1;
            }
            return true;
        }
        this.aQ = 0;
        while (this.aQ < 2) {
            if (!(this.aQ == 0 && this.B[this.aL] == 0 || this.aQ == 1 && this.C[this.aL] == this.O - 1)) {
                this.aZ[0] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.aQ] * 4 + 0] * 2 + 0]);
                this.aZ[1] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.aQ] * 4 + 0] * 2 + 1]);
                this.bc = this.b[this.aZ[0]][this.aZ[1]];
                this.bd = this.c[this.aZ[0]][this.aZ[1]];
                if (this.bc == 7 + this.aQ && this.ah[this.bd] <= 50 && this.ai[this.bd] == 0) {
                    this.w = true;
                    this.aP = this.c[this.B[this.aL]][this.C[this.aL]];
                    while (this.aP >= 0) {
                        if (this.A[this.aP] == 9 && this.D[this.aP] == this.aZ[0] && this.E[this.aP] == this.aZ[1]) {
                            this.w = false;
                            break;
                        }
                        this.aP = this.d[this.aP];
                    }
                    if (this.w) {
                        this.D[this.aL] = this.aZ[0];
                        this.E[this.aL] = this.aZ[1];
                        return true;
                    }
                }
            }
            ++this.aQ;
        }
        return false;
    }

    final boolean l() {
        this.aO = (this.a.nextInt() & 0xFF) % 4;
        if (this.z[0] == 0 && (this.z[1] != 0 && this.z[3] != 0 || this.aO < 2)) {
            this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 0] * 2 + 0]);
            this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 0] * 2 + 1]);
            return true;
        }
        this.aO = (this.a.nextInt() & 0xFF) % 4;
        if (this.z[1] == 0 && (this.z[3] != 0 || this.aO < 2)) {
            this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 1] * 2 + 0]);
            this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 1] * 2 + 1]);
            return true;
        }
        if (this.z[3] == 0) {
            this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 3] * 2 + 0]);
            this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 3] * 2 + 1]);
            return true;
        }
        if (this.z[2] == 0) {
            this.D[this.aL] = (byte)(this.B[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 2] * 2 + 0]);
            this.E[this.aL] = (byte)(this.C[this.aL] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aL] * 4 + 2] * 2 + 1]);
        } else {
            this.D[this.aL] = -1;
            this.W[this.aL] = 18;
        }
        return false;
    }

    final void dr() {
        this.bb = 0;
        if (this.W[this.aL] == 18) {
            this.aS = this.ab - this.B[this.aL];
            this.aT = -this.C[this.aL];
        } else {
            this.aS = this.a[this.c[this.aO][this.aP]][this.aQ][0] - this.B[this.aL];
            this.aT = this.a[this.c[this.aO][this.aP]][this.aQ][1] - this.C[this.aL];
        }
        if (this.aS > 0) {
            this.bb = (byte)(this.bb + 4);
        } else {
            this.aS *= -1;
        }
        if (this.aT > 0) {
            this.bb = (byte)(this.bb + 2);
        } else {
            this.aT *= -1;
        }
        if (this.aS > this.aT) {
            this.bb = (byte)(this.bb + 1);
        }
    }

    final void ds() {
        if (this.ad[this.c[this.B[this.aL]][this.C[this.aL]]] >= 10) {
            this.dt();
            return;
        }
        if (!(this.c[this.c[this.B[this.aL]][this.C[this.aL]]] && this.b[this.c[this.B[this.aL]][this.C[this.aL]]] && this.a[this.c[this.B[this.aL]][this.C[this.aL]]] && this.ah[this.c[this.B[this.aL]][this.C[this.aL]]] >= 10)) {
            this.W[this.aL] = -1;
            this.dw();
            return;
        }
        this.W[this.aL] = 11;
        this.f[this.c[this.B[this.aL]][this.C[this.aL]]][this.ad[this.c[this.B[this.aL]][this.C[this.aL]]]] = (short)this.aL;
        this.ay = this.aL;
        this.dp();
        this.aM = this.ad[this.c[this.B[this.aL]][this.C[this.aL]]] * 6;
        if (this.aa[this.c[this.B[this.aL]][this.C[this.aL]]] == 0) {
            this.du();
        } else {
            this.dv();
        }
        this.d[this.ay] = this.c[this.B[this.ay]][this.C[this.ay]];
        this.c[this.B[this.ay]][this.C[this.ay]] = (short)this.ay;
        byte by = this.c[this.B[this.aL]][this.C[this.aL]];
        this.ad[by] = (byte)(this.ad[by] + 1);
        if (this.Z[this.c[this.B[this.aL]][this.C[this.aL]]] == 14) {
            this.af[this.c[this.B[this.aL]][this.C[this.aL]]] = 0;
        }
        this.J[this.aL] = 0;
    }

    final void dt() {
        this.ay = this.aL;
        this.dp();
        if (this.aa[this.c[this.B[this.aL]][this.C[this.aL]]] == 0) {
            this.C[this.aL] = (byte)(this.ae[this.c[this.B[this.aL]][this.C[this.aL]]] - 2);
            this.E[this.aL] = (byte)(this.C[this.aL] - 1);
            this.D[this.aL] = this.B[this.aL];
            this.H[this.aL] = 0;
            this.G[this.aL] = b.Z[0];
            this.F[this.aL] = 0;
            this.W[this.aL] = -1;
        } else {
            this.B[this.aL] = (byte)(this.ae[this.c[this.B[this.aL]][this.C[this.aL]]] + 2);
            this.D[this.aL] = (byte)(this.B[this.aL] + 1);
            this.E[this.aL] = this.C[this.aL];
            this.H[this.aL] = b.Z[0];
            this.G[this.aL] = 18;
            this.F[this.aL] = 1;
            this.W[this.aL] = -1;
        }
        this.d[this.ay] = this.c[this.B[this.ay]][this.C[this.ay]];
        this.c[this.B[this.ay]][this.C[this.ay]] = (short)this.ay;
    }

    final void du() {
        if (this.aM <= 16) {
            this.C[this.aL] = this.ae[this.c[this.B[this.aL]][this.C[this.aL]]];
            this.D[this.aL] = (byte)(this.B[this.aL] - 1);
            this.E[this.aL] = this.C[this.aL];
            if (this.aM <= 6) {
                this.H[this.aL] = 10;
                this.G[this.aL] = (byte)(this.aM + 4);
                this.F[this.aL] = 2;
                return;
            }
            this.aM -= 6;
            this.G[this.aL] = 10;
            this.H[this.aL] = (byte)(10 - this.aM);
            this.F[this.aL] = 3;
            return;
        }
        this.aM -= 16;
        this.G[this.aL] = 10;
        this.H[this.aL] = (byte)((40 - this.aM) % 20);
        this.C[this.aL] = (byte)(this.ae[this.c[this.B[this.aL]][this.C[this.aL]]] - 1 - (this.aM - 1) / 20);
        this.D[this.aL] = this.B[this.aL];
        this.E[this.aL] = (byte)(this.C[this.aL] + 1);
        this.F[this.aL] = 3;
    }

    final void dv() {
        if (this.aM <= 14) {
            this.B[this.aL] = this.ae[this.c[this.B[this.aL]][this.C[this.aL]]];
            this.D[this.aL] = this.B[this.aL];
            this.E[this.aL] = (byte)(this.C[this.aL] + 1);
            if (this.aM <= 5) {
                this.H[this.aL] = (byte)(19 - this.aM - 4);
                this.G[this.aL] = 10;
                this.F[this.aL] = 3;
                return;
            }
            this.aM -= 5;
            this.G[this.aL] = (byte)(10 + this.aM);
            this.H[this.aL] = 10;
            this.F[this.aL] = 2;
            return;
        }
        this.aM -= 15;
        this.G[this.aL] = (byte)(this.aM % 20);
        this.H[this.aL] = 10;
        this.B[this.aL] = (byte)(this.ae[this.c[this.B[this.aL]][this.C[this.aL]]] + 1 + this.aM / 20);
        this.D[this.aL] = (byte)(this.B[this.aL] - 1);
        this.E[this.aL] = this.C[this.aL];
        this.F[this.aL] = 2;
    }

    final void d(boolean bl) {
        this.aU = this.aL;
        this.aV = 0;
        while (this.aV < this.ad[this.ax]) {
            this.aL = this.f[this.ax][this.aV];
            this.F[this.aL] = this.aI[this.h[30] + this.F[this.aL] * 4 + 2];
            this.e[this.aI[this.h[105] + this.F[this.aL]]][this.aL] = this.aI[this.h[36] + this.F[this.aL] * 2 + this.aI[this.h[105] + this.F[this.aL]]];
            this.W[this.aL] = -1;
            if (bl) {
                this.P[this.aL] = this.a(this.P[this.aL] - b.ap[3]);
            }
            this.dq();
            ++this.aV;
        }
        this.ad[this.ax] = 0;
        this.aL = this.aU;
    }

    final void dw() {
        this.F[this.aL] = this.aI[this.h[30] + this.F[this.aL] * 4 + 2];
        this.G[this.aL] = this.aI[this.h[36] + this.F[this.aL] * 2 + 0];
        this.H[this.aL] = this.aI[this.h[36] + this.F[this.aL] * 2 + 1];
        this.dq();
    }

    final void dx() {
        this.aO = 0;
        while (this.aO < 30) {
            this.Y[this.aO] = 0;
            if (this.i[this.aO][0] >= 0) {
                this.aP = this.i[this.aO][0] - 6;
                while (this.aP <= this.i[this.aO][0] + 6) {
                    if (this.aP >= 0) {
                        if (this.aP >= this.O) break;
                        this.aQ = this.i[this.aO][1] - 6;
                        while (this.aQ <= this.i[this.aO][1] + 6) {
                            if (this.aQ >= 0) {
                                if (this.aQ >= this.O) break;
                                this.be = 0;
                                while (this.be < 2 && this.Y[this.aO] < 20) {
                                    this.bf = 0;
                                    if (this.b[this.aP][this.aQ] <= -15 && this.b[this.aP][this.aQ] >= -27 && this.aI[this.h[163 + this.be] - 1 - this.b[this.aP][this.aQ]] == 1) {
                                        this.j[this.aO][this.Y[this.aO]] = this.b[this.aP][this.aQ];
                                        this.bf = 1;
                                    }
                                    if (this.b[this.aP][this.aQ] == 5 + this.be) {
                                        this.j[this.aO][this.Y[this.aO]] = this.Z[this.c[this.aP][this.aQ]];
                                        this.bf = 1;
                                    }
                                    if (this.bf == 1) {
                                        this.a[this.aO][this.Y[this.aO]][0] = (byte)(this.aP + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.be] * 4 + 2] * 2 + 0]);
                                        this.a[this.aO][this.Y[this.aO]][1] = (byte)(this.aQ + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.be] * 4 + 2] * 2 + 1]);
                                        int n = this.aO;
                                        this.Y[n] = (byte)(this.Y[n] + 1);
                                    }
                                    this.be = (byte)(this.be + 1);
                                }
                            }
                            ++this.aQ;
                        }
                    }
                    ++this.aP;
                }
            }
            ++this.aO;
        }
    }

    final void dy() {
        this.aW = this.P[this.aL] < 50 ? (this.a.nextInt() & 0xFFFF) % (this.c[1][d.k[4] + 1] * 40) : 1000;
        if (this.L[this.aL] < 4 || this.Q[this.aL] >= 96 || this.R[this.aL] >= 100 || 60 + 10 * this.M - this.P[this.aL] > this.aW) {
            this.W[this.aL] = 18;
        }
    }

    final void dz() {
        this.p = (short)100;
        this.p = (short)(this.p - (this.Q[this.aL] + this.R[this.aL]) * 100 / 200);
        this.p = (short)(this.p - this.f[this.bg] * 2);
        if (this.f[0][this.aL] == this.bg) {
            this.p = (short)(this.p - b.av[0]);
        }
        if (this.f[1][this.aL] == this.bg) {
            this.p = (short)(this.p - b.av[1]);
        }
    }

    final void dA() {
        this.bg = this.Z[this.q];
        this.dz();
        if (this.bg != 22) {
            this.p = (short)(this.p - this.ad[this.q] * 50 / 10);
        }
    }

    final void e(boolean bl) {
        if (this.W[this.aL] == 15 || this.W[this.aL] == 16) {
            return;
        }
        this.N[this.aL] = -1;
        this.bh = 0;
        while (this.bh < 10) {
            if (this.aI[this.h[95] + this.bh] == this.ad + 3) {
                if (this.c[this.aL] >= b.b[this.bh]) {
                    this.N[this.aL] = this.bh;
                }
            } else if (this.g[this.aI[this.h[95] + this.bh]][this.aL] <= b.b[this.bh] && this.aI[this.h[97] + this.bh] == 0 || this.g[this.aI[this.h[95] + this.bh]][this.aL] >= b.b[this.bh] && this.aI[this.h[97] + this.bh] == 1) {
                this.N[this.aL] = this.bh;
            }
            if (this.N[this.aL] >= 0 && bl && (this.a.nextInt() & 0xFFFF) % 25 > 0) {
                this.N[this.aL] = -1;
            }
            if (this.N[this.aL] >= 0) {
                return;
            }
            this.bh = (byte)(this.bh + 1);
        }
    }

    final void dB() {
        if (this.aL >= 200) {
            return;
        }
        this.aX = this.d[this.aL];
        while (this.aX != -1) {
            if (this.W[this.aX] == 15 || this.W[this.aX] == 16) {
                this.J[this.aL] = 0;
                this.W[this.aL] = 17;
                return;
            }
            this.aX = this.d[this.aX];
        }
        if (this.W[this.aL] != -1) {
            return;
        }
        this.aX = this.d[this.aL];
        while (this.aX != -1) {
            if (this.W[this.aX] == -1 && this.aX < 200 && this.V[this.aL] >= this.af && this.V[this.aX] >= this.af && (this.a.nextInt() & 0xFFFF) % this.b < this.V[this.aL] + this.V[this.aX]) {
                this.W[this.aL] = 15;
                this.W[this.aX] = 16;
                this.h[0][this.aL] = 0;
                this.h[1][this.aL] = 0;
                this.c[this.aL] = 0;
                this.c[this.aX] = 0;
                this.N[this.aL] = -1;
                this.N[this.aX] = -1;
                this.aZ = this.aL;
                this.dD();
                this.aZ = this.aX;
                this.dD();
                this.bi = 0;
                this.dC();
                return;
            }
            this.aX = this.d[this.aX];
        }
    }

    final void dC() {
        if (!this.j[this.bi]) {
            this.f = 0;
            this.aC = 1;
            this.aB = this.aA = (byte)(this.aE + this.bi);
            this.dH();
            this.j[this.bi] = true;
        }
    }

    final void dD() {
        if (this.M[this.aZ] < 0) {
            return;
        }
        this.aY = 0;
        while (this.aY < this.aH) {
            if (this.x[this.aY][0] < 0) {
                this.x[this.aY][0] = this.B[this.aZ];
                this.x[this.aY][1] = this.C[this.aZ];
                this.aR[this.aY] = (byte)((this.G[this.aZ] + this.H[this.aZ]) / b.Y[0] - this.aI[this.h[73] + this.M[this.aZ] + 13] / 2);
                this.aQ[this.aY] = (byte)(b.B[1] / 2 + (this.G[this.aZ] - this.H[this.aZ]) / b.Y[1] - this.aI[this.h[20] + this.A[this.aZ] * 4 + this.F[this.aZ]] - this.aI[this.h[74] + this.M[this.aZ] + 13]);
                this.aS[this.aY] = (byte)(this.M[this.aZ] + 13);
                this.M[this.aZ] = -1;
                return;
            }
            ++this.aY;
        }
    }

    final void dE() {
        this.aY = 0;
        while (this.aY < this.aH) {
            if (this.x[this.aY][0] >= 0) {
                if (this.aQ[this.aY] < this.aI) {
                    this.x[this.aY][0] = -1;
                } else {
                    int n = this.aY;
                    this.aR[n] = (byte)(this.aR[n] + ((this.a.nextInt() & 0xFFFF) % 3 - 1));
                    int n2 = this.aY;
                    this.aQ[n2] = (byte)(this.aQ[n2] - 2);
                }
            }
            ++this.aY;
        }
    }

    final void dF() {
        this.aM = 0;
        while (this.aM < this.ae) {
            if (b.ar[this.aM] == 0) {
                this.g[this.aM][this.aL] = this.a(this.g[this.aM][this.aL] - this.aI[this.h[33] + this.bj * this.ae + this.aM]);
            }
            if (b.ar[this.aM] == 1) {
                this.g[this.aM][this.aL] = this.a(this.g[this.aM][this.aL] + this.aI[this.h[33] + this.bj * this.ae + this.aM]);
            }
            ++this.aM;
        }
    }

    final byte a(int n) {
        if (n >= 100) {
            return 100;
        }
        if (n <= 0) {
            return 0;
        }
        return (byte)n;
    }

    final void dG() {
        this.s = 0;
        while (this.s < 3) {
            this.a = null;
            try {
                this.a = this.getClass().getResourceAsStream(this.a[this.s] + this.P);
                if (this.a != null) {
                    this.r = 0;
                    this.i[this.s][0] = 0;
                    this.q = 0;
                    while ((this.D = this.a.read()) != -1) {
                        if (this.D == 124) {
                            ++this.r;
                            this.i[this.s][this.r] = (short)this.q;
                            --this.q;
                        } else if (this.D == 38) {
                            this.s[this.s][this.q] = 100;
                        } else if (this.D < 10) {
                            this.s[this.s][this.q] = (byte)(101 + this.D);
                        } else {
                            this.dJ();
                            this.s[this.s][this.q] = (byte)this.E;
                        }
                        ++this.q;
                    }
                }
                this.a.close();
                this.a = null;
            }
            catch (IOException iOException) {}
            System.gc();
            ++this.s;
        }
    }

    final void dH() {
        this.bb = 0;
        this.G = 0;
        this.l[0] = this.i[this.aC][this.aA];
        this.bc = 0;
        this.dI();
        if (this.i[this.aC][this.aA] < this.i[this.aC][this.aA + 1]) {
            ++this.G;
            this.m[this.G - 1] = (short)this.bc;
            this.l[this.G] = this.i[this.aC][this.aA + 1];
        }
        this.F = 0;
        if (this.aC == 3) {
            this.H = (this.m + d.B[this.aC]) / 2 - 10 * this.G;
            if (this.H < d.B[this.aC]) {
                this.H = d.B[this.aC];
                return;
            }
        } else {
            if (this.aC == 1) {
                if (this.G < d.j[1]) {
                    this.H = d.B[this.aC] - (this.G - 1) * 20;
                    return;
                }
                this.H = d.B[this.aC] - (d.j[1] - 1) * 20;
                return;
            }
            this.H = d.B[this.aC];
        }
    }

    final void dI() {
        this.ba = this.i[this.aC][this.aA];
        while (this.ba < this.i[this.aC][this.aA + 1]) {
            if (this.s[this.aC][this.ba] == 45 || this.s[this.aC][this.ba] == 100) {
                this.bb = (short)(this.ba + 1);
                this.bd = this.bc;
            }
            if (this.s[this.aC][this.ba] >= 101) {
                ++this.bc;
                this.bc += this.aI[this.h[73] + this.aI[this.h[96] + this.s[this.aC][this.ba] - 101]];
            }
            if (this.s[this.aC][this.ba] < 100 && (this.s[this.aC][this.ba] / 30 != 0 || this.s[this.aC][this.ba] % 30 < 24)) {
                ++this.bc;
                this.bc += b.a[this.s[this.aC][this.ba] / 30][this.s[this.aC][this.ba] % 30 + 1] - b.a[this.s[this.aC][this.ba] / 30][this.s[this.aC][this.ba] % 30];
            }
            if (this.bc > d.A[this.aC] && this.bb > this.l[this.G] || this.s[this.aC][this.ba] == 100) {
                ++this.G;
                this.l[this.G] = (short)this.bb;
                this.m[this.G - 1] = (short)this.bd;
                this.ba = (short)(this.bb - 1);
                this.bc = 0;
            }
            ++this.ba;
        }
    }

    final void dJ() {
        if (this.j == 0) {
            if (this.D > 1000) {
                this.D -= 848;
            }
            this.u = 0;
            while (this.u < b.c.length) {
                if (this.D == b.c[this.u]) {
                    this.E = 46 + this.u;
                    return;
                }
                ++this.u;
            }
            if (this.D > 223) {
                this.D -= 32;
            }
            if (this.D >= 192 && this.D < 209) {
                this.E = this.D - 192;
                return;
            }
            if (this.D >= 209 && this.D <= 223) {
                this.E = 30 + this.D - 209;
                return;
            }
            if (this.D == 32) {
                this.E = 45;
                return;
            }
            if (this.D >= 48 && this.D <= 57) {
                this.E = 60 + this.D - 48;
                return;
            }
            this.E = 70;
            this.u = 0;
            while (this.u < 11) {
                if (this.D == this.aI[this.h[130] + this.u]) {
                    this.E += this.u;
                    return;
                }
                ++this.u;
            }
        } else {
            if (this.D >= 48 && this.D <= 57) {
                this.E = this.D - 48;
            }
            this.u = 0;
            while (this.u < 3) {
                if (this.D == d.a[this.u]) {
                    this.E = 10 + this.u;
                    return;
                }
                ++this.u;
            }
        }
    }

    final void dK() {
        this.d[this.az] = this.i[this.f + 1] - this.i[this.f] - 1;
        this.c[this.az] = this.i[this.f + 1] - this.i[this.f];
        this.f[this.az] = this.h;
        this.e[this.az] = this.i;
        this.be = 0;
        while (this.be < this.c[this.az]) {
            this.u[this.az][this.be] = (byte)(this.aN[this.i[this.f] + this.be] / 30);
            this.t[this.az][this.be] = (byte)(this.aN[this.i[this.f] + this.be] % 30);
            if (this.aN[this.i[this.f] + this.be] / 30 != 0 || this.aN[this.i[this.f] + this.be] % 30 < 24) {
                byte by = this.az;
                this.d[by] = this.d[by] + (b.a[this.u[this.az][this.be]][this.t[this.az][this.be] + 1] - b.a[this.u[this.az][this.be]][this.t[this.az][this.be]]);
            }
            ++this.be;
        }
        if (this.g == 1) {
            byte by = this.az;
            this.f[by] = this.f[by] - this.d[this.az] / 2;
        }
        if (this.g == 2) {
            byte by = this.az;
            this.f[by] = this.f[by] - this.d[this.az];
        }
        this.g[this.az] = 0;
        this.az = (byte)(this.az + 1);
    }

    final void dL() {
        if (this.aG >= this.aF) {
            return;
        }
        this.be = 0;
        while (this.be < this.aF && this.l[this.be] < this.o) {
            ++this.be;
        }
        if (this.be >= this.aF) {
            return;
        }
        this.h[this.be] = this.a.length();
        this.i[this.be] = this.h[this.be] - 1;
        this.k[this.be] = this.h;
        this.j[this.be] = this.i;
        this.v[this.be][0] = this.aT[0];
        this.v[this.be][1] = this.aT[1];
        this.j = (short)2;
        this.bf = 0;
        while (this.bf < this.h[this.be]) {
            this.D = this.a.charAt(this.bf);
            this.dJ();
            this.w[this.be][this.bf] = (byte)this.E;
            int n = this.be;
            this.i[n] = this.i[n] + (b.a[this.w[this.be][this.bf] + 1] - b.a[this.w[this.be][this.bf]]);
            ++this.bf;
        }
        this.j = 0;
        int n = this.be;
        this.k[n] = this.k[n] - this.i[this.be] / 2;
        this.l[this.be] = 0;
        this.aG = (byte)(this.aG + 1);
    }

    final void dM() {
        this.c[this.az] = this.a.length();
        this.d[this.az] = this.c[this.az] - 1;
        this.f[this.az] = this.h;
        this.e[this.az] = this.i;
        this.be = 0;
        while (this.be < this.c[this.az]) {
            this.D = this.a.charAt(this.be);
            this.dJ();
            this.u[this.az][this.be] = (byte)(this.E / 30);
            this.t[this.az][this.be] = (byte)(this.E % 30);
            if (this.j == 0) {
                byte by = this.az;
                this.d[by] = this.d[by] + (b.a[this.u[this.az][this.be]][this.t[this.az][this.be] + 1] - b.a[this.u[this.az][this.be]][this.t[this.az][this.be]]);
            } else {
                byte by = this.az;
                this.d[by] = this.d[by] + (b.a[this.t[this.az][this.be] + 1] - b.a[this.t[this.az][this.be]]);
            }
            ++this.be;
        }
        if (this.g == 1) {
            byte by = this.az;
            this.f[by] = this.f[by] - this.d[this.az] / 2;
        }
        if (this.g == 2) {
            byte by = this.az;
            this.f[by] = this.f[by] - this.d[this.az];
        }
        this.g[this.az] = this.j;
        this.az = (byte)(this.az + 1);
    }

    final void dN() {
        this.c[this.k] = this.a.length();
        this.d[this.k] = this.c[this.k] - 1;
        this.f[this.k] = this.h;
        this.e[this.k] = this.i;
        this.be = 0;
        while (this.be < this.c[this.k]) {
            this.D = this.a.charAt(this.be);
            this.dJ();
            this.u[this.k][this.be] = (byte)(this.E / 30);
            this.t[this.k][this.be] = (byte)(this.E % 30);
            if (this.j == 0) {
                short s = this.k;
                this.d[s] = this.d[s] + (b.a[this.u[this.k][this.be]][this.t[this.k][this.be] + 1] - b.a[this.u[this.k][this.be]][this.t[this.k][this.be]]);
            } else {
                short s = this.k;
                this.d[s] = this.d[s] + (b.a[this.t[this.k][this.be] + 1] - b.a[this.t[this.k][this.be]]);
            }
            ++this.be;
        }
        if (this.g == 1) {
            short s = this.k;
            this.f[s] = this.f[s] - this.d[this.k] / 2;
        }
        if (this.g == 2) {
            short s = this.k;
            this.f[s] = this.f[s] - this.d[this.k];
        }
        this.g[this.k] = this.j;
    }

    final void dO() {
        ++this.a;
        if (this.a >= 100) {
            this.a = 0;
        }
        this.bg = 0;
        while (this.bg < this.az) {
            this.bi = this.f[this.bg];
            this.bm = 0;
            this.bh = 0;
            while (this.bh < this.c[this.bg]) {
                if (this.g[this.bg] == 0) {
                    this.bj = 0;
                    if (this.u[this.bg][this.bh] == 0 && this.t[this.bg][this.bh] >= 24) {
                        this.bl = -1 - (this.bk + b.a[this.u[this.bg][this.bh]][this.t[this.bg][this.bh] + 1] - b.a[this.u[this.bg][this.bh]][this.t[this.bg][this.bh]]) / 2;
                        ++this.bm;
                    } else {
                        this.bl = 0;
                    }
                    this.bk = b.a[this.u[this.bg][this.bh]][this.t[this.bg][this.bh] + 1] - b.a[this.u[this.bg][this.bh]][this.t[this.bg][this.bh]];
                    this.bn = this.P;
                    if (this.v && this.P > 1) {
                        --this.bn;
                    }
                    if (!(this.R == 26 || this.v[this.R] <= 0 || this.o || this.b != 3 || this.bg - this.aI[this.h[94] + this.R] != this.bn || this.a[this.R][this.P] == 11 || this.a[this.R][this.P] == 12 && this.m)) {
                        this.bj = this.a[(this.bh + this.a - this.bm) % 4];
                    }
                    this.a[this.a].drawRegion(this.c[6], (int)b.a[this.u[this.bg][this.bh]][this.t[this.bg][this.bh]], (int)b.a[this.u[this.bg][this.bh]], this.bk, (int)b.b[this.u[this.bg][this.bh]], 0, this.bi + this.bl, this.e[this.bg] + this.bj, 20);
                    if (this.bl == 0) {
                        this.bi += this.bk + 1;
                    }
                } else {
                    this.a[this.a].drawRegion(this.c[6], (int)b.a[this.t[this.bg][this.bh]], 58, b.a[this.t[this.bg][this.bh] + 1] - b.a[this.t[this.bg][this.bh]], 15, 0, this.bi, this.e[this.bg], 20);
                    this.bi += b.a[this.t[this.bg][this.bh] + 1] - b.a[this.t[this.bg][this.bh]] + 1;
                }
                ++this.bh;
            }
            ++this.bg;
        }
    }

    final void dP() {
        if (this.aG == 0) {
            return;
        }
        this.bg = 0;
        while (this.bg < this.aF) {
            if (this.l[this.bg] < this.o) {
                this.bi = this.k[this.bg] + (this.v[this.bg][0] + this.v[this.bg][1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W;
                this.bh = 0;
                while (this.bh < this.h[this.bg]) {
                    this.a[this.a].drawRegion(this.c[6], (int)b.a[this.w[this.bg][this.bh]], 58, b.a[this.w[this.bg][this.bh] + 1] - b.a[this.w[this.bg][this.bh]], 15, 0, this.bi, this.j[this.bg] + (this.v[this.bg][0] - this.v[this.bg][1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X - 2 * this.l[this.bg], 20);
                    this.bi += b.a[this.w[this.bg][this.bh] + 1] - b.a[this.w[this.bg][this.bh]] + 1;
                    ++this.bh;
                }
            }
            ++this.bg;
        }
    }

    final void dQ() {
        this.bg = this.F;
        while (this.bg < this.F + d.j[this.aC]) {
            if (this.bg >= this.G) {
                return;
            }
            this.bi = (this.l - this.m[this.bg]) / 2;
            this.bh = this.l[this.bg];
            while (this.bh < this.l[this.bg + 1]) {
                if (this.s[this.aC][this.bh] != 100) {
                    if (this.s[this.aC][this.bh] >= 101) {
                        this.bl = this.s[this.aC][this.bh] - 101;
                        this.a[this.a].drawRegion(this.c[7], (int)this.aI[this.h[71] + this.aI[this.h[96] + this.bl]], (int)this.aI[this.h[72] + this.aI[this.h[96] + this.bl]], (int)this.aI[this.h[73] + this.aI[this.h[96] + this.bl]], (int)this.aI[this.h[74] + this.aI[this.h[96] + this.bl]], 0, this.bi, this.H + 20 * (this.bg - this.F) + (b.b[0] - this.aI[this.h[74] + this.aI[this.h[96] + this.bl]]) / 2, 20);
                        this.bi += this.aI[this.h[73] + this.aI[this.h[96] + this.bl]] + 1;
                    } else {
                        this.bl = this.s[this.aC][this.bh] / 30 == 0 && this.s[this.aC][this.bh] % 30 >= 24 ? -1 - (this.bk + b.a[this.s[this.aC][this.bh] / 30][this.s[this.aC][this.bh] % 30 + 1] - b.a[this.s[this.aC][this.bh] / 30][this.s[this.aC][this.bh] % 30]) / 2 : 0;
                        this.bk = b.a[this.s[this.aC][this.bh] / 30][this.s[this.aC][this.bh] % 30 + 1] - b.a[this.s[this.aC][this.bh] / 30][this.s[this.aC][this.bh] % 30];
                        this.a[this.a].drawRegion(this.c[6], (int)b.a[this.s[this.aC][this.bh] / 30][this.s[this.aC][this.bh] % 30], (int)b.a[this.s[this.aC][this.bh] / 30], this.bk, (int)b.b[this.s[this.aC][this.bh] / 30], 0, this.bi + this.bl, this.H + 20 * (this.bg - this.F), 20);
                        if (this.bl == 0) {
                            this.bi += this.bk + 1;
                        }
                    }
                }
                ++this.bh;
            }
            ++this.bg;
        }
    }

    final void dR() {
        try {
            this.dU();
            if (this.x) {
                if (this.K == 0) {
                    this.J = this.M;
                } else {
                    this.H = this.L;
                    this.I = this.M;
                }
                this.dS();
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void a(boolean[] blArray, byte[] byArray, short[] sArray, int[] nArray, int n, int n2, int n3) {
        try {
            this.bs = 0;
            while (this.bs < n2) {
                this.c <<= n;
                this.bu += n;
                if (blArray != null) {
                    if (blArray[this.bs]) {
                        ++this.c;
                    }
                } else if (byArray != null) {
                    this.c += (long)(byArray[this.bs] + n3);
                } else if (sArray != null) {
                    this.c += (long)(sArray[this.bs] + n3);
                } else if (nArray != null) {
                    this.c += (long)(nArray[this.bs] + n3);
                }
                if (this.bu >= 32 || this.bs == n2 - 1) {
                    while (this.bu >= 8) {
                        this.a.write((int)(this.c >> this.bu - 8));
                        this.bu -= 8;
                    }
                }
                ++this.bs;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void b(boolean[] blArray, byte[] byArray, short[] sArray, int[] nArray, int n, int n2, int n3) {
        try {
            this.bv = 1;
            this.bs = 0;
            while (this.bs < n) {
                this.bv *= 2;
                ++this.bs;
            }
            --this.bv;
            this.bs = 0;
            while (this.bs < n2) {
                while (this.bu < n) {
                    this.c <<= 8;
                    this.c += (long)this.a.read();
                    this.bu += 8;
                }
                this.bt = (int)(this.c >> this.bu - n & (long)this.bv);
                this.bt -= n3;
                if (blArray != null) {
                    blArray[this.bs] = this.bt > 0;
                } else if (byArray != null) {
                    byArray[this.bs] = (byte)this.bt;
                } else if (sArray != null) {
                    sArray[this.bs] = (short)this.bt;
                } else if (nArray != null) {
                    nArray[this.bs] = this.bt;
                }
                this.bu -= n;
                ++this.bs;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dS() {
        try {
            this.a = new ByteArrayOutputStream();
            this.a = new DataOutputStream(this.a);
            this.a.write(this.E);
            this.a.write(this.F);
            this.a.write(this.G);
            this.a.write(this.H);
            this.a.write(this.I);
            this.a.write(this.J);
            this.a.write(this.aJ);
            this.bu = 0;
            this.a(this.i, null, null, null, 1, this.i.length, 0);
            if (this.bu > 0) {
                this.a.write((int)(this.c << 8 - this.bu));
            }
            try {
                RecordStore.deleteRecordStore((String)"prehSetSave");
            }
            catch (Exception exception) {}
            this.a = RecordStore.openRecordStore((String)"prehSetSave", (boolean)true);
            if (this.a.getSizeAvailable() >= this.a.size()) {
                this.a.addRecord(this.a.toByteArray(), 0, this.a.size());
            }
            this.a.closeRecordStore();
            this.a.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dT() {
        try {
            this.a = RecordStore.openRecordStore((String)"prehSetSave", (boolean)true);
            this.x = false;
            if (this.a.getNumRecords() > 0) {
                this.x = true;
                System.gc();
                this.a = new DataInputStream(new ByteArrayInputStream(this.a.getRecord(1)));
                this.E = (byte)this.a.read();
                this.F = (byte)this.a.read();
                this.G = (byte)this.a.read();
                this.H = (byte)this.a.read();
                this.I = (byte)this.a.read();
                this.J = (byte)this.a.read();
                this.aJ = (byte)this.a.read();
                this.bu = 0;
                this.b(this.i, null, null, null, 1, this.i.length, 0);
                this.v[8] = this.E;
                this.a.close();
            }
            this.a.closeRecordStore();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dU() {
        try {
            this.x = false;
            System.gc();
            this.a = new ByteArrayOutputStream();
            this.a = new DataOutputStream(this.a);
            this.dV();
            this.dW();
            this.dX();
            this.dY();
            if (this.K == 0) {
                try {
                    RecordStore.deleteRecordStore((String)"prehCustSave");
                }
                catch (Exception exception) {}
                this.a = RecordStore.openRecordStore((String)"prehCustSave", (boolean)true);
            } else {
                try {
                    RecordStore.deleteRecordStore((String)"prehCampSave");
                }
                catch (Exception exception) {}
                this.a = RecordStore.openRecordStore((String)"prehCampSave", (boolean)true);
            }
            if (this.a.getSizeAvailable() >= this.a.size() + 200) {
                this.a.addRecord(this.a.toByteArray(), 0, this.a.size());
                this.x = true;
            }
            this.a.closeRecordStore();
            this.a.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dV() {
        try {
            this.a.writeInt(this.b);
            if (this.K == 1) {
                this.a.write((byte)this.c);
            } else {
                this.a.write(this.N);
            }
            this.a.writeInt(this.d);
            this.a.writeInt(this.e);
            this.a.writeInt(this.g);
            this.a.writeInt(this.f);
            this.a.write(this.g);
            this.a.write(this.w);
            this.a.writeInt(this.i);
            this.a.write(this.P);
            this.a.write(this.y);
            this.a.write(this.R);
            this.a.writeInt(this.k);
            this.a.write(this.ab);
            this.a.writeShort(this.a);
            this.a.write(this.ac);
            this.a.write(this.ag);
            this.a.write(this.ah);
            this.a.write(this.ai);
            this.a.write(this.ak);
            if (this.K == 1) {
                this.a.write(this.D);
                this.a.write(this.N);
            }
            this.bu = 0;
            if (this.K == 1) {
                this.a(null, this.b, null, null, 1, this.b.length, 0);
            }
            this.a(this.j, null, null, null, 1, this.j.length, 0);
            this.bo = 0;
            while (this.bo < 3) {
                this.a(null, null, null, this.e[this.bo], 20, 1, 5000);
                ++this.bo;
            }
            this.a(null, null, null, this.c[0], 24, d.k[4] + 2, 5000);
            this.a(null, null, null, this.c[1], 4, d.k[4] + 2, 1);
            this.a(null, null, null, this.c[2], 8, d.k[4] + 2, 1);
            if (this.K == 0) {
                this.bo = 3;
                while (this.bo < 8) {
                    this.a(null, null, null, this.c[this.bo], 10, d.k[4] + 2, 1);
                    ++this.bo;
                }
                this.a(null, this.aW, null, null, 3, 4, 0);
                this.a(null, this.aX, null, null, 2, 4, 0);
            }
            this.bo = 0;
            while (this.bo < 30) {
                this.a(null, this.b[this.bo], null, null, 6, 30, 29);
                this.a(null, this.c[this.bo], null, null, 7, 30, 1);
                ++this.bo;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dW() {
        try {
            this.a(null, null, null, this.a, 5, 2, 1);
            this.bo = 0;
            while (this.bo < 4) {
                this.a(null, null, null, this.f[this.bo], 7, 2, 25);
                ++this.bo;
            }
            this.bo = 0;
            while (this.bo < 222) {
                if (this.I[this.bo] < 1) {
                    this.I[this.bo] = 1;
                }
                ++this.bo;
            }
            this.a(null, this.B, null, null, 5, this.B.length, 1);
            this.a(null, this.C, null, null, 5, this.C.length, 1);
            this.a(null, this.D, null, null, 5, this.D.length, 1);
            this.a(null, this.E, null, null, 5, this.E.length, 1);
            this.a(null, this.G, null, null, 8, this.G.length, 128);
            this.a(null, this.H, null, null, 8, this.H.length, 128);
            this.a(null, this.A, null, null, 4, this.A.length, 1);
            this.a(null, this.F, null, null, 3, this.F.length, 0);
            this.a(null, this.I, null, null, 2, this.I.length, -1);
            this.a(null, this.W, null, null, 5, this.W.length, 1);
            this.a(null, this.X, null, null, 3, this.X.length, 0);
            this.bo = 0;
            while (this.bo < 3) {
                this.a(null, this.f[this.bo], null, null, 6, 200, 2);
                this.a(null, this.h[this.bo], null, null, 3, 222, 2);
                ++this.bo;
            }
            this.a(null, this.L, null, null, 7, this.L.length, 10);
            this.a(null, null, this.b, null, 4, this.b.length, 1);
            this.a(null, this.M, null, null, 3, this.M.length, 1);
            this.a(null, null, this.e, null, 10, this.e.length, 10);
            this.bo = 0;
            while (this.bo < 30) {
                this.a(null, this.i[this.bo], null, null, 5, 2, 1);
                ++this.bo;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dX() {
        try {
            this.bo = 0;
            while (this.bo < 15) {
                this.a(null, this.k[this.bo], null, null, 5, 2, 1);
                ++this.bo;
            }
            this.a(null, this.Z, null, null, 5, this.Z.length, 1);
            this.a(null, this.aa, null, null, 2, this.aa.length, 1);
            this.a(null, this.ab, null, null, 7, this.ab.length, 1);
            this.a(null, this.ad, null, null, 5, this.ad.length, 1);
            this.a(null, this.ae, null, null, 5, this.ae.length, 1);
            this.a(null, this.af, null, null, 8, this.af.length, 128);
            this.a(null, this.ag, null, null, 3, this.ag.length, 1);
            this.a(null, this.ah, null, null, 7, this.ah.length, 10);
            this.a(null, this.ai, null, null, 2, this.ai.length, 0);
            this.a(null, this.aj, null, null, 2, this.aj.length, 1);
            this.a(this.a, null, null, null, 1, this.a.length, 0);
            this.a(this.b, null, null, null, 1, this.b.length, 0);
            this.a(this.c, null, null, null, 1, this.c.length, 0);
            if (this.K == 1) {
                this.a(this.g, null, null, null, 1, this.g.length, 0);
            }
            this.bo = 0;
            while (this.bo < 2) {
                this.a(null, this.l[this.bo], null, null, 5, 42, 1);
                this.a(null, this.m[this.bo], null, null, 5, 42, 1);
                this.a(null, this.n[this.bo], null, null, 5, 42, 1);
                ++this.bo;
            }
            this.a(null, this.ak, null, null, 7, this.ak.length, 10);
            this.a(this.d, null, null, null, 1, this.d.length, 0);
            this.a(this.e, null, null, null, 1, this.e.length, 0);
            this.a(this.f, null, null, null, 1, this.f.length, 0);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dY() {
        try {
            if (this.K == 1) {
                this.a(this.h, null, null, null, 1, this.h.length, 0);
            }
            this.a(null, this.al, null, null, 4, this.al.length, 0);
            this.a(null, this.aE, null, null, 4, this.aE.length, 0);
            this.a(null, null, this.g, null, 9, this.g.length, 256);
            if (this.K == 1) {
                this.a(this.g, null, null, null, 1, this.g.length, 0);
                this.a(this.h, null, null, null, 1, this.h.length, 0);
            }
            if (this.bu > 0) {
                this.a.write((int)(this.c << 8 - this.bu));
            }
            this.bo = 0;
            while (this.bo < this.ae) {
                this.bq = 0;
                this.bp = 0;
                while (this.bp < 200) {
                    if (this.B[this.bp] >= 0) {
                        this.bq += this.g[this.bo][this.bp];
                    }
                    ++this.bp;
                }
                if (this.a > 0) {
                    this.bq /= this.a;
                }
                this.a.writeInt(this.bq);
                ++this.bo;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dZ() {
        try {
            if (this.K == 0) {
                this.M = this.J;
            } else {
                if (this.F > this.H) {
                    this.L = this.F;
                    this.M = this.G;
                    this.R = (byte)10;
                    this.w[10] = this.n[this.L];
                    this.ct();
                    return;
                }
                this.L = this.H;
                this.M = this.I;
            }
            this.g();
            this.a = this.K == 0 ? RecordStore.openRecordStore((String)"prehCustSave", (boolean)true) : RecordStore.openRecordStore((String)"prehCampSave", (boolean)true);
            if (this.a.getNumRecords() > 0) {
                System.gc();
                this.a = new DataInputStream(new ByteArrayInputStream(this.a.getRecord(1)));
                this.ea();
                this.eb();
                this.ec();
                this.ed();
                this.ee();
                this.a.close();
            }
            this.a.closeRecordStore();
            this.az = 0;
            this.b = 0;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void ea() {
        try {
            this.b = this.a.readInt();
            if (this.K == 1) {
                this.c = this.a.read();
            } else {
                this.N = (byte)this.a.read();
            }
            this.d = this.a.readInt();
            this.e = this.a.readInt();
            this.g = this.a.readInt();
            this.f = this.a.readInt();
            this.g = (byte)this.a.read();
            this.w = (byte)this.a.read();
            this.i = this.a.readInt();
            this.P = (byte)this.a.read();
            this.y = (byte)this.a.read();
            this.R = (byte)this.a.read();
            this.k = this.a.readInt();
            this.ab = (byte)this.a.read();
            this.a = this.a.readShort();
            this.ac = (byte)this.a.read();
            this.ag = (byte)this.a.read();
            this.ah = (byte)this.a.read();
            this.ai = (byte)this.a.read();
            this.ak = (byte)this.a.read();
            if (this.K == 1) {
                this.D = (byte)this.a.read();
                this.N = (byte)this.a.read();
            }
            this.bu = 0;
            if (this.K == 1) {
                this.b(null, this.b, null, null, 1, this.b.length, 0);
            }
            this.b(this.j, null, null, null, 1, this.j.length, 0);
            this.bo = 0;
            while (this.bo < 3) {
                this.b(null, null, null, this.e[this.bo], 20, 1, 5000);
                ++this.bo;
            }
            this.b(null, null, null, this.c[0], 24, d.k[4] + 2, 5000);
            this.b(null, null, null, this.c[1], 4, d.k[4] + 2, 1);
            this.b(null, null, null, this.c[2], 8, d.k[4] + 2, 1);
            if (this.K == 0) {
                this.bo = 3;
                while (this.bo < 8) {
                    this.b(null, null, null, this.c[this.bo], 10, d.k[4] + 2, 1);
                    ++this.bo;
                }
                this.b(null, this.aW, null, null, 3, 4, 0);
                this.b(null, this.aX, null, null, 2, 4, 0);
            }
            this.bo = 0;
            while (this.bo < 30) {
                this.b(null, this.b[this.bo], null, null, 6, 30, 29);
                this.b(null, this.c[this.bo], null, null, 7, 30, 1);
                ++this.bo;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void eb() {
        try {
            this.b(null, null, null, this.a, 5, 2, 1);
            this.bo = 0;
            while (this.bo < 4) {
                this.b(null, null, null, this.f[this.bo], 7, 2, 25);
                ++this.bo;
            }
            this.b(null, this.B, null, null, 5, this.B.length, 1);
            this.b(null, this.C, null, null, 5, this.C.length, 1);
            this.b(null, this.D, null, null, 5, this.D.length, 1);
            this.b(null, this.E, null, null, 5, this.E.length, 1);
            this.b(null, this.G, null, null, 8, this.G.length, 128);
            this.b(null, this.H, null, null, 8, this.H.length, 128);
            this.b(null, this.A, null, null, 4, this.A.length, 1);
            this.b(null, this.F, null, null, 3, this.F.length, 0);
            this.b(null, this.I, null, null, 2, this.I.length, -1);
            this.b(null, this.W, null, null, 5, this.W.length, 1);
            this.b(null, this.X, null, null, 3, this.X.length, 0);
            this.bo = 0;
            while (this.bo < 3) {
                this.b(null, this.f[this.bo], null, null, 6, 200, 2);
                this.b(null, this.h[this.bo], null, null, 3, 222, 2);
                ++this.bo;
            }
            this.b(null, this.L, null, null, 7, this.L.length, 10);
            this.b(null, null, this.b, null, 4, this.b.length, 1);
            this.b(null, this.M, null, null, 3, this.M.length, 1);
            this.b(null, null, this.e, null, 10, this.e.length, 10);
            this.bo = 0;
            while (this.bo < 30) {
                this.b(null, this.i[this.bo], null, null, 5, 2, 1);
                ++this.bo;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void ec() {
        try {
            this.bo = 0;
            while (this.bo < 15) {
                this.b(null, this.k[this.bo], null, null, 5, 2, 1);
                ++this.bo;
            }
            this.b(null, this.Z, null, null, 5, this.Z.length, 1);
            this.b(null, this.aa, null, null, 2, this.aa.length, 1);
            this.b(null, this.ab, null, null, 7, this.ab.length, 1);
            this.b(null, this.ad, null, null, 5, this.ad.length, 1);
            this.b(null, this.ae, null, null, 5, this.ae.length, 1);
            this.b(null, this.af, null, null, 8, this.af.length, 128);
            this.b(null, this.ag, null, null, 3, this.ag.length, 1);
            this.b(null, this.ah, null, null, 7, this.ah.length, 10);
            this.b(null, this.ai, null, null, 2, this.ai.length, 0);
            this.b(null, this.aj, null, null, 2, this.aj.length, 1);
            this.b(this.a, null, null, null, 1, this.a.length, 0);
            this.b(this.b, null, null, null, 1, this.b.length, 0);
            this.b(this.c, null, null, null, 1, this.c.length, 0);
            if (this.K == 1) {
                this.b(this.g, null, null, null, 1, this.g.length, 0);
            }
            this.bo = 0;
            while (this.bo < 2) {
                this.b(null, this.l[this.bo], null, null, 5, 42, 1);
                this.b(null, this.m[this.bo], null, null, 5, 42, 1);
                this.b(null, this.n[this.bo], null, null, 5, 42, 1);
                ++this.bo;
            }
            this.bo = 0;
            while (this.bo < 2) {
                this.ac[this.bo] = 0;
                if (this.Z[this.bo] == 23) {
                    this.bp = 0;
                    while (this.bp < 12) {
                        this.e[this.bo][this.bp] = -1;
                        ++this.bp;
                    }
                }
                ++this.bo;
            }
            this.b(null, this.ak, null, null, 7, this.ak.length, 10);
            this.b(this.d, null, null, null, 1, this.d.length, 0);
            this.b(this.e, null, null, null, 1, this.e.length, 0);
            this.b(this.f, null, null, null, 1, this.f.length, 0);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void ed() {
        try {
            if (this.K == 1) {
                this.b(this.h, null, null, null, 1, this.h.length, 0);
            }
            this.b(null, this.al, null, null, 4, this.al.length, 0);
            this.b(null, this.aE, null, null, 4, this.aE.length, 0);
            this.b(null, null, this.g, null, 9, this.g.length, 256);
            if (this.K == 1) {
                this.b(this.g, null, null, null, 1, this.g.length, 0);
                this.b(this.h, null, null, null, 1, this.h.length, 0);
            } else {
                this.bo = 0;
                while (this.bo < this.g.length) {
                    this.g[this.bo] = true;
                    ++this.bo;
                }
                this.bo = 0;
                while (this.bo < this.h.length) {
                    this.h[this.bo] = true;
                    ++this.bo;
                }
            }
            this.bo = 0;
            while (this.bo < this.ae) {
                this.br = this.bq = this.a.readInt();
                if (100 - this.bq < this.bq) {
                    this.br = 100 - this.bq;
                }
                ++this.br;
                this.bp = 0;
                while (this.bp < 200) {
                    if (this.B[this.bp] >= 0) {
                        this.g[this.bo][this.bp] = (byte)(this.bq + ((this.a.nextInt() & 0xFFFF) % this.br - this.br / 2));
                    }
                    ++this.bp;
                }
                ++this.bo;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void ee() {
        try {
            this.bo = 0;
            while (this.bo < 222) {
                if (this.B[this.bo] >= 0) {
                    this.c[this.bo] = 5;
                    this.J[this.bo] = 0;
                    if (this.bo < 200) {
                        if (this.W[this.bo] == 11) {
                            this.W[this.bo] = 9;
                            byte by = this.c[this.B[this.bo]][this.C[this.bo]];
                            this.ad[by] = (byte)(this.ad[by] - 1);
                        } else if (this.W[this.bo] == 12 || this.W[this.bo] == 13) {
                            this.e[this.c[this.B[this.bo]][this.C[this.bo]]][this.ac[this.c[this.B[this.bo]][this.C[this.bo]]]] = (short)this.bo;
                            if (this.o[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][this.g[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][4] + 0] == 1 && this.W[this.bo] == 13) {
                                if (this.o[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][this.g[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][2] + 2] == 0) {
                                    this.G[this.bo] = this.o[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][this.g[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][21] + 0 * this.au[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]] + this.ac[this.c[this.B[this.bo]][this.C[this.bo]]]];
                                }
                                if (this.o[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][this.g[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][2] + 3] == 0) {
                                    this.H[this.bo] = this.o[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][this.g[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][22] + 0 * this.au[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]] + this.ac[this.c[this.B[this.bo]][this.C[this.bo]]]];
                                }
                                if (this.o[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][this.g[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][2] + 4] == 0) {
                                    this.F[this.bo] = this.o[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][this.g[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]][23] + 0 * this.au[this.Z[this.c[this.B[this.bo]][this.C[this.bo]]]] + this.ac[this.c[this.B[this.bo]][this.C[this.bo]]]];
                                }
                            }
                            byte by = this.c[this.B[this.bo]][this.C[this.bo]];
                            this.ac[by] = (byte)(this.ac[by] + 1);
                        }
                        this.N[this.bo] = -1;
                        this.O[this.bo] = -1;
                    }
                }
                ++this.bo;
            }
            this.az = 0;
            this.aG = 0;
            this.bo = 0;
            while (this.bo < 222) {
                this.d[this.bo] = -1;
                if (this.B[this.bo] >= 0) {
                    if (this.A[this.bo] == 9 && this.b[this.B[this.bo]][this.C[this.bo]] >= 4 && this.b[this.B[this.bo]][this.C[this.bo]] <= 12 && this.ag[this.c[this.B[this.bo]][this.C[this.bo]]] == 4) {
                        this.c[this.m[0][this.c[this.B[this.bo]][this.C[this.bo]]]][this.m[1][this.c[this.B[this.bo]][this.C[this.bo]]]] = (short)this.bo;
                    } else {
                        this.d[this.bo] = this.c[this.B[this.bo]][this.C[this.bo]];
                        this.c[this.B[this.bo]][this.C[this.bo]] = (short)this.bo;
                    }
                }
                ++this.bo;
            }
            this.bo = 0;
            while (this.bo < 24) {
                this.o = this.bo++;
                this.cH();
            }
            this.Y = 0;
            while (this.Y < this.O / 5) {
                this.Z = 0;
                while (this.Z < this.O / 5) {
                    this.cG();
                    this.Z = (byte)(this.Z + 1);
                }
                this.Y = (byte)(this.Y + 1);
            }
            this.dx();
            this.bo = 0;
            while (this.bo < 42) {
                if (this.l[0][this.bo] >= 0 && this.aD[this.Z[this.bo]] == 0) {
                    this.aD[this.Z[this.bo]] = (byte)(this.aA[this.Z[this.bo]] / b.au[0]);
                    this.aD[24] = (byte)(this.aD[24] + this.aD[this.Z[this.bo]]);
                }
                ++this.bo;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

