package com.example.test04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button main_play,main_stop,main_pause,main_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_play=findViewById(R.id.play);
        main_stop=findViewById(R.id.stop);
        main_pause=findViewById(R.id.pause);
        main_exit=findViewById(R.id.exit);

        main_play.setOnClickListener(this);
        main_stop.setOnClickListener(this);
        main_pause.setOnClickListener(this);
        main_exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,MusicService.class);
        if(v==main_play){
            intent.putExtra("action","play");
            startService(intent);
        }else if(v==main_stop){
            intent.putExtra("action","stop");
            startService(intent);
        }else if(v==main_pause){
            intent.putExtra("action","pause");
            startService(intent);
        }else if(v==main_exit){
           stopService(intent);
           finish();
        }
    }
}
