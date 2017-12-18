import com.mongodb.MongoCredential;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.Arrays;

/**
 * Created by sruthipotluri on 12/6/17.
 */

@Configuration
public class Config {

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoCredential credential = MongoCredential.createCredential("fproject","project","password".toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));
        return new SimpleMongoDbFactory(mongoClient, "project");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }
}
