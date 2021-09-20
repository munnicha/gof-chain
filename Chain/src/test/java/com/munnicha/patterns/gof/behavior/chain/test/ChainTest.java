package com.munnicha.patterns.gof.behavior.chain.test;

import com.munnicha.patterns.gof.behavior.chain.model.AbstractLogger;
import com.munnicha.patterns.gof.behavior.chain.model.ConsoleLogger;
import com.munnicha.patterns.gof.behavior.chain.model.DebugLogger;
import com.munnicha.patterns.gof.behavior.chain.model.ErrorLogger;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author munnicha
 */
public class ChainTest {
    
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
    
    private AbstractLogger getChainOfLoggers(){

      AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR); //3
      AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG); //2
      AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO); //1

      errorLogger.setNextLogger(debugLogger);
      debugLogger.setNextLogger(consoleLogger);

      return errorLogger;	
   }
    
    @Test
    public void testChain(){
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO, "Log message-01");
        
        assertEquals("Console::Logger: Log message-01", outputStreamCaptor.toString().trim());
    }
    
}
