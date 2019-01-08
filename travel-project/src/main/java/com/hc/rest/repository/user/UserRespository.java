package com.hc.rest.repository.user;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hc.rest.entity.user.User;

public interface UserRespository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>{

	/**
	 * 新增用户
	 * 
	 * @param activated
	 * @param createDate
	 * @param userCode
	 * @param userName
	 * @param userPassword
	 * @param userType
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO `travel`.`itrip_user` (`qq`,`activated`,`baidu`,`create_date`,`created_by`,`flat_id`,`modified_by`,`modify_date`,`user_code`,`user_name`,`user_password`,`user_type`,`we_chat`,`weibo`,`uuid`) \r\n"
			+ "       VALUES ( DEFAULT,?1,DEFAULT,?2,DEFAULT,DEFAULT,DEFAULT,DEFAULT,?3,?4,?5,?6,DEFAULT,DEFAULT,?7)", nativeQuery = true)
	int save(Integer activated, Date createDate, String userCode, String userName, String userPassword, Integer userType,String uuid);

	/**
	 * 通过用户名查询
	 * 
	 * @param userName
	 * @return
	 */
	@Query(value = "SELECT `id`,`qq`,`activated`,`baidu`,`create_date`,`created_by`,`flat_id`,`modified_by`,`modify_date`,`user_code`,`user_name`,`user_password`,`user_type`,`we_chat`,`weibo` FROM`travel`.`itrip_user`  WHERE `user_name`=?1", nativeQuery = true)
	User findAllByUserName(String userName);

	/**
	 * 通过邮箱/手机号查询
	 * 
	 * @param userCode
	 * @return
	 */
	@Query(value = "SELECT `id`,`qq`,`activated`,`baidu`,`create_date`,`created_by`,`flat_id`,`modified_by`,`modify_date`,`user_code`,`user_name`,`user_password`,`user_type`,`we_chat`,`weibo`,uuid FROM`travel`.`itrip_user`  WHERE `user_code`=?1", nativeQuery = true)
	User findAllByUserCode(String userCode);
	
	/**
	 *修改密码
	 * 
	 * @param userCode
	 * @return
	 */
	@Modifying
    @Transactional
	@Query(value = "UPDATE itrip_user SET user_password=?1 WHERE user_code=?2", nativeQuery = true)
	int updateByUserCode(String pwd,String userCode);
	
	
	
	
	/**
     * 根据手机号码显示数据
     * 
     * @param userCode
     * @return
     */
    User findByUserCode(String userCode);
    /**
     * 根据id查询
     */
    User findAllById(Integer id);
    
    /**
     * 更新个人信息
     * 
     * @param id
     * @param userCode
     * @param userName
     * @param weChat
     * @param QQ
     * @param weibo
     * @param baidu
     * @return
     */
    @Modifying
    @Query(value = "UPDATE itrip_user SET user_name=:userName,we_chat=:weChat, QQ=:QQ,weibo=:weibo WHERE id=:id", nativeQuery = true)
    Integer UpdateUserInformation(@Param("userName")String userName,@Param("QQ")String QQ,@Param("weChat")String weChat,  @Param("weibo")String weibo, @Param("id")Integer id);

	
	
}
