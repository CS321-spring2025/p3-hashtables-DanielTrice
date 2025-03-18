import java.io.*;
import java.util.*;

/**
* Author: Daniel Trice
 * Date: 3/17/2025
 * This class performs an experiment using our hashtable with different both linear and double hashing.
 * It supports data insertion of random numbers, Long Date values, or words from a file.
 * Uses a twin prime number for determining the size of the hash table.
 * 
 * Command-line arguments for the user to specify the data type, load factor, and the debug level.
 */
public class HashtableExperiment {


    /**
     * Main method of the program. Validates input arguments, generates 
     * hash tables, and runs hash table experiments using linear probing 
     * and double hashing techniques.
     *
     * @param args command-line arguments: <dataType>, <loadFactor>, <debugLevel>
     * 
     * @throws Exception Throws exception if file is not found
     */
    public static void main(String[] args) throws Exception 
    {
        if (args.length < 2 || args.length > 3) 
        {
            printUsage();
            return;
        }

        int dataType = Integer.parseInt(args[0]);
        double loadFactor = Double.parseDouble(args[1]);
        int debugLevel = args.length == 3 ? Integer.parseInt(args[2]) : 0;
        int tableSizePrime = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
        int amtElements = (int) Math.ceil(loadFactor * tableSizePrime);

        // prints table information
        System.out.println("HashtableExperiment: Found a twin prime table capacity: " + tableSizePrime);
        System.out.println("HashtableExperiment: Input: " + dataTypeString(dataType) + "   Loadfactor: " + loadFactor + "\n");


        //Linear Probing
        hashSimulation(new LinearProbing(tableSizePrime),amtElements, dataType, debugLevel, "Linear Probing", "linear-dump.txt");

        // Double Hashing
        hashSimulation(new DoubleHashing(tableSizePrime),amtElements , dataType, debugLevel, "Double Hashing", "double-dump.txt");
    }


    /**
     * Runs the hash table simulation using the specified probing method,
     * inserting elements and recording statistics like total probes and duplicates.
     * if debug level is 1, a dump of both hash tables are saved to a file.
     *
     * @param hashTable the hash table object to use for insertion
     * @param amtElements the number of elements to insert
     * @param dataType the type of data to insert 1 = random, 2 = date, 3 = word list
     * @param debug the debug level 0 = summary, 1 = file dump, 2 = detailed debug
     * @param probingType a string to describe the probing technique used 
     * @param dumpFileName the file name to dump the hash table if required
     */
    private static void hashSimulation(HashTable hashTable, int amtElements, int dataType,int debug, String probeType, String dumpFileName)
    {

        int duplicates = 0;
        long totalProbes = 0;
        int insertedCount = 0;

        System.out.println("\tUsing " + probeType);

        if (dataType == 1 || dataType == 2) //table holds int or Date
        {
            Object[] dataList = dataGenerator(dataType, amtElements * 2); //generate either 

            for (Object item : dataList) 
            {
                HashObject obj = new HashObject(item);
                boolean inserted = hashTable.HashInsert(obj);
                if (inserted) {
                    totalProbes += obj.getProbeCount();
                    insertedCount++;
                    if (debug == 2) System.out.println("Inserted: " + obj);
                } else {
                    duplicates++;
                    if (debug == 2) System.out.println("Duplicate found: " + obj.getKey());
                }
                if (insertedCount >= amtElements) break;
            }
        } 
        else //table holds strings
        { 
            Scanner scan;
            try {
                scan = new Scanner(new File("word-list.txt"));
                while (scan.hasNextLine()) 
                {
                    HashObject obj = new HashObject(scan.nextLine());
                    boolean inserted = hashTable.HashInsert(obj);
                    if (inserted) 
                    {
                        totalProbes += obj.getProbeCount();
                        insertedCount++;
                        if (debug == 2) System.out.println("Inserted: " + obj);
                    } else 
                    {
                        duplicates++;
                        if (debug == 2) System.out.println("Duplicate found: " + obj.getKey());
                    }
                    if (insertedCount >= amtElements)
                    {
                        break;
                    }
                }  
                scan.close(); 
            } 
            catch (FileNotFoundException e) 
            {
                e.printStackTrace();
            }
        }

        double avgProbes = (double) totalProbes / insertedCount; //get avg probes

        //print hashtable data after insertions
        System.out.println("HashtableExperiment: size of hash table is " + insertedCount);
        System.out.println("\tInserted " + (insertedCount + duplicates) + " elements, of which " + duplicates + " were duplicates");
        System.out.printf("\tAvg. no. of probes = %.2f \n", avgProbes);

        if (debug == 1) {
            hashTable.dumpToFile(dumpFileName);
            System.out.println("HashtableExperiment: Saved dump of hash table\n");
        } else {
            System.out.println();
        }
    }

    /**
     * Generates a list of data objects based on the specified data type, int or Date
     *
     * @param sourceType the type of data to generate
     * @param amtElements the number of elements to generate
     * @return array of generated data objects
     */
    private static Object[] dataGenerator(int sourceType, int amtElements)
    {
        Object[] data = new Object[amtElements];
        switch (sourceType) 
        {
            case 1: 
                Random rand = new Random(); //random integers
                for (int i = 0; i < amtElements; i++)
                    data[i] = rand.nextInt(); //insert new random int
                break;
            case 2: 
                long current = new Date().getTime(); //Date value
                for (int i = 0; i < amtElements; i++) 
                {
                    data[i] = new Date(current); //insert new Date object
                    current += 1000; //increment time
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid data source type."); //input type doesnt match
        }
        return data;
    }

    /**
     * Prints usage instructions for the program.
     */
    private static void printUsage() 
    {
        System.out.println("Usage: java HashtableExperiment <dataType> <loadFactor> [<debugLevel>]");
        System.out.println("\t<dataType>: 1 ==> random numbers");
        System.out.println("\t              2 ==> date value as a long");
        System.out.println("\t              3 ==> word list");
        System.out.println("\t<loadFactor>: Ratio of objects to table size (alpha = n/m)");
        System.out.println("\t<debugLevel>: 0 ==> print summary");
        System.out.println("\t              1 ==> dump hash tables to files at end");
        System.out.println("\t              2 ==> print detailed debugging for each insert");
    }

    /**
     * Converts the data type integer value to a string representation.
     *
     * @param sourceType the data type integer
     * @return a string representation of the data type
     */
    private static String dataTypeString(int sourceType) //returns string representation of data type input
    {
        switch (sourceType) 
        {
            case 1: return "Random Numbers";
            case 2: return "Date Values";
            case 3: return "Word-List";
            default: return "Unknown";
        }
    }

}
