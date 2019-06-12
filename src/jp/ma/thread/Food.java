package jp.ma.thread;

class Food {

  private final String food;

  Food() {
    this.food = null;
  }

  Food(String food) {
    this.food = food;
  }

  boolean isCookingDone() {
    return food != null;
  }

  String getName() {
    return this.food;
  }

}
