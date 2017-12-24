import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sruthipotluri on 11/17/17.
 */
public class FirstFile {
    public static void main(String args[]) {
        Long start = System.currentTimeMillis();
        // File rfileName = new File("/Users/sruthipotluri/Desktop/sampleRatings.txt");

         File rfileName = new File("/Users/sruthipotluri/Desktop/rat_1M.txt");
      /*  File wfileName = new File("/Users/sruthipotluri/Desktop/rat_write_1M.txt");
        File wfileName = new File("/Users/sruthipotluri/Desktop/sampleWrite.txt"); */

        // MovieListBuilder mlb = new MovieListBuilder(rfileName,wfileName);
        MovieListBuilder mlb = new MovieListBuilder(rfileName);

      /*  File rfileName = new File("/Users/sruthipotluri/Desktop/movies.txt");

        String line = "";
        int i = 1;

        try {

            BufferedReader br = new BufferedReader(new FileReader(rfileName));
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\t");
                System.out.println(i +"line");
                System.out.println(values[0]);
                System.out.println(values[1]);
                i++;
            }
        } catch (IOException ie) {

        } */

        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
