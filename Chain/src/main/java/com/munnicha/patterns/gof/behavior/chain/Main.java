package com.munnicha.patterns.gof.behavior.chain;

import com.munnicha.patterns.gof.behavior.chain.model.AbstractLogger;
import com.munnicha.patterns.gof.behavior.chain.model.ConsoleLogger;
import com.munnicha.patterns.gof.behavior.chain.model.DebugLogger;
import com.munnicha.patterns.gof.behavior.chain.model.ErrorLogger;

/**
 *
 * @author munnicha
 */
public class Main {
    
    //get loggerchain
    private static final AbstractLogger loggerChain = getChainOfLoggers();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //log something
        System.out.println("Log with level: "+AbstractLogger.ERROR);
        loggerChain.logMessage(AbstractLogger.ERROR, "Log message-01");
        
        //
        System.out.println("Log with level: "+AbstractLogger.DEBUG);
        loggerChain.logMessage(AbstractLogger.DEBUG, "Log message-02");
        
        //
        System.out.println("Log with level: "+AbstractLogger.INFO);
        loggerChain.logMessage(AbstractLogger.INFO, "Log message-03");
        
        //
        System.out.println("Log with level: "+-1);
        loggerChain.logMessage(-1, "Log message-04");
        
        //various log messages
        System.out.println("#######################");
        logic("OK");
        logic(null);
        logic("Check String");

    }
    
    private static AbstractLogger getChainOfLoggers(){

      AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR); //3
      AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG); //2
      AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO); //1

      errorLogger.setNextLogger(debugLogger);
      debugLogger.setNextLogger(consoleLogger);

      return errorLogger;	
   }
    
   private static boolean logic(String checkString){
       //change levels
        loggerChain.logMessage(AbstractLogger.INFO, "Start logic");
        if(checkString==null){
            loggerChain.logMessage(AbstractLogger.ERROR, "checkString cannot be null.");
            return false;
        }
        loggerChain.logMessage(AbstractLogger.DEBUG, "checkString = "+checkString);
        if("OK".equalsIgnoreCase(checkString)){
            loggerChain.logMessage(AbstractLogger.INFO, "Hurray");
            return true;
        }else{
            loggerChain.logMessage(AbstractLogger.DEBUG, "checkString is not equal to OK.");
            return false;
        }
   }
    
}
