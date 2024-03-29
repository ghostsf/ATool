package com.ghostsf.atool.convert;

import com.ghostsf.atool.util.ArrayUtil;
import com.ghostsf.atool.util.ClassUtil;
import com.ghostsf.atool.util.StrUtil;

/**
 * 抽象转换器，提供通用的转换逻辑，同时通过convertInternal实现对应类型的专属逻辑<br>
 * 转换器不会抛出转换异常，转换失败时会返回{@code null}
 * 
 * @author ghostsf
 *
 */
public abstract class AbstractConverter<T> implements Converter<T> {

	@Override
	@SuppressWarnings("unchecked")
	public T convert(Object value, T defaultValue) {
		Class<T> targetType = getTargetType();
		if (null == targetType && null == defaultValue) {
			throw new NullPointerException(StrUtil.format("[type] and [defaultValue] are both null for Converter [{}], we can not know what type to convert !", this.getClass().getName()));
		}
		if (null == targetType) {
			targetType = (Class<T>) defaultValue.getClass();
		}
		if (null == value) {
			return defaultValue;
		}

		if (null == defaultValue || targetType.isInstance(defaultValue)) {
			if (targetType.isInstance(value)) {
				// 已经是目标类型，不需要转换
				return (T) targetType.cast(value);
			}
			T result = null;
			try {
				result = convertInternal(value);
			} catch (RuntimeException e) {
				return defaultValue;
			}
			return ((null == result) ? defaultValue : result);
		} else {
			throw new IllegalArgumentException(StrUtil.format("Default value [{}] is not the instance of [{}]", defaultValue, targetType));
		}
	}

	/**
	 * 内部转换器，被 {@link AbstractConverter#convert(Object, Object)} 调用，实现基本转换逻辑<br>
	 * 内部转换器转换后如果转换失败可以做如下操作，处理结果都为返回默认值：
	 * 
	 * <pre>
	 * 1、返回{@code null} 
	 * 2、抛出一个{@link RuntimeException}异常
	 * </pre>
	 * 
	 * @param value 值
	 * @return 转换后的类型
	 */
	protected abstract T convertInternal(Object value);

	/**
	 * 值转为String<br>
	 * 转换规则为：
	 * 
	 * <pre>
	 * 1、字符串类型将被强转
	 * 2、数组将被转换为逗号分隔的字符串
	 * 3、其它类型将调用默认的toString()方法
	 * </pre>
	 * 
	 * @param value 值
	 * @return String
	 */
	protected String convertToStr(Object value) {
		if (null == value) {
			return null;
		}
		if (value instanceof String) {
			return (String) value;
		} else if (ArrayUtil.isArray(value)) {
			return ArrayUtil.toString(value);
		}
		return value.toString();
	}

	/**
	 * 获得此类实现类的泛型类型
	 * 
	 * @return 此类的泛型类型，可能为{@code null}
	 */
	@SuppressWarnings("unchecked")
	public Class<T> getTargetType() {
		return (Class<T>) ClassUtil.getTypeArgument(getClass());
	}
}
