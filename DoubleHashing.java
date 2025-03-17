public class DoubleHashing extends HashTable { 

    public DoubleHashing(int capacity)
    {
        super(capacity);
    }

    public int h(Object key, int probe)
    {
        int h1 = positiveMod(key.hashCode(), this.capacity);
        int h2 = 1 + positiveMod(key.hashCode(), this.capacity - 2);
        return positiveMod(h1 + probe * h2, this.capacity);
    }
}