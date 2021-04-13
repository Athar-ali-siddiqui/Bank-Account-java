import java.lang.reflect.Array;
import java.sql.SQLTransientException;

import org.graalvm.compiler.nodes.calc.FloatEqualsNode;

import java.util.*;


/**
 * InnerAss1
 */



class StopWatch{
    private long startTime;
    private long stopTime;
    
  
    StopWatch(){
      this.startTime = new Date().getTime();
    }
    public void start(){
      this.startTime = new Date().getTime();
    }
    public void stop(){
      this.stopTime = new Date().getTime();
    }
    public double elapsedTime(){
      double elapsedTime = (double)(this.stopTime - this.startTime)/1000;
      this.startTime = 0;
      this.stopTime =0;
      return elapsedTime;
    }
    public double checkElapsedTime(){
      double elapsedTime = (double)(new Date().getTime() - this.startTime)/1000;
      System.out.println(" Checking elapsed time :" +elapsedTime);
      return elapsedTime;
    }
  }
  