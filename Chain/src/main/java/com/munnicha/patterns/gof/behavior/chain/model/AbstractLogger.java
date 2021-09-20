package com.munnicha.patterns.gof.behavior.chain.model;

/**
 *
 * @author munnicha
 */
public abstract class AbstractLogger {
    
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;
    
    protected AbstractLogger nextLogger;
    
    protected int level;

    public final void logMessage(int level, String message){
        if(this.level<=level){
            writeMessage(message);
        }else{
            if(nextLogger!=null){
                nextLogger.logMessage(level, message);
            }else{
                System.out.println("Could not handle the request.");
            }
        }
        
    }
    
    abstract protected void writeMessage(String message);
    
    public AbstractLogger getNextLogger() {
        return nextLogger;
    }

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

}
