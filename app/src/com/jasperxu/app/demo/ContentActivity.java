package com.jasperxu.app.demo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.jasperxu.app.R;

/**
 * Created by Jasper on 2014/5/12.
 */
public class ContentActivity extends Activity
        implements GestureDetector.OnGestureListener {

    GestureDetector detector;
    final int FLIP_DISTANCE = 50;

    int Index;
    String BookGuid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_content);

        //得到传过来的Intent对象
        Intent intent = getIntent();
        Index = intent.getIntExtra("Index", 1);
        BookGuid = intent.getStringExtra("BookGuid");

        TextView IndexView =(TextView)this.findViewById(R.id.IndexView);
        IndexView.setText(String.valueOf(Index));
        TextView BookGuidView =(TextView)this.findViewById(R.id.BookGuidView);
        BookGuidView.setText(BookGuid);

        detector = new GestureDetector(this, this);
    }

    public void GoBackHandler(View view) {
        startActivity(new Intent(this, DirectoryActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        ScrollView scroll = (ScrollView)this.findViewById(R.id.scroll);

        detector.onTouchEvent(ev);
        scroll.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);

    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return detector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        Toast.makeText(this, "onDown", Toast.LENGTH_SHORT).show();
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
            Intent intent = new Intent(this, ContentActivity.class);
            intent.putExtra("Index", Index + 1);
            intent.putExtra("BookGuid", BookGuid);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
            return true;
        } else if (motionEvent2.getX() - motionEvent.getX() > FLIP_DISTANCE) {
            Intent intent = new Intent(this, ContentActivity.class);
            intent.putExtra("Index", Index - 1);
            intent.putExtra("BookGuid", BookGuid);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
            return true;
        }
        return false;
    }
}