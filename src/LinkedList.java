import java.util.NoSuchElementException;

@SuppressWarnings("WeakerAccess")
public class LinkedList {

    private Node head;
    private int count;

    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    public void add(Object data) {
        Node tempHead = this.head;
        this.head = new Node(data);
        head.setNext(tempHead);

        count++;
    }

    Object get(int index) {
        Node current = head;
        for(int i = 0;i < count;i++){
            if(i == index){
                return current.get();
            }
            current = current.getNext();
        }
        throw new NoSuchElementException("value at index " + index + " doesn't exist");
    }

    int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < this.size();i++){
            out.append(this.get(i));
            out.append(", ");
        }
        return out.toString();
    }
}
