package com.jasperxu.app.study;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.jasperxu.app.R;
import com.jasperxu.app.StudyMainActivity;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Created by Jasper on 2014/5/6.
 */
public class JsonParseActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_json_parse);
    }

    public void GoBackHandler(View view) {
        startActivity(new Intent(this, StudyMainActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }

    public void RunHandler(View view) {
        try {
            JSONObject obj = new JSONObject("{" +
                    "\"employees\": [\n" +
                    "{ \"firstName\":\"Bill\" , \"lastName\":\"Gates\" }," +
                    "{ \"firstName\":\"George\" , \"lastName\":\"Bush\" }," +
                    "{ \"firstName\":\"Thomas\" , \"lastName\":\"Carter\" }" +
                    "]}");

            new AlertDialog.Builder(JsonParseActivity.this)
                    .setTitle("提示标题")
                    .setMessage("值：" + obj.getJSONArray("employees").getJSONObject(0).getString("firstName"))
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    })
                    .show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}