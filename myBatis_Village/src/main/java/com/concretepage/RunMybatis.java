package com.concretepage;

import java.util.List;

public class RunMybatis {

	public static void main(String[] args) {
		VillageDAO villageDAO = new VillageDAO();
		Village village = new Village();
		
		// insert
		village.setId(103);
		village.setName("Eger");
		village.setDistrict("Heves");
		villageDAO.save(village);
		System.out.println("Saved. ID: " + village.getId() + ", name: " + village.getName() + ", district: "+ village.getDistrict());
		
		//update
		village = new Village();
		village.setId(1);
		village.setName("Miskolc");
		village.setDistrict("Borsod");
		villageDAO.update(village);
		System.out.println("updated");

		//select
		village = villageDAO.getData(1);
		System.out.println("ID: " + village.getId() + ", name: " + village.getName() + ", district: "+ village.getDistrict());
		System.out.println("1 row retrieved.");
		
		//updateF
		village.setId(1);
		village.setName("Miskolc2");
		village.setDistrict("Heves");
		villageDAO.updateF(village);
		System.out.println("Updated");
		
		//select all into a list
		List<Village> villages = villageDAO.getAllData();
		for(Village v : villages) {
			System.out.println("ID: " + v.getId() + ", name: " + v.getName() + ", district: "+ v.getDistrict());
		}
		
		//delete
		villageDAO.delete(100);
		System.out.println("deleted");
	}

}
