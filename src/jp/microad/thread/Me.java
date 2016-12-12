package jp.microad.thread;

public class Me extends Thread {

	Fridge fridge; // newしてはいけない
	String myname;

	Me(Fridge fridge, String myname) {
		this.fridge = fridge;
		this.myname = myname;
	}

	public void run() {
		/// ここに具体的になにか書いてあげないと実行できない///
		try {
			Food getFood = new Food();
			fridge.get(getFood, myname);
		} catch (InterruptedException e) {
		}

	}

}
