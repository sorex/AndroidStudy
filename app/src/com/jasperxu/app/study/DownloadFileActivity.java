package com.jasperxu.app.study;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import com.jasperxu.app.R;
import com.jasperxu.app.StudyMainActivity;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Jasper on 2014/4/30.
 */
public class DownloadFileActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_download_file);
    }

    public void GoBackHandler(View view) {
        startActivity(new Intent(this, StudyMainActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }

    public void RunHandler(View view) {
        String downloadUrl = "http://m.baidu.com/static/index/logo_index2.png";
        String saveDir = "com.jasperxu.app/";
        String saveFileName = "logo_index2.png";

//      获取外置sd卡路径，并加上目录，目录要以/结尾
        String savePath = Environment.getExternalStorageDirectory() + "/" + saveDir;

        URL url;
        HttpURLConnection urlConn = null;
        InputStream input = null;

        try {
            url = new URL(downloadUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            input = urlConn.getInputStream();
        } catch (MalformedURLException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = null;
        OutputStream output = null;
        try {
//          创建目录
            File dir = new File(savePath);
            dir.mkdir();

//          创建文件
            file = new File(savePath + saveFileName);
            if(file.exists())
                file.delete();
            file.createNewFile();

            output = new FileOutputStream(file);
            int FILESIZE = 4 * 1024;
            byte[] buffer = new byte[FILESIZE];

            /*
            真机测试，这段可能有问题，请采用下面网友提供的
            while((input.read(buffer)) != -1){
                output.write(buffer);
            }
            */

            /* 网友提供 begin */
            int length;
            while ((length = (input.read(buffer))) > 0) {
                output.write(buffer, 0, length);
            }
            /* 网友提供 end */

            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}