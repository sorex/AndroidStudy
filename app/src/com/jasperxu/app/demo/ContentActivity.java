package com.jasperxu.app.demo;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import com.jasperxu.app.R;

import java.net.URL;

/**
 * Created by Jasper on 2014/5/12.
 */
public class ContentActivity extends Activity
        implements GestureDetector.OnGestureListener {

    ViewFlipper flipper;
    GestureDetector detector;
    Animation[] animations = new Animation[4];
    final int FLIP_DISTANCE = 50;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_content);

        detector = new GestureDetector(this, this);
        flipper = (ViewFlipper) this.findViewById(R.id.flipper);
        flipper.addView(addImageView("guid1"));
        flipper.addView(addImageView("guid1"));
        flipper.addView(addImageView("guid1"));
        flipper.addView(addImageView("guid1"));

        animations[0] = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        animations[1] = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);
        animations[2] = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        animations[3] = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);


    }

    private View addImageView(String GUID) {
        ImageView imageView = new ImageView(this);
        imageView.setImageURI(Uri.parse(GUID));
        return imageView;
    }

    public void GoBackHandler(View view) {
        startActivity(new Intent(this, DirectoryActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        return detector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        if (motionEvent.getX() - motionEvent2.getX() > FLIP_DISTANCE) {
            flipper.setInAnimation(animations[0]);
            flipper.setOutAnimation(animations[1]);
            flipper.showPrevious();
            return true;
        } else if (motionEvent2.getX() - motionEvent.getX() > FLIP_DISTANCE) {
            flipper.setInAnimation(animations[2]);
            flipper.setOutAnimation(animations[3]);
            flipper.showNext();
            return true;
        }
        return false;
    }
}