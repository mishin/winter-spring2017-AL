package base;

import base.catalogDb.CatalogCourseRepository;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mongodb.MongoClient;
import org.bson.Document;

@SpringBootApplication
public class Application {

    @Autowired
    private static CatalogCourseRepository catalogCourseRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        //MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        //MongoDatabase database = mongoClient.getDatabase("SlochartDatabase");
        //MongoCollection catalogCourses = database.getCollection("CatalogCourses");

        //mongoClient.close(); //TODO on application shutdown
    }
}