package blogsVIew;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TestMongo {

	public static void main(String[] args) {

		try {
			// 实例化Mongo对象，连接27017端口
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase db = mongoClient.getDatabase("blogs");
			MongoCollection collection = db.getCollection("abc");

//			Document document = new Document();
//			document.put("id", 100);
//			document.put("msg", "Hello Mongodb");
//			collection.insertOne(document);

			BasicDBObject query = new BasicDBObject();
			query.put("id", 100);
			FindIterable cursor = collection.find(query);
			for (Object object : cursor) {
				System.out.println(object);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
