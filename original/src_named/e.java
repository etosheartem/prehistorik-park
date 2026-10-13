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

public final class e
extends GameCanvas
implements Runnable {
    boolean var_boolean_a = false;
    Park var_Park_a;
    boolean var_boolean_b = false;
    boolean var_boolean_c = false;
    Thread var_java_lang_Thread_a;
    Graphics var_javax_microedition_lcdui_Graphics_a = this.getGraphics();
    Image var_javax_microedition_lcdui_Image_a;
    Graphics var_javax_microedition_lcdui_Graphics_b;
    byte var_byte_a = 0;
    Graphics[] var_javax_microedition_lcdui_Graphics_arr_a = new Graphics[]{this.var_javax_microedition_lcdui_Graphics_a, this.var_javax_microedition_lcdui_Graphics_b};
    Random var_java_util_Random_a = new Random();
    long var_long_a = 0L;
    long var_long_b = 0L;
    int var_int_a = 0;
    byte[] var_byte_arr_a = new byte[]{0, 2, 0, -2};
    byte var_byte_b = (byte)3;
    byte var_byte_c;
    boolean var_boolean_d;
    boolean var_boolean_e;
    boolean var_boolean_f;
    boolean var_boolean_g;
    boolean var_boolean_h;
    boolean var_boolean_i;
    byte var_byte_d;
    byte var_byte_e;
    byte var_byte_f = (byte)-1;
    byte var_byte_g;
    byte var_byte_h;
    byte var_byte_i = (byte)-1;
    byte var_byte_j;
    boolean var_boolean_j;
    byte var_byte_k = (byte)24;
    byte var_byte_l = (byte)100;
    byte var_byte_m = (byte)4;
    byte var_byte_n = (byte)4;
    byte var_byte_o = (byte)15;
    byte var_byte_p = (byte)20;
    byte var_byte_q = (byte)20;
    byte var_byte_r = (byte)30;
    byte var_byte_s = (byte)10;
    byte var_byte_t = (byte)(this.var_byte_m * 10);
    byte var_byte_u = (byte)10;
    byte var_byte_v = (byte)45;
    byte var_byte_w;
    int var_int_b;
    int var_int_c;
    int var_int_d;
    int var_int_e;
    int var_int_f;
    int var_int_g;
    int var_int_h;
    final int[][] var_int_arr_arr_a = new int[][]{{500, 400, 500, 600, 650, 700}, {500, 300, 350, 400, 450, 500}};
    final int[][] var_int_arr_arr_b = new int[][]{{700}, {600}};
    final int[][][] var_int_arr_arr_arr_a = new int[][][]{new int[][]{{100, 2, 5}, {750, 5, 40}, {1500, 6, 80}, {3000, 7, 120}, {6000, 8, 150}, {10000, 9, 170}}, new int[][]{{100, 2, 5}, {1500, 6, 60}, {3000, 7, 100}, {5000, 8, 150}, {10000, 9, 180}, {15000, 9, 190}}};
    final int[][][] var_int_arr_arr_arr_b = new int[][][]{this.var_int_arr_arr_b, this.var_int_arr_arr_a};
    byte var_byte_x = (byte)7;
    byte var_byte_y;
    byte var_byte_z;
    byte var_byte_A;
    byte var_byte_B;
    byte var_byte_C;
    int var_int_i;
    byte[] var_byte_arr_b = new byte[19];
    byte var_byte_D;
    byte var_byte_E = 1;
    byte var_byte_F = (byte)-1;
    byte var_byte_G = (byte)-1;
    byte var_byte_H = (byte)-1;
    byte var_byte_I = (byte)-1;
    byte var_byte_J = (byte)-1;
    byte var_byte_K;
    byte var_byte_L;
    byte var_byte_M;
    byte var_byte_N = 0;
    boolean var_boolean_k;
    byte var_byte_O;
    byte var_byte_P = 0;
    byte var_byte_Q;
    byte var_byte_R = (byte)15;
    byte var_byte_S;
    byte var_byte_T;
    final byte[] var_byte_arr_c = new byte[]{1, 0, 2, 95, 3, 107};
    final byte[] var_byte_arr_d = new byte[]{21, 4, 6, 2, 3, 5};
    final byte[] var_byte_arr_e = new byte[]{8, 9};
    final byte[] var_byte_arr_f = new byte[]{10, 11};
    final byte[] var_byte_arr_g = new byte[]{12, 11};
    final byte[] var_byte_arr_h = new byte[]{13};
    final byte[] var_byte_arr_i = new byte[]{10, 12, 11};
    final byte[] var_byte_arr_j = new byte[]{12};
    final byte[] var_byte_arr_k = new byte[]{14, 15, 16, 17, 18, 99};
    final byte[] var_byte_arr_l = new byte[]{41};
    final byte[] var_byte_arr_m = new byte[]{21, 22};
    final byte[] var_byte_arr_n = new byte[]{94, 24, 25, 26, 27, 28};
    final byte[] var_byte_arr_o = new byte[]{30, 31, 16, 32, 33};
    final byte[] var_byte_arr_p = new byte[]{35};
    final byte[] var_byte_arr_q = new byte[]{36};
    final byte[] var_byte_arr_r = new byte[]{37};
    final byte[] var_byte_arr_s = new byte[]{108, 109, 110, 111, 112};
    final byte[] var_byte_arr_t = new byte[]{96, 97};
    final byte[] var_byte_arr_u = new byte[]{100, 101, 102, 103, 104};
    final byte[][] var_byte_arr_arr_a = new byte[][]{this.var_byte_arr_c, this.var_byte_arr_d, new byte[0], new byte[0], this.var_byte_arr_l, new byte[0], this.var_byte_arr_m, this.var_byte_arr_t, this.var_byte_arr_n, this.var_byte_arr_s, new byte[0], this.var_byte_arr_o, {39}, {34}, this.var_byte_arr_p, this.var_byte_arr_q, this.var_byte_arr_r, this.var_byte_arr_e, this.var_byte_arr_f, this.var_byte_arr_g, this.var_byte_arr_h, this.var_byte_arr_i, this.var_byte_arr_j, new byte[0], new byte[0], this.var_byte_arr_u, this.var_byte_arr_k};
    byte[] var_byte_arr_v = new byte[]{6, 6, 0, 0, 1, 0, 2, 2, this.var_byte_E, 5, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 1, 3, 1, 0, 0, 0, 6};
    final byte[] var_byte_arr_w = new byte[]{-1, -1, 3, 95, 2, 20, -1, -1, 23, 107, 0, 29, -1, -1, -1, -1, -1, 7, 0, 0, 0, 0, 0, 19, 38, 98, 0};
    byte[] var_byte_arr_x = new byte[3];
    byte[] var_byte_arr_y = new byte[3];
    boolean var_boolean_l;
    boolean var_boolean_m;
    boolean var_boolean_n = false;
    boolean var_boolean_o = false;
    byte var_byte_U;
    int var_int_j;
    int[][] var_int_arr_arr_c = new int[8][d.var_short_arr_k[4] + 2];
    int[][] var_int_arr_arr_d = new int[][]{{0, 500}, {0, 10}, {0, 10}, {0, 50}};
    final short[] var_short_arr_a = new short[]{40, 100, 250, 150, 300, 200, 350, 50, 200, 400, 250, 500, 300, 600};
    int[][] var_int_arr_arr_e = new int[3][2];
    byte var_byte_V;
    int var_int_k;
    int var_int_l = 240;
    int var_int_m = 320;
    byte var_byte_W;
    byte var_byte_X;
    Image[] var_javax_microedition_lcdui_Image_arr_a = new Image[11];
    Image[] var_javax_microedition_lcdui_Image_arr_b = new Image[13];
    Image[] var_javax_microedition_lcdui_Image_arr_c = new Image[12];
    Image[][] var_javax_microedition_lcdui_Image_arr_arr_a = new Image[][]{this.var_javax_microedition_lcdui_Image_arr_a, this.var_javax_microedition_lcdui_Image_arr_b, this.var_javax_microedition_lcdui_Image_arr_c};
    Image[] var_javax_microedition_lcdui_Image_arr_d = new Image[4];
    byte[][] var_byte_arr_arr_b = new byte[30][30];
    byte[][] var_byte_arr_arr_c = new byte[30][30];
    short[][] var_short_arr_arr_a = new short[6][6];
    byte var_byte_Y;
    byte var_byte_Z;
    byte[][] var_byte_arr_arr_d = new byte[10][10];
    byte var_byte_aa = (byte)5;
    int var_int_n = 0;
    boolean var_boolean_p = true;
    byte var_byte_ab;
    byte[] var_byte_arr_z = new byte[4];
    int[] var_int_arr_a = new int[2];
    int[][] var_int_arr_arr_f = new int[4][2];
    short var_short_a;
    byte var_byte_ac;
    byte[] var_byte_arr_A = new byte[222];
    byte[] var_byte_arr_B = new byte[222];
    byte[] var_byte_arr_C = new byte[222];
    byte[] var_byte_arr_D = new byte[222];
    byte[] var_byte_arr_E = new byte[222];
    byte[] var_byte_arr_F = new byte[222];
    byte[] var_byte_arr_G = new byte[222];
    byte[] var_byte_arr_H = new byte[222];
    byte[][] var_byte_arr_arr_e = new byte[][]{this.var_byte_arr_G, this.var_byte_arr_H};
    byte[] var_byte_arr_I = new byte[222];
    byte[] var_byte_arr_J = new byte[222];
    byte[] var_byte_arr_K = new byte[]{0, 1, 0, 2};
    byte[][] var_byte_arr_arr_f = new byte[3][200];
    byte[] var_byte_arr_L = new byte[200];
    short[] var_short_arr_b = new short[200];
    byte[] var_byte_arr_M = new byte[200];
    byte[] var_byte_arr_N = new byte[200];
    byte[] var_byte_arr_O = new byte[200];
    byte[] var_byte_arr_P = new byte[200];
    byte[] var_byte_arr_Q = new byte[200];
    byte[] var_byte_arr_R = new byte[200];
    byte[] var_byte_arr_S = new byte[200];
    byte[] var_byte_arr_T = new byte[200];
    byte[] var_byte_arr_U = new byte[200];
    byte[] var_byte_arr_V = new byte[200];
    byte var_byte_ad = (byte)6;
    byte var_byte_ae = (byte)7;
    byte[] var_byte_arr_W = new byte[222];
    byte[][] var_byte_arr_arr_g = new byte[][]{this.var_byte_arr_P, this.var_byte_arr_Q, this.var_byte_arr_R, this.var_byte_arr_S, this.var_byte_arr_T, this.var_byte_arr_U, this.var_byte_arr_V, this.var_byte_arr_W, this.var_byte_arr_L};
    short[][] var_short_arr_arr_b = new short[][]{{20, 20, 25, 25, 20, 350, 50}, {12, 12, 16, 16, 12, 150, 25}};
    byte var_byte_af = (byte)20;
    short var_short_b = (short)2000;
    byte[][] var_byte_arr_arr_h = new byte[3][222];
    byte[] var_byte_arr_X = new byte[222];
    short[] var_short_arr_c = new short[222];
    short[][] var_short_arr_arr_c = new short[30][30];
    short[] var_short_arr_d = new short[222];
    short[][] var_short_arr_arr_d = new short[2][200];
    short var_short_c;
    short[] var_short_arr_e = new short[b.j[3] + 1];
    byte var_byte_ag;
    byte[][] var_byte_arr_arr_i = new byte[30][2];
    byte[] var_byte_arr_Y = new byte[30];
    byte[][] var_byte_arr_arr_j = new byte[30][20];
    byte[][][] var_byte_arr_arr_arr_a = new byte[30][20][2];
    byte var_byte_ah;
    byte[][] var_byte_arr_arr_k = new byte[15][2];
    byte var_byte_ai;
    byte[] var_byte_arr_Z = new byte[42];
    byte[] var_byte_arr_aa = new byte[42];
    byte[][] var_byte_arr_arr_l = new byte[2][42];
    byte[][] var_byte_arr_arr_m = new byte[2][42];
    byte[][] var_byte_arr_arr_n = new byte[2][42];
    byte[] var_byte_arr_ab = new byte[42];
    byte[] var_byte_arr_ac = new byte[42];
    short[][] var_short_arr_arr_e = new short[42][12];
    byte[] var_byte_arr_ad = new byte[42];
    byte[] var_byte_arr_ae = new byte[42];
    short[][] var_short_arr_arr_f = new short[42][10];
    byte[] var_byte_arr_af = new byte[42];
    byte[] var_byte_arr_ag = new byte[42];
    byte[] var_byte_arr_ah = new byte[42];
    byte[] var_byte_arr_ai = new byte[42];
    byte[] var_byte_arr_aj = new byte[42];
    boolean[] var_boolean_arr_a = new boolean[42];
    boolean[] var_boolean_arr_b = new boolean[42];
    boolean[] var_boolean_arr_c = new boolean[42];
    byte var_byte_aj = 0;
    byte var_byte_ak;
    byte[] var_byte_arr_ak = new byte[90];
    boolean[] var_boolean_arr_d = new boolean[90];
    boolean[] var_boolean_arr_e = new boolean[90];
    boolean[] var_boolean_arr_f = new boolean[90];
    boolean[] var_boolean_arr_g = new boolean[24];
    byte[] var_byte_arr_al = new byte[24];
    short[] var_short_arr_f = new short[24];
    byte[] var_byte_arr_am = new byte[24];
    byte[] var_byte_arr_an = new byte[24];
    byte[] var_byte_arr_ao = new byte[24];
    byte[] var_byte_arr_ap = new byte[24];
    byte[] var_byte_arr_aq = new byte[24];
    byte[] var_byte_arr_ar = new byte[24];
    byte[] var_byte_arr_as = new byte[24];
    byte[] var_byte_arr_at = new byte[24];
    byte[] var_byte_arr_au = new byte[24];
    byte[] var_byte_arr_av = new byte[24];
    byte[] var_byte_arr_aw = new byte[24];
    byte[] var_byte_arr_ax = new byte[24];
    byte[] var_byte_arr_ay = new byte[24];
    byte[] var_byte_arr_az = new byte[24];
    byte[] var_byte_arr_aA = new byte[24];
    byte[] var_byte_arr_aB = new byte[24];
    byte[] var_byte_arr_aC = new byte[24];
    byte[] var_byte_arr_aD = new byte[25];
    byte var_byte_al = (byte)114;
    byte[][] var_byte_arr_arr_o = new byte[24][];
    short[][] var_short_arr_arr_g = new short[24][42];
    byte[] var_byte_arr_aE = new byte[27];
    short[] var_short_arr_g = new short[6];
    boolean[] var_boolean_arr_h = new boolean[27];
    byte[] var_byte_arr_aF = new byte[27];
    byte[] var_byte_arr_aG = new byte[27];
    byte[] var_byte_arr_aH = new byte[27];
    byte[][] var_byte_arr_arr_p = new byte[27][];
    short[][] var_short_arr_arr_h = new short[27][16];
    boolean[][] var_boolean_arr_arr_a = new boolean[][]{this.var_boolean_arr_g, this.var_boolean_arr_h};
    int var_int_o;
    byte[] var_byte_arr_aI;
    short[] var_short_arr_h = new short[177];
    final byte[] var_byte_arr_aJ = new byte[]{24, 27};
    byte[][] var_byte_arr_arr_q = new byte[][]{{5, 6}, {34}, {7, 8}};
    byte[] var_byte_arr_aK = new byte[]{9, 10};
    byte[][] var_byte_arr_arr_r = new byte[][]{{2, 3, 3, 2}, {3, 2, 2, 3}};
    int var_int_p;
    int var_int_q;
    int var_int_r;
    int var_int_s;
    int var_int_t;
    int var_int_u;
    int var_int_v;
    int var_int_w;
    short var_short_d;
    int var_int_x;
    int var_int_y;
    int var_int_z;
    int var_int_A;
    int var_int_B;
    int var_int_C;
    int[] var_int_arr_b = new int[2];
    byte var_byte_am;
    byte var_byte_an;
    byte var_byte_ao;
    byte var_byte_ap;
    byte var_byte_aq;
    byte var_byte_ar;
    byte var_byte_as;
    byte var_byte_at;
    byte var_byte_au;
    byte var_byte_av;
    byte[] var_byte_arr_aL = new byte[2];
    byte[] var_byte_arr_aM = new byte[2];
    boolean var_boolean_q;
    boolean var_boolean_r;
    short var_short_e;
    byte var_byte_aw;
    byte var_byte_ax;
    byte[] var_byte_arr_aN = new byte[1500];
    short[] var_short_arr_i = new short[500];
    byte[] var_byte_arr_aO = new byte[3000];
    short[] var_short_arr_j = new short[50];
    byte[] var_byte_arr_aP = new byte[7000];
    short[] var_short_arr_k = new short[50];
    byte[][] var_byte_arr_arr_s = new byte[][]{this.var_byte_arr_aP, this.var_byte_arr_aO, this.var_byte_arr_aN, this.var_byte_arr_aO};
    short[][] var_short_arr_arr_i = new short[][]{this.var_short_arr_k, this.var_short_arr_j, this.var_short_arr_i, this.var_short_arr_j};
    String[] var_java_lang_String_arr_a = new String[]{"helptext.da", "warntext.da", "text.da"};
    int var_int_D;
    int var_int_E;
    byte var_byte_ay = (byte)20;
    byte var_byte_az = 0;
    byte[][] var_byte_arr_arr_t = new byte[this.var_byte_ay][80];
    byte[][] var_byte_arr_arr_u = new byte[this.var_byte_ay][80];
    int[] var_int_arr_c = new int[this.var_byte_ay];
    int[] var_int_arr_d = new int[this.var_byte_ay];
    int[] var_int_arr_e = new int[this.var_byte_ay];
    int[] var_int_arr_f = new int[this.var_byte_ay];
    int[] var_int_arr_g = new int[this.var_byte_ay];
    short[] var_short_arr_l = new short[250];
    short[] var_short_arr_m = new short[250];
    int var_int_F;
    int var_int_G;
    byte var_byte_aA;
    byte var_byte_aB = (byte)-1;
    byte var_byte_aC;
    int var_int_H;
    boolean[] var_boolean_arr_i = new boolean[32];
    byte var_byte_aD = (byte)2;
    boolean[] var_boolean_arr_j = new boolean[this.var_byte_aD];
    byte var_byte_aE = (byte)12;
    byte var_byte_aF = (byte)100;
    byte var_byte_aG = 0;
    byte[][] var_byte_arr_arr_v = new byte[this.var_byte_aF][2];
    byte[][] var_byte_arr_arr_w = new byte[this.var_byte_aF][5];
    int[] var_int_arr_h = new int[this.var_byte_aF];
    int[] var_int_arr_i = new int[this.var_byte_aF];
    int[] var_int_arr_j = new int[this.var_byte_aF];
    int[] var_int_arr_k = new int[this.var_byte_aF];
    int[] var_int_arr_l = new int[this.var_byte_aF];
    byte var_byte_aH = (byte)20;
    byte[][] var_byte_arr_arr_x = new byte[this.var_byte_aH][2];
    byte[] var_byte_arr_aQ = new byte[this.var_byte_aH];
    byte[] var_byte_arr_aR = new byte[this.var_byte_aH];
    byte[] var_byte_arr_aS = new byte[this.var_byte_aH];
    byte var_byte_aI = (byte)-60;
    short var_short_f;
    short var_short_g;
    short var_short_h;
    short var_short_i;
    short var_short_j = 0;
    short var_short_k;
    byte[] var_byte_arr_aT = new byte[2];
    String var_java_lang_String_a;
    StringBuffer var_java_lang_StringBuffer_a = new StringBuffer(50);
    InputStream var_java_io_InputStream_a = null;
    ByteArrayOutputStream var_java_io_ByteArrayOutputStream_a;
    DataOutputStream var_java_io_DataOutputStream_a;
    DataInputStream var_java_io_DataInputStream_a;
    RecordStore var_javax_microedition_rms_RecordStore_a;
    a var_a_a;
    byte var_byte_aJ = (byte)2;
    int var_int_I;
    int var_int_J;
    byte var_byte_aK;
    byte var_byte_aL;
    byte var_byte_aM;
    int var_int_K;
    int var_int_L;
    int var_int_M;
    boolean var_boolean_s;
    boolean var_boolean_t;
    int var_int_N = 0;
    int var_int_O;
    int var_int_P;
    int var_int_Q;
    int var_int_R;
    int var_int_S;
    int var_int_T;
    String[] var_java_lang_String_arr_b = new String[]{"arrsi.dat", "arr.dat"};
    int var_int_U;
    int var_int_V;
    int var_int_W;
    int var_int_X;
    int var_int_Y;
    int var_int_Z;
    int var_int_aa;
    short var_short_l;
    short var_short_m;
    short var_short_n;
    short var_short_o;
    int var_int_ab;
    int[] var_int_arr_m = new int[3];
    byte var_byte_aN;
    byte var_byte_aO;
    byte[] var_byte_arr_aU = new byte[4];
    byte[] var_byte_arr_aV = new byte[2];
    byte var_byte_aP;
    byte var_byte_aQ;
    byte var_byte_aR;
    int var_int_ac;
    int var_int_ad;
    int var_int_ae;
    int var_int_af;
    byte[] var_byte_arr_aW = new byte[4];
    byte[] var_byte_arr_aX = new byte[]{0, 1, 1, 2};
    int var_int_ag;
    boolean var_boolean_u;
    byte[] var_byte_arr_aY = new byte[6];
    int var_int_ah;
    int var_int_ai;
    int var_int_aj;
    int var_int_ak;
    int var_int_al;
    int var_int_am;
    byte var_byte_aS;
    byte var_byte_aT;
    byte var_byte_aU;
    int[] var_int_arr_n = new int[4];
    byte var_byte_aV;
    byte var_byte_aW;
    byte var_byte_aX;
    byte var_byte_aY;
    byte var_byte_aZ;
    int var_int_an;
    int var_int_ao;
    int var_int_ap;
    int[] var_int_arr_o = new int[2];
    int[] var_int_arr_p = new int[2];
    int var_int_aq;
    int var_int_ar;
    int var_int_as;
    int var_int_at;
    int var_int_au;
    int var_int_av;
    int var_int_aw;
    int var_int_ax;
    int var_int_ay;
    int var_int_az;
    int var_int_aA;
    int var_int_aB;
    int var_int_aC;
    int var_int_aD;
    int var_int_aE;
    int var_int_aF;
    boolean var_boolean_v;
    int[][] var_int_arr_arr_g = new int[2][this.var_byte_arr_u.length];
    int var_int_aG;
    int var_int_aH;
    int var_int_aI;
    int var_int_aJ;
    byte var_byte_ba;
    int var_int_aK;
    int var_int_aL;
    int var_int_aM;
    int var_int_aN;
    int var_int_aO;
    int var_int_aP;
    int var_int_aQ;
    int var_int_aR;
    byte var_byte_bb;
    byte var_byte_bc;
    byte var_byte_bd;
    boolean var_boolean_w;
    short var_short_p;
    short var_short_q;
    byte[] var_byte_arr_aZ = new byte[2];
    int var_int_aS;
    int var_int_aT;
    int var_int_aU;
    int var_int_aV;
    byte var_byte_be;
    byte var_byte_bf;
    int var_int_aW;
    byte var_byte_bg;
    byte var_byte_bh;
    int var_int_aX;
    byte var_byte_bi;
    int var_int_aY;
    int var_int_aZ;
    byte var_byte_bj;
    int var_int_ba;
    int var_int_bb;
    int var_int_bc;
    int var_int_bd;
    int var_int_be;
    int var_int_bf;
    int var_int_bg;
    int var_int_bh;
    int var_int_bi;
    int var_int_bj;
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
    long var_long_c;
    boolean var_boolean_x;

    public e(Park park) {
        super(false);
        this.var_Park_a = park;
        this.setFullScreenMode(true);
        this.var_Park_a.var_c_a.g = 10;
        this.var_Park_a.var_c_a.repaint();
    }

    final void void_a() {
        System.gc();
        this.t();
        System.gc();
        this.dG();
        this.var_Park_a.var_c_a.g = 60;
        this.var_Park_a.var_c_a.repaint();
        this.var_int_I = 0;
        while (this.var_int_I < 32) {
            this.var_boolean_arr_i[this.var_int_I] = false;
            ++this.var_int_I;
        }
        this.var_int_I = 0;
        while (this.var_int_I < this.var_byte_aD) {
            this.var_boolean_arr_j[this.var_int_I] = false;
            ++this.var_int_I;
        }
        this.var_a_a = new a("entry.mid", "audio/midi");
        this.var_a_a.a(6000);
        this.var_a_a.a(0, 1);
        this.dT();
        this.var_Park_a.var_c_a.g = 80;
        this.var_Park_a.var_c_a.repaint();
        this.void_b();
        this.var_javax_microedition_lcdui_Image_arr_d[0] = this.var_javax_microedition_lcdui_Image_arr_c[7];
        this.var_javax_microedition_lcdui_Image_arr_d[1] = this.var_javax_microedition_lcdui_Image_arr_c[7];
        this.var_javax_microedition_lcdui_Image_arr_d[2] = this.var_javax_microedition_lcdui_Image_arr_a[0];
        this.var_javax_microedition_lcdui_Image_arr_d[3] = this.var_javax_microedition_lcdui_Image_arr_c[7];
        this.var_int_I = 0;
        while (this.var_int_I < 10) {
            this.var_int_J = 0;
            while (this.var_int_J < 10) {
                this.var_byte_arr_arr_d[this.var_int_I][this.var_int_J] = (byte)(-1 - (this.var_java_util_Random_a.nextInt() & 0xFFFF) % 12);
                ++this.var_int_J;
            }
            ++this.var_int_I;
        }
        this.ct();
        this.var_Park_a.var_c_a.g = 100;
        this.var_Park_a.var_c_a.repaint();
        this.void_c();
    }

    final void void_b() {
        try {
            this.var_int_I = 0;
            while (this.var_int_I < 3) {
                System.gc();
                this.var_java_io_InputStream_a = this.getClass().getResourceAsStream("/gpack" + this.var_int_I + ".dat");
                if (this.var_java_io_InputStream_a != null) {
                    this.var_int_J = 0;
                    while (this.var_int_J < this.var_javax_microedition_lcdui_Image_arr_arr_a[this.var_int_I].length) {
                        System.gc();
                        this.var_int_u = this.var_java_io_InputStream_a.read();
                        this.var_int_v = this.var_java_io_InputStream_a.read();
                        int n = this.var_int_v * 256 + this.var_int_u;
                        if (n != 0) {
                            byte[] byArray = new byte[n];
                            this.var_java_io_InputStream_a.read(byArray, 0, n);
                            this.var_javax_microedition_lcdui_Image_arr_arr_a[this.var_int_I][this.var_int_J] = Image.createImage((byte[])byArray, (int)0, (int)n);
                        }
                        ++this.var_int_J;
                    }
                }
                this.var_java_io_InputStream_a.close();
                this.var_java_io_InputStream_a = null;
                this.var_Park_a.var_c_a.g = 85 + this.var_int_I * 5;
                this.var_Park_a.var_c_a.repaint();
                ++this.var_int_I;
            }
            System.gc();
            this.var_javax_microedition_lcdui_Image_arr_b[7] = this.var_javax_microedition_lcdui_Image_arr_a[10];
            this.var_javax_microedition_lcdui_Image_a = Image.createImage((int)this.var_int_l, (int)this.var_int_m);
            this.var_javax_microedition_lcdui_Graphics_arr_a[1] = this.var_javax_microedition_lcdui_Graphics_b = this.var_javax_microedition_lcdui_Image_a.getGraphics();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public final void void_c() {
        this.var_boolean_c = true;
        this.var_java_lang_Thread_a = new Thread(this);
        this.var_java_lang_Thread_a.start();
    }

    public final void void_d() {
        this.dS();
        this.var_boolean_c = false;
        this.var_a_a.c();
        this.var_Park_a.notifyDestroyed();
    }

    public final void hideNotify() {
        this.var_a_a.b();
        this.var_boolean_b = true;
    }

    public final void showNotify() {
        if (this.var_boolean_b) {
            this.var_boolean_b = false;
            this.void_e();
        }
    }

    final void void_e() {
        if (this.var_byte_b == 3 && this.var_byte_R == 16) {
            return;
        }
        this.var_byte_i = (byte)-1;
        this.var_boolean_p = true;
        this.var_byte_aK = this.var_byte_b;
        this.var_byte_aL = this.var_byte_R;
        this.var_byte_aM = this.var_byte_aA;
        this.var_byte_b = (byte)3;
        this.var_byte_R = (byte)16;
        this.cu();
        this.var_byte_aa = (byte)5;
    }

    final void void_f() {
        this.var_byte_b = this.var_byte_aK;
        this.var_byte_R = this.var_byte_aL;
        if (this.var_byte_b == 3) {
            this.cu();
        }
        if (this.var_byte_b == 2) {
            this.co();
        }
        if (this.var_byte_b == 1 || this.var_byte_b == 4) {
            this.var_byte_aK = this.var_byte_b;
            this.var_byte_b = 0;
            this.var_byte_a = 1;
            this.var_byte_aa = (byte)5;
            this.x();
            this.al();
            this.var_byte_a = 0;
            this.var_byte_b = this.var_byte_aK;
            this.var_byte_aa = 0;
        } else {
            this.var_byte_aa = (byte)5;
        }
        this.var_byte_aA = this.var_byte_aM;
        if ((this.var_byte_b != 3 || this.var_byte_R != 15) && this.var_byte_aJ > 0) {
            this.var_a_a.a();
        }
    }

    final void void_g() {
        this.void_h();
        this.void_i();
        this.void_j();
        this.var_byte_e = 0;
        this.var_byte_g = 0;
        this.var_byte_f = (byte)-1;
        this.var_byte_h = (byte)-1;
        this.var_int_K = 0;
        while (this.var_int_K < this.var_byte_aD) {
            this.var_boolean_arr_j[this.var_int_K] = false;
            ++this.var_int_K;
        }
        this.var_int_arr_arr_e[0][0] = this.var_int_k = this.var_int_arr_arr_arr_b[this.var_byte_K][this.var_byte_M][this.var_byte_L];
        this.var_int_arr_arr_e[1][0] = 0;
        this.var_int_arr_arr_e[2][0] = 0;
        this.var_int_K = 0;
        while (this.var_int_K < 8) {
            this.var_int_arr_arr_c[this.var_int_K][0] = this.var_int_K < 3 ? this.var_int_arr_arr_e[this.var_int_K][0] : 0;
            this.var_int_arr_arr_c[this.var_int_K][d.var_short_arr_k[4]] = 1;
            ++this.var_int_K;
        }
        this.var_int_b = 0;
        this.var_int_c = 0;
        this.var_int_d = 0;
        this.var_int_e = 0;
        this.var_int_f = 0;
        this.var_int_g = 0;
        this.var_byte_w = (byte)-1;
        this.var_byte_V = 0;
        this.var_byte_arr_arr_b[this.var_byte_ab][0] = 0;
    }

    final void void_h() {
        if (this.var_byte_K == 1) {
            this.var_int_c = 0;
            this.var_byte_O = this.var_byte_arr_aI[this.var_short_arr_h[134] + this.var_byte_L];
            this.var_int_K = 0;
            while (this.var_int_K < 2) {
                this.var_int_L = 0;
                while (this.var_int_L < this.var_byte_arr_aJ[this.var_int_K]) {
                    this.var_boolean_arr_arr_a[this.var_int_K][this.var_int_L] = this.var_byte_arr_aI[this.var_short_arr_h[40 + this.var_int_K] + this.var_byte_arr_aJ[this.var_int_K] * this.var_byte_L + this.var_int_L] == 1;
                    ++this.var_int_L;
                }
                ++this.var_int_K;
            }
            this.var_int_K = 0;
            while (this.var_int_K < this.var_byte_arr_b.length) {
                this.var_byte_arr_b[this.var_int_K] = 0;
                ++this.var_int_K;
            }
            this.var_byte_D = 0;
            this.var_int_arr_arr_e[0][1] = this.var_int_arr_arr_arr_a[this.var_byte_M][this.var_byte_L][0];
            this.var_int_arr_arr_e[1][1] = this.var_int_arr_arr_arr_a[this.var_byte_M][this.var_byte_L][1];
            this.var_int_arr_arr_e[2][1] = this.var_int_arr_arr_arr_a[this.var_byte_M][this.var_byte_L][2];
        } else if (this.var_byte_K == 0) {
            this.var_int_K = 0;
            while (this.var_int_K < 2) {
                this.var_int_L = 0;
                while (this.var_int_L < this.var_boolean_arr_arr_a[this.var_int_K].length) {
                    this.var_boolean_arr_arr_a[this.var_int_K][this.var_int_L] = true;
                    ++this.var_int_L;
                }
                ++this.var_int_K;
            }
            this.var_byte_O = (byte)30;
        }
        this.var_byte_ab = (byte)(this.var_byte_O / 2);
        this.var_int_arr_a[0] = this.var_byte_ab;
        this.var_int_arr_a[1] = 0;
        this.r();
    }

    final void void_i() {
        this.var_int_K = 0;
        while (this.var_int_K < this.var_byte_O) {
            this.var_int_L = 0;
            while (this.var_int_L < this.var_byte_O) {
                this.var_byte_arr_arr_b[this.var_int_K][this.var_int_L] = (this.var_java_util_Random_a.nextInt() & 0xFFFF) % 20 == 0 ? (byte)(-1 - (this.var_java_util_Random_a.nextInt() & 0xFFFF) % 12) : (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3 + 1);
                this.var_byte_arr_arr_c[this.var_int_K][this.var_int_L] = 0;
                this.var_short_arr_arr_c[this.var_int_K][this.var_int_L] = -1;
                if (!((this.var_int_K + 1) % 5 != 0 && this.var_int_K + 1 != this.var_byte_O || (this.var_int_L + 1) % 5 != 0 && this.var_int_L + 1 != this.var_byte_O)) {
                    this.var_byte_Y = (byte)(this.var_int_K / 5);
                    this.var_byte_Z = (byte)(this.var_int_L / 5);
                    this.cG();
                }
                ++this.var_int_L;
            }
            ++this.var_int_K;
        }
        this.var_int_K = 0;
        while (this.var_int_K < 222) {
            this.var_short_arr_d[this.var_int_K] = -1;
            this.var_byte_arr_B[this.var_int_K] = -1;
            ++this.var_int_K;
        }
        this.var_int_K = 0;
        while (this.var_int_K < 42) {
            this.var_byte_arr_arr_l[0][this.var_int_K] = -1;
            ++this.var_int_K;
        }
        this.var_int_K = 0;
        while (this.var_int_K < 90) {
            this.var_byte_arr_ak[this.var_int_K] = -1;
            ++this.var_int_K;
        }
        this.var_int_K = 0;
        while (this.var_int_K < 30) {
            this.var_byte_arr_arr_i[this.var_int_K][0] = -1;
            ++this.var_int_K;
        }
        this.var_int_K = 0;
        while (this.var_int_K < 15) {
            this.var_byte_arr_arr_k[this.var_int_K][0] = -1;
            ++this.var_int_K;
        }
    }

    final void void_j() {
        this.var_int_K = 0;
        while (this.var_int_K < this.var_byte_aF) {
            this.var_int_arr_l[this.var_int_K] = this.var_byte_o;
            ++this.var_int_K;
        }
        this.var_int_K = 0;
        while (this.var_int_K < this.var_byte_aH) {
            this.var_byte_arr_arr_x[this.var_int_K][0] = -1;
            ++this.var_int_K;
        }
        this.var_int_K = 0;
        while (this.var_int_K < 24) {
            this.var_byte_arr_al[this.var_int_K] = (byte)(this.var_byte_arr_aA[this.var_int_K] / b.au[0]);
            this.var_int_o = this.var_int_K;
            this.cH();
            this.var_byte_arr_aD[this.var_int_K] = 0;
            ++this.var_int_K;
        }
        this.var_byte_arr_aD[24] = 0;
        this.var_int_K = 0;
        while (this.var_int_K < 6) {
            this.var_byte_arr_aE[this.var_int_K] = b.aq[this.var_int_K];
            ++this.var_int_K;
        }
        this.var_int_K = 0;
        while (this.var_int_K < 27) {
            if (this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_int_K] >= 0) {
                this.var_int_o = this.var_int_K;
                this.cI();
            }
            ++this.var_int_K;
        }
        this.var_byte_ai = 0;
        this.var_byte_ak = 0;
        this.var_short_a = 0;
        this.var_int_arr_arr_c[2][d.var_short_arr_k[4] + 1] = 0;
        this.var_byte_ac = 0;
        this.var_int_K = 0;
        while (this.var_int_K < b.j[3] + 1) {
            this.var_short_arr_e[this.var_int_K] = 0;
            ++this.var_int_K;
        }
        this.var_int_K = 0;
        while (this.var_int_K < 4) {
            this.var_byte_arr_aW[this.var_int_K] = 0;
            ++this.var_int_K;
        }
        this.var_byte_y = 0;
        this.var_byte_d = (byte)-1;
        this.var_byte_W = 0;
        this.var_byte_X = 0;
        this.var_boolean_d = false;
        this.var_boolean_f = false;
        this.var_boolean_g = false;
    }

    public final void run() {
        try {
            while (this.var_boolean_c) {
                if (this.var_boolean_b) continue;
                Thread.yield();
                this.var_long_b = System.currentTimeMillis();
                if (this.var_long_b <= this.var_long_a + 100L) continue;
                this.aS();
                this.void_k();
                this.var_byte_a = 1;
                if (this.var_byte_aa != 0) {
                    this.x();
                }
                this.var_byte_a = 0;
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawImage(this.var_javax_microedition_lcdui_Image_a, 0, 0, 20);
                if (this.var_byte_i >= 0) {
                    this.var_byte_i = (byte)(this.var_byte_i + 1);
                }
                if (this.var_byte_i >= this.var_byte_s) {
                    this.var_byte_i = (byte)-1;
                }
                if (this.var_byte_b == 0) {
                    this.void_l();
                    this.m();
                    this.n();
                    if (this.var_byte_b == 3) {
                        continue;
                    }
                } else {
                    this.o();
                }
                this.p();
                this.var_long_a = this.var_long_b;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void void_k() {
        if (this.var_byte_b == 0) {
            if (this.var_byte_e % (this.var_byte_m * 2) == 0 && this.var_short_a < 200 - (30 - this.var_byte_O - 5) * 10 && this.var_short_a < 200) {
                this.cR();
            }
            this.var_byte_e = (byte)(this.var_byte_e + 1);
            if (this.var_byte_e >= this.var_byte_t) {
                this.var_byte_e = 0;
                this.var_byte_g = (byte)(this.var_byte_g + 1);
                if (this.var_byte_g >= 16) {
                    this.var_byte_g = 0;
                }
            }
            this.cK();
            this.cJ();
            this.cT();
            if (this.var_boolean_g) {
                if (this.var_byte_d >= 0) {
                    this.var_byte_d = (byte)(this.var_byte_d + 1);
                }
                if (this.var_byte_d >= 2) {
                    this.var_byte_d = (byte)-1;
                }
            }
            if (!(!this.var_boolean_f && this.var_boolean_d || this.var_boolean_g)) {
                if (this.var_byte_d >= 0) {
                    this.var_byte_d = (byte)(this.var_byte_d + 1);
                    if (this.var_byte_d < this.var_byte_n) {
                        this.var_byte_W = b.m[this.var_byte_d];
                        this.var_byte_X = b.n[this.var_byte_d];
                        this.var_byte_aa = (byte)5;
                    } else {
                        this.var_byte_d = (byte)-1;
                    }
                }
                if (this.var_boolean_f && this.var_byte_d >= 3) {
                    this.cb();
                    this.cm();
                    this.var_boolean_f = false;
                }
            }
            this.var_int_q = 0;
            while (this.var_int_q < this.var_byte_aF) {
                if (this.var_int_arr_l[this.var_int_q] < this.var_byte_o) {
                    int n = this.var_int_q;
                    this.var_int_arr_l[n] = this.var_int_arr_l[n] + 1;
                    if (this.var_int_arr_l[this.var_int_q] == this.var_byte_o) {
                        this.var_byte_aG = (byte)(this.var_byte_aG - 1);
                    }
                }
                ++this.var_int_q;
            }
            this.dE();
        }
    }

    final void void_l() {
        this.var_byte_aj = (byte)(this.var_byte_aj + 1);
        if (this.var_byte_aj >= 3) {
            this.var_byte_aj = 0;
        }
        if (!this.var_boolean_d) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[1], 0, 0, b.B[0] - 2, (int)b.B[1], 0, (this.var_int_arr_a[0] + this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] - this.var_int_arr_arr_f[0][1]) * (b.B[0] / 2) + this.var_byte_W, (this.var_int_arr_a[0] - this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] + this.var_int_arr_arr_f[0][1]) * (b.B[1] / 2) + this.var_byte_X, 20);
        } else if (this.var_byte_aW == 1 && this.var_byte_aV == 26) {
            this.K();
        }
        this.al();
    }

    final void m() {
        if (this.var_boolean_d) {
            this.var_int_x = (this.var_int_arr_a[0] + this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] - this.var_int_arr_arr_f[0][1]) * (b.B[0] / 2) + this.var_byte_W;
            this.var_int_y = (this.var_int_arr_a[0] - this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] + this.var_int_arr_arr_f[0][1]) * (b.B[1] / 2) - this.var_int_C / 2 * b.B[1] + this.var_byte_X;
            if (this.var_byte_j >= 0) {
                this.var_int_y = (this.var_int_arr_a[0] - this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] + this.var_int_arr_arr_f[0][1]) * (b.B[1] / 2) - this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 1] / 2 * b.B[1] + this.var_byte_X;
            }
            if (this.var_byte_aW == 2) {
                this.var_int_x += b.B[0] / 2 - this.var_byte_arr_aI[this.var_short_arr_h[51] + this.var_byte_C] / 2;
                this.var_int_y += b.B[1] / 2 - this.var_byte_arr_aI[this.var_short_arr_h[52] + this.var_byte_C];
            }
            this.af();
            if (this.var_byte_aW < 2) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)b.C[1], (int)b.D[1], (int)b.E[1], (int)b.F[1], 0, this.var_int_x + this.var_int_z / 2 - b.G[1], this.var_int_y + b.H[1], 20);
            }
            if (this.var_byte_aW == 2) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)b.C[2], (int)b.D[2], (int)b.E[2], (int)b.F[2], 0, this.var_int_x + this.var_int_z / 2 - b.G[2], this.var_int_y - b.H[2], 20);
            }
            this.var_byte_d = (byte)(this.var_byte_d + 1);
            if (this.var_byte_d >= this.var_byte_k) {
                this.var_byte_d = 0;
                return;
            }
        } else {
            if (this.var_boolean_g) {
                this.var_int_q = this.var_byte_d < 0 ? 0 : (int)this.var_byte_d;
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)b.I[this.var_int_q], (int)b.J[this.var_int_q], (int)b.K[this.var_int_q], (int)b.L[this.var_int_q], 0, (this.var_int_arr_a[0] + this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] - this.var_int_arr_arr_f[0][1]) * (b.B[0] / 2) + this.var_byte_W + b.M[this.var_int_q], (this.var_int_arr_a[0] - this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] + this.var_int_arr_arr_f[0][1]) * (b.B[1] / 2) + this.var_byte_X + b.N[this.var_int_q], 20);
                return;
            }
            if (this.var_short_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] > -1 || this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] > 3 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] <= 13 || this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] <= -15 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] >= -28) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)b.C[0], (int)b.D[0], (int)b.E[0], (int)b.F[0], 0, (this.var_int_arr_a[0] + this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] - this.var_int_arr_arr_f[0][1]) * (b.B[0] / 2) + this.var_byte_W + b.G[0], (this.var_int_arr_a[0] - this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] + this.var_int_arr_arr_f[0][1]) * (b.B[1] / 2) + this.var_byte_X + b.H[0], 20);
            }
        }
    }

    final void n() {
        this.aR();
        if (this.var_byte_e == 1 && this.var_byte_g == 0 && this.var_int_b == 0 && this.var_byte_K == 1 && this.var_byte_L == 0) {
            this.q();
        }
        if (this.var_byte_e == 0) {
            this.var_boolean_t = false;
            if (this.var_int_k > 0 && this.var_byte_w > -1) {
                this.var_byte_w = (byte)-1;
            }
            if (this.var_int_k < -50 && this.var_byte_w == -1) {
                this.var_byte_w = 0;
                this.var_byte_f = 0;
                this.var_byte_aC = 1;
                this.var_byte_aB = this.var_byte_aA = (byte)20;
                this.dH();
                this.var_boolean_t = true;
            }
            if (this.var_int_k < 0 && this.var_byte_w > -1) {
                this.var_byte_w = (byte)(this.var_byte_w + 1);
                if (this.var_byte_w >= 48) {
                    this.void_a(13);
                }
            }
            this.ad();
            if (this.var_byte_K == 1 && (this.var_int_arr_arr_e[0][0] >= this.var_int_arr_arr_e[0][1] && this.var_int_arr_arr_e[1][0] >= this.var_int_arr_arr_e[1][1] && this.var_int_arr_arr_e[2][0] >= this.var_int_arr_arr_e[2][1] && this.var_byte_L != 0 || this.var_byte_L == 0 && this.var_byte_D >= 8)) {
                this.void_a(12);
            }
            if (this.var_int_N < 1) {
                if (this.var_byte_K == 1 && this.var_byte_L == 0 && this.var_byte_D < 8) {
                    this.var_boolean_s = true;
                    this.var_int_M = this.var_byte_arr_aI[this.var_short_arr_h[142] + this.var_byte_D];
                    while (this.var_int_M < this.var_byte_arr_aI[this.var_short_arr_h[142] + this.var_byte_D + 1]) {
                        if (this.var_byte_arr_b[this.var_int_M] == 0) {
                            this.var_boolean_s = false;
                            break;
                        }
                        ++this.var_int_M;
                    }
                    if (this.var_boolean_s) {
                        this.q();
                    }
                }
            } else {
                this.var_int_N = this.var_int_N < 8 ? ++this.var_int_N : 0;
            }
            if (this.var_byte_g == 0) {
                ++this.var_int_b;
                if (this.var_short_arr_e[b.j[3]] > 0) {
                    this.ab();
                    if (!this.var_boolean_t) {
                        this.var_byte_f = 0;
                        this.var_byte_aC = 1;
                        this.var_byte_aB = this.var_byte_aA = (byte)9;
                        this.dH();
                    }
                }
                this.ac();
                if (this.var_byte_K == 1 && this.var_int_c < this.var_byte_arr_aI[this.var_short_arr_h[161] + this.var_byte_L] && this.var_byte_arr_aI[this.var_short_arr_h[156 + this.var_byte_L - 1] + this.var_int_c * 3] == this.var_int_b) {
                    this.var_byte_aY = this.var_byte_aW;
                    this.var_byte_aX = this.var_byte_aV;
                    this.var_byte_aZ = this.var_byte_at;
                    this.var_byte_aW = this.var_byte_arr_aI[this.var_short_arr_h[156 + this.var_byte_L - 1] + this.var_int_c * 3 + 1];
                    this.var_byte_aV = this.var_byte_arr_aI[this.var_short_arr_h[156 + this.var_byte_L - 1] + this.var_int_c * 3 + 2];
                    this.var_boolean_arr_arr_a[this.var_byte_aW][this.var_byte_aV] = true;
                    ++this.var_int_c;
                    this.void_a(24);
                }
                if (this.var_byte_K == 0 && this.var_int_b % 12 == 0) {
                    this.void_a(25);
                    this.var_byte_V = this.var_int_arr_arr_g[0][0] == 0 ? (byte)(this.var_byte_V + 1) : (byte)0;
                }
            }
        }
        this.dP();
        if (this.var_byte_f >= 0) {
            if (this.var_byte_aC != 1 || this.var_byte_aA != this.var_byte_aB) {
                this.var_byte_aC = 1;
                this.var_byte_aA = this.var_byte_aB;
                this.dH();
            }
            this.E();
            this.var_byte_f = (byte)(this.var_byte_f + 1);
            if (this.var_byte_f >= this.var_byte_p) {
                this.var_byte_f = (byte)-1;
            }
        }
    }

    final void o() {
        if (this.var_byte_b == 1) {
            this.S();
            return;
        }
        if (this.var_byte_b == 2) {
            this.ak();
            return;
        }
        if (this.var_byte_b == 3) {
            this.L();
            return;
        }
        if (this.var_byte_b == 4) {
            this.T();
            return;
        }
        if (this.var_byte_b == 5) {
            this.E();
            this.Q();
        }
    }

    final void p() {
        if (this.var_byte_b != 3 || this.var_byte_R > 17) {
            this.cF();
            this.ar();
        }
        if (this.var_byte_b == 0 || this.var_byte_b == 1) {
            this.cE();
        }
        this.dO();
        this.aq();
        this.flushGraphics(0, 0, this.var_int_l, this.var_int_m);
    }

    final void void_a(int n) {
        this.var_byte_b = (byte)3;
        this.var_byte_R = (byte)n;
        this.ct();
        this.var_byte_aa = (byte)5;
        this.var_byte_i = 0;
    }

    final void q() {
        this.var_byte_a = 1;
        this.al();
        this.var_byte_a = 0;
        this.var_byte_b = (byte)5;
        this.var_byte_aa = 0;
        this.var_byte_aC = 1;
        this.var_byte_aA = (byte)(30 + this.var_byte_D);
        this.dH();
        this.var_byte_D = (byte)(this.var_byte_D + 1);
        if (this.var_byte_D == 7) {
            this.var_int_N = 1;
        }
        this.var_byte_i = 0;
        this.var_boolean_t = true;
    }

    final void r() {
        this.var_int_arr_arr_f[0][0] = this.var_int_arr_a[0] - this.var_int_m / 2 / b.B[1];
        this.var_int_arr_arr_f[0][1] = this.var_int_arr_a[1] + this.var_int_l / 2 / b.B[0];
        this.var_int_arr_arr_f[1][0] = this.var_int_arr_arr_f[0][0] + this.var_int_l / b.B[0] - 1;
        this.var_int_arr_arr_f[1][1] = this.var_int_arr_arr_f[0][1] + this.var_int_l / b.B[0] - 1;
        this.var_int_arr_arr_f[2][0] = this.var_int_arr_arr_f[0][0] + this.var_int_l / b.B[0] - 1 + this.var_int_m / b.B[1] - 1;
        this.var_int_arr_arr_f[2][1] = this.var_int_arr_arr_f[0][1] + this.var_int_l / b.B[0] - this.var_int_m / b.B[1];
        this.var_int_arr_arr_f[3][0] = this.var_int_arr_arr_f[0][0] + this.var_int_m / b.B[1] - 1;
        this.var_int_arr_arr_f[3][1] = this.var_int_arr_arr_f[0][1] + 1 - this.var_int_m / b.B[1];
    }

    final void s() {
        this.var_int_arr_a[0] = (this.var_int_arr_arr_f[0][0] + this.var_int_arr_arr_f[1][0] + this.var_int_arr_arr_f[2][0] + this.var_int_arr_arr_f[3][0]) / 4;
        this.var_int_arr_a[1] = (this.var_int_arr_arr_f[0][1] + this.var_int_arr_arr_f[1][1] + this.var_int_arr_arr_f[2][1] + this.var_int_arr_arr_f[3][1]) / 4;
    }

    final void t() {
        this.var_java_io_InputStream_a = null;
        try {
            this.var_int_Q = 0;
            while (this.var_int_Q < 2) {
                System.gc();
                this.var_java_io_InputStream_a = this.getClass().getResourceAsStream(this.var_java_lang_String_arr_b[this.var_int_Q]);
                if (this.var_java_io_InputStream_a != null) {
                    this.u();
                    this.v();
                    this.w();
                }
                this.var_java_io_InputStream_a.close();
                this.var_java_io_InputStream_a = null;
                System.gc();
                this.var_Park_a.var_c_a.g = 30 + this.var_int_Q * 20;
                this.var_Park_a.var_c_a.repaint();
                ++this.var_int_Q;
            }
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    final void u() {
        try {
            this.var_int_O = 0;
            while (this.var_int_O < 24) {
                if (this.var_int_Q == 0) {
                    this.var_byte_arr_am[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_as[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_at[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_an[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_ap[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_ao[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_aq[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_au[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_ar[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_av[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_aw[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_ax[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_ay[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_az[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_aA[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_aB[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_aC[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_int_R = this.var_java_io_InputStream_a.read() & 0xFF;
                    this.var_int_S = this.var_java_io_InputStream_a.read() & 0xFF;
                    this.var_byte_arr_arr_o[this.var_int_O] = new byte[this.var_int_S * 256 + this.var_int_R];
                } else {
                    this.var_short_arr_arr_g[this.var_int_O][0] = 0;
                    this.var_int_P = 0;
                    while (this.var_int_P < 42) {
                        this.var_int_R = this.var_java_io_InputStream_a.read() & 0xFF;
                        this.var_int_S = this.var_java_io_InputStream_a.read() & 0xFF;
                        this.var_int_T = this.var_int_S * 256 + this.var_int_R;
                        if (this.var_int_P < 41) {
                            this.var_short_arr_arr_g[this.var_int_O][this.var_int_P + 1] = (short)(this.var_short_arr_arr_g[this.var_int_O][this.var_int_P] + this.var_int_T);
                        }
                        if (this.var_int_T > 0) {
                            this.var_java_io_InputStream_a.read(this.var_byte_arr_arr_o[this.var_int_O], this.var_short_arr_arr_g[this.var_int_O][this.var_int_P], this.var_int_T);
                        }
                        ++this.var_int_P;
                    }
                }
                ++this.var_int_O;
            }
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    final void v() {
        try {
            this.var_int_O = 0;
            while (this.var_int_O < 27) {
                if (this.var_int_Q == 0) {
                    this.var_byte_arr_aH[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_aF[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_byte_arr_aG[this.var_int_O] = (byte)this.var_java_io_InputStream_a.read();
                    this.var_int_R = this.var_java_io_InputStream_a.read() & 0xFF;
                    this.var_int_S = this.var_java_io_InputStream_a.read() & 0xFF;
                    this.var_byte_arr_arr_p[this.var_int_O] = new byte[this.var_int_S * 256 + this.var_int_R];
                } else {
                    this.var_short_arr_arr_h[this.var_int_O][0] = 0;
                    this.var_int_P = 0;
                    while (this.var_int_P < 16) {
                        this.var_int_R = this.var_java_io_InputStream_a.read() & 0xFF;
                        this.var_int_S = this.var_java_io_InputStream_a.read() & 0xFF;
                        this.var_int_T = this.var_int_S * 256 + this.var_int_R;
                        if (this.var_int_P < 15) {
                            this.var_short_arr_arr_h[this.var_int_O][this.var_int_P + 1] = (short)(this.var_short_arr_arr_h[this.var_int_O][this.var_int_P] + this.var_int_T);
                        }
                        if (this.var_int_T > 0) {
                            this.var_java_io_InputStream_a.read(this.var_byte_arr_arr_p[this.var_int_O], this.var_short_arr_arr_h[this.var_int_O][this.var_int_P], this.var_int_T);
                        }
                        ++this.var_int_P;
                    }
                }
                ++this.var_int_O;
            }
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    final void w() {
        try {
            if (this.var_int_Q == 0) {
                this.var_int_R = this.var_java_io_InputStream_a.read() & 0xFF;
                this.var_int_S = this.var_java_io_InputStream_a.read() & 0xFF;
                this.var_byte_arr_aI = new byte[this.var_int_S * 256 + this.var_int_R];
            } else {
                this.var_short_arr_h[0] = 0;
                this.var_int_O = 0;
                while (this.var_int_O < 177) {
                    this.var_int_R = this.var_java_io_InputStream_a.read() & 0xFF;
                    this.var_int_S = this.var_java_io_InputStream_a.read() & 0xFF;
                    this.var_int_T = this.var_int_S * 256 + this.var_int_R;
                    if (this.var_int_O < 176) {
                        this.var_short_arr_h[this.var_int_O + 1] = (short)(this.var_short_arr_h[this.var_int_O] + this.var_int_T);
                    }
                    if (this.var_int_T > 0) {
                        this.var_java_io_InputStream_a.read(this.var_byte_arr_aI, this.var_short_arr_h[this.var_int_O], this.var_int_T);
                    }
                    ++this.var_int_O;
                }
            }
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    final void x() {
        if (this.var_byte_b == 0) {
            if (this.var_byte_aa != 0) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(0);
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].fillRect(0, 0, this.var_int_l, this.var_int_m);
                this.a(0, -(b.B[1] / 2), this.var_int_l, this.var_int_m);
            }
        } else if (this.var_byte_b == 2 || this.var_byte_b == 3) {
            this.y();
            this.z();
        }
        this.var_byte_aa = 0;
    }

    final void y() {
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(d.var_int_arr_arr_a[0][0], d.var_int_arr_arr_a[0][1], d.var_int_arr_arr_a[0][2]);
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].fillRect(0, 0, this.var_int_l, this.var_int_m / 2);
        this.var_int_q = 0;
        while (this.var_int_q < this.var_int_m / 4) {
            this.var_int_u = d.var_int_arr_arr_a[0][0] - (d.var_int_arr_arr_a[0][0] - d.var_int_arr_arr_a[1][0]) * this.var_int_q / (this.var_int_m / 4);
            this.var_int_v = d.var_int_arr_arr_a[0][1] - (d.var_int_arr_arr_a[0][1] - d.var_int_arr_arr_a[1][1]) * this.var_int_q / (this.var_int_m / 4);
            this.var_int_w = d.var_int_arr_arr_a[0][2] - (d.var_int_arr_arr_a[0][2] - d.var_int_arr_arr_a[1][2]) * this.var_int_q / (this.var_int_m / 4);
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(this.var_int_u, this.var_int_v, this.var_int_w);
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawLine(0, this.var_int_m / 2 + this.var_int_q, this.var_int_l, this.var_int_m / 2 + this.var_int_q);
            ++this.var_int_q;
        }
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(d.var_int_arr_arr_a[1][0], d.var_int_arr_arr_a[1][1], d.var_int_arr_arr_a[1][2]);
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].fillRect(0, this.var_int_m * 3 / 4, this.var_int_l, this.var_int_m / 4);
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(14734447);
        this.var_int_q = 0;
        while (this.var_int_q < 2) {
            this.var_int_r = 0;
            while (this.var_int_r < 7) {
                if (this.var_int_q == 1) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].fillRect(22 + d.var_short_arr_arr_c[0][this.var_int_r], (int)d.var_short_arr_c[this.var_int_r], d.var_short_arr_arr_c[1][this.var_int_r] - 22 - d.var_short_arr_arr_c[0][this.var_int_r], this.var_int_m - d.var_short_arr_c[this.var_int_r]);
                }
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[4], (int)b.p[this.var_int_q], 0, 22, 42, 0, (int)d.var_short_arr_arr_c[this.var_int_q][this.var_int_r], (int)d.var_short_arr_c[this.var_int_r], 20);
                ++this.var_int_r;
            }
            ++this.var_int_q;
        }
        this.var_int_q = 0;
        while (this.var_int_q < 5) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[8], (int)d.var_byte_arr_b[this.var_int_q], (int)d.var_byte_arr_c[this.var_int_q], (int)d.var_byte_arr_d[this.var_int_q], (int)d.var_byte_arr_e[this.var_int_q], 0, (int)d.var_short_arr_d[this.var_int_q], (int)d.var_byte_arr_f[this.var_int_q], 20);
            ++this.var_int_q;
        }
    }

    final void z() {
        this.var_int_w = 0;
        this.var_int_Z = 0;
        this.var_int_Z = 15;
        this.var_int_q = 0;
        while (this.var_int_q < 2) {
            this.var_int_r = 0;
            while (this.var_int_r < 2) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[5], (int)b.var_byte_arr_arr_a[this.var_int_q][this.var_int_r], (int)b.r[this.var_int_r], (int)b.q[this.var_int_r], (int)b.s[this.var_int_r], 0, (int)b.var_short_arr_arr_b[this.var_int_q][this.var_int_r], 0 - this.var_int_Z, 20);
                ++this.var_int_r;
            }
            ++this.var_int_q;
        }
        if ((this.var_byte_b == 2 || this.var_byte_b == 3 && ((this.var_byte_R == 19 || this.var_byte_R == 21 || this.var_byte_R == 22) && this.var_boolean_m || this.var_byte_R == 20 || this.var_byte_R == 23 || this.var_byte_R == 24)) && !this.var_boolean_o) {
            this.var_int_Y = this.var_byte_b == 2 ? (this.var_byte_aW == 2 ? 1 : 0) : (int)((byte)(this.var_byte_R - 19 + 2));
            this.A();
        }
    }

    final void a(int n, int n2, int n3, int n4) {
        this.var_int_U = n2 + this.var_byte_X;
        while (this.var_int_U < n4) {
            this.var_int_V = (this.var_int_U - this.var_byte_X) % b.B[1] == 0 ? n + this.var_byte_W : n - b.B[0] / 2 + this.var_byte_W;
            while (this.var_int_V < n3) {
                this.F();
                this.J();
                this.var_int_V += b.B[0];
            }
            this.var_int_U += b.B[1] / 2;
        }
    }

    final void A() {
        this.var_int_q = 0;
        while (this.var_int_q < 4) {
            this.var_int_r = 0;
            while (this.var_int_r < d.var_byte_arr_arr_a[d.var_byte_arr_g[this.var_int_Y]][this.var_int_q / 2]) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[6], (int)d.var_byte_arr_arr_arr_a[d.var_byte_arr_g[this.var_int_Y]][this.var_int_q / 2][this.var_int_r], (int)d.var_byte_arr_arr_arr_b[d.var_byte_arr_g[this.var_int_Y]][this.var_int_q / 2][this.var_int_r], (int)d.var_byte_arr_arr_arr_c[d.var_byte_arr_g[this.var_int_Y]][this.var_int_q / 2][this.var_int_r], (int)d.var_byte_arr_arr_arr_d[d.var_byte_arr_g[this.var_int_Y]][this.var_int_q / 2][this.var_int_r], 0, d.var_short_arr_arr_arr_a[d.var_byte_arr_g[this.var_int_Y]][this.var_int_q][this.var_int_r] + d.var_short_arr_g[this.var_int_Y], d.var_short_arr_arr_arr_b[d.var_byte_arr_g[this.var_int_Y]][this.var_int_q][this.var_int_r] + d.var_short_arr_h[this.var_int_Y], 20);
                ++this.var_int_r;
            }
            ++this.var_int_q;
        }
    }

    final void B() {
        this.var_int_aa = this.var_byte_b == 2 && this.var_byte_aW == 2 ? 176 - this.var_byte_arr_aI[this.var_short_arr_h[119] + this.var_int_r] / 2 : 196;
        if ((this.var_byte_b == 2 || this.var_byte_b == 3 && this.var_byte_R == 26) && !this.var_boolean_n) {
            this.var_int_r = 0;
            while (this.var_int_r < 2) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[3], (int)this.var_byte_arr_aI[this.var_short_arr_h[116] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[117] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[118] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[119] + this.var_int_r], 0, d.var_short_arr_e[this.var_int_r] + this.var_byte_arr_a[(this.var_int_a + this.var_int_r * 2) % 4], this.var_int_aa, 20);
                ++this.var_int_r;
            }
        }
    }

    final void C() {
        if (this.var_byte_b == 3 && this.var_byte_arr_w[this.var_byte_R] >= 0 && this.var_byte_arr_aI[this.var_short_arr_h[93] + this.var_byte_R] == 0 || this.var_byte_b == 2) {
            this.var_int_s = 0;
            while (this.var_int_s < 2) {
                this.var_int_t = 0;
                while (this.var_int_t < b.u[0]) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[8], (int)b.t[this.var_int_s], (int)b.var_byte_arr_arr_b[0][this.var_int_t], 50, (int)b.var_byte_arr_arr_c[0][this.var_int_t], 0, (int)d.var_byte_arr_i[this.var_int_s], d.var_short_arr_arr_f[2][0] + b.var_byte_arr_arr_d[0][this.var_int_t], 20);
                    ++this.var_int_t;
                }
                ++this.var_int_s;
            }
        }
    }

    final void D() {
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(14734447);
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].fillRect((int)d.F[0], this.var_int_H + d.F[1], (int)d.F[2], (int)d.F[3]);
        this.var_int_r = 0;
        while (this.var_int_r < 11) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[8], (int)d.var_byte_arr_m[this.var_int_r], (int)d.var_byte_arr_n[this.var_int_r], (int)d.var_byte_arr_o[this.var_int_r], (int)d.var_byte_arr_p[this.var_int_r], 0, (int)d.D[this.var_int_r], this.var_int_H + d.E[this.var_int_r], 20);
            ++this.var_int_r;
        }
        this.var_int_q = 0;
        while (this.var_int_q < 2) {
            this.var_int_r = 0;
            while (this.var_int_r < 3) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[4], (int)b.p[this.var_int_q], (int)d.var_byte_arr_k[this.var_int_r], 22, (int)d.var_byte_arr_l[this.var_int_r], 0, (int)d.var_short_arr_arr_g[this.var_int_q][this.var_int_r], this.var_int_H + d.C[this.var_int_r], 20);
                ++this.var_int_r;
            }
            ++this.var_int_q;
        }
    }

    final void E() {
        this.D();
        if (this.var_byte_b != 1 || this.var_byte_z == 0) {
            this.dQ();
        }
    }

    final void F() {
        this.var_int_W = ((this.var_int_U - this.var_byte_X) / (b.B[1] / 2) + (this.var_int_V - this.var_byte_W) / (b.B[0] / 2)) / 2 + this.var_int_arr_arr_f[0][0];
        this.var_int_X = ((this.var_int_V - this.var_byte_W) / (b.B[0] / 2) - (this.var_int_U - this.var_byte_X) / (b.B[1] / 2)) / 2 + this.var_int_arr_arr_f[0][1];
        if (this.var_int_W >= 0 && this.var_int_X >= 0 && this.var_int_W < this.var_byte_O && this.var_int_X < this.var_byte_O) {
            if (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] != 0 && this.var_boolean_d && this.var_byte_ah > 0 && (this.var_byte_aW == 0 && this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][4] + 3] == 1 || this.var_byte_aW == 1 && this.var_byte_aV == 26)) {
                this.var_int_u = 0;
                while (this.var_int_u < 15) {
                    if (this.var_byte_arr_arr_k[this.var_int_u][0] >= 0 && this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_byte_arr_arr_k[this.var_int_u][0]][this.var_byte_arr_arr_k[this.var_int_u][1]]] && this.var_int_W >= this.var_byte_arr_arr_k[this.var_int_u][0] - b.var_byte_arr_arr_i[0][0] && this.var_int_W <= this.var_byte_arr_arr_k[this.var_int_u][0] + b.var_byte_arr_arr_i[0][1] && this.var_int_X >= this.var_byte_arr_arr_k[this.var_int_u][1] - b.var_byte_arr_arr_i[1][0] && this.var_int_X <= this.var_byte_arr_arr_k[this.var_int_u][1] + b.var_byte_arr_arr_i[1][1]) {
                        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[1], 0, b.B[1] * 2, b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
                        return;
                    }
                    ++this.var_int_u;
                }
            }
            if (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] == 0) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[2], (int)b.O[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X] / 4], (int)b.P[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X] / 4], b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
                return;
            }
            if (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] > 0) {
                this.G();
                return;
            }
            this.H();
            return;
        }
        this.I();
    }

    final void G() {
        if (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] > 3 && this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] <= 12) {
            this.var_int_ak = 0;
            this.aI();
            if (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] == 7) {
                this.var_int_ak = 11;
                this.aI();
            }
            if (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] == 8) {
                this.var_int_ak = 14;
                this.aI();
            }
            if (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] == 5) {
                this.var_int_ak = 13;
                this.aI();
            }
            if (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] == 6) {
                this.var_int_ak = 12;
                this.aI();
                return;
            }
        } else if (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] <= 3) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[0], 0, b.B[1] * (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] - 1), b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
        }
    }

    final void H() {
        if (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] < 0 && this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] >= -27) {
            if (this.var_byte_arr_aI[this.var_short_arr_h[89] + -1 - this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X]] == 0) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[2], (int)b.O[0], (int)b.P[0], b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
                return;
            }
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[0], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
            return;
        }
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[0], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
    }

    final void I() {
        if (this.var_int_W == this.var_byte_ab && this.var_int_X < 0) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[2], (int)b.O[0], (int)b.P[0], b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
            this.aw();
        } else {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[0], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
        }
        if (this.var_int_W != -1 && this.var_int_X != -1 && this.var_int_W != this.var_byte_O && this.var_int_X != this.var_byte_O && (this.var_int_W != this.var_byte_ab || this.var_int_X > 0)) {
            this.var_byte_an = (this.var_int_W == this.var_byte_ab - 1 || this.var_int_W == this.var_byte_ab + 1) && this.var_int_X < 0 ? (byte)-11 : (this.var_int_X == -2 && this.var_int_W >= 0 && this.var_int_W < this.var_byte_O ? (byte)-12 : this.var_byte_arr_arr_d[(this.var_int_W & 0xFFFF) % 10][(this.var_int_X & 0xFFFF) % 10]);
            this.aG();
        }
    }

    final void J() {
        this.var_int_W = ((this.var_int_U - this.var_byte_X) / (b.B[1] / 2) + (this.var_int_V - this.var_byte_W) / (b.B[0] / 2)) / 2 + this.var_int_arr_arr_f[0][0];
        this.var_int_X = ((this.var_int_V - this.var_byte_W) / (b.B[0] / 2) - (this.var_int_U - this.var_byte_X) / (b.B[1] / 2)) / 2 + this.var_int_arr_arr_f[0][1];
        this.var_int_u = 0;
        while (this.var_int_u < 4) {
            if ((this.var_int_W == this.var_byte_arr_aI[this.var_short_arr_h[39] + this.var_int_u * 6 + 0] || this.var_int_W == this.var_byte_O && this.var_byte_arr_aI[this.var_short_arr_h[39] + this.var_int_u * 6 + 0] == 30) && (this.var_int_X == this.var_byte_arr_aI[this.var_short_arr_h[39] + this.var_int_u * 6 + 1] || this.var_int_X == this.var_byte_O && this.var_byte_arr_aI[this.var_short_arr_h[39] + this.var_int_u * 6 + 1] == 30)) {
                this.var_int_v = 0;
                while (this.var_int_v < 2) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[2], (int)this.var_byte_arr_aI[this.var_short_arr_h[65] + this.var_byte_arr_aI[this.var_short_arr_h[39] + this.var_int_u * 6 + (this.var_int_v + 1) * 2]], (int)this.var_byte_arr_aI[this.var_short_arr_h[66] + this.var_byte_arr_aI[this.var_short_arr_h[39] + this.var_int_u * 6 + (this.var_int_v + 1) * 2]], (int)this.var_byte_arr_aI[this.var_short_arr_h[67] + this.var_byte_arr_aI[this.var_short_arr_h[39] + this.var_int_u * 6 + (this.var_int_v + 1) * 2]], (int)this.var_byte_arr_aI[this.var_short_arr_h[68] + this.var_byte_arr_aI[this.var_short_arr_h[39] + this.var_int_u * 6 + (this.var_int_v + 1) * 2]], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[69] + this.var_byte_arr_aI[this.var_short_arr_h[39] + this.var_int_u * 6 + (this.var_int_v + 1) * 2 + 1]], this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[70] + this.var_byte_arr_aI[this.var_short_arr_h[39] + this.var_int_u * 6 + (this.var_int_v + 1) * 2 + 1]], 20);
                    ++this.var_int_v;
                }
            }
            ++this.var_int_u;
        }
        if (this.var_int_W == -1 && this.var_int_X >= 0 && this.var_int_X < this.var_byte_O) {
            this.var_int_ak = 0;
            this.var_int_al = 0;
            this.aJ();
        }
        if (this.var_int_X == this.var_byte_O && this.var_int_W >= 0 && this.var_int_W < this.var_byte_O) {
            this.var_int_ak = 1;
            this.var_int_al = 1;
            this.aJ();
        }
        if (this.var_int_W == this.var_byte_O && this.var_int_X >= 0 && this.var_int_X < this.var_byte_O) {
            this.var_int_ak = 0;
            this.var_int_al = 2;
            this.aJ();
        }
        if (this.var_int_X == -1 && this.var_int_W >= 0 && this.var_int_W < this.var_byte_O && this.var_int_W != this.var_byte_ab) {
            this.var_int_ak = 1;
            this.var_int_al = 3;
            this.aJ();
        }
    }

    final void K() {
        this.var_int_q = -b.var_byte_arr_arr_i[0][0];
        while (this.var_int_q <= b.var_byte_arr_arr_i[0][1]) {
            if (this.var_int_arr_a[0] + this.var_int_q >= 0) {
                if (this.var_int_arr_a[0] + this.var_int_q >= this.var_byte_O) {
                    return;
                }
                this.var_int_r = -b.var_byte_arr_arr_i[1][0];
                while (this.var_int_r <= b.var_byte_arr_arr_i[1][1]) {
                    if (this.var_int_arr_a[1] + this.var_int_r >= 0) {
                        if (this.var_int_arr_a[1] + this.var_int_r >= this.var_byte_O) break;
                        if (this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_q][this.var_int_arr_a[1] + this.var_int_r] != 0) {
                            this.var_int_V = (this.var_int_arr_a[0] + this.var_int_q + this.var_int_arr_a[1] + this.var_int_r - this.var_int_arr_arr_f[0][0] - this.var_int_arr_arr_f[0][1]) * (b.B[0] / 2) + this.var_byte_W;
                            this.var_int_U = (this.var_int_arr_a[0] + this.var_int_q - this.var_int_arr_a[1] - this.var_int_r - this.var_int_arr_arr_f[0][0] + this.var_int_arr_arr_f[0][1]) * (b.B[1] / 2) + this.var_byte_X;
                            if (this.var_int_V < this.var_int_l && this.var_int_V + b.B[0] >= 0 && this.var_int_U < this.var_int_m && this.var_int_U + b.B[1] >= 0) {
                                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[1], 0, b.B[1] * 2, b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
                            }
                        }
                    }
                    ++this.var_int_r;
                }
            }
            ++this.var_int_q;
        }
    }

    final void L() {
        try {
            this.C();
            this.M();
            this.N();
            this.O();
            this.B();
            if (this.var_byte_R == 26) {
                switch (this.var_byte_P) {
                    case 0: 
                    case 1: 
                    case 2: {
                        this.a(this.var_byte_P, 1, 10);
                        break;
                    }
                    case 5: {
                        this.a(3, 5, 0);
                        break;
                    }
                    case 3: {
                        this.var_int_r = 0;
                        while (this.var_int_r < b.j[3]) {
                            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_a[this.var_byte_arr_aI[this.var_short_arr_h[154] + this.var_int_r]], (int)this.var_byte_arr_aI[this.var_short_arr_h[49] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[50] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[51] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[52] + this.var_int_r], 0, (int)d.t[this.var_int_r], d.u[this.var_int_r] - this.var_byte_arr_aI[this.var_short_arr_h[52] + this.var_int_r] / 2, 20);
                            ++this.var_int_r;
                        }
                        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[71] + 10], (int)this.var_byte_arr_aI[this.var_short_arr_h[72] + 10], (int)this.var_byte_arr_aI[this.var_short_arr_h[73] + 10], (int)this.var_byte_arr_aI[this.var_short_arr_h[74] + 10], 0, (int)d.t[this.var_int_r], d.u[this.var_int_r] - this.var_byte_arr_aI[this.var_short_arr_h[74] + 10] / 2, 20);
                        break;
                    }
                    case 4: {
                        this.var_int_r = 0;
                        while (this.var_int_r < 3) {
                            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_d[this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[98] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[99] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[100] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[101] + this.var_int_r], 0, 63 - this.var_byte_arr_aI[this.var_short_arr_h[100] + this.var_int_r], d.z[this.var_int_r] - this.var_byte_arr_aI[this.var_short_arr_h[101] + this.var_int_r] / 2, 20);
                            ++this.var_int_r;
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
        if (this.var_byte_arr_v[this.var_byte_R] > 0 && this.var_byte_R != 26 && !this.var_boolean_o) {
            this.var_int_r = 0;
            while (this.var_int_r < 2) {
                this.var_int_q = this.var_byte_P;
                if (this.var_boolean_v && this.var_byte_P > 1) {
                    --this.var_int_q;
                }
                if (this.var_int_r == 0) {
                    this.var_int_v = this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 11 ? 55 - this.var_byte_arr_aI[this.var_short_arr_h[118] + 0] : (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 12 && this.var_boolean_m ? 70 - this.var_byte_arr_aI[this.var_short_arr_h[118] + 0] : (this.var_int_l - this.var_int_arr_d[this.var_int_q + this.var_byte_arr_aI[this.var_short_arr_h[94] + this.var_byte_R]]) / 2 - 12 - this.var_byte_arr_aI[this.var_short_arr_h[118] + 0]);
                    this.var_int_v += this.var_byte_arr_a[this.var_int_a % 4];
                    this.var_int_u = this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 11 || this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 10 || this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 41 ? 0 : 1;
                }
                if (this.var_int_r == 1) {
                    this.var_int_v = this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 11 ? this.var_int_l - 55 : (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 12 && this.var_boolean_m ? this.var_int_l - 70 : (this.var_int_l + this.var_int_arr_d[this.var_int_q + this.var_byte_arr_aI[this.var_short_arr_h[94] + this.var_byte_R]]) / 2 + 12);
                    this.var_int_v -= this.var_byte_arr_a[this.var_int_a % 4];
                    this.var_int_u = this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 11 || this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 10 || this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 41 ? 1 : 0;
                }
                this.var_int_w = this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 11 ? d.var_short_arr_arr_e[this.var_byte_R][this.var_byte_arr_aI[this.var_short_arr_h[92] + this.var_byte_R] - 1] - this.var_byte_arr_aI[this.var_short_arr_h[119] + 0] / 2 : (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 12 ? d.var_short_arr_p[this.var_byte_R] + 2 : d.var_short_arr_arr_d[this.var_byte_R][0] + d.var_short_arr_arr_d[this.var_byte_R][1] * this.var_byte_P + 2);
                if (this.var_boolean_v) {
                    this.var_int_w = this.var_byte_P < 1 ? (this.var_int_w += d.var_short_arr_arr_d[this.var_byte_R][1] / 2) : (this.var_int_w -= d.var_short_arr_arr_d[this.var_byte_R][1] / 2);
                }
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[3], (int)this.var_byte_arr_aI[this.var_short_arr_h[116] + this.var_int_u], (int)this.var_byte_arr_aI[this.var_short_arr_h[117] + this.var_int_u], (int)this.var_byte_arr_aI[this.var_short_arr_h[118] + this.var_int_u], (int)this.var_byte_arr_aI[this.var_short_arr_h[119] + this.var_int_u], 0, this.var_int_v, this.var_int_w, 20);
                ++this.var_int_r;
            }
        }
    }

    final void N() {
        if (!this.var_boolean_o) {
            this.var_int_r = 0;
            while (this.var_int_r < this.var_byte_arr_aI[this.var_short_arr_h[92] + this.var_byte_R]) {
                this.var_short_l = this.var_byte_arr_x[this.var_int_r];
                this.var_short_m = d.var_short_arr_arr_e[this.var_byte_R][this.var_int_r];
                this.var_short_n = d.var_byte_arr_h[1];
                this.var_short_o = this.var_byte_arr_y[this.var_int_r];
                this.R();
                ++this.var_int_r;
            }
        }
        if (this.var_byte_R != 2 || this.var_byte_aA != 29) {
            this.var_int_r = 0;
            while (!(this.var_int_r >= this.var_byte_arr_aI[this.var_short_arr_h[93] + this.var_byte_R] || this.var_boolean_o && this.var_int_r > 0)) {
                this.var_int_u = this.var_byte_arr_aI[this.var_short_arr_h[144] + this.var_byte_arr_aI[this.var_short_arr_h[145] + this.var_byte_R] + this.var_int_r];
                this.var_int_s = 0;
                while (this.var_int_s < 2) {
                    this.var_int_t = 0;
                    while (this.var_int_t < b.u[this.var_int_u]) {
                        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[8], (int)b.t[this.var_int_s], (int)b.var_byte_arr_arr_b[this.var_int_u][this.var_int_t], 50, (int)b.var_byte_arr_arr_c[this.var_int_u][this.var_int_t], 0, (int)d.var_byte_arr_i[this.var_int_s], d.var_short_arr_arr_f[this.var_byte_R][this.var_int_r] + b.var_byte_arr_arr_d[this.var_int_u][this.var_int_t], 20);
                        ++this.var_int_t;
                    }
                    ++this.var_int_s;
                }
                ++this.var_int_r;
            }
        }
        if (!this.var_boolean_o && ((this.var_byte_R == 19 || this.var_byte_R == 21 || this.var_byte_R == 22) && this.var_boolean_m || this.var_byte_R == 20)) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_a[this.var_byte_arr_aI[this.var_short_arr_h[154] + this.var_byte_U]], (int)this.var_byte_arr_aI[this.var_short_arr_h[49] + this.var_byte_U], (int)this.var_byte_arr_aI[this.var_short_arr_h[50] + this.var_byte_U], (int)this.var_byte_arr_aI[this.var_short_arr_h[51] + this.var_byte_U], (int)this.var_byte_arr_aI[this.var_short_arr_h[52] + this.var_byte_U], 0, (this.var_int_l - this.var_byte_arr_aI[this.var_short_arr_h[51] + this.var_byte_U]) / 2, d.q[this.var_int_Y - 2] - this.var_byte_arr_aI[this.var_short_arr_h[52] + this.var_byte_U] / 2, 20);
        }
    }

    final void O() {
        if (this.var_byte_R == 23) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_a[this.var_byte_U], (int)this.var_byte_arr_aI[this.var_short_arr_h[1] + this.var_byte_U * 12 + 0 + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[19] + this.var_byte_U * 4 + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[2] + this.var_byte_U * 12 + 0 + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[20] + this.var_byte_U * 4 + 0], 0, d.x[2] - this.var_byte_arr_aI[this.var_short_arr_h[2] + this.var_byte_U * 12] / 2, d.y[2] - this.var_byte_arr_aI[this.var_short_arr_h[20] + this.var_byte_U * 4] / 2, 20);
            this.b(this.var_int_j, d.x[2], d.y[2] - this.var_byte_arr_aI[this.var_short_arr_h[20] + this.var_byte_U * 4] / 2);
            this.var_int_r = 0;
            while (this.var_int_r < 2) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[71] + b.aj[this.var_int_r]], (int)this.var_byte_arr_aI[this.var_short_arr_h[72] + b.aj[this.var_int_r]], (int)this.var_byte_arr_aI[this.var_short_arr_h[73] + b.aj[this.var_int_r]], (int)this.var_byte_arr_aI[this.var_short_arr_h[74] + b.aj[this.var_int_r]], 0, d.x[this.var_int_r] - this.var_byte_arr_aI[this.var_short_arr_h[73] + b.aj[this.var_int_r]] - 7, d.y[this.var_int_r] - this.var_byte_arr_aI[this.var_short_arr_h[74] + b.aj[this.var_int_r]] / 2, 20);
                ++this.var_int_r;
            }
        }
        if (this.var_byte_R == 2 || this.var_byte_R == 5 || this.var_boolean_o || this.var_byte_R == 3) {
            this.dQ();
            this.Q();
        }
        if (this.var_byte_R == 12 || this.var_byte_R == 13) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[this.var_byte_R - 12 + 10], 0, 0, (int)b.var_short_arr_arr_c[this.var_byte_R - 12][0], (int)b.var_short_arr_arr_c[this.var_byte_R - 12][1], 0, (this.var_int_l - b.var_short_arr_arr_c[this.var_byte_R - 12][0]) / 2, (this.var_int_m - b.var_short_arr_arr_c[this.var_byte_R - 12][1]) / 2, 20);
        }
    }

    final void a(int n, int n2, int n3) {
        this.var_int_Y = 8;
        this.A();
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_d[n], (int)this.var_byte_arr_aI[this.var_short_arr_h[98] + n], (int)this.var_byte_arr_aI[this.var_short_arr_h[99] + n], (int)this.var_byte_arr_aI[this.var_short_arr_h[100] + n], (int)this.var_byte_arr_aI[this.var_short_arr_h[101] + n], 0, d.var_short_arr_i[0] - this.var_byte_arr_aI[this.var_short_arr_h[100] + n], (int)d.var_short_arr_j[0], 20);
        this.var_int_r = 0;
        while (this.var_int_r < 2) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[9], (int)this.var_byte_arr_aI[this.var_short_arr_h[13] + 8 + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[14] + 8 + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[15] + 8 + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[16] + 8 + this.var_int_r], 0, d.var_short_arr_i[1] - this.var_byte_arr_aI[this.var_short_arr_h[15] + 0 + 0] + this.var_byte_arr_aI[this.var_short_arr_h[17] + 8 + this.var_int_r], d.var_short_arr_j[1] + this.var_byte_arr_aI[this.var_short_arr_h[18] + 8 + this.var_int_r], 20);
            ++this.var_int_r;
        }
        this.var_int_q = n2 - 1;
        while (this.var_int_q >= 0) {
            this.var_int_r = this.var_int_arr_arr_c[n + this.var_int_q][d.var_short_arr_k[4]] - 1;
            while (this.var_int_r > 0) {
                this.var_int_s = d.var_short_arr_k[1] - this.var_int_arr_arr_c[n + this.var_int_q][this.var_int_r] * d.var_short_arr_k[2] / this.var_int_arr_arr_d[n][0];
                this.var_int_t = d.var_short_arr_k[1] - this.var_int_arr_arr_c[n + this.var_int_q][this.var_int_r - 1] * d.var_short_arr_k[2] / this.var_int_arr_arr_d[n][0];
                if (d.var_short_arr_k[3] > Math.abs(this.var_int_s - this.var_int_t)) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(b.var_int_arr_a[n3 + this.var_int_q * 2 + 1]);
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawLine(d.var_short_arr_k[0] + d.var_short_arr_k[3] * (this.var_int_arr_arr_c[n + this.var_int_q][d.var_short_arr_k[4]] - 1 - this.var_int_r) + 1, this.var_int_s + 1, d.var_short_arr_k[0] + d.var_short_arr_k[3] * (this.var_int_arr_arr_c[n + this.var_int_q][d.var_short_arr_k[4]] - this.var_int_r), this.var_int_t + 1);
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawLine(d.var_short_arr_k[0] + d.var_short_arr_k[3] * (this.var_int_arr_arr_c[n + this.var_int_q][d.var_short_arr_k[4]] - 1 - this.var_int_r) + 1, this.var_int_s - 1, d.var_short_arr_k[0] + d.var_short_arr_k[3] * (this.var_int_arr_arr_c[n + this.var_int_q][d.var_short_arr_k[4]] - this.var_int_r), this.var_int_t - 1);
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(b.var_int_arr_a[n3 + this.var_int_q * 2]);
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawLine(d.var_short_arr_k[0] + d.var_short_arr_k[3] * (this.var_int_arr_arr_c[n + this.var_int_q][d.var_short_arr_k[4]] - 1 - this.var_int_r) + 1, this.var_int_s, d.var_short_arr_k[0] + d.var_short_arr_k[3] * (this.var_int_arr_arr_c[n + this.var_int_q][d.var_short_arr_k[4]] - this.var_int_r), this.var_int_t);
                } else {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(b.var_int_arr_a[n3 + this.var_int_q * 2 + 1]);
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawLine(d.var_short_arr_k[0] + d.var_short_arr_k[3] * (this.var_int_arr_arr_c[n + this.var_int_q][d.var_short_arr_k[4]] - 1 - this.var_int_r) + 2, this.var_int_s, d.var_short_arr_k[0] + d.var_short_arr_k[3] * (this.var_int_arr_arr_c[n + this.var_int_q][d.var_short_arr_k[4]] - this.var_int_r) + 1, this.var_int_t);
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawLine(d.var_short_arr_k[0] + d.var_short_arr_k[3] * (this.var_int_arr_arr_c[n + this.var_int_q][d.var_short_arr_k[4]] - 1 - this.var_int_r), this.var_int_s, d.var_short_arr_k[0] + d.var_short_arr_k[3] * (this.var_int_arr_arr_c[n + this.var_int_q][d.var_short_arr_k[4]] - this.var_int_r) - 1, this.var_int_t);
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(b.var_int_arr_a[n3 + this.var_int_q * 2]);
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawLine(d.var_short_arr_k[0] + d.var_short_arr_k[3] * (this.var_int_arr_arr_c[n + this.var_int_q][d.var_short_arr_k[4]] - 1 - this.var_int_r) + 1, this.var_int_s, d.var_short_arr_k[0] + d.var_short_arr_k[3] * (this.var_int_arr_arr_c[n + this.var_int_q][d.var_short_arr_k[4]] - this.var_int_r), this.var_int_t);
                }
                --this.var_int_r;
            }
            --this.var_int_q;
        }
    }

    final void P() {
        if (this.var_byte_R == 10) {
            if (this.var_byte_K == 1) {
                this.var_int_r = 0;
                while (this.var_int_r < 3) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_d[this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[98] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[99] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[100] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[101] + this.var_int_r], 0, this.var_int_l / 2 - 7 - this.var_byte_arr_aI[this.var_short_arr_h[100] + this.var_int_r], d.var_short_arr_arr_d[this.var_byte_R][0] + (this.var_int_r + 1) * d.var_short_arr_arr_d[this.var_byte_R][1] - (this.var_byte_arr_aI[this.var_short_arr_h[101] + this.var_int_r] - b.var_byte_arr_b[0]) / 2, 20);
                    ++this.var_int_r;
                }
            } else {
                this.dQ();
                this.Q();
            }
        }
        if (this.var_byte_R == 20) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[71] + 10], (int)this.var_byte_arr_aI[this.var_short_arr_h[72] + 10], (int)this.var_byte_arr_aI[this.var_short_arr_h[73] + 10], (int)this.var_byte_arr_aI[this.var_short_arr_h[74] + 10], 0, d.var_short_arr_n[0] - this.var_byte_arr_aI[this.var_short_arr_h[73] + 10], d.var_short_arr_arr_e[this.var_byte_R][0] - this.var_byte_arr_aI[this.var_short_arr_h[74] + 10] / 2, 20);
        }
        if (this.var_byte_R == 25) {
            this.var_int_r = 0;
            while (this.var_int_r < this.var_byte_arr_u.length) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[71] + b.al[this.var_int_arr_arr_g[0][this.var_int_r]]], (int)this.var_byte_arr_aI[this.var_short_arr_h[72] + b.al[this.var_int_arr_arr_g[0][this.var_int_r]]], (int)this.var_byte_arr_aI[this.var_short_arr_h[73] + b.al[this.var_int_arr_arr_g[0][this.var_int_r]]], (int)this.var_byte_arr_aI[this.var_short_arr_h[74] + b.al[this.var_int_arr_arr_g[0][this.var_int_r]]], 0, (this.var_int_l - d.A[0]) / 2 + 10 - this.var_byte_arr_aI[this.var_short_arr_h[73] + b.al[this.var_int_arr_arr_g[0][this.var_int_r]]], d.var_short_arr_arr_d[this.var_byte_R][0] + d.var_short_arr_arr_d[this.var_byte_R][1] * this.var_int_r - (this.var_byte_arr_aI[this.var_short_arr_h[74] + b.al[this.var_int_arr_arr_g[0][this.var_int_r]]] - b.var_byte_arr_b[0]) / 2, 20);
                ++this.var_int_r;
            }
        }
        if (this.var_byte_R == 24) {
            this.var_javax_microedition_lcdui_Graphics_a.setClip((int)d.var_short_arr_f[0], (int)d.var_short_arr_f[1], (int)d.var_short_arr_f[2], (int)d.var_short_arr_f[3]);
            this.af();
            this.var_javax_microedition_lcdui_Graphics_a.setClip(0, 0, this.var_int_l, this.var_int_m);
        }
        this.cD();
        if ((this.var_byte_R > 17 || this.var_byte_R == 10 && this.var_byte_K == 1) && (this.var_boolean_arr_i[this.var_byte_arr_aI[this.var_short_arr_h[171 + this.var_byte_b] + this.var_int_aG]] || this.var_int_a / this.var_byte_m % 2 == 0)) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[8], 0, 12, 55, 13, 0, (this.var_int_l - 55) / 2, this.var_int_m - 2 - 13, 20);
        }
    }

    final void Q() {
        if (this.var_int_F > 0) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[8], (int)b.x[0], (int)b.y[0], (int)b.z[0], (int)b.A[0], 0, (int)d.r[this.var_byte_aC], (int)d.s[this.var_byte_aC * 2], 20);
        }
        if (this.var_int_F + d.var_byte_arr_j[this.var_byte_aC] < this.var_int_G) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[8], (int)b.x[1], (int)b.y[1], (int)b.z[1], (int)b.A[1], 0, (int)d.r[this.var_byte_aC], (int)d.s[this.var_byte_aC * 2 + 1], 20);
        }
    }

    final void R() {
        try {
            if (this.var_short_l == 0 && this.var_byte_R == 23) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[71] + 5 - (this.var_short_o - 1) / 2], (int)this.var_byte_arr_aI[this.var_short_arr_h[72] + 5 - (this.var_short_o - 1) / 2], (int)this.var_byte_arr_aI[this.var_short_arr_h[73] + 5 - (this.var_short_o - 1) / 2], (int)this.var_byte_arr_aI[this.var_short_arr_h[74] + 5 - (this.var_short_o - 1) / 2], 0, 87 - this.var_byte_arr_aI[this.var_short_arr_h[73] + 5 - (this.var_short_o - 1) / 2], this.var_short_m - this.var_byte_arr_aI[this.var_short_arr_h[74] + 5 - (this.var_short_o - 1) / 2] / 2, 20);
            } else {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[112] + this.var_short_l], (int)this.var_byte_arr_aI[this.var_short_arr_h[113] + this.var_short_l], (int)this.var_byte_arr_aI[this.var_short_arr_h[114] + this.var_short_l], (int)this.var_byte_arr_aI[this.var_short_arr_h[115] + this.var_short_l], 0, 87 - this.var_byte_arr_aI[this.var_short_arr_h[114] + this.var_short_l], this.var_short_m - this.var_byte_arr_aI[this.var_short_arr_h[115] + this.var_short_l] / 2, 20);
            }
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[6], (int)d.var_byte_arr_arr_arr_a[0][0][0], (int)d.var_byte_arr_arr_arr_b[0][0][0], 30, (int)d.var_byte_arr_arr_arr_d[0][0][0], 0, 90, this.var_short_m - d.var_byte_arr_arr_arr_d[0][0][0] / 2, 20);
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[6], d.var_byte_arr_arr_arr_c[0][0][0] - 30, (int)d.var_byte_arr_arr_arr_b[0][0][0], 30, (int)d.var_byte_arr_arr_arr_d[0][0][0], 0, 120, this.var_short_m - d.var_byte_arr_arr_arr_d[0][0][0] / 2 + 1, 20);
            this.var_int_s = 0;
            while (this.var_int_s < this.var_short_o) {
                if (this.var_short_l != 2) {
                    this.var_int_ab = this.var_short_l != 3 && this.var_short_l != 4 ? this.var_short_o - 1 : 10 - this.var_short_o;
                    if (this.var_short_l == 0 && this.var_byte_R != 23) {
                        this.var_int_ab = 9;
                    }
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)b.v[this.var_byte_arr_aI[this.var_short_arr_h[91] + this.var_int_ab]], (int)b.w[this.var_byte_arr_aI[this.var_short_arr_h[91] + this.var_int_ab]], 4, 10, 0, d.var_byte_arr_h[0] + this.var_short_n * this.var_int_s, this.var_short_m - 5, 20);
                } else {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], 63, 11, 8, 8, 0, d.var_byte_arr_h[0] + this.var_short_n * this.var_int_s, this.var_short_m - 4, 20);
                }
                ++this.var_int_s;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void S() {
        this.var_int_q = 0;
        while (this.var_int_q < this.var_byte_x) {
            this.var_int_r = this.var_int_q == 0 && this.var_byte_z == 0 ? 0 : 1;
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[3], (int)b.var_byte_arr_e[this.var_int_r], (int)b.var_byte_arr_f[this.var_int_r], (int)b.var_byte_arr_g[this.var_int_r], (int)b.var_byte_arr_h[this.var_int_r], 0, (int)d.var_short_arr_arr_a[this.var_byte_z][this.var_int_q], (int)d.var_short_arr_arr_b[this.var_byte_z][this.var_int_q], 20);
            this.var_int_r = (this.var_byte_y + this.var_int_q) % this.var_byte_x;
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[3], (int)this.var_byte_arr_aI[this.var_short_arr_h[120] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[121] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[122] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[123] + this.var_int_r], 0, d.var_short_arr_arr_a[this.var_byte_z][this.var_int_q] + this.var_byte_arr_aI[this.var_short_arr_h[124] + this.var_int_r], d.var_short_arr_arr_b[this.var_byte_z][this.var_int_q] + this.var_byte_arr_aI[this.var_short_arr_h[125] + this.var_int_r], 20);
            ++this.var_int_q;
        }
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[3], (int)this.var_byte_arr_aI[this.var_short_arr_h[116] + 2], (int)this.var_byte_arr_aI[this.var_short_arr_h[117] + 2], (int)this.var_byte_arr_aI[this.var_short_arr_h[118] + 2], (int)this.var_byte_arr_aI[this.var_short_arr_h[119] + 2], 0, 106, 25 + this.var_byte_arr_a[this.var_int_a % 4], 20);
        this.E();
    }

    final void T() {
        this.var_int_q = 0;
        while (this.var_int_q < this.var_byte_O) {
            this.var_int_r = 0;
            while (this.var_int_r < this.var_byte_O) {
                if (this.var_byte_arr_arr_b[this.var_int_q][this.var_int_r] > 0 && this.var_byte_arr_arr_b[this.var_int_q][this.var_int_r] <= 3) {
                    this.var_int_s = 0;
                } else if (this.var_byte_arr_arr_b[this.var_int_q][this.var_int_r] < 0 && this.var_byte_arr_arr_b[this.var_int_q][this.var_int_r] > -15) {
                    this.var_int_s = 1;
                } else if (this.var_byte_arr_arr_b[this.var_int_q][this.var_int_r] > 3) {
                    this.var_int_s = 2;
                } else if (this.var_byte_arr_arr_b[this.var_int_q][this.var_int_r] <= -15) {
                    this.var_int_s = 3;
                } else if (this.var_byte_arr_arr_b[this.var_int_q][this.var_int_r] == 0) {
                    this.var_int_s = 4;
                }
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[4], b.var_byte_arr_d[0] + b.var_byte_arr_d[2] * this.var_int_s, (int)b.var_byte_arr_d[1], (int)b.var_byte_arr_d[2], (int)b.var_byte_arr_d[3], 0, this.var_int_arr_m[this.var_byte_aN] + (this.var_int_q + this.var_int_r) * (b.var_byte_arr_d[2] / 2 + 1), this.var_int_m / 2 + (this.var_int_q - this.var_int_r - 1) * (b.var_byte_arr_d[3] / 2), 20);
                ++this.var_int_r;
            }
            ++this.var_int_q;
        }
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(0);
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawLine(this.var_int_arr_m[this.var_byte_aN] - 1, this.var_int_m / 2 - 1, this.var_int_arr_m[this.var_byte_aN] + this.var_byte_O * (b.var_byte_arr_d[2] / 2 + 1) - 1, this.var_int_m / 2 - (this.var_byte_O + 1) * (b.var_byte_arr_d[3] / 2) + 1);
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawLine(this.var_int_arr_m[this.var_byte_aN] - 1, this.var_int_m / 2, this.var_int_arr_m[this.var_byte_aN] + this.var_byte_O * (b.var_byte_arr_d[2] / 2 + 1) - 1, this.var_int_m / 2 + this.var_byte_O * (b.var_byte_arr_d[3] / 2));
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawLine(this.var_int_arr_m[this.var_byte_aN] + this.var_byte_O * (b.var_byte_arr_d[2] + 2) - 2, this.var_int_m / 2 - 1, this.var_int_arr_m[this.var_byte_aN] + this.var_byte_O * (b.var_byte_arr_d[2] / 2 + 1) - 1, this.var_int_m / 2 - (this.var_byte_O + 1) * (b.var_byte_arr_d[3] / 2) + 1);
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawLine(this.var_int_arr_m[this.var_byte_aN] + this.var_byte_O * (b.var_byte_arr_d[2] + 2) - 2, this.var_int_m / 2, this.var_int_arr_m[this.var_byte_aN] + this.var_byte_O * (b.var_byte_arr_d[2] / 2 + 1), this.var_int_m / 2 + this.var_byte_O * (b.var_byte_arr_d[3] / 2) - 1);
    }

    final void U() {
        if (this.var_byte_aW == 0) {
            this.var_byte_an = this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][37] + (this.var_byte_at * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 0] + this.var_int_W) * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 1] + this.var_int_X];
        } else if (this.var_byte_aW == 1) {
            this.var_byte_an = this.var_byte_arr_aI[this.var_short_arr_h[89] + this.var_byte_aV];
        } else if (this.var_byte_aW == 3) {
            this.var_byte_an = (byte)(this.var_byte_aV + this.var_byte_av);
        }
        if (this.var_byte_aW == 3 && this.var_byte_an == 13) {
            this.au();
        }
        if (this.var_byte_aW == 3 && this.var_byte_an != 13) {
            if ((this.var_byte_an & 2) != 0) {
                this.var_int_ak = 19;
                this.aK();
            } else if ((this.var_byte_an & 1) != 0) {
                this.var_int_ak = 20;
                this.aK();
            } else {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[2], (int)b.O[this.var_byte_an / 4], (int)b.P[this.var_byte_an / 4], b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
            }
        } else {
            this.V();
        }
        if (this.var_byte_aW == 3 && this.var_byte_an != 2 && this.var_byte_an != 1) {
            if (this.var_byte_an != 13) {
                this.au();
            }
            this.av();
        }
    }

    final void V() {
        if (this.var_byte_an == 0) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[2], (int)b.O[0], (int)b.P[0], b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
            return;
        }
        if (this.var_byte_an > 0) {
            if (this.var_byte_an > 3 && this.var_byte_an <= 12) {
                this.var_int_ak = 0;
                this.aI();
                if (this.var_byte_an == 7) {
                    this.var_int_ak = 11;
                    this.aI();
                }
                if (this.var_byte_an == 8) {
                    this.var_int_ak = 14;
                    this.aI();
                }
                if (this.var_byte_an == 5) {
                    this.var_int_ak = 13;
                    this.aI();
                }
                if (this.var_byte_an == 6) {
                    this.var_int_ak = 12;
                    this.aI();
                    return;
                }
            } else {
                if (this.var_byte_an <= 3) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[0], 0, b.B[1] * (this.var_byte_an - 1), b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
                    return;
                }
                if (this.var_byte_an == 13) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[5], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
                }
            }
        }
    }

    final void W() {
        this.var_boolean_u = false;
        if (this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_W][this.var_int_arr_a[1] + this.var_int_X] >= -13 && this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_W][this.var_int_arr_a[1] + this.var_int_X] <= 3) {
            if (this.var_byte_aW == 0 && this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_W][this.var_int_arr_a[1] + this.var_int_X] != 0) {
                if (this.var_int_arr_a[0] + this.var_int_B <= this.var_byte_O - 1 && this.var_byte_at == 1 && (this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][37] + (this.var_byte_at * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 0] + this.var_int_W) * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 1] + this.var_int_X] != 5 && this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][37] + (this.var_byte_at * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 0] + this.var_int_W) * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 1] + this.var_int_X] != 7 || this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_W + 1][this.var_int_arr_a[1] + this.var_int_X] != 0 || (this.var_byte_arr_arr_c[this.var_int_arr_a[0] + this.var_int_W + 1][this.var_int_arr_a[1] + this.var_int_X] & 2) == 0)) {
                    this.var_boolean_u = true;
                }
                if (this.var_int_arr_a[1] > 0 && this.var_byte_at == 0 && (this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][37] + (this.var_byte_at * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 0] + this.var_int_W) * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 1] + this.var_int_X] != 6 && this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][37] + (this.var_byte_at * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 0] + this.var_int_W) * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 1] + this.var_int_X] != 8 || this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_W][this.var_int_arr_a[1] + this.var_int_X - 1] != 0 || (this.var_byte_arr_arr_c[this.var_int_arr_a[0] + this.var_int_W][this.var_int_arr_a[1] + this.var_int_X - 1] & 1) == 0)) {
                    this.var_boolean_u = true;
                }
                if (this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][37] + (this.var_byte_at * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 0] + this.var_int_W) * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 1] + this.var_int_X] == 13) {
                    this.var_byte_aO = 1;
                    this.aa();
                }
            } else {
                this.X();
            }
        }
        this.Y();
        if (this.var_boolean_u) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[1], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
            return;
        }
        this.var_boolean_e = false;
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[1], 0, (int)b.B[1], b.B[0] - 2, (int)b.B[1], 0, this.var_int_V, this.var_int_U, 20);
    }

    final void X() {
        if (this.var_byte_aW == 1 && this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_W][this.var_int_arr_a[1] + this.var_int_X] != 0) {
            this.var_boolean_u = true;
            if (this.var_byte_aV != 26 && this.var_byte_aV >= 14) {
                if (this.var_int_arr_a[0] < this.var_byte_O - 1) {
                    if (this.var_byte_arr_aI[this.var_short_arr_h[163] - 1 - this.var_byte_au] == 1 && this.var_byte_arr_arr_b[this.var_int_arr_a[0] + 1][this.var_int_arr_a[1]] == 0 && (this.var_byte_arr_arr_c[this.var_int_arr_a[0] + 1][this.var_int_arr_a[1]] & 2) != 0) {
                        this.var_boolean_u = false;
                    }
                } else if (this.var_byte_arr_aI[this.var_short_arr_h[163] - 1 - this.var_byte_au] == 1 && this.var_byte_arr_aI[this.var_short_arr_h[164] - 1 - this.var_byte_au] == 0) {
                    this.var_boolean_u = false;
                }
                if (this.var_int_arr_a[1] > 0) {
                    if (this.var_byte_arr_aI[this.var_short_arr_h[164] - 1 - this.var_byte_au] == 1 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] - 1] == 0 && (this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1] - 1] & 1) != 0) {
                        this.var_boolean_u = false;
                        return;
                    }
                } else if (this.var_byte_arr_aI[this.var_short_arr_h[164] - 1 - this.var_byte_au] == 1 && this.var_byte_arr_aI[this.var_short_arr_h[163] - 1 - this.var_byte_au] == 0) {
                    this.var_boolean_u = false;
                    return;
                }
            } else if (this.var_byte_au >= -13 && this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_W][this.var_int_arr_a[1] + this.var_int_X] < 0) {
                this.var_boolean_u = false;
                return;
            }
        } else if (this.var_byte_aW == 3) {
            if (this.var_byte_aV % 4 == 0) {
                this.Z();
                return;
            }
            if (this.var_byte_aV == 13 && this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_W][this.var_int_arr_a[1] + this.var_int_X] != 0) {
                this.var_byte_aO = (byte)2;
                this.aa();
            }
        }
    }

    final void Y() {
        if (this.var_byte_aW == 0 && this.var_byte_aV != 22 && this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][37] + (this.var_byte_at * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 0] + this.var_int_W) * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 1] + this.var_int_X] == 1) {
            this.var_boolean_u = true;
        }
        if (this.var_byte_aW == 3 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 0) {
            if (this.var_byte_aV + this.var_byte_av == 2 && (this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] & 2) == 0) {
                this.var_boolean_u = true;
                if (this.var_int_arr_a[0] > 0) {
                    if (this.var_byte_arr_arr_b[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]] <= -15 && this.var_byte_arr_arr_b[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]] >= -27 && this.var_byte_arr_aI[this.var_short_arr_h[163] - 1 - this.var_byte_arr_arr_b[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]]] == 1) {
                        this.var_boolean_u = false;
                    }
                    if (this.var_byte_arr_arr_b[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]] == 5 || this.var_byte_arr_arr_b[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]] == 7 || this.var_byte_arr_arr_b[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]] == 0) {
                        this.var_boolean_u = false;
                        return;
                    }
                }
            } else if (this.var_byte_aV + this.var_byte_av == 1 && (this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] & 1) == 0) {
                this.var_boolean_u = true;
                if (this.var_int_arr_a[1] < this.var_byte_O - 1) {
                    if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1] <= -15 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1] >= -27 && this.var_byte_arr_aI[this.var_short_arr_h[164] - 1 - this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1]] == 1) {
                        this.var_boolean_u = false;
                    }
                    if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1] == 6 || this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1] == 8 || this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1] == 0) {
                        this.var_boolean_u = false;
                    }
                }
            }
        }
    }

    final void Z() {
        if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] >= -13 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] <= 3) {
            this.var_boolean_u = true;
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 0 && this.var_byte_aV <= this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]) {
                this.var_boolean_u = false;
            }
            if (this.var_int_arr_a[0] < this.var_byte_O - 1 && this.var_byte_arr_arr_b[this.var_int_arr_a[0] + 1][this.var_int_arr_a[1]] == 0 && (this.var_byte_arr_arr_c[this.var_int_arr_a[0] + 1][this.var_int_arr_a[1]] & 2) != 0) {
                this.var_boolean_u = false;
            }
            if (this.var_int_arr_a[1] > 0 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] - 1] == 0 && (this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1] - 1] & 1) != 0) {
                this.var_boolean_u = false;
            }
        }
    }

    final void aa() {
        if (this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_W][this.var_int_arr_a[1] + this.var_int_X] >= -13 && this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_W][this.var_int_arr_a[1] + this.var_int_X] != 0 && this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_W][this.var_int_arr_a[1] + this.var_int_X] <= 3) {
            this.var_boolean_u = true;
            this.var_byte_arr_aV[0] = (byte)(this.var_int_arr_a[0] + this.var_int_W);
            this.var_byte_arr_aV[1] = (byte)(this.var_int_arr_a[1] + this.var_int_X);
            this.var_byte_aQ = 0;
            this.var_byte_aP = 0;
            while (this.var_byte_aP < 4) {
                if (this.var_byte_arr_aV[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 0] >= this.var_byte_O || this.var_byte_arr_aV[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 1] >= this.var_byte_O || this.var_byte_arr_aV[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 0] < 0 || this.var_byte_arr_aV[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 1] < 0) {
                    this.var_byte_arr_aU[this.var_byte_aP] = 1;
                } else {
                    this.var_byte_arr_aU[this.var_byte_aP] = this.var_byte_arr_arr_b[this.var_byte_arr_aV[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 0]][this.var_byte_arr_aV[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 1]];
                    if ((this.var_byte_arr_aU[this.var_byte_aP] == 7 || this.var_byte_arr_aU[this.var_byte_aP] == 5) && this.var_byte_aP == 1 || (this.var_byte_arr_aU[this.var_byte_aP] == 8 || this.var_byte_arr_aU[this.var_byte_aP] == 6) && this.var_byte_aP == 0 || this.var_byte_arr_aU[this.var_byte_aP] == 13) {
                        this.var_byte_aQ = (byte)(this.var_byte_aQ + 1);
                    }
                }
                this.var_byte_aP = (byte)(this.var_byte_aP + 1);
            }
            if (this.var_byte_aQ > this.var_byte_aO) {
                this.var_boolean_u = false;
                return;
            }
            this.var_byte_aR = 0;
            while (this.var_byte_aR < 4) {
                if (this.var_byte_arr_aU[this.var_byte_aR] == 13) {
                    this.var_byte_arr_aV[0] = (byte)(this.var_int_arr_a[0] + this.var_int_W + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aR * 2 + 0]);
                    this.var_byte_arr_aV[1] = (byte)(this.var_int_arr_a[1] + this.var_int_X + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aR * 2 + 1]);
                    this.var_byte_aQ = 0;
                    this.var_byte_aP = 0;
                    while (this.var_byte_aP < 4) {
                        if (this.var_byte_arr_aV[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 0] < this.var_byte_O && this.var_byte_arr_aV[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 1] < this.var_byte_O && this.var_byte_arr_aV[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 0] >= 0 && this.var_byte_arr_aV[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 1] >= 0 && ((this.var_byte_arr_arr_b[this.var_byte_arr_aV[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 0]][this.var_byte_arr_aV[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 1]] == 7 || this.var_byte_arr_arr_b[this.var_byte_arr_aV[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 0]][this.var_byte_arr_aV[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 1]] == 5) && this.var_byte_aP == 1 || (this.var_byte_arr_arr_b[this.var_byte_arr_aV[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 0]][this.var_byte_arr_aV[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 1]] == 8 || this.var_byte_arr_arr_b[this.var_byte_arr_aV[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 0]][this.var_byte_arr_aV[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 1]] == 6) && this.var_byte_aP == 0 || this.var_byte_arr_arr_b[this.var_byte_arr_aV[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 0]][this.var_byte_arr_aV[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_aP * 2 + 1]] == 13)) {
                            this.var_byte_aQ = (byte)(this.var_byte_aQ + 1);
                        }
                        this.var_byte_aP = (byte)(this.var_byte_aP + 1);
                    }
                    if (this.var_byte_aQ > 1) {
                        this.var_boolean_u = false;
                        return;
                    }
                }
                this.var_byte_aR = (byte)(this.var_byte_aR + 1);
            }
        }
    }

    final void ab() {
        this.var_int_k -= this.var_short_arr_e[b.j[3]];
        this.var_int_e += this.var_short_arr_e[b.j[3]];
        this.var_int_ac = 200;
        while (this.var_int_ac < 222) {
            if (this.var_byte_arr_B[this.var_int_ac] >= 0) {
                this.var_byte_arr_aT[0] = this.var_byte_arr_B[this.var_int_ac];
                this.var_byte_arr_aT[1] = this.var_byte_arr_C[this.var_int_ac];
                this.var_short_h = (short)(b.B[0] / 2);
                this.var_short_i = 0;
                this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
                this.var_java_lang_StringBuffer_a.append("-");
                this.var_java_lang_StringBuffer_a.append(this.var_byte_arr_aI[this.var_short_arr_h[131] + this.var_byte_arr_A[this.var_int_ac] - 8]);
                this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
                this.dL();
            }
            ++this.var_int_ac;
        }
    }

    final void ac() {
        this.var_int_ad = 0;
        while (this.var_int_ad < 8) {
            this.var_int_ae = 0;
            while (this.var_int_ae < d.var_short_arr_k[4] - 1) {
                this.var_int_arr_arr_c[this.var_int_ad][d.var_short_arr_k[4] - 1 - this.var_int_ae] = this.var_int_arr_arr_c[this.var_int_ad][d.var_short_arr_k[4] - 2 - this.var_int_ae];
                ++this.var_int_ae;
            }
            this.var_int_arr_arr_c[this.var_int_ad][0] = this.var_int_arr_arr_c[this.var_int_ad][d.var_short_arr_k[4] + 1];
            if (this.var_int_arr_arr_c[this.var_int_ad][d.var_short_arr_k[4]] < d.var_short_arr_k[4]) {
                int[] nArray = this.var_int_arr_arr_c[this.var_int_ad];
                short s = d.var_short_arr_k[4];
                nArray[s] = nArray[s] + 1;
            }
            if (this.var_int_arr_arr_c[this.var_int_ad][0] < 0) {
                this.var_int_arr_arr_c[this.var_int_ad][0] = 0;
            }
            ++this.var_int_ad;
        }
        this.var_int_g += this.var_int_arr_arr_c[1][0];
        this.var_int_arr_arr_c[3][0] = 0;
        this.var_int_ad = 0;
        while (this.var_int_ad < this.var_byte_O / 5) {
            this.var_int_ae = 0;
            while (this.var_int_ae < this.var_byte_O / 5) {
                int[] nArray = this.var_int_arr_arr_c[3];
                nArray[0] = nArray[0] + this.var_short_arr_arr_a[this.var_int_ad][this.var_int_ae];
                ++this.var_int_ae;
            }
            ++this.var_int_ad;
        }
        int[] nArray = this.var_int_arr_arr_c[3];
        nArray[0] = nArray[0] / 10;
        int[] nArray2 = this.var_int_arr_arr_c[3];
        nArray2[0] = nArray2[0] + (this.var_byte_arr_aD[24] + this.var_byte_ai * 2 + this.var_byte_ak + this.var_short_a);
        int[] nArray3 = this.var_int_arr_arr_c[3];
        nArray3[0] = nArray3[0] * this.var_int_arr_arr_c[1][0];
        int[] nArray4 = this.var_int_arr_arr_c[3];
        nArray4[0] = nArray4[0] / 9;
        this.var_int_ad = 4;
        while (this.var_int_ad < 8) {
            if (this.var_int_b % 3 == 0) {
                this.var_byte_arr_aW[this.var_int_ad - 4] = this.var_int_arr_arr_c[this.var_int_ad][1] < this.var_short_arr_a[this.var_byte_M * 7 + this.var_byte_arr_aX[this.var_int_ad - 4] * 2 + 1] ? (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 4) : (this.var_int_arr_arr_c[this.var_int_ad][1] > this.var_short_arr_a[this.var_byte_M * 7 + this.var_byte_arr_aX[this.var_int_ad - 4] * 2 + 2] ? (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 4 + 4) : (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 8));
            }
            if ((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 5 == 0) {
                this.var_byte_arr_aX[this.var_int_ad - 4] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3);
            }
            this.var_int_ae = (this.var_java_util_Random_a.nextInt() & 0xFFFF) % this.var_short_arr_a[this.var_byte_M * 7];
            this.var_int_af = this.var_short_arr_a[this.var_byte_M * 7] / 2;
            this.var_int_arr_arr_c[this.var_int_ad][0] = this.var_int_arr_arr_c[this.var_int_ad][1] + this.var_byte_arr_aI[this.var_short_arr_h[176] + this.var_byte_arr_aW[this.var_int_ad - 4] * 3 + this.var_int_b % 3] + this.var_int_ae - this.var_int_af;
            if (this.var_int_arr_arr_c[this.var_int_ad][0] < 0) {
                this.var_int_arr_arr_c[this.var_int_ad][0] = 0;
            }
            ++this.var_int_ad;
        }
    }

    final void ad() {
        this.var_int_ad = 0;
        while (this.var_int_ad < 3) {
            switch (this.var_int_ad) {
                case 0: {
                    this.var_int_arr_arr_c[this.var_int_ad][d.var_short_arr_k[4] + 1] = this.var_int_k;
                    break;
                }
                case 1: {
                    if (this.var_short_a > 0) {
                        this.var_int_arr_arr_c[this.var_int_ad][d.var_short_arr_k[4] + 1] = 0;
                        this.var_int_ae = 0;
                        while (this.var_int_ae < 200) {
                            if (this.var_byte_arr_B[this.var_int_ae] >= 0) {
                                int[] nArray = this.var_int_arr_arr_c[this.var_int_ad];
                                int n = d.var_short_arr_k[4] + 1;
                                nArray[n] = nArray[n] + this.var_byte_arr_P[this.var_int_ae];
                            }
                            ++this.var_int_ae;
                        }
                        int[] nArray = this.var_int_arr_arr_c[this.var_int_ad];
                        int n = d.var_short_arr_k[4] + 1;
                        nArray[n] = nArray[n] / this.var_short_a;
                        int[] nArray2 = this.var_int_arr_arr_c[this.var_int_ad];
                        int n2 = d.var_short_arr_k[4] + 1;
                        nArray2[n2] = nArray2[n2] / 10;
                        break;
                    }
                    this.var_int_arr_arr_c[this.var_int_ad][d.var_short_arr_k[4] + 1] = 0;
                    break;
                }
                case 2: {
                    this.var_int_arr_arr_c[this.var_int_ad][d.var_short_arr_k[4] + 1] = this.var_short_a;
                }
            }
            ++this.var_int_ad;
        }
        this.var_int_ad = 0;
        while (this.var_int_ad < 3) {
            this.var_int_arr_arr_e[this.var_int_ad][0] = this.var_int_arr_arr_c[this.var_int_ad][d.var_short_arr_k[4] + 1];
            ++this.var_int_ad;
        }
    }

    final void ae() {
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[2], (int)this.var_byte_arr_aI[this.var_short_arr_h[106] + this.var_byte_d], (int)this.var_byte_arr_aI[this.var_short_arr_h[107] + this.var_byte_d], (int)this.var_byte_arr_aI[this.var_short_arr_h[108] + this.var_byte_d], (int)this.var_byte_arr_aI[this.var_short_arr_h[109] + this.var_byte_d], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[110] + this.var_int_ak] - this.var_byte_arr_aI[this.var_short_arr_h[108] + this.var_byte_d] / 2, this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[111] + this.var_int_ak] - this.var_byte_arr_aI[this.var_short_arr_h[109] + this.var_byte_d] / 2, 20);
    }

    final void af() {
        try {
            if (this.var_byte_aW != 2) {
                this.var_byte_arr_aL[0] = 0;
                this.var_byte_arr_aL[1] = 0;
                this.var_byte_arr_aM[0] = 1;
                this.var_byte_arr_aM[1] = 1;
                if (this.var_byte_aW == 0) {
                    this.var_byte_ar = this.var_byte_aV;
                    this.var_byte_arr_aM[0] = 0;
                    while (this.var_byte_arr_aM[0] < this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 0]) {
                        this.var_byte_arr_aM[1] = 0;
                        while (this.var_byte_arr_aM[1] < this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 1] && this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][37] + (this.var_byte_at * this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 0] + this.var_byte_arr_aM[0]) * this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 1] + this.var_byte_arr_aM[1]] != 10) {
                            this.var_byte_arr_aM[1] = (byte)(this.var_byte_arr_aM[1] + 1);
                        }
                        if (this.var_byte_arr_aM[1] < this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 1]) break;
                        this.var_byte_arr_aM[0] = (byte)(this.var_byte_arr_aM[0] + 1);
                    }
                }
                this.var_boolean_e = true;
                this.ag();
                this.ah();
            } else {
                this.aj();
                if (this.var_boolean_e && this.var_byte_b == 0) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], 52, 32, 7, 7, 0, this.var_int_x + b.k[this.var_byte_d % 3] + this.var_byte_arr_aI[this.var_short_arr_h[51] + this.var_byte_C], this.var_int_y + b.l[this.var_byte_d % 3], 20);
                }
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void ag() {
        this.var_int_U = this.var_int_y;
        while (this.var_int_U <= this.var_int_y + this.var_int_A - b.B[1]) {
            this.var_int_V = (this.var_int_U - this.var_int_y) % b.B[1] == 0 ? this.var_int_x : this.var_int_x + b.B[0] / 2;
            while (this.var_int_V <= this.var_int_x + this.var_int_z - b.B[0]) {
                this.var_int_W = ((this.var_int_U - this.var_int_y) / (b.B[1] / 2) + (this.var_int_V - this.var_int_x) / (b.B[0] / 2)) / 2 + this.var_int_arr_b[0];
                this.var_int_X = ((this.var_int_V - this.var_int_x) / (b.B[0] / 2) - (this.var_int_U - this.var_int_y) / (b.B[1] / 2)) / 2 + this.var_int_arr_b[1];
                if ((this.var_byte_j != 1 || this.var_byte_b != 0 || this.var_int_W >= b.var_byte_arr_arr_arr_a[this.var_byte_at][this.var_byte_j][0] && this.var_int_X >= b.var_byte_arr_arr_arr_b[this.var_byte_at][this.var_byte_j][0]) && this.var_int_W >= 0 && this.var_int_X >= 0 && this.var_int_W < this.var_int_B && this.var_int_X < this.var_int_C) {
                    if (this.var_boolean_f) {
                        if (this.var_int_W == 0) {
                            this.var_int_ak = 0;
                            this.ae();
                        }
                        if (this.var_int_W == this.var_int_B - 1) {
                            this.var_int_ak = 1;
                            this.ae();
                        }
                        if (this.var_int_X == 0) {
                            this.var_int_ak = 2;
                            this.ae();
                        }
                        if (this.var_int_X == this.var_int_C - 1) {
                            this.var_int_ak = 3;
                            this.ae();
                        }
                    }
                    if (this.var_byte_b != 0 || this.var_boolean_f) {
                        this.U();
                    } else {
                        this.W();
                    }
                }
                this.var_int_V += b.B[0];
            }
            this.var_int_U += b.B[1] / 2;
        }
    }

    final void ah() {
        if (!(this.var_byte_b == 0 && this.var_byte_d / this.var_byte_m % 2 != 0 || this.var_byte_b != 0 && this.var_byte_aW == 3)) {
            this.var_int_U = this.var_int_y;
            while (this.var_int_U <= this.var_int_y + this.var_int_A - b.B[1]) {
                this.var_int_V = (this.var_int_U - this.var_int_y) % b.B[1] == 0 ? this.var_int_x : this.var_int_x + b.B[0] / 2;
                while (this.var_int_V <= this.var_int_x + this.var_int_z - b.B[0]) {
                    this.var_int_W = ((this.var_int_U - this.var_int_y) / (b.B[1] / 2) + (this.var_int_V - this.var_int_x) / (b.B[0] / 2)) / 2 + this.var_int_arr_b[0];
                    this.var_int_X = ((this.var_int_V - this.var_int_x) / (b.B[0] / 2) - (this.var_int_U - this.var_int_y) / (b.B[1] / 2)) / 2 + this.var_int_arr_b[1];
                    if ((this.var_byte_j != 1 || this.var_byte_b != 0 || this.var_int_W >= b.var_byte_arr_arr_arr_a[this.var_byte_at][this.var_byte_j][0] && this.var_int_X >= b.var_byte_arr_arr_arr_b[this.var_byte_at][this.var_byte_j][0]) && this.var_int_W >= 0 && this.var_int_X >= 0 && this.var_int_W < this.var_int_B && this.var_int_X < this.var_int_C) {
                        if (this.var_byte_aW < 2) {
                            this.var_byte_an = this.var_byte_aW == 0 ? this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][37] + (this.var_byte_at * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 0] + this.var_int_W) * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 1] + this.var_int_X] : (this.var_byte_b != 0 ? (byte)(-1 - this.var_byte_aV) : this.var_byte_au);
                            if (this.var_byte_an > 3) {
                                this.ai();
                            } else {
                                if (this.var_byte_aV == 26) {
                                    this.var_byte_an = b.var_byte_arr_arr_h[this.var_int_W][this.var_int_X];
                                }
                                if (this.var_byte_an < 0 && this.var_byte_an >= -27) {
                                    this.var_byte_aq = 0;
                                    this.var_boolean_q = this.var_byte_b != 0;
                                    this.var_boolean_r = this.var_byte_b == 0;
                                    this.aH();
                                }
                            }
                        } else {
                            this.U();
                        }
                    }
                    this.var_int_V += b.B[0];
                }
                this.var_int_U += b.B[1] / 2;
            }
        }
    }

    final void ai() {
        this.var_byte_as = 0;
        this.var_byte_am = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][38] + (this.var_byte_at * this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 0] + this.var_int_W) * this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 1] + this.var_int_X];
        this.a(true);
        if (this.var_byte_an == 10) {
            this.aD();
            if (this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][4] + 3] == 1 && this.var_byte_b != 0) {
                this.var_int_q = 0;
                while (this.var_int_q < b.am[2]) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[3], (int)this.var_byte_arr_aI[this.var_short_arr_h[165] + b.an[2] + this.var_int_q], (int)this.var_byte_arr_aI[this.var_short_arr_h[166] + b.an[2] + this.var_int_q], (int)this.var_byte_arr_aI[this.var_short_arr_h[167] + b.an[2] + this.var_int_q], (int)this.var_byte_arr_aI[this.var_short_arr_h[168] + b.an[2] + this.var_int_q], 0, d.var_short_arr_arr_arr_a[0][3][0] + b.o[0] + this.var_byte_arr_aI[this.var_short_arr_h[169] + b.an[2] + this.var_int_q], d.var_short_arr_arr_arr_b[0][0][0] + b.o[1] + this.var_byte_arr_aI[this.var_short_arr_h[170] + b.an[2] + this.var_int_q], 20);
                    ++this.var_int_q;
                }
            }
        }
        if (this.var_byte_an == 9 || this.var_byte_an == 11 || this.var_byte_an == 12) {
            this.aD();
        }
        this.var_byte_ao = this.var_byte_an == 11 ? (byte)1 : 0;
        this.var_byte_ap = this.var_byte_an == 12 ? (byte)1 : 0;
        this.b(true);
    }

    final void aj() {
        this.var_int_s = this.var_byte_b == 0 ? this.var_int_y : 176 - this.var_byte_arr_aI[this.var_short_arr_h[52] + this.var_byte_C] / 2;
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_a[this.var_byte_aV], (int)this.var_byte_arr_aI[this.var_short_arr_h[49] + this.var_byte_C], (int)this.var_byte_arr_aI[this.var_short_arr_h[50] + this.var_byte_C], (int)this.var_byte_arr_aI[this.var_short_arr_h[51] + this.var_byte_C], (int)this.var_byte_arr_aI[this.var_short_arr_h[52] + this.var_byte_C], 0, this.var_int_x, this.var_int_s, 20);
        this.var_boolean_e = false;
        switch (this.var_byte_C) {
            case 0: 
            case 1: {
                if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] != 0) break;
                this.var_boolean_e = true;
                return;
            }
            case 2: {
                if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] <= 3 || this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] != 23 || this.var_boolean_arr_a[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]) break;
                this.var_boolean_e = true;
                return;
            }
            case 3: 
            case 4: 
            case 5: {
                if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] >= 0 || this.var_byte_arr_aI[this.var_short_arr_h[56] + -1 - this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] != this.var_byte_C || this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]) break;
                this.var_boolean_e = true;
            }
        }
    }

    final void ak() {
        if (!this.var_boolean_o) {
            this.var_int_ag = 0;
            while (this.var_int_ag < this.var_byte_arr_aI[this.var_short_arr_h[132] + this.var_byte_aW * 2]) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_d[this.var_int_ag], (int)this.var_byte_arr_aI[this.var_short_arr_h[98] + this.var_int_ag], (int)this.var_byte_arr_aI[this.var_short_arr_h[99] + this.var_int_ag], (int)this.var_byte_arr_aI[this.var_short_arr_h[100] + this.var_int_ag], (int)this.var_byte_arr_aI[this.var_short_arr_h[101] + this.var_int_ag], 0, d.var_short_arr_n[this.var_byte_arr_aI[this.var_short_arr_h[132] + this.var_byte_aW * 2 + 1] + this.var_int_ag * 2] - this.var_byte_arr_aI[this.var_short_arr_h[100] + this.var_int_ag], 105, 20);
                ++this.var_int_ag;
            }
            if (this.var_byte_aW < 2) {
                this.var_javax_microedition_lcdui_Graphics_a.setClip((int)d.var_short_arr_f[0], (int)d.var_short_arr_f[1], (int)d.var_short_arr_f[2], (int)d.var_short_arr_f[3]);
            }
            this.af();
            if (this.var_byte_aW < 2) {
                this.var_javax_microedition_lcdui_Graphics_a.setClip(0, 0, this.var_int_l, this.var_int_m);
            }
        } else {
            this.dQ();
        }
        this.B();
        this.C();
        this.cD();
        if (this.var_boolean_arr_i[this.var_byte_arr_aI[this.var_short_arr_h[171 + this.var_byte_b] + this.var_int_aG]] || this.var_int_a / this.var_byte_m % 2 == 0) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[8], 0, 12, 55, 13, 0, (this.var_int_l - 55) / 2, this.var_int_m - 2 - 13, 20);
        }
    }

    final void al() {
        this.var_int_U = -(b.B[1] / 2) - 1 * b.B[1] + this.var_byte_X;
        while (this.var_int_U < this.var_int_m + 4 * b.B[1]) {
            this.var_int_V = (this.var_int_U - this.var_byte_X) % b.B[1] == 0 ? -1 * b.B[0] + this.var_byte_W : -(b.B[0] / 2) - 1 * b.B[0] + this.var_byte_W;
            while (this.var_int_V < this.var_int_l + 1 * b.B[0]) {
                this.var_int_W = ((this.var_int_U - this.var_byte_X) / (b.B[1] / 2) + (this.var_int_V - this.var_byte_W) / (b.B[0] / 2)) / 2 + this.var_int_arr_arr_f[0][0];
                this.var_int_X = ((this.var_int_V - this.var_byte_W) / (b.B[0] / 2) - (this.var_int_U - this.var_byte_X) / (b.B[1] / 2)) / 2 + this.var_int_arr_arr_f[0][1];
                if (this.var_int_W == this.var_byte_ab - 1 && this.var_int_X == -1) {
                    this.as();
                }
                if (this.var_int_W == this.var_byte_ab + 1 && this.var_int_X == -1) {
                    this.at();
                }
                if (this.var_int_W >= 0 && this.var_int_X >= 0 && this.var_int_W < this.var_byte_O && this.var_int_X < this.var_byte_O) {
                    this.var_byte_an = this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X];
                    if (this.var_byte_an == 0 || this.var_byte_an > 3) {
                        this.am();
                        this.ap();
                        this.ao();
                    } else {
                        this.an();
                    }
                }
                this.var_int_V += b.B[0];
            }
            this.var_int_U += b.B[1] / 2;
        }
    }

    final void am() {
        if (this.var_byte_an != 0 && this.var_byte_an <= 12) {
            this.var_byte_ar = this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]];
            this.var_byte_as = this.var_byte_arr_ab[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]];
            this.var_byte_arr_aL[0] = this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]];
            this.var_byte_arr_aL[1] = this.var_byte_arr_arr_l[1][this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]];
            this.var_byte_arr_aM[0] = this.var_byte_arr_arr_m[0][this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]];
            this.var_byte_arr_aM[1] = this.var_byte_arr_arr_m[1][this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]];
            this.var_byte_ao = 0;
            if (this.var_byte_an == 11 && (this.var_byte_arr_ag[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] != 1 && this.var_byte_arr_ag[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] != 0 || this.var_int_X != this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]) && (this.var_byte_arr_ag[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] != 2 || this.var_int_X != this.var_byte_arr_arr_n[1][this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]])) {
                this.var_byte_ao = 1;
            }
            this.var_byte_ap = 0;
            if (this.var_byte_an == 12 && (this.var_byte_arr_ag[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] != 1 && this.var_byte_arr_ag[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] != 0 || this.var_int_W != this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]) && (this.var_byte_arr_ag[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] != 2 || this.var_int_W != this.var_byte_arr_arr_n[0][this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]])) {
                this.var_byte_ap = 1;
            }
            if (this.var_byte_ar != 22) {
                this.var_byte_am = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][38] + (this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] * this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 0] + this.var_int_W - this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]) * this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 1] + this.var_int_X - this.var_byte_arr_arr_l[1][this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]];
                return;
            }
            if (this.var_byte_an == 6 || this.var_byte_an == 8) {
                this.var_byte_am = (byte)74;
            }
            if (this.var_byte_an == 5 || this.var_byte_an == 7) {
                this.var_byte_am = (byte)-123;
            }
        }
    }

    final void an() {
        if (this.var_byte_an < 0 && this.var_byte_an >= -27) {
            if (this.var_byte_an <= -15) {
                this.var_byte_aq = this.var_byte_arr_ak[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]];
                this.var_boolean_q = this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]];
                this.var_boolean_r = this.var_boolean_arr_e[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]];
            }
            this.aH();
            if (this.var_byte_an <= -15 && this.var_byte_e / this.var_byte_m % 2 != 0 && (this.var_boolean_arr_f[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] || this.var_byte_arr_aI[this.var_short_arr_h[56] + -1 - this.var_byte_an] >= 0 && !this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]])) {
                this.var_int_q = this.var_byte_arr_aI[this.var_short_arr_h[163] - 1 - this.var_byte_an] == 1 ? 1 : 0;
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[165] + b.an[this.var_int_q] + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[166] + b.an[this.var_int_q] + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[167] + b.an[this.var_int_q] + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[168] + b.an[this.var_int_q] + 0], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[169] + b.an[this.var_int_q] + 0], this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[170] + b.an[this.var_int_q] + 0], 20);
            }
            if (this.var_byte_an <= -15 && this.var_byte_g == 0 && this.var_byte_e == 0 && this.var_byte_arr_ak[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] >= 0 && this.var_byte_arr_aI[this.var_short_arr_h[56] + -1 - this.var_byte_an] >= 0 && this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]) {
                this.var_byte_arr_aT[0] = (byte)this.var_int_W;
                this.var_byte_arr_aT[1] = (byte)this.var_int_X;
                this.var_short_h = (short)(b.B[0] / 2);
                this.var_short_i = 0;
                this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
                this.var_java_lang_StringBuffer_a.append("-");
                this.var_java_lang_StringBuffer_a.append(this.var_byte_arr_aI[this.var_short_arr_h[131] + this.var_byte_arr_aI[this.var_short_arr_h[56] + -1 - this.var_byte_an]]);
                this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
                this.dL();
            }
        }
    }

    final void ao() {
        if (this.var_byte_an == 9 || this.var_byte_an == 11 || this.var_byte_an == 12) {
            this.aD();
        }
        this.aL();
        if (this.var_int_U < this.var_int_m && this.var_int_V + b.B[0] > 0 && this.var_int_V < this.var_int_l) {
            if (this.var_byte_an == 0) {
                this.aC();
            } else if (this.var_byte_an <= 12) {
                this.b(false);
                if ((this.var_byte_an == 5 || this.var_byte_an == 6) && this.var_byte_e / this.var_byte_m % 2 != 0) {
                    if (!this.var_boolean_arr_a[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]) {
                        if (this.var_byte_an == 5) {
                            this.var_int_q = 1;
                        }
                        if (this.var_byte_an == 6) {
                            this.var_int_q = 0;
                        }
                        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[165] + b.an[this.var_int_q] + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[166] + b.an[this.var_int_q] + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[167] + b.an[this.var_int_q] + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[168] + b.an[this.var_int_q] + 0], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[169] + b.an[this.var_int_q] + 0], this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[170] + b.an[this.var_int_q] + 0], 20);
                    } else if (!this.var_boolean_arr_c[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]) {
                        this.var_int_r = 0;
                        while (this.var_int_r < b.am[3]) {
                            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[3], (int)this.var_byte_arr_aI[this.var_short_arr_h[165] + b.an[3] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[166] + b.an[3] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[167] + b.an[3] + this.var_int_r], (int)this.var_byte_arr_aI[this.var_short_arr_h[168] + b.an[3] + this.var_int_r], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[169] + b.an[3] + this.var_int_r], this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[170] + b.an[3] + this.var_int_r], 20);
                            ++this.var_int_r;
                        }
                    }
                }
            }
            this.aB();
        }
    }

    final void ap() {
        if (this.var_int_U < this.var_int_m && this.var_int_V + b.B[0] > 0 && this.var_int_V < this.var_int_l) {
            if (this.var_byte_an == 0) {
                this.ax();
            } else if (this.var_byte_an <= 12) {
                this.a(false);
            }
            this.az();
        }
        if (this.var_byte_an == 10) {
            this.aD();
            if (!this.var_boolean_arr_b[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] && this.var_byte_e / this.var_byte_m % 2 == 0) {
                this.var_int_q = 0;
                while (this.var_int_q < b.am[2]) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[3], (int)this.var_byte_arr_aI[this.var_short_arr_h[165] + b.an[2] + this.var_int_q], (int)this.var_byte_arr_aI[this.var_short_arr_h[166] + b.an[2] + this.var_int_q], (int)this.var_byte_arr_aI[this.var_short_arr_h[167] + b.an[2] + this.var_int_q], (int)this.var_byte_arr_aI[this.var_short_arr_h[168] + b.an[2] + this.var_int_q], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[169] + b.an[2] + this.var_int_q], this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[170] + b.an[2] + this.var_int_q], 20);
                    ++this.var_int_q;
                }
            }
            if (this.var_byte_arr_ah[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] < 10 && this.var_byte_e / this.var_byte_m % 2 == 1) {
                this.var_int_q = 0;
                while (this.var_int_q < b.am[4]) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[165] + b.an[4] + this.var_int_q], (int)this.var_byte_arr_aI[this.var_short_arr_h[166] + b.an[4] + this.var_int_q], (int)this.var_byte_arr_aI[this.var_short_arr_h[167] + b.an[4] + this.var_int_q], (int)this.var_byte_arr_aI[this.var_short_arr_h[168] + b.an[4] + this.var_int_q], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[169] + b.an[4] + this.var_int_q], this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[170] + b.an[4] + this.var_int_q], 20);
                    ++this.var_int_q;
                }
            }
        }
    }

    final void aq() {
        if (this.var_byte_b == 0 && !this.var_boolean_d && !this.var_boolean_g) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[2], (int)this.var_byte_arr_aI[this.var_short_arr_h[126] + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[127] + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[128] + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[129] + 0], 0, 0, this.var_int_m - this.var_byte_arr_aI[this.var_short_arr_h[129] + 0], 20);
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[2], (int)this.var_byte_arr_aI[this.var_short_arr_h[126] + 1], (int)this.var_byte_arr_aI[this.var_short_arr_h[127] + 1], (int)this.var_byte_arr_aI[this.var_short_arr_h[128] + 1], (int)this.var_byte_arr_aI[this.var_short_arr_h[129] + 1], 0, this.var_int_l - this.var_byte_arr_aI[this.var_short_arr_h[128] + 1], this.var_int_m - this.var_byte_arr_aI[this.var_short_arr_h[129] + 1], 20);
            return;
        }
        if (this.var_byte_b == 0 && this.var_boolean_d) {
            if (this.var_byte_aW != 2 && this.var_byte_B != 4) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[2], (int)this.var_byte_arr_aI[this.var_short_arr_h[126] + 4], (int)this.var_byte_arr_aI[this.var_short_arr_h[127] + 4], (int)this.var_byte_arr_aI[this.var_short_arr_h[128] + 4], (int)this.var_byte_arr_aI[this.var_short_arr_h[129] + 4], 0, 0, this.var_int_m - this.var_byte_arr_aI[this.var_short_arr_h[129] + 4], 20);
            }
        } else {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[2], (int)this.var_byte_arr_aI[this.var_short_arr_h[126] + 2], (int)this.var_byte_arr_aI[this.var_short_arr_h[127] + 2], (int)this.var_byte_arr_aI[this.var_short_arr_h[128] + 2], (int)this.var_byte_arr_aI[this.var_short_arr_h[129] + 2], 0, 0, this.var_int_m - this.var_byte_arr_aI[this.var_short_arr_h[129] + 2], 20);
        }
        if ((this.var_byte_b != 3 || this.var_byte_arr_aI[this.var_short_arr_h[143] + this.var_byte_R] != 0 && (this.var_byte_R != 5 || this.var_byte_aA != 18 && this.var_byte_aA != 19 && this.var_byte_aA != 38) || this.var_byte_R == 0) && this.var_byte_b != 5 && this.var_byte_b != 4) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[2], (int)this.var_byte_arr_aI[this.var_short_arr_h[126] + 3], (int)this.var_byte_arr_aI[this.var_short_arr_h[127] + 3], (int)this.var_byte_arr_aI[this.var_short_arr_h[128] + 3], (int)this.var_byte_arr_aI[this.var_short_arr_h[129] + 3], 0, this.var_int_l - this.var_byte_arr_aI[this.var_short_arr_h[128] + 3], this.var_int_m - this.var_byte_arr_aI[this.var_short_arr_h[129] + 3], 20);
        }
    }

    final void ar() {
        this.var_int_q = 0;
        while (this.var_int_q < 2) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[9], (int)this.var_byte_arr_aI[this.var_short_arr_h[13] + this.var_byte_g * 2 + this.var_int_q], (int)this.var_byte_arr_aI[this.var_short_arr_h[14] + this.var_byte_g * 2 + this.var_int_q], (int)this.var_byte_arr_aI[this.var_short_arr_h[15] + this.var_byte_g * 2 + this.var_int_q], (int)this.var_byte_arr_aI[this.var_short_arr_h[16] + this.var_byte_g * 2 + this.var_int_q], 0, this.var_int_l - this.var_byte_arr_aI[this.var_short_arr_h[15] + 0 + 0] - 2 + this.var_byte_arr_aI[this.var_short_arr_h[17] + this.var_byte_g * 2 + this.var_int_q], 2 + this.var_byte_arr_aI[this.var_short_arr_h[18] + this.var_byte_g * 2 + this.var_int_q], 20);
            ++this.var_int_q;
        }
    }

    final void as() {
        this.var_int_u = 0;
        while (this.var_int_u < b.Q[0]) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[6], 0, 112, 15, 12, 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[37] + 0 + this.var_int_u], this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[38] + 0 + this.var_int_u], 20);
            ++this.var_int_u;
        }
    }

    final void at() {
        this.var_int_u = 0;
        while (this.var_int_u < b.Q[1]) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[6], 0, 112, 15, 12, 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[37] + 3 + this.var_int_u], this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[38] + 3 + this.var_int_u], 20);
            ++this.var_int_u;
        }
        this.var_int_u = 0;
        while (this.var_int_u < b.V.length) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[2], (int)b.R[this.var_int_u], (int)b.S[this.var_int_u], (int)b.T[this.var_int_u], (int)b.U[this.var_int_u], 0, this.var_int_V + b.V[this.var_int_u], this.var_int_U + b.W[this.var_int_u], 20);
            ++this.var_int_u;
        }
    }

    final void au() {
        if (this.var_byte_an != 13) {
            this.var_int_ak = 22;
            this.aK();
            this.var_int_ak = 21;
            this.aK();
            return;
        }
        if (this.var_byte_an == 13) {
            this.var_int_ak = 2;
            this.aK();
            this.var_int_ak = 1;
            this.aK();
        }
    }

    final void av() {
        if (this.var_byte_an != 13) {
            this.var_int_ak = 23;
            this.aK();
            this.var_int_ak = 24;
            this.aK();
            return;
        }
        if (this.var_byte_an == 13) {
            this.var_int_ak = 18;
            this.aK();
            this.var_int_ak = 17;
            this.aK();
        }
    }

    final void aw() {
        this.var_int_ak = 21;
        this.aK();
        this.var_int_ak = 24;
        this.aK();
    }

    final void ax() {
        this.var_boolean_u = this.var_int_X == this.var_byte_O - 1 ? true : this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X + 1] != 0 && this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X + 1] != 6 && this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X + 1] != 8 && this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X + 1] != -17 && this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X + 1] != -19 && this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X + 1] != -22 && this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X + 1] != -20 && this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X + 1] != -23 && this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X + 1] != -24 && this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X + 1] != -25 && this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X + 1] != -26;
        if (this.var_boolean_u) {
            this.var_int_ak = 22;
            this.aK();
        }
        this.var_boolean_u = this.var_int_W == 0 ? true : this.var_byte_arr_arr_b[this.var_int_W - 1][this.var_int_X] != 0 && this.var_byte_arr_arr_b[this.var_int_W - 1][this.var_int_X] != 5 && this.var_byte_arr_arr_b[this.var_int_W - 1][this.var_int_X] != 7 && this.var_byte_arr_arr_b[this.var_int_W - 1][this.var_int_X] != -15 && this.var_byte_arr_arr_b[this.var_int_W - 1][this.var_int_X] != -16 && this.var_byte_arr_arr_b[this.var_int_W - 1][this.var_int_X] != -18 && this.var_byte_arr_arr_b[this.var_int_W - 1][this.var_int_X] != -21 && this.var_byte_arr_arr_b[this.var_int_W - 1][this.var_int_X] != -20 && this.var_byte_arr_arr_b[this.var_int_W - 1][this.var_int_X] != -24 && this.var_byte_arr_arr_b[this.var_int_W - 1][this.var_int_X] != -25 && this.var_byte_arr_arr_b[this.var_int_W - 1][this.var_int_X] != -26;
        if (this.var_boolean_u) {
            this.var_int_ak = 21;
            this.aK();
        }
    }

    final void a(boolean bl) {
        if ((this.var_byte_am & 0x40) != 0) {
            this.var_int_ak = 2;
            this.aK();
        }
        if ((this.var_byte_am & 4) != 0) {
            this.var_int_ak = 8;
            this.aK();
        }
        if ((this.var_byte_am & 0x80) != 0) {
            this.var_int_ak = 1;
            this.aK();
        }
        if ((this.var_byte_am & 8) != 0) {
            this.var_int_ak = 7;
            this.aK();
        }
        if ((this.var_byte_am & 0x4A) == 74) {
            this.var_int_ak = 15;
            this.aK();
        }
        if ((this.var_byte_am & 0x85) == 133) {
            this.var_int_ak = 16;
            this.aK();
        }
        this.ay();
    }

    final void ay() {
        if (this.var_byte_an == 9 && this.var_byte_ar == 23) {
            this.var_int_u = 0;
            while (this.var_int_u < 1) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[this.var_byte_arr_aI[this.var_short_arr_h[88] + 3 + this.var_int_u]], (int)this.var_byte_arr_aI[this.var_short_arr_h[80] + 3 + this.var_int_u], (int)this.var_byte_arr_aI[this.var_short_arr_h[81] + 3 + this.var_int_u], (int)this.var_byte_arr_aI[this.var_short_arr_h[82] + 3 + this.var_int_u], (int)this.var_byte_arr_aI[this.var_short_arr_h[83] + 3 + this.var_int_u], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[84] + 3 + this.var_int_u], this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[85] + 3 + this.var_int_u], 20);
                ++this.var_int_u;
            }
        }
        if (this.var_byte_an == 4 && this.var_byte_ar == 23) {
            this.var_int_u = 0;
            while (this.var_int_u < 1) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[this.var_byte_arr_aI[this.var_short_arr_h[88] + 6 + this.var_int_u]], (int)this.var_byte_arr_aI[this.var_short_arr_h[80] + 6 + this.var_int_u], (int)this.var_byte_arr_aI[this.var_short_arr_h[81] + 6 + this.var_int_u], (int)this.var_byte_arr_aI[this.var_short_arr_h[82] + 6 + this.var_int_u], (int)this.var_byte_arr_aI[this.var_short_arr_h[83] + 6 + this.var_int_u], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[84] + 6 + this.var_int_u + 3 * (this.var_int_W - this.var_byte_arr_aL[0])], this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[85] + 6 + this.var_int_u + 3 * (this.var_int_W - this.var_byte_arr_aL[0])], 20);
                ++this.var_int_u;
            }
            if (this.var_byte_b == 0) {
                this.var_int_u = 0;
                while (this.var_int_u < 2) {
                    this.var_int_v = this.var_short_arr_arr_c[this.var_int_W][this.var_int_X];
                    if (this.var_int_v < 0) {
                        return;
                    }
                    this.var_short_c = 0;
                    while (this.var_int_v >= 0) {
                        if (this.var_byte_arr_H[this.var_int_v] == this.var_int_u && this.var_byte_arr_W[this.var_int_v] == 12) {
                            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_a[this.var_byte_arr_A[this.var_int_v]], (int)this.var_byte_arr_aI[this.var_short_arr_h[21] + this.var_byte_arr_A[this.var_int_v] * 2 + 1], (int)this.var_byte_arr_aI[this.var_short_arr_h[42] + this.var_byte_arr_A[this.var_int_v]], (int)this.var_byte_arr_aI[this.var_short_arr_h[43] + this.var_byte_arr_A[this.var_int_v]], (int)this.var_byte_arr_aI[this.var_short_arr_h[44] + this.var_byte_arr_A[this.var_int_v]], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[27] + (this.var_int_W - this.var_byte_arr_aL[0]) * 4 + this.var_int_u] - this.var_byte_arr_aI[this.var_short_arr_h[43] + this.var_byte_arr_A[this.var_int_v]] / 2, this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[28] + (this.var_int_W - this.var_byte_arr_aL[0]) * 4 + this.var_int_u] - this.var_byte_arr_aI[this.var_short_arr_h[44] + this.var_byte_arr_A[this.var_int_v]], 20);
                            break;
                        }
                        this.var_int_v = this.var_short_arr_d[this.var_int_v];
                        this.var_short_c = (short)(this.var_short_c + 1);
                    }
                    ++this.var_int_u;
                }
            }
        }
    }

    final void az() {
        if (this.var_byte_an == 13) {
            this.var_boolean_u = false;
            if (this.var_int_X == this.var_byte_O - 1) {
                this.var_boolean_u = true;
            } else if (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X + 1] != 13) {
                this.var_boolean_u = true;
            }
            if (this.var_boolean_u) {
                this.var_int_ak = 2;
                this.aK();
            }
            this.aA();
        }
        if (this.var_byte_an == 0 && this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X] > 0) {
            if ((this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X] & 2) != 0) {
                this.var_int_ak = 19;
                this.aK();
            }
            if ((this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X] & 1) != 0) {
                this.var_int_ak = 20;
                this.aK();
            }
        }
    }

    final void aA() {
        this.var_boolean_u = false;
        if (this.var_int_W == 0) {
            this.var_boolean_u = true;
        } else if (this.var_byte_arr_arr_b[this.var_int_W - 1][this.var_int_X] != 13) {
            this.var_boolean_u = true;
        }
        if (this.var_boolean_u) {
            this.var_int_ak = 1;
            this.aK();
        }
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[5], 0, (b.B[1] - 1) * this.var_byte_aj, b.B[0] - 2, (int)b.B[1], 0, this.var_int_V + 0, this.var_int_U + -1, 20);
        if (this.var_int_X > 0 && this.var_short_arr_arr_c[this.var_int_W][this.var_int_X] == -1 && this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X - 1] == 6) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[1], 40, 0, 12, 9, 0, this.var_int_V + (this.var_byte_arr_arr_o[22][this.var_short_arr_arr_g[22][21] + 33 + this.var_byte_arr_as[22]] + this.var_byte_arr_arr_o[22][this.var_short_arr_arr_g[22][22] + 33 + this.var_byte_arr_as[22]]) / b.Y[0] + -6, this.var_int_U + b.B[1] / 2 + (this.var_byte_arr_arr_o[22][this.var_short_arr_arr_g[22][21] + 33 + this.var_byte_arr_as[22]] - this.var_byte_arr_arr_o[22][this.var_short_arr_arr_g[22][22] + 33 + this.var_byte_arr_as[22]]) / b.Y[1] + -11, 20);
        }
        if (this.var_int_W < this.var_byte_O - 1 && this.var_short_arr_arr_c[this.var_int_W][this.var_int_X] == -1 && this.var_byte_arr_arr_b[this.var_int_W + 1][this.var_int_X] == 5) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[1], 40, 0, 12, 9, 0, this.var_int_V + (this.var_byte_arr_arr_o[22][this.var_short_arr_arr_g[22][21] + 22 + this.var_byte_arr_as[22]] + this.var_byte_arr_arr_o[22][this.var_short_arr_arr_g[22][22] + 22 + this.var_byte_arr_as[22]]) / b.Y[0] + -6, this.var_int_U + b.B[1] / 2 + (this.var_byte_arr_arr_o[22][this.var_short_arr_arr_g[22][21] + 22 + this.var_byte_arr_as[22]] - this.var_byte_arr_arr_o[22][this.var_short_arr_arr_g[22][22] + 22 + this.var_byte_arr_as[22]]) / b.Y[1] + -11, 20);
        }
    }

    final void aB() {
        if (this.var_byte_an == 13) {
            this.var_boolean_u = false;
            if (this.var_int_X == 0) {
                this.var_boolean_u = true;
            } else if (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X - 1] != 13) {
                this.var_boolean_u = true;
            }
            if (this.var_boolean_u) {
                this.var_int_ak = 18;
                this.aK();
            }
            this.var_boolean_u = false;
            if (this.var_int_W == this.var_byte_O - 1) {
                this.var_boolean_u = true;
            } else if (this.var_byte_arr_arr_b[this.var_int_W + 1][this.var_int_X] != 13) {
                this.var_boolean_u = true;
            }
            if (this.var_boolean_u) {
                this.var_int_ak = 17;
                this.aK();
            }
        }
    }

    final void aC() {
        if (this.var_int_X != 0 || this.var_int_W != this.var_byte_ab) {
            this.var_boolean_u = this.var_int_X == 0 ? true : this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X - 1] != 0;
            if (this.var_boolean_u) {
                this.var_int_ak = 23;
                this.aK();
            }
        }
        this.var_boolean_u = this.var_int_W == this.var_byte_O - 1 ? true : this.var_byte_arr_arr_b[this.var_int_W + 1][this.var_int_X] != 0;
        if (this.var_boolean_u) {
            this.var_int_ak = 24;
            this.aK();
        }
    }

    final void b(boolean bl) {
        if (this.var_byte_an == 4 && this.var_byte_ar == 23) {
            this.var_int_u = 0;
            while (this.var_int_u < 2) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[this.var_byte_arr_aI[this.var_short_arr_h[88] + 4 + this.var_int_u]], (int)this.var_byte_arr_aI[this.var_short_arr_h[80] + 4 + this.var_int_u], (int)this.var_byte_arr_aI[this.var_short_arr_h[81] + 4 + this.var_int_u], (int)this.var_byte_arr_aI[this.var_short_arr_h[82] + 4 + this.var_int_u], (int)this.var_byte_arr_aI[this.var_short_arr_h[83] + 4 + this.var_int_u], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[84] + 4 + this.var_int_u + 3 * (this.var_int_W - this.var_byte_arr_aL[0])], this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[85] + 4 + this.var_int_u + 3 * (this.var_int_W - this.var_byte_arr_aL[0])], 20);
                ++this.var_int_u;
            }
            if (this.var_byte_b == 0) {
                this.var_int_u = 2;
                while (this.var_int_u < 4) {
                    this.var_int_v = this.var_short_arr_arr_c[this.var_int_W][this.var_int_X];
                    if (this.var_int_v < 0) break;
                    this.var_short_c = 0;
                    while (this.var_int_v >= 0) {
                        if (this.var_byte_arr_H[this.var_int_v] == this.var_int_u && this.var_byte_arr_W[this.var_int_v] == 12) {
                            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_a[this.var_byte_arr_A[this.var_int_v]], (int)this.var_byte_arr_aI[this.var_short_arr_h[1] + this.var_byte_arr_A[this.var_int_v] * 12 + this.var_byte_arr_F[this.var_int_v] * 3 + this.var_byte_arr_K[this.var_byte_arr_J[this.var_int_v]]], (int)this.var_byte_arr_aI[this.var_short_arr_h[19] + this.var_byte_arr_A[this.var_int_v] * 4 + this.var_byte_arr_F[this.var_int_v]], (int)this.var_byte_arr_aI[this.var_short_arr_h[2] + this.var_byte_arr_A[this.var_int_v] * 12 + this.var_byte_arr_F[this.var_int_v] * 3 + this.var_byte_arr_K[this.var_byte_arr_J[this.var_int_v]]], this.var_byte_arr_aI[this.var_short_arr_h[20] + this.var_byte_arr_A[this.var_int_v] * 4 + this.var_byte_arr_F[this.var_int_v]] - 7, 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[27] + (this.var_int_W - this.var_byte_arr_aL[0]) * 4 + this.var_int_u] - this.var_byte_arr_aI[this.var_short_arr_h[2] + this.var_byte_arr_A[this.var_int_v] * 12 + this.var_byte_arr_F[this.var_int_v] * 3 + this.var_byte_arr_K[this.var_byte_arr_J[this.var_int_v]]] / 2, this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[28] + (this.var_int_W - this.var_byte_arr_aL[0]) * 4 + this.var_int_u] - this.var_byte_arr_aI[this.var_short_arr_h[20] + this.var_byte_arr_A[this.var_int_v] * 4 + this.var_byte_arr_F[this.var_int_v]], 20);
                            break;
                        }
                        this.var_int_v = this.var_short_arr_d[this.var_int_v];
                        this.var_short_c = (short)(this.var_short_c + 1);
                    }
                    ++this.var_int_u;
                }
            }
        }
        if ((this.var_byte_am & 0x10) != 0) {
            this.var_int_ak = 18;
            this.aK();
        }
        this.c(bl);
    }

    final void c(boolean bl) {
        if ((this.var_byte_am & 1) != 0) {
            this.var_int_ak = 10;
            this.aK();
        }
        if ((this.var_byte_am & 0x20) != 0) {
            this.var_int_ak = 17;
            this.aK();
        }
        if ((this.var_byte_am & 2) != 0) {
            this.var_int_ak = 9;
            this.aK();
        }
        if (this.var_byte_an == 5) {
            this.var_int_ak = 3;
            this.aK();
        }
        if (this.var_byte_an == 6) {
            this.var_int_ak = 4;
            this.aK();
        }
        if (this.var_byte_ao == 1) {
            this.var_int_ak = 6;
            this.aK();
        }
        if (this.var_byte_ap == 1) {
            this.var_int_ak = 5;
            this.aK();
        }
    }

    final void aD() {
        this.aE();
        this.aF();
        if (this.var_int_W - this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][36] + 0 + 0] == this.var_byte_arr_aM[0] && this.var_int_X - this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][36] + 0 + 1] == this.var_byte_arr_aM[1]) {
            this.var_int_u = 0;
            while (this.var_int_u < this.var_byte_arr_aq[this.var_byte_ar]) {
                if (!(this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][4] + 2] == 0 && this.var_int_u % 2 != 0 || this.var_int_U + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][20] + this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] * (this.var_byte_arr_aq[this.var_byte_ar] + 1) * 2 + this.var_int_u * 2 + 1] >= this.var_int_m && this.var_int_U + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][20] + this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] * (this.var_byte_arr_aq[this.var_byte_ar] + 1) * 2 + this.var_int_u * 2 + 3] >= this.var_int_m)) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(b.var_int_arr_arr_b[this.var_byte_ar][this.var_int_u]);
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawLine(this.var_int_V + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][20] + this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] * (this.var_byte_arr_aq[this.var_byte_ar] + 1) * 2 + this.var_int_u * 2], this.var_int_U + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][20] + this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] * (this.var_byte_arr_aq[this.var_byte_ar] + 1) * 2 + this.var_int_u * 2 + 1], this.var_int_V + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][20] + this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] * (this.var_byte_arr_aq[this.var_byte_ar] + 1) * 2 + this.var_int_u * 2 + 2], this.var_int_U + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][20] + this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] * (this.var_byte_arr_aq[this.var_byte_ar] + 1) * 2 + this.var_int_u * 2 + 3]);
                }
                ++this.var_int_u;
            }
        }
        this.var_int_w = 0;
        this.var_int_u = 0;
        while (this.var_int_u < this.var_byte_arr_ar[this.var_byte_ar]) {
            if (this.var_int_u > 0) {
                this.var_int_w += this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][1] + (this.var_int_u - 1) * 2 + 1] - this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][1] + (this.var_int_u - 1) * 2 + 0] + 1;
            }
            if (this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] >= this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][1] + this.var_int_u * 2 + 0] && this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] <= this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][1] + this.var_int_u * 2 + 1]) {
                this.var_byte_arr_aY[0] = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][30] + this.var_int_w + this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] - this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][1] + this.var_int_u * 2 + 0]];
                this.var_byte_arr_aY[1] = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][31] + this.var_int_w + this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] - this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][1] + this.var_int_u * 2 + 0]];
                if (this.var_int_U + this.var_byte_arr_aY[1] < this.var_int_m && this.var_int_V + this.var_byte_arr_aY[0] + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][27] + this.var_int_u] > 0 && this.var_int_V + this.var_byte_arr_aY[0] < this.var_int_l) {
                    this.var_boolean_u = false;
                    this.var_int_v = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][3] + 3] == 1 ? 0 : this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar];
                    if (this.var_int_W == this.var_byte_arr_aM[0] + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][36] + this.var_int_v * 2 + 0] && this.var_int_X == this.var_byte_arr_aM[1] + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][36] + this.var_int_v * 2 + 1]) {
                        this.var_boolean_u = true;
                    }
                    if (this.var_boolean_u) {
                        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][29] + this.var_int_u]], (int)this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][25] + this.var_int_u], (int)this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][26] + this.var_int_u], (int)this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][27] + this.var_int_u], (int)this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][28] + this.var_int_u], 0, this.var_int_V + this.var_byte_arr_aY[0], this.var_int_U + this.var_byte_arr_aY[1], 20);
                    }
                }
            }
            ++this.var_int_u;
        }
    }

    final void aE() {
        this.var_int_aj = (this.var_int_W - this.var_byte_arr_aL[0]) * (this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 1] - 1) + this.var_int_X - this.var_byte_arr_aL[1] - 1;
        this.var_int_ah = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][33] + this.var_int_aj];
        this.var_int_ai = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][33] + this.var_int_aj + 1];
        this.var_int_aj = this.var_int_ah;
        while (this.var_int_aj < this.var_int_ai) {
            this.var_int_u = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][32] + this.var_int_aj];
            if (this.var_int_U + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][10] + this.var_int_u] < this.var_int_m && this.var_int_V + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][9] + this.var_int_u] + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][7] + this.var_int_u] > 0 && this.var_int_V + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][9] + this.var_int_u] < this.var_int_l) {
                this.var_boolean_u = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][4] + 1] == 1 ? true : this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][40] + this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] * this.var_byte_arr_an[this.var_byte_ar] + this.var_int_u] == 1;
                if (this.var_boolean_u) {
                    this.var_int_v = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][11] + this.var_int_u] == 5 ? (b.B[1] - 1) * this.var_byte_aj : 0;
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][11] + this.var_int_u]], (int)this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][5] + this.var_int_u], this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][6] + this.var_int_u] + this.var_int_v, (int)this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][7] + this.var_int_u], (int)this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][8] + this.var_int_u], 0, this.var_int_V + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][9] + this.var_int_u], this.var_int_U + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][10] + this.var_int_u], 20);
                }
            }
            ++this.var_int_aj;
        }
        if (this.var_int_W - this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][36] + 0 + 0] == this.var_byte_arr_aM[0] && this.var_int_X - this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][36] + 0 + 1] == this.var_byte_arr_aM[1]) {
            this.var_int_u = 0;
            while (this.var_int_u < this.var_byte_arr_ao[this.var_byte_ar]) {
                if (this.var_int_U + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][19] + this.var_int_u * 4 + 1] < this.var_int_m || this.var_int_U + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][19] + this.var_int_u * 4 + 3] < this.var_int_m) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(b.var_int_arr_arr_a[this.var_byte_ar][this.var_int_u]);
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawLine(this.var_int_V + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][19] + this.var_int_u * 4 + 0], this.var_int_U + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][19] + this.var_int_u * 4 + 1], this.var_int_V + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][19] + this.var_int_u * 4 + 2], this.var_int_U + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][19] + this.var_int_u * 4 + 3]);
                }
                ++this.var_int_u;
            }
        }
    }

    final void aF() {
        this.var_int_u = 0;
        while (this.var_int_u < this.var_byte_arr_ap[this.var_byte_ar]) {
            this.var_byte_arr_aY[0] = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][2] + 0] == 1 ? this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][17] + this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] * this.var_byte_arr_ap[this.var_byte_ar] + this.var_int_u] : this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][17] + 0 * this.var_byte_arr_ap[this.var_byte_ar] + this.var_int_u];
            this.var_byte_arr_aY[1] = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][2] + 1] == 1 ? this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][18] + this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] * this.var_byte_arr_ap[this.var_byte_ar] + this.var_int_u] : this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][18] + 0 * this.var_byte_arr_ap[this.var_byte_ar] + this.var_int_u];
            if (this.var_int_U + this.var_byte_arr_aY[1] < this.var_int_m && this.var_int_V + this.var_byte_arr_aY[0] + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][14] + this.var_int_u] > 0 && this.var_int_V + this.var_byte_arr_aY[0] < this.var_int_l) {
                this.var_boolean_u = false;
                this.var_int_v = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][3] + 1] == 1 ? 0 : this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar];
                if (this.var_int_W == this.var_byte_arr_aM[0] + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][34] + this.var_int_v * 2 + 0] && this.var_int_X == this.var_byte_arr_aM[1] + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][34] + this.var_int_v * 2 + 1]) {
                    this.var_boolean_u = true;
                }
                if (!this.var_boolean_u) break;
                this.var_boolean_u = this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][4] + 1] == 1 ? true : this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][41] + this.var_byte_as % this.var_byte_arr_at[this.var_byte_ar] * this.var_byte_arr_ap[this.var_byte_ar] + this.var_int_u] == 1;
                if (this.var_boolean_u) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][16] + this.var_int_u]], (int)this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][12] + this.var_int_u], (int)this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][13] + this.var_int_u], (int)this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][14] + this.var_int_u], (int)this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][15] + this.var_int_u], 0, this.var_int_V + this.var_byte_arr_aY[0], this.var_int_U + this.var_byte_arr_aY[1], 20);
                }
            }
            ++this.var_int_u;
        }
    }

    final void aG() {
        this.var_int_v = -1 - this.var_byte_an;
        this.var_int_w = this.var_byte_arr_aH[this.var_int_v] > 0 && this.var_byte_b == 0 ? (this.var_byte_aq & 0xFF) % this.var_byte_arr_aH[this.var_int_v] : 0;
        this.var_int_u = 0;
        while (this.var_int_u < this.var_byte_arr_aF[this.var_int_v]) {
            if (this.var_int_U + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][5] + this.var_int_u] < this.var_int_m && this.var_int_V + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][4] + this.var_int_u] + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][2] + this.var_int_u] > 0 && this.var_int_V + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][4] + this.var_int_u] < this.var_int_l) {
                this.var_boolean_u = this.var_byte_an > -15 ? true : (this.var_byte_arr_aH[this.var_int_v] == 0 || !this.var_boolean_q && this.var_boolean_r ? true : this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][14] + this.var_int_w * this.var_byte_arr_aF[this.var_int_v] + this.var_int_u] == 1);
                if (this.var_boolean_u) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][6] + this.var_int_u]], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][0] + this.var_int_u], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][1] + this.var_int_u], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][2] + this.var_int_u], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][3] + this.var_int_u], 0, this.var_int_V + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][4] + this.var_int_u], this.var_int_U + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][5] + this.var_int_u], 20);
                }
            }
            ++this.var_int_u;
        }
    }

    final void aH() {
        if (this.var_byte_an < 0 && this.var_byte_an >= -27) {
            this.aG();
            if (this.var_byte_an > -15) {
                return;
            }
            if (this.var_boolean_q && !this.var_boolean_r && this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][2] + this.var_byte_arr_aF[this.var_int_v]] > 0) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][6] + this.var_byte_arr_aF[this.var_int_v]]], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][0] + this.var_byte_arr_aF[this.var_int_v]], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][1] + this.var_byte_arr_aF[this.var_int_v]], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][2] + this.var_byte_arr_aF[this.var_int_v]], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][3] + this.var_byte_arr_aF[this.var_int_v]], 0, this.var_int_V + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][4] + this.var_byte_arr_aF[this.var_int_v]], this.var_int_U + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][5] + this.var_byte_arr_aF[this.var_int_v]], 20);
            } else if (!this.var_boolean_q && this.var_boolean_r && this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][2] + this.var_byte_arr_aF[this.var_int_v] + 1] > 0) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][6] + this.var_byte_arr_aF[this.var_int_v] + 1]], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][0] + this.var_byte_arr_aF[this.var_int_v] + 1], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][1] + this.var_byte_arr_aF[this.var_int_v] + 1], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][2] + this.var_byte_arr_aF[this.var_int_v] + 1], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][3] + this.var_byte_arr_aF[this.var_int_v] + 1], 0, this.var_int_V + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][4] + this.var_byte_arr_aF[this.var_int_v] + 1], this.var_int_U + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][5] + this.var_byte_arr_aF[this.var_int_v] + 1], 20);
            }
            if (this.var_boolean_q && this.var_boolean_r || this.var_byte_b != 0 && this.var_byte_aV == 26) {
                this.var_int_u = 0;
                while (this.var_int_u < this.var_byte_arr_aG[this.var_int_v]) {
                    if (this.var_int_U + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][13] + this.var_int_w * this.var_byte_arr_aG[this.var_int_v] + this.var_int_u] < this.var_int_m && this.var_int_V + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][12] + this.var_int_w * this.var_byte_arr_aG[this.var_int_v] + this.var_int_u] + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][9] + this.var_int_u] > 0 && this.var_int_V + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][12] + this.var_int_w * this.var_byte_arr_aG[this.var_int_v] + this.var_int_u] < this.var_int_l) {
                        this.var_boolean_u = this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][15] + this.var_int_w * this.var_byte_arr_aG[this.var_int_v] + this.var_int_u] == 1;
                        if (this.var_boolean_u) {
                            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][11] + this.var_int_u]], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][7] + this.var_int_u], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][8] + this.var_int_u], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][9] + this.var_int_u], (int)this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][10] + this.var_int_u], 0, this.var_int_V + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][12] + this.var_int_w * this.var_byte_arr_aG[this.var_int_v] + this.var_int_u], this.var_int_U + this.var_byte_arr_arr_p[this.var_int_v][this.var_short_arr_arr_h[this.var_int_v][13] + this.var_int_w * this.var_byte_arr_aG[this.var_int_v] + this.var_int_u], 20);
                        }
                    }
                    ++this.var_int_u;
                }
            }
        }
    }

    final void aI() {
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[2], (int)this.var_byte_arr_aI[this.var_short_arr_h[59] + this.var_int_ak], (int)this.var_byte_arr_aI[this.var_short_arr_h[60] + this.var_int_ak], (int)this.var_byte_arr_aI[this.var_short_arr_h[61] + this.var_int_ak], (int)this.var_byte_arr_aI[this.var_short_arr_h[62] + this.var_int_ak], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[63] + this.var_int_ak], this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[64] + this.var_int_ak], 20);
    }

    final void aJ() {
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[2], (int)this.var_byte_arr_aI[this.var_short_arr_h[65] + this.var_int_ak], (int)this.var_byte_arr_aI[this.var_short_arr_h[66] + this.var_int_ak], (int)this.var_byte_arr_aI[this.var_short_arr_h[67] + this.var_int_ak], (int)this.var_byte_arr_aI[this.var_short_arr_h[68] + this.var_int_ak], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[69] + this.var_int_al], this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[70] + this.var_int_al], 20);
    }

    final void aK() {
        this.var_int_am = this.var_int_ak == 19 && this.var_byte_b != 0 ? b.B[0] / 4 : 0;
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[2], (int)this.var_byte_arr_aI[this.var_short_arr_h[59] + this.var_int_ak], (int)this.var_byte_arr_aI[this.var_short_arr_h[60] + this.var_int_ak], (int)this.var_byte_arr_aI[this.var_short_arr_h[61] + this.var_int_ak], (int)this.var_byte_arr_aI[this.var_short_arr_h[62] + this.var_int_ak], 0, this.var_int_V + this.var_byte_arr_aI[this.var_short_arr_h[63] + this.var_int_ak] + this.var_int_am, this.var_int_U + this.var_byte_arr_aI[this.var_short_arr_h[64] + this.var_int_ak], 20);
    }

    final void aL() {
        try {
            this.var_int_v = this.var_short_arr_arr_c[this.var_int_W][this.var_int_X];
            if (this.var_int_v < 0) {
                return;
            }
            if (this.var_byte_arr_arr_b[this.var_int_W][this.var_int_X] == 10 && this.var_byte_arr_ag[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] == 4) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_a[9], (int)b.af[this.var_byte_arr_af[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] % 2], (int)b.ag[this.var_byte_arr_af[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] % 2], (int)b.ah[this.var_byte_arr_af[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] % 2], (int)b.ai[this.var_byte_arr_af[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] % 2], 0, this.var_int_V + this.var_byte_arr_aB[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]] - b.ah[this.var_byte_arr_af[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] % 2], this.var_int_U + this.var_byte_arr_aC[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]] - b.ai[this.var_byte_arr_af[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] % 2], 20);
                return;
            }
            this.aM();
            if (this.var_short_c == 0) {
                return;
            }
            this.aN();
            this.var_int_u = 0;
            while (this.var_int_u < this.var_short_c) {
                if (this.var_byte_arr_W[this.var_short_arr_arr_d[0][this.var_int_u]] == 15) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[2], (int)b.aa[this.var_byte_arr_J[this.var_short_arr_arr_d[0][this.var_int_u]] % 2], (int)b.ab[this.var_byte_arr_J[this.var_short_arr_arr_d[0][this.var_int_u]] % 2], (int)b.ac[this.var_byte_arr_J[this.var_short_arr_arr_d[0][this.var_int_u]] % 2], (int)b.ad[this.var_byte_arr_J[this.var_short_arr_arr_d[0][this.var_int_u]] % 2], 0, this.var_int_V + b.B[0] / 2 - b.ac[this.var_byte_arr_J[this.var_short_arr_arr_d[0][this.var_int_u]] % 2] / 2 + this.var_byte_arr_arr_h[0][this.var_short_arr_arr_d[0][this.var_int_u]], this.var_int_U + this.var_short_arr_arr_d[1][this.var_int_u] - b.ad[this.var_byte_arr_J[this.var_short_arr_arr_d[0][this.var_int_u]] % 2] + b.ae[this.var_byte_arr_J[this.var_short_arr_arr_d[0][this.var_int_u]] % 2], 20);
                } else {
                    this.aO();
                    if (this.var_int_V + this.var_int_v > -b.B[0] / 2 && this.var_int_V + this.var_int_v < this.var_int_l + b.B[0] / 4) {
                        this.aP();
                        if (this.var_byte_arr_W[this.var_short_arr_arr_d[0][this.var_int_u]] == 10) {
                            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[1], 40, 0, 12, 8, 0, this.var_int_V + this.var_int_v + -6, this.var_int_U + this.var_short_arr_arr_d[1][this.var_int_u] + -11, 20);
                        }
                        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_a[this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]]], (int)this.var_byte_arr_aY[2], (int)this.var_byte_arr_aY[3], (int)this.var_byte_arr_aY[4], this.var_byte_arr_aY[5] - this.var_byte_aS, 0, this.var_int_V + this.var_int_v - this.var_byte_aT, this.var_int_U + this.var_short_arr_arr_d[1][this.var_int_u] - this.var_byte_aU, 20);
                        this.aQ();
                    }
                }
                ++this.var_int_u;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void aM() {
        this.var_short_c = 0;
        while (this.var_int_v >= 0) {
            if (!(this.var_byte_arr_W[this.var_int_v] > -1 && this.var_byte_arr_W[this.var_int_v] < 7 && this.var_byte_arr_arr_h[0][this.var_int_v] == 1 && this.var_byte_arr_aI[this.var_short_arr_h[this.var_byte_arr_arr_q[1][0]] + this.var_byte_arr_W[this.var_int_v] * 4] == 2 || this.var_byte_arr_W[this.var_int_v] == 12 || this.var_byte_arr_W[this.var_int_v] == 16 || this.var_byte_arr_W[this.var_int_v] == 13 && this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]][4] + 0] == 0)) {
                this.var_short_arr_arr_d[0][this.var_short_c] = (short)this.var_int_v;
                this.var_short_arr_arr_d[1][this.var_short_c] = this.var_byte_arr_W[this.var_int_v] == 13 ? (short)this.var_byte_arr_H[this.var_int_v] : (this.var_byte_arr_W[this.var_int_v] == 15 ? (short)(b.B[1] / 2 + this.var_byte_arr_arr_h[1][this.var_int_v]) : (short)(b.B[1] / 2 + (this.var_byte_arr_G[this.var_int_v] - this.var_byte_arr_H[this.var_int_v]) / b.Y[1]));
                if (this.var_int_U + this.var_short_arr_arr_d[1][this.var_short_c] > 0 && this.var_int_U + this.var_short_arr_arr_d[1][this.var_short_c] <= this.var_int_m + b.B[1]) {
                    this.var_short_c = (short)(this.var_short_c + 1);
                }
            }
            this.var_int_v = this.var_short_arr_d[this.var_int_v];
        }
    }

    final void aN() {
        this.var_int_u = 0;
        while (this.var_int_u < this.var_short_c - 1) {
            this.var_int_v = this.var_int_u + 1;
            while (this.var_int_v < this.var_short_c) {
                if (this.var_short_arr_arr_d[1][this.var_int_u] > this.var_short_arr_arr_d[1][this.var_int_v]) {
                    this.var_short_d = this.var_short_arr_arr_d[0][this.var_int_u];
                    this.var_short_arr_arr_d[0][this.var_int_u] = this.var_short_arr_arr_d[0][this.var_int_v];
                    this.var_short_arr_arr_d[0][this.var_int_v] = this.var_short_d;
                    this.var_short_d = this.var_short_arr_arr_d[1][this.var_int_u];
                    this.var_short_arr_arr_d[1][this.var_int_u] = this.var_short_arr_arr_d[1][this.var_int_v];
                    this.var_short_arr_arr_d[1][this.var_int_v] = this.var_short_d;
                }
                ++this.var_int_v;
            }
            ++this.var_int_u;
        }
    }

    final void aO() {
        this.var_int_w = this.var_byte_arr_W[this.var_short_arr_arr_d[0][this.var_int_u]] == -1 || this.var_byte_arr_W[this.var_short_arr_arr_d[0][this.var_int_u]] >= 9 ? this.var_byte_arr_F[this.var_short_arr_arr_d[0][this.var_int_u]] : this.var_byte_arr_X[this.var_short_arr_arr_d[0][this.var_int_u]];
        this.var_byte_aS = 0;
        this.var_byte_aT = 0;
        this.var_byte_aU = 0;
        if (this.var_byte_arr_W[this.var_short_arr_arr_d[0][this.var_int_u]] == 13) {
            this.var_byte_arr_aY[5] = this.var_byte_arr_J[this.var_short_arr_arr_d[0][this.var_int_u]];
            if (this.var_short_arr_c[this.var_short_arr_arr_d[0][this.var_int_u]] % this.var_byte_arr_at[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]] >= this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]][39] + 0] && this.var_short_arr_c[this.var_short_arr_arr_d[0][this.var_int_u]] % this.var_byte_arr_at[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]] <= this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]][39] + 1]) {
                this.var_byte_aS = this.var_byte_arr_ax[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]]];
            }
            if (this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] == 14) {
                this.var_byte_aU = (byte)(this.var_byte_aU - this.var_byte_arr_aI[this.var_short_arr_h[20] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 4 + 0]);
            }
            this.var_int_v = this.var_byte_arr_G[this.var_short_arr_arr_d[0][this.var_int_u]];
            return;
        }
        if (this.var_byte_arr_W[this.var_short_arr_arr_d[0][this.var_int_u]] == 1 && this.var_byte_arr_arr_h[0][this.var_short_arr_arr_d[0][this.var_int_u]] == 1) {
            this.var_int_w = 4;
            this.var_byte_arr_aY[5] = this.var_byte_arr_arr_h[2][this.var_short_arr_arr_d[0][this.var_int_u]];
        } else {
            this.var_byte_arr_aY[5] = this.var_byte_arr_K[this.var_byte_arr_J[this.var_short_arr_arr_d[0][this.var_int_u]]];
        }
        if (this.var_byte_arr_W[this.var_short_arr_arr_d[0][this.var_int_u]] == 10) {
            this.var_byte_aS = (byte)7;
        }
        this.var_int_v = (this.var_byte_arr_G[this.var_short_arr_arr_d[0][this.var_int_u]] + this.var_byte_arr_H[this.var_short_arr_arr_d[0][this.var_int_u]]) / b.Y[0];
    }

    final void aP() {
        if (this.var_int_w < 4) {
            this.var_byte_arr_aY[2] = this.var_byte_arr_aI[this.var_short_arr_h[1] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 12 + this.var_int_w * 3 + this.var_byte_arr_aY[5]];
            this.var_byte_arr_aY[4] = this.var_byte_arr_aI[this.var_short_arr_h[2] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 12 + this.var_int_w * 3 + this.var_byte_arr_aY[5]];
            this.var_byte_arr_aY[3] = this.var_byte_arr_aI[this.var_short_arr_h[19] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 4 + this.var_int_w];
            this.var_byte_arr_aY[5] = this.var_byte_arr_aI[this.var_short_arr_h[20] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 4 + this.var_int_w];
        } else if (this.var_int_w == 4) {
            this.var_byte_arr_aY[2] = this.var_byte_arr_aI[this.var_short_arr_h[21] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 2 + this.var_byte_arr_aY[5]];
            this.var_byte_arr_aY[4] = this.var_byte_arr_aI[this.var_short_arr_h[43] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]]];
            this.var_byte_arr_aY[3] = this.var_byte_arr_aI[this.var_short_arr_h[42] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]]];
            this.var_byte_arr_aY[5] = this.var_byte_arr_aI[this.var_short_arr_h[44] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]]];
        } else if (this.var_int_w == 5) {
            if (this.var_byte_arr_aY[5] == 0) {
                this.var_byte_aU = this.var_byte_arr_aI[this.var_short_arr_h[25] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 3 + this.var_byte_arr_aY[5]];
            }
            this.var_byte_arr_aY[2] = this.var_byte_arr_aI[this.var_short_arr_h[22] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 3 + this.var_byte_arr_aY[5]];
            this.var_byte_arr_aY[4] = this.var_byte_arr_aI[this.var_short_arr_h[24] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 3 + this.var_byte_arr_aY[5]];
            this.var_byte_arr_aY[3] = this.var_byte_arr_aI[this.var_short_arr_h[23] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 3 + this.var_byte_arr_aY[5]];
            this.var_byte_arr_aY[5] = this.var_byte_arr_aI[this.var_short_arr_h[25] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 3 + this.var_byte_arr_aY[5]];
        } else if (this.var_int_w == 6) {
            this.var_byte_arr_aY[2] = this.var_byte_arr_aI[this.var_short_arr_h[45] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]]];
            this.var_byte_arr_aY[4] = this.var_byte_arr_aI[this.var_short_arr_h[47] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]]];
            this.var_byte_arr_aY[3] = this.var_byte_arr_aI[this.var_short_arr_h[46] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]]];
            this.var_byte_arr_aY[5] = this.var_byte_arr_aI[this.var_short_arr_h[48] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]]];
        } else if (this.var_int_w == 7) {
            this.var_byte_aT = (byte)(this.var_byte_aT + this.var_byte_arr_aI[this.var_short_arr_h[3] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 28 + this.var_byte_arr_aY[5] * 4 + 2] / 2 * this.var_byte_arr_aI[this.var_short_arr_h[26] + this.var_byte_arr_aY[5] * 2 + 0]);
            this.var_byte_aU = (byte)(this.var_byte_aU + this.var_byte_arr_aI[this.var_short_arr_h[3] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 28 + this.var_byte_arr_aY[5] * 4 + 3] / 2 * this.var_byte_arr_aI[this.var_short_arr_h[26] + this.var_byte_arr_aY[5] * 2 + 1]);
            this.var_byte_arr_aY[2] = this.var_byte_arr_aI[this.var_short_arr_h[3] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 28 + this.var_byte_arr_aY[5] * 4 + 0];
            this.var_byte_arr_aY[4] = this.var_byte_arr_aI[this.var_short_arr_h[3] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 28 + this.var_byte_arr_aY[5] * 4 + 2];
            this.var_byte_arr_aY[3] = this.var_byte_arr_aI[this.var_short_arr_h[3] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 28 + this.var_byte_arr_aY[5] * 4 + 1];
            this.var_byte_arr_aY[5] = this.var_byte_arr_aI[this.var_short_arr_h[3] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 28 + this.var_byte_arr_aY[5] * 4 + 3];
        }
        if (this.var_int_w != 5 && this.var_int_w != 7) {
            this.var_byte_aT = (byte)(this.var_byte_aT + this.var_byte_arr_aY[4] / 2);
            this.var_byte_aU = (byte)(this.var_byte_aU + this.var_byte_arr_aY[5]);
        }
    }

    final void aQ() {
        if (this.var_byte_arr_W[this.var_short_arr_arr_d[0][this.var_int_u]] == 13) {
            if (this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] == 0) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[this.var_byte_arr_aI[this.var_short_arr_h[75] + 0]], (int)this.var_byte_arr_aI[this.var_short_arr_h[75] + 1], (int)this.var_byte_arr_aI[this.var_short_arr_h[75] + 2], (int)this.var_byte_arr_aI[this.var_short_arr_h[75] + 3], (int)this.var_byte_arr_aI[this.var_short_arr_h[75] + 4], 0, this.var_int_V + this.var_int_v + this.var_byte_arr_aI[this.var_short_arr_h[75] + 5], this.var_int_U + this.var_short_arr_arr_d[1][this.var_int_u] + this.var_byte_arr_aI[this.var_short_arr_h[75] + 6], 20);
            }
            if (this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] == 14 || this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_W][this.var_int_X]] == 16 && this.var_short_arr_c[this.var_short_arr_arr_d[0][this.var_int_u]] >= this.var_byte_arr_aI[this.var_short_arr_h[76] + 0] && this.var_short_arr_c[this.var_short_arr_arr_d[0][this.var_int_u]] <= this.var_byte_arr_aI[this.var_short_arr_h[76] + 1]) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_a[this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]]], (int)this.var_byte_arr_aI[this.var_short_arr_h[0] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 24 + this.var_int_w * 6 + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[0] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 24 + this.var_int_w * 6 + 1], (int)this.var_byte_arr_aI[this.var_short_arr_h[0] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 24 + this.var_int_w * 6 + 2], (int)this.var_byte_arr_aI[this.var_short_arr_h[0] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 24 + this.var_int_w * 6 + 3], 0, this.var_int_V + this.var_int_v - this.var_byte_aT + this.var_byte_arr_aI[this.var_short_arr_h[0] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 24 + this.var_int_w * 6 + 4], this.var_int_U + this.var_short_arr_arr_d[1][this.var_int_u] - this.var_byte_aU + this.var_byte_arr_aI[this.var_short_arr_h[0] + this.var_byte_arr_A[this.var_short_arr_arr_d[0][this.var_int_u]] * 24 + this.var_int_w * 6 + 5], 20);
                return;
            }
        } else if (this.var_short_arr_arr_d[0][this.var_int_u] < 200) {
            if (this.var_byte_arr_M[this.var_short_arr_arr_d[0][this.var_int_u]] >= 0) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[71] + this.var_byte_arr_M[this.var_short_arr_arr_d[0][this.var_int_u]] + 13], (int)this.var_byte_arr_aI[this.var_short_arr_h[72] + this.var_byte_arr_M[this.var_short_arr_arr_d[0][this.var_int_u]] + 13], (int)this.var_byte_arr_aI[this.var_short_arr_h[73] + this.var_byte_arr_M[this.var_short_arr_arr_d[0][this.var_int_u]] + 13], (int)this.var_byte_arr_aI[this.var_short_arr_h[74] + this.var_byte_arr_M[this.var_short_arr_arr_d[0][this.var_int_u]] + 13], 0, this.var_int_V + this.var_int_v - this.var_byte_arr_aI[this.var_short_arr_h[73] + this.var_byte_arr_M[this.var_short_arr_arr_d[0][this.var_int_u]] + 13] / 2, this.var_int_U + this.var_short_arr_arr_d[1][this.var_int_u] - this.var_byte_aU - this.var_byte_arr_aI[this.var_short_arr_h[74] + this.var_byte_arr_M[this.var_short_arr_arr_d[0][this.var_int_u]] + 13], 20);
            }
            if (this.var_byte_arr_O[this.var_short_arr_arr_d[0][this.var_int_u]] >= 0) {
                this.var_int_w = this.var_byte_arr_O[this.var_short_arr_arr_d[0][this.var_int_u]] % b.var_byte_arr_arr_e.length;
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_b[2], (int)b.var_byte_arr_arr_e[this.var_int_w][0], (int)b.var_byte_arr_arr_e[this.var_int_w][1], (int)b.var_byte_arr_arr_e[this.var_int_w][2], (int)b.var_byte_arr_arr_e[this.var_int_w][3], 0, this.var_int_V + this.var_int_v - b.var_byte_arr_arr_e[this.var_int_w][2] / 2 + b.var_byte_arr_arr_e[this.var_int_w][4], this.var_int_U + this.var_short_arr_arr_d[1][this.var_int_u] - this.var_byte_aU + b.var_byte_arr_arr_e[this.var_int_w][5], 20);
            }
            this.b(this.var_short_arr_arr_d[0][this.var_int_u], this.var_int_V + this.var_int_v, this.var_int_U + this.var_short_arr_arr_d[1][this.var_int_u] - this.var_byte_aU);
        }
    }

    final void b(int n, int n2, int n3) {
        if (this.var_byte_arr_N[n] >= 0) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[71] + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[72] + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[73] + 0], (int)this.var_byte_arr_aI[this.var_short_arr_h[74] + 0], 0, n2 - this.var_byte_arr_aI[this.var_short_arr_h[73] + 0], n3 - this.var_byte_arr_aI[this.var_short_arr_h[74] + 0], 20);
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[71] + this.var_byte_arr_aI[this.var_short_arr_h[96] + this.var_byte_arr_N[n]]], (int)this.var_byte_arr_aI[this.var_short_arr_h[72] + this.var_byte_arr_aI[this.var_short_arr_h[96] + this.var_byte_arr_N[n]]], (int)this.var_byte_arr_aI[this.var_short_arr_h[73] + this.var_byte_arr_aI[this.var_short_arr_h[96] + this.var_byte_arr_N[n]]], (int)this.var_byte_arr_aI[this.var_short_arr_h[74] + this.var_byte_arr_aI[this.var_short_arr_h[96] + this.var_byte_arr_N[n]]], 0, n2 - this.var_byte_arr_aI[this.var_short_arr_h[73] + 0] + b.ak[0] - this.var_byte_arr_aI[this.var_short_arr_h[73] + this.var_byte_arr_aI[this.var_short_arr_h[96] + this.var_byte_arr_N[n]]] / 2, n3 - this.var_byte_arr_aI[this.var_short_arr_h[74] + 0] + b.ak[1] - this.var_byte_arr_aI[this.var_short_arr_h[74] + this.var_byte_arr_aI[this.var_short_arr_h[96] + this.var_byte_arr_N[n]]] / 2, 20);
        }
    }

    final void aR() {
        this.var_int_q = 0;
        while (this.var_int_q < this.var_byte_aH) {
            if (this.var_byte_arr_arr_x[this.var_int_q][0] >= 0) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[71] + this.var_byte_arr_aS[this.var_int_q]], (int)this.var_byte_arr_aI[this.var_short_arr_h[72] + this.var_byte_arr_aS[this.var_int_q]], (int)this.var_byte_arr_aI[this.var_short_arr_h[73] + this.var_byte_arr_aS[this.var_int_q]], (int)this.var_byte_arr_aI[this.var_short_arr_h[74] + this.var_byte_arr_aS[this.var_int_q]], 0, (this.var_byte_arr_arr_x[this.var_int_q][0] + this.var_byte_arr_arr_x[this.var_int_q][1] - this.var_int_arr_arr_f[0][0] - this.var_int_arr_arr_f[0][1]) * (b.B[0] / 2) + this.var_byte_W + this.var_byte_arr_aR[this.var_int_q], (this.var_byte_arr_arr_x[this.var_int_q][0] - this.var_byte_arr_arr_x[this.var_int_q][1] - this.var_int_arr_arr_f[0][0] + this.var_int_arr_arr_f[0][1]) * (b.B[1] / 2) + this.var_byte_X + this.var_byte_arr_aQ[this.var_int_q], 20);
            }
            ++this.var_int_q;
        }
    }

    final void aS() {
        if (this.var_boolean_f && this.var_byte_b == 0 || this.var_byte_i >= 0) {
            this.var_int_n = 0;
        }
        if (this.var_int_aK > 0 && this.var_boolean_p) {
            this.var_int_n = 0;
            this.var_int_aK = 0;
        }
        if (this.var_int_n == 48) {
            this.aT();
        } else if (this.var_byte_b == 0) {
            if (this.var_int_aK != 1) {
                this.aU();
            }
        } else if (this.var_byte_b == 1) {
            this.bh();
        } else if (this.var_byte_b == 2) {
            this.bk();
        } else if (this.var_byte_b == 3) {
            this.bo();
        } else if (this.var_byte_b == 4) {
            this.bH();
        } else if (this.var_byte_b == 5) {
            this.bI();
        }
        if (this.var_boolean_p || this.var_int_n == -6 || this.var_int_n == -7 || this.var_int_n == 48 || this.var_int_n == 5 || this.var_byte_b != 0) {
            this.var_int_n = 0;
        }
        if (this.var_int_n != 0) {
            ++this.var_int_aK;
        }
    }

    final void aT() {
        if ((this.var_byte_b != 3 || this.var_byte_R > 17 || this.var_byte_R == 10 && this.var_byte_K == 1) && this.var_byte_b != 4 && this.var_byte_b != 0 && this.var_byte_b != 1) {
            this.cC();
            return;
        }
        if (this.var_byte_b == 0) {
            this.var_byte_a = 1;
            this.al();
            this.var_byte_a = 0;
            this.var_byte_b = (byte)4;
            this.var_byte_aa = 0;
            this.var_byte_aN = 1;
            this.var_int_arr_m[0] = 2;
            this.var_int_arr_m[1] = (this.var_int_l - this.var_byte_O * (b.var_byte_arr_d[2] + 2)) / 2;
            this.var_int_arr_m[2] = this.var_int_l - 2 - this.var_byte_O * (b.var_byte_arr_d[2] + 2);
            return;
        }
        if (this.var_byte_b == 4) {
            this.var_byte_b = 0;
            this.var_byte_aa = (byte)5;
        }
    }

    final void aU() {
        this.aV();
        switch (this.var_int_n) {
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
                if (!this.var_boolean_d && !this.var_boolean_g) {
                    if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] >= 4 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] <= 13) {
                        this.ba();
                        return;
                    }
                    if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] < 0 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] >= -28) {
                        this.bb();
                        return;
                    }
                    if (this.var_short_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == -1) break;
                    this.bc();
                    return;
                }
                if (this.var_boolean_d) {
                    this.bd();
                    return;
                }
                if (!this.var_boolean_g) break;
                if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] > 0 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] <= 3) {
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
        if (this.var_byte_aa != 5) {
            this.var_byte_aa = 0;
        }
        if (this.var_boolean_d) {
            if (this.var_byte_j >= 0) {
                this.var_int_arr_n[0] = b.var_byte_arr_arr_arr_a[this.var_byte_at][this.var_byte_j][0];
                this.var_int_arr_n[1] = b.var_byte_arr_arr_arr_b[this.var_byte_at][this.var_byte_j][0];
                this.var_int_arr_n[2] = b.var_byte_arr_arr_arr_a[this.var_byte_at][this.var_byte_j][1];
                this.var_int_arr_n[3] = b.var_byte_arr_arr_arr_b[this.var_byte_at][this.var_byte_j][1];
                return;
            }
            this.var_int_arr_n[0] = 0;
            this.var_int_arr_n[1] = 0;
            this.var_int_arr_n[2] = this.var_int_B;
            this.var_int_arr_n[3] = this.var_int_C;
        }
    }

    final void aW() {
        this.var_int_r = this.var_int_arr_a[0] - this.var_int_arr_a[1] - this.var_int_arr_n[3] - this.var_int_arr_arr_f[0][0] + this.var_int_arr_arr_f[0][1];
        if (this.var_boolean_d && this.var_int_r < 0) {
            this.var_int_q = 0;
            while (this.var_int_q < 4) {
                int[] nArray = this.var_int_arr_arr_f[this.var_int_q];
                nArray[0] = nArray[0] + (this.var_int_r - 1) / 2;
                int[] nArray2 = this.var_int_arr_arr_f[this.var_int_q];
                nArray2[1] = nArray2[1] - (this.var_int_r - 1) / 2;
                ++this.var_int_q;
            }
            this.var_byte_aa = 1;
            return;
        }
        if (this.var_int_arr_a[0] > -this.var_int_arr_n[0]) {
            this.var_int_arr_a[0] = this.var_int_arr_a[0] - 1;
            if (this.var_int_arr_a[0] + this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] - this.var_int_arr_arr_f[0][1] - 2 < 0 || this.var_int_arr_a[0] - this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] + this.var_int_arr_arr_f[0][1] - 2 < 0 || this.var_boolean_d) {
                this.var_int_q = 0;
                while (this.var_int_q < 4) {
                    int[] nArray = this.var_int_arr_arr_f[this.var_int_q];
                    nArray[0] = nArray[0] - 1;
                    ++this.var_int_q;
                }
                this.var_byte_aa = 1;
            }
        }
    }

    final void aX() {
        this.var_int_r = this.var_int_arr_a[0] + this.var_int_arr_n[2] - this.var_int_arr_a[1] - this.var_int_arr_arr_f[3][0] + this.var_int_arr_arr_f[3][1] - 2;
        if (this.var_boolean_d && this.var_int_r > 0) {
            this.var_int_q = 0;
            while (this.var_int_q < 4) {
                int[] nArray = this.var_int_arr_arr_f[this.var_int_q];
                nArray[0] = nArray[0] + (this.var_int_r + 1) / 2;
                int[] nArray2 = this.var_int_arr_arr_f[this.var_int_q];
                nArray2[1] = nArray2[1] - (this.var_int_r + 1) / 2;
                ++this.var_int_q;
            }
            this.var_byte_aa = (byte)2;
            return;
        }
        if (this.var_int_arr_a[0] < this.var_byte_O - 1 && !this.var_boolean_d || this.var_int_arr_a[0] < this.var_byte_O - this.var_int_arr_n[2] && this.var_boolean_d) {
            this.var_int_arr_a[0] = this.var_int_arr_a[0] + 1;
            if (this.var_int_arr_a[0] + this.var_int_arr_a[1] - this.var_int_arr_arr_f[1][0] - this.var_int_arr_arr_f[1][1] + 1 > 0 || this.var_int_arr_a[0] - this.var_int_arr_a[1] - this.var_int_arr_arr_f[3][0] + this.var_int_arr_arr_f[3][1] + 1 > 0 || this.var_boolean_d) {
                this.var_int_q = 0;
                while (this.var_int_q < 4) {
                    int[] nArray = this.var_int_arr_arr_f[this.var_int_q];
                    nArray[0] = nArray[0] + 1;
                    ++this.var_int_q;
                }
                this.var_byte_aa = (byte)2;
            }
        }
    }

    final void aY() {
        this.var_int_r = this.var_int_arr_a[0] + this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] - this.var_int_arr_arr_f[0][1];
        if (this.var_boolean_d && this.var_int_r < 0) {
            this.var_int_q = 0;
            while (this.var_int_q < 4) {
                int[] nArray = this.var_int_arr_arr_f[this.var_int_q];
                nArray[0] = nArray[0] + (this.var_int_r - 1) / 2;
                int[] nArray2 = this.var_int_arr_arr_f[this.var_int_q];
                nArray2[1] = nArray2[1] + (this.var_int_r - 1) / 2;
                ++this.var_int_q;
            }
            this.var_byte_aa = (byte)4;
            return;
        }
        if (this.var_int_arr_a[1] > -this.var_int_arr_n[1]) {
            this.var_int_arr_a[1] = this.var_int_arr_a[1] - 1;
            if (this.var_int_arr_a[0] + this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] - this.var_int_arr_arr_f[0][1] - 2 < 0 || this.var_int_arr_a[0] - this.var_int_arr_a[1] - this.var_int_arr_arr_f[3][0] + this.var_int_arr_arr_f[3][1] + 1 > 0 || this.var_boolean_d) {
                this.var_int_q = 0;
                while (this.var_int_q < 4) {
                    int[] nArray = this.var_int_arr_arr_f[this.var_int_q];
                    nArray[1] = nArray[1] - 1;
                    ++this.var_int_q;
                }
                this.var_byte_aa = (byte)4;
            }
        }
    }

    final void aZ() {
        this.var_int_r = this.var_int_arr_a[0] + this.var_int_arr_n[2] + this.var_int_arr_a[1] + this.var_int_arr_n[3] - this.var_int_arr_arr_f[1][0] - this.var_int_arr_arr_f[1][1] - 2;
        if (this.var_boolean_d && this.var_int_r > 0) {
            this.var_int_q = 0;
            while (this.var_int_q < 4) {
                int[] nArray = this.var_int_arr_arr_f[this.var_int_q];
                nArray[0] = nArray[0] + (this.var_int_r + 1) / 2;
                int[] nArray2 = this.var_int_arr_arr_f[this.var_int_q];
                nArray2[1] = nArray2[1] + (this.var_int_r + 1) / 2;
                ++this.var_int_q;
            }
            this.var_byte_aa = (byte)3;
            return;
        }
        if (this.var_int_arr_a[1] < this.var_byte_O - 1 && !this.var_boolean_d || this.var_int_arr_a[1] < this.var_byte_O - this.var_int_arr_n[3] && this.var_boolean_d) {
            this.var_int_arr_a[1] = this.var_int_arr_a[1] + 1;
            if (this.var_int_arr_a[0] + this.var_int_arr_a[1] - this.var_int_arr_arr_f[1][0] - this.var_int_arr_arr_f[1][1] + 1 > 0 || this.var_int_arr_a[0] - this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] + this.var_int_arr_arr_f[0][1] - 2 < 0 || this.var_boolean_d) {
                this.var_int_q = 0;
                while (this.var_int_q < 4) {
                    int[] nArray = this.var_int_arr_arr_f[this.var_int_q];
                    nArray[1] = nArray[1] + 1;
                    ++this.var_int_q;
                }
                this.var_byte_aa = (byte)3;
            }
        }
    }

    final void ba() {
        this.var_byte_b = (byte)3;
        if (this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] >= 0) {
            this.var_byte_ar = this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]];
            this.var_boolean_l = this.var_boolean_arr_c[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]];
            if (this.var_byte_ar != 23) {
                this.var_byte_R = (byte)18;
                this.var_byte_arr_x[0] = 0;
                this.var_byte_arr_x[1] = 1;
                this.var_byte_arr_x[2] = 2;
                this.var_byte_arr_y[0] = (byte)(this.var_byte_arr_aA[this.var_byte_ar] / 5);
                if (this.var_byte_ar == 22) {
                    this.var_byte_arr_y[0] = (byte)(this.var_byte_arr_ad[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] / 5);
                }
                this.var_byte_arr_y[1] = (byte)(this.var_byte_arr_ah[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] / 10);
                this.var_byte_arr_y[2] = this.var_byte_arr_al[this.var_byte_ar];
            } else {
                this.var_byte_R = (byte)21;
                this.var_byte_an = (byte)28;
                this.var_boolean_m = this.var_boolean_arr_a[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]];
                this.var_byte_arr_x[0] = 2;
                this.var_byte_arr_y[0] = this.var_byte_arr_aE[this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_byte_an]];
                this.var_byte_U = this.var_byte_arr_aI[this.var_short_arr_h[56] + this.var_byte_an];
            }
        } else {
            this.var_byte_ar = (byte)22;
            this.var_byte_R = (byte)18;
        }
        this.var_byte_arr_w[this.var_byte_R] = this.var_byte_arr_aI[this.var_short_arr_h[135] + this.var_byte_ar];
        this.ct();
        this.var_byte_aa = (byte)5;
    }

    final void bb() {
        if (this.var_byte_arr_aI[this.var_short_arr_h[57] + -1 - this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] >= 0) {
            this.var_byte_b = (byte)3;
            this.var_byte_R = (byte)19;
            this.var_byte_an = (byte)(-1 - this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]]);
            this.var_boolean_m = this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]];
            this.var_byte_arr_x[0] = 0;
            this.var_byte_arr_x[1] = 2;
            this.var_byte_arr_y[0] = this.var_byte_arr_aI[this.var_short_arr_h[29] + this.var_byte_an * (this.var_byte_ad + 1) + this.var_byte_ad];
            this.var_byte_arr_y[1] = this.var_byte_arr_aE[this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_byte_an]];
            this.var_byte_arr_w[this.var_byte_R] = this.var_byte_arr_aI[this.var_short_arr_h[136] + this.var_byte_an];
            this.var_byte_U = this.var_byte_arr_aI[this.var_short_arr_h[56] + this.var_byte_an];
            this.ct();
            this.var_byte_aa = (byte)5;
            return;
        }
        if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] <= -27) {
            this.var_byte_b = (byte)3;
            this.var_byte_R = (byte)22;
            this.var_byte_an = (byte)26;
            this.var_boolean_m = this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]];
            this.var_byte_arr_w[this.var_byte_R] = this.var_byte_arr_aI[this.var_short_arr_h[136] + this.var_byte_an];
            this.var_byte_U = this.var_byte_arr_aI[this.var_short_arr_h[56] + this.var_byte_an];
            this.ct();
            this.var_byte_aa = (byte)5;
        }
    }

    final void bc() {
        this.var_int_v = this.var_short_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]];
        while (this.var_int_v != -1) {
            if (this.var_byte_arr_A[this.var_int_v] == 8 || this.var_byte_arr_A[this.var_int_v] == 9) {
                this.var_byte_b = (byte)3;
                this.var_byte_R = (byte)20;
                this.var_byte_U = (byte)(this.var_byte_arr_A[this.var_int_v] - 8);
                this.var_int_j = this.var_int_v;
                this.var_byte_arr_x[0] = 2;
                this.var_byte_arr_y[0] = this.var_byte_arr_aI[this.var_short_arr_h[131] + this.var_byte_U];
                this.var_byte_arr_w[this.var_byte_R] = this.var_byte_arr_aI[this.var_short_arr_h[137] + this.var_byte_U];
                this.ct();
                this.var_byte_aa = (byte)5;
            }
            this.var_int_v = this.var_short_arr_d[this.var_int_v];
        }
        if (this.var_byte_b == 0) {
            this.var_int_aL = this.var_int_v = this.var_short_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]];
            this.e(false);
            this.var_byte_b = (byte)3;
            this.var_byte_R = (byte)23;
            this.var_byte_U = this.var_byte_arr_A[this.var_int_v];
            this.var_int_j = this.var_int_v;
            this.var_byte_arr_x[0] = 0;
            this.var_byte_arr_x[1] = 4;
            this.var_byte_arr_x[2] = 3;
            this.var_byte_arr_y[0] = (byte)(this.var_byte_arr_P[this.var_int_v] / 10);
            this.var_byte_arr_y[1] = (byte)(this.var_byte_arr_R[this.var_int_v] / 10);
            this.var_byte_arr_y[2] = (byte)(this.var_byte_arr_Q[this.var_int_v] / 10);
            this.ct();
            this.var_byte_aa = (byte)5;
        }
    }

    final void bd() {
        if (this.var_boolean_e) {
            if (this.var_int_k < this.var_int_i) {
                this.var_byte_h = 0;
            }
            if (this.var_int_k - -500 >= this.var_int_i) {
                if (this.var_byte_aW == 0) {
                    this.var_byte_d = 0;
                    this.var_boolean_f = true;
                    this.var_byte_W = b.m[this.var_byte_d];
                    this.var_byte_X = b.n[this.var_byte_d];
                    return;
                }
                this.cb();
                if (this.var_byte_aW != 3 && (this.var_byte_aW != 1 || this.var_byte_aV >= 14 || this.var_byte_aV == 13 && this.var_byte_aW == 1 && this.var_byte_ag >= 30)) {
                    this.var_byte_d = (byte)-1;
                    this.var_boolean_d = false;
                }
                if (this.var_byte_aW == 1 && this.var_byte_aV < 14) {
                    this.var_int_s = (this.var_java_util_Random_a.nextInt() & 0xF) % 4;
                    this.var_int_r = 0;
                    while (this.var_int_r < this.var_int_s) {
                        this.var_byte_au = (byte)(this.var_byte_au - this.var_byte_arr_aI[this.var_short_arr_h[162] - 1 - this.var_byte_au]);
                        ++this.var_int_r;
                    }
                }
            }
        }
    }

    final void be() {
        this.var_byte_d = 0;
        this.bQ();
        if (this.var_boolean_h) {
            if (this.var_short_e >= 0) {
                if (this.var_int_k - -500 < this.var_byte_arr_aI[this.var_short_arr_h[131] + this.var_short_e]) {
                    return;
                }
                this.var_int_k -= this.var_byte_arr_aI[this.var_short_arr_h[131] + this.var_short_e];
                this.var_int_e += this.var_byte_arr_aI[this.var_short_arr_h[131] + this.var_short_e];
                this.var_byte_arr_aT[0] = (byte)this.var_int_arr_a[0];
                this.var_byte_arr_aT[1] = (byte)this.var_int_arr_a[1];
                this.var_short_h = (short)(b.B[0] / 2);
                this.var_short_i = 0;
                this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
                this.var_java_lang_StringBuffer_a.append("-");
                this.var_java_lang_StringBuffer_a.append(this.var_byte_arr_aI[this.var_short_arr_h[131] + this.var_short_e]);
                this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
                this.dL();
            }
            this.bW();
            return;
        }
        this.var_byte_f = 0;
        this.var_byte_aC = 1;
        this.var_byte_aB = this.var_byte_aA;
        this.dH();
    }

    final void bf() {
        if (!this.var_boolean_d && !this.var_boolean_g) {
            this.var_byte_a = 1;
            this.al();
            this.var_byte_a = 0;
            this.var_byte_b = 1;
            this.var_byte_aa = 0;
            this.var_byte_z = 0;
            this.var_byte_A = 0;
            this.var_byte_aC = 1;
            this.var_byte_aA = (byte)(23 + this.var_byte_y);
            this.dH();
            return;
        }
        if (this.var_boolean_d) {
            if (this.var_byte_aW == 0) {
                this.var_byte_at = (byte)((this.var_byte_at + 1) % 2);
                if (this.var_byte_j >= 0) {
                    this.var_int_B = b.var_byte_arr_arr_arr_a[this.var_byte_at][this.var_byte_j][1];
                    this.var_int_C = b.var_byte_arr_arr_arr_b[this.var_byte_at][this.var_byte_j][1];
                    if (this.var_int_arr_a[0] + b.var_byte_arr_arr_arr_a[this.var_byte_at][this.var_byte_j][0] < 0) {
                        this.aX();
                    }
                    if (this.var_int_arr_a[0] + b.var_byte_arr_arr_arr_a[this.var_byte_at][this.var_byte_j][1] > this.var_byte_O) {
                        this.aW();
                    }
                    if (this.var_int_arr_a[1] + b.var_byte_arr_arr_arr_b[this.var_byte_at][this.var_byte_j][0] < 0) {
                        this.aZ();
                    }
                    if (this.var_int_arr_a[1] + b.var_byte_arr_arr_arr_b[this.var_byte_at][this.var_byte_j][1] > this.var_byte_O) {
                        this.aY();
                        return;
                    }
                }
            } else {
                if (this.var_byte_aW == 1) {
                    this.var_byte_au = (byte)(this.var_byte_au - this.var_byte_arr_aI[this.var_short_arr_h[162] - 1 - this.var_byte_au]);
                    return;
                }
                if (this.var_byte_aW == 3 && this.var_byte_aV == 2) {
                    if (this.var_byte_av == 0) {
                        this.var_byte_av = (byte)-1;
                        return;
                    }
                    this.var_byte_av = 0;
                    return;
                }
            }
        } else if (this.var_boolean_g) {
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] > 0 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] <= 3) {
                return;
            }
            this.be();
        }
    }

    final void bg() {
        if (this.var_boolean_d) {
            this.cm();
            this.var_boolean_j = false;
            if (!this.var_boolean_d) {
                this.var_byte_j = (byte)-1;
                this.var_byte_d = (byte)-1;
            }
            this.var_byte_aa = (byte)5;
            return;
        }
        if (this.var_boolean_g) {
            this.var_byte_d = (byte)-1;
            this.var_boolean_g = false;
            return;
        }
        if (!this.var_boolean_d && !this.var_boolean_g) {
            this.var_byte_az = 0;
            this.var_byte_b = (byte)3;
            this.var_byte_R = 1;
            this.var_boolean_k = false;
            this.ct();
            this.var_byte_aa = (byte)5;
        }
    }

    final void bh() {
        if (this.var_byte_z == 0) {
            switch (this.var_int_n) {
                case 3: {
                    this.var_byte_A = (byte)-1;
                    this.var_byte_z = (byte)3;
                    this.var_byte_y = (byte)(this.var_byte_y + 1);
                    if (this.var_byte_y == this.var_byte_x) {
                        this.var_byte_y = 0;
                    }
                    this.var_byte_aC = 1;
                    this.var_byte_aA = (byte)(23 + this.var_byte_y);
                    this.dH();
                    break;
                }
                case 4: {
                    this.var_byte_A = 1;
                    break;
                }
                case -6: 
                case 5: {
                    this.bi();
                    this.var_byte_aa = (byte)5;
                    break;
                }
                case -7: {
                    this.var_byte_b = 0;
                    this.var_byte_aa = (byte)5;
                }
            }
        }
        this.bj();
    }

    final void bi() {
        if (this.var_byte_y != 6 && this.var_byte_y != 3) {
            this.var_byte_b = (byte)2;
            this.var_byte_C = 0;
            this.var_byte_av = 0;
            if (this.var_byte_y == 1) {
                this.var_byte_B = 0;
            }
            if (this.var_byte_y == 2) {
                this.var_byte_B = 1;
            }
            if (this.var_byte_y == 5) {
                this.var_byte_B = (byte)2;
            }
            if (this.var_byte_y == 4) {
                this.var_byte_B = (byte)3;
            }
            if (this.var_byte_y == 0) {
                this.var_byte_B = (byte)4;
            }
            while (true) {
                this.var_byte_aV = this.var_byte_arr_aI[this.var_short_arr_h[151 + this.var_byte_B] + this.var_byte_C];
                this.var_byte_aW = this.var_byte_arr_aI[this.var_short_arr_h[146 + this.var_byte_B] + this.var_byte_C];
                if (!this.boolean_a()) break;
                this.var_byte_C = (byte)(this.var_byte_C + 1);
                if (this.var_byte_C != b.j[this.var_byte_B]) continue;
                this.var_byte_C = 0;
            }
            this.co();
            return;
        }
        if (this.var_byte_y == 6) {
            this.var_byte_b = 0;
            this.var_byte_d = (byte)-1;
            this.var_boolean_g = true;
            return;
        }
        if (this.var_byte_y == 3) {
            this.var_int_ad = 0;
            while (this.var_int_ad < 8) {
                if (this.var_int_ad > 3) {
                    this.var_int_af = 3;
                } else {
                    this.var_int_af = this.var_int_ad;
                    this.var_int_arr_arr_d[this.var_int_ad][0] = this.var_int_arr_arr_d[this.var_int_ad][1];
                }
                this.var_int_ae = 0;
                while (this.var_int_ae < this.var_int_arr_arr_c[this.var_int_ad][d.var_short_arr_k[4]]) {
                    if (this.var_int_arr_arr_c[this.var_int_ad][this.var_int_ae] > this.var_int_arr_arr_d[this.var_int_af][0]) {
                        this.var_int_arr_arr_d[this.var_int_af][0] = this.var_int_arr_arr_c[this.var_int_ad][this.var_int_ae];
                    }
                    ++this.var_int_ae;
                }
                ++this.var_int_ad;
            }
            this.var_byte_b = (byte)3;
            this.var_byte_R = (byte)26;
            this.ct();
        }
    }

    final void bj() {
        this.var_byte_z = (byte)(this.var_byte_z + this.var_byte_A);
        if (this.var_byte_z == 3) {
            if (this.var_byte_y == 0) {
                this.var_byte_y = this.var_byte_x;
            }
            this.var_byte_y = (byte)(this.var_byte_y - 1);
            this.var_byte_aC = 1;
            this.var_byte_aA = (byte)(23 + this.var_byte_y);
            this.dH();
            this.var_byte_z = 0;
            this.var_byte_A = 0;
        }
        if (this.var_byte_z == 0 && this.var_byte_A == -1) {
            this.var_byte_A = 0;
        }
    }

    final void bk() {
        switch (this.var_int_n) {
            case 3: {
                if (this.var_boolean_n) {
                    return;
                }
                do {
                    this.var_byte_C = (byte)(this.var_byte_C + 1);
                    if (this.var_byte_C == b.j[this.var_byte_B]) {
                        this.var_byte_C = 0;
                    }
                    this.var_byte_aV = this.var_byte_arr_aI[this.var_short_arr_h[151 + this.var_byte_B] + this.var_byte_C];
                    this.var_byte_aW = this.var_byte_arr_aI[this.var_short_arr_h[146 + this.var_byte_B] + this.var_byte_C];
                } while (this.boolean_a());
                this.co();
                return;
            }
            case 4: {
                if (this.var_boolean_n) {
                    return;
                }
                do {
                    this.var_byte_C = (byte)(this.var_byte_C - 1);
                    if (this.var_byte_C < 0) {
                        this.var_byte_C = (byte)(b.j[this.var_byte_B] - 1);
                    }
                    this.var_byte_aV = this.var_byte_arr_aI[this.var_short_arr_h[151 + this.var_byte_B] + this.var_byte_C];
                    this.var_byte_aW = this.var_byte_arr_aI[this.var_short_arr_h[146 + this.var_byte_B] + this.var_byte_C];
                } while (this.boolean_a());
                this.co();
                return;
            }
            case -6: 
            case 5: {
                if (!this.var_boolean_o) {
                    if (!this.var_boolean_n) {
                        this.bl();
                        return;
                    }
                    if (this.var_int_k < this.var_int_i) {
                        this.var_byte_h = 0;
                    }
                    if (this.var_int_k - -500 < this.var_int_i) break;
                    this.bm();
                }
            }
            case -7: {
                this.bn();
            }
        }
    }

    final boolean boolean_a() {
        if (this.var_byte_aW == 2 && this.var_byte_K == 1 && (this.var_byte_C == 2 && !this.var_boolean_arr_arr_a[0][23] || this.var_byte_C == 5 && !this.var_boolean_arr_arr_a[1][26])) {
            return true;
        }
        if (this.var_byte_aW > 1 && (this.var_byte_aW != 3 || this.var_byte_aV != 13 || this.var_boolean_arr_arr_a[0][22])) {
            return false;
        }
        if (this.var_byte_aW < 2) {
            if (this.var_byte_K == 0) {
                return false;
            }
            if (this.var_boolean_arr_arr_a[this.var_byte_aW][this.var_byte_aV]) {
                return false;
            }
        }
        return true;
    }

    final void bl() {
        this.var_boolean_d = true;
        this.var_byte_d = 0;
        this.var_byte_j = (byte)-1;
        if (this.var_byte_aW == 1) {
            this.var_byte_au = (byte)(-1 - this.var_byte_aV);
        }
        this.cn();
        if (this.var_byte_aW == 0 && this.var_byte_aV == 22) {
            this.var_byte_j = 0;
            this.var_int_B = b.var_byte_arr_arr_arr_a[this.var_byte_at][this.var_byte_j][1];
            this.var_int_C = b.var_byte_arr_arr_arr_b[this.var_byte_at][this.var_byte_j][1];
        }
        this.var_byte_az = 0;
        this.var_byte_b = 0;
        this.var_byte_aa = (byte)5;
    }

    final void bm() {
        this.var_int_k -= this.var_int_i;
        this.var_int_e += this.var_int_i;
        this.var_boolean_m = true;
        this.var_byte_arr_aT[0] = (byte)this.var_int_arr_a[0];
        this.var_byte_arr_aT[1] = (byte)this.var_int_arr_a[1];
        this.var_short_h = (short)(b.B[0] / 2);
        this.var_short_i = 0;
        this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
        this.var_java_lang_StringBuffer_a.append("-");
        this.var_java_lang_StringBuffer_a.append(this.var_int_i);
        this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
        this.dL();
        byte by = this.var_byte_C;
        this.var_short_arr_e[by] = (short)(this.var_short_arr_e[by] + 1);
        byte by2 = b.j[3];
        this.var_short_arr_e[by2] = (short)(this.var_short_arr_e[by2] + this.var_int_i);
    }

    final void bn() {
        this.var_byte_az = 0;
        if (!this.var_boolean_n) {
            this.var_byte_b = 0;
        } else {
            this.var_byte_b = (byte)3;
            this.cu();
            this.var_boolean_n = false;
        }
        this.var_byte_aa = (byte)5;
        this.var_boolean_o = false;
    }

    final void bo() {
        switch (this.var_int_n) {
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
                if (!this.var_boolean_o && this.var_byte_arr_v[this.var_byte_R] > 0) {
                    if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 11) {
                        if (this.var_byte_arr_y[this.var_byte_arr_aI[this.var_short_arr_h[92] + this.var_byte_R] - 1] >= 10) break;
                        int n = this.var_byte_arr_aI[this.var_short_arr_h[92] + this.var_byte_R] - 1;
                        this.var_byte_arr_y[n] = (byte)(this.var_byte_arr_y[n] + 1);
                        this.cu();
                        return;
                    }
                    if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 10) {
                        this.var_boolean_l = !this.var_boolean_l;
                        this.cu();
                        return;
                    }
                    if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 41) {
                        if (this.var_byte_aJ >= 5) break;
                        this.var_byte_aJ = (byte)(this.var_byte_aJ + 1);
                        this.var_a_a.a(this.var_byte_aJ, this.var_byte_aJ - 1);
                        this.cu();
                        return;
                    }
                    if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 12) {
                        this.bt();
                        return;
                    }
                }
            }
            case -6: {
                if (!this.var_boolean_o) {
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
        if (!this.var_boolean_o && this.var_byte_arr_v[this.var_byte_R] > 0) {
            if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 11 && this.var_byte_arr_y[this.var_byte_arr_aI[this.var_short_arr_h[92] + this.var_byte_R] - 1] < 10) {
                int n = this.var_byte_arr_aI[this.var_short_arr_h[92] + this.var_byte_R] - 1;
                this.var_byte_arr_y[n] = (byte)(this.var_byte_arr_y[n] + 1);
                this.cu();
                return;
            }
            if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 10) {
                this.var_boolean_l = !this.var_boolean_l;
                this.cu();
                return;
            }
            if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 41) {
                if (this.var_byte_aJ < 5) {
                    this.var_byte_aJ = (byte)(this.var_byte_aJ + 1);
                    this.var_a_a.a(this.var_byte_aJ, this.var_byte_aJ - 1);
                    this.cu();
                    return;
                }
            } else if (this.var_byte_R == 26) {
                this.var_byte_P = (byte)(this.var_byte_P + 1);
                if (this.var_byte_P == 4 && this.var_byte_K == 0) {
                    this.var_byte_P = (byte)(this.var_byte_P + 1);
                }
                if (this.var_byte_P >= this.var_byte_arr_v[this.var_byte_R] || this.var_byte_K == 1 && this.var_byte_P >= this.var_byte_arr_v[this.var_byte_R] - 1) {
                    this.var_byte_P = 0;
                }
                this.cu();
            }
        }
    }

    final void bq() {
        if (!this.var_boolean_o && this.var_byte_arr_v[this.var_byte_R] > 0) {
            if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 11 && this.var_byte_arr_y[this.var_byte_arr_aI[this.var_short_arr_h[92] + this.var_byte_R] - 1] > 1) {
                int n = this.var_byte_arr_aI[this.var_short_arr_h[92] + this.var_byte_R] - 1;
                this.var_byte_arr_y[n] = (byte)(this.var_byte_arr_y[n] - 1);
                this.cu();
                return;
            }
            if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 10) {
                this.var_boolean_l = !this.var_boolean_l;
                this.cu();
                return;
            }
            if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 41) {
                if (this.var_byte_aJ > 0) {
                    this.var_byte_aJ = (byte)(this.var_byte_aJ - 1);
                    this.var_a_a.a(this.var_byte_aJ, this.var_byte_aJ + 1);
                    this.cu();
                    return;
                }
            } else if (this.var_byte_R == 26) {
                this.var_byte_P = (byte)(this.var_byte_P - 1);
                if (this.var_byte_P == 4 && this.var_byte_K == 0) {
                    this.var_byte_P = (byte)(this.var_byte_P - 1);
                }
                if (this.var_byte_P < 0) {
                    this.var_byte_P = this.var_byte_K == 1 ? (byte)(this.var_byte_arr_v[this.var_byte_R] - 2) : (byte)(this.var_byte_arr_v[this.var_byte_R] - 1);
                }
                this.cu();
            }
        }
    }

    final void br() {
        if (!this.var_boolean_o) {
            if (this.var_byte_R == 2 || this.var_byte_R == 5 || this.var_byte_R == 3 || this.var_byte_R == 10 && this.var_byte_K == 0) {
                if (this.var_int_F > 0) {
                    this.var_int_F -= d.var_byte_arr_j[this.var_byte_aC];
                }
                if (this.var_int_F < 0) {
                    this.var_int_F = 0;
                    return;
                }
            } else if (this.var_byte_R != 26 && this.var_byte_arr_v[this.var_byte_R] > 0) {
                if (this.var_byte_R == 21) {
                    this.var_byte_P = (byte)(this.var_byte_P + 1);
                    if (this.var_byte_P >= this.var_byte_arr_v[this.var_byte_R]) {
                        this.var_byte_P = 0;
                        return;
                    }
                } else {
                    this.var_byte_P = (byte)(this.var_byte_P - 1);
                    if (this.var_byte_P < 0) {
                        this.var_byte_P = (byte)(this.var_byte_arr_v[this.var_byte_R] - 1);
                    }
                    if (this.var_boolean_v && this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 4) {
                        this.var_byte_P = (byte)(this.var_byte_P - 1);
                    }
                }
            }
        }
    }

    final void bs() {
        if (!this.var_boolean_o) {
            if (this.var_byte_R == 2 || this.var_byte_R == 5 || this.var_byte_R == 3 || this.var_byte_R == 10 && this.var_byte_K == 0) {
                if (this.var_int_G > this.var_int_F + d.var_byte_arr_j[this.var_byte_aC]) {
                    this.var_int_F += d.var_byte_arr_j[this.var_byte_aC];
                    return;
                }
            } else if (this.var_byte_R != 26 && this.var_byte_arr_v[this.var_byte_R] > 0) {
                if (this.var_byte_R != 21) {
                    this.var_byte_P = (byte)(this.var_byte_P + 1);
                    if (this.var_byte_P >= this.var_byte_arr_v[this.var_byte_R]) {
                        this.var_byte_P = 0;
                    }
                    if (this.var_boolean_v && this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 4) {
                        this.var_byte_P = (byte)(this.var_byte_P + 1);
                        return;
                    }
                } else {
                    this.var_byte_P = (byte)(this.var_byte_P - 1);
                    if (this.var_byte_P < 0) {
                        this.var_byte_P = (byte)(this.var_byte_arr_v[this.var_byte_R] - 1);
                    }
                }
            }
        }
    }

    final void bt() {
        this.var_int_i = this.var_byte_arr_aI[this.var_short_arr_h[131] + this.var_byte_arr_aI[this.var_short_arr_h[56] + this.var_byte_an]];
        if (this.var_boolean_m) {
            this.var_byte_az = 0;
            this.var_byte_R = (byte)20;
            this.var_byte_arr_x[0] = 2;
            this.var_byte_arr_y[0] = (byte)this.var_int_i;
            this.var_byte_arr_w[this.var_byte_R] = this.var_byte_arr_aI[this.var_short_arr_h[137] + this.var_byte_arr_aI[this.var_short_arr_h[56] + this.var_byte_an]];
            this.ct();
            this.var_byte_aa = (byte)5;
            return;
        }
        this.var_byte_b = (byte)2;
        this.var_byte_aa = (byte)5;
        this.var_byte_C = this.var_byte_U;
        this.var_byte_B = (byte)3;
        this.var_byte_aV = this.var_byte_arr_aI[this.var_short_arr_h[151 + this.var_byte_B] + this.var_byte_C];
        this.var_byte_aW = this.var_byte_arr_aI[this.var_short_arr_h[146 + this.var_byte_B] + this.var_byte_C];
        this.var_boolean_n = true;
        this.co();
    }

    final void bu() {
        if (this.var_byte_R == 5) {
            this.bv();
            return;
        }
        if (this.var_byte_R == 23 || this.var_byte_R == 26 || this.var_byte_R == 25 && (this.var_byte_N == 0 || this.var_byte_V < 3)) {
            this.var_byte_az = 0;
            this.var_byte_b = 0;
            this.var_byte_aa = (byte)5;
            return;
        }
        if (this.var_byte_R == 4) {
            this.var_byte_P = this.var_byte_Q;
            this.var_byte_R = this.var_byte_S;
            this.cu();
            return;
        }
        if (this.var_byte_R == 3) {
            this.var_byte_R = 0;
            this.cu();
            return;
        }
        if (this.var_byte_R == 2) {
            this.var_byte_b = this.var_byte_c;
            this.var_byte_R = this.var_byte_S;
            if (this.var_byte_b == 3) {
                this.cu();
            }
            if (this.var_byte_b == 2) {
                this.co();
            }
            this.var_byte_aa = (byte)5;
            return;
        }
        if (this.var_byte_R == 7) {
            this.var_byte_N = this.var_byte_P;
            this.var_byte_R = (byte)17;
            this.ct();
            return;
        }
        if (this.var_byte_R == 25 && this.var_byte_N == 1 && this.var_byte_V >= 3) {
            this.void_a(12);
            return;
        }
        if (this.var_byte_R == 12) {
            if (this.var_int_b > 0) {
                this.var_int_g /= this.var_int_b;
            }
            this.var_byte_R = (byte)11;
            this.ct();
            return;
        }
        if (this.var_byte_R == 13) {
            this.var_byte_R = (byte)14;
            this.ct();
            return;
        }
        if (this.var_byte_R == 14) {
            this.var_byte_R = (byte)10;
            this.ct();
            return;
        }
        if (this.var_byte_R == 15) {
            if (this.var_byte_aJ == 0) {
                this.var_byte_aJ = (byte)2;
            }
            this.var_a_a.a(this.var_byte_aJ, 0);
            this.var_byte_R = 0;
            this.ct();
            return;
        }
        if (this.var_byte_R == 16) {
            this.void_f();
            return;
        }
        if (this.var_byte_R == 11) {
            this.bw();
            return;
        }
        if (this.var_byte_R == 10 || this.var_byte_R == 24) {
            this.var_byte_az = 0;
            if (this.var_byte_R == 10) {
                this.void_g();
            }
            if (this.var_byte_R == 24 && this.var_boolean_d) {
                this.var_byte_aW = this.var_byte_aY;
                this.var_byte_aV = this.var_byte_aX;
                this.cs();
                this.var_byte_at = this.var_byte_aZ;
                if (this.var_byte_aW == 0 && this.var_byte_aV == 22) {
                    this.var_int_B = b.var_byte_arr_arr_arr_a[this.var_byte_at][this.var_byte_j][1];
                    this.var_int_C = b.var_byte_arr_arr_arr_b[this.var_byte_at][this.var_byte_j][1];
                }
            }
            this.var_byte_aa = (byte)5;
            this.var_byte_b = 0;
            return;
        }
        if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 5) {
            this.bx();
            return;
        }
        if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 40) {
            this.var_byte_S = this.var_byte_R;
            this.var_byte_R = (byte)5;
            this.var_byte_aA = (byte)22;
            this.cu();
            return;
        }
        if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 0 || this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 1) {
            this.bB();
            return;
        }
        if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 2) {
            this.var_byte_S = this.var_byte_R;
            this.var_byte_Q = this.var_byte_P;
            this.var_byte_R = (byte)4;
            this.ct();
            return;
        }
        if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 21) {
            if (this.var_byte_R == 1) {
                this.var_byte_az = 0;
                this.var_byte_b = 0;
            } else {
                this.dZ();
            }
            this.var_byte_aa = (byte)5;
            return;
        }
        if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 22) {
            this.bA();
            return;
        }
        if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 3) {
            this.cC();
            return;
        }
        if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 95) {
            this.var_byte_R = (byte)3;
            this.cu();
            return;
        }
        if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 107) {
            try {
                this.var_Park_a.platformRequest(this.var_Park_a.getAppProperty("Wap-Link"));
                return;
            }
            catch (Exception exception) {
                return;
            }
        }
        if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 6) {
            this.var_byte_T = this.var_byte_R;
            this.var_byte_S = this.var_byte_R;
            this.var_byte_R = (byte)5;
            this.var_byte_aA = (byte)16;
            this.cu();
            return;
        }
        if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 4) {
            this.var_byte_S = this.var_byte_R;
            this.var_byte_R = (byte)5;
            this.var_byte_aA = (byte)15;
            this.cu();
            return;
        }
        if (this.var_byte_R == 17) {
            this.by();
            return;
        }
        if (this.var_byte_R == 8) {
            this.bz();
            return;
        }
        if (this.var_byte_R == 18 || this.var_byte_R == 19 || this.var_byte_R == 21 || this.var_byte_R == 22) {
            this.bC();
            return;
        }
        if (this.var_byte_R == 20 || this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 13) {
            this.bE();
        }
    }

    final void bv() {
        if (this.var_byte_aA == 15) {
            this.dZ();
            this.var_byte_aa = (byte)5;
            return;
        }
        if (this.var_byte_aA == 16) {
            this.dR();
            this.var_byte_aA = this.var_boolean_x ? (byte)19 : (byte)18;
            this.var_boolean_k = true;
            this.cu();
            return;
        }
        if (this.var_byte_aA == 22) {
            this.void_d();
            return;
        }
        if (this.var_byte_aA == 14) {
            this.var_byte_F = (byte)-1;
            this.var_byte_H = (byte)-1;
        }
        this.var_byte_R = this.var_byte_T;
        this.ct();
    }

    final void bw() {
        if (this.var_byte_K == 0) {
            this.var_byte_R = 0;
        } else if (this.var_byte_L + 1 >= this.var_byte_arr_arr_a[8].length) {
            this.cC();
        } else {
            this.var_byte_F = this.var_byte_L = (byte)(this.var_byte_L + 1);
            this.var_byte_G = this.var_byte_M;
            if (this.var_byte_E <= this.var_byte_L) {
                this.var_byte_E = (byte)(this.var_byte_L + 1);
            }
            this.dS();
            this.var_byte_R = (byte)10;
            this.var_byte_arr_w[10] = this.var_byte_arr_n[this.var_byte_L];
        }
        this.ct();
    }

    final void bx() {
        if (this.var_byte_R == 1) {
            if (this.var_boolean_k) {
                this.var_byte_R = 0;
                this.ct();
                return;
            }
            this.var_byte_T = 0;
            this.var_byte_S = this.var_byte_R;
            this.var_byte_R = (byte)5;
            this.var_byte_aA = (byte)17;
            this.cu();
        }
    }

    final void by() {
        this.var_byte_M = (byte)(this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] - 8);
        if (this.var_byte_K == 0) {
            this.var_byte_R = (byte)10;
            this.var_byte_arr_w[10] = this.var_byte_arr_arr_a[7][this.var_byte_N];
            this.ct();
            return;
        }
        this.var_byte_R = (byte)8;
        this.var_byte_arr_v[8] = this.var_byte_E;
        this.ct();
        this.var_byte_P = (byte)(this.var_byte_arr_v[8] - 1);
    }

    final void bz() {
        this.var_byte_L = this.var_byte_P;
        this.var_byte_F = this.var_byte_P;
        this.var_byte_G = this.var_byte_M;
        this.dS();
        if (this.var_byte_L == 0) {
            this.var_byte_az = 0;
            this.void_g();
            this.var_byte_aa = (byte)5;
            this.var_byte_b = 0;
            return;
        }
        this.var_byte_R = (byte)10;
        this.var_byte_arr_w[10] = this.var_byte_arr_n[this.var_byte_L];
        this.ct();
    }

    final void bA() {
        if (this.var_byte_K == 1) {
            this.var_byte_T = (byte)17;
            this.var_byte_S = this.var_byte_R;
            this.var_byte_R = (byte)5;
            this.var_byte_aA = (byte)14;
            this.cu();
            return;
        }
        this.var_byte_R = (byte)7;
        this.ct();
    }

    final void bB() {
        this.var_byte_K = this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P];
        this.var_byte_L = 0;
        this.var_byte_R = this.var_byte_K == 0 && this.var_byte_J != -1 || this.var_byte_K == 1 && this.var_byte_F != -1 ? (byte)6 : (this.var_byte_K == 1 ? (byte)17 : (byte)7);
        this.ct();
    }

    final void bC() {
        this.var_byte_az = 0;
        this.var_byte_b = 0;
        if (this.var_byte_R == 18) {
            this.var_boolean_arr_c[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] = this.var_boolean_l;
            this.var_byte_arr_al[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]] = this.var_byte_arr_y[2];
            this.var_int_o = this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]];
            this.cH();
            if (!this.var_boolean_l && this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] != 22) {
                this.var_byte_ax = this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]];
                this.d(true);
            }
        } else {
            this.bD();
        }
        this.var_byte_aa = (byte)5;
    }

    final void bD() {
        if (this.var_byte_R == 19) {
            this.var_byte_arr_aE[this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_byte_an]] = this.var_byte_arr_y[1];
            this.var_int_o = this.var_byte_an;
            this.cI();
        }
        if (this.var_boolean_m) {
            this.var_byte_C = this.var_byte_arr_aI[this.var_short_arr_h[56] + this.var_byte_an];
            this.var_byte_B = (byte)3;
            if (this.var_byte_R == 21) {
                if (!this.var_boolean_arr_a[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]) {
                    this.ci();
                }
            } else if (!this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]) {
                this.ci();
            }
        } else if (this.var_byte_R == 21) {
            if (this.var_boolean_arr_a[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]) {
                this.cl();
            }
        } else {
            if (this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]) {
                this.cl();
            }
            if (this.var_byte_R == 22) {
                this.bL();
            }
        }
        if (this.var_byte_R == 21) {
            this.var_byte_arr_aE[this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_byte_an]] = this.var_byte_arr_y[0];
            this.var_int_o = 23;
            this.cH();
            this.var_boolean_arr_c[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] = this.var_boolean_l;
        }
    }

    final void bE() {
        if (this.var_int_k < this.var_int_i) {
            this.var_byte_h = 0;
        }
        if (this.var_int_k - -500 >= this.var_int_i) {
            this.var_int_k -= this.var_int_i;
            this.var_int_e += this.var_int_i;
            this.var_byte_arr_aT[0] = (byte)this.var_int_arr_a[0];
            this.var_byte_arr_aT[1] = (byte)this.var_int_arr_a[1];
            this.var_short_h = (short)(b.B[0] / 2);
            this.var_short_i = 0;
            this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
            this.var_java_lang_StringBuffer_a.append("-");
            this.var_java_lang_StringBuffer_a.append(this.var_int_i);
            this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
            this.dL();
            this.cl();
            this.var_byte_aa = (byte)5;
            if (this.var_byte_U > 1) {
                this.var_boolean_m = false;
                this.var_byte_R = this.var_byte_U == 2 ? (byte)21 : (this.var_byte_U == 5 ? (byte)22 : (byte)19);
                if (this.var_byte_R == 19) {
                    this.var_byte_arr_x[0] = 0;
                } else if (this.var_byte_R == 21) {
                    this.var_byte_arr_x[0] = 2;
                }
                if (this.var_byte_R == 21) {
                    this.var_byte_arr_y[0] = this.var_byte_arr_aE[this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_byte_an]];
                } else if (this.var_byte_R == 19) {
                    this.var_byte_arr_y[0] = this.var_byte_arr_aI[this.var_short_arr_h[29] + this.var_byte_an * (this.var_byte_ad + 1) + this.var_byte_ad];
                }
                this.cu();
                return;
            }
            this.var_byte_az = 0;
            this.var_byte_b = 0;
        }
    }

    final void bF() {
        if (this.var_byte_R == 17 || this.var_byte_R == 6 || this.var_byte_R == 7 || this.var_byte_R == 8 || this.var_byte_R == 14 || this.var_byte_R == 15) {
            if (this.var_byte_R == 15) {
                this.var_byte_aJ = 0;
            }
            this.var_byte_R = 0;
            this.ct();
            return;
        }
        if (this.var_byte_R == 1) {
            this.var_byte_az = 0;
            this.var_byte_b = 0;
            this.var_byte_aa = (byte)5;
            return;
        }
        if (this.var_byte_R == 5 && this.var_byte_aA != 18 && this.var_byte_aA != 19) {
            this.var_byte_R = this.var_byte_S;
            this.cu();
            return;
        }
        if (this.var_byte_R == 20) {
            this.bG();
            return;
        }
        if ((this.var_byte_R == 18 || this.var_byte_R == 19 || this.var_byte_R == 22 || this.var_byte_R == 21) && this.var_boolean_o) {
            this.var_byte_az = 0;
            this.var_byte_b = 0;
            this.var_byte_aa = (byte)5;
            this.var_boolean_o = false;
            return;
        }
        if (this.var_byte_R == 0) {
            this.var_byte_S = this.var_byte_R;
            this.var_byte_R = (byte)5;
            this.var_byte_aA = (byte)22;
            this.cu();
        }
    }

    final void bG() {
        this.var_byte_aa = (byte)5;
        if (this.var_byte_U > 1) {
            this.var_byte_R = this.var_byte_U == 2 ? (byte)21 : (this.var_byte_U == 5 ? (byte)22 : (byte)19);
            if (this.var_byte_R == 19) {
                this.var_byte_arr_x[0] = 0;
            } else if (this.var_byte_R == 21) {
                this.var_byte_arr_x[0] = 2;
            }
            if (this.var_byte_R == 21) {
                this.var_byte_arr_y[0] = this.var_byte_arr_aE[this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_byte_an]];
            } else if (this.var_byte_R == 19) {
                this.var_byte_arr_y[0] = this.var_byte_arr_aI[this.var_short_arr_h[29] + this.var_byte_an * (this.var_byte_ad + 1) + this.var_byte_ad];
            }
            this.cu();
            return;
        }
        this.var_byte_az = 0;
        this.var_byte_b = 0;
    }

    final void bH() {
        switch (this.var_int_n) {
            case 3: {
                if (this.var_byte_aN >= 2 || this.var_int_arr_m[this.var_byte_aN + 1] >= this.var_int_arr_m[this.var_byte_aN]) break;
                this.var_byte_aN = (byte)(this.var_byte_aN + 1);
                return;
            }
            case 4: {
                if (this.var_byte_aN <= 0 || this.var_int_arr_m[this.var_byte_aN - 1] <= this.var_int_arr_m[this.var_byte_aN]) break;
                this.var_byte_aN = (byte)(this.var_byte_aN - 1);
                return;
            }
            case -6: 
            case 5: {
                this.var_byte_b = 0;
                this.var_byte_aa = (byte)5;
            }
        }
    }

    final void bI() {
        switch (this.var_int_n) {
            case 1: {
                if (this.var_int_F > 0) {
                    this.var_int_F -= d.var_byte_arr_j[this.var_byte_aC];
                }
                if (this.var_int_F >= 0) break;
                this.var_int_F = 0;
                return;
            }
            case 2: {
                if (this.var_int_G <= this.var_int_F + d.var_byte_arr_j[this.var_byte_aC]) break;
                this.var_int_F += d.var_byte_arr_j[this.var_byte_aC];
                return;
            }
            case -6: 
            case 5: {
                this.var_byte_b = 0;
                this.var_byte_aa = (byte)5;
            }
        }
    }

    final void bJ() {
        if (this.var_int_arr_a[0] > 0) {
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]] == 7) {
                this.var_int_ap = this.var_byte_arr_arr_c[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]];
                this.bO();
            } else if (this.var_byte_arr_arr_b[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]] <= -15 && this.var_byte_arr_arr_b[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]] >= -27) {
                this.var_byte_aw = this.var_byte_arr_arr_c[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]];
                this.var_int_arr_a[0] = this.var_int_arr_a[0] - 1;
                this.bN();
                this.var_int_arr_a[0] = this.var_int_arr_a[0] + 1;
            }
        }
        if (this.var_int_arr_a[1] < this.var_byte_O - 1) {
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1] == 8) {
                this.var_int_ap = this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1];
                this.bO();
                return;
            }
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1] <= -15 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1] >= -27) {
                this.var_byte_aw = this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1];
                this.var_int_arr_a[1] = this.var_int_arr_a[1] + 1;
                this.bN();
                this.var_int_arr_a[1] = this.var_int_arr_a[1] - 1;
            }
        }
    }

    final void bK() {
        this.var_int_ao = 0;
        while (this.var_int_ao < 42) {
            if (this.var_byte_arr_arr_l[0][this.var_int_ao] >= 0 && this.var_byte_arr_Z[this.var_int_ao] == 22) {
                this.var_int_ap = this.var_int_ao;
                this.bO();
            }
            ++this.var_int_ao;
        }
    }

    final void bL() {
        this.var_int_ao = 0;
        while (this.var_int_ao < 42) {
            if (this.var_byte_arr_arr_l[0][this.var_int_ao] >= 0) {
                if (this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_ao]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_ao]][4] + 3] == 1) {
                    this.var_int_ap = this.var_int_ao;
                    this.bM();
                } else {
                    this.var_boolean_arr_b[this.var_int_ao] = true;
                }
            }
            ++this.var_int_ao;
        }
    }

    final void bM() {
        try {
            this.var_boolean_arr_b[this.var_int_ap] = false;
            this.var_int_an = 0;
            while (this.var_int_an < 15) {
                if (this.var_byte_arr_arr_k[this.var_int_an][0] >= 0 && this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_byte_arr_arr_k[this.var_int_an][0]][this.var_byte_arr_arr_k[this.var_int_an][1]]]) {
                    this.var_boolean_arr_b[this.var_int_ap] = true;
                    if (this.var_byte_arr_arr_k[this.var_int_an][0] - b.var_byte_arr_arr_i[0][0] >= this.var_byte_arr_arr_l[0][this.var_int_ap] + this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_ap]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_ap]][0] + 0] || this.var_byte_arr_arr_k[this.var_int_an][1] - b.var_byte_arr_arr_i[1][0] >= this.var_byte_arr_arr_l[1][this.var_int_ap] + this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_ap]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_ap]][0] + 1] || this.var_byte_arr_arr_k[this.var_int_an][0] + b.var_byte_arr_arr_i[0][1] < this.var_byte_arr_arr_l[0][this.var_int_ap] || this.var_byte_arr_arr_k[this.var_int_an][1] + b.var_byte_arr_arr_i[1][1] < this.var_byte_arr_arr_l[1][this.var_int_ap]) {
                        this.var_boolean_arr_b[this.var_int_ap] = false;
                    }
                    if (this.var_boolean_arr_b[this.var_int_ap]) break;
                }
                ++this.var_int_an;
            }
            if (!this.var_boolean_arr_b[this.var_int_ap]) {
                this.var_byte_ax = (byte)this.var_int_ap;
                this.d(true);
                if (this.var_byte_arr_ag[this.var_int_ap] == 3) {
                    this.var_byte_arr_aj[this.var_int_ap] = this.var_byte_arr_af[this.var_int_ap] < this.var_byte_arr_av[this.var_byte_arr_Z[this.var_int_ap]] ? (byte)0 : 1;
                }
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void bN() {
        this.var_boolean_arr_f[this.var_byte_aw] = false;
        if (this.var_byte_arr_aI[this.var_short_arr_h[163] - 1 - this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] == 1 || this.var_byte_arr_aI[this.var_short_arr_h[164] - 1 - this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] == 1) {
            this.var_boolean_arr_f[this.var_byte_aw] = true;
            if (this.var_int_arr_a[0] < this.var_byte_O - 1 && this.var_byte_arr_aI[this.var_short_arr_h[163] - 1 - this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] == 1 && this.var_byte_arr_arr_b[this.var_int_arr_a[0] + 1][this.var_int_arr_a[1]] == 0) {
                this.var_boolean_arr_f[this.var_byte_aw] = false;
            }
            if (this.var_int_arr_a[1] > 0 && this.var_byte_arr_aI[this.var_short_arr_h[164] - 1 - this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] == 1 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] - 1] == 0) {
                this.var_boolean_arr_f[this.var_byte_aw] = false;
            }
        }
    }

    final void bO() {
        if (this.var_byte_arr_Z[this.var_int_ap] != 22) {
            this.var_boolean_arr_a[this.var_int_ap] = false;
            if (this.var_byte_arr_aa[this.var_int_ap] == 0) {
                if (this.var_byte_arr_arr_b[this.var_byte_arr_arr_n[0][this.var_int_ap]][this.var_byte_arr_arr_n[1][this.var_int_ap] - 1] == 0) {
                    this.var_boolean_arr_a[this.var_int_ap] = true;
                    return;
                }
            } else if (this.var_byte_arr_arr_b[this.var_byte_arr_arr_n[0][this.var_int_ap] + 1][this.var_byte_arr_arr_n[1][this.var_int_ap]] == 0) {
                this.var_boolean_arr_a[this.var_int_ap] = true;
                return;
            }
        } else {
            this.var_boolean_arr_a[this.var_int_ap] = false;
            if (this.var_byte_arr_arr_m[0][this.var_int_ap] == 0) {
                return;
            }
            this.var_int_arr_o[0] = this.var_byte_arr_arr_l[0][this.var_int_ap];
            this.var_int_arr_o[1] = this.var_byte_arr_arr_l[1][this.var_int_ap];
            if (this.var_byte_arr_arr_b[this.var_int_arr_o[0]][this.var_int_arr_o[1]] != 13) {
                this.var_int_arr_o[1] = this.var_int_arr_o[1] + 1;
            }
            this.var_byte_arr_ad[this.var_int_ap] = 1;
            this.var_int_arr_p[0] = -1;
            this.bP();
            int n = this.var_int_ap;
            this.var_byte_arr_ad[n] = (byte)(this.var_byte_arr_ad[n] + 5);
        }
    }

    final void bP() {
        do {
            this.var_int_an = 0;
            while (this.var_int_an < 4) {
                if (this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0] < this.var_byte_O && this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1] < this.var_byte_O && this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0] >= 0 && this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1] >= 0) {
                    if (this.var_byte_arr_arr_b[this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0]][this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1]] == 7 && this.var_int_an == 1 || this.var_byte_arr_arr_b[this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0]][this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1]] == 8 && this.var_int_an == 0) {
                        if (this.var_byte_arr_arr_m[0][this.var_byte_arr_arr_c[this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0]][this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1]]] == 0) {
                            this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0]][this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1]]] = -1;
                            this.var_byte_ai = (byte)(this.var_byte_ai - 1);
                        } else {
                            this.var_byte_arr_arr_m[1][this.var_byte_arr_arr_c[this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0]][this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1]]] = 0;
                        }
                        this.var_byte_arr_arr_c[this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0]][this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1]] = (byte)this.var_int_ap;
                        this.var_byte_arr_arr_m[1][this.var_int_ap] = 1;
                        if (this.var_byte_arr_arr_b[this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0] * 2][this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1] * 2] == 0) {
                            this.var_boolean_arr_a[this.var_int_ap] = true;
                        }
                        this.var_int_an = 4;
                        break;
                    }
                    if (this.var_byte_arr_arr_b[this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0]][this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1]] == 13 && (this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0] != this.var_int_arr_p[0] || this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1] != this.var_int_arr_p[1])) {
                        this.var_int_arr_p[0] = this.var_int_arr_o[0];
                        this.var_int_arr_p[1] = this.var_int_arr_o[1];
                        this.var_int_arr_o[0] = this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0];
                        this.var_int_arr_o[1] = this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1];
                        this.var_byte_arr_arr_c[this.var_int_arr_o[0]][this.var_int_arr_o[1]] = (byte)this.var_int_ap;
                        if (this.var_byte_arr_ad[this.var_int_ap] >= 20) break;
                        int n = this.var_int_ap;
                        this.var_byte_arr_ad[n] = (byte)(this.var_byte_arr_ad[n] + 1);
                        break;
                    }
                }
                ++this.var_int_an;
            }
            if (this.var_int_an != 4) continue;
            return;
        } while (!this.var_boolean_arr_a[this.var_int_ap]);
    }

    /*
     * Enabled aggressive block sorting
     */
    final void bQ() {
        block15: {
            this.var_boolean_h = true;
            this.var_byte_aA = (byte)5;
            this.var_short_e = (short)-1;
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] > 3 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] <= 13) {
                this.bR();
                if (this.var_byte_ar != 22) {
                    if (this.var_byte_arr_ac[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] > 0) {
                        this.var_boolean_h = false;
                        return;
                    }
                    break block15;
                } else {
                    this.var_boolean_i = false;
                    if (this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] < 0) {
                        return;
                    }
                    if (this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] != 22 || !this.var_boolean_arr_a[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]) return;
                    this.bS();
                    return;
                }
            }
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 0) {
                this.bU();
                return;
            }
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] >= 0) return;
            this.bV();
            return;
        }
        this.var_int_aq = this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]];
        while (this.var_int_aq < this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] + this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]][0] + 0]) {
            this.var_int_ar = this.var_byte_arr_arr_l[1][this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]];
            while (this.var_int_ar < this.var_byte_arr_arr_l[1][this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] + this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]][0] + 1]) {
                if (this.var_short_arr_arr_c[this.var_int_aq][this.var_int_ar] != -1 && this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]][37] + (this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] * this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]][0] + 0] + this.var_int_aq - this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]) * this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]][0] + 1] + this.var_int_ar - this.var_byte_arr_arr_l[1][this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]] != 1) {
                    if (this.var_byte_ar == 23 && this.var_byte_arr_A[this.var_short_arr_arr_c[this.var_int_aq][this.var_int_ar]] == 10 && this.var_short_arr_d[this.var_short_arr_arr_c[this.var_int_aq][this.var_int_ar]] == -1) {
                        this.var_short_e = this.var_short_arr_arr_c[this.var_int_aq][this.var_int_ar];
                    } else {
                        this.var_boolean_h = false;
                        return;
                    }
                }
                ++this.var_int_ar;
            }
            ++this.var_int_aq;
        }
        return;
    }

    final void bR() {
        this.var_byte_ar = (byte)-1;
        if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 13) {
            this.var_byte_ar = (byte)22;
        }
        if ((this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 5 || this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 7) && this.var_byte_arr_arr_b[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]] == 13) {
            this.var_byte_ar = (byte)22;
        }
        if ((this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 6 || this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 8) && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1] == 13) {
            this.var_byte_ar = (byte)22;
        }
        if (this.var_byte_ar == -1) {
            this.var_byte_ar = this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]];
        }
    }

    final void bS() {
        this.var_int_arr_o[0] = this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]];
        this.var_int_arr_o[1] = this.var_byte_arr_arr_l[1][this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]];
        if (this.var_byte_arr_arr_b[this.var_int_arr_o[0]][this.var_int_arr_o[1]] != 13) {
            if (this.var_short_arr_arr_c[this.var_int_arr_o[0]][this.var_int_arr_o[1]] != -1) {
                this.var_boolean_h = false;
            }
            if (this.var_int_arr_o[0] == this.var_int_arr_a[0] && this.var_int_arr_o[1] == this.var_int_arr_a[1]) {
                this.var_boolean_i = true;
            }
            this.var_int_arr_o[1] = this.var_int_arr_o[1] + 1;
        } else {
            if (this.var_short_arr_arr_c[this.var_int_arr_o[0] + 1][this.var_int_arr_o[1]] != -1) {
                this.var_boolean_h = false;
            }
            if (this.var_int_arr_o[0] + 1 == this.var_int_arr_a[0] && this.var_int_arr_o[1] == this.var_int_arr_a[1]) {
                this.var_boolean_i = true;
            }
        }
        this.var_int_arr_p[0] = -1;
        this.bT();
    }

    final void bT() {
        block0: do {
            if (this.var_short_arr_arr_c[this.var_int_arr_o[0]][this.var_int_arr_o[1]] != -1) {
                this.var_boolean_h = false;
            }
            if (this.var_int_arr_o[0] == this.var_int_arr_a[0] && this.var_int_arr_o[1] == this.var_int_arr_a[1]) {
                this.var_boolean_i = true;
            }
            this.var_int_an = 0;
            while (this.var_int_an < 4) {
                if (this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0] < this.var_byte_O && this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1] < this.var_byte_O && this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0] >= 0 && this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1] >= 0) {
                    if (this.var_byte_arr_arr_b[this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0]][this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1]] == 7 && this.var_int_an == 1 || this.var_byte_arr_arr_b[this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0]][this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1]] == 8 && this.var_int_an == 0) {
                        if (this.var_short_arr_arr_c[this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0]][this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1]] != -1) {
                            this.var_boolean_h = false;
                        }
                        if (this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0] == this.var_int_arr_a[0] && this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1] == this.var_int_arr_a[1]) {
                            this.var_boolean_i = true;
                        }
                        this.var_int_an = 4;
                        continue block0;
                    }
                    if (this.var_byte_arr_arr_b[this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0]][this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1]] == 13 && (this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0] != this.var_int_arr_p[0] || this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1] != this.var_int_arr_p[1])) {
                        this.var_int_arr_p[0] = this.var_int_arr_o[0];
                        this.var_int_arr_p[1] = this.var_int_arr_o[1];
                        this.var_int_arr_o[0] = this.var_int_arr_o[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 0];
                        this.var_int_arr_o[1] = this.var_int_arr_o[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_an * 2 + 1];
                        continue block0;
                    }
                }
                ++this.var_int_an;
            }
        } while (this.var_int_an != 4);
        if (!this.var_boolean_i) {
            this.var_boolean_h = true;
        }
    }

    final void bU() {
        if (this.var_short_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] != -1) {
            this.var_boolean_h = false;
        }
        if (this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] % 4 == 0) {
            if (this.var_int_arr_a[0] > 0 && (this.var_byte_arr_arr_b[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]] == 5 || this.var_byte_arr_arr_b[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]] == 7)) {
                this.var_int_arr_a[0] = this.var_int_arr_a[0] - 1;
                this.bQ();
                this.var_int_arr_a[0] = this.var_int_arr_a[0] + 1;
            }
            if (this.var_int_arr_a[1] < this.var_byte_O - 1 && (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1] == 6 || this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1] == 8)) {
                this.var_int_arr_a[1] = this.var_int_arr_a[1] + 1;
                this.bQ();
                this.var_int_arr_a[1] = this.var_int_arr_a[1] - 1;
            }
            if (this.var_int_arr_a[0] == this.var_byte_ab && this.var_int_arr_a[1] == 0) {
                this.var_byte_aA = (byte)8;
                this.var_boolean_h = false;
            }
        }
    }

    final void bV() {
        this.var_int_aq = 0;
        while (this.var_int_aq < 2) {
            if (!(this.var_int_aq == 0 && this.var_int_arr_a[0] >= this.var_byte_O - 1 || this.var_int_aq == 1 && this.var_int_arr_a[1] <= 0 || this.var_byte_arr_aI[this.var_short_arr_h[163 + this.var_int_aq] - 1 - this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] == 0)) {
                this.var_int_ar = this.var_short_arr_arr_c[this.var_int_arr_a[0] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_aI[this.var_short_arr_h[103] + this.var_int_aq] * 4 + 2] * 2 + 0]][this.var_int_arr_a[1] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_aI[this.var_short_arr_h[103] + this.var_int_aq] * 4 + 2] * 2 + 1]];
                while (this.var_int_ar >= 0) {
                    if (this.var_int_ar < 200 && this.var_byte_arr_W[this.var_int_ar] == this.var_byte_arr_aI[this.var_short_arr_h[53] + -1 - this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] && this.var_byte_arr_arr_h[2][this.var_int_ar] == this.var_int_aq && this.var_byte_arr_arr_h[0][this.var_int_ar] < 2) {
                        this.var_boolean_h = false;
                        if (this.var_byte_arr_arr_h[0][this.var_int_ar] != 0) break;
                        this.var_byte_aA = (byte)10;
                        break;
                    }
                    this.var_int_ar = this.var_short_arr_d[this.var_int_ar];
                }
                if (!this.var_boolean_h) break;
            }
            ++this.var_int_aq;
        }
        if (this.var_byte_arr_aI[this.var_short_arr_h[56] + -1 - this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] != -1 && this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]) {
            this.var_short_e = 0;
        }
    }

    final void bW() {
        if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] > 3 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] <= 13) {
            if (this.var_short_e != -1) {
                this.var_byte_ac = (byte)(this.var_byte_ac - 1);
                this.var_int_ay = this.var_short_e;
                this.dp();
                this.var_byte_arr_B[this.var_short_e] = -1;
            }
            if (this.var_byte_ar != 22) {
                this.bZ();
            } else {
                this.bX();
            }
            this.var_byte_aa = (byte)5;
            return;
        }
        if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 0) {
            if (this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] % 4 != 0) {
                byte[] byArray = this.var_byte_arr_arr_c[this.var_int_arr_a[0]];
                int n = this.var_int_arr_a[1];
                byArray[n] = (byte)(byArray[n] - this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] % 4);
                return;
            }
            this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3 + 1);
            this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] = 0;
            this.bJ();
            this.var_byte_aa = (byte)5;
            return;
        }
        if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] < 0) {
            this.bY();
        }
    }

    final void bX() {
        if (this.var_boolean_i) {
            this.var_boolean_arr_a[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] = false;
        }
        if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 5 || this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 7) {
            this.var_byte_arr_arr_b[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3 + 1);
            this.var_byte_arr_arr_c[this.var_int_arr_a[0] - 1][this.var_int_arr_a[1]] = 0;
            this.var_int_at = this.var_int_arr_a[0];
            this.var_int_au = this.var_int_arr_a[1];
            this.ca();
        } else if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 6 || this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 8) {
            this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3 + 1);
            this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1] + 1] = 0;
            this.var_int_at = this.var_int_arr_a[0];
            this.var_int_au = this.var_int_arr_a[1];
            this.ca();
        } else {
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 13 && this.var_int_arr_a[0] < this.var_byte_O - 1 && (this.var_byte_arr_arr_b[this.var_int_arr_a[0] + 1][this.var_int_arr_a[1]] == 5 || this.var_byte_arr_arr_b[this.var_int_arr_a[0] + 1][this.var_int_arr_a[1]] == 7)) {
                this.var_int_at = this.var_int_arr_a[0] + 1;
                this.var_int_au = this.var_int_arr_a[1];
                this.ca();
                this.var_byte_arr_arr_b[this.var_int_arr_a[0] + 1][this.var_int_arr_a[1]] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3 + 1);
                this.var_byte_arr_arr_c[this.var_int_arr_a[0] + 1][this.var_int_arr_a[1]] = 0;
            }
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == 13 && this.var_int_arr_a[1] > 0 && (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] - 1] == 6 || this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] - 1] == 8)) {
                this.var_int_at = this.var_int_arr_a[0];
                this.var_int_au = this.var_int_arr_a[1] - 1;
                this.ca();
                this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] - 1] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3 + 1);
                this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1] - 1] = 0;
            }
        }
        this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3 + 1);
        this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] = 0;
    }

    final void bY() {
        if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] <= -15) {
            this.var_byte_arr_ak[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] = -1;
            this.var_byte_ak = (byte)(this.var_byte_ak - 1);
        }
        if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] <= -27) {
            this.var_int_as = 0;
            while (this.var_int_as < 15) {
                if (!(this.var_int_arr_a[0] != this.var_byte_arr_arr_k[this.var_int_as][0] && this.var_int_arr_a[0] - 1 != this.var_byte_arr_arr_k[this.var_int_as][0] || this.var_int_arr_a[1] != this.var_byte_arr_arr_k[this.var_int_as][1] && this.var_int_arr_a[1] - 1 != this.var_byte_arr_arr_k[this.var_int_as][1] || this.var_byte_arr_arr_k[this.var_int_as][0] < 0)) {
                    this.var_int_aq = this.var_byte_arr_arr_k[this.var_int_as][0];
                    while (this.var_int_aq < this.var_byte_arr_arr_k[this.var_int_as][0] + 2) {
                        this.var_int_ar = this.var_byte_arr_arr_k[this.var_int_as][1];
                        while (this.var_int_ar < this.var_byte_arr_arr_k[this.var_int_as][1] + 2) {
                            this.var_byte_arr_arr_b[this.var_int_aq][this.var_int_ar] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3 + 1);
                            this.var_byte_arr_arr_c[this.var_int_aq][this.var_int_ar] = 0;
                            ++this.var_int_ar;
                        }
                        ++this.var_int_aq;
                    }
                    this.var_byte_arr_arr_k[this.var_int_as][0] = -1;
                    this.var_byte_ah = (byte)(this.var_byte_ah - 1);
                    break;
                }
                ++this.var_int_as;
            }
            this.bL();
        } else {
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == -14) {
                this.var_int_as = 0;
                while (this.var_int_as < 30) {
                    if (this.var_byte_arr_arr_i[this.var_int_as][0] == this.var_int_arr_a[0] && this.var_byte_arr_arr_i[this.var_int_as][1] == this.var_int_arr_a[1]) {
                        this.var_byte_arr_arr_i[this.var_int_as][0] = -1;
                        this.var_byte_ag = (byte)(this.var_byte_ag - 1);
                        break;
                    }
                    ++this.var_int_as;
                }
            }
            this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3 + 1);
            this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] = 0;
        }
        this.var_byte_aa = (byte)5;
    }

    final void bZ() {
        this.var_short_e = this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]];
        this.var_byte_ai = (byte)(this.var_byte_ai - 1);
        this.var_int_aq = this.var_byte_arr_arr_l[0][this.var_short_e];
        while (this.var_int_aq < this.var_byte_arr_arr_l[0][this.var_short_e] + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 0]) {
            this.var_int_ar = this.var_byte_arr_arr_l[1][this.var_short_e];
            while (this.var_int_ar < this.var_byte_arr_arr_l[1][this.var_short_e] + this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 1]) {
                if (this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][37] + (this.var_byte_arr_aa[this.var_short_e] * this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 0] + this.var_int_aq - this.var_byte_arr_arr_l[0][this.var_short_e]) * this.var_byte_arr_arr_o[this.var_byte_ar][this.var_short_arr_arr_g[this.var_byte_ar][0] + 1] + this.var_int_ar - this.var_byte_arr_arr_l[1][this.var_short_e]] != 1) {
                    this.var_byte_arr_arr_b[this.var_int_aq][this.var_int_ar] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3 + 1);
                    this.var_byte_arr_arr_c[this.var_int_aq][this.var_int_ar] = 0;
                }
                ++this.var_int_ar;
            }
            ++this.var_int_aq;
        }
        this.dx();
        this.var_byte_arr_arr_l[0][this.var_short_e] = -1;
    }

    final void ca() {
        if (this.var_byte_arr_arr_b[this.var_int_at][this.var_int_au] == 5 || this.var_byte_arr_arr_b[this.var_int_at][this.var_int_au] == 6) {
            this.var_byte_arr_arr_m[0][this.var_byte_arr_arr_c[this.var_int_at][this.var_int_au]] = 0;
            if (this.var_byte_arr_arr_m[1][this.var_byte_arr_arr_c[this.var_int_at][this.var_int_au]] != 0) {
                this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_int_at][this.var_int_au]] = this.var_byte_arr_arr_n[0][this.var_byte_arr_arr_c[this.var_int_at][this.var_int_au]];
                this.var_byte_arr_arr_l[1][this.var_byte_arr_arr_c[this.var_int_at][this.var_int_au]] = this.var_byte_arr_arr_n[1][this.var_byte_arr_arr_c[this.var_int_at][this.var_int_au]];
            }
        } else {
            this.var_byte_arr_arr_m[1][this.var_byte_arr_arr_c[this.var_int_at][this.var_int_au]] = 0;
        }
        if (this.var_byte_arr_arr_m[0][this.var_byte_arr_arr_c[this.var_int_at][this.var_int_au]] == 0 && this.var_byte_arr_arr_m[1][this.var_byte_arr_arr_c[this.var_int_at][this.var_int_au]] == 0) {
            this.var_byte_ai = (byte)(this.var_byte_ai - 1);
            this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_int_at][this.var_int_au]] = -1;
            this.dx();
        }
    }

    final void cb() {
        if (this.var_byte_aW == 0) {
            this.cc();
            this.cd();
            if (this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_av]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_av]][4] + 3] == 1) {
                this.bM();
            } else {
                this.var_boolean_arr_b[this.var_int_av] = true;
            }
            if (this.var_byte_arr_Z[this.var_int_av] == 23) {
                this.var_byte_arr_ag[this.var_int_av] = 3;
                this.var_boolean_arr_a[this.var_int_av] = false;
            } else if (this.var_byte_arr_aD[this.var_byte_arr_Z[this.var_int_av]] == 0) {
                this.var_byte_arr_aD[this.var_byte_arr_Z[this.var_int_av]] = (byte)(this.var_byte_arr_aA[this.var_byte_arr_Z[this.var_int_av]] / b.au[0]);
                this.var_byte_arr_aD[24] = (byte)(this.var_byte_arr_aD[24] + this.var_byte_arr_aD[this.var_byte_arr_Z[this.var_int_av]]);
            }
            if ((this.var_int_arr_a[0] + this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] - this.var_int_arr_arr_f[0][1]) * (b.B[0] / 2) + this.var_byte_W < 0) {
                this.s();
            }
            this.var_byte_aa = (byte)5;
        } else if (this.var_byte_aW == 1) {
            this.ce();
            this.cf();
        } else if (this.var_byte_aW == 2) {
            byte by = this.var_byte_C;
            this.var_short_arr_e[by] = (short)(this.var_short_arr_e[by] + 1);
            byte by2 = b.j[3];
            this.var_short_arr_e[by2] = (short)(this.var_short_arr_e[by2] + this.var_byte_arr_aI[this.var_short_arr_h[131] + this.var_byte_C]);
            this.ci();
        } else if (this.var_byte_aW == 3) {
            this.cg();
        }
        this.ch();
    }

    final void cc() {
        if (this.var_byte_j < 1 || !this.var_boolean_j) {
            this.var_int_av = 0;
            while (this.var_int_av < 42 && this.var_byte_arr_arr_l[0][this.var_int_av] >= 0) {
                ++this.var_int_av;
            }
            this.var_byte_ai = (byte)(this.var_byte_ai + 1);
            this.var_byte_arr_Z[this.var_int_av] = this.var_byte_aV;
            this.var_byte_arr_aa[this.var_int_av] = this.var_byte_at;
            this.var_byte_arr_arr_l[0][this.var_int_av] = (byte)this.var_int_arr_a[0];
            this.var_byte_arr_arr_l[1][this.var_int_av] = (byte)this.var_int_arr_a[1];
            this.var_byte_arr_ab[this.var_int_av] = 0;
            this.var_byte_arr_ac[this.var_int_av] = 0;
            this.var_byte_arr_ad[this.var_int_av] = 0;
            this.var_byte_arr_ae[this.var_int_av] = this.var_byte_arr_aa[this.var_int_av] == 0 ? (byte)(this.var_byte_arr_arr_l[1][this.var_int_av] + this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_av]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_av]][0] + 1] - 1) : this.var_byte_arr_arr_l[0][this.var_int_av];
            this.var_boolean_j = true;
            this.var_byte_arr_arr_m[0][this.var_int_av] = 0;
            this.var_byte_arr_arr_m[1][this.var_int_av] = 0;
        }
        if (this.var_byte_j >= 0) {
            this.var_int_aw = b.var_byte_arr_arr_arr_a[this.var_byte_at][this.var_byte_j][0];
            return;
        }
        this.var_int_aw = 0;
    }

    final void cd() {
        while (this.var_int_aw < this.var_int_B) {
            this.var_int_ax = this.var_byte_j >= 0 ? b.var_byte_arr_arr_arr_b[this.var_byte_at][this.var_byte_j][0] : 0;
            while (this.var_int_ax < this.var_int_C) {
                if (this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][37] + (this.var_byte_at * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 0] + this.var_int_aw) * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 1] + this.var_int_ax] != 1) {
                    this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_aw][this.var_int_arr_a[1] + this.var_int_ax] = this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][37] + (this.var_byte_at * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 0] + this.var_int_aw) * this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 1] + this.var_int_ax];
                    if (this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_aw][this.var_int_arr_a[1] + this.var_int_ax] == 7 || this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_aw][this.var_int_arr_a[1] + this.var_int_ax] == 8) {
                        this.var_byte_arr_arr_n[0][this.var_int_av] = (byte)(this.var_int_arr_a[0] + this.var_int_aw);
                        this.var_byte_arr_arr_n[1][this.var_int_av] = (byte)(this.var_int_arr_a[1] + this.var_int_ax);
                    }
                    if (this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_aw][this.var_int_arr_a[1] + this.var_int_ax] == 10) {
                        this.var_byte_arr_arr_m[0][this.var_int_av] = (byte)(this.var_int_arr_a[0] + this.var_int_aw);
                        this.var_byte_arr_arr_m[1][this.var_int_av] = (byte)(this.var_int_arr_a[1] + this.var_int_ax);
                    }
                    this.var_byte_arr_arr_c[this.var_int_arr_a[0] + this.var_int_aw][this.var_int_arr_a[1] + this.var_int_ax] = (byte)this.var_int_av;
                }
                ++this.var_int_ax;
            }
            ++this.var_int_aw;
        }
        this.var_byte_arr_ah[this.var_int_av] = 100;
        this.var_byte_arr_ai[this.var_int_av] = 0;
        this.var_byte_arr_aj[this.var_int_av] = -1;
        this.var_byte_arr_ag[this.var_int_av] = 0;
        this.var_boolean_arr_c[this.var_int_av] = true;
        this.var_boolean_arr_a[this.var_int_av] = true;
        this.var_int_ap = this.var_int_av;
        if (this.var_byte_arr_Z[this.var_int_av] != 23 && this.var_byte_arr_Z[this.var_int_av] != 22) {
            this.bO();
        }
        if (this.var_byte_arr_Z[this.var_int_av] == 22) {
            this.var_byte_arr_arr_m[this.var_byte_j][this.var_int_av] = 1;
            this.bK();
        }
    }

    final void ce() {
        if (this.var_byte_au > -15) {
            this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] = this.var_byte_au;
            return;
        }
        this.var_int_av = 0;
        while (this.var_int_av < 90 && this.var_byte_arr_ak[this.var_int_av] >= 0) {
            ++this.var_int_av;
        }
        this.var_int_aw = 0;
        while (this.var_int_aw < this.var_int_B) {
            this.var_int_ax = 0;
            while (this.var_int_ax < this.var_int_C) {
                this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_aw][this.var_int_arr_a[1] + this.var_int_ax] = this.var_byte_au;
                if (this.var_byte_au == -27) {
                    this.var_byte_arr_arr_b[this.var_int_arr_a[0] + this.var_int_aw][this.var_int_arr_a[1] + this.var_int_ax] = b.var_byte_arr_arr_h[this.var_int_aw][this.var_int_ax];
                }
                this.var_byte_arr_arr_c[this.var_int_arr_a[0] + this.var_int_aw][this.var_int_arr_a[1] + this.var_int_ax] = (byte)this.var_int_av;
                ++this.var_int_ax;
            }
            ++this.var_int_aw;
        }
        if (this.var_byte_au != -21 && this.var_byte_au != -22 && this.var_byte_au != -20) {
            this.var_boolean_arr_d[this.var_int_av] = false;
            this.var_boolean_arr_e[this.var_int_av] = true;
        } else {
            this.var_boolean_arr_d[this.var_int_av] = true;
            this.var_boolean_arr_e[this.var_int_av] = false;
        }
        this.var_byte_arr_ak[this.var_int_av] = 0;
        this.var_byte_aw = (byte)this.var_int_av;
        this.bN();
        this.var_byte_ak = (byte)(this.var_byte_ak + 1);
    }

    final void cf() {
        if (this.var_byte_au == -14) {
            this.var_int_av = 0;
            while (this.var_int_av < 30 && this.var_byte_arr_arr_i[this.var_int_av][0] >= 0) {
                ++this.var_int_av;
            }
            this.var_byte_arr_arr_i[this.var_int_av][0] = (byte)this.var_int_arr_a[0];
            this.var_byte_arr_arr_i[this.var_int_av][1] = (byte)this.var_int_arr_a[1];
            this.var_byte_ag = (byte)(this.var_byte_ag + 1);
        }
        if (this.var_byte_au == -27) {
            this.var_int_av = 0;
            while (this.var_int_av < 15 && this.var_byte_arr_arr_k[this.var_int_av][0] >= 0) {
                ++this.var_int_av;
            }
            this.var_byte_arr_arr_k[this.var_int_av][0] = (byte)this.var_int_arr_a[0];
            this.var_byte_arr_arr_k[this.var_int_av][1] = (byte)this.var_int_arr_a[1];
            this.var_byte_ah = (byte)(this.var_byte_ah + 1);
        }
        this.var_byte_aa = (byte)5;
    }

    final void cg() {
        if (this.var_byte_aV == 13) {
            this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] = this.var_byte_aV;
            this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] = -1;
            this.bK();
        } else {
            if (this.var_byte_aV != 2 && this.var_byte_aV != 1 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] != 0) {
                this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] = 0;
            }
            this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] = 0;
            byte[] byArray = this.var_byte_arr_arr_c[this.var_int_arr_a[0]];
            int n = this.var_int_arr_a[1];
            byArray[n] = (byte)(byArray[n] + (this.var_byte_aV + this.var_byte_av));
            this.bJ();
        }
        this.var_byte_aa = (byte)5;
    }

    final void ch() {
        this.dx();
        this.var_byte_arr_aT[0] = (byte)(this.var_int_arr_b[0] + this.var_int_arr_a[0]);
        this.var_byte_arr_aT[1] = (byte)(this.var_int_arr_b[1] + this.var_int_arr_a[1]);
        this.var_short_h = (short)(this.var_int_z / 2);
        this.var_short_i = 0;
        if (this.var_byte_j < 0) {
            this.var_int_k -= this.var_int_i;
            this.var_int_e += this.var_int_i;
            this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
            this.var_java_lang_StringBuffer_a.append("-");
            this.var_java_lang_StringBuffer_a.append(this.var_int_i);
            this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
        } else {
            this.var_int_k -= this.var_int_i / 2;
            this.var_int_e += this.var_int_i / 2;
            this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
            this.var_java_lang_StringBuffer_a.append("-");
            this.var_java_lang_StringBuffer_a.append(this.var_int_i / 2);
            this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
        }
        this.dL();
        if (this.var_byte_aW != 2) {
            this.var_byte_Y = (byte)(this.var_int_arr_a[0] / 5);
            while (this.var_byte_Y <= (byte)((this.var_int_arr_a[0] + this.var_int_B - 1) / 5)) {
                this.var_byte_Z = (byte)(this.var_int_arr_a[1] / 5);
                while (this.var_byte_Z <= (byte)((this.var_int_arr_a[1] + this.var_int_C - 1) / 5)) {
                    this.cG();
                    this.var_byte_Z = (byte)(this.var_byte_Z + 1);
                }
                this.var_byte_Y = (byte)(this.var_byte_Y + 1);
            }
        }
        if (this.var_byte_K == 1 && this.var_byte_L == 0 && this.var_byte_j < 1) {
            this.ck();
        }
    }

    final void ci() {
        if (this.var_byte_C < 3) {
            this.cj();
            this.var_byte_ac = (byte)(this.var_byte_ac + 1);
        } else {
            this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] = true;
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] != -16 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] != -17 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] != -27 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] != -28) {
                this.var_boolean_arr_e[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] = false;
            }
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == -24 || this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == -25) {
                if (this.var_int_arr_a[1] > 0 && this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1] - 1] == 0) {
                    this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] = -25;
                }
                if (this.var_int_arr_a[0] < this.var_byte_O - 1 && this.var_byte_arr_arr_b[this.var_int_arr_a[0] + 1][this.var_int_arr_a[1]] == 0) {
                    this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] = -24;
                }
            }
            if (this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == -27 || this.var_byte_arr_arr_b[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == -28) {
                this.bL();
            }
            this.var_byte_aw = this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]];
            this.bN();
        }
        if (this.var_byte_K == 1 && this.var_byte_L == 0) {
            this.ck();
        }
    }

    final void cj() {
        this.var_int_av = 200;
        while (this.var_int_av < 222 && this.var_byte_arr_B[this.var_int_av] >= 0) {
            ++this.var_int_av;
        }
        this.var_byte_arr_A[this.var_int_av] = (byte)(8 + this.var_byte_C);
        if (this.var_byte_arr_A[this.var_int_av] == 10) {
            this.var_byte_arr_B[this.var_int_av] = (byte)(this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] + this.var_byte_arr_aI[this.var_short_arr_h[78] + 0]);
            this.var_byte_arr_C[this.var_int_av] = (byte)(this.var_byte_arr_arr_l[1][this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] + this.var_byte_arr_aI[this.var_short_arr_h[78] + 1]);
            this.var_byte_arr_F[this.var_int_av] = 1;
            this.var_byte_arr_G[this.var_int_av] = this.var_byte_arr_aI[this.var_short_arr_h[78] + 2];
            this.var_byte_arr_H[this.var_int_av] = this.var_byte_arr_aI[this.var_short_arr_h[78] + 3];
            this.var_int_aw = 0;
            while (this.var_int_aw < 12) {
                this.var_short_arr_arr_e[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]][this.var_int_aw] = -1;
                ++this.var_int_aw;
            }
            this.var_byte_arr_ag[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] = 3;
            this.var_boolean_arr_a[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] = true;
        } else {
            this.var_byte_arr_B[this.var_int_av] = (byte)this.var_int_arr_a[0];
            this.var_byte_arr_C[this.var_int_av] = (byte)this.var_int_arr_a[1];
            this.var_byte_arr_F[this.var_int_av] = 0;
            this.var_byte_arr_G[this.var_int_av] = b.Z[0];
            this.var_byte_arr_H[this.var_int_av] = 18;
        }
        this.var_byte_arr_I[this.var_int_av] = 2;
        this.var_byte_arr_J[this.var_int_av] = 0;
        this.var_byte_arr_W[this.var_int_av] = -1;
        this.var_short_arr_d[this.var_int_av] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_av]][this.var_byte_arr_C[this.var_int_av]];
        this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_av]][this.var_byte_arr_C[this.var_int_av]] = (short)this.var_int_av;
        if (this.var_byte_arr_A[this.var_int_av] != 10) {
            this.var_int_aL = this.var_int_av;
            this.dq();
        }
    }

    final void ck() {
        this.var_int_aw = -1;
        if (this.var_byte_aW < 2) {
            this.var_int_aw = this.var_byte_aV;
        }
        if (this.var_byte_aW == 2) {
            this.var_int_aw = this.var_byte_C;
        }
        if (this.var_byte_aW == 3 && this.var_byte_aV < 10) {
            this.var_int_aw = this.var_byte_aV % 4;
        }
        if (this.var_int_aw >= 0) {
            this.var_int_av = 0;
            while (this.var_int_av < this.var_byte_arr_b.length) {
                if (this.var_byte_arr_aI[this.var_short_arr_h[140] + this.var_int_av] == this.var_byte_aW && (this.var_byte_arr_aI[this.var_short_arr_h[141] + this.var_int_av] == this.var_int_aw || this.var_byte_arr_aI[this.var_short_arr_h[141] + this.var_int_av] == -1) && this.var_byte_arr_b[this.var_int_av] == 0) {
                    this.var_byte_arr_b[this.var_int_av] = 1;
                    return;
                }
                ++this.var_int_av;
            }
        }
    }

    final void cl() {
        if (this.var_byte_U == 2) {
            this.var_boolean_arr_a[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] = false;
            this.var_int_av = 200;
            while (this.var_int_av < 222) {
                if (this.var_byte_arr_B[this.var_int_av] >= 0 && this.var_byte_arr_A[this.var_int_av] == 10 && this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] == this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_av]][this.var_byte_arr_C[this.var_int_av]]) {
                    this.var_byte_ac = (byte)(this.var_byte_ac - 1);
                    this.var_int_ay = this.var_int_av;
                    this.dp();
                    this.var_byte_arr_B[this.var_int_av] = -1;
                    break;
                }
                ++this.var_int_av;
            }
        } else if (this.var_byte_U < 2) {
            this.var_byte_ac = (byte)(this.var_byte_ac - 1);
            this.var_int_ay = this.var_int_j;
            this.dp();
            this.var_byte_arr_B[this.var_int_j] = -1;
        } else {
            this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] = false;
            this.var_boolean_arr_e[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] = true;
        }
        byte by = this.var_byte_U;
        this.var_short_arr_e[by] = (short)(this.var_short_arr_e[by] - 1);
        byte by2 = b.j[3];
        this.var_short_arr_e[by2] = (short)(this.var_short_arr_e[by2] - this.var_byte_arr_aI[this.var_short_arr_h[131] + this.var_byte_U]);
    }

    final void cm() {
        if (this.var_byte_j >= 0 && this.var_byte_j < 2) {
            this.var_byte_j = (byte)(this.var_byte_j + 1);
            if (this.var_byte_j < 2) {
                this.var_int_B = b.var_byte_arr_arr_arr_a[this.var_byte_at][this.var_byte_j][1];
                this.var_int_C = b.var_byte_arr_arr_arr_b[this.var_byte_at][this.var_byte_j][1];
            }
            if (this.var_byte_j == 2) {
                this.var_byte_B = (byte)4;
                this.var_byte_C = (byte)2;
                this.var_byte_aV = this.var_byte_arr_aI[this.var_short_arr_h[151 + this.var_byte_B] + this.var_byte_C];
                this.var_byte_aW = this.var_byte_arr_aI[this.var_short_arr_h[146 + this.var_byte_B] + this.var_byte_C];
                this.var_int_i = this.var_byte_arr_aI[this.var_short_arr_h[133] + this.var_byte_aV];
                this.var_int_B = 1;
                this.var_int_C = 1;
                this.var_int_z = b.B[0];
                this.var_int_A = b.B[1];
                this.var_int_arr_b[0] = 0;
                this.var_int_arr_b[1] = 0;
                this.cn();
                this.var_byte_j = (byte)-1;
            }
            if (this.var_int_arr_a[0] < 0) {
                this.var_int_arr_a[0] = 0;
                this.var_int_q = 0;
                while (this.var_int_q < 4) {
                    int[] nArray = this.var_int_arr_arr_f[this.var_int_q];
                    nArray[0] = nArray[0] + 1;
                    ++this.var_int_q;
                }
            }
            if (this.var_int_arr_a[1] < 0) {
                this.var_int_arr_a[1] = 0;
                this.var_int_q = 0;
                while (this.var_int_q < 4) {
                    int[] nArray = this.var_int_arr_arr_f[this.var_int_q];
                    nArray[1] = nArray[1] + 1;
                    ++this.var_int_q;
                }
            }
            if (this.var_int_arr_a[0] >= this.var_byte_O - 1) {
                this.var_int_arr_a[0] = this.var_byte_O - 2;
                this.var_int_q = 0;
                while (this.var_int_q < 4) {
                    int[] nArray = this.var_int_arr_arr_f[this.var_int_q];
                    nArray[0] = nArray[0] - 1;
                    ++this.var_int_q;
                }
            }
            if (this.var_int_arr_a[1] >= this.var_byte_O - 1) {
                this.var_int_arr_a[1] = this.var_byte_O - 2;
                this.var_int_q = 0;
                while (this.var_int_q < 4) {
                    int[] nArray = this.var_int_arr_arr_f[this.var_int_q];
                    nArray[1] = nArray[1] - 1;
                    ++this.var_int_q;
                }
            }
        } else {
            this.var_boolean_d = false;
        }
    }

    final void cn() {
        if (this.var_int_arr_a[0] + this.var_int_B >= this.var_byte_O) {
            this.var_int_arr_a[0] = (byte)(this.var_byte_O - this.var_int_B);
        }
        if (this.var_int_arr_a[1] + this.var_int_C >= this.var_byte_O) {
            this.var_int_arr_a[1] = (byte)(this.var_byte_O - this.var_int_C);
        }
        this.var_int_az = (this.var_int_arr_a[0] + this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] - this.var_int_arr_arr_f[0][1]) * (b.B[0] / 2) + (this.var_int_z - this.var_int_l) / 2;
        this.var_int_aA = (this.var_int_arr_a[0] - this.var_int_arr_a[1] - this.var_int_arr_arr_f[0][0] + this.var_int_arr_arr_f[0][1]) * (b.B[1] / 2) + (this.var_int_B - this.var_int_C + 2) * (b.B[1] / 2) / 2 - this.var_int_m / 2;
        this.var_int_aB = (this.var_int_aA / (b.B[1] / 2) + this.var_int_az / (b.B[0] / 2)) / 2;
        this.var_int_aC = (this.var_int_az / (b.B[0] / 2) - this.var_int_aA / (b.B[1] / 2)) / 2;
        this.var_int_az = 0;
        while (this.var_int_az < 4) {
            int[] nArray = this.var_int_arr_arr_f[this.var_int_az];
            nArray[0] = nArray[0] + this.var_int_aB;
            int[] nArray2 = this.var_int_arr_arr_f[this.var_int_az];
            nArray2[1] = nArray2[1] + this.var_int_aC;
            ++this.var_int_az;
        }
    }

    final void co() {
        this.cp();
        if (this.var_byte_aA >= 0) {
            if (!this.var_boolean_o) {
                this.var_byte_aa = (byte)5;
            }
            this.var_boolean_o = true;
            this.var_byte_aC = (byte)3;
            this.dH();
            return;
        }
        this.cq();
        this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
        if (this.var_byte_aW == 0) {
            if (this.var_byte_aV != 23) {
                this.var_java_lang_StringBuffer_a.append(this.var_byte_arr_aA[this.var_byte_aV] / 5);
            } else {
                this.var_java_lang_StringBuffer_a.append(b.aq[5]);
            }
        } else if (this.var_byte_aW == 1) {
            if (this.var_byte_aV >= 14) {
                this.var_java_lang_StringBuffer_a.append(this.var_byte_arr_aI[this.var_short_arr_h[29] + this.var_byte_aV * (this.var_byte_ad + 1) + this.var_byte_ad]);
            } else {
                this.var_java_lang_StringBuffer_a.append(this.var_byte_arr_aI[this.var_short_arr_h[29] + this.var_byte_aV * (this.var_byte_ad + 1) + 0]);
            }
        }
        this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
        this.var_short_g = 0;
        this.var_short_h = d.var_short_arr_n[3 + this.var_byte_arr_aI[this.var_short_arr_h[132] + this.var_byte_aW * 2 + 1]];
        this.var_short_i = (short)(105 - (b.var_byte_arr_b[1] - this.var_byte_arr_aI[this.var_short_arr_h[74] + 10]) / 2);
        this.dM();
        this.cs();
    }

    final void cp() {
        this.var_byte_az = 1;
        this.var_byte_aA = (byte)-1;
        switch (this.var_byte_aW) {
            case 0: {
                this.var_short_f = this.var_byte_arr_aI[this.var_short_arr_h[135] + this.var_byte_aV];
                if (this.var_byte_ai < 42) break;
                this.var_byte_aA = 0;
                break;
            }
            case 1: {
                this.var_short_f = this.var_byte_arr_aI[this.var_short_arr_h[136] + this.var_byte_aV];
                if (-1 - this.var_byte_aV <= -15 && this.var_byte_ak >= 90) {
                    this.var_byte_aA = 1;
                }
                if (-1 - this.var_byte_aV == -14 && this.var_byte_ag >= 30) {
                    this.var_byte_aA = (byte)2;
                }
                if (-1 - this.var_byte_aV != -27 || this.var_byte_ah < 15) break;
                this.var_byte_aA = (byte)3;
                break;
            }
            case 2: {
                this.var_short_f = this.var_byte_arr_aI[this.var_short_arr_h[137] + this.var_byte_C];
                if (this.var_byte_C >= 3 || this.var_byte_ac < 22) break;
                this.var_byte_aA = (byte)4;
                break;
            }
            case 3: {
                this.var_short_f = this.var_byte_arr_aI[this.var_short_arr_h[139] + this.var_byte_aV];
            }
        }
        this.var_short_g = 1;
        this.var_short_h = (short)(this.var_int_l / 2);
        this.var_short_i = (short)65;
        this.dK();
    }

    final void cq() {
        if (this.var_boolean_o) {
            this.var_byte_aa = (byte)5;
        }
        this.var_boolean_o = false;
        if (this.var_byte_aW == 2) {
            this.var_short_f = this.var_byte_arr_aI[this.var_short_arr_h[138] + this.var_byte_C];
            this.var_short_g = 1;
            this.var_short_h = (short)(this.var_int_l / 2);
            this.var_short_i = (short)240;
            this.dK();
        }
        switch (this.var_byte_aW) {
            case 0: {
                this.var_int_i = this.var_byte_arr_az[this.var_byte_aV] * 10;
                break;
            }
            case 1: {
                this.var_int_i = this.var_byte_arr_aI[this.var_short_arr_h[58] + this.var_byte_aV];
                break;
            }
            case 2: {
                this.var_int_i = this.var_byte_arr_aI[this.var_short_arr_h[131] + this.var_byte_C];
                break;
            }
            case 3: {
                this.var_int_i = this.var_byte_arr_aI[this.var_short_arr_h[133] + this.var_byte_aV];
            }
        }
        this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
        this.var_java_lang_StringBuffer_a.append(this.var_int_i);
        this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
        this.var_short_g = 0;
        this.var_short_h = d.var_short_arr_n[1 + this.var_byte_arr_aI[this.var_short_arr_h[132] + this.var_byte_aW * 2 + 1]];
        this.var_short_i = (short)(105 - (b.var_byte_arr_b[1] - this.var_byte_arr_aI[this.var_short_arr_h[74] + 10]) / 2);
        this.dM();
        if (this.var_byte_aW == 0) {
            this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
            this.var_java_lang_StringBuffer_a.append(this.var_byte_arr_au[this.var_byte_aV]);
            this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
            this.var_short_g = 0;
            this.var_short_h = d.var_short_arr_n[5 + this.var_byte_arr_aI[this.var_short_arr_h[132] + this.var_byte_aW * 2 + 1]];
            this.var_short_i = (short)(105 - (b.var_byte_arr_b[1] - this.var_byte_arr_aI[this.var_short_arr_h[74] + 10]) / 2);
            this.dM();
        }
    }

    final void cr() {
        if (this.var_byte_aW == 1 && this.var_byte_aV == 26) {
            this.var_int_B = 2;
            this.var_int_C = 2;
        } else {
            this.var_int_B = 1;
            this.var_int_C = 1;
        }
        if (this.var_byte_aW != 2) {
            this.var_int_z = (this.var_int_B + this.var_int_C) * b.B[0] / 2;
            this.var_int_A = (this.var_int_B + this.var_int_C) * b.B[1] / 2;
        } else {
            this.var_int_z = this.var_byte_arr_aI[this.var_short_arr_h[51] + this.var_byte_C];
            this.var_int_A = this.var_byte_arr_aI[this.var_short_arr_h[52] + this.var_byte_C];
        }
        this.var_int_x = 120 - this.var_int_z / 2;
        this.var_int_y = 230 - this.var_int_A / 2;
        if (this.var_byte_aW == 1) {
            this.var_int_y -= (this.var_int_C + 1) % 2 * b.B[1] / 2;
            this.var_int_A += (this.var_int_C + 1) % 2 * b.B[1] / 2;
        }
        this.var_int_arr_b[0] = 0;
        this.var_int_arr_b[1] = 0;
        if (this.var_byte_aW == 1) {
            this.var_int_arr_b[0] = -(this.var_int_C / 2);
            this.var_int_arr_b[1] = this.var_int_C / 2;
        }
    }

    final void cs() {
        if (this.var_byte_aW == 0) {
            this.var_int_B = this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 0];
            this.var_int_C = this.var_byte_arr_arr_o[this.var_byte_aV][this.var_short_arr_arr_g[this.var_byte_aV][0] + 1];
            this.var_int_z = (this.var_int_B + this.var_int_C) * b.B[0] / 2;
            this.var_int_A = (this.var_int_B + this.var_int_C) * b.B[1] / 2;
            this.var_int_x = 120 - this.var_int_z / 2;
            this.var_int_y = d.var_short_arr_o[this.var_byte_aV] - this.var_int_A / 2;
            this.var_int_y -= (this.var_int_C + 1) % 2 * b.B[1] / 2;
            this.var_int_A += (this.var_int_C + 1) % 2 * b.B[1] / 2;
            this.var_int_arr_b[0] = -(this.var_int_C / 2);
            this.var_int_arr_b[1] = this.var_int_C / 2;
            this.var_byte_at = 0;
            return;
        }
        this.cr();
    }

    final void ct() {
        this.var_byte_P = 0;
        this.cu();
    }

    final void cu() {
        this.cv();
        if (this.var_byte_R == 4) {
            this.var_short_f = this.var_byte_arr_l[0];
            this.var_short_i = d.var_short_arr_arr_d[this.var_byte_R][0];
            this.var_short_h = (short)(this.var_int_l / 2 - 6);
            this.var_short_g = 1;
            this.dK();
            int n = this.var_byte_az - 1;
            this.var_int_arr_d[n] = this.var_int_arr_d[n] + 6;
            this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
            this.var_java_lang_StringBuffer_a.append(this.var_byte_aJ);
            this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
            this.var_short_i = d.var_short_arr_arr_d[this.var_byte_R][0];
            this.var_short_h = (short)(this.var_int_l / 2 + this.var_int_arr_d[this.var_byte_az - 1] / 2);
            this.dM();
        }
        this.cw();
        if (this.var_byte_R == 26) {
            switch (this.var_byte_P) {
                case 0: 
                case 1: 
                case 2: 
                case 5: {
                    this.var_int_aD = 0;
                    while (this.var_int_aD < 2) {
                        this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
                        if (this.var_int_aD == 0) {
                            if (this.var_byte_P < 3) {
                                this.var_java_lang_StringBuffer_a.append(this.var_int_arr_arr_d[this.var_byte_P][0]);
                            } else {
                                this.var_java_lang_StringBuffer_a.append(this.var_int_arr_arr_d[3][0]);
                            }
                        } else {
                            this.var_java_lang_StringBuffer_a.append(0);
                        }
                        this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
                        this.var_short_g = 1;
                        this.var_short_h = d.var_short_arr_l[this.var_int_aD];
                        this.var_short_i = d.var_short_arr_m[this.var_int_aD];
                        this.dM();
                        ++this.var_int_aD;
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
        this.var_byte_az = this.var_byte_arr_aI[this.var_short_arr_h[94] + this.var_byte_R];
        if (this.var_byte_R != 2) {
            if (this.var_byte_R != 5) {
                this.var_byte_aA = (byte)-1;
                switch (this.var_byte_R) {
                    case 18: {
                        if (!(this.var_byte_ar != 22 || this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]] >= 0 && this.var_boolean_arr_a[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]])) {
                            this.var_byte_aA = (byte)21;
                            break;
                        }
                        if (!this.var_boolean_arr_b[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]) {
                            this.var_byte_aA = (byte)6;
                            break;
                        }
                        if (!this.var_boolean_arr_a[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]) {
                            this.var_byte_aA = (byte)7;
                            break;
                        }
                        if (this.var_byte_arr_ah[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]] >= 10) break;
                        this.var_byte_aA = (byte)11;
                        break;
                    }
                    case 19: {
                        if (!this.var_boolean_arr_f[this.var_byte_arr_arr_c[this.var_int_arr_a[0]][this.var_int_arr_a[1]]]) break;
                        this.var_byte_aA = (byte)7;
                    }
                }
            }
            if (this.var_byte_aA >= 0) {
                if (this.var_byte_R != 5) {
                    this.var_boolean_o = true;
                }
                this.var_byte_aC = (byte)3;
                this.dH();
            } else {
                this.var_boolean_o = false;
            }
        } else {
            this.var_boolean_o = false;
        }
        this.var_short_g = 1;
    }

    final void cw() {
        this.var_boolean_v = this.var_byte_R == 1 && this.var_byte_K == 0 && this.var_byte_J == -1;
        if (!(this.var_boolean_o || this.var_byte_R == 26 || this.var_byte_arr_v[this.var_byte_R] <= 0 && this.var_byte_R != 14 && this.var_byte_R != 15 && this.var_byte_R != 16 && this.var_byte_R != 12 && this.var_byte_R != 13)) {
            this.var_int_aD = 0;
            while (this.var_int_aD < this.var_byte_arr_arr_a[this.var_byte_R].length) {
                if (!(this.var_byte_arr_arr_a[this.var_byte_R][this.var_int_aD] == 11 || this.var_byte_arr_arr_a[this.var_byte_R][this.var_int_aD] == 12 && this.var_boolean_m || this.var_byte_R == 4 && this.var_int_aD == 0)) {
                    if (this.var_byte_R == 8 && this.var_int_aD >= this.var_byte_E) break;
                    if (!this.var_boolean_v || this.var_byte_arr_arr_a[this.var_byte_R][this.var_int_aD] != 4) {
                        this.var_short_f = this.var_byte_arr_arr_a[this.var_byte_R][this.var_int_aD];
                        if (this.var_byte_arr_arr_a[this.var_byte_R][this.var_int_aD] == 10 && !this.var_boolean_l) {
                            this.var_short_f = (short)(this.var_short_f + 1);
                        }
                        this.var_short_i = this.var_byte_R == 12 || this.var_byte_R == 13 ? (short)((this.var_int_m + b.var_short_arr_arr_c[this.var_byte_R - 12][1]) / 2 + 3) : (this.var_byte_arr_arr_a[this.var_byte_R][this.var_int_aD] == 12 ? d.var_short_arr_p[this.var_byte_R] : (short)(d.var_short_arr_arr_d[this.var_byte_R][0] + d.var_short_arr_arr_d[this.var_byte_R][1] * this.var_int_aD));
                        if (this.var_boolean_v) {
                            this.var_short_i = this.var_int_aD < 1 ? (short)(this.var_short_i + d.var_short_arr_arr_d[this.var_byte_R][1] / 2) : (short)(this.var_short_i - d.var_short_arr_arr_d[this.var_byte_R][1] / 2);
                        }
                        this.var_short_h = (short)(this.var_int_l / 2);
                        this.dK();
                    }
                }
                ++this.var_int_aD;
            }
        }
        if ((this.var_byte_R != 2 || this.var_byte_aA != 29) && this.var_byte_arr_w[this.var_byte_R] != -1) {
            this.var_short_f = this.var_byte_R != 26 ? (short)this.var_byte_arr_w[this.var_byte_R] : (short)this.var_byte_arr_k[this.var_byte_P];
            this.var_short_i = (short)65;
            this.var_short_h = (short)(this.var_int_l / 2);
            this.dK();
        }
        if (!this.var_boolean_o) {
            this.var_int_aD = 0;
            while (this.var_int_aD < this.var_byte_arr_aI[this.var_short_arr_h[92] + this.var_byte_R]) {
                this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
                this.var_java_lang_StringBuffer_a.append(this.var_byte_arr_y[this.var_int_aD]);
                this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
                this.var_short_g = 0;
                this.var_short_h = (short)153;
                this.var_short_i = (short)(d.var_short_arr_arr_e[this.var_byte_R][this.var_int_aD] - b.var_byte_arr_b[0] / 2);
                this.dM();
                ++this.var_int_aD;
            }
        }
    }

    final void cx() {
        this.var_int_aD = 0;
        while (this.var_int_aD < b.j[3] + 1) {
            this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
            this.var_java_lang_StringBuffer_a.append(this.var_short_arr_e[this.var_int_aD]);
            this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
            this.var_short_g = 0;
            this.var_short_h = d.v[this.var_int_aD];
            this.var_short_i = d.w[this.var_int_aD];
            this.dM();
            ++this.var_int_aD;
        }
    }

    final void cy() {
        this.ad();
        this.var_int_aD = 0;
        while (this.var_int_aD < 3) {
            this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
            this.var_java_lang_StringBuffer_a.append(this.var_int_arr_arr_e[this.var_int_aD][0]);
            this.var_java_lang_StringBuffer_a.append("/");
            this.var_java_lang_StringBuffer_a.append(this.var_int_arr_arr_e[this.var_int_aD][1]);
            this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
            this.var_short_g = 0;
            this.var_short_h = (short)70;
            this.var_short_i = (short)(d.z[this.var_int_aD] - b.var_byte_arr_b[0] / 2);
            this.dM();
            ++this.var_int_aD;
        }
    }

    final void cz() {
        if (this.var_byte_R == 23) {
            this.var_int_aD = 0;
            while (this.var_int_aD < 2) {
                this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
                if (this.var_int_aD == 0) {
                    this.var_java_lang_StringBuffer_a.append(this.var_byte_arr_arr_f[2][this.var_int_j]);
                }
                if (this.var_int_aD == 1) {
                    this.var_java_lang_StringBuffer_a.append(this.var_byte_arr_L[this.var_int_j]);
                }
                this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
                this.var_short_g = 0;
                this.var_short_h = (short)(d.x[this.var_int_aD] + 7);
                this.var_short_i = (short)(d.y[this.var_int_aD] - b.var_byte_arr_b[0] / 2);
                this.dM();
                ++this.var_int_aD;
            }
        }
        if (this.var_byte_R == 10) {
            if (this.var_byte_K == 1) {
                this.var_short_f = (byte)(8 + this.var_byte_M);
                this.var_short_i = d.var_short_arr_arr_d[this.var_byte_R][0];
                this.var_short_h = (short)(this.var_int_l / 2);
                this.dK();
                this.var_int_aD = 0;
                while (this.var_int_aD < 3) {
                    this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
                    this.var_java_lang_StringBuffer_a.append(this.var_int_arr_arr_arr_a[this.var_byte_M][this.var_byte_L][this.var_int_aD]);
                    this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
                    this.var_short_g = 0;
                    this.var_short_h = (short)(this.var_int_l / 2);
                    this.var_short_i = (short)(d.var_short_arr_arr_d[this.var_byte_R][0] + d.var_short_arr_arr_d[this.var_byte_R][1] * (this.var_int_aD + 1));
                    this.dM();
                    ++this.var_int_aD;
                }
            } else {
                this.var_byte_aA = (byte)(33 + this.var_byte_N);
                this.var_byte_aC = 0;
                this.dH();
            }
        }
        if (this.var_byte_R == 3) {
            this.var_byte_aA = (byte)32;
            this.var_byte_aC = 0;
            this.dH();
        }
    }

    final void cA() {
        if (this.var_byte_R == 11) {
            this.var_int_h = (this.var_int_d * 2 - this.var_int_e + this.var_int_f * 5) * this.var_int_g / 10;
            if (this.var_int_h < 0) {
                this.var_int_h = 0;
            }
            this.var_int_aD = 0;
            while (this.var_int_aD < this.var_byte_arr_o.length) {
                this.var_short_g = 0;
                this.var_short_f = this.var_byte_arr_o[this.var_int_aD];
                this.var_short_i = (short)(d.var_short_arr_arr_d[this.var_byte_R][0] + d.var_short_arr_arr_d[this.var_byte_R][1] * this.var_int_aD);
                this.var_short_h = (short)((this.var_int_l - d.A[0]) / 2 - 2);
                if (this.var_int_aD == this.var_byte_arr_o.length - 1) {
                    this.var_short_i = (short)(this.var_short_i + 6);
                }
                this.dK();
                this.var_int_aE = this.var_int_arr_d[this.var_byte_az - 1];
                this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
                if (this.var_int_aD == 0) {
                    this.var_java_lang_StringBuffer_a.append(this.var_int_d);
                }
                if (this.var_int_aD == 1) {
                    this.var_java_lang_StringBuffer_a.append(this.var_int_e);
                }
                if (this.var_int_aD == 2) {
                    this.var_java_lang_StringBuffer_a.append(this.var_int_f);
                }
                if (this.var_int_aD == 3) {
                    this.var_java_lang_StringBuffer_a.append(this.var_int_g);
                }
                if (this.var_int_aD == 4) {
                    this.var_java_lang_StringBuffer_a.append(this.var_int_h);
                }
                this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
                this.var_short_g = (short)2;
                this.var_short_h = (short)((this.var_int_l + d.A[0]) / 2 + 2);
                this.dM();
                while (this.var_int_arr_d[this.var_byte_az - 1] + this.var_int_aE < d.A[0]) {
                    this.var_byte_az = (byte)(this.var_byte_az - 1);
                    this.var_java_lang_String_a = "." + this.var_java_lang_String_a;
                    this.dM();
                }
                ++this.var_int_aD;
            }
        }
        if (this.var_byte_R == 20) {
            this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
            this.var_java_lang_StringBuffer_a.append(this.var_byte_arr_aI[this.var_short_arr_h[131] + this.var_byte_U]);
            this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
            this.var_short_g = 0;
            this.var_short_h = d.var_short_arr_n[1];
            this.var_short_i = (short)(d.var_short_arr_arr_e[this.var_byte_R][0] - b.var_byte_arr_b[0] / 2);
            this.dM();
        }
        if (this.var_byte_R == 24) {
            if (this.var_byte_aW == 0) {
                this.var_short_f = this.var_byte_arr_aI[this.var_short_arr_h[135] + this.var_byte_aV];
            }
            if (this.var_byte_aW == 1) {
                this.var_short_f = this.var_byte_arr_aI[this.var_short_arr_h[136] + this.var_byte_aV];
            }
            this.var_short_g = 1;
            this.var_short_h = (short)(this.var_int_l / 2);
            this.var_short_i = (short)105;
            this.dK();
            this.cs();
        }
    }

    final void cB() {
        if (this.var_byte_R == 25) {
            this.var_int_aD = 0;
            while (this.var_int_aD < this.var_byte_arr_u.length) {
                this.var_int_arr_arr_g[1][this.var_int_aD] = 0;
                this.var_int_aE = 0;
                while (this.var_int_aE < d.var_short_arr_k[4]) {
                    int[] nArray = this.var_int_arr_arr_g[1];
                    int n = this.var_int_aD;
                    nArray[n] = nArray[n] + this.var_int_arr_arr_c[3 + this.var_int_aD][this.var_int_aE];
                    ++this.var_int_aE;
                }
                int[] nArray = this.var_int_arr_arr_g[1];
                int n = this.var_int_aD;
                nArray[n] = nArray[n] / d.var_short_arr_k[4];
                this.var_int_arr_arr_g[0][this.var_int_aD] = this.var_int_aD;
                ++this.var_int_aD;
            }
            this.var_int_aD = 0;
            while (this.var_int_aD < this.var_byte_arr_u.length - 1) {
                this.var_int_aE = this.var_int_aD + 1;
                while (this.var_int_aE < this.var_byte_arr_u.length) {
                    if (this.var_int_arr_arr_g[1][this.var_int_aD] < this.var_int_arr_arr_g[1][this.var_int_aE]) {
                        this.var_int_aF = this.var_int_arr_arr_g[0][this.var_int_aD];
                        this.var_int_arr_arr_g[0][this.var_int_aD] = this.var_int_arr_arr_g[0][this.var_int_aE];
                        this.var_int_arr_arr_g[0][this.var_int_aE] = this.var_int_aF;
                        this.var_int_aF = this.var_int_arr_arr_g[1][this.var_int_aD];
                        this.var_int_arr_arr_g[1][this.var_int_aD] = this.var_int_arr_arr_g[1][this.var_int_aE];
                        this.var_int_arr_arr_g[1][this.var_int_aE] = this.var_int_aF;
                    }
                    ++this.var_int_aE;
                }
                ++this.var_int_aD;
            }
            this.var_int_aD = 0;
            while (this.var_int_aD < this.var_byte_arr_u.length) {
                this.var_short_g = 0;
                this.var_short_f = this.var_byte_arr_u[this.var_int_arr_arr_g[0][this.var_int_aD]];
                this.var_short_i = (short)(d.var_short_arr_arr_d[this.var_byte_R][0] + d.var_short_arr_arr_d[this.var_byte_R][1] * this.var_int_aD);
                this.var_short_h = (short)((this.var_int_l - d.A[0]) / 2 + 13);
                this.dK();
                this.var_int_aE = this.var_int_arr_d[this.var_byte_az - 1] + 15;
                this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
                this.var_java_lang_StringBuffer_a.append(this.var_int_arr_arr_g[1][this.var_int_aD]);
                this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
                this.var_short_g = (short)2;
                this.var_short_h = (short)((this.var_int_l + d.A[0]) / 2 + 2);
                this.dM();
                while (this.var_int_arr_d[this.var_byte_az - 1] + this.var_int_aE < d.A[0]) {
                    this.var_byte_az = (byte)(this.var_byte_az - 1);
                    this.var_java_lang_String_a = "." + this.var_java_lang_String_a;
                    this.dM();
                }
                ++this.var_int_aD;
            }
        }
    }

    final void cC() {
        this.var_byte_c = this.var_byte_b;
        if (this.var_byte_b == 3 && this.var_byte_R == 11) {
            this.var_byte_S = 0;
            this.var_byte_P = 0;
            this.var_byte_aA = (byte)29;
        } else {
            this.cD();
            this.var_byte_S = this.var_byte_R;
            this.var_byte_aA = this.var_byte_arr_aI[this.var_short_arr_h[171 + this.var_byte_c] + this.var_int_aG];
        }
        this.var_byte_b = (byte)3;
        this.var_byte_R = (byte)2;
        this.var_byte_aC = 0;
        this.var_boolean_arr_i[this.var_byte_aA] = true;
        this.dH();
        this.cu();
        this.var_byte_aa = (byte)5;
    }

    final void cD() {
        this.var_int_aG = 0;
        if (this.var_byte_b == 2) {
            this.var_int_aG = this.var_byte_arr_aI[this.var_short_arr_h[175] + this.var_byte_B] + this.var_byte_C;
        }
        if (this.var_byte_b == 3) {
            this.var_int_aG = this.var_byte_R;
            if (this.var_byte_R == 26) {
                this.var_int_aG += this.var_byte_P;
            }
        }
    }

    final void cE() {
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)b.var_byte_arr_i[0], (int)b.var_byte_arr_i[1], (int)b.var_byte_arr_i[2], (int)b.var_byte_arr_i[3], 0, this.var_int_l - 40, 2, 20);
        this.var_int_aH = this.var_int_arr_arr_c[2][d.var_short_arr_k[4] + 1] == 0 ? 3 : 5 - (this.var_int_arr_arr_c[1][d.var_short_arr_k[4] + 1] - 1) / 2;
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[71] + this.var_int_aH], (int)this.var_byte_arr_aI[this.var_short_arr_h[72] + this.var_int_aH], (int)this.var_byte_arr_aI[this.var_short_arr_h[73] + this.var_int_aH], (int)this.var_byte_arr_aI[this.var_short_arr_h[74] + this.var_int_aH], 0, this.var_int_l - 40 + (b.var_byte_arr_i[2] - this.var_byte_arr_aI[this.var_short_arr_h[73] + this.var_int_aH]) / 2, 2 + (b.var_byte_arr_i[3] - this.var_byte_arr_aI[this.var_short_arr_h[74] + this.var_int_aH]) / 2, 20);
    }

    final void cF() {
        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], 73, 0, 16, 13, 0, (int)d.var_short_arr_a[0], (int)d.var_short_arr_b[0], 20);
        this.var_short_j = 1;
        this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
        this.var_java_lang_StringBuffer_a.append(this.var_int_k);
        this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
        this.var_short_g = 0;
        this.var_short_h = d.var_short_arr_a[1];
        this.var_short_i = d.var_short_arr_b[1];
        if (this.var_byte_az == 0) {
            this.dM();
        } else {
            this.var_short_k = 0;
            this.dN();
        }
        this.var_short_j = 0;
        if (this.var_byte_h >= 0) {
            this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].setColor(0xFF0000);
            this.var_int_q = 0;
            while (this.var_int_q < 2) {
                this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRect(d.var_short_arr_a[0] - 2 - this.var_int_q, d.var_short_arr_b[0] - 2 - this.var_int_q, d.var_short_arr_a[1] + this.var_int_arr_d[0] + this.var_int_q * 2 - d.var_short_arr_a[0] + 3, 13 + this.var_int_q * 2 + 3);
                ++this.var_int_q;
            }
            this.var_byte_h = (byte)(this.var_byte_h + 1);
            if (this.var_byte_h >= this.var_byte_u) {
                this.var_byte_h = (byte)-1;
            }
        }
    }

    final void cG() {
        this.var_short_arr_arr_a[this.var_byte_Y][this.var_byte_Z] = 0;
        this.var_int_aI = this.var_byte_Y * 5;
        while (this.var_int_aI < (this.var_byte_Y + 1) * 5) {
            this.var_int_aJ = this.var_byte_Z * 5;
            while (this.var_int_aJ < (this.var_byte_Z + 1) * 5) {
                if (this.var_byte_arr_arr_b[this.var_int_aI][this.var_int_aJ] == 0) {
                    short[] sArray = this.var_short_arr_arr_a[this.var_byte_Y];
                    byte by = this.var_byte_Z;
                    sArray[by] = (short)(sArray[by] + b.as[this.var_byte_arr_arr_c[this.var_int_aI][this.var_int_aJ] / 4]);
                    short[] sArray2 = this.var_short_arr_arr_a[this.var_byte_Y];
                    byte by2 = this.var_byte_Z;
                    sArray2[by2] = (short)(sArray2[by2] + b.at[this.var_byte_arr_arr_c[this.var_int_aI][this.var_int_aJ] % 4]);
                } else if (this.var_byte_arr_arr_b[this.var_int_aI][this.var_int_aJ] < 0 && this.var_byte_arr_arr_b[this.var_int_aI][this.var_int_aJ] > -15) {
                    short[] sArray = this.var_short_arr_arr_a[this.var_byte_Y];
                    byte by = this.var_byte_Z;
                    sArray[by] = (short)(sArray[by] + this.var_byte_arr_aI[this.var_short_arr_h[90] + -1 - this.var_byte_arr_arr_b[this.var_int_aI][this.var_int_aJ]]);
                }
                ++this.var_int_aJ;
            }
            ++this.var_int_aI;
        }
        short[] sArray = this.var_short_arr_arr_a[this.var_byte_Y];
        byte by = this.var_byte_Z;
        sArray[by] = (short)(sArray[by] / 3);
    }

    final void cH() {
        if (this.var_int_o != 23) {
            this.var_short_arr_f[this.var_int_o] = (byte)(this.var_byte_arr_aA[this.var_int_o] / b.au[0] - this.var_byte_arr_al[this.var_int_o]);
            if (this.var_short_arr_f[this.var_int_o] > 0) {
                int n = this.var_int_o;
                this.var_short_arr_f[n] = (short)(this.var_short_arr_f[n] * 10);
                return;
            }
            int n = this.var_int_o;
            this.var_short_arr_f[n] = (short)(this.var_short_arr_f[n] * 25);
            return;
        }
        this.var_short_arr_g[5] = (byte)(9 - this.var_byte_arr_aE[5]);
        if (this.var_short_arr_g[5] > 0) {
            this.var_short_arr_g[5] = (short)(this.var_short_arr_g[5] * 10);
            return;
        }
        this.var_short_arr_g[5] = (short)(this.var_short_arr_g[5] * 25);
    }

    final void cI() {
        if (this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_int_o] < 0) {
            return;
        }
        this.var_short_arr_g[this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_int_o]] = 0;
        this.var_byte_ba = 0;
        while (this.var_byte_ba < this.var_byte_ad) {
            byte by = this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_int_o];
            this.var_short_arr_g[by] = (short)(this.var_short_arr_g[by] + this.var_byte_arr_aI[this.var_short_arr_h[29] + this.var_int_o * (this.var_byte_ad + 1) + this.var_byte_ba] / b.au[this.var_byte_ba]);
            this.var_byte_ba = (byte)(this.var_byte_ba + 1);
        }
        byte by = this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_int_o];
        this.var_short_arr_g[by] = (short)(this.var_short_arr_g[by] - this.var_byte_arr_aE[this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_int_o]]);
        if (this.var_short_arr_g[this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_int_o]] > 0) {
            byte by2 = this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_int_o];
            this.var_short_arr_g[by2] = (short)(this.var_short_arr_g[by2] * 10);
            return;
        }
        byte by3 = this.var_byte_arr_aI[this.var_short_arr_h[57] + this.var_int_o];
        this.var_short_arr_g[by3] = (short)(this.var_short_arr_g[by3] * 25);
    }

    protected final void keyPressed(int n) {
        if (this.var_int_n != 0 || !this.var_boolean_c) {
            return;
        }
        try {
            if (n == -6 || n == 6 || n == 42) {
                this.var_int_n = -6;
            } else if (n == -7 || n == 7 || n == 35) {
                this.var_int_n = -7;
            } else if (n == 48) {
                this.var_int_n = 48;
            } else if (n == 55) {
                this.var_boolean_a = !this.var_boolean_a;
            } else {
                this.var_int_p = this.getGameAction(n);
                if (this.var_int_p == 8 || n == 53) {
                    this.var_int_n = 5;
                } else if (this.var_int_p == 1 || n == 50) {
                    this.var_int_n = 1;
                } else if (this.var_int_p == 6 || n == 56) {
                    this.var_int_n = 2;
                } else if (this.var_int_p == 2 || n == 52) {
                    this.var_int_n = 4;
                } else if (this.var_int_p == 5 || n == 54) {
                    this.var_int_n = 3;
                }
            }
            this.var_boolean_p = false;
            this.var_int_aK = 0;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    protected final void keyReleased(int n) {
        try {
            this.var_boolean_p = true;
            if (this.var_int_aK > 0) {
                this.var_int_n = 0;
            }
            this.var_int_aK = 0;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void cJ() {
        this.var_int_aL = 0;
        while (this.var_int_aL < 90) {
            if (this.var_byte_arr_ak[this.var_int_aL] >= 0) {
                int n = this.var_int_aL;
                this.var_byte_arr_ak[n] = (byte)(this.var_byte_arr_ak[n] + 1);
                if (this.var_byte_arr_ak[this.var_int_aL] > 100) {
                    this.var_byte_arr_ak[this.var_int_aL] = 0;
                }
            }
            ++this.var_int_aL;
        }
    }

    final void cK() {
        try {
            this.var_int_aL = 0;
            while (this.var_int_aL < 42) {
                if (this.var_byte_arr_arr_l[0][this.var_int_aL] >= 0) {
                    this.cL();
                    this.cN();
                    if (this.var_byte_arr_ag[this.var_int_aL] == 0 && this.var_byte_arr_Z[this.var_int_aL] != 22) {
                        int n = this.var_int_aL;
                        this.var_byte_arr_af[n] = (byte)(this.var_byte_arr_af[n] + 1);
                        if (this.var_byte_arr_ai[this.var_int_aL] == 2 && this.var_byte_arr_ac[this.var_int_aL] == 0) {
                            this.var_int_aM = 200;
                            while (this.var_int_aM < 222) {
                                if (this.var_byte_arr_A[this.var_int_aM] == 9 && this.var_byte_arr_B[this.var_int_aM] == this.var_byte_arr_arr_n[0][this.var_int_aL] && this.var_byte_arr_C[this.var_int_aM] == this.var_byte_arr_arr_n[1][this.var_int_aL]) {
                                    this.var_int_ay = this.var_int_aM;
                                    this.dp();
                                    this.var_short_arr_d[this.var_int_aM] = -1;
                                    this.var_short_arr_arr_c[this.var_byte_arr_arr_m[0][this.var_int_aL]][this.var_byte_arr_arr_m[1][this.var_int_aL]] = (short)this.var_int_aM;
                                    this.var_byte_arr_ag[this.var_int_aL] = 4;
                                    this.var_byte_arr_ai[this.var_int_aL] = 3;
                                    this.var_byte_arr_af[this.var_int_aL] = 0;
                                    break;
                                }
                                ++this.var_int_aM;
                            }
                        } else if (this.var_byte_arr_ad[this.var_int_aL] > 0 && this.var_byte_arr_Z[this.var_int_aL] != 14 || this.var_byte_arr_Z[this.var_int_aL] == 14 && this.var_byte_arr_ad[this.var_int_aL] + this.var_byte_arr_ac[this.var_int_aL] > 1) {
                            this.cO();
                            this.var_byte_arr_af[this.var_int_aL] = 0;
                            this.var_byte_arr_ag[this.var_int_aL] = 1;
                        } else if (this.var_byte_arr_ac[this.var_int_aL] > 0 && this.var_byte_arr_af[this.var_int_aL] >= this.var_byte_arr_aw[this.var_byte_arr_Z[this.var_int_aL]]) {
                            this.var_byte_arr_af[this.var_int_aL] = 0;
                            this.var_byte_arr_ag[this.var_int_aL] = 3;
                        }
                        if (this.var_byte_arr_Z[this.var_int_aL] == 14 && this.var_byte_arr_af[this.var_int_aL] % 100 == 0 && this.var_byte_arr_ad[this.var_int_aL] == 1) {
                            this.var_byte_ax = (byte)this.var_int_aL;
                            this.d(false);
                        }
                    }
                    this.cM();
                }
                ++this.var_int_aL;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void cL() {
        if (this.var_byte_arr_ag[this.var_int_aL] == 1 || this.var_byte_arr_ag[this.var_int_aL] == 2) {
            int n = this.var_int_aL;
            this.var_byte_arr_af[n] = (byte)(this.var_byte_arr_af[n] + 1);
            if (this.var_byte_arr_af[this.var_int_aL] == 5) {
                if (this.var_byte_arr_ag[this.var_int_aL] == 1) {
                    this.var_int_ay = this.var_short_arr_arr_e[this.var_int_aL][this.var_byte_arr_ac[this.var_int_aL] - 1];
                    this.dp();
                    this.var_short_arr_d[this.var_int_ay] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_ay]][this.var_byte_arr_C[this.var_int_ay]];
                    this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_ay]][this.var_byte_arr_C[this.var_int_ay]] = (short)this.var_int_ay;
                    if (this.var_byte_arr_ac[this.var_int_aL] == this.var_byte_arr_au[this.var_byte_arr_Z[this.var_int_aL]]) {
                        this.var_byte_arr_af[this.var_int_aL] = 0;
                        this.var_byte_arr_ag[this.var_int_aL] = 3;
                        return;
                    }
                    this.var_byte_arr_ag[this.var_int_aL] = 0;
                    return;
                }
                this.var_byte_arr_af[this.var_int_aL] = 0;
                this.cQ();
                if (this.var_byte_arr_ac[this.var_int_aL] == 0) {
                    if (this.var_byte_arr_ah[this.var_int_aL] < 10) {
                        this.var_byte_ax = (byte)this.var_int_aL;
                        this.d(true);
                        this.var_byte_bi = 1;
                        this.dC();
                    }
                    this.var_byte_arr_ag[this.var_int_aL] = 0;
                    this.var_byte_arr_aj[this.var_int_aL] = -1;
                    return;
                }
                this.var_int_ay = this.var_short_arr_arr_e[this.var_int_aL][this.var_byte_arr_ac[this.var_int_aL] - 1];
                this.dp();
            }
        }
    }

    final void cM() {
        if (this.var_byte_arr_ag[this.var_int_aL] == 3) {
            int n = this.var_int_aL;
            this.var_byte_arr_af[n] = (byte)(this.var_byte_arr_af[n] + 1);
            int n2 = this.var_int_aL;
            this.var_byte_arr_ab[n2] = (byte)(this.var_byte_arr_ab[n2] + 1);
            if (this.var_byte_arr_ab[this.var_int_aL] >= this.var_byte_arr_as[this.var_byte_arr_Z[this.var_int_aL]]) {
                this.var_byte_arr_ab[this.var_int_aL] = 0;
            }
            if (this.var_byte_arr_Z[this.var_int_aL] != 23) {
                if (this.var_byte_arr_af[this.var_int_aL] >= this.var_byte_arr_am[this.var_byte_arr_Z[this.var_int_aL]] - 1 || this.var_byte_arr_aj[this.var_int_aL] == 0) {
                    this.var_byte_arr_ab[this.var_int_aL] = 0;
                    this.var_byte_arr_af[this.var_int_aL] = 0;
                    this.var_byte_arr_ag[this.var_int_aL] = 2;
                    this.var_int_ay = this.var_short_arr_arr_e[this.var_int_aL][this.var_byte_arr_ac[this.var_int_aL] - 1];
                    this.dp();
                }
                this.var_int_aM = 0;
                while (this.var_int_aM < this.var_byte_arr_ac[this.var_int_aL]) {
                    this.var_short_arr_c[this.var_short_arr_arr_e[this.var_int_aL][this.var_int_aM]] = this.var_byte_arr_ab[this.var_int_aL];
                    if (this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][2] + 2] == 1) {
                        this.var_byte_arr_G[this.var_short_arr_arr_e[this.var_int_aL][this.var_int_aM]] = this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][21] + this.var_byte_arr_ab[this.var_int_aL] % this.var_byte_arr_at[this.var_byte_arr_Z[this.var_int_aL]] * this.var_byte_arr_au[this.var_byte_arr_Z[this.var_int_aL]] + (this.var_byte_arr_ab[this.var_int_aL] / this.var_byte_arr_at[this.var_byte_arr_Z[this.var_int_aL]] + this.var_int_aM) % this.var_byte_arr_au[this.var_byte_arr_Z[this.var_int_aL]]];
                    }
                    if (this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][2] + 3] == 1) {
                        this.var_byte_arr_H[this.var_short_arr_arr_e[this.var_int_aL][this.var_int_aM]] = this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][22] + this.var_byte_arr_ab[this.var_int_aL] % this.var_byte_arr_at[this.var_byte_arr_Z[this.var_int_aL]] * this.var_byte_arr_au[this.var_byte_arr_Z[this.var_int_aL]] + (this.var_byte_arr_ab[this.var_int_aL] / this.var_byte_arr_at[this.var_byte_arr_Z[this.var_int_aL]] + this.var_int_aM) % this.var_byte_arr_au[this.var_byte_arr_Z[this.var_int_aL]]];
                    }
                    if (this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][2] + 4] == 1) {
                        this.var_byte_arr_F[this.var_short_arr_arr_e[this.var_int_aL][this.var_int_aM]] = this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][23] + this.var_byte_arr_ab[this.var_int_aL] % this.var_byte_arr_at[this.var_byte_arr_Z[this.var_int_aL]] * this.var_byte_arr_au[this.var_byte_arr_Z[this.var_int_aL]] + (this.var_byte_arr_ab[this.var_int_aL] / this.var_byte_arr_at[this.var_byte_arr_Z[this.var_int_aL]] + this.var_int_aM) % this.var_byte_arr_au[this.var_byte_arr_Z[this.var_int_aL]]];
                    }
                    if (this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][2] + 5] == 1) {
                        this.var_byte_arr_J[this.var_short_arr_arr_e[this.var_int_aL][this.var_int_aM]] = this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][24] + this.var_byte_arr_ab[this.var_int_aL] % this.var_byte_arr_at[this.var_byte_arr_Z[this.var_int_aL]] * this.var_byte_arr_au[this.var_byte_arr_Z[this.var_int_aL]] + this.var_int_aM];
                    }
                    if (this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][3] + 2] == 0 && this.var_byte_arr_ag[this.var_int_aL] == 3 && (this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][35] + this.var_byte_arr_ab[this.var_int_aL] % this.var_byte_arr_at[this.var_byte_arr_Z[this.var_int_aL]] * 2 + 0] != 0 || this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][35] + this.var_byte_arr_ab[this.var_int_aL] % this.var_byte_arr_at[this.var_byte_arr_Z[this.var_int_aL]] * 2 + 1] != 0)) {
                        this.var_int_ay = this.var_short_arr_arr_e[this.var_int_aL][this.var_int_aM];
                        this.dp();
                        int n3 = this.var_int_ay;
                        this.var_byte_arr_B[n3] = (byte)(this.var_byte_arr_B[n3] + this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][35] + this.var_byte_arr_ab[this.var_int_aL] % this.var_byte_arr_at[this.var_byte_arr_Z[this.var_int_aL]] * 2 + 0]);
                        int n4 = this.var_int_ay;
                        this.var_byte_arr_C[n4] = (byte)(this.var_byte_arr_C[n4] + this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][35] + this.var_byte_arr_ab[this.var_int_aL] % this.var_byte_arr_at[this.var_byte_arr_Z[this.var_int_aL]] * 2 + 1]);
                        this.var_short_arr_d[this.var_int_ay] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_ay]][this.var_byte_arr_C[this.var_int_ay]];
                        this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_ay]][this.var_byte_arr_C[this.var_int_ay]] = (short)this.var_int_ay;
                    }
                    ++this.var_int_aM;
                }
            }
        }
    }

    final void cN() {
        if (this.var_byte_arr_ag[this.var_int_aL] == 4) {
            int n = this.var_int_aL;
            this.var_byte_arr_af[n] = (byte)(this.var_byte_arr_af[n] + 1);
            if (this.var_byte_arr_af[this.var_int_aL] == this.var_byte_l) {
                this.var_byte_arr_ag[this.var_int_aL] = 0;
                this.var_byte_arr_ai[this.var_int_aL] = 0;
                this.var_byte_arr_ah[this.var_int_aL] = 100;
                this.var_int_ay = this.var_short_arr_arr_c[this.var_byte_arr_arr_m[0][this.var_int_aL]][this.var_byte_arr_arr_m[1][this.var_int_aL]];
                this.var_short_arr_arr_c[this.var_byte_arr_arr_n[0][this.var_int_aL]][this.var_byte_arr_arr_n[1][this.var_int_aL]] = (short)this.var_int_ay;
                this.var_short_arr_arr_c[this.var_byte_arr_arr_m[0][this.var_int_aL]][this.var_byte_arr_arr_m[1][this.var_int_aL]] = -1;
                this.var_byte_arr_B[this.var_int_ay] = this.var_byte_arr_arr_n[0][this.var_int_aL];
                this.var_byte_arr_C[this.var_int_ay] = this.var_byte_arr_arr_n[1][this.var_int_aL];
                this.var_byte_arr_F[this.var_int_ay] = b.ao[this.var_byte_arr_aa[this.var_int_aL]];
                this.var_byte_arr_D[this.var_int_ay] = (byte)(this.var_byte_arr_B[this.var_int_ay] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_ay] * 2 + 0]);
                this.var_byte_arr_E[this.var_int_ay] = (byte)(this.var_byte_arr_C[this.var_int_ay] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_ay] * 2 + 1]);
                this.var_byte_arr_G[this.var_int_ay] = b.var_byte_arr_arr_g[this.var_byte_arr_aa[this.var_int_aL]][0];
                this.var_byte_arr_H[this.var_int_ay] = b.var_byte_arr_arr_g[this.var_byte_arr_aa[this.var_int_aL]][1];
                this.var_byte_arr_W[this.var_int_ay] = -1;
            }
        }
    }

    final void cO() {
        this.cP();
        this.var_int_aO = 1;
        while (this.var_int_aO < this.var_byte_arr_ad[this.var_int_aL]) {
            this.var_byte_arr_W[this.var_short_arr_arr_f[this.var_int_aL][this.var_int_aO]] = 9;
            ++this.var_int_aO;
        }
        this.var_int_ay = this.var_short_arr_arr_e[this.var_int_aL][this.var_byte_arr_ac[this.var_int_aL]];
        this.dp();
        this.var_byte_arr_B[this.var_int_ay] = (byte)(this.var_byte_arr_arr_m[0][this.var_int_aL] + this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][35] + 0 + 0]);
        this.var_byte_arr_C[this.var_int_ay] = (byte)(this.var_byte_arr_arr_m[1][this.var_int_aL] + this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][35] + 0 + 1]);
        if (this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][4] + 0] == 1) {
            this.var_byte_arr_G[this.var_int_ay] = this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][21] + 0 * this.var_byte_arr_au[this.var_byte_arr_Z[this.var_int_aL]] + this.var_byte_arr_ac[this.var_int_aL]];
            this.var_byte_arr_H[this.var_int_ay] = this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][22] + 0 * this.var_byte_arr_au[this.var_byte_arr_Z[this.var_int_aL]] + this.var_byte_arr_ac[this.var_int_aL]];
            this.var_byte_arr_F[this.var_int_ay] = this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][23] + 0 * this.var_byte_arr_au[this.var_byte_arr_Z[this.var_int_aL]] + this.var_byte_arr_ac[this.var_int_aL]];
            this.var_byte_arr_J[this.var_int_ay] = this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][2] + 5] == 1 ? this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_int_aL]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_int_aL]][24] + 0 * this.var_byte_arr_au[this.var_byte_arr_Z[this.var_int_aL]] + this.var_byte_arr_ac[this.var_int_aL]] : (byte)0;
        }
        int n = this.var_int_aL;
        this.var_byte_arr_ac[n] = (byte)(this.var_byte_arr_ac[n] + 1);
        this.var_byte_arr_ad[this.var_int_aL] = 0;
    }

    final void cP() {
        this.var_byte_arr_P[this.var_short_arr_arr_f[this.var_int_aL][0]] = this.byte_a(this.var_byte_arr_P[this.var_short_arr_arr_f[this.var_int_aL][0]] + this.var_short_arr_f[this.var_byte_arr_Z[this.var_int_aL]]);
        this.var_byte_arr_aT[0] = this.var_byte_arr_B[this.var_short_arr_arr_f[this.var_int_aL][0]];
        this.var_byte_arr_aT[1] = this.var_byte_arr_C[this.var_short_arr_arr_f[this.var_int_aL][0]];
        this.var_short_h = (short)((this.var_byte_arr_G[this.var_short_arr_arr_f[this.var_int_aL][0]] + this.var_byte_arr_H[this.var_short_arr_arr_f[this.var_int_aL][0]]) / b.Y[0] - this.var_byte_arr_aI[this.var_short_arr_h[2] + this.var_byte_arr_A[this.var_short_arr_arr_f[this.var_int_aL][0]] * 12 + 0 + this.var_byte_arr_K[this.var_byte_arr_J[this.var_short_arr_arr_f[this.var_int_aL][0]]]] / 2);
        this.var_short_i = (short)(b.B[1] / 2 + (this.var_byte_arr_G[this.var_short_arr_arr_f[this.var_int_aL][0]] - this.var_byte_arr_H[this.var_short_arr_arr_f[this.var_int_aL][0]]) / b.Y[1] - this.var_byte_arr_aI[this.var_short_arr_h[20] + this.var_byte_arr_A[this.var_short_arr_arr_f[this.var_int_aL][0]] * 4 + 0] - 15);
        this.var_int_k += this.var_short_arr_b[this.var_short_arr_arr_f[this.var_int_aL][0]];
        this.var_int_d += this.var_short_arr_b[this.var_short_arr_arr_f[this.var_int_aL][0]];
        short s = this.var_short_arr_arr_f[this.var_int_aL][0];
        this.var_byte_arr_L[s] = (byte)(this.var_byte_arr_L[s] - this.var_short_arr_b[this.var_short_arr_arr_f[this.var_int_aL][0]]);
        this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
        this.var_java_lang_StringBuffer_a.append("+");
        this.var_java_lang_StringBuffer_a.append(this.var_short_arr_b[this.var_short_arr_arr_f[this.var_int_aL][0]]);
        this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
        this.dL();
        this.var_short_arr_b[this.var_short_arr_arr_f[this.var_int_aL][0]] = 0;
        this.var_short_arr_arr_e[this.var_int_aL][this.var_byte_arr_ac[this.var_int_aL]] = this.var_short_arr_arr_f[this.var_int_aL][0];
        this.var_short_arr_c[this.var_short_arr_arr_e[this.var_int_aL][this.var_byte_arr_ac[this.var_int_aL]]] = 0;
        this.var_byte_arr_W[this.var_short_arr_arr_e[this.var_int_aL][this.var_byte_arr_ac[this.var_int_aL]]] = 13;
    }

    final void cQ() {
        int n = this.var_int_aL;
        this.var_byte_arr_ac[n] = (byte)(this.var_byte_arr_ac[n] - 1);
        this.var_int_ay = this.var_short_arr_arr_e[this.var_int_aL][this.var_byte_arr_ac[this.var_int_aL]];
        this.dp();
        this.var_byte_arr_B[this.var_short_arr_arr_e[this.var_int_aL][this.var_byte_arr_ac[this.var_int_aL]]] = this.var_byte_arr_arr_n[0][this.var_int_aL];
        this.var_byte_arr_C[this.var_short_arr_arr_e[this.var_int_aL][this.var_byte_arr_ac[this.var_int_aL]]] = this.var_byte_arr_arr_n[1][this.var_int_aL];
        this.var_short_arr_d[this.var_int_ay] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_ay]][this.var_byte_arr_C[this.var_int_ay]];
        this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_ay]][this.var_byte_arr_C[this.var_int_ay]] = (short)this.var_int_ay;
        this.var_byte_arr_W[this.var_int_ay] = -1;
        this.var_byte_arr_P[this.var_int_ay] = this.byte_a(this.var_byte_arr_P[this.var_int_ay] + this.var_byte_arr_aA[this.var_byte_arr_Z[this.var_int_aL]] - b.ap[this.var_byte_arr_aj[this.var_int_aL] + 1]);
        this.var_byte_arr_F[this.var_int_ay] = b.ao[this.var_byte_arr_aa[this.var_int_aL]];
        this.var_byte_arr_D[this.var_int_ay] = (byte)(this.var_byte_arr_B[this.var_int_ay] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_ay] * 2 + 0]);
        this.var_byte_arr_E[this.var_int_ay] = (byte)(this.var_byte_arr_C[this.var_int_ay] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_ay] * 2 + 1]);
        this.var_byte_arr_G[this.var_int_ay] = b.var_byte_arr_arr_g[this.var_byte_arr_aa[this.var_int_aL]][0];
        this.var_byte_arr_H[this.var_int_ay] = b.var_byte_arr_arr_g[this.var_byte_arr_aa[this.var_int_aL]][1];
        if (this.var_byte_arr_aA[this.var_byte_arr_Z[this.var_int_aL]] >= 30 && (this.var_java_util_Random_a.nextInt() & 0xFFFF) % 100 < this.var_byte_arr_aA[this.var_byte_arr_Z[this.var_int_aL]]) {
            this.var_byte_arr_O[this.var_int_ay] = 0;
        }
        int n2 = this.var_int_aL;
        this.var_byte_arr_ah[n2] = (byte)(this.var_byte_arr_ah[n2] - (this.var_java_util_Random_a.nextInt() & 0xFFFF) % this.var_byte_arr_ay[this.var_byte_arr_Z[this.var_int_aL]] / (20 - 7 * this.var_byte_M));
    }

    final void cR() {
        this.var_int_aR = 5 + (this.var_int_arr_arr_c[1][d.var_short_arr_k[4] + 1] - 6 - this.var_byte_M) * (this.var_int_b * (2 + this.var_byte_M) / 3) + this.var_byte_arr_aD[24] * 15 / this.var_byte_al;
        if (this.var_byte_ai > 0 && this.var_short_a > 0 && this.var_short_a > this.var_byte_ai * 5) {
            this.var_int_aR /= this.var_short_a / (this.var_byte_ai * 5);
        }
        if (this.var_int_aR < 3) {
            this.var_int_aR = 3;
        }
        if (this.var_int_aR > 80) {
            this.var_int_aR = 80;
        }
        if ((this.var_java_util_Random_a.nextInt() & 0xFFF) % 100 >= this.var_int_aR) {
            return;
        }
        this.var_int_aL = 0;
        while (this.var_int_aL < 200) {
            if (this.var_byte_arr_B[this.var_int_aL] < 0) {
                this.var_byte_arr_A[this.var_int_aL] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFF) % 8);
                this.var_byte_arr_B[this.var_int_aL] = this.var_byte_ab;
                this.var_byte_arr_C[this.var_int_aL] = 0;
                this.var_byte_arr_D[this.var_int_aL] = this.var_byte_ab;
                this.var_byte_arr_E[this.var_int_aL] = 1;
                this.var_byte_arr_F[this.var_int_aL] = 3;
                this.var_byte_arr_G[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[36] + this.var_byte_arr_F[this.var_int_aL] * 2 + 0];
                this.var_byte_arr_H[this.var_int_aL] = -100;
                this.var_byte_arr_I[this.var_int_aL] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFF) % 4 + 1);
                this.var_byte_arr_J[this.var_int_aL] = 1;
                this.var_byte_arr_W[this.var_int_aL] = -1;
                this.var_byte_arr_L[this.var_int_aL] = (byte)(60 + (this.var_java_util_Random_a.nextInt() & 0xFFFF) % 40 - 20);
                this.var_short_arr_b[this.var_int_aL] = 0;
                this.var_byte_arr_R[this.var_int_aL] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 60);
                this.var_byte_arr_Q[this.var_int_aL] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 60);
                this.var_byte_arr_P[this.var_int_aL] = (byte)(100 - (this.var_java_util_Random_a.nextInt() & 0xFFFF) % 20);
                this.var_byte_arr_S[this.var_int_aL] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 20);
                this.var_byte_arr_T[this.var_int_aL] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 60);
                this.var_byte_arr_U[this.var_int_aL] = (byte)(100 - (this.var_java_util_Random_a.nextInt() & 0xFFFF) % 20);
                this.var_byte_arr_V[this.var_int_aL] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 20);
                this.var_byte_arr_M[this.var_int_aL] = -1;
                this.var_byte_arr_N[this.var_int_aL] = -1;
                this.var_byte_arr_O[this.var_int_aL] = -1;
                this.var_short_arr_c[this.var_int_aL] = 0;
                this.var_short_arr_d[this.var_int_aL] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
                this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] = (short)this.var_int_aL;
                this.var_byte_arr_arr_f[0][this.var_int_aL] = -1;
                this.var_byte_arr_arr_f[1][this.var_int_aL] = -1;
                this.var_byte_arr_arr_f[2][this.var_int_aL] = 0;
                this.var_short_a = (short)(this.var_short_a + 1);
                ++this.var_int_f;
                return;
            }
            ++this.var_int_aL;
        }
    }

    final void cS() {
        this.var_int_ay = this.var_int_aL;
        this.dp();
        this.var_byte_arr_B[this.var_int_aL] = -1;
        this.var_short_a = (short)(this.var_short_a - 1);
    }

    final void cT() {
        try {
            this.var_int_aL = 0;
            while (this.var_int_aL < 222) {
                if (this.var_byte_arr_B[this.var_int_aL] >= 0) {
                    this.cU();
                    if (this.var_byte_arr_W[this.var_int_aL] > -1 && this.var_byte_arr_W[this.var_int_aL] < 9) {
                        this.cV();
                    } else {
                        this.de();
                        if (this.var_byte_arr_W[this.var_int_aL] < 11 || this.var_byte_arr_W[this.var_int_aL] == 18) {
                            this.df();
                            if (this.var_byte_arr_A[this.var_int_aL] != 10) {
                                this.dg();
                            }
                        }
                        this.dh();
                        if (this.var_byte_arr_W[this.var_int_aL] == 10 && this.var_byte_arr_arr_b[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]] != 13) {
                            if (this.var_byte_arr_arr_b[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]] == 7 && this.var_byte_arr_G[this.var_int_aL] > 15) {
                                this.var_byte_arr_G[this.var_int_aL] = 20;
                            }
                            if (this.var_byte_arr_arr_b[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]] == 8 && this.var_byte_arr_H[this.var_int_aL] < 4) {
                                this.var_byte_arr_H[this.var_int_aL] = -1;
                            }
                        }
                        if (this.var_byte_arr_W[this.var_int_aL] == 12 && this.var_short_arr_c[this.var_int_aL] == 100) {
                            this.di();
                            byte by = this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
                            this.var_byte_arr_ac[by] = (byte)(this.var_byte_arr_ac[by] - 1);
                        } else {
                            this.dj();
                            this.dk();
                            this.dl();
                        }
                    }
                }
                ++this.var_int_aL;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void cU() {
        if (this.var_byte_arr_W[this.var_int_aL] != 13) {
            int n = this.var_int_aL;
            this.var_short_arr_c[n] = (short)(this.var_short_arr_c[n] + 1);
        }
        if (this.var_int_aL < 200) {
            if (this.var_byte_arr_O[this.var_int_aL] >= 0) {
                int n = this.var_int_aL;
                this.var_byte_arr_O[n] = (byte)(this.var_byte_arr_O[n] + 1);
            }
            if (this.var_byte_arr_O[this.var_int_aL] >= this.var_byte_v) {
                this.var_byte_arr_O[this.var_int_aL] = -1;
            }
        }
        if (this.var_int_aL < 200 && this.var_byte_arr_W[this.var_int_aL] != 13 && this.var_byte_arr_W[this.var_int_aL] != 18) {
            this.var_int_aM = 0;
            while (this.var_int_aM < this.var_byte_ae) {
                this.var_int_aP = this.var_short_arr_arr_b[this.var_byte_M][this.var_int_aM];
                if (this.var_int_aM == 0) {
                    this.var_int_aP += this.var_short_arr_arr_a[this.var_byte_arr_B[this.var_int_aL] / 5][this.var_byte_arr_C[this.var_int_aL] / 5];
                }
                if (this.var_short_arr_c[this.var_int_aL] % this.var_int_aP == 0) {
                    if (b.ar[this.var_int_aM] == 0 && this.var_byte_arr_arr_g[this.var_int_aM][this.var_int_aL] > 0) {
                        byte[] byArray = this.var_byte_arr_arr_g[this.var_int_aM];
                        int n = this.var_int_aL;
                        byArray[n] = (byte)(byArray[n] - 1);
                    }
                    if (b.ar[this.var_int_aM] == 1 && this.var_byte_arr_arr_g[this.var_int_aM][this.var_int_aL] < 100) {
                        byte[] byArray = this.var_byte_arr_arr_g[this.var_int_aM];
                        int n = this.var_int_aL;
                        byArray[n] = (byte)(byArray[n] + 1);
                    }
                }
                ++this.var_int_aM;
            }
            if (this.var_short_arr_c[this.var_int_aL] % this.var_byte_q == 0) {
                this.e(true);
            }
        }
    }

    final void cV() {
        if (this.var_byte_arr_W[this.var_int_aL] < 7) {
            this.dc();
            return;
        }
        if (this.var_byte_arr_W[this.var_int_aL] == 7 || this.var_byte_arr_W[this.var_int_aL] == 8) {
            int n = this.var_int_aL;
            this.var_byte_arr_G[n] = (byte)(this.var_byte_arr_G[n] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + 0] * this.var_byte_arr_I[this.var_int_aL]);
            int n2 = this.var_int_aL;
            this.var_byte_arr_H[n2] = (byte)(this.var_byte_arr_H[n2] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + 1] * this.var_byte_arr_I[this.var_int_aL]);
            int n3 = this.var_int_aL;
            this.var_byte_arr_J[n3] = (byte)(this.var_byte_arr_J[n3] + 1);
            if (this.var_byte_arr_J[this.var_int_aL] > 3) {
                this.var_byte_arr_J[this.var_int_aL] = 0;
            }
            if (this.var_byte_arr_W[this.var_int_aL] == 7) {
                this.dd();
                return;
            }
            if (this.var_byte_arr_W[this.var_int_aL] == 8) {
                this.var_int_aM = (this.var_byte_arr_H[this.var_int_aL] - this.var_byte_arr_aI[this.var_short_arr_h[35] + this.var_byte_arr_arr_h[1][this.var_int_aL] * 4 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]] + 1]) * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]]];
                if (this.var_int_aM >= 0) {
                    this.var_byte_arr_H[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[35] + this.var_byte_arr_arr_h[1][this.var_int_aL] * 4 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]] + 1];
                    this.var_byte_arr_X[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[35] + this.var_byte_arr_arr_h[1][this.var_int_aL] * 4 + 3];
                    int n4 = this.var_int_aL;
                    this.var_byte_arr_H[n4] = (byte)(this.var_byte_arr_H[n4] + this.var_int_aM * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]]]);
                    byte[] byArray = this.var_byte_arr_arr_h[1];
                    int n5 = this.var_int_aL;
                    byArray[n5] = (byte)(byArray[n5] + 1);
                    if (this.var_byte_arr_arr_h[1][this.var_int_aL] == 4) {
                        this.da();
                        return;
                    }
                }
                this.db();
            }
        }
    }

    final void cW() {
        if (this.var_int_aM >= 0) {
            this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]]][this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[this.var_byte_arr_arr_q[this.var_byte_arr_arr_h[0][this.var_int_aL]][this.var_byte_arr_arr_h[2][this.var_int_aL]]] + this.var_int_aQ * 16 + this.var_byte_arr_arr_h[1][this.var_int_aL] * 4 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]] + 1];
            this.var_byte_arr_X[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[this.var_byte_arr_arr_q[this.var_byte_arr_arr_h[0][this.var_int_aL]][this.var_byte_arr_arr_h[2][this.var_int_aL]]] + this.var_int_aQ * 16 + this.var_byte_arr_arr_h[1][this.var_int_aL] * 4 + 3];
            byte[] byArray = this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]]];
            int n = this.var_int_aL;
            byArray[n] = (byte)(byArray[n] + this.var_int_aM * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]]]);
            byte[] byArray2 = this.var_byte_arr_arr_h[1];
            int n2 = this.var_int_aL;
            byArray2[n2] = (byte)(byArray2[n2] + 1);
            if (this.var_byte_arr_arr_h[0][this.var_int_aL] == 0 && this.var_byte_arr_arr_h[1][this.var_int_aL] == this.var_byte_arr_arr_r[this.var_byte_arr_arr_h[2][this.var_int_aL]][this.var_int_aQ] + this.var_byte_arr_aI[this.var_short_arr_h[102] + this.var_byte_arr_W[this.var_int_aL]]) {
                this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]]][this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[this.var_byte_arr_arr_q[this.var_byte_arr_arr_h[0][this.var_int_aL]][this.var_byte_arr_arr_h[2][this.var_int_aL]]] + this.var_int_aQ * 16 + (this.var_byte_arr_arr_h[1][this.var_int_aL] - 1) * 4 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]] + 1];
                this.var_byte_arr_arr_h[1][this.var_int_aL] = 0;
                byte[] byArray3 = this.var_byte_arr_arr_h[0];
                int n3 = this.var_int_aL;
                byArray3[n3] = (byte)(byArray3[n3] + 1);
                this.var_short_arr_c[this.var_int_aL] = 0;
                this.var_byte_arr_J[this.var_int_aL] = 0;
                this.cX();
                return;
            }
            if (this.var_byte_arr_arr_h[0][this.var_int_aL] == 2) {
                this.var_byte_arr_W[this.var_int_aL] = -1;
                this.var_byte_arr_F[this.var_int_aL] = this.var_byte_arr_X[this.var_int_aL];
            }
        }
    }

    final void cX() {
        if (this.var_byte_arr_W[this.var_int_aL] == 6 && this.var_boolean_arr_e[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 0] * 2 + 0]][this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 0] * 2 + 1]]]) {
            this.var_byte_arr_X[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 2];
            this.var_byte_arr_arr_h[1][this.var_int_aL] = 0;
            byte[] byArray = this.var_byte_arr_arr_h[0];
            int n = this.var_int_aL;
            byArray[n] = (byte)(byArray[n] + 1);
        } else if (this.var_byte_arr_W[this.var_int_aL] == 4 || this.var_byte_arr_W[this.var_int_aL] == 6) {
            this.var_boolean_arr_e[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 0] * 2 + 0]][this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 0] * 2 + 1]]] = true;
        }
        if (this.var_byte_arr_W[this.var_int_aL] == 4) {
            this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 0] * 2 + 0]][this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 0] * 2 + 1]]] = false;
        }
        if (this.var_byte_arr_W[this.var_int_aL] == 1) {
            this.var_int_aP = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
            this.var_int_aQ = 0;
            do {
                if (this.var_byte_arr_G[this.var_int_aP] == this.var_byte_arr_aI[this.var_short_arr_h[11] + this.var_byte_arr_arr_h[2][this.var_int_aL] * 4 + 0 + 0] && this.var_byte_arr_H[this.var_int_aP] == this.var_byte_arr_aI[this.var_short_arr_h[11] + this.var_byte_arr_arr_h[2][this.var_int_aL] * 4 + 0 + 1] && this.var_int_aP != this.var_int_aL) {
                    ++this.var_int_aQ;
                    break;
                }
                this.var_int_aP = this.var_short_arr_d[this.var_int_aP];
            } while (this.var_int_aP >= 0);
            this.var_byte_arr_G[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[11] + this.var_byte_arr_arr_h[2][this.var_int_aL] * 4 + this.var_int_aQ * 2 + 0];
            this.var_byte_arr_H[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[11] + this.var_byte_arr_arr_h[2][this.var_int_aL] * 4 + this.var_int_aQ * 2 + 1];
        }
    }

    final void cY() {
        if (this.var_short_arr_c[this.var_int_aL] >= this.var_byte_arr_aI[this.var_short_arr_h[this.var_byte_arr_arr_q[1][0]] + this.var_byte_arr_W[this.var_int_aL] * 4 + 1]) {
            if (this.var_byte_arr_W[this.var_int_aL] != 1) {
                this.var_byte_bc = this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 0] * 2 + 0]][this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 0] * 2 + 1]];
                if (this.var_byte_arr_W[this.var_int_aL] == 4 || this.var_byte_arr_W[this.var_int_aL] == 6) {
                    this.var_boolean_arr_e[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 0] * 2 + 0]][this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 0] * 2 + 1]]] = false;
                }
                if (this.var_byte_arr_W[this.var_int_aL] == 4) {
                    this.var_boolean_arr_d[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 0] * 2 + 0]][this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 0] * 2 + 1]]] = true;
                }
                this.var_int_aM = 0;
                while (this.var_int_aM < this.var_byte_ad) {
                    this.var_byte_arr_arr_g[this.var_int_aM][this.var_int_aL] = b.ar[this.var_int_aM] == 0 ? this.byte_a(this.var_byte_arr_arr_g[this.var_int_aM][this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[29] + (-1 - this.var_byte_bc) * (this.var_byte_ad + 1) + this.var_int_aM]) : this.byte_a(this.var_byte_arr_arr_g[this.var_int_aM][this.var_int_aL] - this.var_byte_arr_aI[this.var_short_arr_h[29] + (-1 - this.var_byte_bc) * (this.var_byte_ad + 1) + this.var_int_aM]);
                    ++this.var_int_aM;
                }
                if (this.var_byte_arr_W[this.var_int_aL] == 5) {
                    this.var_byte_arr_M[this.var_int_aL] = (byte)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 5);
                }
            }
            this.var_byte_arr_X[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 2];
            this.var_byte_arr_arr_h[1][this.var_int_aL] = 0;
            byte[] byArray = this.var_byte_arr_arr_h[0];
            int n = this.var_int_aL;
            byArray[n] = (byte)(byArray[n] + 1);
            if (this.var_byte_arr_W[this.var_int_aL] == 1) {
                int n2 = this.var_int_aL;
                this.var_byte_arr_Q[n2] = (byte)(this.var_byte_arr_Q[n2] - 50);
                if (this.var_byte_arr_arr_h[2][this.var_int_aL] == 0) {
                    this.var_byte_arr_H[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[this.var_byte_arr_arr_q[this.var_byte_arr_arr_h[0][this.var_int_aL]][this.var_byte_arr_arr_h[2][this.var_int_aL]]] + this.var_byte_arr_F[this.var_int_aL] * 16 + this.var_byte_arr_arr_h[1][this.var_int_aL] * 4 + 2];
                    return;
                }
                this.var_byte_arr_G[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[this.var_byte_arr_arr_q[this.var_byte_arr_arr_h[0][this.var_int_aL]][this.var_byte_arr_arr_h[2][this.var_int_aL]]] + this.var_byte_arr_F[this.var_int_aL] * 16 + this.var_byte_arr_arr_h[1][this.var_int_aL] * 4 + 1];
            }
        }
    }

    final void cZ() {
        if (this.var_short_arr_b[this.var_int_aL] > 0 && this.var_byte_arr_arr_h[0][this.var_int_aL] != 1) {
            this.var_byte_arr_aT[0] = this.var_byte_arr_B[this.var_int_aL];
            this.var_byte_arr_aT[1] = this.var_byte_arr_C[this.var_int_aL];
            this.var_short_h = (short)((this.var_byte_arr_G[this.var_int_aL] + this.var_byte_arr_H[this.var_int_aL]) / b.Y[0] - this.var_byte_arr_aI[this.var_short_arr_h[2] + this.var_byte_arr_A[this.var_int_aL] * 12 + 0 + this.var_byte_arr_K[this.var_byte_arr_J[this.var_int_aL]]] / 2);
            this.var_short_i = (short)(b.B[1] / 2 + (this.var_byte_arr_G[this.var_int_aL] - this.var_byte_arr_H[this.var_int_aL]) / b.Y[1] - this.var_byte_arr_aI[this.var_short_arr_h[20] + this.var_byte_arr_A[this.var_int_aL] * 4 + 0] - 15);
            int n = this.var_int_aL;
            this.var_byte_arr_L[n] = (byte)(this.var_byte_arr_L[n] - this.var_short_arr_b[this.var_int_aL]);
            this.var_int_k += this.var_short_arr_b[this.var_int_aL];
            this.var_int_d += this.var_short_arr_b[this.var_int_aL];
            this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
            this.var_java_lang_StringBuffer_a.append("+");
            this.var_java_lang_StringBuffer_a.append(this.var_short_arr_b[this.var_int_aL]);
            this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
            this.var_short_arr_b[this.var_int_aL] = 0;
            this.dL();
            this.var_byte_arr_P[this.var_int_aL] = this.byte_a(this.var_byte_arr_P[this.var_int_aL] + this.var_short_arr_g[this.var_byte_arr_aI[this.var_short_arr_h[57] + -1 - this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 2] * 2 + 0]][this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_X[this.var_int_aL] * 4 + 2] * 2 + 1]]]]);
        }
    }

    final void da() {
        this.var_byte_arr_W[this.var_int_aL] = -1;
        this.var_byte_arr_F[this.var_int_aL] = 1;
        this.var_byte_arr_J[this.var_int_aL] = 0;
        this.var_short_arr_c[this.var_int_aL] = 1;
        this.var_byte_arr_G[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[78] + 2];
        this.var_byte_arr_H[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[78] + 3];
        this.var_int_ay = this.var_int_aL;
        this.dp();
        this.var_byte_arr_B[this.var_int_aL] = (byte)(this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] + this.var_byte_arr_aI[this.var_short_arr_h[78] + 0]);
        this.var_byte_arr_C[this.var_int_aL] = (byte)(this.var_byte_arr_arr_l[1][this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] + this.var_byte_arr_aI[this.var_short_arr_h[78] + 1]);
        this.var_short_arr_d[this.var_int_aL] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
        this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] = (short)this.var_int_aL;
    }

    final void db() {
        if (this.var_byte_arr_G[this.var_int_aL] >= 20 || this.var_byte_arr_H[this.var_int_aL] >= 20 || this.var_byte_arr_G[this.var_int_aL] < 0 || this.var_byte_arr_H[this.var_int_aL] < 0) {
            int n = this.var_int_aL;
            this.var_byte_arr_G[n] = (byte)(this.var_byte_arr_G[n] - 20 * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + 0]);
            int n2 = this.var_int_aL;
            this.var_byte_arr_H[n2] = (byte)(this.var_byte_arr_H[n2] - 20 * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + 1]);
            this.var_int_ay = this.var_int_aL;
            this.dp();
            this.var_byte_arr_B[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + 0]);
            this.var_byte_arr_C[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + 1]);
            this.var_short_arr_d[this.var_int_aL] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
            this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] = (short)this.var_int_aL;
        }
    }

    final void dc() {
        this.var_int_aQ = this.var_byte_arr_arr_h[0][this.var_int_aL] != 1 ? this.var_byte_arr_F[this.var_int_aL] : 0;
        if (this.var_byte_arr_arr_h[0][this.var_int_aL] != 1) {
            int n = this.var_int_aL;
            this.var_byte_arr_G[n] = (byte)(this.var_byte_arr_G[n] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + 0] * this.var_byte_arr_I[this.var_int_aL]);
            int n2 = this.var_int_aL;
            this.var_byte_arr_H[n2] = (byte)(this.var_byte_arr_H[n2] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + 1] * this.var_byte_arr_I[this.var_int_aL]);
            int n3 = this.var_int_aL;
            this.var_byte_arr_J[n3] = (byte)(this.var_byte_arr_J[n3] + 1);
            if (this.var_byte_arr_J[this.var_int_aL] > 3) {
                this.var_byte_arr_J[this.var_int_aL] = 0;
            }
            this.var_int_aM = (this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]]][this.var_int_aL] - this.var_byte_arr_aI[this.var_short_arr_h[this.var_byte_arr_arr_q[this.var_byte_arr_arr_h[0][this.var_int_aL]][this.var_byte_arr_arr_h[2][this.var_int_aL]]] + this.var_int_aQ * 16 + this.var_byte_arr_arr_h[1][this.var_int_aL] * 4 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]] + 1]) * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]]];
            this.cW();
            return;
        }
        this.cY();
        this.cZ();
    }

    final void dd() {
        this.var_int_aM = (this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]]][this.var_int_aL] - this.var_byte_arr_aI[this.var_short_arr_h[this.var_byte_arr_aK[this.var_byte_arr_arr_h[2][this.var_int_aL]]] + this.var_byte_arr_F[this.var_int_aL] * 12 + this.var_byte_arr_arr_h[1][this.var_int_aL] * 4 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]] + 1]) * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]]];
        if (this.var_int_aM >= 0) {
            this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]]][this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[this.var_byte_arr_aK[this.var_byte_arr_arr_h[2][this.var_int_aL]]] + this.var_byte_arr_F[this.var_int_aL] * 12 + this.var_byte_arr_arr_h[1][this.var_int_aL] * 4 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]] + 1];
            this.var_byte_arr_X[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[this.var_byte_arr_aK[this.var_byte_arr_arr_h[2][this.var_int_aL]]] + this.var_byte_arr_F[this.var_int_aL] * 12 + this.var_byte_arr_arr_h[1][this.var_int_aL] * 4 + 3];
            byte[] byArray = this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]]];
            int n = this.var_int_aL;
            byArray[n] = (byte)(byArray[n] + this.var_int_aM * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_X[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_X[this.var_int_aL]]]);
            byte[] byArray2 = this.var_byte_arr_arr_h[1];
            int n2 = this.var_int_aL;
            byArray2[n2] = (byte)(byArray2[n2] + 1);
            if (this.var_byte_arr_arr_h[1][this.var_int_aL] == this.var_byte_arr_arr_r[this.var_byte_arr_arr_h[2][this.var_int_aL]][this.var_byte_arr_F[this.var_int_aL]]) {
                this.var_byte_arr_W[this.var_int_aL] = -1;
                this.var_byte_arr_F[this.var_int_aL] = this.var_byte_arr_X[this.var_int_aL];
            }
        }
    }

    final void de() {
        if (this.var_byte_g / 4 == 0 && this.var_byte_e == 0 && this.var_byte_arr_W[this.var_int_aL] == -1 && this.var_int_aL < 200) {
            this.dy();
        }
        if (this.var_byte_arr_W[this.var_int_aL] == 9) {
            if (this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] != 23) {
                if (this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] == 0) {
                    this.var_int_aM = this.var_byte_arr_G[this.var_int_aL] - 4;
                    if (this.var_byte_arr_C[this.var_int_aL] != this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] || this.var_byte_arr_H[this.var_int_aL] != 10) {
                        this.var_int_aM += (this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] - this.var_byte_arr_C[this.var_int_aL]) * 20 + 10 - this.var_byte_arr_H[this.var_int_aL];
                    }
                } else {
                    this.var_int_aM = 19 - this.var_byte_arr_H[this.var_int_aL] - 4;
                    if (this.var_byte_arr_B[this.var_int_aL] != this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] || this.var_byte_arr_G[this.var_int_aL] != 10) {
                        this.var_int_aM += (this.var_byte_arr_B[this.var_int_aL] - this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]]) * 20 - 10 + this.var_byte_arr_G[this.var_int_aL];
                    }
                }
                if (this.var_byte_arr_ad[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] * 6 >= this.var_int_aM) {
                    this.ds();
                    return;
                }
            } else {
                if (this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] == 5 && this.var_byte_arr_G[this.var_int_aL] < 6) {
                    this.var_byte_arr_G[this.var_int_aL] = -1;
                }
                if (this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] == 6 && this.var_byte_arr_H[this.var_int_aL] > 13) {
                    this.var_byte_arr_H[this.var_int_aL] = 20;
                }
            }
        }
    }

    final void df() {
        if (this.var_byte_arr_A[this.var_int_aL] != 10) {
            if (this.var_byte_arr_W[this.var_int_aL] == 10) {
                this.var_byte_arr_J[this.var_int_aL] = 0;
                int n = this.var_int_aL;
                this.var_byte_arr_G[n] = (byte)(this.var_byte_arr_G[n] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + 0] * 2);
                int n2 = this.var_int_aL;
                this.var_byte_arr_H[n2] = (byte)(this.var_byte_arr_H[n2] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + 1] * 2);
                return;
            }
            int n = this.var_int_aL;
            this.var_byte_arr_G[n] = (byte)(this.var_byte_arr_G[n] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + 0] * this.var_byte_arr_I[this.var_int_aL]);
            int n3 = this.var_int_aL;
            this.var_byte_arr_H[n3] = (byte)(this.var_byte_arr_H[n3] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + 1] * this.var_byte_arr_I[this.var_int_aL]);
            int n4 = this.var_int_aL;
            this.var_byte_arr_J[n4] = (byte)(this.var_byte_arr_J[n4] + 1);
            if (this.var_byte_arr_J[this.var_int_aL] > 3) {
                this.var_byte_arr_J[this.var_int_aL] = 0;
                return;
            }
        } else if (this.var_byte_arr_ac[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] > 0 && this.var_short_arr_c[this.var_int_aL] % this.var_byte_arr_aw[23] == 0) {
            this.var_byte_arr_W[this.var_int_aL] = 8;
            this.var_byte_arr_arr_h[1][this.var_int_aL] = 0;
            this.var_byte_arr_X[this.var_int_aL] = 0;
            this.var_byte_arr_G[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[79] + 2];
            this.var_byte_arr_H[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[79] + 3];
            this.var_int_ay = this.var_int_aL;
            this.dp();
            this.var_byte_arr_B[this.var_int_aL] = (byte)(this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] + this.var_byte_arr_aI[this.var_short_arr_h[79] + 0]);
            this.var_byte_arr_C[this.var_int_aL] = (byte)(this.var_byte_arr_arr_l[1][this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] + this.var_byte_arr_aI[this.var_short_arr_h[79] + 1]);
            this.var_short_arr_d[this.var_int_aL] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
            this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] = (short)this.var_int_aL;
        }
    }

    final void dg() {
        if (this.var_byte_arr_W[this.var_int_aL] == -1 || this.var_byte_arr_W[this.var_int_aL] == 18) {
            this.var_int_aM = (this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]][this.var_int_aL] - this.var_byte_arr_aI[this.var_short_arr_h[12] + 0 + this.var_byte_arr_F[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]]) * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]];
            if (this.var_int_aM >= 0 && this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 1] * 2 + 0] == this.var_byte_arr_D[this.var_int_aL] && this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 1] * 2 + 1] == this.var_byte_arr_E[this.var_int_aL]) {
                this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]][this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[12] + 0 + this.var_byte_arr_F[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]];
                this.var_byte_arr_F[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 1];
                byte[] byArray = this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]];
                int n = this.var_int_aL;
                byArray[n] = (byte)(byArray[n] + this.var_int_aM * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]]);
            }
            this.var_int_aM = (this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]][this.var_int_aL] - this.var_byte_arr_aI[this.var_short_arr_h[12] + 8 + this.var_byte_arr_F[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]]) * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]];
            if (this.var_int_aM >= 0 && (this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 3] * 2 + 0] == this.var_byte_arr_D[this.var_int_aL] && this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 3] * 2 + 1] == this.var_byte_arr_E[this.var_int_aL] || this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 2] * 2 + 0] == this.var_byte_arr_D[this.var_int_aL] && this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 2] * 2 + 1] == this.var_byte_arr_E[this.var_int_aL] || this.var_byte_arr_D[this.var_int_aL] < 0)) {
                this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]][this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[12] + 8 + this.var_byte_arr_F[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]];
                this.var_byte_arr_F[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 3];
                byte[] byArray = this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]];
                int n = this.var_int_aL;
                byArray[n] = (byte)(byArray[n] + this.var_int_aM * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]]);
                if (this.var_byte_arr_D[this.var_int_aL] < 0) {
                    this.dq();
                    return;
                }
            }
        } else {
            this.var_int_aM = (this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]][this.var_int_aL] - 10) * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]];
            if (this.var_int_aM >= 0) {
                if (this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 1] * 2 + 0] == this.var_byte_arr_D[this.var_int_aL] && this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 1] * 2 + 1] == this.var_byte_arr_E[this.var_int_aL]) {
                    this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]][this.var_int_aL] = 10;
                    this.var_byte_arr_F[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 1];
                    byte[] byArray = this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]];
                    int n = this.var_int_aL;
                    byArray[n] = (byte)(byArray[n] + this.var_int_aM * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]]);
                }
                if (this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 3] * 2 + 0] == this.var_byte_arr_D[this.var_int_aL] && this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 3] * 2 + 1] == this.var_byte_arr_E[this.var_int_aL]) {
                    this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]][this.var_int_aL] = 10;
                    this.var_byte_arr_F[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 3];
                    byte[] byArray = this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]];
                    int n = this.var_int_aL;
                    byArray[n] = (byte)(byArray[n] + this.var_int_aM * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[104] + this.var_byte_arr_F[this.var_int_aL]]]);
                }
            }
        }
    }

    final void dh() {
        if (this.var_byte_arr_W[this.var_int_aL] == 14) {
            this.var_byte_arr_G[this.var_int_aL] = this.var_byte_arr_arr_o[22][this.var_short_arr_arr_g[22][21] + this.var_byte_arr_F[this.var_int_aL] * 11 + this.var_short_arr_c[this.var_int_aL]];
            this.var_byte_arr_H[this.var_int_aL] = this.var_byte_arr_arr_o[22][this.var_short_arr_arr_g[22][22] + this.var_byte_arr_F[this.var_int_aL] * 11 + this.var_short_arr_c[this.var_int_aL]];
            int n = this.var_int_aL;
            this.var_byte_arr_J[n] = (byte)(this.var_byte_arr_J[n] + 1);
            if (this.var_byte_arr_J[this.var_int_aL] > 3) {
                this.var_byte_arr_J[this.var_int_aL] = 0;
            }
            if (this.var_short_arr_c[this.var_int_aL] >= this.var_byte_arr_as[22]) {
                this.var_int_ay = this.var_int_aL;
                this.dp();
                this.var_byte_arr_B[this.var_int_aL] = this.var_byte_arr_D[this.var_int_aL];
                this.var_byte_arr_C[this.var_int_aL] = this.var_byte_arr_E[this.var_int_aL];
                this.var_short_arr_d[this.var_int_aL] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
                this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] = (short)this.var_int_aL;
                if (this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] == 13) {
                    this.var_byte_arr_P[this.var_int_aL] = this.byte_a(this.var_byte_arr_P[this.var_int_aL] + this.var_short_arr_f[22]);
                    this.var_byte_arr_W[this.var_int_aL] = 10;
                    this.var_byte_arr_aT[0] = this.var_byte_arr_B[this.var_int_aL];
                    this.var_byte_arr_aT[1] = this.var_byte_arr_C[this.var_int_aL];
                    this.var_short_h = (short)((this.var_byte_arr_G[this.var_int_aL] + this.var_byte_arr_H[this.var_int_aL]) / b.Y[0] - this.var_byte_arr_aI[this.var_short_arr_h[2] + this.var_byte_arr_A[this.var_int_aL] * 12 + 0 + this.var_byte_arr_K[this.var_byte_arr_J[this.var_int_aL]]] / 2);
                    this.var_short_i = (short)(b.B[1] / 2 + (this.var_byte_arr_G[this.var_int_aL] - this.var_byte_arr_H[this.var_int_aL]) / b.Y[1] - this.var_byte_arr_aI[this.var_short_arr_h[20] + this.var_byte_arr_A[this.var_int_aL] * 4 + 0] - 15);
                    this.var_int_k += this.var_short_arr_b[this.var_int_aL];
                    this.var_int_d += this.var_short_arr_b[this.var_int_aL];
                    int n2 = this.var_int_aL;
                    this.var_byte_arr_L[n2] = (byte)(this.var_byte_arr_L[n2] - this.var_short_arr_b[this.var_int_aL]);
                    this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
                    this.var_java_lang_StringBuffer_a.append("+");
                    this.var_java_lang_StringBuffer_a.append(this.var_short_arr_b[this.var_int_aL]);
                    this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
                    this.dL();
                    this.var_short_arr_b[this.var_int_aL] = 0;
                } else {
                    this.var_byte_arr_W[this.var_int_aL] = -1;
                }
                this.dq();
            }
        }
    }

    final void di() {
        this.var_int_ay = this.var_int_aL;
        this.dp();
        this.var_byte_arr_aT[0] = this.var_byte_arr_B[this.var_int_aL];
        this.var_byte_arr_aT[1] = this.var_byte_arr_C[this.var_int_aL];
        this.var_short_h = (short)(this.var_byte_arr_aI[this.var_short_arr_h[27] + (this.var_byte_arr_B[this.var_int_aL] - this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]]) * 4 + this.var_byte_arr_H[this.var_int_aL]] - this.var_byte_arr_aI[this.var_short_arr_h[43] + this.var_byte_arr_A[this.var_int_aL]] / 2);
        this.var_short_i = (short)(this.var_byte_arr_aI[this.var_short_arr_h[28] + (this.var_byte_arr_B[this.var_int_aL] - this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]]) * 4 + this.var_byte_arr_H[this.var_int_aL]] - this.var_byte_arr_aI[this.var_short_arr_h[44] + this.var_byte_arr_A[this.var_int_aL]] - 15);
        int n = this.var_int_aL;
        this.var_byte_arr_L[n] = (byte)(this.var_byte_arr_L[n] - this.var_short_arr_b[this.var_int_aL]);
        this.var_int_k += this.var_short_arr_b[this.var_int_aL];
        this.var_int_d += this.var_short_arr_b[this.var_int_aL];
        this.var_java_lang_StringBuffer_a.delete(0, this.var_java_lang_StringBuffer_a.length());
        this.var_java_lang_StringBuffer_a.append("+");
        this.var_java_lang_StringBuffer_a.append(this.var_short_arr_b[this.var_int_aL]);
        this.var_java_lang_String_a = this.var_java_lang_StringBuffer_a.toString();
        this.var_short_arr_b[this.var_int_aL] = 0;
        this.dL();
        this.var_byte_arr_F[this.var_int_aL] = this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]];
        this.var_byte_arr_B[this.var_int_aL] = (byte)(this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] + this.var_byte_arr_aI[this.var_short_arr_h[77] + 0]);
        this.var_byte_arr_C[this.var_int_aL] = (byte)(this.var_byte_arr_arr_l[1][this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] + this.var_byte_arr_aI[this.var_short_arr_h[77] + 1]);
        this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + 0]);
        this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + 1]);
        this.var_short_arr_d[this.var_int_aL] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
        this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] = (short)this.var_int_aL;
        this.var_byte_arr_G[this.var_int_aL] = b.var_byte_arr_arr_f[this.var_byte_arr_F[this.var_int_aL]][0];
        this.var_byte_arr_H[this.var_int_aL] = b.var_byte_arr_arr_f[this.var_byte_arr_F[this.var_int_aL]][1];
        this.var_byte_arr_Q[this.var_int_aL] = this.byte_a(this.var_byte_arr_Q[this.var_int_aL] - 50);
        this.var_byte_arr_R[this.var_int_aL] = this.byte_a(this.var_byte_arr_R[this.var_int_aL] - 60);
        this.var_byte_arr_T[this.var_int_aL] = this.byte_a(this.var_byte_arr_T[this.var_int_aL] - 60);
        this.var_byte_arr_W[this.var_int_aL] = -1;
        this.var_int_aO = 0;
        while (this.var_int_aO < this.var_byte_arr_au[23]) {
            if (this.var_short_arr_arr_e[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]][this.var_int_aO] == this.var_int_aL) {
                this.var_short_arr_arr_e[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]][this.var_int_aO] = -1;
                return;
            }
            ++this.var_int_aO;
        }
    }

    final void dj() {
        if (this.var_byte_arr_W[this.var_int_aL] == 15 || this.var_byte_arr_W[this.var_int_aL] == 16) {
            int n = this.var_int_aL;
            this.var_byte_arr_J[n] = (byte)(this.var_byte_arr_J[n] + 1);
            if (this.var_byte_arr_J[this.var_int_aL] > 3) {
                this.var_byte_arr_J[this.var_int_aL] = 0;
            }
            if (this.var_byte_arr_W[this.var_int_aL] == 15) {
                byte[] byArray = this.var_byte_arr_arr_h[0];
                int n2 = this.var_int_aL;
                byArray[n2] = (byte)(byArray[n2] + ((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3 - 1));
                byte[] byArray2 = this.var_byte_arr_arr_h[1];
                int n3 = this.var_int_aL;
                byArray2[n3] = (byte)(byArray2[n3] + ((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3 - 1));
                if (this.var_byte_arr_arr_h[0][this.var_int_aL] < -2) {
                    this.var_byte_arr_arr_h[0][this.var_int_aL] = -2;
                }
                if (this.var_byte_arr_arr_h[0][this.var_int_aL] > 2) {
                    this.var_byte_arr_arr_h[0][this.var_int_aL] = 2;
                }
                if (this.var_byte_arr_arr_h[1][this.var_int_aL] < -2) {
                    this.var_byte_arr_arr_h[1][this.var_int_aL] = -2;
                }
                if (this.var_byte_arr_arr_h[1][this.var_int_aL] > 2) {
                    this.var_byte_arr_arr_h[1][this.var_int_aL] = 2;
                }
            }
            if (this.var_short_arr_c[this.var_int_aL] >= this.var_byte_r) {
                if (this.var_byte_arr_W[this.var_int_aL] == 15) {
                    this.var_int_aN = this.var_int_aL;
                    this.var_int_aL = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aN]][this.var_byte_arr_C[this.var_int_aN]];
                    while (this.var_int_aL >= 0) {
                        if (this.var_byte_arr_W[this.var_int_aL] == 17) {
                            this.var_byte_arr_W[this.var_int_aL] = -1;
                            this.var_byte_bj = 1;
                            this.dF();
                            this.dq();
                        }
                        this.var_int_aL = this.var_short_arr_d[this.var_int_aL];
                    }
                    this.var_int_aL = this.var_int_aN;
                }
                this.var_byte_arr_W[this.var_int_aL] = -1;
                this.var_byte_arr_V[this.var_int_aL] = 0;
                this.var_byte_bj = 0;
                this.dF();
            }
        }
    }

    final void dk() {
        if (this.var_byte_arr_A[this.var_int_aL] == 8) {
            this.var_int_aM = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
            while (this.var_int_aM >= 0) {
                if (this.var_int_aM < 200) {
                    if (this.var_byte_arr_W[this.var_int_aM] == 15 || this.var_byte_arr_W[this.var_int_aM] == 16) {
                        this.var_short_arr_c[this.var_int_aM] = this.var_byte_r;
                    } else {
                        this.var_byte_arr_V[this.var_int_aM] = 0;
                    }
                }
                this.var_int_aM = this.var_short_arr_d[this.var_int_aM];
            }
        }
        if (this.var_byte_arr_A[this.var_int_aL] == 9 && this.var_byte_arr_W[this.var_int_aL] == -1 && this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] > 3 && this.var_byte_arr_F[this.var_int_aL] > 1 && (this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] == 0 && this.var_byte_arr_H[this.var_int_aL] >= 15 || this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] == 1 && this.var_byte_arr_G[this.var_int_aL] <= 4)) {
            this.var_byte_arr_J[this.var_int_aL] = 0;
            this.var_byte_arr_W[this.var_int_aL] = 17;
            this.var_byte_arr_ai[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] = 2;
        }
    }

    final void dl() {
        if (!(this.var_byte_arr_W[this.var_int_aL] >= 11 && this.var_byte_arr_W[this.var_int_aL] != 18 || this.var_byte_arr_A[this.var_int_aL] == 10 || this.var_byte_arr_G[this.var_int_aL] < 20 && this.var_byte_arr_H[this.var_int_aL] < 20 && this.var_byte_arr_G[this.var_int_aL] >= 0 && this.var_byte_arr_H[this.var_int_aL] >= 0)) {
            if (this.var_byte_arr_B[this.var_int_aL] != this.var_byte_ab || this.var_byte_arr_C[this.var_int_aL] != 0 || this.var_byte_arr_H[this.var_int_aL] >= 0) {
                if (this.var_byte_arr_G[this.var_int_aL] == 10 || this.var_byte_arr_H[this.var_int_aL] == 10) {
                    if (this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] == 0 && (this.var_byte_arr_F[this.var_int_aL] == 2 && this.var_byte_arr_arr_b[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]] != 5 || this.var_byte_arr_F[this.var_int_aL] == 3 && this.var_byte_arr_arr_b[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]] != 6 || this.var_byte_arr_arr_f[0][this.var_int_aL] != this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]]])) {
                        this.dw();
                        return;
                    }
                    if (!(this.var_boolean_arr_c[this.var_byte_arr_arr_c[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]]] && this.var_boolean_arr_b[this.var_byte_arr_arr_c[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]]] && this.var_boolean_arr_a[this.var_byte_arr_arr_c[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]]] && this.var_byte_arr_ah[this.var_byte_arr_arr_c[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]]] >= 10 || this.var_byte_arr_W[this.var_int_aL] != 9)) {
                        this.var_byte_arr_W[this.var_int_aL] = -1;
                        this.dw();
                        return;
                    }
                } else if (this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] == 0 && this.var_byte_arr_arr_b[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]] != 0) {
                    if (this.var_byte_arr_A[this.var_int_aL] != 9) {
                        this.dw();
                        return;
                    }
                    this.var_boolean_w = true;
                    if (this.var_byte_arr_arr_b[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]] != 7 && this.var_byte_arr_arr_b[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]] != 8) {
                        this.var_boolean_w = false;
                    } else if (this.var_byte_arr_ah[this.var_byte_arr_arr_c[this.var_byte_arr_D[this.var_int_aL]][this.var_byte_arr_E[this.var_int_aL]]] > 50) {
                        this.var_boolean_w = false;
                    }
                    if (!this.var_boolean_w) {
                        this.dw();
                        return;
                    }
                }
                this.dm();
                return;
            }
            if (this.var_byte_arr_H[this.var_int_aL] <= -100 && this.var_byte_arr_W[this.var_int_aL] == 18) {
                this.cS();
                return;
            }
            if (this.var_byte_arr_H[this.var_int_aL] >= -3 && this.var_byte_arr_W[this.var_int_aL] == -1) {
                this.dq();
            }
        }
    }

    final void dm() {
        int n = this.var_int_aL;
        this.var_byte_arr_G[n] = (byte)(this.var_byte_arr_G[n] - 20 * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + 0]);
        int n2 = this.var_int_aL;
        this.var_byte_arr_H[n2] = (byte)(this.var_byte_arr_H[n2] - 20 * this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + 1]);
        if (this.var_byte_arr_W[this.var_int_aL] == 9 && this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] == 23) {
            if (this.var_byte_arr_ac[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] >= this.var_byte_arr_au[23]) {
                this.var_byte_arr_F[this.var_int_aL] = this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]];
                this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + 0]);
                this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + 1]);
                this.var_byte_arr_G[this.var_int_aL] = b.var_byte_arr_arr_f[this.var_byte_arr_F[this.var_int_aL]][0];
                this.var_byte_arr_H[this.var_int_aL] = b.var_byte_arr_arr_f[this.var_byte_arr_F[this.var_int_aL]][1];
                this.var_byte_arr_W[this.var_int_aL] = -1;
                return;
            }
            this.cfr_renamed_0();
        }
        this.dn();
    }

    final void dn() {
        this.var_int_ay = this.var_int_aL;
        this.dp();
        this.var_byte_arr_B[this.var_int_aL] = this.var_byte_arr_D[this.var_int_aL];
        this.var_byte_arr_C[this.var_int_aL] = this.var_byte_arr_E[this.var_int_aL];
        this.var_short_arr_d[this.var_int_aL] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
        this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] = (short)this.var_int_aL;
        if (this.var_int_aL < 200 && this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] > 3 && this.var_byte_arr_W[this.var_int_aL] == -1 && this.var_byte_arr_F[this.var_int_aL] > 1) {
            if (this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] == 22) {
                this.var_int_aZ = this.var_int_aL;
                this.dD();
                this.var_byte_arr_W[this.var_int_aL] = 14;
                this.var_short_arr_c[this.var_int_aL] = 0;
            } else {
                this.var_int_aZ = this.var_int_aL;
                this.dD();
                this.var_byte_arr_W[this.var_int_aL] = 9;
            }
        }
        if (this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] != 13 && this.var_byte_arr_W[this.var_int_aL] == 10) {
            this.var_byte_arr_W[this.var_int_aL] = 14;
            this.var_short_arr_c[this.var_int_aL] = 0;
            this.var_byte_arr_G[this.var_int_aL] = this.var_byte_arr_arr_o[22][this.var_short_arr_arr_g[22][21] + this.var_byte_arr_F[this.var_int_aL] * 11 + this.var_short_arr_c[this.var_int_aL]];
            this.var_byte_arr_H[this.var_int_aL] = this.var_byte_arr_arr_o[22][this.var_short_arr_arr_g[22][22] + this.var_byte_arr_F[this.var_int_aL] * 11 + this.var_short_arr_c[this.var_int_aL]];
            this.var_byte_arr_P[this.var_int_aL] = this.byte_a(this.var_byte_arr_P[this.var_int_aL] + this.var_byte_arr_ad[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]]);
        }
        if (this.var_byte_arr_W[this.var_int_aL] != 12) {
            this.dq();
        }
        this.dB();
    }

    final void cfr_renamed_0() {
        byte by = this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
        this.var_byte_arr_ac[by] = (byte)(this.var_byte_arr_ac[by] + 1);
        this.var_int_aO = 0;
        while (this.var_int_aO < this.var_byte_arr_au[23]) {
            if (this.var_short_arr_arr_e[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]][this.var_int_aO] < 0) {
                this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_arr_l[0][this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] + this.var_byte_arr_aI[this.var_short_arr_h[4] + this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] * 6 + this.var_int_aO % 3 * 2 + 0]);
                this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_arr_l[1][this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] + this.var_byte_arr_aI[this.var_short_arr_h[4] + this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] * 6 + this.var_int_aO % 3 * 2 + 1]);
                this.var_byte_arr_H[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[87] + this.var_int_aO / 3];
                this.var_short_arr_arr_e[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]][this.var_int_aO] = (short)this.var_int_aL;
                break;
            }
            ++this.var_int_aO;
        }
        this.var_byte_arr_F[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[86] + this.var_byte_arr_H[this.var_int_aL]];
        this.var_byte_arr_J[this.var_int_aL] = 0;
        this.var_short_arr_c[this.var_int_aL] = 0;
        this.var_byte_arr_W[this.var_int_aL] = 12;
        this.var_byte_arr_P[this.var_int_aL] = this.byte_a(this.var_byte_arr_P[this.var_int_aL] + this.var_short_arr_g[5]);
    }

    final void dp() {
        this.var_int_aP = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_ay]][this.var_byte_arr_C[this.var_int_ay]];
        if (this.var_int_aP == this.var_int_ay) {
            this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_ay]][this.var_byte_arr_C[this.var_int_ay]] = this.var_short_arr_d[this.var_int_ay];
            return;
        }
        while (this.var_int_aP >= 0) {
            if (this.var_short_arr_d[this.var_int_aP] == this.var_int_ay) {
                this.var_short_arr_d[this.var_int_aP] = this.var_short_arr_d[this.var_int_ay];
                return;
            }
            this.var_int_aP = this.var_short_arr_d[this.var_int_aP];
        }
    }

    final void dq() {
        try {
            if (this.var_byte_arr_A[this.var_int_aL] != 8 && this.var_byte_arr_A[this.var_int_aL] != 9) {
                if (this.boolean_b()) {
                    return;
                }
                if (this.boolean_c()) {
                    return;
                }
                if (this.boolean_d()) {
                    return;
                }
                if (this.boolean_e()) {
                    return;
                }
                if (this.boolean_i()) {
                    return;
                }
            } else if (this.var_byte_arr_A[this.var_int_aL] == 9 && this.boolean_k()) {
                return;
            }
            this.var_int_aO = 0;
            while (this.var_int_aO < 4) {
                this.var_byte_arr_z[this.var_int_aO] = this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 0] >= this.var_byte_O || this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 1] >= this.var_byte_O || this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 0] < 0 || this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 1] < 0 ? (byte)1 : this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 0]][this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 1]];
                ++this.var_int_aO;
            }
            if (this.boolean_l()) {
                return;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final boolean boolean_b() {
        if (this.var_byte_arr_W[this.var_int_aL] == 14 || this.var_byte_arr_W[this.var_int_aL] == -1 && this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] > 3 && this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] == 22) {
            this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 0] * 2 + 0]);
            this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 0] * 2 + 1]);
            return true;
        }
        if (this.var_byte_arr_W[this.var_int_aL] == 18 && this.var_byte_arr_B[this.var_int_aL] == this.var_byte_ab && this.var_byte_arr_C[this.var_int_aL] == 0) {
            this.var_byte_arr_D[this.var_int_aL] = this.var_byte_ab;
            this.var_byte_arr_E[this.var_int_aL] = -1;
            return true;
        }
        return false;
    }

    final boolean boolean_c() {
        if (this.var_byte_arr_W[this.var_int_aL] == 10) {
            this.var_int_aO = 0;
            while (this.var_int_aO < 4) {
                if (this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 0] >= this.var_byte_O || this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 1] >= this.var_byte_O || this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 0] < 0 || this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 1] < 0) {
                    this.var_byte_arr_z[this.var_int_aO] = 1;
                } else {
                    this.var_byte_arr_z[this.var_int_aO] = this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 0]][this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 1]];
                    if (this.var_byte_arr_z[this.var_int_aO] == 7 && this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] == 1 || this.var_byte_arr_z[this.var_int_aO] == 8 && this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] == 0) {
                        this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 0]);
                        this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + this.var_int_aO] * 2 + 1]);
                        return true;
                    }
                }
                ++this.var_int_aO;
            }
            if (this.var_byte_arr_z[0] == 13) {
                this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 0] * 2 + 0]);
                this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 0] * 2 + 1]);
                return true;
            }
            if (this.var_byte_arr_z[1] == 13) {
                this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 1] * 2 + 0]);
                this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 1] * 2 + 1]);
                return true;
            }
            if (this.var_byte_arr_z[3] == 13) {
                this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 3] * 2 + 0]);
                this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 3] * 2 + 1]);
                return true;
            }
            this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 2] * 2 + 0]);
            this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 2] * 2 + 1]);
            return true;
        }
        return false;
    }

    final boolean boolean_d() {
        if (this.var_byte_arr_W[this.var_int_aL] == 9) {
            if (this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] == 0) {
                if (this.var_byte_arr_C[this.var_int_aL] == this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]]) {
                    this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + 4 + 0]);
                    this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + 4 + 1]);
                } else {
                    this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + 6 + 0]);
                    this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + 6 + 1]);
                }
            } else if (this.var_byte_arr_B[this.var_int_aL] == this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]]) {
                this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + 6 + 0]);
                this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + 6 + 1]);
            } else {
                this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + 4 + 0]);
                this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + 4 + 1]);
            }
            return true;
        }
        if ((this.var_byte_arr_W[this.var_int_aL] == -1 || this.var_byte_arr_W[this.var_int_aL] == 18) && this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] >= 4 && this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] <= 6) {
            this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] * 2 + 0]);
            this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] * 2 + 1]);
            return true;
        }
        return false;
    }

    final boolean boolean_e() {
        if (this.var_byte_arr_W[this.var_int_aL] != 18) {
            if (this.var_byte_arr_Q[this.var_int_aL] > 50) {
                this.var_int_aO = 0;
                while (this.var_int_aO < 2) {
                    if (this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] == 0 && (this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] & b.X[this.var_int_aO]) != 0) {
                        this.var_int_aQ = 0;
                        this.var_int_aP = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
                        while (this.var_int_aP >= 0) {
                            if (this.var_byte_arr_W[this.var_int_aP] == 1 && this.var_byte_arr_arr_h[2][this.var_int_aP] == this.var_int_aO && this.var_byte_arr_arr_h[0][this.var_int_aP] < 2) {
                                ++this.var_int_aQ;
                            }
                            this.var_int_aP = this.var_short_arr_d[this.var_int_aP];
                        }
                        if (this.var_int_aQ < 2) {
                            this.var_byte_arr_W[this.var_int_aL] = 1;
                            this.var_byte_arr_arr_h[0][this.var_int_aL] = 0;
                            this.var_byte_arr_arr_h[1][this.var_int_aL] = 0;
                            this.var_byte_arr_arr_h[2][this.var_int_aL] = (byte)this.var_int_aO;
                            this.var_byte_arr_X[this.var_int_aL] = this.var_byte_arr_F[this.var_int_aL];
                            this.var_short_arr_b[this.var_int_aL] = 0;
                            break;
                        }
                    }
                    ++this.var_int_aO;
                }
            }
            if (this.boolean_f()) {
                return true;
            }
        }
        return false;
    }

    final boolean boolean_f() {
        this.var_int_aQ = 0;
        while (this.var_int_aQ < 2) {
            if (!(this.var_int_aQ == 0 && this.var_byte_arr_B[this.var_int_aL] == 0 || this.var_int_aQ == 1 && this.var_byte_arr_C[this.var_int_aL] == this.var_byte_O - 1)) {
                this.var_byte_arr_aZ[0] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_aI[this.var_short_arr_h[103] + this.var_int_aQ] * 4 + 0] * 2 + 0]);
                this.var_byte_arr_aZ[1] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_aI[this.var_short_arr_h[103] + this.var_int_aQ] * 4 + 0] * 2 + 1]);
                this.var_byte_bc = this.var_byte_arr_arr_b[this.var_byte_arr_aZ[0]][this.var_byte_arr_aZ[1]];
                this.var_byte_bd = this.var_byte_arr_arr_c[this.var_byte_arr_aZ[0]][this.var_byte_arr_aZ[1]];
                if (this.var_byte_bc <= -15 && this.var_byte_bc >= -27) {
                    this.var_boolean_w = false;
                    if (this.var_boolean_arr_d[this.var_byte_bd]) {
                        if (this.boolean_g()) {
                            return true;
                        }
                        if (this.var_boolean_w) {
                            this.var_byte_arr_W[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[53] + -1 - this.var_byte_bc];
                            this.var_byte_arr_arr_h[0][this.var_int_aL] = 0;
                            this.var_byte_arr_arr_h[1][this.var_int_aL] = 0;
                            this.var_byte_arr_arr_h[2][this.var_int_aL] = (byte)this.var_int_aQ;
                            this.var_byte_arr_X[this.var_int_aL] = this.var_byte_arr_F[this.var_int_aL];
                            break;
                        }
                    }
                }
                this.var_boolean_w = false;
                if (this.boolean_h()) {
                    return true;
                }
                if (this.var_boolean_w) {
                    this.var_byte_arr_D[this.var_int_aL] = this.var_byte_arr_aZ[0];
                    this.var_byte_arr_E[this.var_int_aL] = this.var_byte_arr_aZ[1];
                    this.var_byte_arr_arr_f[1][this.var_int_aL] = this.var_byte_arr_arr_f[0][this.var_int_aL];
                    this.var_byte_arr_arr_f[0][this.var_int_aL] = this.var_byte_arr_Z[this.var_byte_bd];
                    byte[] byArray = this.var_byte_arr_arr_f[2];
                    int n = this.var_int_aL;
                    byArray[n] = (byte)(byArray[n] + 1);
                    this.var_byte_arr_arr_h[0][this.var_int_aL] = 0;
                    this.var_byte_arr_arr_h[1][this.var_int_aL] = 0;
                    this.var_byte_arr_arr_h[2][this.var_int_aL] = (byte)this.var_int_aQ;
                    this.var_byte_arr_X[this.var_int_aL] = this.var_byte_arr_F[this.var_int_aL];
                    if (this.var_byte_arr_Z[this.var_byte_bd] != 23) {
                        this.var_short_arr_b[this.var_int_aL] = this.var_byte_arr_al[this.var_byte_arr_Z[this.var_byte_bd]];
                    }
                    this.var_byte_arr_W[this.var_int_aL] = 7;
                    return true;
                }
            }
            ++this.var_int_aQ;
        }
        return false;
    }

    final boolean boolean_g() {
        if (this.var_byte_arr_aI[this.var_short_arr_h[163 + this.var_int_aQ] - 1 - this.var_byte_bc] == 1 && (this.var_byte_arr_aI[this.var_short_arr_h[55] + -1 - this.var_byte_bc] >= this.var_byte_arr_arr_g[this.var_byte_arr_aI[this.var_short_arr_h[54] + -1 - this.var_byte_bc]][this.var_int_aL] && b.ar[this.var_byte_arr_aI[this.var_short_arr_h[54] + -1 - this.var_byte_bc]] == 0 || this.var_byte_arr_aI[this.var_short_arr_h[55] + -1 - this.var_byte_bc] <= this.var_byte_arr_arr_g[this.var_byte_arr_aI[this.var_short_arr_h[54] + -1 - this.var_byte_bc]][this.var_int_aL] && b.ar[this.var_byte_arr_aI[this.var_short_arr_h[54] + -1 - this.var_byte_bc]] == 1)) {
            if (this.var_byte_arr_aI[this.var_short_arr_h[57] + -1 - this.var_byte_bc] >= 0) {
                if (this.var_byte_arr_L[this.var_int_aL] >= this.var_byte_arr_aE[this.var_byte_arr_aI[this.var_short_arr_h[57] + -1 - this.var_byte_bc]]) {
                    this.var_short_arr_b[this.var_int_aL] = this.var_byte_arr_aE[this.var_byte_arr_aI[this.var_short_arr_h[57] + -1 - this.var_byte_bc]];
                    this.var_boolean_w = true;
                }
            } else {
                this.var_short_arr_b[this.var_int_aL] = 0;
                this.var_boolean_w = true;
            }
        }
        if ((this.var_byte_bc == -21 || this.var_byte_bc == -22 || this.var_byte_bc == -26) && this.var_boolean_w) {
            if (this.var_boolean_arr_e[this.var_byte_bd]) {
                this.var_boolean_w = false;
            } else {
                this.var_int_aP = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
                do {
                    if ((this.var_byte_arr_W[this.var_int_aP] == 4 || this.var_byte_arr_W[this.var_int_aP] == 6) && this.var_byte_arr_arr_h[2][this.var_int_aP] == this.var_int_aQ && this.var_int_aP != this.var_int_aL) {
                        this.var_boolean_w = false;
                        break;
                    }
                    this.var_int_aP = this.var_short_arr_d[this.var_int_aP];
                } while (this.var_int_aP >= 0);
            }
        }
        if (this.var_byte_arr_aI[this.var_short_arr_h[53] + -1 - this.var_byte_bc] == 5 && this.var_byte_arr_M[this.var_int_aL] > -1 && this.var_boolean_w) {
            this.var_short_arr_b[this.var_int_aL] = 0;
            this.var_boolean_w = false;
        }
        return false;
    }

    final boolean boolean_h() {
        if (this.var_byte_bc == 5 + this.var_int_aQ && this.var_boolean_arr_a[this.var_byte_bd] && this.var_boolean_arr_b[this.var_byte_bd] && this.var_boolean_arr_c[this.var_byte_bd] && this.var_byte_arr_ah[this.var_byte_bd] >= 10 && (this.var_byte_arr_Z[this.var_byte_bd] == 23 || this.var_byte_arr_L[this.var_int_aL] >= this.var_byte_arr_al[this.var_byte_arr_Z[this.var_byte_bd]])) {
            this.var_short_q = this.var_byte_bd;
            if (this.var_byte_arr_Z[this.var_byte_bd] != 22 && this.var_byte_arr_Z[this.var_byte_bd] != 23 && this.var_byte_arr_ad[this.var_byte_bd] < 10) {
                this.dA();
                this.var_short_q = (short)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 100);
                if (this.var_short_q < this.var_short_p) {
                    this.var_boolean_w = true;
                }
            } else if (this.var_byte_arr_Z[this.var_byte_bd] == 22 && this.var_short_arr_arr_c[this.var_byte_arr_aZ[0]][this.var_byte_arr_aZ[1]] == -1) {
                this.dA();
                this.var_short_q = (short)((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 100);
                if (this.var_short_q < this.var_short_p) {
                    this.var_boolean_w = true;
                }
                if (this.var_boolean_w) {
                    this.var_int_aP = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
                    do {
                        if (this.var_byte_arr_W[this.var_int_aP] == 7 && this.var_byte_arr_arr_h[2][this.var_int_aP] == this.var_int_aQ && this.var_int_aP != this.var_int_aL) {
                            this.var_boolean_w = false;
                            break;
                        }
                        this.var_int_aP = this.var_short_arr_d[this.var_int_aP];
                    } while (this.var_int_aP >= 0);
                }
            } else if (this.var_byte_arr_Z[this.var_byte_bd] == 23 && this.var_byte_arr_ac[this.var_byte_bd] < this.var_byte_arr_au[23] && (this.var_byte_arr_Q[this.var_int_aL] > 50 || this.var_byte_arr_R[this.var_int_aL] > 50 || this.var_byte_arr_T[this.var_int_aL] > 50) && this.var_byte_arr_L[this.var_int_aL] >= this.var_byte_arr_aE[this.var_byte_arr_aI[this.var_short_arr_h[57] + 27 + 1]]) {
                this.var_short_arr_b[this.var_int_aL] = this.var_byte_arr_aE[this.var_byte_arr_aI[this.var_short_arr_h[57] + 27 + 1]];
                this.var_boolean_w = true;
            }
        }
        return false;
    }

    final boolean boolean_i() {
        this.var_int_aQ = 0;
        this.var_int_aO = 0;
        while (this.var_int_aO < 4) {
            if (this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_aO * 2 + 0] >= this.var_byte_O || this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_aO * 2 + 1] >= this.var_byte_O || this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_aO * 2 + 0] < 0 || this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_aO * 2 + 1] < 0) {
                this.var_byte_arr_z[this.var_int_aO] = 1;
            } else {
                this.var_byte_arr_z[this.var_int_aO] = this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_aO * 2 + 0]][this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_int_aO * 2 + 1]];
                if (this.var_byte_arr_z[this.var_int_aO] == 0) {
                    ++this.var_int_aQ;
                }
            }
            ++this.var_int_aO;
        }
        if (this.var_int_aQ > 2) {
            if (this.var_byte_arr_W[this.var_int_aL] == 18) {
                this.dr();
                this.var_int_aO = 0;
                while (this.var_int_aO < 4) {
                    if (this.var_byte_arr_z[this.var_byte_arr_aI[this.var_short_arr_h[32] + this.var_byte_bb * 4 + this.var_int_aO]] == 0 && this.var_byte_arr_aI[this.var_short_arr_h[32] + this.var_byte_bb * 4 + this.var_int_aO] != this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 2]) {
                        this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[32] + this.var_byte_bb * 4 + this.var_int_aO] * 2 + 0]);
                        this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[32] + this.var_byte_bb * 4 + this.var_int_aO] * 2 + 1]);
                        return true;
                    }
                    ++this.var_int_aO;
                }
            }
            if (this.boolean_j()) {
                return true;
            }
        }
        return false;
    }

    final boolean boolean_j() {
        this.var_int_aO = this.var_byte_arr_B[this.var_int_aL] - 1;
        while (this.var_int_aO <= this.var_byte_arr_B[this.var_int_aL] + 1) {
            if (this.var_int_aO >= 0) {
                if (this.var_int_aO >= this.var_byte_O) break;
                this.var_int_aP = this.var_byte_arr_C[this.var_int_aL] - 1;
                while (this.var_int_aP <= this.var_byte_arr_C[this.var_int_aL] + 1) {
                    if (this.var_int_aP >= 0) {
                        if (this.var_int_aP >= this.var_byte_O) break;
                        if (this.var_byte_arr_arr_b[this.var_int_aO][this.var_int_aP] == -14 && this.var_byte_arr_Y[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]] > 0) {
                            this.var_int_aQ = 0;
                            while (this.var_int_aQ < this.var_byte_arr_Y[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]]) {
                                this.var_boolean_w = false;
                                if (this.var_byte_arr_arr_j[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]][this.var_int_aQ] >= 0) {
                                    if (this.var_byte_arr_arr_j[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]][this.var_int_aQ] != 23) {
                                        this.var_byte_bg = this.var_byte_arr_arr_j[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]][this.var_int_aQ];
                                        this.dz();
                                        if (this.var_short_p >= 50) {
                                            this.var_boolean_w = true;
                                        }
                                    } else if (this.var_byte_arr_Q[this.var_int_aL] > 50 || this.var_byte_arr_R[this.var_int_aL] > 50) {
                                        this.var_boolean_w = true;
                                    }
                                } else if (this.var_byte_arr_aI[this.var_short_arr_h[55] + -1 - this.var_byte_arr_arr_j[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]][this.var_int_aQ]] >= this.var_byte_arr_arr_g[this.var_byte_arr_aI[this.var_short_arr_h[54] + -1 - this.var_byte_arr_arr_j[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]][this.var_int_aQ]]][this.var_int_aL] && b.ar[this.var_byte_arr_aI[this.var_short_arr_h[54] + -1 - this.var_byte_arr_arr_j[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]][this.var_int_aQ]]] == 0 || this.var_byte_arr_aI[this.var_short_arr_h[55] + -1 - this.var_byte_arr_arr_j[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]][this.var_int_aQ]] <= this.var_byte_arr_arr_g[this.var_byte_arr_aI[this.var_short_arr_h[54] + -1 - this.var_byte_arr_arr_j[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]][this.var_int_aQ]]][this.var_int_aL] && b.ar[this.var_byte_arr_aI[this.var_short_arr_h[54] + -1 - this.var_byte_arr_arr_j[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]][this.var_int_aQ]]] == 1 && this.var_byte_arr_aI[this.var_short_arr_h[53] + this.var_byte_arr_arr_j[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]][this.var_int_aQ]] != -2) {
                                    this.var_boolean_w = true;
                                }
                                if (this.var_boolean_w) {
                                    this.dr();
                                    this.var_int_aO = 0;
                                    while (this.var_int_aO < 4) {
                                        if (this.var_byte_arr_z[this.var_byte_arr_aI[this.var_short_arr_h[32] + this.var_byte_bb * 4 + this.var_int_aO]] == 0 && this.var_byte_arr_aI[this.var_short_arr_h[32] + this.var_byte_bb * 4 + this.var_int_aO] != this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 2]) {
                                            this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[32] + this.var_byte_bb * 4 + this.var_int_aO] * 2 + 0]);
                                            this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[32] + this.var_byte_bb * 4 + this.var_int_aO] * 2 + 1]);
                                            return true;
                                        }
                                        ++this.var_int_aO;
                                    }
                                }
                                ++this.var_int_aQ;
                            }
                        }
                    }
                    ++this.var_int_aP;
                }
            }
            ++this.var_int_aO;
        }
        return false;
    }

    final boolean boolean_k() {
        if (this.var_byte_arr_arr_b[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]] > 3) {
            this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + 0]);
            this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_F[this.var_int_aL] * 2 + 1]);
            if (this.var_byte_arr_F[this.var_int_aL] > 1) {
                this.var_byte_arr_ai[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] = 1;
            }
            return true;
        }
        this.var_int_aQ = 0;
        while (this.var_int_aQ < 2) {
            if (!(this.var_int_aQ == 0 && this.var_byte_arr_B[this.var_int_aL] == 0 || this.var_int_aQ == 1 && this.var_byte_arr_C[this.var_int_aL] == this.var_byte_O - 1)) {
                this.var_byte_arr_aZ[0] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_aI[this.var_short_arr_h[103] + this.var_int_aQ] * 4 + 0] * 2 + 0]);
                this.var_byte_arr_aZ[1] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_aI[this.var_short_arr_h[103] + this.var_int_aQ] * 4 + 0] * 2 + 1]);
                this.var_byte_bc = this.var_byte_arr_arr_b[this.var_byte_arr_aZ[0]][this.var_byte_arr_aZ[1]];
                this.var_byte_bd = this.var_byte_arr_arr_c[this.var_byte_arr_aZ[0]][this.var_byte_arr_aZ[1]];
                if (this.var_byte_bc == 7 + this.var_int_aQ && this.var_byte_arr_ah[this.var_byte_bd] <= 50 && this.var_byte_arr_ai[this.var_byte_bd] == 0) {
                    this.var_boolean_w = true;
                    this.var_int_aP = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
                    while (this.var_int_aP >= 0) {
                        if (this.var_byte_arr_A[this.var_int_aP] == 9 && this.var_byte_arr_D[this.var_int_aP] == this.var_byte_arr_aZ[0] && this.var_byte_arr_E[this.var_int_aP] == this.var_byte_arr_aZ[1]) {
                            this.var_boolean_w = false;
                            break;
                        }
                        this.var_int_aP = this.var_short_arr_d[this.var_int_aP];
                    }
                    if (this.var_boolean_w) {
                        this.var_byte_arr_D[this.var_int_aL] = this.var_byte_arr_aZ[0];
                        this.var_byte_arr_E[this.var_int_aL] = this.var_byte_arr_aZ[1];
                        return true;
                    }
                }
            }
            ++this.var_int_aQ;
        }
        return false;
    }

    final boolean boolean_l() {
        this.var_int_aO = (this.var_java_util_Random_a.nextInt() & 0xFF) % 4;
        if (this.var_byte_arr_z[0] == 0 && (this.var_byte_arr_z[1] != 0 && this.var_byte_arr_z[3] != 0 || this.var_int_aO < 2)) {
            this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 0] * 2 + 0]);
            this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 0] * 2 + 1]);
            return true;
        }
        this.var_int_aO = (this.var_java_util_Random_a.nextInt() & 0xFF) % 4;
        if (this.var_byte_arr_z[1] == 0 && (this.var_byte_arr_z[3] != 0 || this.var_int_aO < 2)) {
            this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 1] * 2 + 0]);
            this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 1] * 2 + 1]);
            return true;
        }
        if (this.var_byte_arr_z[3] == 0) {
            this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 3] * 2 + 0]);
            this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 3] * 2 + 1]);
            return true;
        }
        if (this.var_byte_arr_z[2] == 0) {
            this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 2] * 2 + 0]);
            this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 2] * 2 + 1]);
        } else {
            this.var_byte_arr_D[this.var_int_aL] = -1;
            this.var_byte_arr_W[this.var_int_aL] = 18;
        }
        return false;
    }

    final void dr() {
        this.var_byte_bb = 0;
        if (this.var_byte_arr_W[this.var_int_aL] == 18) {
            this.var_int_aS = this.var_byte_ab - this.var_byte_arr_B[this.var_int_aL];
            this.var_int_aT = -this.var_byte_arr_C[this.var_int_aL];
        } else {
            this.var_int_aS = this.var_byte_arr_arr_arr_a[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]][this.var_int_aQ][0] - this.var_byte_arr_B[this.var_int_aL];
            this.var_int_aT = this.var_byte_arr_arr_arr_a[this.var_byte_arr_arr_c[this.var_int_aO][this.var_int_aP]][this.var_int_aQ][1] - this.var_byte_arr_C[this.var_int_aL];
        }
        if (this.var_int_aS > 0) {
            this.var_byte_bb = (byte)(this.var_byte_bb + 4);
        } else {
            this.var_int_aS *= -1;
        }
        if (this.var_int_aT > 0) {
            this.var_byte_bb = (byte)(this.var_byte_bb + 2);
        } else {
            this.var_int_aT *= -1;
        }
        if (this.var_int_aS > this.var_int_aT) {
            this.var_byte_bb = (byte)(this.var_byte_bb + 1);
        }
    }

    final void ds() {
        if (this.var_byte_arr_ad[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] >= 10) {
            this.dt();
            return;
        }
        if (!(this.var_boolean_arr_c[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] && this.var_boolean_arr_b[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] && this.var_boolean_arr_a[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] && this.var_byte_arr_ah[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] >= 10)) {
            this.var_byte_arr_W[this.var_int_aL] = -1;
            this.dw();
            return;
        }
        this.var_byte_arr_W[this.var_int_aL] = 11;
        this.var_short_arr_arr_f[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]][this.var_byte_arr_ad[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]]] = (short)this.var_int_aL;
        this.var_int_ay = this.var_int_aL;
        this.dp();
        this.var_int_aM = this.var_byte_arr_ad[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] * 6;
        if (this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] == 0) {
            this.du();
        } else {
            this.dv();
        }
        this.var_short_arr_d[this.var_int_ay] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_ay]][this.var_byte_arr_C[this.var_int_ay]];
        this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_ay]][this.var_byte_arr_C[this.var_int_ay]] = (short)this.var_int_ay;
        byte by = this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]];
        this.var_byte_arr_ad[by] = (byte)(this.var_byte_arr_ad[by] + 1);
        if (this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] == 14) {
            this.var_byte_arr_af[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] = 0;
        }
        this.var_byte_arr_J[this.var_int_aL] = 0;
    }

    final void dt() {
        this.var_int_ay = this.var_int_aL;
        this.dp();
        if (this.var_byte_arr_aa[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] == 0) {
            this.var_byte_arr_C[this.var_int_aL] = (byte)(this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] - 2);
            this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] - 1);
            this.var_byte_arr_D[this.var_int_aL] = this.var_byte_arr_B[this.var_int_aL];
            this.var_byte_arr_H[this.var_int_aL] = 0;
            this.var_byte_arr_G[this.var_int_aL] = b.Z[0];
            this.var_byte_arr_F[this.var_int_aL] = 0;
            this.var_byte_arr_W[this.var_int_aL] = -1;
        } else {
            this.var_byte_arr_B[this.var_int_aL] = (byte)(this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] + 2);
            this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] + 1);
            this.var_byte_arr_E[this.var_int_aL] = this.var_byte_arr_C[this.var_int_aL];
            this.var_byte_arr_H[this.var_int_aL] = b.Z[0];
            this.var_byte_arr_G[this.var_int_aL] = 18;
            this.var_byte_arr_F[this.var_int_aL] = 1;
            this.var_byte_arr_W[this.var_int_aL] = -1;
        }
        this.var_short_arr_d[this.var_int_ay] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_ay]][this.var_byte_arr_C[this.var_int_ay]];
        this.var_short_arr_arr_c[this.var_byte_arr_B[this.var_int_ay]][this.var_byte_arr_C[this.var_int_ay]] = (short)this.var_int_ay;
    }

    final void du() {
        if (this.var_int_aM <= 16) {
            this.var_byte_arr_C[this.var_int_aL] = this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]];
            this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] - 1);
            this.var_byte_arr_E[this.var_int_aL] = this.var_byte_arr_C[this.var_int_aL];
            if (this.var_int_aM <= 6) {
                this.var_byte_arr_H[this.var_int_aL] = 10;
                this.var_byte_arr_G[this.var_int_aL] = (byte)(this.var_int_aM + 4);
                this.var_byte_arr_F[this.var_int_aL] = 2;
                return;
            }
            this.var_int_aM -= 6;
            this.var_byte_arr_G[this.var_int_aL] = 10;
            this.var_byte_arr_H[this.var_int_aL] = (byte)(10 - this.var_int_aM);
            this.var_byte_arr_F[this.var_int_aL] = 3;
            return;
        }
        this.var_int_aM -= 16;
        this.var_byte_arr_G[this.var_int_aL] = 10;
        this.var_byte_arr_H[this.var_int_aL] = (byte)((40 - this.var_int_aM) % 20);
        this.var_byte_arr_C[this.var_int_aL] = (byte)(this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] - 1 - (this.var_int_aM - 1) / 20);
        this.var_byte_arr_D[this.var_int_aL] = this.var_byte_arr_B[this.var_int_aL];
        this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + 1);
        this.var_byte_arr_F[this.var_int_aL] = 3;
    }

    final void dv() {
        if (this.var_int_aM <= 14) {
            this.var_byte_arr_B[this.var_int_aL] = this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]];
            this.var_byte_arr_D[this.var_int_aL] = this.var_byte_arr_B[this.var_int_aL];
            this.var_byte_arr_E[this.var_int_aL] = (byte)(this.var_byte_arr_C[this.var_int_aL] + 1);
            if (this.var_int_aM <= 5) {
                this.var_byte_arr_H[this.var_int_aL] = (byte)(19 - this.var_int_aM - 4);
                this.var_byte_arr_G[this.var_int_aL] = 10;
                this.var_byte_arr_F[this.var_int_aL] = 3;
                return;
            }
            this.var_int_aM -= 5;
            this.var_byte_arr_G[this.var_int_aL] = (byte)(10 + this.var_int_aM);
            this.var_byte_arr_H[this.var_int_aL] = 10;
            this.var_byte_arr_F[this.var_int_aL] = 2;
            return;
        }
        this.var_int_aM -= 15;
        this.var_byte_arr_G[this.var_int_aL] = (byte)(this.var_int_aM % 20);
        this.var_byte_arr_H[this.var_int_aL] = 10;
        this.var_byte_arr_B[this.var_int_aL] = (byte)(this.var_byte_arr_ae[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.var_int_aL]][this.var_byte_arr_C[this.var_int_aL]]] + 1 + this.var_int_aM / 20);
        this.var_byte_arr_D[this.var_int_aL] = (byte)(this.var_byte_arr_B[this.var_int_aL] - 1);
        this.var_byte_arr_E[this.var_int_aL] = this.var_byte_arr_C[this.var_int_aL];
        this.var_byte_arr_F[this.var_int_aL] = 2;
    }

    final void d(boolean bl) {
        this.var_int_aU = this.var_int_aL;
        this.var_int_aV = 0;
        while (this.var_int_aV < this.var_byte_arr_ad[this.var_byte_ax]) {
            this.var_int_aL = this.var_short_arr_arr_f[this.var_byte_ax][this.var_int_aV];
            this.var_byte_arr_F[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 2];
            this.var_byte_arr_arr_e[this.var_byte_arr_aI[this.var_short_arr_h[105] + this.var_byte_arr_F[this.var_int_aL]]][this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[36] + this.var_byte_arr_F[this.var_int_aL] * 2 + this.var_byte_arr_aI[this.var_short_arr_h[105] + this.var_byte_arr_F[this.var_int_aL]]];
            this.var_byte_arr_W[this.var_int_aL] = -1;
            if (bl) {
                this.var_byte_arr_P[this.var_int_aL] = this.byte_a(this.var_byte_arr_P[this.var_int_aL] - b.ap[3]);
            }
            this.dq();
            ++this.var_int_aV;
        }
        this.var_byte_arr_ad[this.var_byte_ax] = 0;
        this.var_int_aL = this.var_int_aU;
    }

    final void dw() {
        this.var_byte_arr_F[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_F[this.var_int_aL] * 4 + 2];
        this.var_byte_arr_G[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[36] + this.var_byte_arr_F[this.var_int_aL] * 2 + 0];
        this.var_byte_arr_H[this.var_int_aL] = this.var_byte_arr_aI[this.var_short_arr_h[36] + this.var_byte_arr_F[this.var_int_aL] * 2 + 1];
        this.dq();
    }

    final void dx() {
        this.var_int_aO = 0;
        while (this.var_int_aO < 30) {
            this.var_byte_arr_Y[this.var_int_aO] = 0;
            if (this.var_byte_arr_arr_i[this.var_int_aO][0] >= 0) {
                this.var_int_aP = this.var_byte_arr_arr_i[this.var_int_aO][0] - 6;
                while (this.var_int_aP <= this.var_byte_arr_arr_i[this.var_int_aO][0] + 6) {
                    if (this.var_int_aP >= 0) {
                        if (this.var_int_aP >= this.var_byte_O) break;
                        this.var_int_aQ = this.var_byte_arr_arr_i[this.var_int_aO][1] - 6;
                        while (this.var_int_aQ <= this.var_byte_arr_arr_i[this.var_int_aO][1] + 6) {
                            if (this.var_int_aQ >= 0) {
                                if (this.var_int_aQ >= this.var_byte_O) break;
                                this.var_byte_be = 0;
                                while (this.var_byte_be < 2 && this.var_byte_arr_Y[this.var_int_aO] < 20) {
                                    this.var_byte_bf = 0;
                                    if (this.var_byte_arr_arr_b[this.var_int_aP][this.var_int_aQ] <= -15 && this.var_byte_arr_arr_b[this.var_int_aP][this.var_int_aQ] >= -27 && this.var_byte_arr_aI[this.var_short_arr_h[163 + this.var_byte_be] - 1 - this.var_byte_arr_arr_b[this.var_int_aP][this.var_int_aQ]] == 1) {
                                        this.var_byte_arr_arr_j[this.var_int_aO][this.var_byte_arr_Y[this.var_int_aO]] = this.var_byte_arr_arr_b[this.var_int_aP][this.var_int_aQ];
                                        this.var_byte_bf = 1;
                                    }
                                    if (this.var_byte_arr_arr_b[this.var_int_aP][this.var_int_aQ] == 5 + this.var_byte_be) {
                                        this.var_byte_arr_arr_j[this.var_int_aO][this.var_byte_arr_Y[this.var_int_aO]] = this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_int_aP][this.var_int_aQ]];
                                        this.var_byte_bf = 1;
                                    }
                                    if (this.var_byte_bf == 1) {
                                        this.var_byte_arr_arr_arr_a[this.var_int_aO][this.var_byte_arr_Y[this.var_int_aO]][0] = (byte)(this.var_int_aP + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_aI[this.var_short_arr_h[103] + this.var_byte_be] * 4 + 2] * 2 + 0]);
                                        this.var_byte_arr_arr_arr_a[this.var_int_aO][this.var_byte_arr_Y[this.var_int_aO]][1] = (byte)(this.var_int_aQ + this.var_byte_arr_aI[this.var_short_arr_h[31] + this.var_byte_arr_aI[this.var_short_arr_h[30] + this.var_byte_arr_aI[this.var_short_arr_h[103] + this.var_byte_be] * 4 + 2] * 2 + 1]);
                                        int n = this.var_int_aO;
                                        this.var_byte_arr_Y[n] = (byte)(this.var_byte_arr_Y[n] + 1);
                                    }
                                    this.var_byte_be = (byte)(this.var_byte_be + 1);
                                }
                            }
                            ++this.var_int_aQ;
                        }
                    }
                    ++this.var_int_aP;
                }
            }
            ++this.var_int_aO;
        }
    }

    final void dy() {
        this.var_int_aW = this.var_byte_arr_P[this.var_int_aL] < 50 ? (this.var_java_util_Random_a.nextInt() & 0xFFFF) % (this.var_int_arr_arr_c[1][d.var_short_arr_k[4] + 1] * 40) : 1000;
        if (this.var_byte_arr_L[this.var_int_aL] < 4 || this.var_byte_arr_Q[this.var_int_aL] >= 96 || this.var_byte_arr_R[this.var_int_aL] >= 100 || 60 + 10 * this.var_byte_M - this.var_byte_arr_P[this.var_int_aL] > this.var_int_aW) {
            this.var_byte_arr_W[this.var_int_aL] = 18;
        }
    }

    final void dz() {
        this.var_short_p = (short)100;
        this.var_short_p = (short)(this.var_short_p - (this.var_byte_arr_Q[this.var_int_aL] + this.var_byte_arr_R[this.var_int_aL]) * 100 / 200);
        this.var_short_p = (short)(this.var_short_p - this.var_short_arr_f[this.var_byte_bg] * 2);
        if (this.var_byte_arr_arr_f[0][this.var_int_aL] == this.var_byte_bg) {
            this.var_short_p = (short)(this.var_short_p - b.av[0]);
        }
        if (this.var_byte_arr_arr_f[1][this.var_int_aL] == this.var_byte_bg) {
            this.var_short_p = (short)(this.var_short_p - b.av[1]);
        }
    }

    final void dA() {
        this.var_byte_bg = this.var_byte_arr_Z[this.var_short_q];
        this.dz();
        if (this.var_byte_bg != 22) {
            this.var_short_p = (short)(this.var_short_p - this.var_byte_arr_ad[this.var_short_q] * 50 / 10);
        }
    }

    final void e(boolean bl) {
        if (this.var_byte_arr_W[this.var_int_aL] == 15 || this.var_byte_arr_W[this.var_int_aL] == 16) {
            return;
        }
        this.var_byte_arr_N[this.var_int_aL] = -1;
        this.var_byte_bh = 0;
        while (this.var_byte_bh < 10) {
            if (this.var_byte_arr_aI[this.var_short_arr_h[95] + this.var_byte_bh] == this.var_byte_ad + 3) {
                if (this.var_short_arr_c[this.var_int_aL] >= b.var_short_arr_b[this.var_byte_bh]) {
                    this.var_byte_arr_N[this.var_int_aL] = this.var_byte_bh;
                }
            } else if (this.var_byte_arr_arr_g[this.var_byte_arr_aI[this.var_short_arr_h[95] + this.var_byte_bh]][this.var_int_aL] <= b.var_short_arr_b[this.var_byte_bh] && this.var_byte_arr_aI[this.var_short_arr_h[97] + this.var_byte_bh] == 0 || this.var_byte_arr_arr_g[this.var_byte_arr_aI[this.var_short_arr_h[95] + this.var_byte_bh]][this.var_int_aL] >= b.var_short_arr_b[this.var_byte_bh] && this.var_byte_arr_aI[this.var_short_arr_h[97] + this.var_byte_bh] == 1) {
                this.var_byte_arr_N[this.var_int_aL] = this.var_byte_bh;
            }
            if (this.var_byte_arr_N[this.var_int_aL] >= 0 && bl && (this.var_java_util_Random_a.nextInt() & 0xFFFF) % 25 > 0) {
                this.var_byte_arr_N[this.var_int_aL] = -1;
            }
            if (this.var_byte_arr_N[this.var_int_aL] >= 0) {
                return;
            }
            this.var_byte_bh = (byte)(this.var_byte_bh + 1);
        }
    }

    final void dB() {
        if (this.var_int_aL >= 200) {
            return;
        }
        this.var_int_aX = this.var_short_arr_d[this.var_int_aL];
        while (this.var_int_aX != -1) {
            if (this.var_byte_arr_W[this.var_int_aX] == 15 || this.var_byte_arr_W[this.var_int_aX] == 16) {
                this.var_byte_arr_J[this.var_int_aL] = 0;
                this.var_byte_arr_W[this.var_int_aL] = 17;
                return;
            }
            this.var_int_aX = this.var_short_arr_d[this.var_int_aX];
        }
        if (this.var_byte_arr_W[this.var_int_aL] != -1) {
            return;
        }
        this.var_int_aX = this.var_short_arr_d[this.var_int_aL];
        while (this.var_int_aX != -1) {
            if (this.var_byte_arr_W[this.var_int_aX] == -1 && this.var_int_aX < 200 && this.var_byte_arr_V[this.var_int_aL] >= this.var_byte_af && this.var_byte_arr_V[this.var_int_aX] >= this.var_byte_af && (this.var_java_util_Random_a.nextInt() & 0xFFFF) % this.var_short_b < this.var_byte_arr_V[this.var_int_aL] + this.var_byte_arr_V[this.var_int_aX]) {
                this.var_byte_arr_W[this.var_int_aL] = 15;
                this.var_byte_arr_W[this.var_int_aX] = 16;
                this.var_byte_arr_arr_h[0][this.var_int_aL] = 0;
                this.var_byte_arr_arr_h[1][this.var_int_aL] = 0;
                this.var_short_arr_c[this.var_int_aL] = 0;
                this.var_short_arr_c[this.var_int_aX] = 0;
                this.var_byte_arr_N[this.var_int_aL] = -1;
                this.var_byte_arr_N[this.var_int_aX] = -1;
                this.var_int_aZ = this.var_int_aL;
                this.dD();
                this.var_int_aZ = this.var_int_aX;
                this.dD();
                this.var_byte_bi = 0;
                this.dC();
                return;
            }
            this.var_int_aX = this.var_short_arr_d[this.var_int_aX];
        }
    }

    final void dC() {
        if (!this.var_boolean_arr_j[this.var_byte_bi]) {
            this.var_byte_f = 0;
            this.var_byte_aC = 1;
            this.var_byte_aB = this.var_byte_aA = (byte)(this.var_byte_aE + this.var_byte_bi);
            this.dH();
            this.var_boolean_arr_j[this.var_byte_bi] = true;
        }
    }

    final void dD() {
        if (this.var_byte_arr_M[this.var_int_aZ] < 0) {
            return;
        }
        this.var_int_aY = 0;
        while (this.var_int_aY < this.var_byte_aH) {
            if (this.var_byte_arr_arr_x[this.var_int_aY][0] < 0) {
                this.var_byte_arr_arr_x[this.var_int_aY][0] = this.var_byte_arr_B[this.var_int_aZ];
                this.var_byte_arr_arr_x[this.var_int_aY][1] = this.var_byte_arr_C[this.var_int_aZ];
                this.var_byte_arr_aR[this.var_int_aY] = (byte)((this.var_byte_arr_G[this.var_int_aZ] + this.var_byte_arr_H[this.var_int_aZ]) / b.Y[0] - this.var_byte_arr_aI[this.var_short_arr_h[73] + this.var_byte_arr_M[this.var_int_aZ] + 13] / 2);
                this.var_byte_arr_aQ[this.var_int_aY] = (byte)(b.B[1] / 2 + (this.var_byte_arr_G[this.var_int_aZ] - this.var_byte_arr_H[this.var_int_aZ]) / b.Y[1] - this.var_byte_arr_aI[this.var_short_arr_h[20] + this.var_byte_arr_A[this.var_int_aZ] * 4 + this.var_byte_arr_F[this.var_int_aZ]] - this.var_byte_arr_aI[this.var_short_arr_h[74] + this.var_byte_arr_M[this.var_int_aZ] + 13]);
                this.var_byte_arr_aS[this.var_int_aY] = (byte)(this.var_byte_arr_M[this.var_int_aZ] + 13);
                this.var_byte_arr_M[this.var_int_aZ] = -1;
                return;
            }
            ++this.var_int_aY;
        }
    }

    final void dE() {
        this.var_int_aY = 0;
        while (this.var_int_aY < this.var_byte_aH) {
            if (this.var_byte_arr_arr_x[this.var_int_aY][0] >= 0) {
                if (this.var_byte_arr_aQ[this.var_int_aY] < this.var_byte_aI) {
                    this.var_byte_arr_arr_x[this.var_int_aY][0] = -1;
                } else {
                    int n = this.var_int_aY;
                    this.var_byte_arr_aR[n] = (byte)(this.var_byte_arr_aR[n] + ((this.var_java_util_Random_a.nextInt() & 0xFFFF) % 3 - 1));
                    int n2 = this.var_int_aY;
                    this.var_byte_arr_aQ[n2] = (byte)(this.var_byte_arr_aQ[n2] - 2);
                }
            }
            ++this.var_int_aY;
        }
    }

    final void dF() {
        this.var_int_aM = 0;
        while (this.var_int_aM < this.var_byte_ae) {
            if (b.ar[this.var_int_aM] == 0) {
                this.var_byte_arr_arr_g[this.var_int_aM][this.var_int_aL] = this.byte_a(this.var_byte_arr_arr_g[this.var_int_aM][this.var_int_aL] - this.var_byte_arr_aI[this.var_short_arr_h[33] + this.var_byte_bj * this.var_byte_ae + this.var_int_aM]);
            }
            if (b.ar[this.var_int_aM] == 1) {
                this.var_byte_arr_arr_g[this.var_int_aM][this.var_int_aL] = this.byte_a(this.var_byte_arr_arr_g[this.var_int_aM][this.var_int_aL] + this.var_byte_arr_aI[this.var_short_arr_h[33] + this.var_byte_bj * this.var_byte_ae + this.var_int_aM]);
            }
            ++this.var_int_aM;
        }
    }

    final byte byte_a(int n) {
        if (n >= 100) {
            return 100;
        }
        if (n <= 0) {
            return 0;
        }
        return (byte)n;
    }

    final void dG() {
        this.var_int_s = 0;
        while (this.var_int_s < 3) {
            this.var_java_io_InputStream_a = null;
            try {
                this.var_java_io_InputStream_a = this.getClass().getResourceAsStream(this.var_java_lang_String_arr_a[this.var_int_s] + this.var_byte_P);
                if (this.var_java_io_InputStream_a != null) {
                    this.var_int_r = 0;
                    this.var_short_arr_arr_i[this.var_int_s][0] = 0;
                    this.var_int_q = 0;
                    while ((this.var_int_D = this.var_java_io_InputStream_a.read()) != -1) {
                        if (this.var_int_D == 124) {
                            ++this.var_int_r;
                            this.var_short_arr_arr_i[this.var_int_s][this.var_int_r] = (short)this.var_int_q;
                            --this.var_int_q;
                        } else if (this.var_int_D == 38) {
                            this.var_byte_arr_arr_s[this.var_int_s][this.var_int_q] = 100;
                        } else if (this.var_int_D < 10) {
                            this.var_byte_arr_arr_s[this.var_int_s][this.var_int_q] = (byte)(101 + this.var_int_D);
                        } else {
                            this.dJ();
                            this.var_byte_arr_arr_s[this.var_int_s][this.var_int_q] = (byte)this.var_int_E;
                        }
                        ++this.var_int_q;
                    }
                }
                this.var_java_io_InputStream_a.close();
                this.var_java_io_InputStream_a = null;
            }
            catch (IOException iOException) {}
            System.gc();
            ++this.var_int_s;
        }
    }

    final void dH() {
        this.var_int_bb = 0;
        this.var_int_G = 0;
        this.var_short_arr_l[0] = this.var_short_arr_arr_i[this.var_byte_aC][this.var_byte_aA];
        this.var_int_bc = 0;
        this.dI();
        if (this.var_short_arr_arr_i[this.var_byte_aC][this.var_byte_aA] < this.var_short_arr_arr_i[this.var_byte_aC][this.var_byte_aA + 1]) {
            ++this.var_int_G;
            this.var_short_arr_m[this.var_int_G - 1] = (short)this.var_int_bc;
            this.var_short_arr_l[this.var_int_G] = this.var_short_arr_arr_i[this.var_byte_aC][this.var_byte_aA + 1];
        }
        this.var_int_F = 0;
        if (this.var_byte_aC == 3) {
            this.var_int_H = (this.var_int_m + d.B[this.var_byte_aC]) / 2 - 10 * this.var_int_G;
            if (this.var_int_H < d.B[this.var_byte_aC]) {
                this.var_int_H = d.B[this.var_byte_aC];
                return;
            }
        } else {
            if (this.var_byte_aC == 1) {
                if (this.var_int_G < d.var_byte_arr_j[1]) {
                    this.var_int_H = d.B[this.var_byte_aC] - (this.var_int_G - 1) * 20;
                    return;
                }
                this.var_int_H = d.B[this.var_byte_aC] - (d.var_byte_arr_j[1] - 1) * 20;
                return;
            }
            this.var_int_H = d.B[this.var_byte_aC];
        }
    }

    final void dI() {
        this.var_int_ba = this.var_short_arr_arr_i[this.var_byte_aC][this.var_byte_aA];
        while (this.var_int_ba < this.var_short_arr_arr_i[this.var_byte_aC][this.var_byte_aA + 1]) {
            if (this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_ba] == 45 || this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_ba] == 100) {
                this.var_int_bb = (short)(this.var_int_ba + 1);
                this.var_int_bd = this.var_int_bc;
            }
            if (this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_ba] >= 101) {
                ++this.var_int_bc;
                this.var_int_bc += this.var_byte_arr_aI[this.var_short_arr_h[73] + this.var_byte_arr_aI[this.var_short_arr_h[96] + this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_ba] - 101]];
            }
            if (this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_ba] < 100 && (this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_ba] / 30 != 0 || this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_ba] % 30 < 24)) {
                ++this.var_int_bc;
                this.var_int_bc += b.var_short_arr_arr_a[this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_ba] / 30][this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_ba] % 30 + 1] - b.var_short_arr_arr_a[this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_ba] / 30][this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_ba] % 30];
            }
            if (this.var_int_bc > d.A[this.var_byte_aC] && this.var_int_bb > this.var_short_arr_l[this.var_int_G] || this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_ba] == 100) {
                ++this.var_int_G;
                this.var_short_arr_l[this.var_int_G] = (short)this.var_int_bb;
                this.var_short_arr_m[this.var_int_G - 1] = (short)this.var_int_bd;
                this.var_int_ba = (short)(this.var_int_bb - 1);
                this.var_int_bc = 0;
            }
            ++this.var_int_ba;
        }
    }

    final void dJ() {
        if (this.var_short_j == 0) {
            if (this.var_int_D > 1000) {
                this.var_int_D -= 848;
            }
            this.var_int_u = 0;
            while (this.var_int_u < b.var_byte_arr_c.length) {
                if (this.var_int_D == b.var_byte_arr_c[this.var_int_u]) {
                    this.var_int_E = 46 + this.var_int_u;
                    return;
                }
                ++this.var_int_u;
            }
            if (this.var_int_D > 223) {
                this.var_int_D -= 32;
            }
            if (this.var_int_D >= 192 && this.var_int_D < 209) {
                this.var_int_E = this.var_int_D - 192;
                return;
            }
            if (this.var_int_D >= 209 && this.var_int_D <= 223) {
                this.var_int_E = 30 + this.var_int_D - 209;
                return;
            }
            if (this.var_int_D == 32) {
                this.var_int_E = 45;
                return;
            }
            if (this.var_int_D >= 48 && this.var_int_D <= 57) {
                this.var_int_E = 60 + this.var_int_D - 48;
                return;
            }
            this.var_int_E = 70;
            this.var_int_u = 0;
            while (this.var_int_u < 11) {
                if (this.var_int_D == this.var_byte_arr_aI[this.var_short_arr_h[130] + this.var_int_u]) {
                    this.var_int_E += this.var_int_u;
                    return;
                }
                ++this.var_int_u;
            }
        } else {
            if (this.var_int_D >= 48 && this.var_int_D <= 57) {
                this.var_int_E = this.var_int_D - 48;
            }
            this.var_int_u = 0;
            while (this.var_int_u < 3) {
                if (this.var_int_D == d.var_byte_arr_a[this.var_int_u]) {
                    this.var_int_E = 10 + this.var_int_u;
                    return;
                }
                ++this.var_int_u;
            }
        }
    }

    final void dK() {
        this.var_int_arr_d[this.var_byte_az] = this.var_short_arr_i[this.var_short_f + 1] - this.var_short_arr_i[this.var_short_f] - 1;
        this.var_int_arr_c[this.var_byte_az] = this.var_short_arr_i[this.var_short_f + 1] - this.var_short_arr_i[this.var_short_f];
        this.var_int_arr_f[this.var_byte_az] = this.var_short_h;
        this.var_int_arr_e[this.var_byte_az] = this.var_short_i;
        this.var_int_be = 0;
        while (this.var_int_be < this.var_int_arr_c[this.var_byte_az]) {
            this.var_byte_arr_arr_u[this.var_byte_az][this.var_int_be] = (byte)(this.var_byte_arr_aN[this.var_short_arr_i[this.var_short_f] + this.var_int_be] / 30);
            this.var_byte_arr_arr_t[this.var_byte_az][this.var_int_be] = (byte)(this.var_byte_arr_aN[this.var_short_arr_i[this.var_short_f] + this.var_int_be] % 30);
            if (this.var_byte_arr_aN[this.var_short_arr_i[this.var_short_f] + this.var_int_be] / 30 != 0 || this.var_byte_arr_aN[this.var_short_arr_i[this.var_short_f] + this.var_int_be] % 30 < 24) {
                byte by = this.var_byte_az;
                this.var_int_arr_d[by] = this.var_int_arr_d[by] + (b.var_short_arr_arr_a[this.var_byte_arr_arr_u[this.var_byte_az][this.var_int_be]][this.var_byte_arr_arr_t[this.var_byte_az][this.var_int_be] + 1] - b.var_short_arr_arr_a[this.var_byte_arr_arr_u[this.var_byte_az][this.var_int_be]][this.var_byte_arr_arr_t[this.var_byte_az][this.var_int_be]]);
            }
            ++this.var_int_be;
        }
        if (this.var_short_g == 1) {
            byte by = this.var_byte_az;
            this.var_int_arr_f[by] = this.var_int_arr_f[by] - this.var_int_arr_d[this.var_byte_az] / 2;
        }
        if (this.var_short_g == 2) {
            byte by = this.var_byte_az;
            this.var_int_arr_f[by] = this.var_int_arr_f[by] - this.var_int_arr_d[this.var_byte_az];
        }
        this.var_int_arr_g[this.var_byte_az] = 0;
        this.var_byte_az = (byte)(this.var_byte_az + 1);
    }

    final void dL() {
        if (this.var_byte_aG >= this.var_byte_aF) {
            return;
        }
        this.var_int_be = 0;
        while (this.var_int_be < this.var_byte_aF && this.var_int_arr_l[this.var_int_be] < this.var_byte_o) {
            ++this.var_int_be;
        }
        if (this.var_int_be >= this.var_byte_aF) {
            return;
        }
        this.var_int_arr_h[this.var_int_be] = this.var_java_lang_String_a.length();
        this.var_int_arr_i[this.var_int_be] = this.var_int_arr_h[this.var_int_be] - 1;
        this.var_int_arr_k[this.var_int_be] = this.var_short_h;
        this.var_int_arr_j[this.var_int_be] = this.var_short_i;
        this.var_byte_arr_arr_v[this.var_int_be][0] = this.var_byte_arr_aT[0];
        this.var_byte_arr_arr_v[this.var_int_be][1] = this.var_byte_arr_aT[1];
        this.var_short_j = (short)2;
        this.var_int_bf = 0;
        while (this.var_int_bf < this.var_int_arr_h[this.var_int_be]) {
            this.var_int_D = this.var_java_lang_String_a.charAt(this.var_int_bf);
            this.dJ();
            this.var_byte_arr_arr_w[this.var_int_be][this.var_int_bf] = (byte)this.var_int_E;
            int n = this.var_int_be;
            this.var_int_arr_i[n] = this.var_int_arr_i[n] + (b.var_short_arr_a[this.var_byte_arr_arr_w[this.var_int_be][this.var_int_bf] + 1] - b.var_short_arr_a[this.var_byte_arr_arr_w[this.var_int_be][this.var_int_bf]]);
            ++this.var_int_bf;
        }
        this.var_short_j = 0;
        int n = this.var_int_be;
        this.var_int_arr_k[n] = this.var_int_arr_k[n] - this.var_int_arr_i[this.var_int_be] / 2;
        this.var_int_arr_l[this.var_int_be] = 0;
        this.var_byte_aG = (byte)(this.var_byte_aG + 1);
    }

    final void dM() {
        this.var_int_arr_c[this.var_byte_az] = this.var_java_lang_String_a.length();
        this.var_int_arr_d[this.var_byte_az] = this.var_int_arr_c[this.var_byte_az] - 1;
        this.var_int_arr_f[this.var_byte_az] = this.var_short_h;
        this.var_int_arr_e[this.var_byte_az] = this.var_short_i;
        this.var_int_be = 0;
        while (this.var_int_be < this.var_int_arr_c[this.var_byte_az]) {
            this.var_int_D = this.var_java_lang_String_a.charAt(this.var_int_be);
            this.dJ();
            this.var_byte_arr_arr_u[this.var_byte_az][this.var_int_be] = (byte)(this.var_int_E / 30);
            this.var_byte_arr_arr_t[this.var_byte_az][this.var_int_be] = (byte)(this.var_int_E % 30);
            if (this.var_short_j == 0) {
                byte by = this.var_byte_az;
                this.var_int_arr_d[by] = this.var_int_arr_d[by] + (b.var_short_arr_arr_a[this.var_byte_arr_arr_u[this.var_byte_az][this.var_int_be]][this.var_byte_arr_arr_t[this.var_byte_az][this.var_int_be] + 1] - b.var_short_arr_arr_a[this.var_byte_arr_arr_u[this.var_byte_az][this.var_int_be]][this.var_byte_arr_arr_t[this.var_byte_az][this.var_int_be]]);
            } else {
                byte by = this.var_byte_az;
                this.var_int_arr_d[by] = this.var_int_arr_d[by] + (b.var_short_arr_a[this.var_byte_arr_arr_t[this.var_byte_az][this.var_int_be] + 1] - b.var_short_arr_a[this.var_byte_arr_arr_t[this.var_byte_az][this.var_int_be]]);
            }
            ++this.var_int_be;
        }
        if (this.var_short_g == 1) {
            byte by = this.var_byte_az;
            this.var_int_arr_f[by] = this.var_int_arr_f[by] - this.var_int_arr_d[this.var_byte_az] / 2;
        }
        if (this.var_short_g == 2) {
            byte by = this.var_byte_az;
            this.var_int_arr_f[by] = this.var_int_arr_f[by] - this.var_int_arr_d[this.var_byte_az];
        }
        this.var_int_arr_g[this.var_byte_az] = this.var_short_j;
        this.var_byte_az = (byte)(this.var_byte_az + 1);
    }

    final void dN() {
        this.var_int_arr_c[this.var_short_k] = this.var_java_lang_String_a.length();
        this.var_int_arr_d[this.var_short_k] = this.var_int_arr_c[this.var_short_k] - 1;
        this.var_int_arr_f[this.var_short_k] = this.var_short_h;
        this.var_int_arr_e[this.var_short_k] = this.var_short_i;
        this.var_int_be = 0;
        while (this.var_int_be < this.var_int_arr_c[this.var_short_k]) {
            this.var_int_D = this.var_java_lang_String_a.charAt(this.var_int_be);
            this.dJ();
            this.var_byte_arr_arr_u[this.var_short_k][this.var_int_be] = (byte)(this.var_int_E / 30);
            this.var_byte_arr_arr_t[this.var_short_k][this.var_int_be] = (byte)(this.var_int_E % 30);
            if (this.var_short_j == 0) {
                short s = this.var_short_k;
                this.var_int_arr_d[s] = this.var_int_arr_d[s] + (b.var_short_arr_arr_a[this.var_byte_arr_arr_u[this.var_short_k][this.var_int_be]][this.var_byte_arr_arr_t[this.var_short_k][this.var_int_be] + 1] - b.var_short_arr_arr_a[this.var_byte_arr_arr_u[this.var_short_k][this.var_int_be]][this.var_byte_arr_arr_t[this.var_short_k][this.var_int_be]]);
            } else {
                short s = this.var_short_k;
                this.var_int_arr_d[s] = this.var_int_arr_d[s] + (b.var_short_arr_a[this.var_byte_arr_arr_t[this.var_short_k][this.var_int_be] + 1] - b.var_short_arr_a[this.var_byte_arr_arr_t[this.var_short_k][this.var_int_be]]);
            }
            ++this.var_int_be;
        }
        if (this.var_short_g == 1) {
            short s = this.var_short_k;
            this.var_int_arr_f[s] = this.var_int_arr_f[s] - this.var_int_arr_d[this.var_short_k] / 2;
        }
        if (this.var_short_g == 2) {
            short s = this.var_short_k;
            this.var_int_arr_f[s] = this.var_int_arr_f[s] - this.var_int_arr_d[this.var_short_k];
        }
        this.var_int_arr_g[this.var_short_k] = this.var_short_j;
    }

    final void dO() {
        ++this.var_int_a;
        if (this.var_int_a >= 100) {
            this.var_int_a = 0;
        }
        this.var_int_bg = 0;
        while (this.var_int_bg < this.var_byte_az) {
            this.var_int_bi = this.var_int_arr_f[this.var_int_bg];
            this.bm = 0;
            this.var_int_bh = 0;
            while (this.var_int_bh < this.var_int_arr_c[this.var_int_bg]) {
                if (this.var_int_arr_g[this.var_int_bg] == 0) {
                    this.var_int_bj = 0;
                    if (this.var_byte_arr_arr_u[this.var_int_bg][this.var_int_bh] == 0 && this.var_byte_arr_arr_t[this.var_int_bg][this.var_int_bh] >= 24) {
                        this.bl = -1 - (this.bk + b.var_short_arr_arr_a[this.var_byte_arr_arr_u[this.var_int_bg][this.var_int_bh]][this.var_byte_arr_arr_t[this.var_int_bg][this.var_int_bh] + 1] - b.var_short_arr_arr_a[this.var_byte_arr_arr_u[this.var_int_bg][this.var_int_bh]][this.var_byte_arr_arr_t[this.var_int_bg][this.var_int_bh]]) / 2;
                        ++this.bm;
                    } else {
                        this.bl = 0;
                    }
                    this.bk = b.var_short_arr_arr_a[this.var_byte_arr_arr_u[this.var_int_bg][this.var_int_bh]][this.var_byte_arr_arr_t[this.var_int_bg][this.var_int_bh] + 1] - b.var_short_arr_arr_a[this.var_byte_arr_arr_u[this.var_int_bg][this.var_int_bh]][this.var_byte_arr_arr_t[this.var_int_bg][this.var_int_bh]];
                    this.bn = this.var_byte_P;
                    if (this.var_boolean_v && this.var_byte_P > 1) {
                        --this.bn;
                    }
                    if (!(this.var_byte_R == 26 || this.var_byte_arr_v[this.var_byte_R] <= 0 || this.var_boolean_o || this.var_byte_b != 3 || this.var_int_bg - this.var_byte_arr_aI[this.var_short_arr_h[94] + this.var_byte_R] != this.bn || this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 11 || this.var_byte_arr_arr_a[this.var_byte_R][this.var_byte_P] == 12 && this.var_boolean_m)) {
                        this.var_int_bj = this.var_byte_arr_a[(this.var_int_bh + this.var_int_a - this.bm) % 4];
                    }
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[6], (int)b.var_short_arr_arr_a[this.var_byte_arr_arr_u[this.var_int_bg][this.var_int_bh]][this.var_byte_arr_arr_t[this.var_int_bg][this.var_int_bh]], (int)b.var_byte_arr_a[this.var_byte_arr_arr_u[this.var_int_bg][this.var_int_bh]], this.bk, (int)b.var_byte_arr_b[this.var_byte_arr_arr_u[this.var_int_bg][this.var_int_bh]], 0, this.var_int_bi + this.bl, this.var_int_arr_e[this.var_int_bg] + this.var_int_bj, 20);
                    if (this.bl == 0) {
                        this.var_int_bi += this.bk + 1;
                    }
                } else {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[6], (int)b.var_short_arr_a[this.var_byte_arr_arr_t[this.var_int_bg][this.var_int_bh]], 58, b.var_short_arr_a[this.var_byte_arr_arr_t[this.var_int_bg][this.var_int_bh] + 1] - b.var_short_arr_a[this.var_byte_arr_arr_t[this.var_int_bg][this.var_int_bh]], 15, 0, this.var_int_bi, this.var_int_arr_e[this.var_int_bg], 20);
                    this.var_int_bi += b.var_short_arr_a[this.var_byte_arr_arr_t[this.var_int_bg][this.var_int_bh] + 1] - b.var_short_arr_a[this.var_byte_arr_arr_t[this.var_int_bg][this.var_int_bh]] + 1;
                }
                ++this.var_int_bh;
            }
            ++this.var_int_bg;
        }
    }

    final void dP() {
        if (this.var_byte_aG == 0) {
            return;
        }
        this.var_int_bg = 0;
        while (this.var_int_bg < this.var_byte_aF) {
            if (this.var_int_arr_l[this.var_int_bg] < this.var_byte_o) {
                this.var_int_bi = this.var_int_arr_k[this.var_int_bg] + (this.var_byte_arr_arr_v[this.var_int_bg][0] + this.var_byte_arr_arr_v[this.var_int_bg][1] - this.var_int_arr_arr_f[0][0] - this.var_int_arr_arr_f[0][1]) * (b.B[0] / 2) + this.var_byte_W;
                this.var_int_bh = 0;
                while (this.var_int_bh < this.var_int_arr_h[this.var_int_bg]) {
                    this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[6], (int)b.var_short_arr_a[this.var_byte_arr_arr_w[this.var_int_bg][this.var_int_bh]], 58, b.var_short_arr_a[this.var_byte_arr_arr_w[this.var_int_bg][this.var_int_bh] + 1] - b.var_short_arr_a[this.var_byte_arr_arr_w[this.var_int_bg][this.var_int_bh]], 15, 0, this.var_int_bi, this.var_int_arr_j[this.var_int_bg] + (this.var_byte_arr_arr_v[this.var_int_bg][0] - this.var_byte_arr_arr_v[this.var_int_bg][1] - this.var_int_arr_arr_f[0][0] + this.var_int_arr_arr_f[0][1]) * (b.B[1] / 2) + this.var_byte_X - 2 * this.var_int_arr_l[this.var_int_bg], 20);
                    this.var_int_bi += b.var_short_arr_a[this.var_byte_arr_arr_w[this.var_int_bg][this.var_int_bh] + 1] - b.var_short_arr_a[this.var_byte_arr_arr_w[this.var_int_bg][this.var_int_bh]] + 1;
                    ++this.var_int_bh;
                }
            }
            ++this.var_int_bg;
        }
    }

    final void dQ() {
        this.var_int_bg = this.var_int_F;
        while (this.var_int_bg < this.var_int_F + d.var_byte_arr_j[this.var_byte_aC]) {
            if (this.var_int_bg >= this.var_int_G) {
                return;
            }
            this.var_int_bi = (this.var_int_l - this.var_short_arr_m[this.var_int_bg]) / 2;
            this.var_int_bh = this.var_short_arr_l[this.var_int_bg];
            while (this.var_int_bh < this.var_short_arr_l[this.var_int_bg + 1]) {
                if (this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] != 100) {
                    if (this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] >= 101) {
                        this.bl = this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] - 101;
                        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[7], (int)this.var_byte_arr_aI[this.var_short_arr_h[71] + this.var_byte_arr_aI[this.var_short_arr_h[96] + this.bl]], (int)this.var_byte_arr_aI[this.var_short_arr_h[72] + this.var_byte_arr_aI[this.var_short_arr_h[96] + this.bl]], (int)this.var_byte_arr_aI[this.var_short_arr_h[73] + this.var_byte_arr_aI[this.var_short_arr_h[96] + this.bl]], (int)this.var_byte_arr_aI[this.var_short_arr_h[74] + this.var_byte_arr_aI[this.var_short_arr_h[96] + this.bl]], 0, this.var_int_bi, this.var_int_H + 20 * (this.var_int_bg - this.var_int_F) + (b.var_byte_arr_b[0] - this.var_byte_arr_aI[this.var_short_arr_h[74] + this.var_byte_arr_aI[this.var_short_arr_h[96] + this.bl]]) / 2, 20);
                        this.var_int_bi += this.var_byte_arr_aI[this.var_short_arr_h[73] + this.var_byte_arr_aI[this.var_short_arr_h[96] + this.bl]] + 1;
                    } else {
                        this.bl = this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] / 30 == 0 && this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] % 30 >= 24 ? -1 - (this.bk + b.var_short_arr_arr_a[this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] / 30][this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] % 30 + 1] - b.var_short_arr_arr_a[this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] / 30][this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] % 30]) / 2 : 0;
                        this.bk = b.var_short_arr_arr_a[this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] / 30][this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] % 30 + 1] - b.var_short_arr_arr_a[this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] / 30][this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] % 30];
                        this.var_javax_microedition_lcdui_Graphics_arr_a[this.var_byte_a].drawRegion(this.var_javax_microedition_lcdui_Image_arr_c[6], (int)b.var_short_arr_arr_a[this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] / 30][this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] % 30], (int)b.var_byte_arr_a[this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] / 30], this.bk, (int)b.var_byte_arr_b[this.var_byte_arr_arr_s[this.var_byte_aC][this.var_int_bh] / 30], 0, this.var_int_bi + this.bl, this.var_int_H + 20 * (this.var_int_bg - this.var_int_F), 20);
                        if (this.bl == 0) {
                            this.var_int_bi += this.bk + 1;
                        }
                    }
                }
                ++this.var_int_bh;
            }
            ++this.var_int_bg;
        }
    }

    final void dR() {
        try {
            this.dU();
            if (this.var_boolean_x) {
                if (this.var_byte_K == 0) {
                    this.var_byte_J = this.var_byte_M;
                } else {
                    this.var_byte_H = this.var_byte_L;
                    this.var_byte_I = this.var_byte_M;
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
                this.var_long_c <<= n;
                this.bu += n;
                if (blArray != null) {
                    if (blArray[this.bs]) {
                        ++this.var_long_c;
                    }
                } else if (byArray != null) {
                    this.var_long_c += (long)(byArray[this.bs] + n3);
                } else if (sArray != null) {
                    this.var_long_c += (long)(sArray[this.bs] + n3);
                } else if (nArray != null) {
                    this.var_long_c += (long)(nArray[this.bs] + n3);
                }
                if (this.bu >= 32 || this.bs == n2 - 1) {
                    while (this.bu >= 8) {
                        this.var_java_io_DataOutputStream_a.write((int)(this.var_long_c >> this.bu - 8));
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
                    this.var_long_c <<= 8;
                    this.var_long_c += (long)this.var_java_io_DataInputStream_a.read();
                    this.bu += 8;
                }
                this.bt = (int)(this.var_long_c >> this.bu - n & (long)this.bv);
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
            this.var_java_io_ByteArrayOutputStream_a = new ByteArrayOutputStream();
            this.var_java_io_DataOutputStream_a = new DataOutputStream(this.var_java_io_ByteArrayOutputStream_a);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_E);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_F);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_G);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_H);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_I);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_J);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_aJ);
            this.bu = 0;
            this.a(this.var_boolean_arr_i, null, null, null, 1, this.var_boolean_arr_i.length, 0);
            if (this.bu > 0) {
                this.var_java_io_DataOutputStream_a.write((int)(this.var_long_c << 8 - this.bu));
            }
            try {
                RecordStore.deleteRecordStore((String)"prehSetSave");
            }
            catch (Exception exception) {}
            this.var_javax_microedition_rms_RecordStore_a = RecordStore.openRecordStore((String)"prehSetSave", (boolean)true);
            if (this.var_javax_microedition_rms_RecordStore_a.getSizeAvailable() >= this.var_java_io_ByteArrayOutputStream_a.size()) {
                this.var_javax_microedition_rms_RecordStore_a.addRecord(this.var_java_io_ByteArrayOutputStream_a.toByteArray(), 0, this.var_java_io_ByteArrayOutputStream_a.size());
            }
            this.var_javax_microedition_rms_RecordStore_a.closeRecordStore();
            this.var_java_io_DataOutputStream_a.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dT() {
        try {
            this.var_javax_microedition_rms_RecordStore_a = RecordStore.openRecordStore((String)"prehSetSave", (boolean)true);
            this.var_boolean_x = false;
            if (this.var_javax_microedition_rms_RecordStore_a.getNumRecords() > 0) {
                this.var_boolean_x = true;
                System.gc();
                this.var_java_io_DataInputStream_a = new DataInputStream(new ByteArrayInputStream(this.var_javax_microedition_rms_RecordStore_a.getRecord(1)));
                this.var_byte_E = (byte)this.var_java_io_DataInputStream_a.read();
                this.var_byte_F = (byte)this.var_java_io_DataInputStream_a.read();
                this.var_byte_G = (byte)this.var_java_io_DataInputStream_a.read();
                this.var_byte_H = (byte)this.var_java_io_DataInputStream_a.read();
                this.var_byte_I = (byte)this.var_java_io_DataInputStream_a.read();
                this.var_byte_J = (byte)this.var_java_io_DataInputStream_a.read();
                this.var_byte_aJ = (byte)this.var_java_io_DataInputStream_a.read();
                this.bu = 0;
                this.b(this.var_boolean_arr_i, null, null, null, 1, this.var_boolean_arr_i.length, 0);
                this.var_byte_arr_v[8] = this.var_byte_E;
                this.var_java_io_DataInputStream_a.close();
            }
            this.var_javax_microedition_rms_RecordStore_a.closeRecordStore();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dU() {
        try {
            this.var_boolean_x = false;
            System.gc();
            this.var_java_io_ByteArrayOutputStream_a = new ByteArrayOutputStream();
            this.var_java_io_DataOutputStream_a = new DataOutputStream(this.var_java_io_ByteArrayOutputStream_a);
            this.dV();
            this.dW();
            this.dX();
            this.dY();
            if (this.var_byte_K == 0) {
                try {
                    RecordStore.deleteRecordStore((String)"prehCustSave");
                }
                catch (Exception exception) {}
                this.var_javax_microedition_rms_RecordStore_a = RecordStore.openRecordStore((String)"prehCustSave", (boolean)true);
            } else {
                try {
                    RecordStore.deleteRecordStore((String)"prehCampSave");
                }
                catch (Exception exception) {}
                this.var_javax_microedition_rms_RecordStore_a = RecordStore.openRecordStore((String)"prehCampSave", (boolean)true);
            }
            if (this.var_javax_microedition_rms_RecordStore_a.getSizeAvailable() >= this.var_java_io_ByteArrayOutputStream_a.size() + 200) {
                this.var_javax_microedition_rms_RecordStore_a.addRecord(this.var_java_io_ByteArrayOutputStream_a.toByteArray(), 0, this.var_java_io_ByteArrayOutputStream_a.size());
                this.var_boolean_x = true;
            }
            this.var_javax_microedition_rms_RecordStore_a.closeRecordStore();
            this.var_java_io_DataOutputStream_a.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dV() {
        try {
            this.var_java_io_DataOutputStream_a.writeInt(this.var_int_b);
            if (this.var_byte_K == 1) {
                this.var_java_io_DataOutputStream_a.write((byte)this.var_int_c);
            } else {
                this.var_java_io_DataOutputStream_a.write(this.var_byte_N);
            }
            this.var_java_io_DataOutputStream_a.writeInt(this.var_int_d);
            this.var_java_io_DataOutputStream_a.writeInt(this.var_int_e);
            this.var_java_io_DataOutputStream_a.writeInt(this.var_int_g);
            this.var_java_io_DataOutputStream_a.writeInt(this.var_int_f);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_g);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_w);
            this.var_java_io_DataOutputStream_a.writeInt(this.var_int_i);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_P);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_y);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_R);
            this.var_java_io_DataOutputStream_a.writeInt(this.var_int_k);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_ab);
            this.var_java_io_DataOutputStream_a.writeShort(this.var_short_a);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_ac);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_ag);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_ah);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_ai);
            this.var_java_io_DataOutputStream_a.write(this.var_byte_ak);
            if (this.var_byte_K == 1) {
                this.var_java_io_DataOutputStream_a.write(this.var_byte_D);
                this.var_java_io_DataOutputStream_a.write(this.var_int_N);
            }
            this.bu = 0;
            if (this.var_byte_K == 1) {
                this.a(null, this.var_byte_arr_b, null, null, 1, this.var_byte_arr_b.length, 0);
            }
            this.a(this.var_boolean_arr_j, null, null, null, 1, this.var_boolean_arr_j.length, 0);
            this.bo = 0;
            while (this.bo < 3) {
                this.a(null, null, null, this.var_int_arr_arr_e[this.bo], 20, 1, 5000);
                ++this.bo;
            }
            this.a(null, null, null, this.var_int_arr_arr_c[0], 24, d.var_short_arr_k[4] + 2, 5000);
            this.a(null, null, null, this.var_int_arr_arr_c[1], 4, d.var_short_arr_k[4] + 2, 1);
            this.a(null, null, null, this.var_int_arr_arr_c[2], 8, d.var_short_arr_k[4] + 2, 1);
            if (this.var_byte_K == 0) {
                this.bo = 3;
                while (this.bo < 8) {
                    this.a(null, null, null, this.var_int_arr_arr_c[this.bo], 10, d.var_short_arr_k[4] + 2, 1);
                    ++this.bo;
                }
                this.a(null, this.var_byte_arr_aW, null, null, 3, 4, 0);
                this.a(null, this.var_byte_arr_aX, null, null, 2, 4, 0);
            }
            this.bo = 0;
            while (this.bo < 30) {
                this.a(null, this.var_byte_arr_arr_b[this.bo], null, null, 6, 30, 29);
                this.a(null, this.var_byte_arr_arr_c[this.bo], null, null, 7, 30, 1);
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
            this.a(null, null, null, this.var_int_arr_a, 5, 2, 1);
            this.bo = 0;
            while (this.bo < 4) {
                this.a(null, null, null, this.var_int_arr_arr_f[this.bo], 7, 2, 25);
                ++this.bo;
            }
            this.bo = 0;
            while (this.bo < 222) {
                if (this.var_byte_arr_I[this.bo] < 1) {
                    this.var_byte_arr_I[this.bo] = 1;
                }
                ++this.bo;
            }
            this.a(null, this.var_byte_arr_B, null, null, 5, this.var_byte_arr_B.length, 1);
            this.a(null, this.var_byte_arr_C, null, null, 5, this.var_byte_arr_C.length, 1);
            this.a(null, this.var_byte_arr_D, null, null, 5, this.var_byte_arr_D.length, 1);
            this.a(null, this.var_byte_arr_E, null, null, 5, this.var_byte_arr_E.length, 1);
            this.a(null, this.var_byte_arr_G, null, null, 8, this.var_byte_arr_G.length, 128);
            this.a(null, this.var_byte_arr_H, null, null, 8, this.var_byte_arr_H.length, 128);
            this.a(null, this.var_byte_arr_A, null, null, 4, this.var_byte_arr_A.length, 1);
            this.a(null, this.var_byte_arr_F, null, null, 3, this.var_byte_arr_F.length, 0);
            this.a(null, this.var_byte_arr_I, null, null, 2, this.var_byte_arr_I.length, -1);
            this.a(null, this.var_byte_arr_W, null, null, 5, this.var_byte_arr_W.length, 1);
            this.a(null, this.var_byte_arr_X, null, null, 3, this.var_byte_arr_X.length, 0);
            this.bo = 0;
            while (this.bo < 3) {
                this.a(null, this.var_byte_arr_arr_f[this.bo], null, null, 6, 200, 2);
                this.a(null, this.var_byte_arr_arr_h[this.bo], null, null, 3, 222, 2);
                ++this.bo;
            }
            this.a(null, this.var_byte_arr_L, null, null, 7, this.var_byte_arr_L.length, 10);
            this.a(null, null, this.var_short_arr_b, null, 4, this.var_short_arr_b.length, 1);
            this.a(null, this.var_byte_arr_M, null, null, 3, this.var_byte_arr_M.length, 1);
            this.a(null, null, this.var_short_arr_e, null, 10, this.var_short_arr_e.length, 10);
            this.bo = 0;
            while (this.bo < 30) {
                this.a(null, this.var_byte_arr_arr_i[this.bo], null, null, 5, 2, 1);
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
                this.a(null, this.var_byte_arr_arr_k[this.bo], null, null, 5, 2, 1);
                ++this.bo;
            }
            this.a(null, this.var_byte_arr_Z, null, null, 5, this.var_byte_arr_Z.length, 1);
            this.a(null, this.var_byte_arr_aa, null, null, 2, this.var_byte_arr_aa.length, 1);
            this.a(null, this.var_byte_arr_ab, null, null, 7, this.var_byte_arr_ab.length, 1);
            this.a(null, this.var_byte_arr_ad, null, null, 5, this.var_byte_arr_ad.length, 1);
            this.a(null, this.var_byte_arr_ae, null, null, 5, this.var_byte_arr_ae.length, 1);
            this.a(null, this.var_byte_arr_af, null, null, 8, this.var_byte_arr_af.length, 128);
            this.a(null, this.var_byte_arr_ag, null, null, 3, this.var_byte_arr_ag.length, 1);
            this.a(null, this.var_byte_arr_ah, null, null, 7, this.var_byte_arr_ah.length, 10);
            this.a(null, this.var_byte_arr_ai, null, null, 2, this.var_byte_arr_ai.length, 0);
            this.a(null, this.var_byte_arr_aj, null, null, 2, this.var_byte_arr_aj.length, 1);
            this.a(this.var_boolean_arr_a, null, null, null, 1, this.var_boolean_arr_a.length, 0);
            this.a(this.var_boolean_arr_b, null, null, null, 1, this.var_boolean_arr_b.length, 0);
            this.a(this.var_boolean_arr_c, null, null, null, 1, this.var_boolean_arr_c.length, 0);
            if (this.var_byte_K == 1) {
                this.a(this.var_boolean_arr_g, null, null, null, 1, this.var_boolean_arr_g.length, 0);
            }
            this.bo = 0;
            while (this.bo < 2) {
                this.a(null, this.var_byte_arr_arr_l[this.bo], null, null, 5, 42, 1);
                this.a(null, this.var_byte_arr_arr_m[this.bo], null, null, 5, 42, 1);
                this.a(null, this.var_byte_arr_arr_n[this.bo], null, null, 5, 42, 1);
                ++this.bo;
            }
            this.a(null, this.var_byte_arr_ak, null, null, 7, this.var_byte_arr_ak.length, 10);
            this.a(this.var_boolean_arr_d, null, null, null, 1, this.var_boolean_arr_d.length, 0);
            this.a(this.var_boolean_arr_e, null, null, null, 1, this.var_boolean_arr_e.length, 0);
            this.a(this.var_boolean_arr_f, null, null, null, 1, this.var_boolean_arr_f.length, 0);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dY() {
        try {
            if (this.var_byte_K == 1) {
                this.a(this.var_boolean_arr_h, null, null, null, 1, this.var_boolean_arr_h.length, 0);
            }
            this.a(null, this.var_byte_arr_al, null, null, 4, this.var_byte_arr_al.length, 0);
            this.a(null, this.var_byte_arr_aE, null, null, 4, this.var_byte_arr_aE.length, 0);
            this.a(null, null, this.var_short_arr_g, null, 9, this.var_short_arr_g.length, 256);
            if (this.var_byte_K == 1) {
                this.a(this.var_boolean_arr_g, null, null, null, 1, this.var_boolean_arr_g.length, 0);
                this.a(this.var_boolean_arr_h, null, null, null, 1, this.var_boolean_arr_h.length, 0);
            }
            if (this.bu > 0) {
                this.var_java_io_DataOutputStream_a.write((int)(this.var_long_c << 8 - this.bu));
            }
            this.bo = 0;
            while (this.bo < this.var_byte_ae) {
                this.bq = 0;
                this.bp = 0;
                while (this.bp < 200) {
                    if (this.var_byte_arr_B[this.bp] >= 0) {
                        this.bq += this.var_byte_arr_arr_g[this.bo][this.bp];
                    }
                    ++this.bp;
                }
                if (this.var_short_a > 0) {
                    this.bq /= this.var_short_a;
                }
                this.var_java_io_DataOutputStream_a.writeInt(this.bq);
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
            if (this.var_byte_K == 0) {
                this.var_byte_M = this.var_byte_J;
            } else {
                if (this.var_byte_F > this.var_byte_H) {
                    this.var_byte_L = this.var_byte_F;
                    this.var_byte_M = this.var_byte_G;
                    this.var_byte_R = (byte)10;
                    this.var_byte_arr_w[10] = this.var_byte_arr_n[this.var_byte_L];
                    this.ct();
                    return;
                }
                this.var_byte_L = this.var_byte_H;
                this.var_byte_M = this.var_byte_I;
            }
            this.void_g();
            this.var_javax_microedition_rms_RecordStore_a = this.var_byte_K == 0 ? RecordStore.openRecordStore((String)"prehCustSave", (boolean)true) : RecordStore.openRecordStore((String)"prehCampSave", (boolean)true);
            if (this.var_javax_microedition_rms_RecordStore_a.getNumRecords() > 0) {
                System.gc();
                this.var_java_io_DataInputStream_a = new DataInputStream(new ByteArrayInputStream(this.var_javax_microedition_rms_RecordStore_a.getRecord(1)));
                this.ea();
                this.eb();
                this.ec();
                this.ed();
                this.ee();
                this.var_java_io_DataInputStream_a.close();
            }
            this.var_javax_microedition_rms_RecordStore_a.closeRecordStore();
            this.var_byte_az = 0;
            this.var_byte_b = 0;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void ea() {
        try {
            this.var_int_b = this.var_java_io_DataInputStream_a.readInt();
            if (this.var_byte_K == 1) {
                this.var_int_c = this.var_java_io_DataInputStream_a.read();
            } else {
                this.var_byte_N = (byte)this.var_java_io_DataInputStream_a.read();
            }
            this.var_int_d = this.var_java_io_DataInputStream_a.readInt();
            this.var_int_e = this.var_java_io_DataInputStream_a.readInt();
            this.var_int_g = this.var_java_io_DataInputStream_a.readInt();
            this.var_int_f = this.var_java_io_DataInputStream_a.readInt();
            this.var_byte_g = (byte)this.var_java_io_DataInputStream_a.read();
            this.var_byte_w = (byte)this.var_java_io_DataInputStream_a.read();
            this.var_int_i = this.var_java_io_DataInputStream_a.readInt();
            this.var_byte_P = (byte)this.var_java_io_DataInputStream_a.read();
            this.var_byte_y = (byte)this.var_java_io_DataInputStream_a.read();
            this.var_byte_R = (byte)this.var_java_io_DataInputStream_a.read();
            this.var_int_k = this.var_java_io_DataInputStream_a.readInt();
            this.var_byte_ab = (byte)this.var_java_io_DataInputStream_a.read();
            this.var_short_a = this.var_java_io_DataInputStream_a.readShort();
            this.var_byte_ac = (byte)this.var_java_io_DataInputStream_a.read();
            this.var_byte_ag = (byte)this.var_java_io_DataInputStream_a.read();
            this.var_byte_ah = (byte)this.var_java_io_DataInputStream_a.read();
            this.var_byte_ai = (byte)this.var_java_io_DataInputStream_a.read();
            this.var_byte_ak = (byte)this.var_java_io_DataInputStream_a.read();
            if (this.var_byte_K == 1) {
                this.var_byte_D = (byte)this.var_java_io_DataInputStream_a.read();
                this.var_int_N = (byte)this.var_java_io_DataInputStream_a.read();
            }
            this.bu = 0;
            if (this.var_byte_K == 1) {
                this.b(null, this.var_byte_arr_b, null, null, 1, this.var_byte_arr_b.length, 0);
            }
            this.b(this.var_boolean_arr_j, null, null, null, 1, this.var_boolean_arr_j.length, 0);
            this.bo = 0;
            while (this.bo < 3) {
                this.b(null, null, null, this.var_int_arr_arr_e[this.bo], 20, 1, 5000);
                ++this.bo;
            }
            this.b(null, null, null, this.var_int_arr_arr_c[0], 24, d.var_short_arr_k[4] + 2, 5000);
            this.b(null, null, null, this.var_int_arr_arr_c[1], 4, d.var_short_arr_k[4] + 2, 1);
            this.b(null, null, null, this.var_int_arr_arr_c[2], 8, d.var_short_arr_k[4] + 2, 1);
            if (this.var_byte_K == 0) {
                this.bo = 3;
                while (this.bo < 8) {
                    this.b(null, null, null, this.var_int_arr_arr_c[this.bo], 10, d.var_short_arr_k[4] + 2, 1);
                    ++this.bo;
                }
                this.b(null, this.var_byte_arr_aW, null, null, 3, 4, 0);
                this.b(null, this.var_byte_arr_aX, null, null, 2, 4, 0);
            }
            this.bo = 0;
            while (this.bo < 30) {
                this.b(null, this.var_byte_arr_arr_b[this.bo], null, null, 6, 30, 29);
                this.b(null, this.var_byte_arr_arr_c[this.bo], null, null, 7, 30, 1);
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
            this.b(null, null, null, this.var_int_arr_a, 5, 2, 1);
            this.bo = 0;
            while (this.bo < 4) {
                this.b(null, null, null, this.var_int_arr_arr_f[this.bo], 7, 2, 25);
                ++this.bo;
            }
            this.b(null, this.var_byte_arr_B, null, null, 5, this.var_byte_arr_B.length, 1);
            this.b(null, this.var_byte_arr_C, null, null, 5, this.var_byte_arr_C.length, 1);
            this.b(null, this.var_byte_arr_D, null, null, 5, this.var_byte_arr_D.length, 1);
            this.b(null, this.var_byte_arr_E, null, null, 5, this.var_byte_arr_E.length, 1);
            this.b(null, this.var_byte_arr_G, null, null, 8, this.var_byte_arr_G.length, 128);
            this.b(null, this.var_byte_arr_H, null, null, 8, this.var_byte_arr_H.length, 128);
            this.b(null, this.var_byte_arr_A, null, null, 4, this.var_byte_arr_A.length, 1);
            this.b(null, this.var_byte_arr_F, null, null, 3, this.var_byte_arr_F.length, 0);
            this.b(null, this.var_byte_arr_I, null, null, 2, this.var_byte_arr_I.length, -1);
            this.b(null, this.var_byte_arr_W, null, null, 5, this.var_byte_arr_W.length, 1);
            this.b(null, this.var_byte_arr_X, null, null, 3, this.var_byte_arr_X.length, 0);
            this.bo = 0;
            while (this.bo < 3) {
                this.b(null, this.var_byte_arr_arr_f[this.bo], null, null, 6, 200, 2);
                this.b(null, this.var_byte_arr_arr_h[this.bo], null, null, 3, 222, 2);
                ++this.bo;
            }
            this.b(null, this.var_byte_arr_L, null, null, 7, this.var_byte_arr_L.length, 10);
            this.b(null, null, this.var_short_arr_b, null, 4, this.var_short_arr_b.length, 1);
            this.b(null, this.var_byte_arr_M, null, null, 3, this.var_byte_arr_M.length, 1);
            this.b(null, null, this.var_short_arr_e, null, 10, this.var_short_arr_e.length, 10);
            this.bo = 0;
            while (this.bo < 30) {
                this.b(null, this.var_byte_arr_arr_i[this.bo], null, null, 5, 2, 1);
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
                this.b(null, this.var_byte_arr_arr_k[this.bo], null, null, 5, 2, 1);
                ++this.bo;
            }
            this.b(null, this.var_byte_arr_Z, null, null, 5, this.var_byte_arr_Z.length, 1);
            this.b(null, this.var_byte_arr_aa, null, null, 2, this.var_byte_arr_aa.length, 1);
            this.b(null, this.var_byte_arr_ab, null, null, 7, this.var_byte_arr_ab.length, 1);
            this.b(null, this.var_byte_arr_ad, null, null, 5, this.var_byte_arr_ad.length, 1);
            this.b(null, this.var_byte_arr_ae, null, null, 5, this.var_byte_arr_ae.length, 1);
            this.b(null, this.var_byte_arr_af, null, null, 8, this.var_byte_arr_af.length, 128);
            this.b(null, this.var_byte_arr_ag, null, null, 3, this.var_byte_arr_ag.length, 1);
            this.b(null, this.var_byte_arr_ah, null, null, 7, this.var_byte_arr_ah.length, 10);
            this.b(null, this.var_byte_arr_ai, null, null, 2, this.var_byte_arr_ai.length, 0);
            this.b(null, this.var_byte_arr_aj, null, null, 2, this.var_byte_arr_aj.length, 1);
            this.b(this.var_boolean_arr_a, null, null, null, 1, this.var_boolean_arr_a.length, 0);
            this.b(this.var_boolean_arr_b, null, null, null, 1, this.var_boolean_arr_b.length, 0);
            this.b(this.var_boolean_arr_c, null, null, null, 1, this.var_boolean_arr_c.length, 0);
            if (this.var_byte_K == 1) {
                this.b(this.var_boolean_arr_g, null, null, null, 1, this.var_boolean_arr_g.length, 0);
            }
            this.bo = 0;
            while (this.bo < 2) {
                this.b(null, this.var_byte_arr_arr_l[this.bo], null, null, 5, 42, 1);
                this.b(null, this.var_byte_arr_arr_m[this.bo], null, null, 5, 42, 1);
                this.b(null, this.var_byte_arr_arr_n[this.bo], null, null, 5, 42, 1);
                ++this.bo;
            }
            this.bo = 0;
            while (this.bo < 2) {
                this.var_byte_arr_ac[this.bo] = 0;
                if (this.var_byte_arr_Z[this.bo] == 23) {
                    this.bp = 0;
                    while (this.bp < 12) {
                        this.var_short_arr_arr_e[this.bo][this.bp] = -1;
                        ++this.bp;
                    }
                }
                ++this.bo;
            }
            this.b(null, this.var_byte_arr_ak, null, null, 7, this.var_byte_arr_ak.length, 10);
            this.b(this.var_boolean_arr_d, null, null, null, 1, this.var_boolean_arr_d.length, 0);
            this.b(this.var_boolean_arr_e, null, null, null, 1, this.var_boolean_arr_e.length, 0);
            this.b(this.var_boolean_arr_f, null, null, null, 1, this.var_boolean_arr_f.length, 0);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void ed() {
        try {
            if (this.var_byte_K == 1) {
                this.b(this.var_boolean_arr_h, null, null, null, 1, this.var_boolean_arr_h.length, 0);
            }
            this.b(null, this.var_byte_arr_al, null, null, 4, this.var_byte_arr_al.length, 0);
            this.b(null, this.var_byte_arr_aE, null, null, 4, this.var_byte_arr_aE.length, 0);
            this.b(null, null, this.var_short_arr_g, null, 9, this.var_short_arr_g.length, 256);
            if (this.var_byte_K == 1) {
                this.b(this.var_boolean_arr_g, null, null, null, 1, this.var_boolean_arr_g.length, 0);
                this.b(this.var_boolean_arr_h, null, null, null, 1, this.var_boolean_arr_h.length, 0);
            } else {
                this.bo = 0;
                while (this.bo < this.var_boolean_arr_g.length) {
                    this.var_boolean_arr_g[this.bo] = true;
                    ++this.bo;
                }
                this.bo = 0;
                while (this.bo < this.var_boolean_arr_h.length) {
                    this.var_boolean_arr_h[this.bo] = true;
                    ++this.bo;
                }
            }
            this.bo = 0;
            while (this.bo < this.var_byte_ae) {
                this.br = this.bq = this.var_java_io_DataInputStream_a.readInt();
                if (100 - this.bq < this.bq) {
                    this.br = 100 - this.bq;
                }
                ++this.br;
                this.bp = 0;
                while (this.bp < 200) {
                    if (this.var_byte_arr_B[this.bp] >= 0) {
                        this.var_byte_arr_arr_g[this.bo][this.bp] = (byte)(this.bq + ((this.var_java_util_Random_a.nextInt() & 0xFFFF) % this.br - this.br / 2));
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
                if (this.var_byte_arr_B[this.bo] >= 0) {
                    this.var_short_arr_c[this.bo] = 5;
                    this.var_byte_arr_J[this.bo] = 0;
                    if (this.bo < 200) {
                        if (this.var_byte_arr_W[this.bo] == 11) {
                            this.var_byte_arr_W[this.bo] = 9;
                            byte by = this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]];
                            this.var_byte_arr_ad[by] = (byte)(this.var_byte_arr_ad[by] - 1);
                        } else if (this.var_byte_arr_W[this.bo] == 12 || this.var_byte_arr_W[this.bo] == 13) {
                            this.var_short_arr_arr_e[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]][this.var_byte_arr_ac[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]] = (short)this.bo;
                            if (this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][4] + 0] == 1 && this.var_byte_arr_W[this.bo] == 13) {
                                if (this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][2] + 2] == 0) {
                                    this.var_byte_arr_G[this.bo] = this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][21] + 0 * this.var_byte_arr_au[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]] + this.var_byte_arr_ac[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]];
                                }
                                if (this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][2] + 3] == 0) {
                                    this.var_byte_arr_H[this.bo] = this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][22] + 0 * this.var_byte_arr_au[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]] + this.var_byte_arr_ac[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]];
                                }
                                if (this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][2] + 4] == 0) {
                                    this.var_byte_arr_F[this.bo] = this.var_byte_arr_arr_o[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][this.var_short_arr_arr_g[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][23] + 0 * this.var_byte_arr_au[this.var_byte_arr_Z[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]] + this.var_byte_arr_ac[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]];
                                }
                            }
                            byte by = this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]];
                            this.var_byte_arr_ac[by] = (byte)(this.var_byte_arr_ac[by] + 1);
                        }
                        this.var_byte_arr_N[this.bo] = -1;
                        this.var_byte_arr_O[this.bo] = -1;
                    }
                }
                ++this.bo;
            }
            this.var_byte_az = 0;
            this.var_byte_aG = 0;
            this.bo = 0;
            while (this.bo < 222) {
                this.var_short_arr_d[this.bo] = -1;
                if (this.var_byte_arr_B[this.bo] >= 0) {
                    if (this.var_byte_arr_A[this.bo] == 9 && this.var_byte_arr_arr_b[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]] >= 4 && this.var_byte_arr_arr_b[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]] <= 12 && this.var_byte_arr_ag[this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]] == 4) {
                        this.var_short_arr_arr_c[this.var_byte_arr_arr_m[0][this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]][this.var_byte_arr_arr_m[1][this.var_byte_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]]]] = (short)this.bo;
                    } else {
                        this.var_short_arr_d[this.bo] = this.var_short_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]];
                        this.var_short_arr_arr_c[this.var_byte_arr_B[this.bo]][this.var_byte_arr_C[this.bo]] = (short)this.bo;
                    }
                }
                ++this.bo;
            }
            this.bo = 0;
            while (this.bo < 24) {
                this.var_int_o = this.bo++;
                this.cH();
            }
            this.var_byte_Y = 0;
            while (this.var_byte_Y < this.var_byte_O / 5) {
                this.var_byte_Z = 0;
                while (this.var_byte_Z < this.var_byte_O / 5) {
                    this.cG();
                    this.var_byte_Z = (byte)(this.var_byte_Z + 1);
                }
                this.var_byte_Y = (byte)(this.var_byte_Y + 1);
            }
            this.dx();
            this.bo = 0;
            while (this.bo < 42) {
                if (this.var_byte_arr_arr_l[0][this.bo] >= 0 && this.var_byte_arr_aD[this.var_byte_arr_Z[this.bo]] == 0) {
                    this.var_byte_arr_aD[this.var_byte_arr_Z[this.bo]] = (byte)(this.var_byte_arr_aA[this.var_byte_arr_Z[this.bo]] / b.au[0]);
                    this.var_byte_arr_aD[24] = (byte)(this.var_byte_arr_aD[24] + this.var_byte_arr_aD[this.var_byte_arr_Z[this.bo]]);
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

