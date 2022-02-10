package com.example.customcoloring;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class PictureController implements SeekBar.OnSeekBarChangeListener,
                                            View.OnTouchListener {

    private PictureView pictureView;
    private TextView redView;
    private TextView greenView;
    private TextView blueView;
    private TextView elementView;
    private SeekBar redBar;
    private SeekBar greenBar;
    private SeekBar blueBar;

    private RectangleObject activeObj;


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

    public void onProgressChanged(SeekBar viewSlider, int progress, boolean fromUser)
    {
        if (viewSlider.getId() == R.id.redSeekBar) {
            Log.d("RedCount", "Changed to " + progress);
            activeObj.setColor(progress, activeObj.getG(), activeObj.getB());
            this.redView.setText("" + progress);
        } else if (viewSlider.getId() == R.id.greenSeekBar) {
            Log.d("GreenCount", "Changed to " + progress);
            activeObj.setColor(activeObj.getR(), progress, activeObj.getB());
            this.greenView.setText("" + progress);
        } else if (viewSlider.getId() == R.id.blueSeekBar) {
            Log.d("BlueCount", "Changed to " + progress);
            activeObj.setColor(activeObj.getR(), activeObj.getG(), progress);
            this.blueView.setText("" + progress);
        }

        pictureView.invalidate();

    }

    public void setActiveObject(RectangleObject rect)
    {
        this.activeObj = rect;
        this.elementView.setText(rect.getName());

        this.redView.setText("" + rect.getR());
        this.greenView.setText("" + rect.getG());
        this.blueView.setText("" + rect.getB());

        redBar.setProgress(rect.getR());
        greenBar.setProgress(rect.getG());
        blueBar.setProgress(rect.getB());

        pictureView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();

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
