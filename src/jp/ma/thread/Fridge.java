package jp.ma.thread;

import java.util.List;
import java.util.ArrayList;
// Keyは不要、重複ありうる、順番大事　→　List

public class Fridge {

  /**
   * synchronized bufferは１つだけ（nullを反対に使った） 入れるのは無限に入れられる、食べるのは、なかったら食えない。
   * foodがnullなら作る、foodがnullじゃなかったら食べる
   * <p>
   * notifyAll()とwait()を使うペアsynchronizedを使わずに処理する。
   */

  List<Food> foodlist = new ArrayList<>();
  // バッファの中の入れ箱を初期化

  // 主語なしの「協調してほしい動作」だけをつくる。両方。
  // Fridgeクラスの外では呼ばれてはならない（呼ばれて良いものは syncされたメソッドのみ）

  private void put(Food putFood, String name) throws InterruptedException {
    // 何があってもお父さんはずっと入れ続けられる
    int sizewas = foodlist.size();
    foodlist.add(putFood);
    int sizenow = foodlist.size();
    System.out.println(
        name + "が" + putFood.food + "を" + (sizenow - sizewas) + "個追加しました" + ":" + foodlist.size() + "個");
    Thread.sleep(300);
  }

  private void get(Food getFood, String name) throws InterruptedException {
    // 私は、Foodがないと取り除けない
    if (foodlist.isEmpty() == true) {
      System.out.println(foodlist.size() + "個なので" + name + "は待ちます");
      Thread.sleep(500);
    } else {
      int sizewas = foodlist.size();
      foodlist.remove(0);
      int sizenow = foodlist.size();
      System.out.println(name + "が" + (sizewas - sizenow) + "個食べました" + ":" + foodlist.size() + "個");
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
        fridge.get(food, name);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
