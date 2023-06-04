package com.ghostsf.atool.clone;

/**
 * 克隆支持接口
 * @author ghostsf
 *
 * @param <T> 实现克隆接口的类型
 */
public interface Cloneable<T> extends java.lang.Cloneable{
	
	/**
	 * 克隆当前对象，浅复制
	 * @return 克隆后的对象
	 */
	T clone();
}
