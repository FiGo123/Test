package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.Preference;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AppUpdater appUpdater = new AppUpdater(this)
             //   .showEvery(5)
             //   .setUpdateFrom(UpdateFrom.GITHUB)
              //  .setGitHubUserAndRepo()
               // .start();

    }
}