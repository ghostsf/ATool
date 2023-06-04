package com.ghostsf.atool.exceptions;

import java.io.IOException;

import com.ghostsf.atool.io.IORuntimeException;
import org.junit.Assert;
import org.junit.Test;

/**
 * 异常工具单元测试
 * @author ghostsf
 *
 */
public class ExceptionUtilTest {
	
	@Test
	public void wrapTest() {
		IORuntimeException e = ExceptionUtil.wrap(new IOException(), IORuntimeException.class);
		Assert.assertNotNull(e);
	}
}
