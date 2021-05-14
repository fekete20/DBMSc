package db;

import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Service {
	 MongoCollection<Document> selectAll(MongoDatabase db, String collection) {
		return db.getCollection(collection);
	}
	
	 void insert(MongoCollection<Document> collection, Document newdocument) {
		collection.insertOne(newdocument);
	}
	
	 void deleteById(MongoDatabase db, String collection, String id) {
		MongoCollection<Document> coll = db.getCollection(collection);
		coll.deleteOne(eq("_id", id));
	}
	
	 void update(MongoDatabase db, String collection, String id, String field, String newValue) {
		MongoCollection<Document> coll = db.getCollection(collection);
		coll.updateOne(eq("_id", id), new Document("$set", new Document(field, newValue)));
	}
}
