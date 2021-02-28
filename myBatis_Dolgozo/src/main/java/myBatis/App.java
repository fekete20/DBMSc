package myBatis;

import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		DAO dao = new DAO();
		Dolgozo dolgozo = new Dolgozo();
		Kepzes kepzes = new Kepzes();
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
			System.out.println("14\tparaméterként megadott fizetésnél magasabb fizetésû dolgozók milyen képzésken vettek részt");
			System.out.println("15\tparaméterként megadott beosztásúak közül ki milyen képzésen vett részt");
			System.out.println("16\tdolgozó és képzés összerendelése");
			System.out.println("0\tkilépés");
			input = scanner.nextInt();
			
			switch(input) {
			case 0: {
				input = 0;
				break;
			}
			case 1: {
				// dolgozó felvitele
				System.out.println("Dolgozó ID-ja:");
				dolgozo.setDid(scanner.nextInt());
				System.out.println("Dolgozó neve:");
				dolgozo.setDnev(scanner.next());
				System.out.println("Dolgozó beosztása:");
				dolgozo.setBeosztas(scanner.next());
				System.out.println("Dolgozó fizetése:");
				dolgozo.setFizetes(scanner.nextInt());
				dao.saveDolgozo(dolgozo);
				System.out.println("Dolgozó tárolva a következõ adatokkal: ID: " + dolgozo.getDid() + ", Név: " + dolgozo.getDnev() + ", Beosztás:" + dolgozo.getBeosztas() + ", Fizetés: " + dolgozo.getFizetes());
				break;
			}
			
			case 2: {
				// dolgozó fizetésének módosítása
				Dolgozo dolgozo1 = new Dolgozo();
				System.out.println("Dolgozó ID-ja:");
				dolgozo1.setDid(scanner.nextInt());
				System.out.println("Dolgozó új fizetése:");
				dolgozo1.setFizetes(scanner.nextInt());
				dao.updateFizetes(dolgozo1);
				System.out.println("Dolgozó fizetése módosítva: ID: " + dolgozo1.getDid() + ", új fizetés: " + dolgozo1.getFizetes());	
				break;
			}
			
			case 3: {
				// dolgozó beosztásának módosítása
				Dolgozo dolgozo2 = new Dolgozo();
				System.out.println("Dolgozó ID-ja:");
				dolgozo2.setDid(scanner.nextInt());
				System.out.println("Dolgozó új beosztása:");
				dolgozo2.setBeosztas(scanner.next());
				dao.updateBeosztas(dolgozo2);
				System.out.println("Dolgozó beosztása módosítva: ID: " + dolgozo2.getDid() + ", új beosztás: " + dolgozo2.getBeosztas());
				break;
			}
			
			case 4: {
				// dolgozó törlése
				System.out.println("Törlendõ dolgozó ID-ja:");
				dao.deleteDolgozo(scanner.nextInt());
				System.out.println("Törölve.");
				break;
			}
			
			case 5: {
				// képzés felvitele
				System.out.println("Képzés ID-ja:");
				kepzes.setKid(scanner.nextInt());
				System.out.println("Képzés neve:");
				kepzes.setKnev(scanner.next());
				System.out.println("Képzés oktatója:");
				kepzes.setOktato(scanner.next());
				System.out.println("Képzés idõtartama:");
				kepzes.setIdotartam(scanner.nextInt());
				dao.saveKepzes(kepzes);
				System.out.println("Képzés tárolva a következõ adatokkal: ID: " + kepzes.getKid() + ", Név: " + kepzes.getKnev() + ", Oktató: " + kepzes.getOktato() + ", Idõtartam: " + kepzes.getIdotartam());
				break;
			}
			
			case 6: {
				// képzés hosszának módosítása
				Kepzes kepzes1 = new Kepzes();
				System.out.println("Képzés ID-ja:");
				kepzes1.setKid(scanner.nextInt());
				System.out.println("Képzés új idõtartama:");
				kepzes1.setIdotartam(scanner.nextInt());
				dao.updateIdotartam(kepzes1);
				System.out.println("Képzés idõtartama módosítva: ID: " + kepzes1.getKid() + ", új idõtartam: " + kepzes1.getIdotartam());
				break;
			}
			
			case 7: {
				// képzés oktatójának módosítása
				Kepzes kepzes2 = new Kepzes();
				System.out.println("Képzés ID-ja:");
				kepzes2.setKid(scanner.nextInt());
				System.out.println("Képzés új oktatója:");
				kepzes2.setOktato(scanner.next());
				dao.updateOktato(kepzes2);
				System.out.println("Képzés oktatója módosítva: ID: " + kepzes2.getKid() + ", új oktató: " + kepzes2.getOktato());
				break;
			}
			
			case 8: {
				// képzés törlése
				System.out.println("Törlendõ képzés ID-ja:");
				dao.deleteKepzes(scanner.nextInt());
				System.out.println("Törölve.");
				break;
			}
			
			case 9: {
				// összes dolgozó lekérdezése
				List<Dolgozo> osszesDolgozo = dao.findAllDolgozo();
				System.out.println("Összes dolgozó:");
				for(Dolgozo d : osszesDolgozo) {
					System.out.println("ID: " + d.getDid() + ", Név: " + d.getDnev() + ", Beosztás:" + d.getBeosztas() + ", Fizetés: " + d.getFizetes());
				}
				break;
			}
			
			case 10: {
				// összes képzés lekérdezése
				List<Kepzes> osszesKepzes = dao.findAllKepzes();
				System.out.println("Összes képzés:");
				for(Kepzes k : osszesKepzes) {
					System.out.println("ID: " + k.getKid() + ", Név: " + k.getKnev() + ", Oktató: " + k.getOktato() + ", Idõtartam: " + k.getIdotartam());
				}	
				break;
			}
			
			case 11: {
				// paraméternél magasabb fizetésû dolgozók lekérdezése
				System.out.println("Adja meg azt az értéket, amelynél magasabb fizetésû dolgozók nevét kéri listázni:");
				List<Dolgozo> dolgozoByFizetes = dao.magasabbFizetes(scanner.nextInt());
				for(Dolgozo d : dolgozoByFizetes) {
					System.out.println("Név: " + d.getDnev() + ", Fizetés: " + d.getFizetes());
				}
				break;
			}
			
			case 12: {
				// paraméternél rövidebb idejû képzések lekérdezése
				System.out.println("Adja meg azt az értéket, amelynél rövidebb idejû képzések nevét kéri listázni:");
				List<Kepzes> kepzesByIdotartam = dao.rovidebbKepzes(scanner.nextInt());
				for(Kepzes k : kepzesByIdotartam) {
					System.out.println("Név: " + k.getKnev() + ", Idõtartam: " + k.getIdotartam());
				}
				break;
			}
			
			case 13: {
				// paraméterként megadott oktatóhoz tartozó képzések
				System.out.println("Adja meg azt az oktatót, akihez tartozó képzések nevét kéri listázni:");
				List<Kepzes> kepzesByOktato = dao.kepzesByOktato(scanner.next());
				for(Kepzes k : kepzesByOktato) {
					System.out.println("Név: " + k.getKnev() + ", Oktató: " + k.getOktato());
				}
				break;
			}
			
			case 14: {
				// paraméterként megadott fizetésnél magasabb fizetésû dolgozók milyen képzésken vettek részt
				System.out.println("Adja meg azt a fizetésértéket, amelynél magasabb fizetésûek által elvégzett képzések listáját kéri.");
				List<Kozos> kepzesByNagyobbFizetes = dao.selectKepzesByNagyobbFizetes(scanner.nextInt());
				for(Kozos k : kepzesByNagyobbFizetes) {
					System.out.println("Dolgozó neve: " + k.getDnev() + ", képzés neve: " + k.getKnev() + ", dolgozó fizetése: " + k.getFizetes());
				}
				break;
			}
			
			case 15: {
				// paraméterként megadott beosztásúak közül ki milyen képzésen vett részt
				System.out.println("Adja meg azt a beosztást, amelyhez kapcsolódóan a képzések listázását kéri");
				List<Kozos> kepzesByBeosztas = dao.selectKepzesByBeosztas(scanner.next());
				for(Kozos k : kepzesByBeosztas) {
					System.out.println("Dolgozó neve: " + k.getDnev() + ", képzés neve: " + k.getKnev());
				}
				break;
			}
			
			case 16: {
				// dolgozó és képzés összerendelése
				System.out.println("Adja meg a dolgozó ID-ját, akit képzéshez szeretne rendelni:");
				DolgKepzOsszerendeles dk = new DolgKepzOsszerendeles();
				dk.setDid(scanner.nextInt());
				System.out.println("Adja meg a képzés ID-ját, amelyhez " + dk.getDid() + " ID-jû dolgozót szeretné rendelni.");
				dk.setKid(scanner.nextInt());
				dao.dolgozoKepzesOsszerendeles(dk);	
				System.out.println("Összerendelve.");
				break;
			}
			
			default: {
				System.out.println("Nem létezõ menüpont.");					
				break;
			}	
		}
			
	} while(input != 0);
	
	scanner.close();
	
}
}
