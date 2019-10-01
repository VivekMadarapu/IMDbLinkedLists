import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IMDb {

    public static void main(String[] args) throws FileNotFoundException {
        LinkedList actorList = new LinkedList();
        Scanner actorFile = new Scanner(new File("actors.txt"));

        while (actorFile.hasNext()){
            actorList.add(new Actor(actorFile.nextLine()));
        }
        System.out.println();

        LinkedList movies = new LinkedList();
        Scanner dirFile = new Scanner(new File("movies.txt"));

        while (dirFile.hasNext()) {
            String line = dirFile.nextLine();
            Movie movie = new Movie();
            movie.setDate(line.substring(0, 4));
            movie.setTitle(line.substring(5,38).trim());
            String actorStr = line.substring(38, 84).trim();
            String[] actorArr = actorStr.split(", ");
            LinkedList actors = new LinkedList();
            for (String actor: actorArr) {
                actors.add(actor);
            }
            movie.setActors(actors);
            String dirStr = line.substring(89).trim();
            String[] dirArr = dirStr.split(", ");
            LinkedList directors = new LinkedList();
            for (String dir: dirArr) {
                directors.add(dir);
            }
            movie.setDirectors(directors);
            movies.add(movie);
        }

        for(int i = 0; i < actorList.size();i++){
            StringBuilder print = new StringBuilder();
            Actor actor = (Actor) actorList.get(i);
            print.append(actor.getName().trim());
            print.append(" acted in ");
            boolean hasActed = false;
            for(int j = 0; j < movies.size();j++){
                Movie movie = (Movie) movies.get(j);
                if(movie.containsActor(actor)) {
                    print.append(movie.getDate()).append(" ").append(movie.getTitle()).append(", ");
                    hasActed = true;
                }
            }
            if (!hasActed){
                print.append("none  ");
            }
            print = new StringBuilder(print.substring(0, print.length() - 2));
            System.out.println(print);
        }

    }

}
