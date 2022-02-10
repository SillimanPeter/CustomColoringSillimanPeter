package com.example.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

public class PictureView extends SurfaceView
{

    RectangleObject skyR;
    RectangleObject groundR;
    RectangleObject houseR;
    RectangleObject roofR;
    RectangleObject chimneyR;
    RectangleObject doorR;

    final int width = 1536;
    final int height = 1566;

    public PictureView(Context context, AttributeSet attrs){
        super(context, attrs);

        //this is essential to onDraw method
        setWillNotDraw(false);

        setBackgroundColor(Color.WHITE);

        skyR = new RectangleObject("sky", Color.BLUE,
                0, 0,
                width, height);

        groundR = new RectangleObject("ground", Color.GREEN,
                0, height/2,
                width, height);

        houseR = new RectangleObject("house", Color.YELLOW,
                (2 * width)/7, height/3,
                (5 * width)/7,(2 * height)/3);

        roofR = new RectangleObject("roof", Color.DKGRAY,
                (3 * width)/14, height/4,
                (11 * width)/14,height/3);

        chimneyR = new RectangleObject("chimney", Color.RED,
                (3 * width)/9, height/7,
                (3 * width)/7, height/4);

        doorR = new RectangleObject("door", Color.LTGRAY,
                (3 * width)/7, height/2,
                (4 * width)/7,(2 * height)/3);
    }

    /**
     * onDraw is like "paint" in a regular Java program.  While a Canvas is
     * conceptually similar to a Graphics in javax.swing, the implementation has
     * many subtle differences.  Show care and read the documentation.
     *
     * This method will draw a picture in surfaceView
     */
    @Override
    public void onDraw(Canvas canvas)
    {
//        //draws the sky
//        canvas.drawRect(0, 0, getWidth(), getHeight(), skyPaint);
//        //draws the ground
//        canvas.drawRect(0, getHeight()/2, getWidth(), getHeight(), groundPaint);
//        //draws house wall
//        canvas.drawRect((2 * getWidth())/7, getHeight()/3,
//                        (5 * getWidth())/7,(2 * getHeight())/3, housePaint);
//        //draws house's roof
//        canvas.drawRect((3 * getWidth())/14, getHeight()/4,
//                        (11 * getWidth())/14,getHeight()/3, roofPaint);
//        //draws door
//        canvas.drawRect((3 * getWidth())/7, getHeight()/2,
//                        (4 * getWidth())/7,(2 * getHeight())/3, doorPaint);
//        //draws sun in top left corner
//        canvas.drawCircle(0, 0, 200, sunPaint);

        skyR.drawMe(canvas);
        groundR.drawMe(canvas);
        houseR.drawMe(canvas);
        roofR.drawMe(canvas);
        chimneyR.drawMe(canvas);
        doorR.drawMe(canvas);

        Log.d("onDraw","Drawn");

    }

}
