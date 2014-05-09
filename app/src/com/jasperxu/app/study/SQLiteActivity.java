package com.jasperxu.app.study;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import com.jasperxu.app.R;
import com.jasperxu.app.StudyMainActivity;

import java.util.ArrayList;

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
        String TABLE_NAME = "users";
        ArrayList<String> FIELD_NAMES = new ArrayList<String>();
        ArrayList<String> FIELD_TYPES = new ArrayList<String>();

        FIELD_NAMES.add("ID");
        FIELD_TYPES.add("VARCHAR");

        FIELD_NAMES.add("UserName");
        FIELD_TYPES.add("VARCHAR");

        FIELD_NAMES.add("LoginName");
        FIELD_TYPES.add("VARCHAR");

        FIELD_NAMES.add("LoginPassword");
        FIELD_TYPES.add("VARCHAR");

        // /data/data/com.study/databases/test
        db = SQLiteDatabase.openOrCreateDatabase(this.getDatabasePath("test") + "/test.db", null);

        String CreateSQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (";

        for (int i = 0; i < FIELD_NAMES.size(); i++) {
            CreateSQL += FIELD_NAMES.get(i) + " " + FIELD_TYPES.get(i);
            if (i == 0) CreateSQL += " PRIMARY KEY";
            if (i < FIELD_NAMES.size() - 1) CreateSQL += ", ";
        }
        CreateSQL += ")";

        String InsertSQL = "INSERT INTO "+ TABLE_NAME +"(";

        db.execSQL(CreateSQL);
        Log.e("Database", "onCreate");

        db.execSQL();

    }
}