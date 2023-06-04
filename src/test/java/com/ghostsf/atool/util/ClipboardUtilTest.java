package com.ghostsf.atool.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * 剪贴板工具类单元测试
 * @author ghostsf
 *
 */
public class ClipboardUtilTest {
	
	@Test
	public void setAndGetStrTest() {
		ClipboardUtil.setStr("test");
		
		String test = ClipboardUtil.getStr();
		Assert.assertEquals("test", test);
	}
}
