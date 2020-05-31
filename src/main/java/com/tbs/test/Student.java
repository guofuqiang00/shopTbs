package com.tbs.test;

public class Student extends Person {
    private String schoolName;
    int id = 1002;// 学号

    public Student() {
        super();
    }

    public void  eat(){
        System.out.println("学生吃饭");
    }

    public void info(){
        this.eat();
        super.eat();
        super.sleep();//写成this.sleep也行 反正只有一个
    }

    public void show() {
        System.out.println(this.id);// 1002
        System.out.println(super.id);// 1001 调用父类的id
        System.out.println(super.name);
    }

    public static void main(String[] args) {
    }
}