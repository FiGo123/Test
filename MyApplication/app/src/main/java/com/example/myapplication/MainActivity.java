package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.util.Log;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.AppUpdaterUtils;
import com.github.javiersantos.appupdater.enums.AppUpdaterError;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;
import com.github.javiersantos.appupdater.objects.Update;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    DownloadManager downloadManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        run();



    }
    public void update(){



    }
    public void run(){
        System.out.println("svanulo je");

        AppUpdaterUtils appUpdaterUtils = new AppUpdaterUtils(this)

                 .setUpdateFrom(UpdateFrom.XML)
                .setUpdateXML("https://raw.githubusercontent.com/FiGo123/Test/master/MyApplication/update-changelog.xml")

                .withListener(new AppUpdaterUtils.UpdateListener() {

                    @Override
                    public void onSuccess(Update update, Boolean isUpdateAvailable) {
                        //https://apkpure.com/helloworld/my.v1rtyoz.helloworld/download?from=details

                        downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                        Uri uri = Uri.parse("https://github.com/amirzaidi/Launcher3/releases/download/Pixel-v2.1/Launcher3-aosp-debug.apk");
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        Long reference = downloadManager.enqueue(request);
                        Log.d("Latest Version", update.getLatestVersion());
                        Log.d("Latest Version Code", String.valueOf(update.getLatestVersionCode()));
                        Log.d("Release notes", update.getReleaseNotes());
                        Log.d("URL", String.valueOf(update.getUrlToDownload()));
                        Log.d("Is update available?", Boolean.toString(isUpdateAvailable));
                        installNewApk();
                    }

                    @Override
                    public void onFailed(AppUpdaterError error) {

                    }

    });
        appUpdaterUtils.start();
    };
    public static void installNewApk()
    {System.out.println("install");
        try
        {   System.out.println("root");
            Runtime.getRuntime().exec(new String[] {"su", "-c", "pm install -r /mnt/internal/Download/Launcher3-aosp-debug.apk.apk"});
        }
        catch (IOException e)
        {
            System.out.println(e.toString());
            System.out.println("no root");
        }
    }



}