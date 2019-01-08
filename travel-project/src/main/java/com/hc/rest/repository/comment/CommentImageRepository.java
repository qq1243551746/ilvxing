package com.hc.rest.repository.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hc.rest.entity.room.ItripImage;

/**
 * 查询评论图片
 * @author JAY
 *
 */
public interface CommentImageRepository extends JpaRepository<ItripImage,Integer>{
    /**
     * 根据商品id和类型查询评论图片
     * @param targetId
     * @param type
     * @return
     */
    @Query(value="select i from ItripImage i where i.targetId =:targetId and type=:type ")
    List<ItripImage> queryByIdAndType(@Param("targetId")Integer targetId,@Param("type")String type);

}
