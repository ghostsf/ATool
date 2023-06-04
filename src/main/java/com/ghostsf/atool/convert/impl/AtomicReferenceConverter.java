package com.ghostsf.atool.convert.impl;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

import com.ghostsf.atool.convert.AbstractConverter;
import com.ghostsf.atool.convert.ConverterRegistry;
import com.ghostsf.atool.util.TypeUtil;

/**
 * {@link AtomicReference}转换器
 * 
 * @author ghostsf
 * @since 3.0.8
 */
@SuppressWarnings("rawtypes")
public class AtomicReferenceConverter extends AbstractConverter<AtomicReference> {
	
	@Override
	protected AtomicReference<?> convertInternal(Object value) {
		
		//尝试将值转换为Reference泛型的类型
		Object targetValue = null;
		final Type paramType = TypeUtil.getTypeArgument(AtomicReference.class);
		if(null != paramType){
			targetValue = ConverterRegistry.getInstance().convert(paramType, value);
		}
		if(null == targetValue){
			targetValue = value;
		}
		
		return new AtomicReference<>(targetValue);
	}

}
