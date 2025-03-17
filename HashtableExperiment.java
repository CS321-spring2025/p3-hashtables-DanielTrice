
    // public static void Main(String[] args)
    // {
    //     /*
    //      *  Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]
    //         <dataSource>: 1 ==> random numbers
    //                  2 ==> date value as a long
    //                  3 ==> word list
    //         <loadFactor>: The ratio of objects to table size, 
    //                    denoted by alpha = n/m
    //         <debugLevel>: 0 ==> print summary of experiment
    //                  1 ==> save the two hash tables to a file at the end
    //                  2 ==> print debugging output for each insert

    //      */


 
import java.io.*;
import java.util.*;

public class HashtableExperiment {

    public static void main(String[] args) throws Exception 
        {
        if (args.length < 2 || args.length > 3) {
            usage();
            return;
        }

        int dataSource = Integer.parseInt(args[0]);
        double loadFactor = Double.parseDouble(args[1]);
        int debugLevel = args.length == 3 ? Integer.parseInt(args[2]) : 0; 

        int tableSize = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
        int numElements = (int) Math.ceil(loadFactor * tableSize) - 1;
        System.out.println("num of elements: " + numElements);
        System.out.println("HashtableExperiment: Found a twin prime table capacity: " + tableSize);
        System.out.println("HashtableExperiment: Input: " + inputSourceName(dataSource) + "   Loadfactor: " + loadFactor + "\n");

        // Linear Probing
        HashTable linearHash  = new LinearProbing(tableSize);
        runExperiment(linearHash, dataSource, numElements, debugLevel, "Linear Probing", "linear-dump.txt");

        // Double Hashing
        HashTable doubleHash  = new DoubleHashing(tableSize);
        runExperiment(doubleHash, dataSource, numElements, debugLevel, "Double Hashing", "double-dump.txt");
    }

    private static void runExperiment(HashTable hashTable, int source, int numElements, int debug, String probingType, String dumpFileName) throws Exception {
        int duplicates = 0;
        long totalProbes = 0;
        int insertedCount = 0;
    
        
        System.out.println("\tUsing " + probingType);
        
        if(source == 1 || source == 2) //input from random values
        {
            Object[] data = generateData(source, numElements);
    
            for (Object key : data) {
                HashObject obj = new HashObject(key);
                int inserted = hashTable.HashInsert(obj);
                if (inserted == 0) {  // Duplicate found
                    duplicates++;
                    if (debug == 2) System.out.println("Duplicate found: " + obj.getKey());
                } else {  // Successfully inserted
                    totalProbes += obj.getProbeCount();
                    insertedCount++;
                    if (debug == 2) System.out.println("Inserted: " + obj + "@" + inserted);
                }
        
                if (insertedCount >= numElements) break;  // Stop once we reach the desired number of insertions
            }
        }
        else //document input
        {  
            Scanner scan = new Scanner(new File("word-list.txt"));
            while(scan.hasNextLine())
            {
                HashObject obj = new HashObject(scan.nextLine());
                int inserted = hashTable.HashInsert(obj);
                if (inserted == 0) {  // Duplicate found
                    duplicates++;
                    if (debug == 2) System.out.println("Duplicate found: " + obj.getKey());
                } else {  // Successfully inserted
                    totalProbes += obj.getProbeCount();
                    insertedCount++;
                    if (debug == 2) System.out.println("Inserted: " + obj + "@" + inserted);
                }
                if (insertedCount >= numElements) break;
            }  
                scan.close();
        }

        double avgProbes = (double) totalProbes / insertedCount;
        System.out.println("HashtableExperiment: size of hash table is " + hashTable.getTableSize());
        System.out.println("\tInserted " + (insertedCount + duplicates) + " elements, of which " + duplicates + " were duplicates");
        System.out.printf("\tAvg. no. of probes = %.2f \n", avgProbes);
    
        if (debug == 1) {
            hashTable.dumpToFile(dumpFileName);
            System.out.println("HashtableExperiment: Saved dump of hash table\n");
        } else {
            System.out.println();
        }
    }

    private static Object[] generateData(int sourceType, int count) throws Exception {
        Object[] data = new Object[count];
        switch (sourceType) {
            case 1: // Random integers
                Random rand = new Random();
                for (int i = 0; i < count; i++)
                    data[i] = rand.nextInt();
                break;
            case 2: // Date as long
                long current = new Date().getTime();
                for (int i = 0; i < count; i++) {
                    data[i] = new Date(current);
                    current += 1000;
                }
                break;
            
            default:
                throw new IllegalArgumentException("Invalid data source type.");
        }
        return data;
    }

    private static String inputSourceName(int source) {
        switch (source) {
            case 1: return "Random Numbers";
            case 2: return "Date Values";
            case 3: return "Word-List";
            default: return "Unknown";
        }
    }

    private static void usage() {
        System.out.println("Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]");
        System.out.println("\t<dataSource>: 1 ==> random numbers");
        System.out.println("\t              2 ==> date value as a long");
        System.out.println("\t              3 ==> word list");
        System.out.println("\t<loadFactor>: Ratio of objects to table size (alpha = n/m)");
        System.out.println("\t<debugLevel>: 0 ==> print summary");
        System.out.println("\t              1 ==> dump hash tables to files at end");
        System.out.println("\t              2 ==> print detailed debugging for each insert");
    }
}
