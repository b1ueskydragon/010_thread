package jp.ma.thread;

public class Parent implements Runnable {

  private final Fridge fridge;
  private final String name;

  Parent(Fridge fridge, String name) {
    this.fridge = fridge;
    this.name = name;
  }

  public void run() {
    while (true) {
      Food putFood = new Food("Chicken");
      fridge.syncFridge(putFood, fridge, name); // (O)
      // fridge.put(putFood, name); (X)
    }
  }
}
