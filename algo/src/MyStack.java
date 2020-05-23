public class MyStack {
    private MyList elements = new MyList();
    private MyList minStack = new MyList();
    private MyList maxStack = new MyList();
    private int size = 0;
    
    public void push(Integer value) {
        elements.add(value);
        
        if (minStack.getLast() == null) {
            minStack.add(value);
            maxStack.add(value);
        } else {
            if (minStack.getLast() >= value) {
                minStack.add(value);
            }
            if (maxStack.getLast() <= value) {
                maxStack.add(value);
            }
        }
        size += 1;
    }
    
    public Integer pop() {
        Integer value = elements.removeLast();
        if (minStack.getLast() != null && minStack.getLast().equals(value)) {
            minStack.removeLast();
        }
        if (maxStack.getLast() != null && maxStack.getLast().equals(value)) {
            maxStack.removeLast();
        }
        if (size > 0) {
            size -= 1;
        }
        return value;
    }
    
    public void print() {
        elements.print();
    }
    
    public Integer average() {
        if (minStack.getLast() != null && maxStack.getLast() != null) {
            return (maxStack.getLast() + minStack.getLast()) / 2;
        }
        return null;
    }
    
    public int getSize() {
        return size;
    }
}
