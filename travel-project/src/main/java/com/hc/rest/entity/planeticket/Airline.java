package com.hc.rest.entity.planeticket;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 航空公司类
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "itrip_Airline")
public class Airline implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name", columnDefinition = "varchar(40) not null COMMENT'航空公司名称'")
	private String name;

	public Airline() {
		super();
	}

	public Airline(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "Airline [id=" + id + ", name=" + name + "]";
	}

}
