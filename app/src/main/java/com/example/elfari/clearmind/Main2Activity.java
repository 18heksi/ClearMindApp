package com.example.elfari.clearmind;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private Button btnPlay;
    private Button btnPause;
    private Button btnEffect;
    private Button btnTimer;
    private MediaPlayer mp, ef;
    private AudioManager am;
    private SeekBar sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        mp = new MediaPlayer();
        ef = new MediaPlayer();

        String judul = i.getStringExtra("pilihan");
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(judul);

        /*int gambar = i.getIntExtra("gambar", 1);
        ImageView img = (ImageView) findViewById(R.id.img);
        img.setImageResource(gambar);*/

        int song = i.getIntExtra("lagu", 0);
        mp = MediaPlayer.create(this,song);

        int effect = i.getIntExtra("seffect", 0);
        ef = MediaPlayer.create(this,effect);

        int bg = i.getIntExtra("bg", 1);
        ImageView b = (ImageView) findViewById(R.id.bg);
        b.setImageResource(bg);

        //mp.start();

        btnPlay = (Button) findViewById(R.id.btnPLAY);
        btnPause = (Button) findViewById(R.id.btnPAUSE);
        //btnTimer = (Button) findViewById(R.id.timer);
        btnEffect = (Button) findViewById(R.id.effect);

        stateAwal();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
                btnPlay.setEnabled(false);
                btnPause.setEnabled(true);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
                btnPlay.setEnabled(true);
                btnPause.setEnabled(false);
            }
        });

        btnEffect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playEffect();
            }
        });

        /*btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer();
            }
        });*/

        sb = (SeekBar)findViewById(R.id.seekBar);

        am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxV = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curV = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        sb.setMax(maxV);
        sb.setProgress(curV);
        sb.setOnSeekBarChangeListener(this);

    }

    /** State Awal / Pertama Dijalankan */
    public void stateAwal(){
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
    }

    /** Dijalankan Oleh Tombol Play */
    private void play() {

        try {
            mp.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** Menjalankan Audio */
        mp.start();


    }

    private void playEffect(){
        try {
            mp.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** Menjalankan Audio */
        ef.start();
    }

    /** Dijalankan Oleh Tombol Pause */
    public void pause(){

        if(mp != null && mp.isPlaying() == true && ef != null && ef.isPlaying()){
            mp.pause();
            ef.pause();
        } else {
            if(mp!=null){
                mp.start();
                ef.start();
            }
        }
        stateAwal();
    }

    /** Dijalankan Oleh Tombol Timer */
    public void timer(){

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_popup);
        dialog.setTitle("Set Timer!");
        dialog.setCancelable(true);

        RadioButton rd1 = (RadioButton) dialog.findViewById(R.id.timer1);
        RadioButton rd2 = (RadioButton) dialog.findViewById(R.id.timer2);
        RadioButton rd3 = (RadioButton) dialog.findViewById(R.id.timer3);

        dialog.show();

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
