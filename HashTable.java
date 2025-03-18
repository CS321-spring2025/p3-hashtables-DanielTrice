import java.io.FileNotFoundException;

/**
 * Author: Daniel Trice
 * Date: 3/17/2025
 * Abstract class representing a hash table.
 * Contains methods for inserting, searching, and dumping data from the hash
 * table.
 */
public abstract class HashTable {
    // instance variables
    protected HashObject[] table;
    protected int capacity;
    protected int tableSize;

    /**
     * Constructor to initialize the hash table with a given capacity.
     *
     * @param capacity the capacity of the hash table.
     */
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new HashObject[capacity];
        this.tableSize = 0;
    }

    /**
     * Abstract method for hashing the key. This must be implemented by subclasses.
     *
     * @param key   the key to hash.
     * @param probe the current probe count.
     * @return the computed index for the given key.
     */
    public abstract int h(Object key, int probe);

    /**
     * Computes a positive modulus to ensure the result is not negative.
     *
     * @param dividend the number to divide.
     * @param divisor  the divisor.
     * @return the positive modulus.
     */
    protected int positiveMod(int dividend, int divisor) {
        int quotient = dividend % divisor;
        return (quotient < 0) ? quotient + divisor : quotient;
    }

    /**
     * Inserts a hash object into the hash table.
     * If a duplicate is found, the frequency of the object is incremented.
     *
     * @param obj the hash object to insert.
     * @return true if the object was successfully inserted, false if it was a
     *         duplicate.
     */
    public boolean HashInsert(HashObject obj) {
        for (int probe = 0; probe < capacity; probe++) // probe list
        {
            int index = h(obj.getKey(), probe);// initial hash
            if (table[index] == null) // index is emoty, insert
            {
                obj.setProbeCount(probe + 1);
                table[index] = obj;
                tableSize++;
                return true;
            } else if (table[index].equals(obj)) // index contains duplicate
            {
                table[index].incrementFrequency();
                return false;
            }
        }
        return false; // full list
    }

    /**
     * Searches for a HashObject in the hash table using the key.
     * If the key is found, the object containing it is returned.
     *
     * @param key the key to search for.
     * @return the HashObject associated with the key
     */
    public HashObject HashSearch(Object key) {
        for (int i = 0; i < capacity; i++) {
            int hashIndex = h(key, i);
            if (table[hashIndex] == null)
                return null;
            if (table[hashIndex].getKey().equals(key))
                return table[hashIndex];
        }
        return null;
    }

    /**
     * Writes the contents of the hash table to a file.
     *
     * @param fileName the name of the file to write to.
     */
    public void dumpToFile(String fileName) {
        java.io.PrintWriter pWriter;
        try {
            pWriter = new java.io.PrintWriter(fileName);
            for (int i = 0; i < capacity; i++) {
                if (table[i] != null)
                    pWriter.println("table[" + i + "]: " + table[i]);
            }
            pWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the number of elements in the hash table.
     *
     * @return the number of elements in the hash table.
     */
    public int gettableSize() {
        return tableSize;
    }
}