public class LinearProbing extends HashTable { 

    public LinearProbing(int capacity, double loadFactor)
    {
        super(capacity,loadFactor);
    }

    public int h(Object key, int probe)
    {
        Object hashKey = key.hashCode();
        //see if spot is open
        //if not linear probe
        return 0; //return the correct location
    }
}