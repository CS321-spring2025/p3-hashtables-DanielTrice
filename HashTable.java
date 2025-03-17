public abstract class HashTable
{
    protected int tableSize;
    protected int capacity;

    protected HashObject[] table;
    
    public HashTable(int capacity)
    {
        this.capacity = capacity;
        this.table = new HashObject[capacity];
        this.tableSize = 0;
    }

    public abstract int h(Object key, int probe);
    
    public int HashSearch(Object key)
    {
        for(int i = 0;i < capacity; i++)
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
        if (tableSize >= capacity) {
            System.out.println("Hash table overflow - Table is full!");
            return -1; // Table is full, cannot insert
        }

        int i = 0;
        while(i < capacity) //probing until spot is found
        {
            int probe = h(newObj.getKey(), i);
            newObj.incrementProbeCount();  // Increment probe count for each probe
            
            if (table[probe] == null) {
                table[probe] = newObj;
                tableSize++;
                return probe;
            }
            else if (table[probe].equals(newObj)) {  // Same object
                table[probe].incrementFrequency();
                return 0;
            }
            else {  // Spot taken, not by same key object
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

    public int getTableSize()
    {
        return this.tableSize;
    }
        
    
}