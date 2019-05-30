package java.pl;

import java.util.Stack;

public class Program {
    public static void main(String[] args) {
        Stack<String> napisy = new Stack<>();

        napisy.push("element0");
        napisy.push("element1");
        napisy.push("element2");
        String pop = napisy.pop();
        napisy.pop();
        napisy.pop();
        napisy.pop();
    }
}
