package com.atguigu.designmethods.Template;

public class Main {
       public static void main(String[] args) {
           // 创建并运行赛车游戏
           Game racingGame = new RacingGame();
           racingGame.play();

           // 创建并运行射击游戏
           Game shootingGame = new ShootingGame();
           shootingGame.play();
       }
   }
   