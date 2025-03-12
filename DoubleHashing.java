public class DoubleHashing extends HashTable { 

    public DoubleHashing(int capacity, double loadFactor)
    {
        super(capacity,loadFactor);
    }

    public int h(Object key, int probe)
    {
        return 0;
    }
}