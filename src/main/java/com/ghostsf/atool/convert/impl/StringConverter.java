package com.ghostsf.atool.convert.impl;

import com.ghostsf.atool.convert.AbstractConverter;

/**
 * 字符串转换器
 * @author ghostsf
 *
 */
public class StringConverter extends AbstractConverter<String>{

	@Override
	protected String convertInternal(Object value) {
		return convertToStr(value);
	}

}
