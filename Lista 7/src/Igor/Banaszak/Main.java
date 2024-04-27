package Igor.Banaszak;

import Igor.Banaszak.Comparator.ComparatorIntiger;
import Igor.Banaszak.Comparator.ComparatorStudent;
import Igor.Banaszak.HashFunction.HashFunction10000;
import Igor.Banaszak.HashFunction.HashFunctionStudent;
import Igor.Banaszak.HashTable.OpenAddressingHashTable;
import Igor.Banaszak.IncrementalFunctionLine.InceremntalFunctionLine;
import Igor.Banaszak.IncrementalFunctionLine.InceremntalFunctionQuadratic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        OpenAddressingHashTable openAddressingHashTable = new OpenAddressingHashTable(0.5,new ComparatorStudent(),new HashFunctionStudent(),new InceremntalFunctionLine());



        for (int i = 0 ; i < 2 ; i++) {
            List list = new ArrayList<Integer>();
            list.add(i);
            openAddressingHashTable.insert(new Student("Banaszak" , "Igor" , 20, (ArrayList) list));
        }

        List list = new ArrayList<Integer>();
        list.add(10);
        openAddressingHashTable.insert(new Student("Banaszak" , "Igor22" , 20, (ArrayList) list));

//        System.out.println(openAddressingHashTable.lookUp(-20));

        System.out.println(openAddressingHashTable.statics());

//        System.out.println();
        System.out.println(openAddressingHashTable);
//        System.out.println(openAddressingHashTable.size());
//        System.out.println(openAddressingHashTable.capacity());
//
//        System.out.println(openAddressingHashTable.collisions());
//        System.out.println(openAddressingHashTable.insertComparisons());
//        System.out.println(openAddressingHashTable.lookUpComparisons());
//        System.out.println(openAddressingHashTable.hashFunctionEvaluations());





//        SeparateChainingHashTable separateChainingHashTable = new SeparateChainingHashTable(0.1,new ComparatorIntiger(),new HashFunction10000());
//
//        separateChainingHashTable.insert(5);
//        separateChainingHashTable.insert(105);
//        separateChainingHashTable.insert(1005);
//        separateChainingHashTable.insert(1105);
//        separateChainingHashTable.insert(1705);
//        separateChainingHashTable.insert(78);
//        separateChainingHashTable.insert(51);
//        separateChainingHashTable.insert(22);
//        separateChainingHashTable.insert(81);
//        separateChainingHashTable.insert(71);
//

//        for (int i = 0 ; i < 500 ; i++) {
//            separateChainingHashTable.insert(random.nextInt());
//        }

//        System.out.println(separateChainingHashTable.lookUp(74));
//        System.out.println(separateChainingHashTable);
//        System.out.println(separateChainingHashTable.statics());




    }
}
