package jp.ma.thread;

import java.util.List;
import java.util.ArrayList;

public class Fridge {

  /**
   * synchronized bufferは１つだけ（nullを反対に使った） 入れるのは無限に入れられる、食べるのは、なかったら食えない。
   * foodがnullなら作る、foodがnullじゃなかったら食べる
   * <p>
   * notifyAll()とwait()を使うペアsynchronizedを使わずに処理する。
   */

  private List<Food> foods = new ArrayList<>();
  // バッファの中の入れ箱を初期化

  // 主語なしの「協調してほしい動作」だけをつくる。両方。
  // Fridgeクラスの外では呼ばれてはならない（呼ばれて良いものは syncされたメソッドのみ）

  private void put(Food putFood, String name) throws InterruptedException {
    // 何があってもお父さんはずっと入れ続けられる
    int before = foods.size();
    foods.add(putFood);
    int after = foods.size();
    System.out.println(
        name + "が" + putFood.food + "を" + (after - before) + "個追加しました" + ":" + foods.size() + "個");
    Thread.sleep(300);
  }

  private void get(String name) throws InterruptedException {
    // 私は、Foodがないと取り除けない
    if (foods.isEmpty()) {
      System.out.println(foods.size() + "個なので" + name + "は待ちます");
      Thread.sleep(500);
    } else {
      int before = foods.size();
      foods.remove(0);
      int after = foods.size();
      System.out.println(name + "が" + (before - after) + "個食べました" + ":" + foods.size() + "個");
      Thread.sleep(300);
    }
  }

  public synchronized void syncFridge(Food food, Fridge fridge, String name) {
    // 動作の制限（協調）
    // String型のnameなのは一緒なので、無駄なパラメータは減らし統一させる。
    // パパ１、パパ２、ちゃん、ちゃん弟がみんな同じ冷蔵庫を共有・かつ、それぞれ同時に触ることはできない。
    try {
      // 手元にフードがあれば冷蔵庫に追加できる
      if (food != null) {
        fridge.put(food, name);
      }
      // 手元にフードがない時だけ冷蔵庫から取り除ける
      if (food == null) {
        fridge.get(name);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
