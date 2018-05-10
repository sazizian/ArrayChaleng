package com.sasan.test;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add(0,"Sasan");
        linkedList.add(1,"Elham");
        linkedList.add(2,"Salar");
        for(String s:linkedList){
            System.out.println(s);
        }
        System.out.println("===============================");
        linkedList.add(1,"Samam");
        for(String s:linkedList){
            System.out.println(s);
        }
    }

}
