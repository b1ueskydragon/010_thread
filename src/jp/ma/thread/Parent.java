package jp.ma.thread;

import java.util.Random;

public class Parent implements Runnable {

  private final Fridge fridge;
  private final String name;

  private final String[] menus = {"Chicken", "Bossam"};
  private Random random = new Random();

  Parent(Fridge fridge, String name) {
    this.fridge = fridge;
    this.name = name;
  }

  public void run() {
    //noinspection InfiniteLoopStatement
    while (true) {
      fridge.sync(new Food(menus[random.nextInt(2)]), name);
    }
  }
}
