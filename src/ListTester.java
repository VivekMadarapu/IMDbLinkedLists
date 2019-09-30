import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ListTester {

    public static void main(String[] args) throws IOException {
//        LinkedList actorList = new LinkedList();
//
//        Scanner file = new Scanner(new File("actors.txt"));
//
//        while (file.hasNext()){
//            actorList.add(new Actor(file.nextLine()));
//        }
//
//
//        for(int i = 0; i < actorList.size();i++){
//            System.out.println(actorList.get(i));
//
//        }
//
//        System.out.println("\n" + ((Actor) actorList.get(0)).getName());


        LinkedList movies = new LinkedList();

        Scanner file = new Scanner(new File("movies.txt"));

        while (file.hasNext()) {
            String line = file.nextLine();
            Movie movie = new Movie();
            movie.setDate(line.substring(0, 4));
            movie.setTitle(line.substring(5,38).trim());
            String actorStr = line.substring(39, 84).trim();
            String[] actorArr = actorStr.split(", ");
            LinkedList actors = new LinkedList();
            for (String actor: actorArr) {
                actors.add(new Actor(actor));
            }
            movie.setActors(actors);
            String dirStr = line.substring(89, line.length()-1).trim();
            String[] dirArr = dirStr.split(",");
            LinkedList directors = new LinkedList();
            for (String dir: dirArr) {
                directors.add(dir);
            }
            movie.setDirectors(directors);

            movies.add(movie);
        }

        for(int i = 0; i < movies.size();i++){
            System.out.println(movies.get(i));

        }

        System.out.println("\n" + ((Movie) movies.get(0)).getTitle());

    }
}
