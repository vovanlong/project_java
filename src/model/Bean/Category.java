package model.Bean;

import java.util.ArrayList;

public class Category {
	private int id;
	private String name;
	private int id_Parent;
	private News mainNew;
	private ArrayList<Category> subCategories;
	private ArrayList<News> subNews;

	public Category(int id, String name, int id_Parent, News mainNew, ArrayList<News> subNews) {
		super();
		this.id = id;
		this.name = name;
		this.id_Parent = id_Parent;
		this.mainNew = mainNew;
		this.subNews = subNews;
	}

	public News getMainNew() {
		return mainNew;
	}

	public void setMainNew(News mainNew) {
		this.mainNew = mainNew;
	}

	public Category(int id, String name, int id_Parent, ArrayList<Category> subCategories, ArrayList<News> subNews) {
		super();
		this.id = id;
		this.name = name;
		this.id_Parent = id_Parent;
		this.subCategories = subCategories;
		this.subNews = subNews;
	}

	public ArrayList<News> getSubNews() {
		return subNews;
	}

	public void setSubNews(ArrayList<News> subNews) {
		this.subNews = subNews;
	}

	public Category(int id, String name, int id_Parent, ArrayList<Category> subCategories) {
		super();
		this.id = id;
		this.name = name;
		this.id_Parent = id_Parent;
		this.subCategories = subCategories;
	}

	public ArrayList<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(ArrayList<Category> subCategories) {
		this.subCategories = subCategories;
	}

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

	public int getId_Parent() {
		return id_Parent;
	}

	public void setId_Parent(int id_Parent) {
		this.id_Parent = id_Parent;
	}

	public Category(int id, String name, int id_Parent) {
		super();
		this.id = id;
		this.name = name;
		this.id_Parent = id_Parent;
	}

	public Category() {
		super();
	}

}
