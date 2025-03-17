public class LinearProbing extends HashTable
{ 
    public LinearProbing(int capacity)
    {
        super(capacity);
    }

    public int h(Object key, int probe)
    {
        int keyHash = key.hashCode();
        int newProbe = positiveMod(keyHash + probe, this.capacity);
        return newProbe; //return the correct location

    }
    
}