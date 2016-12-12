package jp.microad.thread;

public class Me extends Thread {

	Fridge fridge; // newしてはいけない

	String name;

	Me(Fridge fridge, String name) {
		this.fridge = fridge;
		this.name = name;
	}

	public void run() {
		/// ここに具体的になにか書いてあげないと実行できない///
		try {
			Food getFood = new Food("チキン");
			fridge.get(getFood, name);
		} catch (InterruptedException e) {
		}

	}

}
