package com.atguigu.designmethods.Adapter;

public class VlcPlayer implements AdvancedPlayer {
       @Override
       public void playVlc(String fileName) {
           System.out.println("Playing vlc file. Name: " + fileName);
       }

       @Override
       public void playMp4(String fileName) {
           // This method is not used in this example
       }
   }
   