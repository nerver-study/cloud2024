package com.atguigu.designmethods.Adapter;

public class MediaAdapter implements MediaPlayer {
       private AdvancedPlayer advancedPlayer;

       public MediaAdapter(String audioType) {
           if (audioType.equalsIgnoreCase("vlc")) {
               advancedPlayer = new VlcPlayer();
           } else if (audioType.equalsIgnoreCase("mp4")) {
               advancedPlayer = new Mp4Player();
           }
       }

       @Override
       public void play(String audioType, String fileName) {
           if (audioType.equalsIgnoreCase("vlc")) {
               advancedPlayer.playVlc(fileName);
           } else if (audioType.equalsIgnoreCase("mp4")) {
               advancedPlayer.playMp4(fileName);
           }
       }
   }
   