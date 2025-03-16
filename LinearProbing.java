public class LinearProbing extends HashTable
{ 
    public LinearProbing(int capacity, double loadFactor)
    {
        super(capacity,loadFactor);
    }

    public int h(Object key, int probe)
    {
        int keyHash = key.hashCode() + probe % tableSize;
        int newProbe = positiveMod(keyHash, tableSize);
        return newProbe; //return the correct location

        // h1(key) = positiveMod (key.hashCode(), tablesize);
        // h2(key) = 
    }
}