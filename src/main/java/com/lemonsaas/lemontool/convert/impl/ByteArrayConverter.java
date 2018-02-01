package com.lemonsaas.lemontool.convert.impl;

import com.lemonsaas.lemontool.convert.AbstractConverter;
import com.lemonsaas.lemontool.convert.ConverterRegistry;
import com.lemonsaas.lemontool.util.ArrayUtil;

/**
 * byte 类型数组转换器
 * @author Looly
 *
 */
public class ByteArrayConverter extends AbstractConverter<byte[]>{
	
	@Override
	protected byte[] convertInternal(Object value) {
		final Byte[] result = ConverterRegistry.getInstance().convert(Byte[].class, value);
		return ArrayUtil.unWrap(result);
	}

}
