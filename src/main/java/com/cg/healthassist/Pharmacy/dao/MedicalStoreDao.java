package com.cg.healthassist.Pharmacy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthassist.Pharmacy.dto.MedicalStore;

/** The MedicalStoreDao layer provides jpa repository conectivity
 * 
 * @author Rohith
 * @version 2.0
 * 
 */
@Repository
public interface MedicalStoreDao extends JpaRepository<MedicalStore,Integer>{



}
