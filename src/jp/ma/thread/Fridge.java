package jp.ma.thread;

import java.util.List;
import java.util.ArrayList;

class Fridge {

  private List<Food> buffer = new ArrayList<>(); // TODO Deque

  /**
   * Responsibility : PUT ONLY
   */
  private void put(Food food, String name) throws InterruptedException {
    buffer.add(food);
    // TODO fix params, replace to logger
    System.out.println(name + " put a " + food.food + ", the number of foods : " + buffer.size());
    Thread.sleep(300);
  }

  /**
   * Responsibility : GET ONLY
   */
  private void get(String name) throws InterruptedException {
    if (buffer.isEmpty()) {
      System.out.println("the number of foods is " + buffer.size() + ", " + name + " is waiting");
      Thread.sleep(500);
    } else {
      buffer.remove(0);
      System.out.println(name + " takes a food" + ", the number of foods :" + buffer.size());
      Thread.sleep(300);
    }
  }

  /**
   * if food exists, put in fridge
   * TODO: Fix conditions
   */
  synchronized void syncFridge(Food food, Fridge fridge, String name) {
    try {
      if (food == null) fridge.get(name);
      else fridge.put(food, name);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
