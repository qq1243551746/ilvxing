package com.hc.rest.entity.tour;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "itrip_area_dic")
public class ItripAreaDic implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;// '主键',

	private String name;// '区域名称',

	private String areaNo;// '区域编号',

	private Integer parent;// '父级区域',

	private Integer isActivated;// '0:未激活 1:已激活',

	private Integer isTradingArea;// '是否是商圈(0:不是 1:是)',

	private Integer isHot;// (0:不是 1：是)',

	private Integer level;// '区域级别(0:国家级 1:省级 2:市级 3:县/区)',

	private Integer isChina;// '1:国内 2：国外',

	private String pinyin;

	private Date creationDate;

	private Integer createdBy;

	private Date modifyDate;

	private Integer modifiedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreaNo() {
		return areaNo;
	}

	public void setAreaNo(String areaNo) {
		this.areaNo = areaNo;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Integer getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Integer isActivated) {
		this.isActivated = isActivated;
	}

	public Integer getIsTradingArea() {
		return isTradingArea;
	}

	public void setIsTradingArea(Integer isTradingArea) {
		this.isTradingArea = isTradingArea;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getIsChina() {
		return isChina;
	}

	public void setIsChina(Integer isChina) {
		this.isChina = isChina;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public ItripAreaDic(Integer id, String name, String areaNo, Integer parent, Integer isActivated,
			Integer isTradingArea, Integer isHot, Integer level, Integer isChina, String pinyin, Date creationDate,
			Integer createdBy, Date modifyDate, Integer modifiedBy) {
		super();
		this.id = id;
		this.name = name;
		this.areaNo = areaNo;
		this.parent = parent;
		this.isActivated = isActivated;
		this.isTradingArea = isTradingArea;
		this.isHot = isHot;
		this.level = level;
		this.isChina = isChina;
		this.pinyin = pinyin;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
		this.modifyDate = modifyDate;
		this.modifiedBy = modifiedBy;
	}

	public ItripAreaDic() {
		super();
	}

	@Override
	public String toString() {
		return "ItripAreaDic [id=" + id + ", name=" + name + ", areaNo=" + areaNo + ", parent=" + parent
				+ ", isActivated=" + isActivated + ", isTradingArea=" + isTradingArea + ", isHot=" + isHot + ", level="
				+ level + ", isChina=" + isChina + ", pinyin=" + pinyin + ", creationDate=" + creationDate
				+ ", createdBy=" + createdBy + ", modifyDate=" + modifyDate + ", modifiedBy=" + modifiedBy + "]";
	}

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;// '主键',
	 * 
	 * @Column(name = "name", columnDefinition =
	 * "varchar(255) NOT NULL COMMENT '区域名称'") private String name;// '区域名称',
	 * 
	 * @Column(name = "areaNo", columnDefinition =
	 * "varchar(255) NOT NULL COMMENT '区域编号'") private Integer areaNo;// '区域编号',
	 * 
	 * @Column(name = "parent", columnDefinition =
	 * "bigint(255) NOT NULL COMMENT '父级区域'") private Integer parent;// '父级区域',
	 * 
	 * @Column(name = "isActivated", columnDefinition =
	 * "int(11) NOT NULL COMMENT '0:未激活 1:已激活'") private Integer isActivated;//
	 * '0:未激活 1:已激活',
	 * 
	 * @Column(name = "isTradingArea", columnDefinition =
	 * "int(11) NOT NULL COMMENT '是否是商圈(0:不是 1:是)'") private Integer
	 * isTradingArea;// '是否是商圈(0:不是 1:是)',
	 * 
	 * @Column(name = "isHot", columnDefinition =
	 * "int(1) NOT NULL COMMENT '(0:不是 1：是)'") private Integer isHot;// (0:不是 1：是)',
	 * 
	 * @Column(name = "level", columnDefinition =
	 * "int(11) NOT NULL COMMENT '区域级别(0:国家级 1:省级 2:市级 3:县/区)'") private Integer
	 * level;// '区域级别(0:国家级 1:省级 2:市级 3:县/区)',
	 * 
	 * @Column(name = "isChina", columnDefinition =
	 * "int(1) NOT NULL COMMENT '1:国内 2：国外'") private Integer isChina;// '1:国内
	 * 2：国外',
	 * 
	 * @Column(name = "pinyin", columnDefinition =
	 * "varchar(10) NOT NULL COMMENT ''") private String pinyin;
	 * 
	 * @Column(name = "creationDate", columnDefinition =
	 * "datetime NOT NULL COMMENT ''") private Integer creationDate;
	 * 
	 * @Column(name = "createdBy", columnDefinition =
	 * "bigint(11) NOT NULL COMMENT ''") private Integer createdBy;
	 * 
	 * @Column(name = "modifyDate", columnDefinition =
	 * "datetime NOT NULL COMMENT ''") private Integer modifyDate;
	 * 
	 * @Column(name = "modifiedBy", columnDefinition =
	 * "bigint(11) NOT NULL COMMENT ''") private Integer modifiedBy;
	 */

}
