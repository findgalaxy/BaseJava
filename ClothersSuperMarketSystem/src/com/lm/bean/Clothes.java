package com.lm.bean;

import java.io.Serializable;

public class Clothes implements Serializable{
	 private String id;       //商品编号
	 private String style;    //商品款式
	 private String brand;    //商品品牌
	 private String color;    //商品颜色
	 private String size;     //商品尺码
	 private int num;         //库存数量
	 private float price;     //商品单价
	 private String description;//商品描述
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Clothes(String id, String style, String brand, String color, String size, int num, float price,
			String description) {
		super();
		this.id = id;
		this.style = style;
		this.brand = brand;
		this.color = color;
		this.size = size;
		this.num = num;
		this.price = price;
		this.description = description;
	}
	public Clothes() {
		super();
	}
}
