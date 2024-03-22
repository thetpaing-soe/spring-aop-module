package org.example;

import org.example.jdk.proxy.FormalGreeting;
import org.example.jdk.proxy.GreetingProxy;
import org.example.jdk.proxy.IGreeting;

public class Main {
    public static void main(String[] args) {

        IGreeting greeting = new GreetingProxy(new FormalGreeting());
        System.out.println(greeting.greet("John"));
    }
}