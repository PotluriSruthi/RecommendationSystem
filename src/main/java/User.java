import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.TreeMap;

/**
 * Created by sruthipotluri on 11/22/17.
 */
@Document
public class User {


    private String userId;

    private  TreeMap<String,Double> movieRating = new TreeMap<>();

    public User(String userId) {

        this.userId = userId;
    }

    public String getUserId() {

        return userId;
    }



    @Override
    public String toString() {
        return " "+ movieRating;
    }

    public TreeMap<String, Double> getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(TreeMap<String, Double> movieList) {
        this.movieRating = movieList;
    }
}
