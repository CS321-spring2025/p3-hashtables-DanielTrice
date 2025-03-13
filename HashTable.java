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
        this.table = Hashobject[capacity];
    }


    public abstract int h(Object key, int probe);
    
    private int LinearHashSearch(HashObject[] table, Object key)
    {
        int i = 0;
        LinearProbing probe = new LinearProbing();
        while (T[probe]);
    }

    private int linearHashInsert(HashObject[] table, Object key)
    {
        
    }
    
    protected int positiveMod (int dividend, int divisor) 
    {
        int quotient = dividend % divisor;
        if (quotient < 0)
        quotient += divisor;
        return quotient;
    }
        
}