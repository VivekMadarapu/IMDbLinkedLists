public class ListTester {

    public static void main(String[] args) {
        ActorLinkedList actorList = new ActorLinkedList();

        actorList.add(new Actor("James"));
        actorList.add(new Actor("Mary"));
        actorList.add(new Actor("Derek"));

        for(int i = 0; i < 3;i++){
            System.out.println(actorList.get(i));

        }

        System.out.println(actorList.get(0).getName());

    }
}
