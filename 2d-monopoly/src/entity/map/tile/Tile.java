package entity.map.tile;

import java.io.Serializable;

public abstract class Tile implements Serializable {
	// properties
	private String name;
	private int id;

	public Tile(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() { return name; }
	public void setName(String name) {  this.name = name; }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() { return name + " " + id + "\n"; }
}