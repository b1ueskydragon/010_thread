package jp.microad.thread;

public class Main {

	public static void main(String[] args) {

		Fridge fridge = new Fridge(); // 同じ冷蔵庫を使うべき=パラメータで渡す
		Dad dad = new Dad(fridge);
		Me me = new Me(fridge,"ちゃん");

		dad.start();
		me.start();

	}

}
