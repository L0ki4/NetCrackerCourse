package com.netcracker.edu.java.tasks;

public class Main {

    public static void main(String[] args) {
        ComplexNumberImpl a = new ComplexNumberImpl();

        a.set("-8.0 + 8.0i");
//
//        a.negate();
        ComplexNumber b =  new ComplexNumberImpl();
        b.set("8-4i");
        a.multiply(b).add(a);
        System.out.println(a.toString());
    }
}
