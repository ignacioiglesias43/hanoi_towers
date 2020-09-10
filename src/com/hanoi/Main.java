package com.hanoi;

import java.util.Stack;

public class Main {
    static Stack<Integer> origin = new Stack<>();
    static Stack<Integer> aux = new Stack<>();
    static Stack<Integer> end = new Stack<>();

    public static void main(String[] args) {
        origin.push(4);
        origin.push(3);
        origin.push(2);
        origin.push(1);

        System.out.println("origin: " + origin);
        System.out.println("aux: " + aux);
        System.out.println("end: " + end);

        hanoi(origin.size(), origin, aux, end);
    }
    //Funcion recursiva
    public static void hanoi(int towers, Stack<Integer> origin, Stack<Integer> aux, Stack<Integer> end) {
        if(towers == 1) {
            move(origin.pop(), end);
        } else {
            hanoi(towers-1,origin, end, aux);
            move(origin.pop(), end);
            hanoi(towers-1,aux, origin, end);
        }
    }

    // Esta función es para visualizar en consola el progreso
    public static void move(int n, Stack<Integer> target) {
        target.push(n);
        System.out.println("origin: " + origin);
        System.out.println("aux: " + aux);
        System.out.println("end: " + end);
    }

}
