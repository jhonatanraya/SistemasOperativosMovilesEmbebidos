package com.jhonatanraya.reciclerview.Adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.jhonatanraya.reciclerview.R;
import com.jhonatanraya.reciclerview.MainActivity;

import java.io.IOException;

public class Playlist extends AppCompatActivity {



    MediaPlayer mediaPlayer;
    String music_url = "http://sampleswap.org/mp3/artist/46669/joevirus_Out-post-aiff-160.mp3";

    ImageView playi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);


        playi = findViewById(R.id.playi);
        playi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    playi.setImageResource(R.drawable.ic_pause_black_24dp);
                }
                else {
                    mediaPlayer.pause();
                    playi.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                }
            }
        });




        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(music_url);
            mediaPlayer.prepareAsync();

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    Toast.makeText(Playlist.this, "Media ", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
