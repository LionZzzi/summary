package com.eric.thread.code.practice;

/**
 * @author Eric
 * @date 2020/1/31 22:36
 */
public class Singleton3 {
  private Singleton3(){

  }
  private static volatile Singleton3 instance = null;

  public static Singleton3 getInstance(){
      if (null == instance) {
          synchronized (Singleton3.class){
              if (null == instance){
                  instance = new Singleton3();
              }
          }
      }
      return instance;
  }
}
