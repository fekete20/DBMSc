package db;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Osszerendeles {
	private String id;
	private String dolgozoID;
	private String kepzesID;
	
	Service service = new Service();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDolgozoID() {
		return dolgozoID;
	}

	public void setDolgozoID(String dolgozoID) {
		this.dolgozoID = dolgozoID;
	}

	public String getKepzesID() {
		return kepzesID;
	}

	public void setKepzesID(String kepzesID) {
		this.kepzesID = kepzesID;
	}
	
	void initOsszerendeles(MongoCollection<Document> collection) {
		Document osszerendeles = new Document();
		osszerendeles.put("_id", "1");
		osszerendeles.put("dolgozoID", "100");
		osszerendeles.put("kepzesID", "100");
		service.insert(collection, osszerendeles);
		Document osszerendeles1 = new Document();
		osszerendeles1.put("_id", "2");
		osszerendeles1.put("dolgozoID", "100");
		osszerendeles1.put("kepzesID", "101");
		service.insert(collection, osszerendeles1);
		Document osszerendeles2 = new Document();
		osszerendeles2.put("_id", "3");
		osszerendeles2.put("dolgozoID", "102");
		osszerendeles2.put("kepzesID", "101");
		service.insert(collection, osszerendeles2);
		Document osszerendeles3 = new Document();
		osszerendeles3.put("_id", "4");
		osszerendeles3.put("dolgozoID", "104");
		osszerendeles3.put("kepzesID", "102");
		service.insert(collection, osszerendeles3);
	}
	 
	void deleteOsszerendelesInit(MongoDatabase db, String collection) {
			service.deleteById(db, collection, "1");
			service.deleteById(db, collection, "2");
			service.deleteById(db, collection, "3");
			service.deleteById(db, collection, "4");
		}
}
