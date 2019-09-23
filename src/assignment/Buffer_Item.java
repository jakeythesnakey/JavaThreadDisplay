/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author sdg0118
 */
public class Buffer_Item {
    public static final int BUFFER_SIZE = 5;
    public Integer item;
    
    public Buffer_Item(){   
        item = (int)(Math.random() * 1000);
    }
    
    public int getBufferSize()
    {
        return BUFFER_SIZE;        
    }
    
    public Integer getItem() {
        Integer returnInt;
        returnInt = -1;
        if (item != null)
        {
            returnInt = item;
        }
            
        return returnInt;
    }

    public void setItem(int item) {
        this.item = item;
    }
    
}
