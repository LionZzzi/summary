package com.eric.thread.code.practice;

/**
 * @author Eric
 * @date 2020/1/31 22:36
 */
public class Singleton2 {
   private Singleton2 (){
       // do sth
   }
   private static Singleton2 instance = null;

   public static Singleton2 getInstance(){
       if (null == instance){
           instance = new Singleton2();
       }
       return instance;
   }
}
