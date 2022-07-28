package com.newthinktank;

import java.io.*;
import java.util.*;

public class Generics {
    public static void main(String[] args) {
        String[] gA1 = { "one", "two" };
        Integer[] gA2 = { 1, 2, 3, 4 };

        // printStuff(gA1);
        // printStuff(gA2);

        ArrayList<Integer> aL1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        printAL(aL1);

        MyGeneric<Integer> myGI = new MyGeneric<Integer>();
        myGI.setVal(10);
        System.out.println(myGI.getVal());

        MyGeneric<String> myGS = new MyGeneric<String>();
        myGS.setVal("Dog");
        System.out.println(myGS.getVal());
    }

    public static <T> void printStuff(T[] arr) {
        for (T x : arr)
            System.out.println(x);
    }

    public static void printAL(ArrayList<?> aL) {
        for (Object x : aL)
            System.out.println(x);
    }
}

class MyGeneric<T> {
    T val;

    public void setVal(T _val) {
        this.val = _val;
    }

    public T getVal() {
        return val;
    }
}
