package com.lm.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.lm.bean.Clothes;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

//读
public class ProductsXmlUtils {
	public static List<Clothes> parserProductForXml() {
		List<Clothes> products = new ArrayList<>();
		XStream xStream = new XStream(new Xpp3Driver());
		xStream.alias("list", products.getClass());
		xStream.alias("clothes", Clothes.class);
		xStream.useAttributeFor(Clothes.class, "id");
		try {
			BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("products.xml"));
			products = (List<Clothes>) xStream.fromXML(inputStream);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return products;
	}

//写
	public static void writeProductToXml(List<Clothes> products) {
		XStream xStream = new XStream(new Xpp3Driver());
		xStream.alias("list", products.getClass());
		xStream.alias("clothes", Clothes.class);
		xStream.useAttributeFor(Clothes.class, "id");
		try {
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("products.xml"));
			outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes());// 加上第一行
			xStream.toXML(products, outputStream);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
