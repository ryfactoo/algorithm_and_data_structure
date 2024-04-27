package Igor.Banaszak;

public class Main {


    public static void main(String[] args) {
        TwoWayArrayLinkedList<String> twoWayArrayLinkedList = new TwoWayArrayLinkedList<>( 3);

        twoWayArrayLinkedList.add(0,"0");
        twoWayArrayLinkedList.add(1,"1");
        twoWayArrayLinkedList.add(2,"2");
        twoWayArrayLinkedList.add(3,"3");
        twoWayArrayLinkedList.add(4,"4");
        twoWayArrayLinkedList.add(5,"5");
        twoWayArrayLinkedList.add(6,"6");
        twoWayArrayLinkedList.add(7,"7");
        twoWayArrayLinkedList.add(8,"8");

//        System.out.println(twoWayArrayLinkedList.endCapacity());


        twoWayArrayLinkedList.remove(8);
        twoWayArrayLinkedList.remove(4);
        twoWayArrayLinkedList.remove(0);


        for (int i = 0; i< twoWayArrayLinkedList.size(); i++) {
            System.out.println(twoWayArrayLinkedList.get(i));
        }

        twoWayArrayLinkedList.defragment();
//        twoWayArrayLinkedList.remove(1);
//        twoWayArrayLinkedList.remove(2);
//        twoWayArrayLinkedList.remove(0);
//        twoWayArrayLinkedList.remove(0);
//        twoWayArrayLinkedList.remove(0);

        System.out.println(twoWayArrayLinkedList.endCapacity());
        System.out.println(twoWayArrayLinkedList.capacity());


//        System.out.println(twoWayArrayLinkedList.set(0,"10"));
//        System.out.println(twoWayArrayLinkedList.indexOf("2"));
//        System.out.println(twoWayArrayLinkedList.isEmpty());

        for (int i = 0; i< twoWayArrayLinkedList.size(); i++) {
            System.out.println(twoWayArrayLinkedList.get(i));
        }


//
//        twoWayArrayLinkedList.remove("8");
//        twoWayArrayLinkedList.remove("7");
//
//        System.out.println(twoWayArrayLinkedList.contains("5"));
//
//        twoWayArrayLinkedList.remove("5");
//
//        System.out.println(twoWayArrayLinkedList.contains("5"));
//
//        twoWayArrayLinkedList.remove("4");
//        twoWayArrayLinkedList.remove("6");
//        twoWayArrayLinkedList.remove("3");
//        twoWayArrayLinkedList.remove("2");
//        twoWayArrayLinkedList.remove("1");
//        twoWayArrayLinkedList.remove("10");
//
//
//
//
//        for (int i = 0; i< twoWayArrayLinkedList.size(); i++) {
//            System.out.println(twoWayArrayLinkedList.get(i));
//        }

//        System.out.println(twoWayArrayLinkedList);



//        TwoWayArrayLinkedList twoWayArrayLinkedList2 = new TwoWayArrayLinkedList(3);
//
//        for (int i = 0; i < 10;i++) {
//            twoWayArrayLinkedList2.add(i);
//        }
//
//        twoWayArrayLinkedList2.remove(8);
//        twoWayArrayLinkedList2.remove(5);
//        twoWayArrayLinkedList2.remove(2);
//
//        for (int i = 0; i < twoWayArrayLinkedList2.size() ; i++) {
//            System.out.println(twoWayArrayLinkedList2.get(i));
//        }
//
//        System.out.println(twoWayArrayLinkedList2.endCapacity());
//        System.out.println(twoWayArrayLinkedList2.capacity());
    }
}

