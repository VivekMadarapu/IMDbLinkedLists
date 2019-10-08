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
        Scanner file2 = new Scanner(new File("dictionary.txt"));
        while(file2.hasNext()){
            dict.add(file.nextLine());
        }

        while(file.hasNext()){
            String start = file.next();
            String end = file.next();

        }

    }
}
