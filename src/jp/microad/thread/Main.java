package jp.microad.thread;

public class Main {

	public static void main(String[] args) {

		Fridge fridge = new Fridge(); // 同じ冷蔵庫を使うべき=パラメータで渡す
		Dad dad = new Dad(fridge, "パパ１");
		Dad dad2 = new Dad(fridge,"パパ２");
		Me me = new Me(fridge,"ちゃん");
		Me me2 = new Me(fridge,"弟＜ちゃん＞");

		dad.start();
		me.start();
		dad2.start();
		me2.start();
	}

}
