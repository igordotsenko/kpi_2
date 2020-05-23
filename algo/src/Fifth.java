import java.util.Stack;

public class Fifth {
    
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        
        stack.push(9);
        stack.push(5);
        stack.push(2);
        stack.push(5);
        stack.push(8);
        stack.push(1);
    
//        stack.print();
//    
//        stack.pop();
        System.out.println();
        System.out.println(stack.average());
        System.out.println();
        
        int size = stack.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
//            stack.pop();
        }
//        stack.print();
//    
//        stack.print();
//        stack.push(6);
//        stack.print();
    
//        System.out.println();
//        System.out.println(stack.average());
    }
    
}
