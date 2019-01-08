package com.hc.rest.mapper.commentsql;

public class CommentMapperSql {
    
    
//    public String findByid(int productType,int productId,int pageNo,int pageSize) {
//	StringBuffer sql = new StringBuffer("select u.user_name userName,com.trip_mode tripMode,"
//		+"com.user_id userId,com.service_score serviceScore,com.score score,com.product_type productType "
//		+",com.product_id productId,"
//		+"com.position_score positionScore,com.order_id orderId,com.modify_date modifyDate,"
//		+"com.modified_by modifiedBy,com.is_ok isOk,"
//		+"com.is_having_img isHavingImg,com.id,com.hygiene_score hygieneScore,"
//		+"com.hotel_id hotelId,com.facilities_score facilitiesScore,"
//		+"com.creation_date creationDate,com.created_by createdBy,com.content from itrip_comment com "
//		+ "INNER JOIN itrip_user u on com.user_id = u.id INNER join itrip_product_store s on "
//		+ "com.product_id = s.product_id  where s.product_id="+productId+" and s.product_type ="+productType+" limit "+pageNo+","+pageSize);
//	return sql.toString();
//    }
    
    public String findByid(int productType,int productId) {
	StringBuffer sql = new StringBuffer("select u.user_name userName,com.trip_mode tripMode,"
		+"com.user_id userId,com.service_score serviceScore,com.score score,com.product_type productType "
		+",com.product_id productId,"
		+"com.position_score positionScore,com.order_id orderId,com.modify_date modifyDate,"
		+"com.modified_by modifiedBy,com.is_ok isOk,"
		+"com.is_having_img isHavingImg,com.id,com.hygiene_score hygieneScore,"
		+"com.hotel_id hotelId,com.facilities_score facilitiesScore,"
		+"com.creation_date creationDate,com.created_by createdBy,com.content from itrip_comment com "
		+ "INNER JOIN itrip_user u on com.user_id = u.id INNER join itrip_product_store s on "
		+ "com.product_id = s.product_id  where s.product_id="+productId+" and s.product_type ="+productType);
	return sql.toString();
    }
    
    
    public String findByidAndType(int productType,int productId) {
	StringBuffer sql = new StringBuffer("select u.user_name userName,com.trip_mode tripMode,"
		+"com.user_id userId,com.service_score serviceScore,com.score score,com.product_type productType "
		+",com.product_id productId,"
		+"com.position_score positionScore,com.order_id orderId,com.modify_date modifyDate,"
		+"com.modified_by modifiedBy,com.is_ok isOk,"
		+"com.is_having_img isHavingImg,com.id,com.hygiene_score hygieneScore,"
		+"com.hotel_id hotelId,com.facilities_score facilitiesScore,"
		+"com.creation_date creationDate,com.created_by createdBy,com.content from itrip_comment com "
		+ "INNER JOIN itrip_user u on com.user_id = u.id INNER join itrip_product_store s on "
		+ "com.product_id = s.product_id  where s.product_id="+productId+" and s.product_type ="+productType);
	return sql.toString();
	
    }
    
    
    public String findByIdAndTypeAndImg(int productType,int productId) {
	StringBuffer sql = new StringBuffer("select com.id,u.user_name userName,com.trip_mode tripMode,\r\n" + 
		"com.user_id userId,com.service_score serviceScore,com.score score,com.product_type productType\r\n" + 
		",com.product_id productId,\r\n" + 
		"com.position_score positionScore,com.order_id orderId,com.modify_date modifyDate,\r\n" + 
		"com.modified_by modifiedBy,com.is_ok isOk,\r\n" + 
		"com.is_having_img isHavingImg,com.hygiene_score hygieneScore,\r\n" + 
		"com.hotel_id hotelId,com.facilities_score facilitiesScore,\r\n" + 
		"com.creation_date creationDate,com.created_by createdBy,com.content "
		+ "from itrip_comment com INNER JOIN itrip_user u on com.user_id = u.id "
		+ "INNER join itrip_product_store s on com.product_id = s.product_id  "
		+ "where s.product_id="+productId+" and s.product_type = "+productType+" and com.is_having_img=1");
	return sql.toString();
	
    }
    
//    public String findByIdAndTypeAndImgPage(int productType,int productId,int pageNo,int pageSize) {
//	StringBuffer sql = new StringBuffer("select com.id,u.user_name userName,com.trip_mode tripMode,\r\n" + 
//		"com.user_id userId,com.service_score serviceScore,com.score score,com.product_type productType\r\n" + 
//		",com.product_id productId,\r\n" + 
//		"com.position_score positionScore,com.order_id orderId,com.modify_date modifyDate,\r\n" + 
//		"com.modified_by modifiedBy,com.is_ok isOk,\r\n" + 
//		"com.is_having_img isHavingImg,com.hygiene_score hygieneScore,\r\n" + 
//		"com.hotel_id hotelId,com.facilities_score facilitiesScore,\r\n" + 
//		"com.creation_date creationDate,com.created_by createdBy,com.content "
//		+ "from itrip_comment com INNER JOIN itrip_user u on com.user_id = u.id "
//		+ "INNER join itrip_product_store s on com.product_id = s.product_id  "
//		+ "where s.product_id="+productId+" and s.product_type = "+productType+" and "
//		+ "com.is_having_img=1 limit "+pageNo+","+pageSize);
//	return sql.toString();
//    }
    
    public String findByIdAndTypeAndImgPage(int productType,int productId) {
	StringBuffer sql = new StringBuffer("select com.id,u.user_name userName,com.trip_mode tripMode,\r\n" + 
		"com.user_id userId,com.service_score serviceScore,com.score score,com.product_type productType\r\n" + 
		",com.product_id productId,\r\n" + 
		"com.position_score positionScore,com.order_id orderId,com.modify_date modifyDate,\r\n" + 
		"com.modified_by modifiedBy,com.is_ok isOk,\r\n" + 
		"com.is_having_img isHavingImg,com.hygiene_score hygieneScore,\r\n" + 
		"com.hotel_id hotelId,com.facilities_score facilitiesScore,\r\n" + 
		"com.creation_date creationDate,com.created_by createdBy,com.content "
		+ "from itrip_comment com INNER JOIN itrip_user u on com.user_id = u.id "
		+ "INNER join itrip_product_store s on com.product_id = s.product_id  "
		+ "where s.product_id="+productId+" and s.product_type = "+productType+" and "
		+ "com.is_having_img=1");
	return sql.toString();
    }
    
    
    public String findIdByContent(String content) {
	String sql = "select id from itrip_comment where content = '"+content+"'";
	System.out.println("==============="+sql);
	return sql;
    }
    

}
