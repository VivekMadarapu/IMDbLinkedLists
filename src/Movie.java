public class Movie {
    private String title;
    private String date;
    private LinkedList actors;
    private LinkedList directors;

    public Movie() {
        this.title = null;
        this.date = null;
        this.actors = null;
        this.directors = null;
    }

    public Movie(String title, String date, LinkedList actors, LinkedList directors) {
        this.title = title;
        this.date = date;
        this.actors = actors;
        this.directors = directors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LinkedList getActors() {
        return actors;
    }

    public void setActors(LinkedList actors) {
        this.actors = actors;
    }

    public LinkedList getDirectors() {
        return directors;
    }

    public void setDirectors(LinkedList directors) {
        this.directors = directors;
    }

    @Override
    public String toString() {
        return "Movie: " + title + "| Date: " + date + "| Actors: " + actors + "| Directors: " + directors;
    }
}
