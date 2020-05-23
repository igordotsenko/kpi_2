import java.util.LinkedList;
import java.util.StringJoiner;

public class MyList {
    private Node first;
    private Node last;
    
    public void add(Integer value) {
        Node newNode = last == null ? new Node(value) : new Node(value, last);
        if (last != null) {
            last.setNext(newNode);
        }
        last = newNode;
        if (first == null) {
            first = newNode;
        }
    }
    
    public Node find(Integer value) {
        if (first == null) {
            System.out.println("List is empty");
            return null;
        }
        Node current = first;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    
    public void findAndRemove(Integer value) {
        Node node = find(value);
        if (node == null) {
            return;
        }
        
        if (first == node) {
            Node next = first.getNext();
            swapNodes(next, next.getNext());
            first = node.getNext();
            return;
        }
        
        Node prev = node.getPrev();
        Node next = node.getNext();
        if (prev != null) {
            prev.setNext(next);
        } else {
            first = next;
        }
        if (next != null) {
            next.setPrev(prev);
            swapNodes(next, next.getNext());
        }
        
    }
    
    private void swapNodes(Node first, Node second) {
        Node firstPrev = first.getPrev();
        
        first.setPrev(second);
        first.setNext(second.getNext());
        
        second.setNext(first);
        second.setPrev(firstPrev);
        if (firstPrev != null) {
            firstPrev.setNext(second);
        }
    }
    
    public Integer removeLast() {
        if (last == null) {
            return null;
        }
        Node node = last;
        
        last = node.getPrev();
        if (node.getPrev() != null) {
            node.getPrev().setNext(null);
        }
        
        return node.getValue();
    }
    
    public Integer getLast() {
        return last != null ? last.getValue() : null;
    }
    
    public void print() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = first;
        while (current != null) {
            System.out.println("" + current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
    
    public void printReverse() {
        if (last == null) {
            return;
        }
        Node current = last;
        for (int i = 1; current != null; i++) {
            if (i % 3 == 0) {
                System.out.println(current.getValue());
            }
            current = current.getPrev();
        }
    }
}
