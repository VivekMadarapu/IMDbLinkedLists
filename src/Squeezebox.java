import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Squeezebox {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File("squeezebox.dat"));

        while (file.hasNext()){
            ArrayList<ArrayDeque<String>> game = new ArrayList<>();
            String c = file.nextLine() + " " + file.nextLine();
            Scanner cards = new Scanner(c);
            while (cards.hasNext()){
                ArrayDeque<String> cardStack = new ArrayDeque<>();
                cardStack.addFirst(cards.next());
                game.add(cardStack);
            }
            int i = 1;
            while (game.size() != 1){

                boolean canPlay = false;
                if(i >= 3 && game.get(i).getFirst().charAt(0) == game.get(i-3).getFirst().charAt(0) || game.get(i).getFirst().charAt(1) == game.get(i-3).getFirst().charAt(1)) {
                    while (game.get(i).getFirst().charAt(0) == game.get(i-3).getFirst().charAt(0) || game.get(i).getFirst().charAt(1) == game.get(i-3).getFirst().charAt(1)) {
                        game.get(i-3).addFirst(game.get(i).removeFirst());
                    }
                    canPlay = true;
                }
                else if(game.get(i).getFirst().charAt(0) == game.get(i-1).getFirst().charAt(0) || game.get(i).getFirst().charAt(1) == game.get(i-1).getFirst().charAt(1)){
                    while (game.get(i).getFirst().charAt(0) == game.get(i-1).getFirst().charAt(0) || game.get(i).getFirst().charAt(1) == game.get(i-1).getFirst().charAt(1)) {
                        game.get(i-1).addFirst(game.get(i).removeFirst());
                    }
                    canPlay = true;
                }

                if(!canPlay){
                    break;
                }
                i++;
            }
            System.out.print(game.size() + " piles remaining: ");
            for (ArrayDeque<String> cs : game){
                System.out.print(cs.size() + " ");
            }
            System.out.println();

        }

    }

}
