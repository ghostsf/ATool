package com.ghostsf.atool.lang.copier;

/**
 * 拷贝接口
 * @author ghostsf
 *
 * @param <T> 拷贝目标类型
 */
public interface Copier<T> {
	/**
	 * 执行拷贝
	 * @return 拷贝的目标
	 */
	T copy();
}
