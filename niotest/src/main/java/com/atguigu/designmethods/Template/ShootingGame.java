package com.atguigu.designmethods.Template;

public class ShootingGame extends Game {
       @Override
       protected void initialize() {
           System.out.println("Initializing Shooting Game...");
       }

       @Override
       protected void startPlay() {
           System.out.println("Starting Shooting Game...");
       }

       @Override
       protected void endPlay() {
           System.out.println("Ending Shooting Game...");
       }
   }
   