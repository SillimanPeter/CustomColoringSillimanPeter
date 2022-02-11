package com.example.customcoloring;

import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

/**
 * MainActivity sets up all Listeners for the MVC
 *
 * @author Peter Silliman
 * @version Feb 2022
 */
public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets up AppCompatActivity
        super.onCreate(savedInstanceState);
        //sets application orientation to portrait mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        PictureView pictureView = findViewById(R.id.pictureView);
        //sets up controller class with all the views
        PictureController pictureController = new PictureController(pictureView,
                                                    findViewById(R.id.redValueTextView),
                                                    findViewById(R.id.greenValueTextView),
                                                    findViewById(R.id.blueValueTextView),
                                                    findViewById(R.id.elementTextView),
                                                    findViewById(R.id.redSeekBar),
                                                    findViewById(R.id.greenSeekBar),
                                                    findViewById(R.id.blueSeekBar));
        //sets up the RGB seekBars with a Listener to the controller class
        SeekBar redSlider = findViewById(R.id.redSeekBar);
        redSlider.setOnSeekBarChangeListener(pictureController);
        SeekBar greenSlider = findViewById(R.id.greenSeekBar);
        greenSlider.setOnSeekBarChangeListener(pictureController);
        SeekBar blueSlider = findViewById(R.id.blueSeekBar);
        blueSlider.setOnSeekBarChangeListener(pictureController);
        //sets up onTouchListener for object selection to controller
        PictureView drawView = findViewById(R.id.pictureView);
        drawView.setOnTouchListener(pictureController);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) { return true; }
}
