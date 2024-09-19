package com.atguigu.designmethods.Adapter;

public class Mp4Player implements AdvancedPlayer {
       @Override
       public void playVlc(String fileName) {
           // This method is not used in this example
       }

       @Override
       public void playMp4(String fileName) {
           System.out.println("Playing mp4 file. Name: " + fileName);
       }
   }
   