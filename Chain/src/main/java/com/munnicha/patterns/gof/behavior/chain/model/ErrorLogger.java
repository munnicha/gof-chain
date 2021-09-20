package com.munnicha.patterns.gof.behavior.chain.model;

/**
 *
 * @author munnicha
 */
public class ErrorLogger extends AbstractLogger{
    
    public ErrorLogger(int level) {
        this.level=level;
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("Error::Logger: " + message);
    }
    
}
