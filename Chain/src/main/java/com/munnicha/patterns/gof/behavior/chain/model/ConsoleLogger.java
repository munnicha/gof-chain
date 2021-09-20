package com.munnicha.patterns.gof.behavior.chain.model;

/**
 *
 * @author munnicha
 */
public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level) {
        this.level=level;
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("Console::Logger: " + message);
    }
    
}
