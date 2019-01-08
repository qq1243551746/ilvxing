package com.hc.rest.repository.planeticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hc.rest.entity.planeticket.ManageFlightInfor;
@Repository
public interface ManageFlightInforRepository extends JpaRepository<ManageFlightInfor, Integer>{
	
	
	
}
