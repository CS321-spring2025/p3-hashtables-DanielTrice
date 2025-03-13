public class DoubleHashing extends HashTable { 

    public DoubleHashing(int capacity, double loadFactor)
    {
        super(capacity,loadFactor);
    }

    public int h(Object key, int probe)
    {
        Object hashKey = key.hashCode();
        //see if spot is open
        //if not double probe
        return 0; //return the correct location
    }

    public int HashSearch(HashObject[] table, Object key)
    {
        int i = 0;
        LinearProbing probe = new LinearProbing();
        while (table[probe]);
    }

    public int HashInsert(HashObject[] table, Object key)
    {
        return 0;
    }
    
}