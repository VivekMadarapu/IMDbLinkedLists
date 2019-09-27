public class NodeTester {

    public static void main(String[] args) {

        Actor actor = new Actor("James");

        Actor actor2 = new Actor("Mary");
        actor.setNext(actor2);
        Actor actor3 = new Actor("Jordan");
        actor2.setNext(actor3);
        Actor actor4 = new Actor("Garry");
        actor3.setNext(actor4);
        Actor actor5 = new Actor("Frost");
        actor4.setNext(actor5);
        Actor actor6 = new Actor("Karen");
        actor5.setNext(actor6);


        Actor current = actor;
        while(current.getNext() != null){
            System.out.println(current);
            current = current.getNext();
        }
    }

}
