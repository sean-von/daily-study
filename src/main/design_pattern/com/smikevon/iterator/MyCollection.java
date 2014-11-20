package com.smikevon.iterator;

public class MyCollection<T> implements Collection<T>{

	public Object[] strs = new Object[10];
	public int pos = -1;

	public Iterator<T> iterator() {
		return new MyIterator<T>(this);
	}

	@SuppressWarnings("unchecked")
	public T get(int i) {
		return (T)strs[i];
	}

	public int size() {
		return strs.length;
	}

	public  void add(T obj) {
		if(pos<(strs.length-1)){
			strs[pos+1] = obj;
			pos++;
		}
	}

}
