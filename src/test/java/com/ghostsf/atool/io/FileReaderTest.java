package com.ghostsf.atool.io;

import com.ghostsf.atool.io.file.FileReader;
import org.junit.Assert;
import org.junit.Test;

/**
 * 文件读取测试
 * @author ghostsf
 *
 */
public class FileReaderTest {
	
	@Test
	public void fileReaderTest(){
		FileReader fileReader = new FileReader("test.properties");
		String result = fileReader.readString();
		Assert.assertNotNull(result);
	}
}
