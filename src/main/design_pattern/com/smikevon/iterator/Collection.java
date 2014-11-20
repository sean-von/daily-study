package com.smikevon.iterator;

public interface Collection<T> {

	public Iterator<T> iterator();

	public T get(int i);

	public void add(T obj);

	public int size();
}
