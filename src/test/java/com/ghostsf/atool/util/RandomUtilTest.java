package com.ghostsf.atool.util;

import java.util.Set;

import com.ghostsf.atool.collection.CollectionUtil;
import org.junit.Assert;
import org.junit.Test;

public class RandomUtilTest {
	@Test
	public void randomEleSetTest(){
		Set<Integer> set = RandomUtil.randomEleSet(CollectionUtil.newArrayList(1, 2, 3, 4, 5, 6), 2);
		Assert.assertEquals(set.size(), 2);
	}
}
