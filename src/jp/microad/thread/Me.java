package jp.microad.thread;

public class Me extends Thread {

	Fridge fridge; // newしてはいけない
	String myname;

	Me(Fridge fridge, String myname) {
		this.fridge = fridge;
		this.myname = myname;
	}

	public void run() {
		// fridge.get( myname);
		while (true) {
			fridge.syncFridge(null, fridge, null, myname);
		}
	}

}
