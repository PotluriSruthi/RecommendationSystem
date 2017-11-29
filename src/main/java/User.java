import java.util.HashSet;

/**
 * Created by sruthipotluri on 11/22/17.
 */
public class User {
    private String userID;
    private  HashSet<String> movieList = new HashSet<String>();

    public User(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public HashSet<String> getMovieList() {
        return movieList;
    }

    public void setMovieList(HashSet<String> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return " "+ movieList;
    }
}
