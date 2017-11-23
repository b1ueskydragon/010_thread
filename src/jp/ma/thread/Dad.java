package jp.ma.thread;

public class Dad extends Thread {

  Fridge fridge; // newしないこと
  String dadname;

  Dad(Fridge fridge, String dadname) {
    this.fridge = fridge; // (左)このフィールドのfridge = (右)受け取るfridge
    this.dadname = dadname;
  }

  public void run() {
    /// ここに具体的になにか書いてあげないと実行できない///
    while (true) {
      Food putFood = new Food(); // 毎回新しいFoodを作る
      fridge.syncFridge(putFood, fridge, dadname); // (O)
      // fridge.put(putFood, dadname); (X)
    }

  }
}
