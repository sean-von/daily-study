package com.smikevon.memento;

public class Original {

	private String value;

	Original(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Memento createMemento(){
		return new Memento(value);

	}

	public void reloadMemento(Memento memento){
		setValue(memento.getValue());
	}

}
