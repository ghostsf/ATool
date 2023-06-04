package com.ghostsf.atool.convert.impl;

import com.ghostsf.atool.convert.AbstractConverter;
import com.ghostsf.atool.util.ClassUtil;

/**
 * 类转换器<br>
 * 将类名转换为类
 * @author ghostsf
 *
 */
public class ClassConverter extends AbstractConverter<Class<?>>{
	
	@Override
	protected Class<?> convertInternal(Object value) {
		String valueStr = convertToStr(value);
		try {
			return ClassUtil.getClassLoader().loadClass(valueStr);
		} catch (Exception e) {
			// Ignore Exception
		}
		return null;
	}

}
