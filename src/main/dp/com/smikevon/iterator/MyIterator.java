package com.smikevon.iterator;

/**
 * @description: 迭代器模式就是顺序访问聚集中的对象，一般来说，集合中非常常见，如果对集合类比较熟悉的话，理解本模式会十分轻松。
 * 				 这句话包含两层意思：一是需要遍历的对象，即聚集对象，二是迭代器对象，用于对聚集对象进行遍历访问。
 * @author     : fengxiao
 * @date       : 2014年10月28日 下午5:33:05
 */
public class MyIterator<T> implements Iterator<T> {

	private Collection<T> collection;
	private int pos = -1;



	public MyIterator(Collection<T> collection) {
		super();
		this.collection = collection;
	}

	public T previous() {
		if(pos>0){
			pos--;
		}
		return collection.get(pos);
	}

	public T next() {
		if(pos<(collection.size()-1)){
			pos++;
		}
		return collection.get(pos);
	}

	public boolean hasNext() {
		if(pos<(collection.size()-1)){
			return true;
		}
		return false;
	}

	public T first() {
		if(pos>-1){
			return collection.get(0);
		}
		return null;
	}

}
