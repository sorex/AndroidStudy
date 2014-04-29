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
//        //写法一，创建Intent
//        Intent intent = new Intent();
//        intent.setClass(StudyMainActivity.this, AddViewByCodeActivity.class);
//        startActivity(intent);

        //写法二，直接调用startActivity
        startActivity(new Intent(this, AddViewByCodeActivity.class));


        overridePendingTransition(R.anim.move_in_left, R.anim.move_out_left);


        //如果不关闭当前的会出现好多个页面
        finish();


//        Intent intent = new Intent();
//        intent.setClass(Bmi.this, Report.class);
//        Bundle bundle = new Bundle();   //bundle带参数跳转
//        bundle.putString("KEY_HEIGHT",field_height.getText().toString());
//        bundle.putString("KEY_WEIGHT",field_weight.getText().toString());
//        intent.putExtras(bundle);
//        startActivity(intent);
    }
}