package com.hc.rest.controller.comment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.entity.comment.ItripComment;
import com.hc.rest.service.comment.CommentService;
import com.hc.rest.utils.Result;
import com.hc.rest.vo.ImageBase64Vo;
import com.hc.rest.vo.comment.CommentVo;

@RestController
public class CommentController {
    
    @Autowired
    CommentService commentService;
    
   /* @RequestMapping(value = "/info/save")
    public Result<CommentVo> save(String content,Integer hygieneScore,Integer isHavingImg,Integer productId,Integer productType,Integer userId) {
	return commentService.save(content, hygieneScore, isHavingImg, productId, productType, userId);
    }*/
    
    @RequestMapping(value = "/info/queryList")
    public Result<CommentVo> queryList(Integer productType,Integer productId,String type,Integer pageNo,Integer pageSize,Integer num){
	return commentService.findByUserId(productType,productId,type,pageNo,pageSize,num);
    }
    
    
    @RequestMapping(value = "/info/imgCount")
    public int findByIdAndTypeAndImg(int productType,int productId) {
	return commentService.findByIdAndTypeAndImg(productType, productId);
    }
    
    @RequestMapping(value = "/info/save")
    public Result<ItripComment> save(ItripComment itriptComment,ImageBase64Vo vo) {
	return commentService.save(itriptComment, vo);
    }
    
    

}
