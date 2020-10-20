package com.ghostsf.atool.convert.impl;

import java.nio.charset.Charset;

import com.ghostsf.atool.convert.AbstractConverter;
import com.ghostsf.atool.util.CharsetUtil;

/**
 * 编码对象转换器
 * @author Looly
 *
 */
public class CharsetConverter extends AbstractConverter<Charset> {

	@Override
	protected Charset convertInternal(Object value) {
		return CharsetUtil.charset(convertToStr(value));
	}

}
