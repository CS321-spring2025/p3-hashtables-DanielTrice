public class DoubleHashing extends HashTable { 

    public DoubleHashing(int capacity, double loadFactor)
    {
        super(capacity,loadFactor);
    }

    public int h(Object key, int probe)
    {
        int h1 = positiveMod(key.hashCode(), tableSize);
        int h2 = 1 + positiveMod(key.hashCode(), tableSize - 2);
        return positiveMod(h1 + probe * h2, tableSize);
    }
}