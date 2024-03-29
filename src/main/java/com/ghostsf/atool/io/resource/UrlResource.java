package com.ghostsf.atool.io.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

import com.ghostsf.atool.util.CharsetUtil;
import com.ghostsf.atool.util.URLUtil;
import com.ghostsf.atool.io.FileUtil;
import com.ghostsf.atool.io.IORuntimeException;
import com.ghostsf.atool.io.IoUtil;

/**
 * URL资源访问类
 * @author ghostsf
 *
 */
public class UrlResource implements Resource{
	protected URL url;
	
	//-------------------------------------------------------------------------------------- Constructor start
	/**
	 * 构造
	 * @param url URL
	 */
	public UrlResource(URL url) {
		this.url = url;
	}
	
	/**
	 * 构造
	 * @param file 文件路径
	 * @deprecated Please use {@link FileResource}
	 */
	@Deprecated
	public UrlResource(File file) {
		this.url = URLUtil.getURL(file);
	}
	//-------------------------------------------------------------------------------------- Constructor end
	
	@Override
	public URL getUrl(){
		return this.url;
	}
	
	@Override
	public InputStream getStream(){
		if(null == this.url){
			throw new IORuntimeException("Resource [{}] not exist!", this.url);
		}
		return URLUtil.getStream(url);
	}
	
	/**
	 * 获得Reader
	 * @param charset 编码
	 * @return {@link BufferedReader}
	 * @since 3.0.1
	 */
	public BufferedReader getReader(Charset charset){
		return URLUtil.getReader(this.url, charset);
	}
	
	//------------------------------------------------------------------------------- read
	@Override
	public String readStr(Charset charset) throws IORuntimeException{
		BufferedReader reader = null;
		try {
			reader = getReader(charset);
			return IoUtil.read(reader);
		} finally {
			IoUtil.close(reader);
		}
	}
	
	@Override
	public String readUtf8Str() throws IORuntimeException{
		return readStr(CharsetUtil.CHARSET_UTF_8);
	}
	
	@Override
	public byte[] readBytes() throws IORuntimeException{
		InputStream in = null;
		try {
			in = getStream();
			return IoUtil.readBytes(in);
		} finally {
			IoUtil.close(in);
		}
	}
	
	/**
	 * 获得File
	 * @return {@link File}
	 */
	public File getFile(){
		return FileUtil.file(this.url);
	}
	
	/**
	 * 返回路径
	 * @return 返回URL路径
	 */
	@Override
	public String toString() {
		return (null == this.url) ? "null" : this.url.toString();
	}
}
