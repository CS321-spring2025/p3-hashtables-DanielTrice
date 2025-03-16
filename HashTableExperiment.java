public class HashTableExperiment
{
    public static void Main(String[] args)
    {
        /*
         *  Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]
            <dataSource>: 1 ==> random numbers
                     2 ==> date value as a long
                     3 ==> word list
            <loadFactor>: The ratio of objects to table size, 
                       denoted by alpha = n/m
            <debugLevel>: 0 ==> print summary of experiment
                     1 ==> save the two hash tables to a file at the end
                     2 ==> print debugging output for each insert

         */


        public void dumpToFile(String fileName) {
     PrintWriter out = new PrintWriter(fileName);
     // loop through the hash table, and print non-null entries 
     // using toString() method in the HashObject class
    out.close();
}
    }
}