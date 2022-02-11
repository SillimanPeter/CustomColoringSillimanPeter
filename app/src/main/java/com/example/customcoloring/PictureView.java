package com.example.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

/**
 * PictureView is the View of MVC, containing onDraw method for rect objects
 *
 * @author Peter Silliman
 * @version Feb 2022
 */
public class PictureView extends SurfaceView
{

    /** These are the rectangle objects used to draw the picture */
    RectangleObject skyR;
    RectangleObject groundR;
    RectangleObject houseR;
    RectangleObject roofR;
    RectangleObject chimneyR;
    RectangleObject doorR;

    /** These are constants that relate to the total size of the SurfaceView */
    final int width = 1536;     //needs variables that correspond to the size of the SurfaceView
    final int height = 1566;    //needs variables that correspond to the size of the SurfaceView

    /** sets up the rectangle objects for each part of the picture in the SurfaceView */
    public PictureView(Context context, AttributeSet attrs){
        super(context, attrs);

        //this is essential to onDraw method
        setWillNotDraw(false);

        //Creates the sky as a rectangle object and gives it a name, title and size
        skyR = new RectangleObject("sky", Color.BLUE,
                0, 0,
                width, height);

        //Creates the ground as a rectangle object and gives it a name, title and size
        groundR = new RectangleObject("ground", Color.GREEN,
                0, height/2,
                width, height);

        //Creates the house as a rectangle object and gives it a name, title and size
        houseR = new RectangleObject("house", Color.YELLOW,
                (2 * width)/7, height/3,
                (5 * width)/7,(2 * height)/3);

        //Creates the roof as a rectangle object and gives it a name, title and size
        roofR = new RectangleObject("roof", Color.DKGRAY,
                (3 * width)/14, height/4,
                (11 * width)/14,height/3);

        //Creates the chimney as a rectangle object and gives it a name, title and size
        chimneyR = new RectangleObject("chimney", Color.RED,
                (3 * width)/9, height/7,
                (3 * width)/7, height/4);

        //Creates the door as a rectangle object and gives it a name, title and size
        doorR = new RectangleObject("door", Color.LTGRAY,
                (3 * width)/7, height/2,
                (4 * width)/7,(2 * height)/3);
    }

    /** This method will draw in surfaceView by calling each rectangle objects draw method */
    @Override
    public void onDraw(Canvas canvas)
    {
        skyR.drawMe(canvas);
        groundR.drawMe(canvas);
        houseR.drawMe(canvas);
        roofR.drawMe(canvas);
        chimneyR.drawMe(canvas);
        doorR.drawMe(canvas);

        Log.d("onDraw","Drawn");
    }

}
