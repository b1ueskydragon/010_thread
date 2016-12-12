package jp.microad.thread;

public class Dad extends Thread {

	Fridge fridge; // newしないこと
	String dadname;


	Dad(Fridge fridge, String dadname) {
		this.fridge = fridge; // (左)このフィールドのfridge = (右)受け取るfridge
		this.dadname = dadname;
	}

	public void run() {
		/// ここに具体的になにか書いてあげないと実行できない///
		try {
			Food putFood = new Food();
			fridge.put(putFood, dadname);
		} catch (InterruptedException e) {
		}
	}
}
