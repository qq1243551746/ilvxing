package com.hc.rest.repository.planeticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hc.rest.entity.planeticket.FlightInformation;

@Repository
public interface FlightInformationRepository extends JpaRepository<FlightInformation, Integer>{
	
	@Query(value="select * from itrip_flight_information where fl_id =:id",nativeQuery=true)
	List<FlightInformation> findByid(@Param("id")Integer fId);
}	
 