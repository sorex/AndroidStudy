package com.jasperxu.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.jasperxu.app.study.AddViewByCodeActivity;

/**
 * Created by Jasper on 2014/4/28.
 */
public class StudyMainActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_main);
    }

    public void GoBackHandler(View view)
    {
        Intent intent = new Intent();
        intent.setClass(StudyMainActivity.this, MainActivity.class);
        startActivity(intent);
        //如果不关闭当前的会出现好多个页面
        StudyMainActivity.this.finish();
    }

    public void CloseHandler(View view)
    {
        finish();
    }

    public void AddViewByCodeHandler(View view)
    {
        Intent intent = new Intent();
        intent.setClass(StudyMainActivity.this, AddViewByCodeActivity.class);
        startActivity(intent);
        //如果不关闭当前的会出现好多个页面
        StudyMainActivity.this.finish();
    }
}