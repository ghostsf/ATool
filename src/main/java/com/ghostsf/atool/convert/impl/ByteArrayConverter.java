package com.ghostsf.atool.convert.impl;

import com.ghostsf.atool.convert.AbstractConverter;
import com.ghostsf.atool.convert.ConverterRegistry;
import com.ghostsf.atool.util.ArrayUtil;

/**
 * byte 类型数组转换器
 * @author ghostsf
 *
 */
public class ByteArrayConverter extends AbstractConverter<byte[]>{
	
	@Override
	protected byte[] convertInternal(Object value) {
		final Byte[] result = ConverterRegistry.getInstance().convert(Byte[].class, value);
		return ArrayUtil.unWrap(result);
	}

}
