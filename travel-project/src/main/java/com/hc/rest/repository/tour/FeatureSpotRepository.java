package com.hc.rest.repository.tour;

import org.springframework.data.jpa.domain.Specification;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hc.rest.entity.tour.FeatureSpot;
/**
 * 景点
 * @author MaiBenBen
 *
 */
public interface FeatureSpotRepository extends JpaRepository<FeatureSpot, Integer> {

	/**
	 * 分页查询
	 * 
	 * @param specification
	 *            动态查询
	 * @param pageable
	 *            分页
	 * @return
	 */
	List<FeatureSpot> findAll(Specification<FeatureSpot> specification, Pageable pageable);
}
