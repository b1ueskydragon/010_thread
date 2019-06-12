package jp.ma.thread;

public class Parent extends Thread {

  Fridge fridge; // newしないこと
  String name;

  Parent(Fridge fridge, String name) {
    this.fridge = fridge; // (左)このフィールドのfridge = (右)受け取るfridge
    this.name = name;
  }

  public void run() {
    /// ここに具体的になにか書いてあげないと実行できない///
    while (true) {
      Food putFood = new Food(); // 毎回新しいFoodを作る
      fridge.syncFridge(putFood, fridge, name); // (O)
      // fridge.put(putFood, name); (X)
    }
  }
}
