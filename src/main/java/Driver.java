import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created by sruthipotluri on 11/26/17.
 */
public class Driver {
    void save(Movie movie) {
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("project" );
            boolean auth = db.authenticate("fproject", "password".toCharArray());
            DBCollection table = db.getCollection("movie");
            BasicDBObject document = new BasicDBObject();

            document.put("id", movie.getId());
            document.put("userlist",new BasicDBObject(movie.getUserlist()));
            document.put("movieSimilarity", movie.getMovieSimilarity());
            table.insert(document);


         //   System.out.println("Done");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
