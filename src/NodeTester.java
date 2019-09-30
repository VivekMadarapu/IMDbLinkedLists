public class NodeTester {

    public static void main(String[] args) {

        Actor actor = new Actor("James");
        Node node = new Node(actor);

        Actor actor1 = new Actor("Mary");
        Node node1 = new Node(actor1);
        node.setNext(node1);

        Actor actor2 = new Actor("Jordan");
        Node node2 = new Node(actor2);
        node1.setNext(node2);

        Actor actor3 = new Actor("Garry");
        Node node3 = new Node(actor3);
        node2.setNext(node3);

        Actor actor4 = new Actor("Frost");
        Node node4 = new Node(actor4);
        node3.setNext(node4);

        Actor actor5 = new Actor("Karen");
        Node node5 = new Node(actor5);
        node4.setNext(node5);

        Node current = node;
        while(current != null){
            System.out.println(current);
            current = current.getNext();
        }
        System.out.println(((Actor) node.get()).getName());

    }

}
