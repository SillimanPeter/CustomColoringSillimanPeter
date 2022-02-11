package com.example.customcoloring;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * PictureController uses Listeners to set and change values of each TextViews/SeekBars
 *
 * @author Peter Silliman
 * @version Feb 2022
 */
public class PictureController implements SeekBar.OnSeekBarChangeListener,
                                            View.OnTouchListener {

    /**
     * These creates local View, Seekbar and Rectangle objects
     * so we can pass in the objects to get and set their texts and values
     */
    private PictureView pictureView;
    private TextView redView;
    private TextView greenView;
    private TextView blueView;
    private TextView elementView;
    private SeekBar redBar;
    private SeekBar greenBar;
    private SeekBar blueBar;
    private RectangleObject activeObj;

    /** sets local object equal to the passed in objects */
    PictureController(PictureView view, TextView rView,
                      TextView gView, TextView bView, TextView eView,
                      SeekBar rBar, SeekBar gBar, SeekBar bBar)
    {
        pictureView = view;
        redView = rView;
        greenView = gView;
        blueView = bView;
        elementView = eView;
        redBar = rBar;
        greenBar = gBar;
        blueBar = bBar;
    }

    /** sets the color of the ActiveObject and the RGB TextViews to match the RGB Seekbar progress */
    public void onProgressChanged(SeekBar viewSlider, int progress, boolean fromUser)
    {
    //check witch SeekBar is changing and set the respective textview and rectangles RGB to progress
        if (viewSlider.getId() == R.id.redSeekBar) {
            Log.d("RedCount", "Changed to " + progress);
            this.activeObj.setColor(progress, activeObj.getG(), activeObj.getB());
            this.redView.setText("" + progress);
        } else if (viewSlider.getId() == R.id.greenSeekBar) {
            Log.d("GreenCount", "Changed to " + progress);
            this.activeObj.setColor(activeObj.getR(), progress, activeObj.getB());
            this.greenView.setText("" + progress);
        } else if (viewSlider.getId() == R.id.blueSeekBar) {
            Log.d("BlueCount", "Changed to " + progress);
            this.activeObj.setColor(activeObj.getR(), activeObj.getG(), progress);
            this.blueView.setText("" + progress);
        }

        //is necessary to redraw the PictureView with the new Rectangle Object colors
        pictureView.invalidate();

    }

    /** sets TextViews and SeekBars to the object's values */
    public void setActiveObject(RectangleObject rect)
    {
        //sets up local rectangle object for onProgressChanged
        this.activeObj = rect;

        //sets TextViews to display color values and name of the selected object
        this.elementView.setText(rect.getName());
        this.redView.setText("" + rect.getR());
        this.greenView.setText("" + rect.getG());
        this.blueView.setText("" + rect.getB());

        //sets SeekBars' progress to object's color values
        this.redBar.setProgress(rect.getR());
        this.greenBar.setProgress(rect.getG());
        this.blueBar.setProgress(rect.getB());
    }

    //method is needed for implemented OnTouchListener
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }
    //method is needed for implemented OnTouchListener
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }

    /** uses OnTouchListener to find which object is being selected and edited */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();

        /**
         * finds which rectObj is being clicked (checks in opposite order they are drawn to avoid
         * calling more than one objects because they overlap)
         * calls setActiveObject() to set TextViews and Seekbars to the object's values
         */
        if(pictureView.doorR.containsPoint(x, y)) {
            Log.d("onTouch","touchedDoor");
            setActiveObject(pictureView.doorR);
        } else if(pictureView.chimneyR.containsPoint(x, y)) {
            Log.d("onTouch","touchedChimney");
            setActiveObject(pictureView.chimneyR);
        } else if(pictureView.roofR.containsPoint(x, y)) {
            Log.d("onTouch","touchedRoof");
            setActiveObject(pictureView.roofR);
        } else if(pictureView.houseR.containsPoint(x, y)) {
            Log.d("onTouch","touchedHouse");
            setActiveObject(pictureView.houseR);
        } else if(pictureView.groundR.containsPoint(x, y)) {
            Log.d("onTouch","touchedGround");
            setActiveObject(pictureView.groundR);
        } else if(pictureView.skyR.containsPoint(x, y)) {
            Log.d("onTouch","touchedSky");
            setActiveObject(pictureView.skyR);
        }

        return true;
    }
}
