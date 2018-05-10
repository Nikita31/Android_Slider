package com.example.itrs.slider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;

import android.view.MotionEvent;

import android.widget.AdapterViewFlipper;
import android.widget.Button;

/**
 * Created by itrs on 4/11/2018.
 */

public class MainActivity extends AppCompatActivity {
    private GestureDetector mGestureDetector;
    int[] testImages = {R.drawable.img1, R.drawable.img33, R.drawable.img21, R.drawable.img43};     // array of images
    String offertitle[] = {"test_1", "test_2", "test_3", "test_4" };    // array of strings
    String OfferDes[] = {"10% OFF", "2% OFF", "30% OFF", "40% OFF"};    // array of strings
    int Price[] = {100,200,300,400};    // array of strings
    static  AdapterViewFlipper adapterViewFlipper;
    Adapter adapter;
    private Button right;
    private Button left;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.adapterflipper);
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.adapterViewFlipper);
        adapter = new Adapter(getApplicationContext(), offertitle, OfferDes, testImages, Price, adapterViewFlipper);
        adapterViewFlipper.setAdapter(adapter);
        adapterViewFlipper.setFlipInterval(5000);
        adapterViewFlipper.setAutoStart(true);



        CustomGestureDetector detector = new CustomGestureDetector();
        mGestureDetector = new GestureDetector(this, detector);
    }

    class CustomGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (e1.getX() > e2.getX()) {

                adapterViewFlipper.showNext();
            }

            if (e1.getX() < e2.getX()) {
                adapterViewFlipper.showPrevious();
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);


    }

    }
