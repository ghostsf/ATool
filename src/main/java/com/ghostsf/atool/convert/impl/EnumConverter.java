package com.ghostsf.atool.convert.impl;

import com.ghostsf.atool.convert.AbstractConverter;

/**
 * 枚举转换器
 * 
 * @param <E> 枚举类类型
 * @author ghostsf
 * @since 3.2.0
 */
public class EnumConverter<E extends Enum<E>> extends AbstractConverter<E> {

	private Class<E> enumClass;
	
	/**
	 * 构造
	 * 
	 * @param enumClass 转换成的目标Enum类
	 */
	public EnumConverter(Class<E> enumClass) {
		this.enumClass = enumClass;
	}

	@Override
	protected E convertInternal(Object value) {
		return Enum.valueOf(enumClass, convertToStr(value));
	}

}
