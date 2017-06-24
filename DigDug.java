package com.example.christian.digdugassignment_3;

/**
 * Created by Christian on 5/23/2017.
 */

public class DigDug {
    public static int y;
    public static int x;
    public static int facing;
    public static int direction;
    public static int rockshield = 1;
    public DigDug(int newy, int newx, int newdirection) {
        y = newy;
        x = newx;
        facing = 1;
        direction = newdirection;
    }
    public static void moveDigDug(int[][] dirtmap, int direction, DigDug digdug) {
        digdug.direction = direction;
        //make if statements for direction
        if(digdug.direction == 0) {
            digdug.facing = 0;
            if(digdug.y != 0 && dirtmap[digdug.y - 1][digdug.x] != 2) {
                dirtmap[digdug.y - 1][digdug.x] = 3;
                dirtmap[digdug.y][digdug.x] = 0;
                digdug.y--;
            }
        }
        else if(digdug.direction == 1) {
            digdug.facing = 1;
            if(digdug.x != Dirt.eqwidth - 1 && dirtmap[digdug.y][digdug.x + 1] != 2) {
                dirtmap[digdug.y][digdug.x + 1] = 3;
                dirtmap[digdug.y][digdug.x] = 0;
                digdug.x++;
            }
        }
        else if(digdug.direction == 2) {
            digdug.facing = 2;
            if(digdug.y != Dirt.eqheight - 1 && dirtmap[digdug.y + 1][digdug.x] != 2) {
                dirtmap[digdug.y + 1][digdug.x] = 3;
                dirtmap[digdug.y][digdug.x] = 0;
                digdug.y++;
            }
        }
        else {
            digdug.facing = 3;
            if(digdug.x != 0 && dirtmap[digdug.y][digdug.x - 1] != 2) {
                dirtmap[digdug.y][digdug.x - 1] = 3;
                dirtmap[digdug.y][digdug.x] = 0;
                digdug.x--;
            }
        }
    }
    public static void inflate(int[][] dirtmap, DigDug digdug) {
        //check if monster is close enough and in front of digdug
        //if inflatable, call getInflated in Dragon.java
        if(digdug.facing == 0) { //facing up
            if(dirtmap[digdug.y - 1][digdug.x] == 5) {
                Dragon inflatingdragon = Dragon.identifyMonster(digdug.y - 1, digdug.x, dirtmap);
                Dragon.getInflated(dirtmap, inflatingdragon);
                return;
            }
            if(dirtmap[digdug.y - 1][digdug.x] == 4) {
                Monster1 inflatingmonster1 = Monster1.identifyMonster(digdug.y - 1, digdug.x, dirtmap);
                if(inflatingmonster1 != null) {
                    Monster1.getInflated(dirtmap, inflatingmonster1);
                }
                Monster2 inflatingmonster2 = Monster2.identifyMonster(digdug.y - 1, digdug.x, dirtmap);
                if(inflatingmonster2 != null) {
                    Monster2.getInflated(dirtmap, inflatingmonster2);
                }
                Monster3 inflatingmonster3 = Monster3.identifyMonster(digdug.y - 1, digdug.x, dirtmap);
                if(inflatingmonster3 != null) {
                    Monster3.getInflated(dirtmap, inflatingmonster3);
                }
                return;
            }
            if(dirtmap[digdug.y - 1][digdug.x] == 0) {
                dirtmap[digdug.y - 1][digdug.x] = 7;
            }
            if(dirtmap[digdug.y - 2][digdug.x] == 5) {
                Dragon inflatingmonster = Dragon.identifyMonster(digdug.y - 2, digdug.x, dirtmap);
                Dragon.getInflated(dirtmap, inflatingmonster);
                return;
            }
            if(dirtmap[digdug.y - 2][digdug.x] == 4) {
                Monster1 inflatingmonster1 = Monster1.identifyMonster(digdug.y - 2, digdug.x, dirtmap);
                if(inflatingmonster1 != null) {
                    Monster1.getInflated(dirtmap, inflatingmonster1);
                    return;
                }
                Monster2 inflatingmonster2 = Monster2.identifyMonster(digdug.y - 2, digdug.x, dirtmap);
                if(inflatingmonster2 != null) {
                    Monster2.getInflated(dirtmap, inflatingmonster2);
                    return;
                }
                Monster3 inflatingmonster3 = Monster3.identifyMonster(digdug.y - 2, digdug.x, dirtmap);
                if(inflatingmonster3 != null) {
                    Monster3.getInflated(dirtmap, inflatingmonster3);
                    return;
                }
                return;
            }
            if(dirtmap[digdug.y - 2][digdug.x] == 0) {
                dirtmap[digdug.y - 2][digdug.x] = 7;
            }
            if(dirtmap[digdug.y - 3][digdug.x] == 5) {
                Dragon inflatingmonster = Dragon.identifyMonster(digdug.y - 3, digdug.x, dirtmap);
                Dragon.getInflated(dirtmap, inflatingmonster);
                return;
            }
            if(dirtmap[digdug.y - 3][digdug.x] == 4) {
                Monster1 inflatingmonster1 = Monster1.identifyMonster(digdug.y - 3, digdug.x, dirtmap);
                if(inflatingmonster1 != null) {
                    Monster1.getInflated(dirtmap, inflatingmonster1);
                    return;
                }
                Monster2 inflatingmonster2 = Monster2.identifyMonster(digdug.y - 3, digdug.x, dirtmap);
                if(inflatingmonster2 != null) {
                    Monster2.getInflated(dirtmap, inflatingmonster2);
                    return;
                }
                Monster3 inflatingmonster3 = Monster3.identifyMonster(digdug.y - 3, digdug.x, dirtmap);
                if(inflatingmonster3 != null) {
                    Monster3.getInflated(dirtmap, inflatingmonster3);
                    return;
                }
                return;
            }
        }
        else if(digdug.facing == 1) { //facing right
            if(dirtmap[digdug.y][digdug.x + 1] == 5) {
                Dragon inflatingdragon = Dragon.identifyMonster(digdug.y, digdug.x + 1, dirtmap);
                Dragon.getInflated(dirtmap, inflatingdragon);
                return;
            }
            if(dirtmap[digdug.y][digdug.x + 1] == 4) {
                Monster1 inflatingmonster1 = Monster1.identifyMonster(digdug.y, digdug.x + 1, dirtmap);
                if(inflatingmonster1 != null) {
                    Monster1.getInflated(dirtmap, inflatingmonster1);
                    return;
                }
                Monster2 inflatingmonster2 = Monster2.identifyMonster(digdug.y, digdug.x + 1, dirtmap);
                if(inflatingmonster2 != null) {
                    Monster2.getInflated(dirtmap, inflatingmonster2);
                    return;
                }
                Monster3 inflatingmonster3 = Monster3.identifyMonster(digdug.y, digdug.x + 1, dirtmap);
                if(inflatingmonster3 != null) {
                    Monster3.getInflated(dirtmap, inflatingmonster3);
                    return;
                }
                return;
            }
            if(dirtmap[digdug.y][digdug.x + 1] == 0) {
                dirtmap[digdug.y][digdug.x + 1] = 8;
            }
            if(dirtmap[digdug.y][digdug.x + 2] == 5) {
                Dragon inflatingmonster = Dragon.identifyMonster(digdug.y, digdug.x + 2, dirtmap);
                Dragon.getInflated(dirtmap, inflatingmonster);
                return;
            }
            if(dirtmap[digdug.y][digdug.x + 2] == 4) {
                Monster1 inflatingmonster1 = Monster1.identifyMonster(digdug.y, digdug.x + 2, dirtmap);
                if(inflatingmonster1 != null) {
                    Monster1.getInflated(dirtmap, inflatingmonster1);
                    return;
                }
                Monster2 inflatingmonster2 = Monster2.identifyMonster(digdug.y, digdug.x + 2, dirtmap);
                if(inflatingmonster2 != null) {
                    Monster2.getInflated(dirtmap, inflatingmonster2);
                    return;
                }
                Monster3 inflatingmonster3 = Monster3.identifyMonster(digdug.y, digdug.x + 2, dirtmap);
                if(inflatingmonster3 != null) {
                    Monster3.getInflated(dirtmap, inflatingmonster3);
                    return;
                }
                return;
            }
            if(dirtmap[digdug.y][digdug.x + 2] == 0) {
                dirtmap[digdug.y][digdug.x + 2] = 8;
            }
            if(dirtmap[digdug.y][digdug.x + 3] == 5) {
                Dragon inflatingmonster = Dragon.identifyMonster(digdug.y, digdug.x + 3, dirtmap);
                Dragon.getInflated(dirtmap, inflatingmonster);
                return;
            }
            if(dirtmap[digdug.y][digdug.x + 3] == 4) {
                Monster1 inflatingmonster1 = Monster1.identifyMonster(digdug.y, digdug.x + 3, dirtmap);
                if(inflatingmonster1 != null) {
                    Monster1.getInflated(dirtmap, inflatingmonster1);
                    return;
                }
                Monster2 inflatingmonster2 = Monster2.identifyMonster(digdug.y, digdug.x + 3, dirtmap);
                if(inflatingmonster2 != null) {
                    Monster2.getInflated(dirtmap, inflatingmonster2);
                    return;
                }
                Monster3 inflatingmonster3 = Monster3.identifyMonster(digdug.y, digdug.x + 3, dirtmap);
                if(inflatingmonster3 != null) {
                    Monster3.getInflated(dirtmap, inflatingmonster3);
                    return;
                }
                return;
            }
        }
        else if(digdug.facing == 2) { //facing down
            if(dirtmap[digdug.y + 1][digdug.x] == 5) {
                Dragon inflatingdragon = Dragon.identifyMonster(digdug.y + 1, digdug.x, dirtmap);
                Dragon.getInflated(dirtmap, inflatingdragon);
                return;
            }
            if(dirtmap[digdug.y + 1][digdug.x] == 4) {
                Monster1 inflatingmonster1 = Monster1.identifyMonster(digdug.y + 1, digdug.x, dirtmap);
                if(inflatingmonster1 != null) {
                    Monster1.getInflated(dirtmap, inflatingmonster1);
                    return;
                }
                Monster2 inflatingmonster2 = Monster2.identifyMonster(digdug.y + 1, digdug.x, dirtmap);
                if(inflatingmonster2 != null) {
                    Monster2.getInflated(dirtmap, inflatingmonster2);
                    return;
                }
                Monster3 inflatingmonster3 = Monster3.identifyMonster(digdug.y + 1, digdug.x, dirtmap);
                if(inflatingmonster3 != null) {
                    Monster3.getInflated(dirtmap, inflatingmonster3);
                    return;
                }
                return;
            }
            if(dirtmap[digdug.y + 1][digdug.x] == 0) {
                dirtmap[digdug.y + 1][digdug.x] = 9;
            }
            if(dirtmap[digdug.y + 2][digdug.x] == 5) {
                Dragon inflatingmonster = Dragon.identifyMonster(digdug.y + 2, digdug.x, dirtmap);
                Dragon.getInflated(dirtmap, inflatingmonster);
                return;
            }
            if(dirtmap[digdug.y + 2][digdug.x] == 4) {
                Monster1 inflatingmonster1 = Monster1.identifyMonster(digdug.y + 2, digdug.x, dirtmap);
                if(inflatingmonster1 != null) {
                    Monster1.getInflated(dirtmap, inflatingmonster1);
                    return;
                }
                Monster2 inflatingmonster2 = Monster2.identifyMonster(digdug.y + 2, digdug.x, dirtmap);
                if(inflatingmonster2 != null) {
                    Monster2.getInflated(dirtmap, inflatingmonster2);
                    return;
                }
                Monster3 inflatingmonster3 = Monster3.identifyMonster(digdug.y + 2, digdug.x, dirtmap);
                if(inflatingmonster3 != null) {
                    Monster3.getInflated(dirtmap, inflatingmonster3);
                    return;
                }
                return;
            }
            if(dirtmap[digdug.y + 2][digdug.x] == 0) {
                dirtmap[digdug.y + 2][digdug.x] = 9;
            }
            if(dirtmap[digdug.y + 3][digdug.x] == 5) {
                Dragon inflatingmonster = Dragon.identifyMonster(digdug.y + 3, digdug.x, dirtmap);
                Dragon.getInflated(dirtmap, inflatingmonster);
                return;
            }
            if(dirtmap[digdug.y + 3][digdug.x] == 4) {
                Monster1 inflatingmonster1 = Monster1.identifyMonster(digdug.y + 3, digdug.x, dirtmap);
                if(inflatingmonster1 != null) {
                    Monster1.getInflated(dirtmap, inflatingmonster1);
                    return;
                }
                Monster2 inflatingmonster2 = Monster2.identifyMonster(digdug.y + 3, digdug.x, dirtmap);
                if(inflatingmonster2 != null) {
                    Monster2.getInflated(dirtmap, inflatingmonster2);
                    return;
                }
                Monster3 inflatingmonster3 = Monster3.identifyMonster(digdug.y + 3, digdug.x, dirtmap);
                if(inflatingmonster3 != null) {
                    Monster3.getInflated(dirtmap, inflatingmonster3);
                    return;
                }
                return;
            }
        }
        else { //facing left
            if(dirtmap[digdug.y][digdug.x - 1] == 5) {
                Dragon inflatingdragon = Dragon.identifyMonster(digdug.y, digdug.x - 1, dirtmap);
                Dragon.getInflated(dirtmap, inflatingdragon);
                return;
            }
            if(dirtmap[digdug.y][digdug.x - 1] == 4) {
                Monster1 inflatingmonster1 = Monster1.identifyMonster(digdug.y, digdug.x - 1, dirtmap);
                if(inflatingmonster1 != null) {
                    Monster1.getInflated(dirtmap, inflatingmonster1);
                    return;
                }
                Monster2 inflatingmonster2 = Monster2.identifyMonster(digdug.y, digdug.x - 1, dirtmap);
                if(inflatingmonster2 != null) {
                    Monster2.getInflated(dirtmap, inflatingmonster2);
                    return;
                }
                Monster3 inflatingmonster3 = Monster3.identifyMonster(digdug.y, digdug.x - 1, dirtmap);
                if(inflatingmonster3 != null) {
                    Monster3.getInflated(dirtmap, inflatingmonster3);
                    return;
                }
                return;
            }
            if(dirtmap[digdug.y][digdug.x - 1] == 0) {
                dirtmap[digdug.y][digdug.x - 1] = 10;
            }
            if(dirtmap[digdug.y][digdug.x - 2] == 5) {
                Dragon inflatingmonster = Dragon.identifyMonster(digdug.y, digdug.x - 2, dirtmap);
                Dragon.getInflated(dirtmap, inflatingmonster);
                return;
            }
            if(dirtmap[digdug.y][digdug.x - 2] == 4) {
                Monster1 inflatingmonster1 = Monster1.identifyMonster(digdug.y, digdug.x - 2, dirtmap);
                if(inflatingmonster1 != null) {
                    Monster1.getInflated(dirtmap, inflatingmonster1);
                    return;
                }
                Monster2 inflatingmonster2 = Monster2.identifyMonster(digdug.y, digdug.x - 2, dirtmap);
                if(inflatingmonster2 != null) {
                    Monster2.getInflated(dirtmap, inflatingmonster2);
                    return;
                }
                Monster3 inflatingmonster3 = Monster3.identifyMonster(digdug.y, digdug.x - 2, dirtmap);
                if(inflatingmonster3 != null) {
                    Monster3.getInflated(dirtmap, inflatingmonster3);
                    return;
                }
                return;
            }
            if(dirtmap[digdug.y][digdug.x - 2] == 0) {
                dirtmap[digdug.y][digdug.x - 2] = 10;
            }
            if(dirtmap[digdug.y][digdug.x - 3] == 5) {
                Dragon inflatingmonster = Dragon.identifyMonster(digdug.y, digdug.x - 3, dirtmap);
                Dragon.getInflated(dirtmap, inflatingmonster);
                return;
            }
            if(dirtmap[digdug.y][digdug.x - 3] == 4) {
                Monster1 inflatingmonster1 = Monster1.identifyMonster(digdug.y, digdug.x - 3, dirtmap);
                if(inflatingmonster1 != null) {
                    Monster1.getInflated(dirtmap, inflatingmonster1);
                    return;
                }
                Monster2 inflatingmonster2 = Monster2.identifyMonster(digdug.y, digdug.x - 3, dirtmap);
                if(inflatingmonster2 != null) {
                    Monster2.getInflated(dirtmap, inflatingmonster2);
                    return;
                }
                Monster3 inflatingmonster3 = Monster3.identifyMonster(digdug.y, digdug.x - 3, dirtmap);
                if(inflatingmonster3 != null) {
                    Monster3.getInflated(dirtmap, inflatingmonster3);
                    return;
                }
                return;
            }
        }
    }
}
