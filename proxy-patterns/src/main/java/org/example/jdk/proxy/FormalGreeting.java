package org.example.jdk.proxy;

public class FormalGreeting implements IGreeting {
    @Override
    public String greet(String name) {
        return "Hello! " + name;
    }
}
