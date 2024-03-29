package com.ghostsf.atool.collection;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * {@link Iterator}对象转{@link Enumeration}
 * @author ghostsf
 *
 * @param <E> 元素类型
 * @since 3.0.8
 */
public class IteratorEnumeration<E> implements Enumeration<E>{
	
	private final Iterator<E> iterator;
	
	/**
	 * 构造
	 * @param iterator {@link Iterator}对象
	 */
	public IteratorEnumeration(Iterator<E> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasMoreElements() {
		return iterator.hasNext();
	}

	@Override
	public E nextElement() {
		return iterator.next();
	}

}
