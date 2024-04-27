package Igor.Banaszak;


public class Main {

    public static void main(String[] args) {

//        HeapyBinarySearchTree heapyBinarySearchTree = new HeapyBinarySearchTree(new ComparatorIntiger());
//        BST bst = new BST(new ComparatorIntiger());
//
//        ArrayList arrayList = new ArrayList();
//        int j;
//
//        Random random = new Random();
//
//        for (int i = 0 ; i < 100000; i++) {
//            arrayList.add(i);
//        }
//
//        Collections.shuffle(arrayList);
//
//        for (int i = 0 ; i < 100000; i++) {
//            heapyBinarySearchTree.add(arrayList.get(i));
//            bst.add(arrayList.get(i));
//        }
//
//        Collections.shuffle(arrayList);
//
//        for (int i = 0 ; i < arrayList.size() ; i++) {
//            heapyBinarySearchTree.remove(arrayList.get(i));
//            bst.remove((Integer) arrayList.get(i));
//        }




        Test test = new Test(100000,new ComparatorIntiger(),10);
        test.test();


//        Test test = new Test(5000,new ComparatorIntiger(),5);
//        test.testSorted();

//        Timer.start(100000,10);

    }
}
