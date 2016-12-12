package jp.microad.thread;

public class Dad extends Thread {

	Fridge fridge; // newしないこと

	Dad(Fridge fridge) {
		this.fridge = fridge;

	}

	public void run() {

		/// ここに具体的になにか書いてあげないと実行できない///
		try {
			Food putFood = new Food("チキン");
			fridge.put(putFood);
		} catch (InterruptedException e) {
		}

	}

}
