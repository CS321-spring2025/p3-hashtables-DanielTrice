public class LinearProbing extends HashTable
{ 
    public LinearProbing(int capacity)
    {
        super(capacity);
    }

    public int h(Object key, int probe)
    {
        int keyHash = key.hashCode() + probe;
        int newProbe = positiveMod(keyHash, this.capacity);
        return newProbe; //return the correct location

        // h1(key) = positiveMod (key.hashCode(), tablesize);
        // h2(key) = 
    }
}