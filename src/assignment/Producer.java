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
public class Producer implements Runnable {
    
    Buffer buffer;
    Buffer_Item newItem;
    public Producer(Buffer buffer)
    {
        this.buffer = buffer;
        newItem = new Buffer_Item();
    }
    
    @Override
    public void run()
    {
        
        
        while (true) 
        {
            if (buffer.acquireLock())               
            {
                //System.out.println("ProducerRunning");                
                newItem.setItem((int) (Math.random()*1000));
                if (buffer.insert_item(newItem) == 0)
                {
                    buffer.empty--;
                    buffer.full++;
                    buffer.toString();
                }   
               System.out.println("Produce: " + buffer.toString()  + "Thread: " +  Thread.currentThread().getId());                
                buffer.releaseLock();
                try {
                    Thread.sleep((int)(Math.random()*1000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }     
        }
    }
        
}