package com.lm.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.lm.bean.Order;

public class OrderFile {
  private static List<Order> orders=new ArrayList<>();
  private static final String ORDER_FILE="oeder.obj";
  public void add(Order order)throws WorkException{
	  orders.add(order);
  }
  public List<Order> list() throws WorkException{
	  return orders;
  }
  
  public Order findByOrderId(int orderId)throws WorkException{
	  Order order=null;
	  int oid;
	  for(Order o:orders) {
		 oid=o.getOrderId();
		 if(oid==orderId) {
			 order=o;
			 break;
		 }
	  }
	  return order;
  }
  
  public boolean  writeOrders() {
	  try {
		 ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(ORDER_FILE));
		 out.writeObject(orders);
		 out.close();
		 return true;
	  }catch (IOException e) {
	   e.printStackTrace();
	  }
	  return false;
  }
  
  public  boolean readOrders() {
	  try {
		  ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(ORDER_FILE));
		 orders=(List<Order>)inputStream.readObject();//需要强制转换为LIST
		 inputStream.close();
		 return true;
	  }catch(IOException e) {
		  e.printStackTrace();
	  } catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	  return false;
  }
  }

