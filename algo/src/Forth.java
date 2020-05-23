public class Forth {
    
    public static void main(String[] args) {
        MyList myList = new MyList();
        
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(10);
        myList.add(11);
    
//        System.out.println(myList.find(3));
//        System.out.println(myList.find(1));
//        System.out.println(myList.find(2));
//        System.out.println(myList.find(4));
//        System.out.println(myList.find(4));
    
        System.out.println("Before: ");
        myList.print();
//        myList.findAndRemove(3);
        System.out.println("After: ");
        myList.print();
        myList.printReverse();
    }
}

