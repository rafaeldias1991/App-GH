package com.example.ghcentrodetreinamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.WindowManager;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);
        videoview = (VideoView)findViewById(R.id.videoView);
        Uri video = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ghintro);
        videoview.setVideoURI(video);

        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(MainActivity.this,Login.class);
                startActivity(i);

                finish();

            }
        });
        videoview.start();
    }





}