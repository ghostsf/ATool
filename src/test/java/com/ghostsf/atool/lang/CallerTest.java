package com.ghostsf.atool.lang;

import org.junit.Assert;
import org.junit.Test;

/**
 * {@link Caller} 单元测试
 * @author ghostsf
 *
 */
public class CallerTest {
	
	@Test
	public void getCallerTest() {
		Class<?> caller = Caller.getCaller();
		Assert.assertEquals(this.getClass(), caller);
		
		Class<?> caller0 = Caller.getCaller(0);
		Assert.assertEquals(Caller.class, caller0);
		
		Class<?> caller1 = Caller.getCaller(1);
		Assert.assertEquals(this.getClass(), caller1);
		
		Class<?> callerCaller = CallerTestClass.getCaller();
		Assert.assertEquals(this.getClass(), callerCaller);
	}
	
	private static class CallerTestClass{
		public static Class<?> getCaller(){
			return Caller.getCallerCaller();
		}
	}
}
