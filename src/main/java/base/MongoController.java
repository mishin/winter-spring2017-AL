package base;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Created by calvinnguyen on 5/9/17.
 */
public class MongoController {

    private static final String URI = "mongodb://heroku_c1vgg6jm:813gekflqs9sest76p1gu94h77@ds121171.mlab.com:21171/heroku_c1vgg6jm";
    private static MongoClientURI uri;
    private static MongoClient client;
    private static MongoDatabase db;

    public static void loginMongo() {
        uri = new MongoClientURI(URI);
        client = new MongoClient(uri);
        db = client.getDatabase("heroku_c1vgg6jm");
    }

    public static void logoutMongo() {
        client.close();
    }

    public static MongoCollection getCollection(String colName) { return db.getCollection(colName); }

    public static String getUri() { return URI; }
}
