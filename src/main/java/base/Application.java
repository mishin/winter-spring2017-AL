package base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        //MongoClient mongoClient = new MongoClient();
        //MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        //MongoDatabase database = mongoClient.getDatabase("SlochartDatabase");
        //MongoCollection catalogCourses = database.getCollection("CatalogCourses");

        //mongoClient.close(); //TODO on application shutdown
    }
}