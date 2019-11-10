package com.lm.service.impl;



import java.util.List;

import com.lm.bean.Clothes;
import com.lm.service.ClothesService;
import com.lm.utils.ClothesFile;
import com.lm.utils.ProductsXmlUtils;
import com.lm.utils.WorkException;

public class ClothesServiseImpl implements ClothesService {
	private ClothesFile ClothesFile=new ClothesFile();
	@Override
	public List<Clothes> list() throws WorkException {
	
		return ClothesFile.list();
	}

	@Override
	public Clothes findById(String cid) throws WorkException {
		return ClothesFile.findById(cid);
	}
	public void update() throws WorkException{
		ClothesFile.update();
	}
}
