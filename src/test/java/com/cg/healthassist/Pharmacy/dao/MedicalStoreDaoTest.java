package com.cg.healthassist.Pharmacy.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthassist.Pharmacy.dto.MedicalStore;

@RunWith(SpringRunner.class)
@DataJpaTest

/** The MedicalStoreDaoTest class provides testing for MedicalStoreDao
 * 
 * @author Rohith
 * @version 2.0
 * 
 */

public class MedicalStoreDaoTest {
	
	@Autowired
    private MedicalStoreDao medicalstoredao;

    @Autowired
    private TestEntityManager testEntityManager;
    
    /** Adding new Medicines into the pharmacy
     * 
     * @param AddNewMedicine
     * 
     */
    
    @Test
    public void testNewMedicine() throws Exception{
    	 MedicalStore medicalstore = getMedicalStore();
    	 MedicalStore saveInDb = testEntityManager.persist(medicalstore);
    	 MedicalStore getFromInDb = medicalstoredao.findById(saveInDb.getMedicineId()).get();
         assertThat(getFromInDb).isEqualTo(saveInDb);
    }
    
	private MedicalStore getMedicalStore() {
		 MedicalStore medicalstore = new MedicalStore();
		 medicalstore.setMedicineCost(200);
		 medicalstore.setMedicineName("dolo");
		 medicalstore.setMedicineDose(100);
		 medicalstore.setExpireDate("21/2/2009");
         return medicalstore;
	}
	
	
	 /** Searching medicine by its Id from pharmacy
     * 
     * @param GetMedicineById
     * 
     */
	
	@Test
     public void testGetMedicineById() throws Exception{
		 MedicalStore medicalstore = new MedicalStore();
		 medicalstore.setMedicineCost(200);
		 medicalstore.setMedicineName("dolo");
		 medicalstore.setMedicineDose(100);
		 medicalstore.setExpireDate("21/2/2029");

 		 MedicalStore saveInDb = testEntityManager.persist(medicalstore);
 		 MedicalStore getInDb = medicalstoredao.findById(medicalstore.getMedicineId()).get();
         assertThat(getInDb).isEqualTo(saveInDb);
	}
	
     /** Deleting medicine by its Id from pharmacy
     * 
     * @param GetDeleteMedicineById
     * 
     */
	
	 @Test
	    public void testDeleteMedicineById() throws Exception{
		 MedicalStore medicalstore = new MedicalStore();
		 medicalstore.setMedicineCost(200);
		 medicalstore.setMedicineName("dolo");
		 medicalstore.setMedicineDose(100);
		 medicalstore.setExpireDate("21/2/2029");
		 
		 MedicalStore medicalstore1 = new MedicalStore();
		 medicalstore1.setMedicineCost(1200);
		 medicalstore1.setMedicineName("para");
		 medicalstore1.setMedicineDose(1000);
		 medicalstore1.setExpireDate("2/2/2009");
	        

		 MedicalStore medicalstore2 = testEntityManager.persist(medicalstore);
	     testEntityManager.persist(medicalstore1);

 	     testEntityManager.remove(medicalstore2);

	     List<MedicalStore> medic = (List<MedicalStore>) medicalstoredao.findAll();
	     Assert.assertEquals(medic.size(), 1);

	    }

	 /** View all medicines from pharmacy
	 * 
	 * @param GetAllMedicines
	 * 
	 */
	 
	 @Test
     public void testGetAllProducts() throws Exception{
		
		MedicalStore medicalstore = new MedicalStore();
		medicalstore.setMedicineCost(200);
		medicalstore.setMedicineName("dolo");
		medicalstore.setMedicineDose(100);
		medicalstore.setExpireDate("21/2/2009");
		
		MedicalStore medicalstore1 = new MedicalStore();
		medicalstore1.setMedicineCost(1200);
		medicalstore1.setMedicineName("para");
		medicalstore1.setMedicineDose(1000);
		medicalstore1.setExpireDate("2/2/2009");

        testEntityManager.persist(medicalstore);
        testEntityManager.persist(medicalstore1);
        List<MedicalStore> medic = (List<MedicalStore>) medicalstoredao.findAll();

        Assert.assertEquals(2, medic.size());
    }
	
	 /** Updating medicines from pharmacy
	 * 
	 * @param UpdateMedicine
	 * 
	 */
	
	 @Test
	    public void testUpdateMedicine(){

		 MedicalStore medicalstore = new MedicalStore();
		 medicalstore.setMedicineCost(200);
		 medicalstore.setMedicineName("dolo");
		 medicalstore.setMedicineDose(100);
		 medicalstore.setExpireDate("21/2/2009");
	     testEntityManager.persist(medicalstore);
	     MedicalStore getFromDb = medicalstoredao.findById(medicalstore.getMedicineId()).get();
	     getFromDb.setMedicineCost(15000);
	     testEntityManager.persist(getFromDb);

	     assertThat(getFromDb.getMedicineCost()).isEqualTo(15000);
	    }
}
