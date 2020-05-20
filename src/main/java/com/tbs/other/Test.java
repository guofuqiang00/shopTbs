package com.tbs.other;

public class Test {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.showMessage();
    }
}
