package com.tbs.test;

public class Test   {
    private String username;

    public static void main(String[] args){
        java.util.Scanner s = new java.util.Scanner(System.in);
        System.out.println("请输入1~12的数字");
        int num = s.nextInt();
        String str = "冬季";
        switch(num){
            case 3: case 4: case 5:
                str = "春季";
                break;
            case 6: case 7: case 8:
                str = "夏季";
                break;
            case 9: case 10: case 11:
                str = "秋季";
                break;
            case 12: case 1: case 2:
                System.out.println(str);
                break;
            default:
                System.out.println("非法操作");
        }
    }


//
//    public static void main(String[] args) {
//        // 类型声明
//        A a=new A();
//        a.show();
//        A.B b = new A().new B();
//        b.show2();
//        System.out.println(a.lab);
//        //匿名内部类
//        //具体名字不会被我们在程序当众编写出来，因为它已经在主方法当中被实例化了
//       C c = new C() {
//           @Override
//           public void run() {
//               super.run();
//           }
//       };
//
//
//
//    }

}
class A{
     String lab = "lab";
    public void show(){
        String inner = "inner";
        System.out.println("show---->>>"+"aaa");
    }

    class B{
        public void show2(){
            System.out.println("show---->>>"+"bbb");
        }
    }
}

abstract  class  C{
    public void run(){
        System.out.println("run");
    }
}

class  D extends TestAbstract {

}

