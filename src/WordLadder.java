import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class WordLadder {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File("input.txt"));

        HashSet<String> dict = new HashSet<>();

        Scanner file2 = new Scanner(new File("dictionary.txt"));
        while(file2.hasNext()){
            dict.add(file2.nextLine());
        }

        while(file.hasNext()){
            String start = file.next();
            String end = file.next();
            if (start.length() != end.length()){
                System.out.println("There is no word ladder between " + start + " and " + end);
                continue;
            }
            LinkedList ladder = new LinkedList();
            LinkedList queue = new LinkedList();
            HashSet<String> used = new HashSet<>();
            used.add(start);
            used.add(end);
            boolean finished = false;

            for (String s : dict) {
                if (s.equals(end) && s.equals(start)) {
                    ladder.add(start);
                    ladder.add(end);
                    finished = true;
                    break;
                }
                else if(s.length() == start.length() && checkDiff(s, start) == 1){
                    LinkedList stack = new LinkedList();
                    stack.add(start);
                    stack.add(s);
                    queue.add(stack);
                    used.add(s);
                }
            }

            while (!finished){
                if (queue.size() == 0 || used.size() == dict.size()){
                    break;
                }
                LinkedList current = (LinkedList) queue.get(queue.size()-1);
                queue.removeAsQueue();
                String word = (String) current.get(0);
                for (String s : dict) {
                    if (s.equals(end) && checkDiff(s, word) == 1) {
                        if(current.size() > 1 && indexOfDiff(s, word) == indexOfDiff(s, (String) current.get(1))){
                            current.removeAsStack();
                        }
                        current.add(s);
                        ladder = current;
                        finished = true;
                        break;
                    }
                    else if(!used.contains(s) && s.length() == word.length() && checkDiff(s, word) == 1){
                        LinkedList stack = new LinkedList();
                        for (int i = current.size()-1; i >= 0; i--) {
                            stack.add(current.get(i));
                        }
                        stack.add(s);
                        queue.add(stack);
                        used.add(s);
                    }
                }


            }

            if(ladder.size() == 0){
                System.out.println("There is no word ladder between " + start + " and " + end);
                continue;
            }
            for (int i = ladder.size()-1; i >= 1; i--) {
                System.out.print(ladder.get(i) + ", ");
            }
            System.out.println(ladder.get(0));
        }
    }

    private static int checkDiff(String string1, String string2) {
        if(string1.length() != string2.length()){
            throw new IllegalArgumentException("String sizes don't match");
        }
        int diff = 0;
        for (int i = 0; i < string1.length(); i++) {
            if(string1.charAt(i) != string2.charAt(i)){
                diff++;
            }
        }
        return diff;
    }

    private static int indexOfDiff(String string1, String string2) {
        if(checkDiff(string1, string2) != 1){
            return -1;
        }
        for (int i = 0; i < string1.length(); i++) {
            if(string1.charAt(i) != string2.charAt(i)){
                return i;
            }
        }
        return -1;
    }



}
