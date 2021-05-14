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
			System.out.println("V�lasszon m�veletet!");
			System.out.println("1\tdolgoz� felvitele");
			System.out.println("2\tdolgoz� fizet�s�nek m�dos�t�sa");
			System.out.println("3\tdolgoz� beoszt�s�nak m�dos�t�sa");
			System.out.println("4\tdolgoz� t�rl�se");
			System.out.println("5\tk�pz�s felvitele");
			System.out.println("6\tk�pz�s hossz�nak m�dos�t�sa");
			System.out.println("7\tk�pz�s oktat�j�nak m�dos�t�sa");
			System.out.println("8\tk�pz�s t�rl�se");
			System.out.println("9\t�sszes dolgoz� lek�rdez�se");
			System.out.println("10\t�sszes k�pz�s lek�rdez�se");
			System.out.println("11\tparam�tern�l magasabb fizet�s� dolgoz�k lek�rdez�se");
			System.out.println("12\tr�videbb idej� k�pz�sek lek�rdez�se");
			System.out.println("13\tparam�terk�nt megadott oktat�hoz tartoz� k�pz�sek");
			System.out.println("14\tdolgoz� �s k�pz�s �sszerendel�se");
			System.out.println("0\tkil�p�s");
			input = scanner.nextInt();
			
			switch(input) {
			case 0: {
				input = 0;
				break;
			}
			case 1: {
				// dolgoz� felvitele
				Document document = new Document();
				System.out.println("Dolgoz� ID-ja:");
				document.put("_id", scanner.next());
				System.out.println("Dolgoz� neve:");
				document.put("nev", scanner.next());
				System.out.println("Dolgoz� beoszt�sa:");
				document.put("beosztas", scanner.next());
				System.out.println("Dolgoz� fizet�se:");
				document.put("fizetes", scanner.next());
				service.insert(dolgozok, document);
				System.out.println("Dolgoz� t�rolva.");
				break;
			}
			case 2: {
				// dolgoz� fizet�s�nek m�dos�t�sa
				System.out.println("Dolgoz� ID-ja:");
				String id = scanner.next();
				System.out.println("Dolgoz� �j fizet�se:");
				String fizetes = scanner.next();
				service.update(db, "dolgozok", id, "fizetes", fizetes);
				System.out.println("Dolgoz� fizet�se m�dos�tva.");	
				break;
			}
			case 3: {
				// dolgoz� beoszt�s�nak m�dos�t�sa
				System.out.println("Dolgoz� ID-ja:");
				String id = scanner.next();
				System.out.println("Dolgoz� �j beoszt�sa:");
				String beosztas = scanner.next();
				service.update(db, "dolgozok", id, "beosztas", beosztas);
				System.out.println("Dolgoz� beoszt�sa m�dos�tva.");	
				break;
			}
			case 4: {
				// dolgoz� t�rl�se
				System.out.println("T�rlend� dolgoz� ID-ja:");
				String id = scanner.next();
				service.deleteById(db, "dolgozok", id);
				System.out.println("T�r�lve.");
				break;
			}
			case 5: {
				// k�pz�s felvitele
				Document document = new Document();
				System.out.println("K�pz�s ID-ja:");
				document.put("_id", scanner.next());
				System.out.println("K�pz�s neve:");
				document.put("nev", scanner.next());
				System.out.println("K�pz�s oktat�ja:");
				document.put("oktato", scanner.next());
				System.out.println("K�pz�s id�tartama:");
				document.put("idotartam", scanner.next());
				service.insert(kepzesek, document);
				System.out.println("K�pz�s t�rolva.");
				break;
			}
			case 6: {
				// k�pz�s hossz�nak m�dos�t�sa
				System.out.println("K�pz�s ID-ja:");
				String id = scanner.next();
				System.out.println("K�pz�s �j id�tartama:");
				String idotartam = scanner.next();
				service.update(db, "kepzesek", id, "idotartam", idotartam);
				System.out.println("K�pz�s id�tartama m�dos�tva.");	
				break;
			}
			case 7: {
				// k�pz�s oktat�j�nak m�dos�t�sa
				System.out.println("K�pz�s ID-ja:");
				String id = scanner.next();
				System.out.println("K�pz�s �j oktat�ja:");
				String oktato = scanner.next();
				service.update(db, "kepzesek", id, "oktato", oktato);
				System.out.println("K�pz�s oktat�ja m�dos�tva.");	
				break;
			}
			case 8: {
				// k�pz�s t�rl�se
				System.out.println("T�rlend� k�pz�s ID-ja:");
				String id = scanner.next();
				service.deleteById(db, "kepzesek", id);
				System.out.println("T�r�lve.");
				break;
			}
			case 9: {
				// �sszes dolgoz� lek�rdez�se
				System.out.println("Dolgoz�k list�ja:");
				for(Document document : service.selectAll(db, "dolgozok").find()) {
					System.out.println(document);
				}
				break;
			}
			case 10: {
				// �sszes k�pz�s lek�rdez�se
				System.out.println("K�pz�sek list�ja");
				for(Document document : service.selectAll(db, "kepzesek").find()) {
					System.out.println(document);
				}
				break;	
			}
			case 11: {
				// param�tern�l magasabb fizet�s� dolgoz�k lek�rdez�se
				System.out.println("Adja meg azt az �rt�ket, amelyn�l magasabb fizet�s� dolgoz�k nev�t k�ri list�zni:");
				String value = scanner.next();
				for(Document document : service.selectAll(db, "dolgozok").find(gt("fizetes", value))) {
					System.out.println(document);
				}
				break;
			}
			case 12: {
				// param�tern�l r�videbb idej� k�pz�sek lek�rdez�se
				System.out.println("Adja meg azt az �rt�ket, amelyn�l r�videbb idej� k�pz�sek nev�t k�ri list�zni:");
				String value = scanner.next();
				for(Document document : service.selectAll(db, "kepzesek").find(lt("idotartam", value))) {
					System.out.println(document);
				}
				break;
			}
			case 13: {
				// param�terk�nt megadott oktat�hoz tartoz� k�pz�sek
				System.out.println("Adja meg azt az oktat�t, akihez tartoz� k�pz�sek nev�t k�ri list�zni:");
				String value = scanner.next();
				for(Document document : service.selectAll(db, "kepzesek").find(eq("oktato", value))) {
					System.out.println(document);
				}
				break;
			}
			case 14: {
				// dolgoz� �s k�pz�s �sszerendel�se
				Document document = new Document();
				System.out.println("Adja meg a dolgoz� ID-j�t, akit k�pz�shez szeretne rendelni:");
				String id = scanner.next();
				document.put("dolgozoID", id);
				System.out.println("Adja meg a k�pz�s ID-j�t, amelyhez " + id + " ID-j� dolgoz�t szeretn� rendelni.");
				document.put("kepzesID", scanner.next());
				System.out.println("�sszerendelve.");
				break;
			}
			default: {
				System.out.println("Nem l�tez� men�pont.");					
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
