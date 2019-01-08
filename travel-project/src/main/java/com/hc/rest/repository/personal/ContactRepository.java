package com.hc.rest.repository.personal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hc.rest.entity.personal.Contact;


/**
 * 联系人接口
 * 
 * @author 邓爱青
 *
 */

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    /**
     * 根据id查询联系人
     * 
     * @param id
     * @return
     */
    Contact findAllById(Integer id);
    
    /**
     * 查询用户联系人
     * @param userId
     * @return
     */
    List<Contact> findByUserId(Integer userId);
    	

    /**
     * 更新联系人
     * 
     * @param linkUserName
     * @param linkPhone
     * @param linkIdCard
     * @param linkIdCardType
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "UPDATE itrip_user_link_user SET link_user_name =:linkUserName,link_phone =:linkPhone,link_id_card =:linkIdCard, link_id_card_type =:linkIdCardType WHERE id =:id",nativeQuery=true)
    Integer Updatecontact(@Param("linkUserName")String linkUserName,@Param("linkPhone")String linkPhone,@Param("linkIdCard")String linkIdCard,@Param("linkIdCardType")Integer linkIdCardType,@Param("id")Integer id);
}
