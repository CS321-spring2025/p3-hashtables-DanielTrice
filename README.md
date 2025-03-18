# Project #: Project Name

* Author: Daniel Trice
* Class: CS321 Section #002
* Semester: Spring


## Overview

This program is an implementation of a Hash Table and can store either string data, integer data, or long Date data. Uses linear and double hashing to create two seperate hashtables containing the data from the user input choice. The user can choose to have debug level 1 or 2, 1 printing both tables to dump files and 2 displaying each item when it is attempting to add. Telling the user if it is inserted or a duplicate.

## Reflection

This was a very difficult lab for me for some reason. I think i understand the concept of the hash table fairly well but implementing it in code was a struggle for me. I think the reason for this was because I dont have much experiance with the simulation file, which is where I struggled the most. I also was having an off by one issue with only certain members of the data. The frequency was being increased by one too many. I belive this was caused by the equals method not accounting for the possibility that two distinct objects may return the same hash value. 

I think the testing script was much easier to implement than any I have done before. I dont have much experiance using thi stesting format buit I think it is much more intuitive than doing it in a java file like I have previously done. Overall I think that this assigment gave me a better understanding of hash tables as a whole. This program was tested using the run-tests script which tests differant input vales as load factors and tests to make sure results match corresponding given test cases.

## Compiling and Using

Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]
    <dataSource>    1 ==> random numbers
                    2 ==> date value as a long
                    3 ==> word list
    <loadFactor> Ratio of objects to table size (alpha = n/m)
    <debugLevel>    0 ==> print summary
                    1 ==> dump hash tables to files at end
                    2 ==> print detailed debugging for each insert

## Results 

|Load Factor    |Linear avg probe | Linear avg probe |
| ------------- |:---------------:| -----:           |
| 0.50          |1.60             |1.39|
| 0.60          |2.15             |1.53|
| 0.70          |3.60             |1.72|
| 0.80          |6.71             |2.02|
| 0.90          |19.81            |2.57|
| 0.95          |110.59           |3.19|
| 0.99          |471.67           |4.70|

## Sources used

Chat Gpt- java doc help / debugging


