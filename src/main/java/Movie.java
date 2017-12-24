import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.TreeMap;

/**
 * Created by sruthipotluri on 11/17/17.
 */
@Document
public class Movie{


    private String movieId;

    @Transient
    private String name;

    //Storing user and his rating for this movie.
    private TreeMap<String, Double> userlist = new TreeMap<String, Double>();

    //Stroing the Simlaity of every other movie
    private TreeMap<String,Double> movieSimilarity = new TreeMap<>();

    @Transient
    private TreeMap<String, Double> normaliseduserList = new TreeMap<>();

    @Transient
    private Double totVector;


    public Movie(String id) {
        this.movieId = id;
       /* for(int i = 1; i <=12; i++){
        for(int i=1; i<=6040; i++){n
            userlist.put(i,0.0f);
        } */
    }

    public String getId() {
        return movieId;
    }

   /* public void setId(int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeMap<String, Double> getUserlist() {
        return userlist;
    }

    public void setUserlist(TreeMap<String, Double> userlist) {
        this.userlist = userlist;
    }

    @Override
    public String toString() {
        return  " "+
                movieSimilarity;
    }

    public TreeMap<String, Double> getMovieSimilarity() {
        return movieSimilarity;
    }

    public void setMovieSimilarity(TreeMap<String, Double> movieSimilarity) {
        this.movieSimilarity = movieSimilarity;
    }

    public TreeMap<String, Double> getNormaliseduserList() {
        return normaliseduserList;
    }

    public void setNormaliseduserList(TreeMap<String, Double> normaliseduserList) {
        this.normaliseduserList = normaliseduserList;
    }

    public Double getTotVector() {
        return totVector;
    }

    public void setTotVector(Double totVector) {
        this.totVector = totVector;
    }
}
