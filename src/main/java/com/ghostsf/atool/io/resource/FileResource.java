package com.ghostsf.atool.io.resource;

import java.io.File;

import com.ghostsf.atool.util.URLUtil;
import com.ghostsf.atool.io.FileUtil;

/**
 * 文件资源访问对象
 * 
 * @author ghostsf
 *
 */
public class FileResource extends UrlResource{

	// ----------------------------------------------------------------------- Constructor start
	/**
	 * 构造
	 * 
	 * @param file 文件
	 */
	public FileResource(File file) {
		super(URLUtil.getURL(file));
	}
	
	/**
	 * 构造
	 * 
	 * @param path 文件绝对路径或相对ClassPath路径，但是这个路径不能指向一个jar包中的文件
	 */
	public FileResource(String path) {
		this(FileUtil.file(path));
	}
	// ----------------------------------------------------------------------- Constructor end

}
