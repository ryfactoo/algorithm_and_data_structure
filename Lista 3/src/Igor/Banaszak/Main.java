package Igor.Banaszak;

import java.io.IOException;

public class Main extends IOException {

    public static void main(String[] args)  {

        OneWayLinkedListWithSentinel oneWayLinkedListWithSentinel = new OneWayLinkedListWithSentinel();
//
        oneWayLinkedListWithSentinel.add(1);
        oneWayLinkedListWithSentinel.add(2);
        oneWayLinkedListWithSentinel.add(3);
        oneWayLinkedListWithSentinel.add(4);
        oneWayLinkedListWithSentinel.add(5);
        oneWayLinkedListWithSentinel.add(6);
        oneWayLinkedListWithSentinel.add(7);
        oneWayLinkedListWithSentinel.add(1,"B");
        oneWayLinkedListWithSentinel.set(0,"A");
//
//        System.out.println(oneWayLinkedListWithSentinel.get(1));
//        oneWayLinkedListWithSentinel.clear();
        System.out.println(oneWayLinkedListWithSentinel.isEmpty());
//        System.out.println(oneWayLinkedListWithSentinel.remove("kot"));
//        System.out.println(oneWayLinkedListWithSentinel.remove("A"));
//        System.out.println(oneWayLinkedListWithSentinel.get(0));

//        oneWayLinkedListWithSentinel.reverse();

        for (int i = 0 ; i<oneWayLinkedListWithSentinel.size();i++ ) {
            System.out.println(oneWayLinkedListWithSentinel.get(i));
        }


    }
}
