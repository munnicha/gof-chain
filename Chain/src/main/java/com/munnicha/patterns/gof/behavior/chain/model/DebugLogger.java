package com.munnicha.patterns.gof.behavior.chain.model;

/**
 *
 * @author munnicha
 */
public class DebugLogger extends AbstractLogger{
    
    public DebugLogger(int level) {
        this.level=level;
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("Debug::Logger: " + message);
    }
}
