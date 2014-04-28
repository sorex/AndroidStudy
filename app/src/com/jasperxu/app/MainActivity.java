package com.jasperxu.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }


    public void GoToStudyHandler(View view)
    {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, StudyMainActivity.class);
        startActivity(intent);
        //如果不关闭当前的会出现好多个页面
        MainActivity.this.finish();
    }

    public void CloseHandler(View view)
    {
        finish();
    }
}
