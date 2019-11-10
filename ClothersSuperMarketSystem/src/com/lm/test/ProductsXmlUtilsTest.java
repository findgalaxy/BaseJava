package com.lm.test;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.lm.bean.Clothes;
import com.lm.utils.ProductsXmlUtils;

public class ProductsXmlUtilsTest {
	@Test
	public void test() {
		List<Clothes> clothes = ProductsXmlUtils.parserProductForXml();
		System.out.println(Arrays.toString(clothes.toArray()));
	}

}
