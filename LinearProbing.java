public class LinearProbing extends HashTable { 

    public LinearProbing(int capacity, double loadFactor)
    {
        super(capacity,loadFactor);
    }

    public int h(Object key, int probe)
    {
        Object hashKey = key.hashCode();
        //see if spot is open
        //if not linear probe
        return 0; //return the correct location
    }

    public int HashSearch(HashObject[] table, Object key)
    {
        int i = 0;
        LinearProbing probe = new LinearProbing();
        while (T[probe]);
    }

    public int HashInsert(HashObject[] table, Object key)
    {
        
    }
    
}