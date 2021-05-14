package db;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Dolgozo {
	private String id;
	private String nev;
	private String beosztas;
	private String fizetes;
	
	Service service = new Service();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getBeosztas() {
		return beosztas;
	}

	public void setBeosztas(String beosztas) {
		this.beosztas = beosztas;
	}

	public String getFizetes() {
		return fizetes;
	}

	public void setFizetes(String fizetes) {
		this.fizetes = fizetes;
	}

	void initDolgozo(MongoCollection<Document> collection) {
		Document insertDolgozo = new Document();
		insertDolgozo.put("_id", "100");
		insertDolgozo.put("nev", "dolgozó 1");
		insertDolgozo.put("beosztas", "gyakornok");
		insertDolgozo.put("fizetes", 220000);
		service.insert(collection, insertDolgozo);
		Document insertDolgozo1 = new Document();
		insertDolgozo1.put("_id", "101");
		insertDolgozo1.put("nev", "dolgozó 2");
		insertDolgozo1.put("beosztas", "csoportvezetõ");
		insertDolgozo1.put("fizetes", 460000);
		service.insert(collection, insertDolgozo1);
		Document insertDolgozo2 = new Document();
		insertDolgozo2.put("_id", "102");
		insertDolgozo2.put("nev", "dolgozó 3");
		insertDolgozo2.put("beosztas", "gyakornok");
		insertDolgozo2.put("fizetes", 200000);
		service.insert(collection, insertDolgozo2);
		Document insertDolgozo3 = new Document();
		insertDolgozo3.put("_id", "103");
		insertDolgozo3.put("nev", "dolgozó 4");
		insertDolgozo3.put("beosztas", "osztályvezetõ");
		insertDolgozo3.put("fizetes", 770000);
		service.insert(collection, insertDolgozo3);
		Document insertDolgozo4 = new Document();
		insertDolgozo4.put("_id", "104");
		insertDolgozo4.put("nev", "dolgozó 5");
		insertDolgozo4.put("beosztas", "gyakornok");
		insertDolgozo4.put("fizetes", 180000);
		service.insert(collection, insertDolgozo4);
	}
	 
	void deleteDolgozoInit(MongoDatabase db, String collection) {
		service.deleteById(db, collection, "100");
		service.deleteById(db, collection, "101");
		service.deleteById(db, collection, "102");
		service.deleteById(db, collection, "103");
		service.deleteById(db, collection, "104");
		}	
}
