package com.hc.rest.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hc.rest.entity.room.ItripImage;
import com.hc.rest.repository.comment.ItripImgRepository;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;

@Service
@Transactional
public class ItripImageService {
    @Autowired
    ItripImgRepository itripImageRepository;
    
    /**
     * 新增图片
     * @param itripImage
     * @return
     */
    @SuppressWarnings("unchecked")
    public Result<ItripImage> save(ItripImage itripImage) {
	ItripImage image = itripImageRepository.save(itripImage);
	return ResultUtil.getResult(ResultEnum.SUCCESS, image);
    }

}
