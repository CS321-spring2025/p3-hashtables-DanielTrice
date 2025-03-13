public class DoubleHashing extends HashTable { 

    public DoubleHashing(int capacity, double loadFactor)
    {
        super(capacity,loadFactor);
    }

    public int h(Object key, int probe)
    {
        Object hashKey = key.hashCode();
        //see if spot is open
        //if not double probe
        return 0; //return the correct location
    }
}