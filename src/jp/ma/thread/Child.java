package jp.ma.thread;

public class Child implements Runnable {

  private final Fridge fridge;
  private final String name;

  Child(Fridge fridge, String name) {
    this.fridge = fridge;
    this.name = name;
  }

  public void run() {
    while (true) {
      fridge.syncFridge(null, fridge, name);
    }
  }
}
