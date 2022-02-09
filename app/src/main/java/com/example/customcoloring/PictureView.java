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
    Paint groundPaint = new Paint();
    Paint housePaint = new Paint();
    Paint roofPaint = new Paint();
    Paint sunPaint = new Paint();
    Paint doorPaint = new Paint();

    private PictureModel pictureModel;

    public PictureView(Context context, AttributeSet attrs){
        super(context, attrs);

        //this is essential to onDraw method
        setWillNotDraw(false);

        //Setup color palette
        skyPaint.setColor(Color.BLUE);
        skyPaint.setStyle(Paint.Style.FILL);
        groundPaint.setColor(Color.GREEN);
        groundPaint.setStyle(Paint.Style.FILL);
        housePaint.setColor(Color.CYAN);
        housePaint.setStyle(Paint.Style.FILL);
        roofPaint.setColor(Color.DKGRAY);
        roofPaint.setStyle(Paint.Style.FILL);
        sunPaint.setColor(Color.YELLOW);
        sunPaint.setStyle(Paint.Style.FILL);
        doorPaint.setColor(Color.WHITE);
        doorPaint.setStyle(Paint.Style.FILL);

        setBackgroundColor(Color.WHITE);

        pictureModel = new PictureModel();

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
        canvas.drawRect(0, 0, getWidth(), getHeight(), skyPaint);
        canvas.drawRect(0, getHeight()/2, getWidth(), getHeight(), groundPaint);
    }

    public PictureModel getPictureModel(){ return this.pictureModel; }

}
