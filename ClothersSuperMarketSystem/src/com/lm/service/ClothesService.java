package com.lm.service;



import java.util.List;

import com.lm.bean.Clothes;
import com.lm.utils.WorkException;

public interface ClothesService {
	public List<Clothes> list() throws WorkException;
	public Clothes findById(String cid)throws WorkException;
	public void update() throws WorkException;
}
