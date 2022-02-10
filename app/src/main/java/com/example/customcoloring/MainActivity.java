package com.example.customcoloring;

import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        PictureView pictureView = findViewById(R.id.pictureView);
        PictureController pictureController = new PictureController(pictureView,
                                                    findViewById(R.id.redValueTextView),
                                                    findViewById(R.id.greenValueTextView),
                                                    findViewById(R.id.blueValueTextView),
                                                    findViewById(R.id.elementTextView),
                                                    findViewById(R.id.redSeekBar),
                                                    findViewById(R.id.greenSeekBar),
                                                    findViewById(R.id.blueSeekBar));

        SeekBar redSlider = findViewById(R.id.redSeekBar);
        redSlider.setOnSeekBarChangeListener(pictureController);

        SeekBar greenSlider = findViewById(R.id.greenSeekBar);
        greenSlider.setOnSeekBarChangeListener(pictureController);

        SeekBar blueSlider = findViewById(R.id.blueSeekBar);
        blueSlider.setOnSeekBarChangeListener(pictureController);

        PictureView drawView = findViewById(R.id.pictureView);
        drawView.setOnTouchListener(pictureController);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) { return true; }
}
