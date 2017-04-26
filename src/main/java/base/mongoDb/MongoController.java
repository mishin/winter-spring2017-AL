package base.mongoDb;

/**
 * Created by calvinnguyen on 4/21/17.
 */

// Standard URI format: mongodb://[dbuser:dbpassword@]host:port/dbname

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoController {
    private static final String USER_URI = "mongodb://heroku_d6c78867:m2t990uta0dlc2p9ear688bvkl@ds155820.mlab.com:55820/heroku_d6c78867";
    private static MongoClient client;
    private static MongoDatabase db;

    public static void loginMongo() {
        client = new MongoClient(USER_URI);
        db = client.getDatabase(USER_URI);
    }

    public static void logoutMongo() {
        client.close();
    }

    public static MongoDatabase getDatabase(){
        return db;
    }
}
