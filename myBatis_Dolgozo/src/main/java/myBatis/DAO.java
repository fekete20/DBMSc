package myBatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DAO {
	
	// dolgozó felvitele
	public void saveDolgozo(Dolgozo dolgozo) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("mybatis.DolgozoMapper.insertDolgozo", dolgozo);
		session.commit();
		session.close();
	}
	
	// képzés felvitele
	public void saveKepzes(Kepzes kepzes) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("mybatis.KepzesMapper.insertKepzes", kepzes);
		session.commit();
		session.close();
	}
	
	// dolgozó hozzárendelése képzéshez 
	public void dolgozoKepzesOsszerendeles(DolgKepzOsszerendeles dk) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("mybatis.Osszerendeles.osszerendeles", dk);
		session.commit();
		session.close();
	}
	
	// dolgozó fizetésének módosítása
	public void updateFizetes(Dolgozo dolgozo) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("mybatis.DolgozoMapper.updatePayment", dolgozo);
		session.commit();
		session.close();
	}
	
	// dolgozó beosztásának módosítása
	public void updateBeosztas(Dolgozo dolgozo) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("mybatis.DolgozoMapper.updatePost", dolgozo);
		session.commit();
		session.close();
	}
	
	// képzés idõtartamának módosítása
	public void updateIdotartam(Kepzes kepzes) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("mybatis.KepzesMapper.updateIdotartam", kepzes);
		session.commit();
		session.close();
	}
	
	// képzés oktatójának módosítása
	public void updateOktato(Kepzes kepzes) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("mybatis.KepzesMapper.updateOktato", kepzes);
		session.commit();
		session.close();
	}

	// dolgozó törlése
	public void deleteDolgozo(int id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("mybatis.DolgozoMapper.deleteDolgozo", id);
		session.commit();
		session.close();
	}
	
	// képzés törlése
	public void deleteKepzes(int id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("mybatis.KepzesMapper.deleteKepzes", id);
		session.commit();
		session.close();
	}
	
	// összes dolgozó lekérdezése
	public List<Dolgozo> findAllDolgozo() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Dolgozo> dolgozok = session.selectList("mybatis.DolgozoMapper.findAllDolgozo");
		session.close();
		return dolgozok;
	}
	
	// összes képzés lekérdezése
	public List<Kepzes> findAllKepzes() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Kepzes> kepzesek = session.selectList("mybatis.KepzesMapper.findAllKepzes");
		session.close();
		return kepzesek;
	}
	
	// Paraméternél magasabb fizetésû dolgozók lekérdezése
	public List<Dolgozo> magasabbFizetes(int fizetes) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Dolgozo> dolgozok = session.selectList("mybatis.DolgozoMapper.selectDolgozoByFizetes", fizetes);
		session.close();
		return dolgozok;
	}
	
	// Paraméternél rövidebb idejû képzések lekérdezése
	public List<Kepzes> rovidebbKepzes(int idotartam) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Kepzes> kepzesek = session.selectList("mybatis.KepzesMapper.selectRovidebbKepzes", idotartam);
		session.close();
		return kepzesek;
	}
	
	// Paraméterként megadott oktatóhoz milyen képzés tartozik
	public List<Kepzes> kepzesByOktato(String oktato) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Kepzes> kepzesek = session.selectList("mybatis.KepzesMapper.selectKepzesByOktato", oktato);
		session.close();
		return kepzesek;
	}
	
	// Paraméterként megadott fizetésnél magasabb fizetésû dolgozók milyen képzésen vett részt
	public List<Kozos> selectKepzesByNagyobbFizetes(int fizetes) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Kozos> kepzesByNagyobbFizetes = session.selectList("mybatis.KozosMapper.selectKepzesByNagyobbFizetes", fizetes);
		session.close();
		return kepzesByNagyobbFizetes;
	}
	
	// Paraméterként megadott beosztású dolgozó közül ki milyen képzésen vett részt
	public List<Kozos> selectKepzesByBeosztas(String beosztas) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Kozos> kepzesByBeosztas = session.selectList("mybatis.KozosMapper.selectKepzesByBeosztas", beosztas);
		session.close();
		return kepzesByBeosztas;
	}
	
}
