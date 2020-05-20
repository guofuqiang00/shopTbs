package com.tbs.other;

public class Singleton {

    private static Singleton instance= new Singleton();

    public Singleton() {
    }

    public static Singleton getInstance() {
        if(instance!=null){
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("显示一条信息");
    }
}
