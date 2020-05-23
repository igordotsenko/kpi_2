import java.util.TreeSet;

public class MyTree {
    private Node root;
    
    public void add(Integer value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        put(root, value);
    }
    
    private void put(Node root, Integer value) {
        if (root.getValue().equals(value)) {
            return;
        }
        
        if (root.getValue() > value) {
            if (root.getPrev() == null) {
                root.setPrev(new Node(value));
                return;
            }
            put(root.getPrev(), value);
        } else {
            if (root.getNext() == null) {
                root.setNext(new Node(value));
                return;
            }
            put(root.getNext(), value);
        }
    }  
    
    public Integer getMax() {
        if (root == null) {
            return null;
        }
        return findMax(root).getValue();
    }
    
    public Integer getMin() {
        if (root == null) {
            return null;
        }
        return findMin(root).getValue();
    }
    
    private Node findMax(Node node) {
        if (node.getNext() == null) {
            return node;
        } else {
            return findMax(node.getNext());
        }
    }
    
    private Node findMin(Node node) {
        if (node.getPrev() == null) {
            return node;
        } else {
            return findMin(node.getPrev());
        }
    }
    
    public void multiplyMax() {
        if (root == null) {
            return;
        }
        
        Node node = findMax(root);
        node.setValue(node.getValue()*2);
    }
    
    public void multiplyMin() {
        if (root == null) {
            return;
        }
        
        Node node = findMin(root);
        node.setValue(node.getValue()*2);
    }
}
