package com.example.christian.digdugassignment_3;

/**
 * Created by Christian on 5/26/2017.
 */

public class Monster1 {
    public static int y;
    public static int x;
    public static int facing;
    public static int direction;
    public static int type;
    public static int inflation;
    public Monster1(int newy, int newx, int newtype, int newdirection) {
        y = newy;
        x = newx;
        facing = 1;
        type = newtype;
        direction = newdirection;
        inflation = 0;
    }
    public static void moveMonster(int[][] dirtmap, Monster1 monster) {
        //make if statements for direction
        if(monster.direction == 0) {
            if(dirtmap[monster.y - 1][monster.x] == 3 || dirtmap[monster.y - 1][monster.x] == 0) {
                if(monster.type == 2) {
                    dirtmap[monster.y - 1][monster.x] = 5;
                }
                else {
                    dirtmap[monster.y - 1][monster.x] = 4;
                }
                dirtmap[monster.y][monster.x] = 0;
                monster.y--;
            }
            else {
                monster.direction = 2;
                if(monster.type == 2) {
                    dirtmap[monster.y + 1][monster.x] = 5;
                }
                else {
                    dirtmap[monster.y + 1][monster.x] = 4;
                }
                dirtmap[monster.y][monster.x] = 0;
                monster.y++;
            }
        }
        else if(monster.direction == 1) {
            monster.facing = 1;
            if(dirtmap[monster.y][monster.x + 1] == 3 || dirtmap[monster.y][monster.x + 1] == 0) {
                if(monster.type == 2) {
                    dirtmap[monster.y][monster.x + 1] = 5;
                }
                else {
                    dirtmap[monster.y][monster.x + 1] = 4;
                }
                dirtmap[monster.y][monster.x] = 0;
                monster.x++;
            }
            else {
                monster.direction = 3;
                monster.facing = 3;
                if(monster.type == 2) {
                    dirtmap[monster.y][monster.x - 1] = 5;
                }
                else {
                    dirtmap[monster.y][monster.x - 1] = 4;
                }
                dirtmap[monster.y][monster.x] = 0;
                monster.x--;
            }
        }
        else if(monster.direction == 2) {
            if(dirtmap[monster.y + 1][monster.x] == 3 || dirtmap[monster.y + 1][monster.x] == 0) {
                if(monster.type == 2) {
                    dirtmap[monster.y + 1][monster.x] = 5;
                }
                else {
                    dirtmap[monster.y + 1][monster.x] = 4;
                }
                dirtmap[monster.y][monster.x] = 0;
                monster.y++;
            }
            else {
                monster.direction = 0;
                if(monster.type == 2) {
                    dirtmap[monster.y - 1][monster.x] = 5;
                }
                else {
                    dirtmap[monster.y - 1][monster.x] = 4;
                }
                dirtmap[monster.y][monster.x] = 0;
                monster.y--;
            }
        }
        else {
            monster.facing = 3;
            if(dirtmap[monster.y][monster.x - 1] == 3 || dirtmap[monster.y][monster.x - 1] == 0) {
                if(monster.type == 2) {
                    dirtmap[monster.y][monster.x - 1] = 5;
                }
                else {
                    dirtmap[monster.y][monster.x - 1] = 4;
                }
                dirtmap[monster.y][monster.x] = 0;
                monster.x--;
            }
            else {
                monster.direction = 1;
                monster.facing = 1;
                if(monster.type == 2) {
                    dirtmap[monster.y][monster.x + 1] = 5;
                }
                else {
                    dirtmap[monster.y][monster.x + 1] = 4;
                }
                dirtmap[monster.y][monster.x] = 0;
                monster.x++;
            }
        }
    }
    public static void getInflated(int[][] dirtmap, Monster1 monster) {
        //make if statements for level of inflation of monster
        monster.inflation++;
        if(monster.inflation >= 4) {
            dirtmap[monster.y][monster.x] = 0;
        }
    }
    public static void breatheFire(int[][] dirtmap, Monster1 monster) {
        if(monster.facing == 1) {
            if(dirtmap[monster.y][monster.x + 1] == 3 || dirtmap[monster.y][monster.x + 2] == 3 ) {
                dirtmap[monster.y][monster.x + 1] = 6;
                dirtmap[monster.y][monster.x + 2] = 6;
                //trigger game over
                return;
            }
            else {
                if(dirtmap[monster.y][monster.x + 1] == 1) {
                    return;
                }
                else if(dirtmap[monster.y][monster.x + 2] == 1) {
                    dirtmap[monster.y][monster.x + 1] = 6;
                    return;
                }
                else {
                    dirtmap[monster.y][monster.x + 1] = 6;
                    dirtmap[monster.y][monster.x + 2] = 6;
                }
            }
        }
        else {
            if(dirtmap[monster.y][monster.x - 1] == 3 || dirtmap[monster.y][monster.x - 2] == 3 ) {
                dirtmap[monster.y][monster.x - 1] = 6;
                dirtmap[monster.y][monster.x - 2] = 6;
                //trigger game over
                return;
            }
            else {
                if(dirtmap[monster.y][monster.x - 1] == 1) {
                    return;
                }
                else if(dirtmap[monster.y][monster.x - 2] == 1) {
                    dirtmap[monster.y][monster.x - 1] = 6;
                    return;
                }
                else {
                    dirtmap[monster.y][monster.x - 1] = 6;
                    dirtmap[monster.y][monster.x - 2] = 6;
                }
            }
        }
    }
    public static Monster1 identifyMonster(int y, int x, int[][] dirtmap) {
        Monster1 inflatingmonster;
        if(dirtmap[y][x] == 4) {
            inflatingmonster = Dirt.monster1;
            System.out.println("Monster1 identified");
        }
        else {
            inflatingmonster = null;
            System.out.println("Monster being inflated unidentified, defaulting to null");
        }
        return inflatingmonster;
    }
}
