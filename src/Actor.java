import java.util.LinkedList;

public class Actor {

    private String name;
    private Actor next;

    public Actor() {
        this.next = null;
    }

    public Actor(String name) {
        this.name = name;
        this.next = null;

    }

    public String getName() {
        return name;
    }

    public Actor getNext() {
        return next;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNext(Actor next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if(next != null) {
            return "name: " + name + ", next: " + next.getName();
        }
        else{
            return "name: " + name + ", next: none";
        }
    }

}
