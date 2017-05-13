package base;

import base.catalogCourseDb.CatalogCourseRepository;
import base.studentFlowchartDb.FlowchartRepository;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableMongoRepositories
public class Application {

    //@Autowired private static CatalogCourseRepository catalogCourseRepository;
    //@Autowired private static FlowchartRepository studentFlowchartRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
    }
}