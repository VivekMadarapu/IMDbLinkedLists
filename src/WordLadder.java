import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class WordLadder {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File("input.txt"));

        HashSet<String> dict = new HashSet<>();
        HashSet<String> used = new HashSet<>();

        Scanner file2 = new Scanner(new File("dictionary.txt"));
        while(file2.hasNext()){
            dict.add(file.nextLine());
        }

        while(file.hasNext()){
            String start = file.next();
            String end = file.next();



        }

    }

    public static int checkDiff(String string1, String string2) {
        if(string1.length() != string2.length()){
            throw new IllegalArgumentException("String sizes don't match");
        }

        for (int i = 0; i < string1.length(); i++) {

        }
    }


}
