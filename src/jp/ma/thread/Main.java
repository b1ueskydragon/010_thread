package jp.ma.thread;

public class Main {

  public static void main(String[] args) {

    Fridge fridge = new Fridge(); // 同じ冷蔵庫を使うべき=パラメータで渡す
    Parent parent = new Parent(fridge, "Mom");
    Parent parent2 = new Parent(fridge, "Dad");
    Child child = new Child(fridge, "Alex");
    Child child2 = new Child(fridge, "Rick");

    parent.start();
    child.start();
    parent2.start();
    child2.start();

  }
}
