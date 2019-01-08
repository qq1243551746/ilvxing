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
 * 主题表
 * 
 * @author MaiBenBen
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "itrip_Theme")
public class Theme implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer themeid;// 主题主键

	@Column(name = "parent", columnDefinition = "bigint(255) NOT NULL COMMENT ' 父级区域'")
	private Integer parent;// 父级区域

	@Column(name = "themeName", columnDefinition = "VARCHAR(200) NOT NULL COMMENT '主题名称'")
	private String themeName;// 主题名称

	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", columnDefinition = "datetime DEFAULT NULL COMMENT '创建时间'")
	private Date createTime; // 创建时间

	@Temporal(TemporalType.DATE)
	@Column(name = "update_time", columnDefinition = "datetime DEFAULT NULL COMMENT '更新时间'")
	private Date updateTime;// 更新时间

	@Column(name = "level", columnDefinition = "int(11) NOT NULL COMMENT '区域级别(0:主题 1:主题子类 2:地区(市级)子子类级别)'")
	private Integer level;// 区域级别(0:主题 1:主题子类 2:地区(市级)子子类级别)

	public Theme(Integer themeid, Integer parent, String themeName, Date createTime, Date updateTime, Integer level) {
		super();
		this.themeid = themeid;
		this.parent = parent;
		this.themeName = themeName;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.level = level;
	}

	public Theme() {
		super();
	}

	@Override
	public String toString() {
		return "Theme [themeid=" + themeid + ", parent=" + parent + ", themeName=" + themeName + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", level=" + level + "]";
	}

	public Integer getThemeid() {
		return themeid;
	}

	public void setThemeid(Integer themeid) {
		this.themeid = themeid;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}