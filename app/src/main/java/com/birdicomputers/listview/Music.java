package com.birdicomputers.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class Music extends AppCompatActivity {
    Button playFirst;
    Button playSecond;
    MediaPlayer pop, jazz;
    int playing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        playFirst = findViewById(R.id.button3);
        playSecond = findViewById(R.id.button5);
        pop = new MediaPlayer();
        pop = MediaPlayer.create(Music.this, R.raw.ukulele);
        jazz = new MediaPlayer();
        jazz = MediaPlayer.create(Music.this, R.raw.drums);
        playing = 0;

        playFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (playing) {
                    case 0:
                        pop.start();
                        playing = 1;
                        playFirst.setText("Pause pop song.");
                        playSecond.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        pop.pause();
                        playing = 0;
                        playFirst.setText("Play pop song.");
                        playSecond.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        playSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (playing) {
                    case 0:
                        jazz.start();
                        playing = 1;
                        playSecond.setText("Pause jazz song.");
                        playFirst.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        jazz.pause();
                        playing = 0;
                        playSecond.setText("Play jazz song.");
                        playFirst.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });








    }
}
