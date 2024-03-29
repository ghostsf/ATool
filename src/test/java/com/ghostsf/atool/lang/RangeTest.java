package com.ghostsf.atool.lang;


import com.ghostsf.atool.date.DateField;
import com.ghostsf.atool.date.DateTime;
import com.ghostsf.atool.date.DateUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * {@link Range} 单元测试
 * @author ghostsf
 *
 */
public class RangeTest {
	
	@Test
	public void dateRangeTest() {
		DateTime start = DateUtil.parse("2017-01-01");
		DateTime end = DateUtil.parse("2017-01-31");
		
		final Range<DateTime> range = new Range<DateTime>(start, end, new Range.Steper<DateTime>(){

			@Override
			public DateTime step(DateTime current, DateTime end, int index) {
				if(current.isAfterOrEquals(end)) {
					return null;
				}
				return current.offsetNew(DateField.DAY_OF_YEAR, 1);
			}
			
		});
		
		Assert.assertEquals(range.next(), DateUtil.parse("2017-01-01"));
		Assert.assertEquals(range.next(), DateUtil.parse("2017-01-02"));
	}
}
