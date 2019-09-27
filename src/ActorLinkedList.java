import java.util.NoSuchElementException;

public class ActorLinkedList {

    private Actor head;
    private int count;

    public ActorLinkedList() {
        this.head = null;
        this.count = 0;
    }

    public void add(Actor head) {
        Actor tempHead = this.head;
        this.head = head;
        head.setNext(tempHead);

        count++;
    }

    public Actor get(int index) {
        Actor current = head;
        for(int i = 0;i < count;i++){
            if(i == index){
                return current;
            }
            current = current.getNext();
        }
        throw new NoSuchElementException("value at index " + index + " doesn't exist");
    }


    public int size() {
        return count;
    }
}
