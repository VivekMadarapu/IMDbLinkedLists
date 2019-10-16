@SuppressWarnings("WeakerAccess")
public class Node {
    private Object data;
    private Node next, prev;

    public Node() {
        this.data = null;
        this.next = null;
    }

    public Node(Object data) {
        this.data = data;
        this.next = null;

    }

    public Object get() {
        return data;
    }

    public void set(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        if(next != null) {
            return "data: " + data + ", next: " + next.get()+ ", prev: " + prev.get();
        }
        else{
            return "data: " + data + ", next: none";
        }
    }

}