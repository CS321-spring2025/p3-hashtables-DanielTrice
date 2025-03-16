public abstract class HashTable
{
    protected int tableSize;
    protected int capacity;
    protected double loadFactor;
    protected HashObject[] table;
    
    public HashTable(int capacity, double loadFactor)
    {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = new HashObject[capacity];
        // this.tableSize = TwinPrimeGenerator(capacity, capacity); 
    }

    public abstract int h(Object key, int probe);
    
    public int HashSearch(Object key)
    {
        
        for(int i = 0;i < tableSize; i++)
        {
            int probe = h(key, i);
            if(this.table[probe] == null)
            {
                return -1;
            }
            if(this.table[probe].getKey().equals(key))
            {
                return probe;
            }
        }   
        System.out.println("Not found");
        return -1;
    }

    public int HashInsert(HashObject newObj)
    {
        int i = 0;
        while(i < tableSize)
        {
            int probe = h(newObj.getKey(), i);
            if(this.table[probe] == null)
            {
                this.table[probe] = newObj;
                this.tableSize ++;
                return probe;
            }
            else
            {
                newObj.incrementProbeCount();
                probe++;
                i++;
            }
        }
        System.out.println("hash table overflow");
        return -1;
    }

  
    public void dumpToFile(String fileName) throws Exception {
        java.io.PrintWriter out = new java.io.PrintWriter(fileName);
        for (int i = 0; i < tableSize; i++) {
            if (table[i] != null)
                out.println("table[" + i + "]: " + table[i]);
        }
        out.close();
    }

    protected int positiveMod (int dividend, int divisor) 
    {
        int quotient = dividend % divisor;
        if (quotient < 0)
        quotient += divisor;
        return quotient;
    }
        
}