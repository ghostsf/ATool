package com.ghostsf.atool.util;

import java.net.InetAddress;

import com.ghostsf.atool.lang.PatternPool;
import org.junit.Assert;
import org.junit.Test;

/**
 * NetUtil单元测试
 * @author ghostsf
 *
 */
public class NetUtilTest {

	@Test
	public void getLocalhostTest(){
		InetAddress localhost = NetUtil.getLocalhost();
		Assert.assertNotNull(localhost);
	}
	
	@Test
	public void getLocalMacAddressTest(){
		String macAddress = NetUtil.getLocalMacAddress();
		Assert.assertNotNull(macAddress);
		
		//验证MAC地址正确
		boolean match = ReUtil.isMatch(PatternPool.MAC_ADDRESS, macAddress);
		Assert.assertTrue(match);
	}
	
	@Test
	public void longToIpTest() {
		String ipv4 = NetUtil.longToIpv4(2130706433L);
		Assert.assertEquals("127.0.0.1", ipv4);
	}
	
	@Test
	public void ipToLongTest() {
		long ipLong = NetUtil.ipv4ToLong("127.0.0.1");
		Assert.assertEquals(2130706433L, ipLong);
	}
}
