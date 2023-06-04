package com.ghostsf.atool.convert.impl;

import java.util.TimeZone;

import com.ghostsf.atool.convert.AbstractConverter;

/**
 * TimeZone转换器
 * @author ghostsf
 *
 */
public class TimeZoneConverter extends AbstractConverter<TimeZone>{

	@Override
	protected TimeZone convertInternal(Object value) {
		return TimeZone.getTimeZone(convertToStr(value));
	}

}
