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

    public void removeAsStack() {
        head = head.getNext();
        count--;
    }

    public void removeAsQueue() {
        Node current = head;
        for(int i = 0;i < count-2;i++){
            current = current.getNext();
        }
        current.setNext(null);
        count--;
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

    Object indexOf(Object data) {
        Node current = head;
        for(int i = 0;i < count;i++){
            if(current.get() == data){
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{");
        for(int i = 0; i < this.size();i++){
            out.append(this.get(i));
            out.append(", ");
        }
        out.append("}");
        return out.toString();
    }
}
