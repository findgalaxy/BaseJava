package com.lm.bean;

import java.io.Serializable;
public class OrderItem implements Serializable{
	private int itemId;//商品id
	private Clothes clothes;//商品
	private int shoppingNum;//商品数量
	private float sum;//购买的金额
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public Clothes getClothes() {
		return clothes;
	}
	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}
	public int getShoppingNum() {
		return shoppingNum;
	}
	public void setShoppingNum(int shoppingNum) {
		this.shoppingNum = shoppingNum;
	}
	public OrderItem(int itemId, Clothes clothes, int shoppingNum, float sum) {
		super();
		this.itemId = itemId;
		this.clothes = clothes;
		this.shoppingNum = shoppingNum;
		this.sum = sum;
	}
	public OrderItem() {
		super();
	}
}
