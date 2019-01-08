package com.hc.rest.repository.room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hc.rest.entity.room.ItripImage;

/**
 * 图片查询
 * @author LCL
 *
 */
public interface ItripImageRepository extends JpaRepository<ItripImage, Integer>{

	/**
	 * 根据商品ID 商品类型查询图片
	 * @param targetId 商品ID 
	 * @param type 商品类型图片类型(0:酒店图片1:房间图片2:评论图片)
	 * @return 返回图片对象集合
	 */
	@Query(value="select i from ItripImage i where i.targetId =:targetId and type=:type ")
	List<ItripImage> obtainHotelImage(@Param("targetId")Integer targetId,@Param("type")String type);
	
	
	
	@Query(value="select i from ItripImage i where i.indexImgType =:indexImgType and type=:type ")
	List<ItripImage> image(@Param("indexImgType")String indexImgType,@Param("type")String type);
	
}
