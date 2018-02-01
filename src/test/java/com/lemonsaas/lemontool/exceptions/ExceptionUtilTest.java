package com.lemonsaas.lemontool.exceptions;

import java.io.IOException;

import com.lemonsaas.lemontool.exceptions.ExceptionUtil;
import org.junit.Assert;
import org.junit.Test;

import com.lemonsaas.lemontool.io.IORuntimeException;

/**
 * 异常工具单元测试
 * @author looly
 *
 */
public class ExceptionUtilTest {
	
	@Test
	public void wrapTest() {
		IORuntimeException e = ExceptionUtil.wrap(new IOException(), IORuntimeException.class);
		Assert.assertNotNull(e);
	}
}
