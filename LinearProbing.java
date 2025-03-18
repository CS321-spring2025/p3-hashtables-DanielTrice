/**
 * Author: Daniel Trice
 * Date: 3/17/2025
 * The LinearProbing class extends the HashTable class and implements the linear probing hash functionality
 * Linear probing works by checking the next slot in the table if the initial hash location is 
 * already occupied. This continues until an empty slot is found or the table is full.
 */
public class LinearProbing extends HashTable
{   
     /**
     * Constructs a LinearProbing hash table with the specified capacity.
     * This constructor invokes the parent class's constructor with the provided capacity value.
     *
     * @param capacity the capacity of the hash table
     */
    public LinearProbing(int capacity)
    {
        super(capacity);
    }

    /**
     * Calculates the hash value for the given key, using linear probing
     * The method calculates the initial hash of the key, then probes accouringly.
     * @param key key to hash
     * @param probe current probe count
     * @return the index in the hash table where the key should be inserted 
     */
    public int h(Object key, int probe)
    {
        int newProbe = positiveMod(key.hashCode(), capacity);
        return positiveMod(newProbe + probe, capacity); //return the correct location
    }
    
}