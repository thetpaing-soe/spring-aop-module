package org.example.jdk.proxy;

public class GreetingProxy implements IGreeting {

    private FormalGreeting formalGreeting;

    public GreetingProxy(FormalGreeting formalGreeting) {
        this.formalGreeting = formalGreeting;
    }

    @Override
    public String greet(String name) {
        return formalGreeting.greet(name) + ". How are you doing?";
    }
}
