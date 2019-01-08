package com.hc.rest.controller.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.entity.personal.Contact;
import com.hc.rest.entity.user.User;
import com.hc.rest.service.personal.ContactService;
import com.hc.rest.utils.EirunyeException;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;

@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    /**
     * 新增联系人
     * 
     * @param contact
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/info/app")
    public Result<Contact> appContact(Contact contact) throws Exception {
	return contactService.GetContact(contact);

    }

    /**
     * 根据id删除联系人
     * 
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/info/delete")
    public Result<String> deleteContactInfo(Integer id) throws Exception {
	if (null == id)
	    throw new EirunyeException(ResultEnum.UNKNOWN_ERROR);
	return contactService.deleteById(id);
    }

    /**
     * 根据id修改联系人
     * 
     * @param contact
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/info/update")
    public Result<Contact> updateConatct(Contact contact) throws Exception {
	return contactService.updateContact(contact);
    }

    /**
     * 根据id查询联系人
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/info/findById")
    public Contact findById(Integer id) {
    	return contactService.findById(id);
    }

    /**
     * 查询联系人
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/info/query")
    public Result<Contact> queryContact(Integer userId) throws Exception {
	return contactService.queryContact(userId);
    }
    
    
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/info/findByUserid")
    public User findAllId(Integer id) {
    	System.out.println("+========================="+id);
	return contactService.findAllId(id);

    }

    /**
     * 根据id修改个人信息
     * 
     * @param Updatecode
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/info/UpdateUser")
    public Result<User> updateUser(User updateuser) throws Exception {
    	System.out.println("+========================="+updateuser.getId());
    	System.out.println("+========================="+updateuser.getQQ());
    	System.out.println("+========================="+updateuser.getWeChat());
    	System.out.println("+========================="+updateuser.getWeibo());
    	System.out.println("+========================="+updateuser.getUserName());
	return contactService.updateUser(updateuser);
    }

}
