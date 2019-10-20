package com.example.test04;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    @Nullable

    private MediaPlayer player;
    public  int onStartCommand(Intent intent,int flags,int startId){
        String action=intent.getStringExtra("action");
        if("play".equals(action)){
            playMusic();
        }else if("pause".equals(action)){
            pauseMusic();
        }else if("stop".equals(action)){
            stopMusic();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void pauseMusic(){
        if(player!=null&&player.isPlaying()){
            player.pause();
        }
    }

    private void stopMusic(){
        if(player!=null){
            player.stop();
            player.reset();
            player.release();
            player=null;
        }
    }

    private void playMusic(){
        if(player==null){
            player=MediaPlayer.create(this,R.raw.music);
        }
        player.start();
    }

    public void onDestory(){
        super.onDestroy();
        stopMusic();
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
