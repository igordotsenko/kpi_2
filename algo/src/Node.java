public class Node {
    private Integer value;
    private Node prev;
    private Node next;
    
    public Node(Integer value, Node prev) {
        this.value = value;
        this.prev = prev;
    }
    
    public Node(Integer value) {
        this.value = value;
    }
    
    public void setNext(Node node) {
        next = node;
    }
    
    public Node getNext() {
        return next;
    }
    
    public Integer getValue() {
        return value;
    }
    
    public Node getPrev() {
        return prev;
    }
    
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    
    public void setValue(Integer value) {
        this.value = value;
    }
}
