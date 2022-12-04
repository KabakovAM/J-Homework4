package Homework4;

import java.util.Stack;

public class Ex232 {
    static Stack<Integer> firstStack;
    static Stack<Integer> secondStack;

    public static void main(String[] args) {
        String[] command = new String[] { "MyQueue", "push", "push", "peek", "pop", "empty" };
        Integer[][] digits = new Integer[][] { {}, { 1 }, { 2 }, {}, {}, {} };
        for (int i = 0; i < command.length; i++) {
            if (command[i] == "MyQueue") {
                MyQueue();
            }
            if (command[i] == "push") {
                push(digits[i][0]);
            }
            if (command[i] == "pop") {
                System.out.println(pop());
            }
            if (command[i] == "peek") {
                System.out.println(peek());
            }
            if (command[i] == "empty") {
                System.out.println(empty());
            }
        }
    }

    public static void MyQueue() {
        firstStack = new Stack<Integer>();
        secondStack = new Stack<Integer>();
    }

    public static void push(int x) {
        firstStack.push(x);
    }

    public static int pop() {
        if (!secondStack.isEmpty()) {
            return secondStack.pop();
        } else {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
            return secondStack.pop();
        }
    }

    public static int peek() {
        int first = 0;
        if (!secondStack.isEmpty()) {
            first = secondStack.peek();
        } else {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
            first = secondStack.peek();
        }

        return first;
    }

    public static boolean empty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }
}
