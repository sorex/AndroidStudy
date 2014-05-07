package com.jasperxu.app.study;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import com.jasperxu.app.R;
import com.jasperxu.app.StudyMainActivity;

/**
 * Created by Jasper on 2014/5/7.
 */
public class SQLiteActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_sqlite);
    }

    public void GoBackHandler(View view) {
        startActivity(new Intent(this, StudyMainActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }

    SQLiteDatabase db;



    public void RunHandler(View view) {
        // /data/data/com.study/databases/temp
        //db = SQLiteDatabase.openOrCreateDatabase(this.getDatabasePath("data")+"/test.db", null);

        new AlertDialog.Builder(SQLiteActivity.this)
                .setTitle("提示标题")
                .setMessage("this.getDatabasePath(\"data\")：" + this.getDatabasePath("data") +
                        "\nthis.getCacheDir()："+this.getCacheDir()+
                        "\nthis.getFilesDir()："+this.getFilesDir()+
                        "\nEnvironment.getExternalStorageDirectory()："+ Environment.getExternalStorageDirectory())
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }
}