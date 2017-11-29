import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * Created by sruthipotluri on 11/17/17.
 */
public class MovieListBuilder {
    File ratingFile;
    // File writeFile;
    String line;

    String userId = null;
    String movieID = null;
    Double rating = 0.0;

    TreeMap<String,Double> userList = null;

    HashSet<String> movieList = null;

    Movie movie = null;

    User user = null;

    //Storing MovieId and its object.
    TreeMap<String, Movie> utilityMatrix = new TreeMap<String, Movie>();

    //Storing user rated movies list
    TreeMap<String, User> userMovieList = new TreeMap<String, User>();

   public MovieListBuilder(File fileName) {
        ratingFile = fileName;

        builder();
    }


  /* public MovieListBuilder(File fileName,File writeFile) {
        ratingFile = fileName;
        this.writeFile = writeFile;
        builder();
    } */

    private void builder() {
        try {
            //  BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile));
            BufferedReader br = new BufferedReader(new FileReader(ratingFile));
            while((line = br.readLine())!= null) {

                //System.out.println(line);
                String[] values = line.split(" ");
                userId = values[0];
                movieID = values[1];
                rating = Double.parseDouble(values[2]);

                // System.out.println(userId + " " + movieID + " " + rating);

                //This check if the movie is a new movie, if its new, we add the user and his ratings to our collection

                if (!utilityMatrix.containsKey(movieID)) {

                    //Creating the movie object with its new user and rating
                    movie = new Movie(movieID);
                    addingMovieToUtilityMatrix(movie);
                    utilityMatrix.put(movieID, movie);

                }
                //If the movie is already in our collection, add new user and his rating for the movie
                else {

                    movie = utilityMatrix.get(movieID);
                    addingMovieToUtilityMatrix(movie);

                }

                if(!userMovieList.containsKey(userId)){
                    user = new User(userId);
                    addingUsertoUserMovieList(user);
                    userMovieList.put(userId,user);
                }

                else{
                    user = userMovieList.get(userId);
                    addingUsertoUserMovieList(user);
                }
            }

          // System.out.println(utilityMatrix);
         //   System.out.println(userMovieList);

           CosineSimCal c = new CosineSimCal(utilityMatrix);
           c.calculate();


           // System.out.println(utilityMatrix);

          /*  for(Map.Entry<Integer, Movie> u : utilityMatrix.entrySet()){
                bw.write(u.getKey() + " "+u.getValue());
                bw.flush();
            } */


        } catch (IOException ie) {
            System.out.println("File not present");
        }

    }

    private void addingMovieToUtilityMatrix(Movie movie){
        userList = movie.getUserlist();
        userList.put(userId,rating);
        movie.setUserlist(userList);

    }

    private void addingUsertoUserMovieList(User user){
        movieList = user.getMovieList();
        movieList.add(movieID);
        user.setMovieList(movieList);
    }



}
