package com.hc.rest.mapper.comment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.hc.rest.mapper.commentsql.CommentMapperSql;
import com.hc.rest.vo.comment.CommentVo;

@Mapper
public interface CommentMapper {

	/**
	 * 查询当前商品全部评论 分页显示
	 * 
	 * @return
	 */
	@SelectProvider(method = "findByid", type = CommentMapperSql.class)
	public List<CommentVo> findByid(int productType, int productId);

	/**
	 * 查询当前商品总共多少条评论，用于计算分页总页数
	 * 
	 * @param productType
	 * @param productId
	 * @return
	 */
	@SelectProvider(method = "findByidAndType", type = CommentMapperSql.class)
	public List<CommentVo> findByidAndType(int productType, int productId);

	/**
	 * 查询当前商品总共有多少条有图片的评论，用于计算分页总页数
	 * 
	 * @param productType
	 * @param productId
	 * @param isHavingImg
	 * @return
	 */
	@SelectProvider(method = "findByIdAndTypeAndImg", type = CommentMapperSql.class)
	public List<CommentVo> findByIdAndTypeAndImg(int productType, int productId);

	/**
	 * 查询当前商品总共有多少条有图片的评论,分页显示
	 * 
	 * @param productType
	 * @param productId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SelectProvider(method = "findByIdAndTypeAndImgPage", type = CommentMapperSql.class)
	public List<CommentVo> findByIdAndTypeAndImgPage(int productType, int productId);

	/**
	 * 根据评论内容查询该条评论的id，用于新增图片
	 * 
	 * @param content
	 * @return
	 */
	@SelectProvider(method = "findIdByContent", type = CommentMapperSql.class)
	public List<CommentVo> findIdByContent(String content);
}
