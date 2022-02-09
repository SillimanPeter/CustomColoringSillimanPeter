package com.example.customcoloring;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class PictureController implements SeekBar.OnSeekBarChangeListener {

    private PictureView pictureView;
    private PictureModel pictureModel;

    PictureController(PictureView view)
    {
        pictureView = view;
        pictureModel = view.getPictureModel();
    }

    public void onProgressChanged(SeekBar viewSlider, int progress, boolean fromUser)
    {
        if (viewSlider.getId() == R.id.redSeekBar) {
            Log.d("RedCount", "Changed to " + progress);
            pictureModel.redCount(progress);
            //Button rView = findViewById(R.id.redTextView);
            //rView.setText(progress + " Red");
        } else if (viewSlider.getId() == R.id.greenSeekBar) {
            Log.d("GreenCount", "Changed to " + progress);
            pictureModel.greenCount(progress);
        } else if (viewSlider.getId() == R.id.blueSeekBar) {
            Log.d("BlueCount", "Changed to " + progress);
            pictureModel.blueCount(progress);
        }

        pictureView.invalidate();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }

}
