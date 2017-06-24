package com.example.christian.digdugassignment_3;

public class Dirt {
    public static int width = 1080;
    public static int height = 1584;
    public static int rowheight = 51;
    public static int columnwidth = 54;
    public static int dirtheight = 1029;
    public static int dirtwidth = 1080;
    public static int eqheight = dirtheight/rowheight;
    public static int eqwidth = dirtwidth/columnwidth;
    public static Monster1 monster1;
    public static Monster2 monster2;
    public static Monster3 monster3;
    public static Dragon dragon;
    public Dirt(int newheight, int newwidth) {
        height = newheight;
        width = newwidth;
    }
    public static int[][] generateDirt() {
        int[][] dirtmap = new int[eqheight][eqwidth];
        //generate pattern of tunnels to scale with given size
        for(int i = 0; i < eqheight; i++) {
            for(int j = 0; j < eqwidth; j++) {
                if(i == 0) { //top area where characters can walk
                    dirtmap[i][j] = 0;
                }
                else { //generate rest of map with dirt
                    dirtmap[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < eqheight/2; i++) { //path digdug digs going to starting tunnel
            dirtmap[i][eqwidth/2] = 0;
        }
        for(int j = 3*eqwidth/7; j < 5*eqwidth/7 - 1; j++) {//horizontal tunnel digdug starts in
            dirtmap[(eqheight)/2][j] = 0;
        }
        for(int i = eqheight/10; i < eqheight/2 - 1; i++) {//vertical tunnel for monster
            dirtmap[i][eqwidth/10] = 0;
        }
        for(int j = eqwidth/7; j < 2*eqwidth/5; j++) {//horizontal tunnel for dragon
            dirtmap[2*eqheight/3][j] = 0;
        }
        for(int j = 2*eqwidth/3; j < 9*eqwidth/10; j++) {//horizontal tunnel for monster
            dirtmap[eqheight/10][j] = 0;
        }
        for(int i = 2*eqheight/3; i < 9*eqheight/10; i++) {//vertical tunnel for monster
            dirtmap[i][2*eqwidth/3] = 0;
        }
        return dirtmap;
    }

    public static void generateRocks(int[][] dirtmap) {
        dirtmap[eqheight/10][eqwidth/3] = 2;
        dirtmap[2*eqheight/3+1][eqwidth/7] = 2;
        dirtmap[2*eqheight/3][2*eqwidth/3 + 1] = 2;
    }
    public static void placeDigDug(int[][] dirtmap) {
        dirtmap[eqheight/2][eqwidth/2] = 3;
    }
    public static void placeMonsters(int[][] dirtmap) {
        dirtmap[eqheight/10 + 1][eqwidth/10] = 4;
        dirtmap[eqheight/10][9*eqwidth/10 - 1] = 4;
        dirtmap[2*eqheight/3 + 1][2*eqwidth/3] = 4;
    }
    public static void placeDragon(int[][] dirtmap) {
        dirtmap[2*eqheight/3][eqwidth/7 + 1] = 5;
    }
    public static void clearTemps(int[][] dirtmap) { //clears fire and inflators
        for(int i = 0; i < eqheight - 1; i++) {
            for(int j = 0; j < eqwidth - 1; j++) {
                if(dirtmap[i][j] == 6 || dirtmap[i][j] == 7 || dirtmap[i][j] == 8 || dirtmap[i][j] == 9 || dirtmap[i][j] == 10) { //top area where characters can walk
                    dirtmap[i][j] = 0;
                }
            }
        }
    }
    public static void rocksFalling(int[][] dirtmap) {
        for(int i = 0; i < eqheight - 1; i++) {
            for(int j = 0; j < eqwidth - 1; j++) {
                if(dirtmap[i][j] == 2 && dirtmap[i + 1][j] != 1) {
                    if(dirtmap[i + 1][j] == 3 && dirtmap[i - 1][j] == 1) {
                        if(DigDug.rockshield == 1) {
                            DigDug.rockshield = 0;
                            return;
                        }
                        else {
                            dirtmap[i][j] = 0;
                            dirtmap[i + 1][j] = 2;

                        }
                    }
                    dirtmap[i][j] = 0;
                    dirtmap[i + 1][j] = 2;
                    DigDug.rockshield = 1;
                    return;
                }
            }
        }
    }
}
