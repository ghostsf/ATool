package com.ghostsf.atool.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 复制 {@link Iterator}<br>
 * 为了解决并发情况下{@link Iterator}遍历导致的问题（当Iterator被修改会抛出ConcurrentModificationException）
 * ，故使用复制原Iterator的方式解决此问题。
 * 
 * <p>
 * 解决方法为：在构造方法中遍历Iterator中的元素，装入新的List中然后遍历之。
 * 当然，修改这个复制后的Iterator是没有意义的，因此remove方法将会抛出异常。
 * 
 * <p>
 * 需要注意的是，在构造此对象时需要保证原子性（原对象不被修改），最好加锁构造此对象，构造完毕后解锁。
 * 
 *
 * @param <E> 元素类型
 * @author ghostsf
 * @since 3.0.7
 */
public class CopiedIterator<E> implements Iterator<E> {

	private List<E> eleList = new ArrayList<>();
	private Iterator<E> listIterator;
	
	public static <V> CopiedIterator<V> copyOf(Iterator<V> iterator){
		return new CopiedIterator<>(iterator);
	}

	/**
	 * 构造
	 * @param iterator 被复制的Iterator
	 */
	public CopiedIterator(Iterator<E> iterator) {
		while (iterator.hasNext()) {
			eleList.add(iterator.next());
		}
		this.listIterator = eleList.iterator();
	}

	@Override
	public boolean hasNext() {
		return this.listIterator.hasNext();
	}

	@Override
	public E next() {
		return this.listIterator.next();
	}

	/**
	 * 此对象不支持移除元素
	 * @throws UnsupportedOperationException 当调用此方法时始终抛出此异常
	 */
	@Override
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException("This is a read-only iterator.");
	}

}
