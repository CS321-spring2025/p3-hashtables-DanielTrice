public abstract class HashTable
{
    protected int tableSize;
    protected int capacity;
    protected double loadFactor;
    protected HashObject[] table;
    protected int tableSize;
    
    public HashTable(int capacity, double loadFactor)
    {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = new HashObject[capacity];
        tableSize = TwinPrimeGenerator(capacity, )
        
    }


    public abstract int h(Object key, int probe);
    
    public abstract int HashSearch(HashObject[] table, Object key);
   
    public abstract int HashInsert(HashObject[] table, Object key);
  
    protected int positiveMod (int dividend, int divisor) 
    {
        int quotient = dividend % divisor;
        if (quotient < 0)
        quotient += divisor;
        return quotient;
    }
        
}