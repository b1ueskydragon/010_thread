package jp.ma.thread;

public class Main {

  public static void main(String[] args) {

    // TODO 'Dad' rename to 'Parents', 'Me' rename to 'Child'
    Fridge fridge = new Fridge(); // 同じ冷蔵庫を使うべき=パラメータで渡す
    Dad dad = new Dad(fridge, "ママ");
    Dad dad2 = new Dad(fridge, "パパ");
    Me me = new Me(fridge, "ちゃん");
    Me me2 = new Me(fridge, "ちゃん弟");

    dad.start();
    me.start();
    dad2.start();
    me2.start();
  }
}
