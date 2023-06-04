package com.ghostsf.atool.io;

import com.ghostsf.atool.io.file.FileCopier;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 文件拷贝单元测试
 * @author ghostsf
 *
 */
public class FileCopierTest {
	
	@Test
	@Ignore
	public void dirCopyTest() {
		FileCopier copier = FileCopier.create("D:\\Java", "e:/eclipse/eclipse2.zip");
		copier.copy();
	}
	
	@Test
	@Ignore
	public void copyFileToDirTest() {
		FileCopier copier = FileCopier.create("d:/GReen_Soft/XshellXftpPortable.zip", "c:/hp/");
		copier.copy();
	}
}
