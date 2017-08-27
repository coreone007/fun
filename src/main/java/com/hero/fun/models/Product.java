package com.hero.fun.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Table(name = "Product")
public class Product implements Serializable{

	private static final long serialVersionUID = -3707120946496439012L;
	
	public Product() {};
	
	public Product(long categoryid, String name, String desc) {
		this.categoryid = categoryid;
		this.typename = name;
		this.description = desc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Getter @Setter @Column(name = "categoryid")
	private long categoryid;
	
	@Getter @Setter @Column(name = "typename")
	private String typename;
	
	@Getter @Setter @Column(name = "description")
	private String description;
}
