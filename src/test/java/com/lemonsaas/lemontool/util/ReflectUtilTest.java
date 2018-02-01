package com.lemonsaas.lemontool.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.lemonsaas.lemontool.util.ArrayUtil;
import com.lemonsaas.lemontool.util.ReflectUtil;
import org.junit.Assert;
import org.junit.Test;

import com.lemonsaas.lemontool.lang.test.bean.ExamInfoDict;
import com.lemonsaas.lemontool.util.ClassUtilTest.TestSubClass;

/**
 * 反射工具类单元测试
 * 
 * @author Looly
 *
 */
public class ReflectUtilTest {

	@Test
	public void getMethodsTest() {
		Method[] methods = ReflectUtil.getMethods(ExamInfoDict.class);
		Assert.assertTrue(ArrayUtil.isNotEmpty(methods));
	}

	@Test
	public void getMethodTest() {
		Method method = ReflectUtil.getMethod(ExamInfoDict.class, "getId");
		Assert.assertEquals("getId", method.getName());
	}

	@Test
	public void getFieldTest() {
		// 能够获取到父类字段
		Field privateField = ReflectUtil.getField(TestSubClass.class, "privateField");
		Assert.assertNotNull(privateField);
	}

	@Test
	public void invokeTest() {
		TestClass testClass = new TestClass();
		ReflectUtil.invoke(testClass, "setA", 10);
		Assert.assertEquals(10, testClass.getA());
	}

	static class TestClass {
		private int a;

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}
	}
}
