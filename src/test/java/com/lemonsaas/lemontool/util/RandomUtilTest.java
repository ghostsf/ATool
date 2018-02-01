package com.lemonsaas.lemontool.util;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.lemonsaas.lemontool.collection.CollectionUtil;
import com.lemonsaas.lemontool.util.RandomUtil;

public class RandomUtilTest {
	@Test
	public void randomEleSetTest(){
		Set<Integer> set = RandomUtil.randomEleSet(CollectionUtil.newArrayList(1, 2, 3, 4, 5, 6), 2);
		Assert.assertEquals(set.size(), 2);
	}
}
