/**
 * The DoubleHashing class extends the HashTable class and implements the double hashing functionality
 * Double hashing uses two hash functions to resolve collisions. The first hash function is used
 * to calculate the initial index. If a collision occurs, a second hash function is applied to
 * calculate an next potential location.
 */
public class DoubleHashing extends HashTable { 

    /**
     * Constructs a DoubleHashing hash table with the specified capacity.
     * This constructor invokes the parent class's constructor with the provided capacity value.
     *
     * @param capacity the capacity of the hash table
     */
    public DoubleHashing(int capacity)
    {
        super(capacity);
    }

      /**
     * Calculates the hash value for the given key using the double hash probing.
     * The method calculates the first hash value (h1) for the key and then calculates a second hash value (h2).
     * If a collision occurs, h2 is used to compute the next index in the hash table. 
     *
     * @param key the key to hash
     * @param probe the current probe count
     * @return the index in the hash table where the key should be inserted
     */
    public int h(Object key, int probe)
    {
        int h1 = positiveMod(key.hashCode(), capacity);
        int h2 = 1 + positiveMod(key.hashCode(), capacity - 2);
        return positiveMod(h1 + probe * h2, capacity);
        
    }
}