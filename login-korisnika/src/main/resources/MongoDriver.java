import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;

public class MongoDriver {
    ConnectionString connString = new ConnectionString(
        "mongodb+srv://sanja:borkvOCiBpguBQtt@cluster0.7prvw.mongodb.net/biblioteka?retryWrites=true&w=majority"
    );
    MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(connString)
        .retryWrites(true)
        .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase("login-korisnika");
}