package com.hc.rest.repository.tour;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hc.rest.entity.tour.ItripAreaDic;

/**
 * 地区
 * 
 * @author MaiBenBen
 *
 */
public interface ItripAreaDicRepository extends JpaRepository<ItripAreaDic, Integer> {
	/**
	 * 根据地区id/地区名称查询
	 * 
	 * @param id
	 *            地区id
	 * @param name
	 *            地区名称
	 * @return
	 *//*
		 * @Query(value =
		 * "select i from  ItripAreaDic i where i.id=:id or i.name=:name ")
		 * List<ItripAreaDic> idNameInfo(@Param("id") Integer id, @Param("name") String
		 * name);
		 */

	/**
	 * 子查询市里的街区
	 * 
	 * @return
	 */
	@Query(value = "select ic from ItripAreaDic ic where ic.parent=:id and level=3")
	List<ItripAreaDic> idInfo(@Param("id") Integer id);
}
