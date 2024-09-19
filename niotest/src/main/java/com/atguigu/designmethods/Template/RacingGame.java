package com.atguigu.designmethods.Template;

public class RacingGame extends Game {
       @Override
       protected void initialize() {
           System.out.println("Initializing Racing Game...");
       }

       @Override
       protected void startPlay() {
           System.out.println("Starting Racing Game...");
       }

       @Override
       protected void endPlay() {
           System.out.println("Ending Racing Game...");
       }
   }
   