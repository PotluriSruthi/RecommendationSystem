import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;
import java.util.TreeMap;

/**
 * Created by sruthipotluri on 11/26/17.
 */
public class Driver {


    private MongoTemplate mongoTemplate;

    Driver(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        this.mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
    }

    public void save(Movie movie){



        mongoTemplate.save(movie);
    }

    public void savingUser(User user){

            mongoTemplate.save(user);

    }

}

  /*  DBCollection table ;
    BasicDBObject document ;
    MongoClient mongo;
    DB db;
    boolean auth;

    Driver(){
        try{
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("project" );
        boolean auth = db.authenticate("fproject", "password".toCharArray());
        this.table = db.getCollection("movieTrial");
        this.document = new BasicDBObject();

    } catch (UnknownHostException e) {
        e.printStackTrace();
    } catch (MongoException e) {
        e.printStackTrace();
    }
    }
    void save(Movie movie) {


            document.put("id", movie.getId());
            document.put("userlist",movie.getUserlist());
            document.put("movieSimilarity", movie.getMovieSimilarity());
            table.insert(document);


         //   System.out.println("Done");


    } */

