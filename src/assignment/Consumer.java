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
public class Consumer implements Runnable {
    Buffer buffer;
    
    public Consumer(Buffer buffer)
    {
        this.buffer = buffer;
    }
    
    @Override
    public void run(){
        while (true) 
        {
            if (buffer.acquireLock())
            {                                
                if (buffer.remove_item() == 0)
                {
                    buffer.empty++;
                    buffer.full--;
                }                
                buffer.releaseLock();
                System.out.println("Consume: " + buffer.toString() + "Thread: " + Thread.currentThread().getId()); 
                try {
                    Thread.sleep((int)(Math.random()*1000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }     
        }
    }
}