package com.programacaobrasil.somdosbichos;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    MediaPlayer mediaPlayer;
    private ImageView imgCao;
    private ImageView imgGato;
    private ImageView imgLeao;
    private ImageView imgMacaco;
    private ImageView imgOvelha;
    private ImageView imgVaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        initializeEventsComponents();
    }

    @Override
    protected void onDestroy() {

        if (mediaPlayer!=null)
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;

            Toast.makeText(getApplicationContext(), "Finalizou", Toast.LENGTH_LONG).show();
        }

        super.onDestroy();
    }

    private void initializeComponents()
    {
        imgCao = (ImageView)findViewById(R.id.imgCao);
        imgGato = (ImageView)findViewById(R.id.imgGato);
        imgLeao = (ImageView)findViewById(R.id.imgLeao);
        imgMacaco = (ImageView)findViewById(R.id.imgMacaco);
        imgOvelha = (ImageView)findViewById(R.id.imgOvelha);
        imgVaca = (ImageView)findViewById(R.id.imgVaca);
    }

    private void initializeEventsComponents()
    {
        imgCao.setOnClickListener(this);
        imgGato.setOnClickListener(this);
        imgLeao.setOnClickListener(this);
        imgMacaco.setOnClickListener(this);
        imgOvelha.setOnClickListener(this);
        imgVaca.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Context context = getApplicationContext();
        switch (view.getId())
        {
            case R.id.imgCao:
                mediaPlayer = MediaPlayer.create(context, R.raw.cao);
                break;
            case R.id.imgGato:
                mediaPlayer = MediaPlayer.create(context, R.raw.gato);
                break;
            case R.id.imgLeao:
                mediaPlayer = MediaPlayer.create(context, R.raw.leao);
                break;
            case R.id.imgMacaco:
                mediaPlayer = MediaPlayer.create(context, R.raw.macaco);
                break;
            case R.id.imgOvelha:
                mediaPlayer = MediaPlayer.create(context, R.raw.ovelha);
                break;
            case R.id.imgVaca:
                mediaPlayer = MediaPlayer.create(context, R.raw.vaca);
                break;
        }

        tocarSom();
    }

    private void tocarSom()
    {
        if (mediaPlayer != null) {
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                };
            });
        }
    }
}
