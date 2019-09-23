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
public class Buffer {
    Buffer_Item item;
    Buffer_Item[] buffer;
    int empty;
    int full;
    Boolean mutex;
    
    public Buffer()
    {
        item = new Buffer_Item();        
        buffer = new Buffer_Item[item.getBufferSize()];
        this.mutex = false;
        
    }
    
    public int insert_item(Buffer_Item item)
    {
        int returnInt = -1;
        
        int i = 0;
        for (; i <buffer.length; i++)
        {
            if ((buffer[i] == null) && (returnInt != 0))
            {            
                buffer[i] = new Buffer_Item();            
                returnInt = 0;
            } 
        }
        
        return returnInt;
    }
    
    public int remove_item()
    {
        int returnInt = -1;
        for (int i = 0; i <buffer.length; i++)
        {
            if ((buffer[i] != null) && (returnInt != 0))
            {            
                buffer[i] = null;            
                returnInt = 0;
            } 
        }    
        return returnInt;
    }

    public Buffer_Item getItem() {
        return item;
    }
   
    public synchronized Boolean acquireLock()
    {
        boolean returnBool = false;
        if (mutex == false)
        {
            mutex = true;
            returnBool = true;
        }        
        return returnBool;
    }
    
    public synchronized boolean releaseLock()
    {
        boolean returnInt = false;
        if (mutex == true)
        {
            mutex = false;
            returnInt = true;
        }        
        return returnInt;
    }
    
    @Override
    public String toString()
    {   
        String returnString = "";
        for (int i = 0; i < item.getBufferSize(); i++)
        {
            returnString += (i+1) + ": ";
            if (buffer[i] != null)
            {
                returnString = returnString + buffer[i].getItem().toString() + ", ";
            }
            else
            {
                returnString += "null";
            }
        }
        
        return returnString;
    }
}
