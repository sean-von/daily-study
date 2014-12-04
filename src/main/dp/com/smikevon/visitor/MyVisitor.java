package com.smikevon.visitor;

public class MyVisitor implements Visitor {

	public void visit(Subject subject) {
		System.out.println("visit the subject:"+subject.getSubject());
	}

}
