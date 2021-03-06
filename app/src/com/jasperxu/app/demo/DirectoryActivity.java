package com.jasperxu.app.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jasperxu.app.R;

/**
 * Created by Jasper on 2014/5/12.
 */
public class DirectoryActivity extends Activity {

    String BookGuid;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_directory);

        //得到传过来的Intent对象
        Intent intent = getIntent();
        BookGuid = intent.getStringExtra("BookGuid");

        TextView BookGuidView =(TextView)this.findViewById(R.id.BookGuidView);
        BookGuidView.setText(BookGuid);

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        for (int i = 0; i < 50; i++) {
            final int final_i = i;
            TextView tv = new TextView(this);
            tv.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));//设置TextView的布局
            //tv1.setPadding(50, 100, 0, 0);//设置边距
            tv.setText(String.format("第%1$ 4d页", i + 1));
            tv.setAutoLinkMask(Linkify.ALL);
            tv.setTextSize(20);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), ContentActivity.class);
                    intent.putExtra("BookGuid", BookGuid);
                    intent.putExtra("Index", final_i + 1);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                }
            });
            layout.addView(tv);//将TextView 添加到子View 中
        }
    }

    public void GoBackHandler(View view) {
        Intent intent = new Intent(this, DirectoryActivity.class);
        intent.putExtra("BookGuid", BookGuid);
        startActivity(new Intent(this, DirectoryActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}