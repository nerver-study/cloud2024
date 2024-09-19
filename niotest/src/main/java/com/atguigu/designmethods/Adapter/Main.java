package com.atguigu.designmethods.Adapter;

public class Main {
       public static void main(String[] args) {
           MediaPlayer mp3Player = new MediaAdapter("mp3");
           mp3Player.play("mp3", "beyond_the_horizon.mp3");

           MediaPlayer vlcPlayer = new MediaAdapter("vlc");
           vlcPlayer.play("vlc", "alone.mp4");

           MediaPlayer mp4Player = new MediaAdapter("mp4");
           mp4Player.play("mp4", "tears_of_steel.mp4");
       }
   }
   