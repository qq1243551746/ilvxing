package com.hc.rest.repository.comment;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hc.rest.entity.comment.ItripComment;

/**
 * 评论
 * @author JAY
 *
 */
public interface CommentRepository extends JpaRepository<ItripComment, Integer> {
    
    /**
     * 新增评论
     * @param content 评论内容
     * @param hygieneScore 卫生评分（这里没什么卵用）
     * @param isHavingImg （0无图片 1有图片）
     * @param productId 商品id
     * @param productType 商品类型（0旅游产品 1酒店产品）
     * @param userId 用户编号
     * @return
     */
    @Modifying
    @Transactional
    @Query(value="insert into itrip_comment (content,creation_date,hygiene_score,is_having_img,product_id,product_type,user_id) VALUES(?1,now(),?2,?3,?4,?5,?6)", nativeQuery = true)
    public Integer add(String content,Integer hygieneScore,Integer isHavingImg,Integer productId,Integer productType,Integer userId);
}
