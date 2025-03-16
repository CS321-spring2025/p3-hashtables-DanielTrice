public class LinearProbing extends HashTable { 

    public LinearProbing(int capacity, double loadFactor)
    {
        super(capacity,loadFactor);
    }

    public int h(Object key, int probe)
    {
        int newProbe = positiveMod(key.hashCode(), tablesize);
        return newProbe; //return the correct location

        // h1(key) = positiveMod (key.hashCode(), tablesize);
        // h2(key) = 1 + positiveMod (key.hashCode(), tablesize - 2);

    }

    public int HashSearch(HashObject[] table, Object key)
    {
        int i = 0;
        while(table[probe] != null && i != tableSize)
        {
            int probe = h(key, i);
            if(table[probe] == key)
            {
                return probe;
            }
            i++;
        }
        return null;
    }

    public int HashInsert(HashObject[] table, Object key)
    {
        int i = 0;
        while(i != tableSize)
        {
            int probe = h(key, i);
            if(table[probe] == null)
            {
                table[probe] = key;
                return probe;
            }
            else
            {
                i++;
            }
            System.out.println("hash table overtflow");
        }
    }
    
}