package db;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Kepzes {
	private String id;
	private String nev;
	private String oktato;
	private String idotartam;
	
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

	public String getOktato() {
		return oktato;
	}

	public void setOktato(String oktato) {
		this.oktato = oktato;
	}

	public String getIdotartam() {
		return idotartam;
	}

	public void setIdotartam(String idotartam) {
		this.idotartam = idotartam;
	}

	void initKepzes(MongoCollection<Document> collection) {
		Document insertKepzes = new Document();
		insertKepzes.put("_id", "100");
		insertKepzes.put("nev", "képzés 1");
		insertKepzes.put("oktato", "oktató 1");
		insertKepzes.put("idotartam", "60");
		service.insert(collection, insertKepzes);
		Document insertKepzes1 = new Document();
		insertKepzes1.put("_id", "101");
		insertKepzes1.put("nev", "képzés 2");
		insertKepzes1.put("oktato", "oktató 2");
		insertKepzes1.put("idotartam", "180");
		service.insert(collection, insertKepzes1);
		Document insertKepzes2 = new Document();
		insertKepzes2.put("_id", "102");
		insertKepzes2.put("nev", "képzés 3");
		insertKepzes2.put("oktato", "oktató 3");
		insertKepzes2.put("idotartam", "300");
		service.insert(collection, insertKepzes2);
	}
	 
	void deleteKepzesInit(MongoDatabase db, String collection) {
			service.deleteById(db, collection, "100");
			service.deleteById(db, collection, "101");
			service.deleteById(db, collection, "102");
		}
}
