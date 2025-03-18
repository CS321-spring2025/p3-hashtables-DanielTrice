/*
 * Author: Daniel Trice
 * Date: 3/17/2025
 * HashObject contains a generic key object (declared as Object key)
 * Frequency count (to count duplicates), and probe count.  
 * Overrides both the equals and the toString methods
 */
public class HashObject
{
    //instance variables
    private Object key;
    private int frequency;
    private int probeCount;
    
    /**
     * Constructs a new HashObject with the specified key.
     * The frequency is initialized to 1, and the probe count is initialized to 0.
     * 
     * @param key the key associated with this HashObject
     */
    public HashObject(Object key)
    {
        this.key = key;
        this.frequency = 1; 
        this.probeCount = 0; 
    }

     /**
     * Returns the hash code for this HashObject.
     *
     * @return the hash code of the key
     */
    @Override
    public int hashCode() 
    {
        return key.hashCode();  
    }


    /**
     * Returns the key associated with this HashObject.
     * 
     * @return the key
     */
    public Object getKey()
    {
        return this.key;
    }

    /**
     * Returns the frequency count of this HashObject.
     * 
     * @return the frequency count
     */
    public int getFrequency() {
        return frequency;
    }
    
     /**
     * Increments the frequency count of this HashObject by 1.
     */
    public void incrementFrequency() 
    {
        frequency++;
    }

     /**
     * Sets the probe count for this HashObject.
     * 
     * @param newProbeCount the new probe count to set
     */
    public void setProbeCount(int newProbeCount) {
        probeCount = newProbeCount;
    }

     /**
     * Returns the probe count for this HashObject.
     * 
     * @return the probe count
     */
    public int getProbeCount() {
        return probeCount;
    }

    /**
     * Increments the probe count of this HashObject by 1.
     */
    public void incrementProbeCount() 
    {
        probeCount++;
    }
    
    /**
     * Compares one HashObject to another object.
     * HashObject instances are equal if they have the same key.
     *
     * @param comparedObj the object to compare this HashObject to
     * @return true if the compared object is a HashObject with the same key, false otherwise
     */

    @Override
    public boolean equals(Object comparedObj) 
    {
        if (comparedObj == null || !(comparedObj instanceof HashObject))
            return false;
        if (this == comparedObj)
            return true;
        HashObject comparedHash = (HashObject) comparedObj;
        return key.equals(comparedHash.key);
    }

     /**
     * Returns a string representation of this HashObject.
     * The string format is: key, frequency, probeCount.
     *
     * @return a string representation of this HashObject
     */
    @Override
    public String toString()
    {
        return key + " " + frequency + " " + probeCount;
    }

}