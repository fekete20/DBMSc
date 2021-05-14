package db;

import java.util.Scanner;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Filters.eq;

public class App {

	public static void main(String[] args) {
		MongoClient mongo = new MongoClient("127.0.0.1", 27777);
		MongoDatabase db = mongo.getDatabase("AB_MSC_B5T3ZN");
		MongoCollection<Document> dolgozok = db.getCollection("dolgozok");
		MongoCollection<Document> kepzesek = db.getCollection("kepzesek");
		MongoCollection<Document> dolgkepzes = db.getCollection("dolgkepzes");
		
		Service service = new Service();
		Dolgozo dolgozo = new Dolgozo();
		Kepzes kepzes = new Kepzes();
		Osszerendeles osszerendeles = new Osszerendeles();
		
		// delete all init
		dolgozo.deleteDolgozoInit(db, "dolgozok");
		kepzes.deleteKepzesInit(db, "kepzesek");
		osszerendeles.deleteOsszerendelesInit(db, "dolgkepzes");
		
		dolgozo.initDolgozo(dolgozok);
		kepzes.initKepzes(kepzesek);
		osszerendeles.initOsszerendeles(dolgkepzes);
		
		Scanner scanner = new Scanner(System.in);
		int input;
		do {
			System.out.println("Válasszon mûveletet!");
			System.out.println("1\tdolgozó felvitele");
			System.out.println("2\tdolgozó fizetésének módosítása");
			System.out.println("3\tdolgozó beosztásának módosítása");
			System.out.println("4\tdolgozó törlése");
			System.out.println("5\tképzés felvitele");
			System.out.println("6\tképzés hosszának módosítása");
			System.out.println("7\tképzés oktatójának módosítása");
			System.out.println("8\tképzés törlése");
			System.out.println("9\tösszes dolgozó lekérdezése");
			System.out.println("10\tösszes képzés lekérdezése");
			System.out.println("11\tparaméternél magasabb fizetésû dolgozók lekérdezése");
			System.out.println("12\trövidebb idejû képzések lekérdezése");
			System.out.println("13\tparaméterként megadott oktatóhoz tartozó képzések");
			System.out.println("14\tdolgozó és képzés összerendelése");
			System.out.println("0\tkilépés");
			input = scanner.nextInt();
			
			switch(input) {
			case 0: {
				input = 0;
				break;
			}
			case 1: {
				// dolgozó felvitele
				Document document = new Document();
				System.out.println("Dolgozó ID-ja:");
				document.put("_id", scanner.next());
				System.out.println("Dolgozó neve:");
				document.put("nev", scanner.next());
				System.out.println("Dolgozó beosztása:");
				document.put("beosztas", scanner.next());
				System.out.println("Dolgozó fizetése:");
				document.put("fizetes", scanner.next());
				service.insert(dolgozok, document);
				System.out.println("Dolgozó tárolva.");
				break;
			}
			case 2: {
				// dolgozó fizetésének módosítása
				System.out.println("Dolgozó ID-ja:");
				String id = scanner.next();
				System.out.println("Dolgozó új fizetése:");
				String fizetes = scanner.next();
				service.update(db, "dolgozok", id, "fizetes", fizetes);
				System.out.println("Dolgozó fizetése módosítva.");	
				break;
			}
			case 3: {
				// dolgozó beosztásának módosítása
				System.out.println("Dolgozó ID-ja:");
				String id = scanner.next();
				System.out.println("Dolgozó új beosztása:");
				String beosztas = scanner.next();
				service.update(db, "dolgozok", id, "beosztas", beosztas);
				System.out.println("Dolgozó beosztása módosítva.");	
				break;
			}
			case 4: {
				// dolgozó törlése
				System.out.println("Törlendõ dolgozó ID-ja:");
				String id = scanner.next();
				service.deleteById(db, "dolgozok", id);
				System.out.println("Törölve.");
				break;
			}
			case 5: {
				// képzés felvitele
				Document document = new Document();
				System.out.println("Képzés ID-ja:");
				document.put("_id", scanner.next());
				System.out.println("Képzés neve:");
				document.put("nev", scanner.next());
				System.out.println("Képzés oktatója:");
				document.put("oktato", scanner.next());
				System.out.println("Képzés idõtartama:");
				document.put("idotartam", scanner.next());
				service.insert(kepzesek, document);
				System.out.println("Képzés tárolva.");
				break;
			}
			case 6: {
				// képzés hosszának módosítása
				System.out.println("Képzés ID-ja:");
				String id = scanner.next();
				System.out.println("Képzés új idõtartama:");
				String idotartam = scanner.next();
				service.update(db, "kepzesek", id, "idotartam", idotartam);
				System.out.println("Képzés idõtartama módosítva.");	
				break;
			}
			case 7: {
				// képzés oktatójának módosítása
				System.out.println("Képzés ID-ja:");
				String id = scanner.next();
				System.out.println("Képzés új oktatója:");
				String oktato = scanner.next();
				service.update(db, "kepzesek", id, "oktato", oktato);
				System.out.println("Képzés oktatója módosítva.");	
				break;
			}
			case 8: {
				// képzés törlése
				System.out.println("Törlendõ képzés ID-ja:");
				String id = scanner.next();
				service.deleteById(db, "kepzesek", id);
				System.out.println("Törölve.");
				break;
			}
			case 9: {
				// összes dolgozó lekérdezése
				System.out.println("Dolgozók listája:");
				for(Document document : service.selectAll(db, "dolgozok").find()) {
					System.out.println(document);
				}
				break;
			}
			case 10: {
				// összes képzés lekérdezése
				System.out.println("Képzések listája");
				for(Document document : service.selectAll(db, "kepzesek").find()) {
					System.out.println(document);
				}
				break;	
			}
			case 11: {
				// paraméternél magasabb fizetésû dolgozók lekérdezése
				System.out.println("Adja meg azt az értéket, amelynél magasabb fizetésû dolgozók nevét kéri listázni:");
				String value = scanner.next();
				for(Document document : service.selectAll(db, "dolgozok").find(gt("fizetes", value))) {
					System.out.println(document);
				}
				break;
			}
			case 12: {
				// paraméternél rövidebb idejû képzések lekérdezése
				System.out.println("Adja meg azt az értéket, amelynél rövidebb idejû képzések nevét kéri listázni:");
				String value = scanner.next();
				for(Document document : service.selectAll(db, "kepzesek").find(lt("idotartam", value))) {
					System.out.println(document);
				}
				break;
			}
			case 13: {
				// paraméterként megadott oktatóhoz tartozó képzések
				System.out.println("Adja meg azt az oktatót, akihez tartozó képzések nevét kéri listázni:");
				String value = scanner.next();
				for(Document document : service.selectAll(db, "kepzesek").find(eq("oktato", value))) {
					System.out.println(document);
				}
				break;
			}
			case 14: {
				// dolgozó és képzés összerendelése
				Document document = new Document();
				System.out.println("Adja meg a dolgozó ID-ját, akit képzéshez szeretne rendelni:");
				String id = scanner.next();
				document.put("dolgozoID", id);
				System.out.println("Adja meg a képzés ID-ját, amelyhez " + id + " ID-jû dolgozót szeretné rendelni.");
				document.put("kepzesID", scanner.next());
				System.out.println("Összerendelve.");
				break;
			}
			default: {
				System.out.println("Nem létezõ menüpont.");					
				break;
			}
		}
			
			
		} while(input != 0);
		
		// delete all init
		dolgozo.deleteDolgozoInit(db, "dolgozok");
		kepzes.deleteKepzesInit(db, "kepzesek");
		osszerendeles.deleteOsszerendelesInit(db, "dolgkepzes");
		
		scanner.close();
		
		mongo.close();
	}
}
