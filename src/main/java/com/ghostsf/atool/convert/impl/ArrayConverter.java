package com.ghostsf.atool.convert.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ghostsf.atool.convert.AbstractConverter;
import com.ghostsf.atool.convert.ConverterRegistry;
import com.ghostsf.atool.lang.Assert;
import com.ghostsf.atool.util.ArrayUtil;
import com.ghostsf.atool.util.StrUtil;

/**
 * 数组转换器，包括原始类型数组
 * 
 * @author ghostsf
 */
public class ArrayConverter extends AbstractConverter<Object> {

	private final Class<?> targetType;
	/** 目标元素类型 */
	private final Class<?> targetComponentType;

	/**
	 * 构造
	 * 
	 * @param targetType 目标数组类型
	 */
	public ArrayConverter(Class<?> targetType) {
		if(null == targetType) {
			//默认Object数组
			targetType = Object[].class;
		}else {
			Assert.isTrue(targetType.isArray(), "Target type must be a array!");
		}
		this.targetType = targetType;
		this.targetComponentType = targetType.getComponentType();
	}

	@Override
	protected Object convertInternal(Object value) {
		return value.getClass().isArray() ? convertArrayToArray(value) : convertObjectToArray(value);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getTargetType() {
		return this.targetType;
	}

	// -------------------------------------------------------------------------------------- Private method start
	/**
	 * 数组对数组转换
	 * 
	 * @param array 被转换的数组值
	 * @return 转换后的数组
	 */
	private Object convertArrayToArray(Object array) {
		final Class<?> valueComponentType =ArrayUtil.getComponentType(array);

		if (valueComponentType == targetComponentType) {
			return array;
		}

		final int len = ArrayUtil.length(array);
		final Object result = Array.newInstance(targetComponentType, len);

		final ConverterRegistry converter = ConverterRegistry.getInstance();
		for (int i = 0; i < len; i++) {
			Array.set(result, i, converter.convert(targetComponentType, Array.get(array, i)));
		}
		return result;
	}

	/**
	 * 非数组对数组转换
	 * 
	 * @param value 被转换值
	 * @return 转换后的数组
	 */
	private Object convertObjectToArray(Object value) {
		if (value instanceof CharSequence) {
			if(targetComponentType == char.class || targetComponentType == Character.class) {
				return convertArrayToArray(value.toString().toCharArray());
			}
			
			//单纯字符串情况下按照逗号分隔后劈开
			final String[] strings = StrUtil.split(value.toString(), StrUtil.COMMA);
			return convertArrayToArray(strings);
		}
		
		final ConverterRegistry converter = ConverterRegistry.getInstance();
		Object[] result = null;
		if (value instanceof List) {
			//List转数组
			final List<?> list = (List<?>) value;
			result = ArrayUtil.newArray(targetComponentType, list.size());
			for (int i = 0; i < list.size(); i++) {
				result[i] = converter.convert(targetComponentType, list.get(i));
			}
		} else if (value instanceof Collection) {
			//集合转数组
			final Collection<?> collection = (Collection<?>) value;
			result = ArrayUtil.newArray(targetComponentType, collection.size());

			int i = 0;
			for (Object element : collection) {
				result[i] = converter.convert(targetComponentType, element);
				i++;
			}
		} else if (value instanceof Iterable) {
			//可循环对象转数组，可循环对象无法获取长度，因此先转为List后转为数组
			final Iterable<?> iterable = (Iterable<?>) value;
			final List<Object> list = new ArrayList<>();
			for (Object element : iterable) {
				list.add(converter.convert(targetComponentType, element));
			}

			result = ArrayUtil.newArray(targetComponentType, list.size());
			result = list.toArray(result);
		}else {
			// everything else:
			result = convertToSingleElementArray(value);
		}

		return result;
	}

	/**
	 * 单元素数组
	 * 
	 * @param value 被转换的值
	 * @return 数组，只包含一个元素
	 */
	private Object[] convertToSingleElementArray(Object value) {
		final Object[] singleElementArray = ArrayUtil.newArray(targetComponentType, 1);
		singleElementArray[0] = ConverterRegistry.getInstance().convert(targetComponentType, value);
		return singleElementArray;
	}
	// -------------------------------------------------------------------------------------- Private method end
}
