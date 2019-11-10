package com.lm.ui;


import java.util.List;

import com.lm.bean.Clothes;
import com.lm.bean.Order;
import com.lm.bean.OrderItem;
import com.lm.service.ClothesService;
import com.lm.service.OrderService;
import com.lm.service.impl.ClothesServiseImpl;
import com.lm.service.impl.OrderServiceImpl;
import com.lm.utils.ConsoleTable;
import com.lm.utils.DateUtils;
import com.lm.utils.WorkException;

public class HomePageClass extends Baseclass {
	private OrderService orderService=new OrderServiceImpl();
	private ClothesService clothesService=new ClothesServiseImpl();

	public void show() {
		showProducts();
		println("欢迎您!尊贵的客户:" + currUser.getUsername() + "!");
		menu();
	}	
		private void menu() {
		boolean flag = true;
		while (flag) {
			println(getString("user.function"));
			println(getString("info.select"));
			String select = input.nextLine();
			switch (select) {
			case "0": // 退出
				flag = false;
				System.exit(0);
				break;
			case "1": // 查询所有订单
				findList();
				flag = false;
				break;

			case "2": // 查找订单
				findOrderById();
				flag = false;
				break;

			case "3": // 购买
				try {
					BuyProducts();
					flag = false;
				} catch (WorkException e) {
					println(e.getMessage());
				}
				break;
			case"4"://显示商品
				show();
				break;
			default:
				println(getString("input.error"));
				break;
			}
		}
	}

	private void BuyProducts() throws WorkException{
		//生成订单
		boolean flag=true;
		int count=1;
		float sum=0.0f;//总金额
		Order order=new Order();//生成订单
		while(flag) {
			println(getString("product.input.id"));
			String id = input.nextLine();
			println(getString("product.input.shoppingNum"));
			String shoppingNum = input.nextLine();
			OrderItem orderItem=new OrderItem();
			Clothes clothes = clothesService.findById(id);
			
			
			//比较库存
			int num=Integer.parseInt(shoppingNum);
			if(num>clothes.getNum()) {
				throw new WorkException("product.num.error");
			}
			
			//一条订单的详细数据
			clothes.setNum(clothes.getNum()-num);//刷新库存
			orderItem.setClothes(clothes);
			orderItem.setShoppingNum(num);
			orderItem.setSum(clothes.getPrice()*num);
			sum +=orderItem.getSum();
			orderItem.setItemId(count++);
			order.getOrderItemList().add(orderItem);
			
			println(getString("product.buy.con"));
			String isBuy = input.nextLine();
			switch(isBuy) {
			case"1":
				flag=true;
				break;
			case"2":
				flag=false;
				break;
				default:
					flag=false;
					break;
			}
		}
		order.setCreateDate(DateUtils.toDate(new java.util.Date()));
		order.setUserId(currUser.getId());
		order.setSum(sum);
		order.setOrderId(orderService.list().size()+1);
		orderService.buyProducts(order);
		clothesService.update();
		show();
		}
	
    
	private void findOrderById() {
		println(getString("product.order.input.oid"));
		String oid=input.nextLine();
		Order order=orderService.findById(Integer.parseInt(oid));
		if(order!=null) {
			showOrder(order);
		}else {
			println(getString("product.order.error"));
		}
		menu();
		}
	

	private void findList() {
		List<Order> list=orderService.list();
		for(Order o:list) {
			showOrder(o);
		}
		menu();
	}
	
	

	private void showOrder(Order o) {
		print(getString("product.order.oid") + o.getOrderId());
		print("\t"+getString("product.order.cerateDate")+o.getCreateDate());
		println("\t"+getString("product.order.sum")+o.getSum());
		ConsoleTable t=new ConsoleTable(9, true);
		t.appendRow();// 添加一行
		t.appendColumn("itemId").appendColumn("brand").appendColumn("style").appendColumn("color").appendColumn("size")
				.appendColumn("price").appendColumn("description").appendColumn("shoppingNum").appendColumn("sum");
		for(OrderItem item:o.getOrderItemList()) {
			t.appendRow();// 添加一行
		   t.appendColumn(item.getClothes().getBrand())
			.appendColumn(item.getClothes().getStyle())
			.appendColumn(item.getClothes().getColor())
			.appendColumn(item.getClothes().getSize())
			.appendColumn(item.getClothes().getPrice())
			.appendColumn(item.getClothes().getDescription())
			.appendColumn(item.getShoppingNum())
			.appendColumn(item.getSum());
		}
		println(toString().toString());
		}
	
	private void showProducts() {
		List<Clothes> list = clothesService.list();
		ConsoleTable t = new ConsoleTable(8, true);// 8列
		t.appendRow();// 添加一行
		t.appendColumn("id").appendColumn("brand").appendColumn("style").appendColumn("color").appendColumn("size")
				.appendColumn("num").appendColumn("price").appendColumn("description");
		for (Clothes c : list) {
			t.appendRow();// 添加一行
			t.appendColumn(c.getId()).appendColumn(c.getBrand()).appendColumn(c.getStyle()).appendColumn(c.getColor())
					.appendColumn(c.getSize()).appendColumn(c.getNum()).appendColumn(c.getPrice())
					.appendColumn(c.getDescription());
		}
		println(t.toString());
	}
}
