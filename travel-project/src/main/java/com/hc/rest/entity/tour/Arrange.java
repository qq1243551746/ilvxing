package com.hc.rest.entity.tour;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 行程表
 * 
 * @author MaiBenBen
 *
 */
@Entity
@Table(name = "itrip_Arrange")
public class Arrange implements Serializable {
	private static final long serialVersionUID = 3564138510492780842L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;// 行程id

	@Column(name = "parent", columnDefinition = "bigint(255) NOT NULL COMMENT '父级区域!'")
	private Integer parent;// '父级区域'

	@Column(name = "name", columnDefinition = "VARCHAR(300) NOT NULL COMMENT '时间!'")
	private Integer name;// 时间
	
	@Column(name = "level", columnDefinition = "int(11) NOT NULL COMMENT '区域级别(0:天数 1:时间段  2:小时/分钟)!'")
	private Integer level;// '区域级别(0:天数 1:时间段 2:小时/分钟)'

	@Column(name = "travelTiem", columnDefinition = "VARCHAR(300) NOT NULL COMMENT '出发日期!'")
	private Date travelTiem;// 出发日期

	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", columnDefinition = "datetime DEFAULT NULL COMMENT '创建时间'")
	private Date createTime; // 创建时间

	@Temporal(TemporalType.DATE)
	@Column(name = "update_time", columnDefinition = "datetime DEFAULT NULL COMMENT '更新时间'")
	private Date updateTime;// 更新时间

}
