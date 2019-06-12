package jp.ma.thread;

public class Main {

  public static void main(String[] args) {

    Fridge fridge = Fridge.getInstance();

    Thread parent = new Thread(new Parent(fridge, "Mom"));
    Thread parent2 = new Thread(new Parent(fridge, "Dad"));
    Thread child = new Thread(new Child(fridge, "Alex"));
    Thread child2 = new Thread(new Child(fridge, "Rick"));

    parent.start();
    child.start();
    parent2.start();
    child2.start();

  }

}
