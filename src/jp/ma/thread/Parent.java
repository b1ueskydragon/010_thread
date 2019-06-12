package jp.ma.thread;

public class Parent implements Runnable {

  private final Fridge fridge;
  private final String name;

  Parent(Fridge fridge, String name) {
    this.fridge = fridge;
    this.name = name;
  }

  public void run() {
    //noinspection InfiniteLoopStatement
    while (true) {
      fridge.sync(new Food("Chicken"), name);
    }
  }
}
