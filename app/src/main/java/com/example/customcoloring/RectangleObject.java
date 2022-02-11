package com.example.customcoloring;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

/**
 * RectangleObject creates/edits/draws rectangle objects and acts as the model
 *
 * @author Peter Silliman
 * @version Feb 2022
 *
 * This class is a modified combination of CustomElement and CustomRect classes by...
 *
 * @author Andrew Nuxoll
 * @version Spring 2015
 *
 */
public class RectangleObject {

    /** the position and size of the rectangle is stored here */
    protected Rect myRect;

    /** This defines the main color that the rectangle will be drawn with */
    protected Paint myPaint = new Paint();

    /**
     * This gives the element a name for identification. This need not be unique
     * but it's helpful
     */
    protected String myName = "Element has no name";

    /** instantiates this Rectangle Object with name, color and size */
    public RectangleObject(String name, int color, int left, int top, int right, int bottom)
    {
        this.myName = name;
        this.myRect = new Rect(left, top, right, bottom);
        this.myPaint.setColor(color);
        this.myPaint.setStyle(Paint.Style.FILL); //the paint style will be Fill for all objects
    }

    /** draws the rectangle object */
    public void drawMe(Canvas canvas){
        canvas.drawRect(myRect.left, myRect.top,
                myRect.right, myRect.bottom, myPaint);
        Log.d("DrawME","Called");
    }

    /** checks if OnTouched has touched a point inside this rectangle object */
    public boolean containsPoint(int x, int y){
        int left = this.myRect.left;
        int top = this.myRect.top;
        int right = this.myRect.right;
        int bottom = this.myRect.bottom;
        Rect r = new Rect(left, top, right, bottom);

        return r.contains(x, y);
    }//containsPoint

    /** set Color of this rectangle object */
    public void setColor(int red, int green, int blue){
        Paint p = new Paint();
        p.setARGB(255, red, green, blue);
        // ignore request if it's not a new color (this keeps the undo queue clean)
        if(p.getColor() == myPaint.getColor())
            return;
        // make the change
        this.myPaint.setARGB(255, red, green, blue);
    }

    /** get the rectangle's given name */
    public String getName(){ return this.myName; }

    /** get the rectangle's red value */
    public int getR(){ return Color.red(myPaint.getColor()); }

    /** get the rectangle's green value */
    public int getG(){ return Color.green(myPaint.getColor()); }

    /** get the rectangle's blue value */
    public int getB(){ return Color.blue(myPaint.getColor()); }

}
