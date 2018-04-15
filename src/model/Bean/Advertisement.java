package model.Bean;

public class Advertisement {
	private int id;
	private String name;
	private String picture;
	private int active;
	private String link;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Advertisement(int id, String name, String picture, int active, String link) {
		super();
		this.id = id;
		this.name = name;
		this.picture = picture;
		this.active = active;
		this.link = link;
	}

	public Advertisement() {
		super();
	}

}
