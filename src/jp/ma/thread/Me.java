package jp.ma.thread;

public class Me extends Thread {

  Fridge fridge; // newしてはいけない
  String myname;

  Me(Fridge fridge, String myname) {
    this.fridge = fridge;
    this.myname = myname;
  }

  public void run() {
    while (true) {
      fridge.syncFridge(null, fridge, myname);
    }
  }
}
