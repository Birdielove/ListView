package com.birdicomputers.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MediaPlayer currentSong = new MediaPlayer();
    List<String> songNameList = new ArrayList<String>();
    List<Integer> songPicList = new ArrayList<Integer>();
    List<Integer> songList = new ArrayList<Integer>();
    EditText text1;
    EditText text2;

    public void addData(){
        songList.add(R.raw.ukulele); songList.add(R.raw.bagpipes); songList.add (R.raw.drums);
        songNameList.add("Ukulele"); songNameList.add("Bagpipes"); songNameList.add("Drums");
        songPicList.add(R.drawable.ukulele); songPicList.add(R.drawable.bagpipes); songPicList.add(R.drawable.drums);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.editText);
        text2 = findViewById(R.id.editText2);
        addData();
        final MyCustomAdapter adapterObject = new MyCustomAdapter(songNameList, songPicList);
        ListView mainList = findViewById(R.id.mainList);
        mainList.setAdapter(adapterObject);
        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(adapterObject.getCurrentPlayId() == position){
                        if (currentSong != null && currentSong.isPlaying()){
                            currentSong.pause();
                            adapterObject.setPlaystatus(false);
                        } else if (currentSong != null && !currentSong.isPlaying()){
                            currentSong.start(); //resume playing
                            adapterObject.setPlaystatus(true);
                        }
                    } else {
                        // First stop current song, if playing
                        if (currentSong!=null && currentSong.isPlaying()){
                            currentSong.stop();
                            //need to prepare if restarting the same media player object
                        }
                        //already prepared
                        currentSong = MediaPlayer.create(MainActivity.this, songList.get(position));
                        currentSong.start();
                        adapterObject.setCurrentPlayId(position);
                        adapterObject.setPlaystatus(true);
                }
            }
        });


        Button spinner = findViewById(R.id.button);
        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spin = new Intent(MainActivity.this, Spinner.class);
                Bundle bundle = new Bundle();
                String intentVal1 = text1.getText().toString();
                String intentVal2 = text2.getText().toString();
                bundle.putString("First", intentVal1);
                bundle.putString("Second", intentVal2);
                spin.putExtras(bundle);
                startActivity(spin);
            }
        });

        currentSong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                finish();
            }
        });
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.themagnificentmile.com/")));
            }
        });
        Button btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent music = new Intent(MainActivity.this, Music.class);
                startActivity(music);
            }
        });

        TextView myWebSite = findViewById(R.id.textView4);
        myWebSite.setText("http://http://www.dzone.com/");
        Linkify.addLinks(myWebSite , Linkify.WEB_URLS);

        Toast toast=Toast. makeText(getApplicationContext(),"Hello",Toast. LENGTH_SHORT);
        toast.show();
    }
}
