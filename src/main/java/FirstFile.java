import java.io.File;

/**
 * Created by sruthipotluri on 11/17/17.
 */
public class FirstFile {
    public static void main(String args[]){
        Long start = System.currentTimeMillis();
      // File rfileName = new File("/Users/sruthipotluri/Desktop/sampleRatings.txt");

        File rfileName = new File("/Users/sruthipotluri/Desktop/rat_1M.txt");
      /*  File wfileName = new File("/Users/sruthipotluri/Desktop/rat_write_1M.txt");
        File wfileName = new File("/Users/sruthipotluri/Desktop/sampleWrite.txt"); */

        // MovieListBuilder mlb = new MovieListBuilder(rfileName,wfileName);
        MovieListBuilder mlb = new MovieListBuilder(rfileName);
        Long end = System.currentTimeMillis();
         System.out.println(end - start);
    }
}
