package com.hc.rest.service.comment;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hc.rest.entity.comment.ItripComment;
import com.hc.rest.entity.room.ItripImage;
import com.hc.rest.mapper.comment.CommentMapper;
import com.hc.rest.oss.service.OssService;
import com.hc.rest.repository.comment.CommentImageRepository;
import com.hc.rest.repository.comment.CommentRepository;
import com.hc.rest.repository.comment.ItripImgRepository;
import com.hc.rest.service.order.HotelOrderService;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;
import com.hc.rest.vo.ImageBase64Vo;
import com.hc.rest.vo.comment.CommentVo;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    CommentImageRepository commentImageRepository;
    
    @Autowired
    ItripImgRepository itripImageRepository;

    @Autowired
    private OssService ossService;
    
    @Autowired
    HotelOrderService hotelOrderService;
    
    
    /**
     * 新增评论
     * 
     * @param comment
     * @return
     */
    /*
    @SuppressWarnings("unchecked")
    @Transactional
    public Result<CommentVo> save(String content,Integer hygieneScore,Integer isHavingImg,Integer productId,Integer productType,Integer userId) {
	Integer num = commentRepository.add(content, hygieneScore, isHavingImg, productId, productType, userId);
	List<CommentVo> comVo = null;
	if(num>0) {
	    comVo = commentMapper.findIdByContent(content);
	}
	return  ResultUtil.getResult(ResultEnum.SUCCESS, comVo);
    }*/
    
    /**
     * 新增评论
     * 
     * @param comment
     * @return
     */
    @SuppressWarnings("unchecked")
    @Transactional
    public Result<ItripComment> save(ItripComment itripCom,ImageBase64Vo vo) {
	itripCom.setCreationDate(new Date());
	ItripComment itripComment = commentRepository.save(itripCom);	
	hotelOrderService.updataById("4", itripComment.getOrderId());
	if(itripComment.getIsHavingImg()==1) {
	    vo.setTableName("travel-hc");
		Result<String> rs = ossService.uploadBase64(vo);
		ItripImage itripImage=new ItripImage();
		itripImage.setImgUrl("https://travel-hc.oss-cn-shenzhen.aliyuncs.com/"+rs.getData());
		itripImage.setTargetId(itripComment.getId());
		itripImage.setType("2");//2代表评论图片
		itripImageRepository.save(itripImage);
	}
	
	return  ResultUtil.getResult(ResultEnum.SUCCESS, itripComment);
    }
    
    

//    /**
//     * 分页查询当前商品评论
//     * 
//     * @param productType
//     * @param productId
//     *            当前商品id
//     * @return
//     */
//    @SuppressWarnings("unchecked")
//    public Result<CommentVo> findByUserId(Integer productType, Integer productId, String type, Integer no,
//	    Integer pageSize, Integer num) {
//	List<CommentVo> commentVo = null;
//	// 如果num=0就查询所有评论，等于1就查询有图片的评论
//	if (num == 0) {
//	    // 计算总页数
//	    List<CommentVo> commentSum = commentMapper.findByidAndType(productType, productId);
//	    if(commentSum.size()>0) {
//		Integer commentCount = commentSum.size() % pageSize == 0 ? commentSum.size() / pageSize
//			    : commentSum.size() / pageSize + 1;
//		// 设置当前页数
//		    if (no == null || no < 1) {
//			no = 1;
//		    } else if (no > commentCount) {
//			no = commentCount;
//		    }
//		    Integer pageNo = (no - 1) * pageSize;
//		    commentVo = commentMapper.findByid(productType, productId, pageNo, pageSize);
//		    List<ItripImage> itripImage = null;
//		    for (CommentVo com : commentVo) {
//			com.setPageNo(no);
//			com.setPageCount(commentCount);
//			com.setCommentCount(commentSum.size());
//			com.setNum(num);
//			if (com.getIsHavingImg() == 1) {
//			    itripImage = commentImageRepository.queryByIdAndType(com.getId(), type);
//			    com.setImgUrl(itripImage);
//			}
//		    }
//	    }else {
//		commentVo = null;
//	    }
//	    
//	    
//	} else if (num == 1) {
//	 // 计算总页数
//	    List<CommentVo> commentSum = commentMapper.findByIdAndTypeAndImg(productType, productId);
//	    if(commentSum.size()>0) {
//		Integer commentCount = commentSum.size() % pageSize == 0 ? commentSum.size() / pageSize
//			    : commentSum.size() / pageSize + 1;
//		    // 设置当前页数
//		    if (no == null || no < 1) {
//			no = 1;
//		    } else if (no > commentCount) {
//			no = commentCount;
//		    }
//		    Integer pageNo = (no - 1) * pageSize;
//		    commentVo = commentMapper.findByIdAndTypeAndImgPage(productType, productId, pageNo, pageSize);
//		    List<ItripImage> itripImage = null;
//		    for (CommentVo com : commentVo) {
//			com.setPageNo(no);
//			com.setPageCount(commentCount);
//			com.setCommentCount(commentSum.size());
//			com.setNum(num);
//			itripImage = commentImageRepository.queryByIdAndType(com.getId(), type);
//			com.setImgUrl(itripImage);
//			
//		    }
//	    }else {
//		commentVo = null;
//	    }
//	    
//	}
//
//	return ResultUtil.getResult(ResultEnum.SUCCESS, commentVo);
//
//    }
    
    /**
     * 分页当前商品评论
     * 
     * @param productType
     * @param productId
     *            当前商品id
     * @return
     */
    @SuppressWarnings("unchecked")
    public Result<CommentVo> findByUserId(Integer productType, Integer productId, String type, Integer no,
	    Integer pageSize, Integer num) {
	List<CommentVo> commentVo = null;
	// 如果num=0就查询所有评论，等于1就查询有图片的评论
	if (num == 0) {
		    commentVo = commentMapper.findByid(productType, productId);
		    List<ItripImage> itripImage = null;
		    for (CommentVo com : commentVo) {
			com.setCommentCount(commentVo.size());
			com.setNum(num);
			if (com.getIsHavingImg() == 1) {
			    itripImage = commentImageRepository.queryByIdAndType(com.getId(), type);
			    com.setImgUrl(itripImage);
			}
		    }
	    
	    
	} else if (num == 1) {
		    commentVo = commentMapper.findByIdAndTypeAndImgPage(productType, productId);
		    List<ItripImage> itripImage = null;
		    for (CommentVo com : commentVo) {
			com.setCommentCount(commentVo.size());
			com.setNum(num);
			itripImage = commentImageRepository.queryByIdAndType(com.getId(), type);
			com.setImgUrl(itripImage);
			
		    }
	    
	}

	return ResultUtil.getResult(ResultEnum.SUCCESS, commentVo);

    }
    
    
    

    /**
     * 查询当前商品有图片的评论总数
     * 
     * @param productType
     * @param productId
     *            当前商品id
     * @param isHavingImg
     * @return
     */
    public int findByIdAndTypeAndImg(Integer productType, Integer productId) {
	List<CommentVo> commentVo = commentMapper.findByIdAndTypeAndImg(productType, productId);
	Integer sum;
	if(commentVo.size()<1) {
	    sum = 0;
	}else {
	    sum = commentVo.size();
	}
	return sum;

    }

}
