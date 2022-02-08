package com.example.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class PictureView extends SurfaceView
{
    //paints used to draw the picture
    Paint skyPaint = new Paint();
    Paint backDropPaint = new Paint();
    Paint wallPaint = new Paint();
    Paint roofPaint = new Paint();
    Paint houseTrimPaint = new Paint();
    Paint doorPaint = new Paint();

    private PictureModel pModel;

    public PictureView(Context context, AttributeSet attrs){
        super(context, attrs);

        //this is essential to onDraw method
        setWillNotDraw(false);

        //Setup color palette
        skyPaint.setColor(Color.BLUE);
        skyPaint.setStyle(Paint.Style.FILL);
        backDropPaint.setColor(Color.GREEN);
        backDropPaint.setStyle(Paint.Style.FILL);
        wallPaint.setColor(Color.CYAN);
        wallPaint.setStyle(Paint.Style.FILL);
        roofPaint.setColor(Color.DKGRAY);
        roofPaint.setStyle(Paint.Style.FILL);
        houseTrimPaint.setColor(Color.WHITE);
        houseTrimPaint.setStyle(Paint.Style.FILL);
        doorPaint.setColor(Color.YELLOW);
        doorPaint.setStyle(Paint.Style.FILL);

        setBackgroundColor(Color.GRAY);

        pModel = new PictureModel();

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

    }

    public PictureModel getPictureModel(){ return this.pModel; }

}
