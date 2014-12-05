package com.smikevon.iterator;

public class TestIterator {

	public static void main(String[] args) {
		Collection<String> collection = new MyCollection<String>();
		collection.add("abc");
		collection.add("12");
		collection.add("我");

		Iterator<String> iterator = collection.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

}
