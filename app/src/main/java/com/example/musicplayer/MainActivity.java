package com.example.musicplayer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mp=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(MainActivity.this, R.raw.masih);


        Button play = findViewById(R.id.playbtn);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mp.isPlaying())
                    mp.pause();
                else
                    mp.start();

            }
        });


        Button choosebtn = findViewById(R.id.choosefile);
        choosebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("audio/*");
                startActivityForResult(intent,10);



            }
        });

        Button stop = findViewById(R.id.stopmusic);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mp !=null);
                mp.stop();

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode==10 && resultCode==RESULT_OK){

            mp = MediaPlayer.create(MainActivity.this,data.getData());
            mp.start();

        }
    }
}