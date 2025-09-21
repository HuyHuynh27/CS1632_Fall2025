package edu.pitt.cs;

public class CatImpl implements Cat {
	private String name;
	private int id;
	private boolean rented;


	public CatImpl(int id, String name) {
		this.name = name;
		this.id = id;
	}

	public void rentCat() {
		rented = true;
	}

	public void returnCat() {
		rented = false;
	}

	public void renameCat(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public boolean getRented() {
		return rented;
	}

	public String toString() {
		return "ID " + id + ". " + name;
	}

}