package base;

import base.catalogCourseDb.CatalogCourseRepository;
import base.studentFlowchartDb.FlowchartRepository;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    private static CatalogCourseRepository catalogCourseRepository;
    private static FlowchartRepository studentFlowchartRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        MongoClient mongoClient = new MongoClient();

        //MongoDatabase database = mongoClient.getDatabase("SlochartDatabase");
        //MongoCollection catalogCourses = database.getCollection("CatalogCourses");
    }
}