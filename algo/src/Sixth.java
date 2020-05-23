public class Sixth {
    
    public static void main(String[] args) {
        MyTree myTree = new MyTree();
        
        myTree.add(3);
        myTree.add(7);
        myTree.add(1);
        myTree.add(4);
        myTree.add(-10);
        myTree.add(-1);
        myTree.add(2);
    
        System.out.println(myTree.getMax());
        System.out.println(myTree.getMin());
        
        myTree.multiplyMax();
        myTree.multiplyMin();
    
        System.out.println(myTree.getMax());
        System.out.println(myTree.getMin());
    }
}
