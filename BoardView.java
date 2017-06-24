package com.example.christian.digdugassignment_3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;

public class BoardView extends SurfaceView implements SurfaceHolder.Callback {
    private Bitmap icons[];
    private ArrayList<Integer> indices = new ArrayList<Integer>();
    private int X;
    private int Y;
    private int dirtmap[][] = Dirt.generateDirt();
    private Monster1 monster1 = new Monster1(Dirt.eqheight/10 + 1, Dirt.eqwidth/10, 1, 2);
    private Monster2 monster2 = new Monster2(Dirt.eqheight/10, 9*Dirt.eqwidth/10 - 1, 1, 1);
    private Monster3 monster3 = new Monster3(2*Dirt.eqheight/3 + 1, 2*Dirt.eqwidth/3, 1, 2);
    private Dragon dragon = new Dragon(2*Dirt.eqheight/3, Dirt.eqwidth/7 + 1, 2, 1);
    private DigDug digdug = new DigDug(Dirt.eqheight/2, Dirt.eqwidth/2, 1);
    private int dragonfire = 0;
    private int digdugalive = 1;




    BoardView(Context context) {
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
        System.out.println("Constructor");


        icons = new Bitmap[15];
        Dirt dirt = new Dirt(1029, 1080);
        monster1 = new Monster1(dirt.eqheight/10 + 1, dirt.eqwidth/10, 1, 2);
        System.out.println("monster1 type is "+monster1.type);
        System.out.println("monster1 x is "+monster1.x);
        System.out.println("monster1 y is "+monster1.y);
        System.out.println("monster1 direction is "+monster1.direction);
        monster2 = new Monster2(dirt.eqheight/10, 9*dirt.eqwidth/10 - 1, 1, 1);
        System.out.println("monster1 type is "+monster1.type);
        System.out.println("monster1 x is "+monster1.x);
        System.out.println("monster1 y is "+monster1.y);
        System.out.println("monster1 direction is "+monster1.direction);
        System.out.println("monster2 type is "+monster2.type);
        System.out.println("monster2 x is "+monster2.x);
        System.out.println("monster2 y is "+monster2.y);
        System.out.println("monster2 direction is "+monster2.direction);
        monster3 = new Monster3(2*dirt.eqheight/3 + 1, 2*dirt.eqwidth/3, 1, 2);
        System.out.println("monster1 type is "+monster1.type);
        System.out.println("monster1 x is "+monster1.x);
        System.out.println("monster1 y is "+monster1.y);
        System.out.println("monster1 direction is "+monster1.direction);
        System.out.println("monster2 type is "+monster2.type);
        System.out.println("monster2 x is "+monster2.x);
        System.out.println("monster2 y is "+monster2.y);
        System.out.println("monster2 direction is "+monster2.direction);
        System.out.println("monster3 type is "+monster3.type);
        System.out.println("monster3 x is "+monster3.x);
        System.out.println("monster3 y is "+monster3.y);
        System.out.println("monster3 direction is "+monster3.direction);
        dragon = new Dragon(2*dirt.eqheight/3, dirt.eqwidth/7 + 1, 2, 1);
        System.out.println("dragon type is "+dragon.type);
        System.out.println("dragon x is "+dragon.x);
        System.out.println("dragon y is "+dragon.y);
        System.out.println("dragon direction is "+dragon.direction);
        digdug = new DigDug(dirt.eqheight/2, dirt.eqwidth/2, 1);
        Dirt.generateRocks(dirtmap);
        Dirt.placeDigDug(dirtmap);
        Dirt.placeMonsters(dirtmap);
        Dirt.placeDragon(dirtmap);
        System.out.println("monster1 type is "+monster1.type);
        System.out.println("monster1 x is "+monster1.x);
        System.out.println("monster1 y is "+monster1.y);
        System.out.println("monster1 direction is "+monster1.direction);
        System.out.println("monster2 type is "+monster2.type);
        System.out.println("monster2 x is "+monster2.x);
        System.out.println("monster2 y is "+monster2.y);
        System.out.println("monster2 direction is "+monster2.direction);
        System.out.println("monster3 type is "+monster3.type);
        System.out.println("monster3 x is "+monster3.x);
        System.out.println("monster3 y is "+monster3.y);
        System.out.println("monster3 direction is "+monster3.direction);

        for (int i = 0; i < dirt.eqheight; i++) {
            System.out.println();
            for (int j = 0; j < dirt.eqwidth; j++) {
                int tmpVal = dirtmap[i][j];
                System.out.print(dirtmap[i][j]);
                indices.add(tmpVal);
            }
        }
        System.out.println();
    }

    @Override
    public void onDraw(Canvas canvas) {
        System.out.println("onDraw()");
        canvas.drawColor(Color.BLACK);
        int width = getWidth();
        int height = getHeight();
        int columnwidth = Dirt.columnwidth;
        int rowheight = Dirt.rowheight;

        Rect rect = new Rect();
        for (int i = 0; i < Dirt.eqheight; i++) {
            for (int j = 0; j < Dirt.eqwidth; j++) {
                rect.set(j * columnwidth, i * rowheight, (j + 1) * columnwidth, (i + 1) * rowheight);
                Paint q = new Paint(Color.BLACK);
                if(indices.get(i * Dirt.eqheight + j) == 1) {
                    canvas.drawBitmap(icons[4], null, rect, q);
                }
                else if(indices.get(i * Dirt.eqheight + j) == 2) {
                    canvas.drawBitmap(icons[3], null, rect, q);
                }
                else if(indices.get(i * Dirt.eqheight + j) == 3) {
                    canvas.drawBitmap(icons[0], null, rect, q);
                }
                else if(indices.get(i * Dirt.eqheight + j) == 4) {
                    canvas.drawBitmap(icons[2], null, rect, q);
                }
                else if(indices.get(i * Dirt.eqheight + j) == 5) {
                    canvas.drawBitmap(icons[1], null, rect, q);
                }
                else if(indices.get(i * Dirt.eqheight + j) == 6) {
                    canvas.drawBitmap(icons[12], null, rect, q);
                }
                else if(indices.get(i * Dirt.eqheight + j) == 7) {
                    canvas.drawBitmap(icons[6], null, rect, q);
                }
                else if(indices.get(i * Dirt.eqheight + j) == 8) {
                    canvas.drawBitmap(icons[7], null, rect, q);
                }
                else if(indices.get(i * Dirt.eqheight + j) == 9) {
                    canvas.drawBitmap(icons[8], null, rect, q);
                }
                else if(indices.get(i * Dirt.eqheight + j) == 10) {
                    canvas.drawBitmap(icons[9], null, rect, q);
                }
                else{
                    canvas.drawBitmap(icons[5], null, rect, q);
                }
            }
        }

        rect.set(0, Dirt.height, width/2, height);
        Paint q = new Paint(Color.BLACK);
        canvas.drawBitmap(icons[10], null, rect, q);
        rect.set(width/2, Dirt.height, 3*width, height);
        canvas.drawBitmap(icons[11], null, rect, q);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        System.out.println("SurfaceCreated()");
        setWillNotDraw(false);

        icons[0] = BitmapFactory.decodeResource(getResources(), R.mipmap.digdug);
        icons[1] = BitmapFactory.decodeResource(getResources(), R.mipmap.dragon);
        icons[2] = BitmapFactory.decodeResource(getResources(), R.mipmap.monster);
        icons[3] = BitmapFactory.decodeResource(getResources(), R.mipmap.rock);
        icons[4] = BitmapFactory.decodeResource(getResources(), R.mipmap.dirt);
        icons[5] = BitmapFactory.decodeResource(getResources(), R.mipmap.black);
        icons[6] = BitmapFactory.decodeResource(getResources(), R.mipmap.inflator0);
        icons[7] = BitmapFactory.decodeResource(getResources(), R.mipmap.inflator1);
        icons[8] = BitmapFactory.decodeResource(getResources(), R.mipmap.inflator2);
        icons[9] = BitmapFactory.decodeResource(getResources(), R.mipmap.inflator3);
        icons[10] = BitmapFactory.decodeResource(getResources(), R.mipmap.dpad);
        icons[11] = BitmapFactory.decodeResource(getResources(), R.mipmap.redbutton);
        icons[12] = BitmapFactory.decodeResource(getResources(), R.mipmap.fire);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("touch event");
        if(digdugalive == 0) {
            return false;
        }

        int width = (getWidth());
        int height = (getHeight());
        Dirt.clearTemps(dirtmap);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            X = (int) event.getX();
            Y = (int) event.getY();
            if (X >= width / 6 && X <= width / 3 && Y >= Dirt.dirtheight && Y <= height - (height - Dirt.dirtheight) / 2) {
                //move up
                DigDug.moveDigDug(dirtmap, 0, digdug);
                System.out.println("move up");
            } else if (X >= width / 6 && X <= width / 3 && Y >= height - (height - Dirt.dirtheight) / 2 && Y <= height) {
                //move down
                DigDug.moveDigDug(dirtmap, 2, digdug);
                System.out.println("move down");
            } else if (X >= 0 && X <= width / 6 && Y >= height - (height - Dirt.dirtheight) && Y <= height - (height - Dirt.dirtheight) / 3) {
                //move left
                System.out.println("move left");
                DigDug.moveDigDug(dirtmap, 3, digdug);
            } else if (X >= width / 3 && X <= width / 2 && Y >= height - (height - Dirt.dirtheight) && Y <= height - (height - Dirt.dirtheight) / 3) {
                //move right
                DigDug.moveDigDug(dirtmap, 1, digdug);
                System.out.println("move right");
            } else if (X >= width / 2 && X <= width && Y >= Dirt.dirtheight && Y <= height) {
                //inflate
                DigDug.inflate(dirtmap, digdug);
                System.out.println("inflate");
            } else {
                //do nothing
            }
            if(monster1.inflation == 0) {
                Monster1.moveMonster(dirtmap, monster1);
            }
            if(monster2.inflation == 0) {
                Monster2.moveMonster(dirtmap, monster2);
            }
            if(monster3.inflation == 0) {
                Monster3.moveMonster(dirtmap, monster3);
            }
            if(dragonfire != 4) {
                if(dragon.inflation == 0) {
                    Dragon.moveMonster(dirtmap, dragon);
                    dragonfire++;
                }
            }
            else{
                Dragon.breatheFire(dirtmap, dragon);
                dragonfire = 0;
            }
            Dirt.rocksFalling(dirtmap);
        }
        else {

        }
        indices.clear();
        for (int i = 0; i < Dirt.eqheight; i++) {
            System.out.println();
            for (int j = 0; j < Dirt.eqwidth; j++) {
                int tmpVal = dirtmap[i][j];
                System.out.print(dirtmap[i][j]);
                indices.add(tmpVal);
                if(dirtmap[i][j] == 3) {
                    digdugalive = 1;
                }
            }
        }
        System.out.println();
        invalidate();
        return false;
    }
}
