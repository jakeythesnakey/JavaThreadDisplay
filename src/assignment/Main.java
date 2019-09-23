/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdg0118
 */
public class Main {
    
    public static Buffer buffer;
    
    public static void main(String[] args)
    {
        buffer = new Buffer();
        
        int numberOfThreads = 5;
        
        for (int i = 0;i < numberOfThreads; i++)
        {
        Runnable p = new Producer(buffer);
        Runnable c = new Consumer(buffer);
        
        Thread producerThread = new Thread(p);
        Thread consumerThread = new Thread(c);
        
        producerThread.start();
        consumerThread.start();
        }
        
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ten Seconds has Passed");
    }
    
}
