package Homework4;

import java.util.Stack;

public class Ex71 {
    public static void main(String[] args) {
        String exp = "/home/";
        simplifyPath(exp);
    }

    public static void simplifyPath(String path) {
        Stack<String> pathStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] pathString = path.split("/");
        for (int i = 0; i < pathString.length; i++) {
            if (pathString[i].equals("..")) {
                if (!pathStack.isEmpty()) {
                    pathStack.pop();
                }
            }
            if (!pathString[i].equals("") && !pathString[i].equals(".") && !pathString[i].equals("..")) {
                pathStack.push(pathString[i]);
            }
        }
        if (!pathStack.isEmpty()) {
            for (String i : pathStack) {
                sb.append("/");
                sb.append(i);
            }
        } else {
            sb.append("/");
        }
        System.out.println(sb.toString());
    }
}
