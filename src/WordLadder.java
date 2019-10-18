import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class WordLadder {

    public static void main(String[] args) throws FileNotFoundException {

        long startTime = System.currentTimeMillis();

        Scanner file = new Scanner(new File("input.txt"));

        HashSet<String> dictionary = new HashSet<>();

        Scanner file2 = new Scanner(new File("dictionary.txt"));
        while(file2.hasNext()){
            dictionary.add(file2.nextLine());
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
            String alphabet = "qwertyuiopasdfghjklzxcvbnm";
            char[] letters = alphabet.toCharArray();

            outer:
            for (int i = 0; i < start.length(); i++) {
                for(char l:letters) {
                    String s = start.substring(0, i) + l + start.substring(i + 1);
                    if(dictionary.contains(s)) {
                        if (s.equals(end) && s.equals(start)) {
                            ladder.add(start);
                            ladder.add(end);
                            finished = true;
                            break outer;
                        } else if (checkDiff(s, start) == 1) {
                            LinkedList stack = new LinkedList();
                            stack.add(start);
                            stack.add(s);
                            queue.add(stack);
                            used.add(s);
                        }
                    }
                }
            }


            while (!finished){
                if (queue.size() == 0 || used.size() == dictionary.size()){
                    break;
                }
                LinkedList current = (LinkedList) queue.get(queue.size()-1);
                queue.removeAsQueue();

                String word = (String) current.get(0);
                outer:
                for (int i = 0; i < word.length(); i++) {
                    for(char l:letters){
                        String s = word.substring(0, i) + l + word.substring(i+1);
                        if(dictionary.contains(s)){
                            if (s.equals(end)) {
                                if(current.size() > 1 && indexOfDiff(s, word) == indexOfDiff(s, (String) current.get(1))){
                                    current.removeAsStack();
                                }
                                current.add(s);
                                ladder = current;
                                finished = true;
                                break outer;
                            }
                            else if(!used.contains(s)){
                                LinkedList stack = new LinkedList();
                                for (int j = current.size()-1; j >= 0; j--) {
                                    stack.add(current.get(j));
                                }
                                stack.add(s);
                                queue.add(stack);
                                used.add(s);
                            }
                        }
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

        System.out.println("Time to run: " + ((System.currentTimeMillis() - startTime)) + " milliseconds (" + ((System.currentTimeMillis() - startTime)/1000.0) + " seconds)");
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
        if(checkDiff(string1, string2) > 1){
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