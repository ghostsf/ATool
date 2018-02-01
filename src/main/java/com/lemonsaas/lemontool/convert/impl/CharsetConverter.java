package com.lemonsaas.lemontool.convert.impl;

import java.nio.charset.Charset;

import com.lemonsaas.lemontool.convert.AbstractConverter;
import com.lemonsaas.lemontool.util.CharsetUtil;

/**
 * 编码对象转换器
 * @author Looly
 *
 */
public class CharsetConverter extends AbstractConverter<Charset>{

	@Override
	protected Charset convertInternal(Object value) {
		return CharsetUtil.charset(convertToStr(value));
	}

}
