package com.lm.utils;

import java.util.ArrayList;
import java.util.List;

import com.lm.bean.Clothes;

public class ClothesFile {
	private static List<Clothes> list=new ArrayList<>();
	
	public Clothes findById(String  cid)throws WorkException{
		for(Clothes c:list) {
			if(c.getId().equals(cid)) {
				return c;
			}
		}
		return null;
	}
	
	public List<Clothes> list() throws WorkException{
		if(list.size()==0) {
			list=ProductsXmlUtils.parserProductForXml();
		}
		return list;
	}
	//刷新xml文档
	public void update() throws WorkException{
		ProductsXmlUtils.writeProductToXml(list);
	}
}
