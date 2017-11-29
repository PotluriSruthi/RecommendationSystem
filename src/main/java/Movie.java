import java.util.TreeMap;

/**
 * Created by sruthipotluri on 11/17/17.
 */
public class Movie {
    private String id;
    private String name;

    //Storing user and his rating for this movie.
    private TreeMap<String, Double> userlist = new TreeMap<String, Double>();

    //Stroing the Simlaity of every other movie
    private TreeMap<String,Double> movieSimilarity = new TreeMap<String, Double>();


    public Movie(String id) {
        this.id = id;
       /* for(int i = 1; i <=12; i++){
        for(int i=1; i<=6040; i++){
            userlist.put(i,0.0f);
        } */
    }

    public String getId() {
        return id;
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
}
