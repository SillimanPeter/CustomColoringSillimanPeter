package com.example.customcoloring;

import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        PictureView pictureView = findViewById(R.id.surfaceView);
        PictureController pictureController = new PictureController(pictureView);

        SeekBar seekBarSlider = findViewById(R.id.redSeekBar);
        seekBarSlider.setOnSeekBarChangeListener(pictureController);

    }
}