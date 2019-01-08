package com.hc.rest.service.personal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hc.rest.entity.personal.Contact;
import com.hc.rest.entity.user.User;
import com.hc.rest.repository.personal.ContactRepository;
import com.hc.rest.repository.user.UserRespository;
import com.hc.rest.utils.EirunyeException;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;

@Service
public class ContactService {
	@Autowired
	ContactRepository contactRepository;

	@Autowired
	UserRespository userRespository;

	/**
	 * 根据getContact来获取Contact信息
	 *
	 * @param getContact
	 *            参数getContact
	 * @return Json Contact
	 */
	@SuppressWarnings("unchecked")
	public Result<Contact> GetContact(Contact getContact) throws Exception {
		Contact contact = contactRepository.save(getContact);
		return ResultUtil.getResult(ResultEnum.SUCCESS, contact);

	}

	/**
	 * 按照id删除联系人
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<String> deleteById(Integer id) {
		contactRepository.deleteById(id);

		Contact contact = contactRepository.findAllById(id);
		if (contact == null) {
			throw new EirunyeException(ResultEnum.SUCCESS);
		} else {
			return ResultUtil.error(-1, "删除数据失败!!!");
		}
	}

	/**
	 * 
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Contact findById(Integer id) {
		return contactRepository.findAllById(id);
	}

	/**
	 * 修改联系人信息
	 * 
	 * @param updateContact
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public Result<Contact> updateContact(Contact updateContact) throws Exception {
		Contact contact = contactRepository.findAllById(updateContact.getId());
		Integer updatecon = null;
		if (contact != null) {
			updatecon = contactRepository.Updatecontact(updateContact.getLinkUserName(), updateContact.getLinkPhone(), updateContact.getLinkIdCard(), updateContact.getLinkIdCardType(), updateContact.getId());
		}
		return ResultUtil.getResult(ResultEnum.SUCCESS, updatecon);
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Result<Contact> queryContact(Integer userId) throws Exception {
		List<Contact> listContact = contactRepository.findByUserId(userId);
		return ResultUtil.getResult(ResultEnum.SUCCESS, listContact);
	}

	/**
	 * 根据ID查询数据
	 * 
	 * @param id
	 * @return
	 */
	public User findAllId(Integer id) {
		return userRespository.findAllById(id);
	}

	/**
	 * 
	 * 根据id修改
	 * 
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public Result<User> updateUser(User updatecode) {
		User updateuser = userRespository.findAllById(updatecode.getId());
		Integer user = null;
		if (updateuser != null) {
			user = userRespository.UpdateUserInformation(updatecode.getUserName(), updatecode.getQQ(), updatecode.getWeChat(), updatecode.getWeibo(), updatecode.getId());
		}
		return ResultUtil.getResult(ResultEnum.SUCCESS, user);
	}

}
