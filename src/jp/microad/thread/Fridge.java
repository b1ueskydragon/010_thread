package jp.microad.thread;

import java.util.List;
import java.util.ArrayList;
// Keyは不要、重複ありうる、順番大事　→　List

public class Fridge {

	/**
	 * synchronized bufferは１つだけ（nullを反対に使った） 入れるのは無限に入れられる、食べるのは、なかったら食えない。
	 * foodがnullなら作る、foodがnullじゃなかったら食べる
	 * 
	 * notifyAll()とwait()を使うペアsynchronizedを使わずに処理する。
	 */

	List<Food> foodlist = new ArrayList<>();
	int sizenow = 0;
	// バッファの中の入れ箱を初期化

	// 主語なしの「協調してほしい動作」だけをつくる。両方。
	public void put(Food putFood, String dadname) throws InterruptedException {
		// 何があってもお父さんはずっと入れ続けられる
		while (true) {
			foodlist.add(putFood); 
			sizenow = sizenow +1;
			System.out.println(dadname + "が" + putFood.food + "を追加しました" + ":" + sizenow + "個");
			Thread.sleep(1500);
			// ちゃんが消費しやすくするために、もうちょっと待ってあげる・・・。
		}
	}

	public void get(Food getFood, String name) throws InterruptedException {
		// 私は、Foodがないと取り除けない

		while (true) {
			while (foodlist.size() > 0) {
				foodlist.remove(0);
				sizenow = sizenow - 1;
				System.out.println(name + "が" + getFood.food + "を食べました" + ":" + sizenow + "個");
			}
			// whileだとぐるぐる回ってデッドロックになりそう・・。
			if (foodlist.isEmpty() == true) {
				System.out.println(name + "は待ちます");
				Thread.sleep(1000);
			}
		}
	}

	public synchronized void syncFridge(Food food, Fridge fridge, String dadname, String myname) {
		// 動作の制限（協調）
		try {
			// 手元にフードがあれば冷蔵庫に追加できる
			if (food != null) {
				fridge.put(food, dadname);
			}
			// 手元にフードがない時だけ冷蔵庫から取り除ける
			if (food == null) {
				fridge.get(food, myname);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
