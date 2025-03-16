/*
 * Contains a generic key object (declared as Object key), frequency count (to count duplicates), and probe count.  
 * It needs to override both the equals and the toString methods and should also have a getKey method that returns an Object type. 
 * Make sure that the equals method actually compares the key values using the equals method on the keys.
 */

public class HashObject
{
    private Object key;
    private int frequency;
    private int probeCount;

    public HashObject(Object key)
    {
        this.key = key;
        this.frequency = 1; 
        this.probeCount = 0; 
    }

    public Object getKey()
    {
        return this.key;
    }

    public int getFrequency() {
        return frequency;
    }
    
    public void incrementFrequency() 
    {
        frequency++;
    }

    public int getProbeCount() {
        return probeCount;
    }

    public void incrementProbeCount() 
    {
        probeCount++;
    }
    
  
    public boolean equals(HashObject compared)
    {
        if(this == compared)
        {
            return true;
        }
        if (compared == null || getClass() != compared.getClass()) return false;
        HashObject that = (HashObject) compared;
        return key.equals(that.key);
    }

    @Override
    public String toString()
    {
        return "Key: " + key + ", Frequency: " + frequency + ", Probe Count: " + probeCount;
    }

}