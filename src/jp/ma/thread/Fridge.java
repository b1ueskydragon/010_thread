package jp.ma.thread;

import java.util.Deque;
import java.util.LinkedList;

import static java.lang.System.out;


class Fridge {

  private Deque<Food> buffer = new LinkedList<>();

  /**
   * Responsibility : PUT ONLY
   */
  private void put(Food food, String name) throws InterruptedException {
    buffer.addLast(food);
    out.println(name + " put a " + food.getName() + ", the number of foods : " + buffer.size());
    Thread.sleep(300);
  }

  /**
   * Responsibility : GET ONLY
   */
  private void get(String name) throws InterruptedException {
    if (buffer.isEmpty()) {
      out.println("the number of foods is " + buffer.size() + ", " + name + " is waiting");
      Thread.sleep(500);
    } else {
      buffer.removeFirst();
      out.println(name + " takes a food" + ", the number of foods :" + buffer.size());
      Thread.sleep(300);
    }
  }

  /**
   * if cooking is done, put in fridge
   */
  synchronized void sync(Food food, String name) {
    try {
      if (food.isCookingDone()) put(food, name);
      else get(name);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
