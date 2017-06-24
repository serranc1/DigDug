package com.example.christian.digdugassignment_3;

/**
 * Created by Christian on 5/23/2017.
 */
import java.util.ArrayList;

public class Dragon {
    public static int y;
    public static int x;
    public static int facing;
    public static int direction;
    public static int type;
    public static int inflation;
    public Dragon (int newy, int newx, int newtype, int newdirection) {
        y = newy;
        x = newx;
        facing = 1;
        type = newtype;
        direction = newdirection;
        inflation = 0;
    }
    public static void moveMonster(int[][] dirtmap, Dragon monster) {
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
    public static void getInflated(int[][] dirtmap, Dragon monster) {
        //make if statements for level of inflation of monster
        monster.inflation++;
        if(monster.inflation >= 4) {
            dirtmap[monster.y][monster.x] = 0;
        }
    }
    public static int breatheFire(int[][] dirtmap, Dragon monster) {
        if(monster.facing == 1) {
            if((dirtmap[monster.y][monster.x + 1] == 3 || dirtmap[monster.y][monster.x + 2] == 3) && dirtmap[monster.y][monster.x + 1] == 0) {
                dirtmap[monster.y][monster.x + 1] = 6;
                dirtmap[monster.y][monster.x + 2] = 6;
                //trigger game over
                return 0;
            }
            else {
                if(dirtmap[monster.y][monster.x + 1] == 1) {
                    return 1;
                }
                else if(dirtmap[monster.y][monster.x + 2] == 1) {
                    dirtmap[monster.y][monster.x + 1] = 6;
                    return 1;
                }
                else {
                    dirtmap[monster.y][monster.x + 1] = 6;
                    dirtmap[monster.y][monster.x + 2] = 6;
                    return 1;
                }
            }
        }
        else {
            if(dirtmap[monster.y][monster.x - 1] == 3 || dirtmap[monster.y][monster.x - 2] == 3 ) {
                dirtmap[monster.y][monster.x - 1] = 6;
                dirtmap[monster.y][monster.x - 2] = 6;
                //trigger game over
                return 0;
            }
            else {
                if(dirtmap[monster.y][monster.x - 1] == 1) {
                    return 1;
                }
                else if(dirtmap[monster.y][monster.x - 2] == 1) {
                    dirtmap[monster.y][monster.x - 1] = 6;
                    return 1;
                }
                else {
                    dirtmap[monster.y][monster.x - 1] = 6;
                    dirtmap[monster.y][monster.x - 2] = 6;
                    return 1;
                }
            }
        }
    }
    public static Dragon identifyMonster(int y, int x, int[][] dirtmap) {
        Dragon inflatingmonster;
        if(dirtmap[y][x] == 5) {
            inflatingmonster = Dirt.dragon;
            System.out.println("Dragon identified");
        }
        else {
                inflatingmonster = null;
                System.out.println("Monster being inflated unidentified, defaulting to dragon");
        }
        return inflatingmonster;
    }
}
