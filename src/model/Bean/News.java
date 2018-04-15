package model.Bean;

public class News {
	private int id;
	private String name;
	private String preview;
	private String detail;
	private String date_create;
	private int create_by;
	private String picture;
	private int id_Cat;
	private int id_Slide;
	private int count_number;
	private User user;
	private Category category;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public News(int id, String name, String preview, String detail, String date_create, int create_by, String picture,
			int id_Cat, int id_Slide, int count_number, User user, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.detail = detail;
		this.date_create = date_create;
		this.create_by = create_by;
		this.picture = picture;
		this.id_Cat = id_Cat;
		this.id_Slide = id_Slide;
		this.count_number = count_number;
		this.user = user;
		this.category = category;
	}

	public News(int id, String name, String preview, String detail, String date_create, int create_by, String picture,
			int id_Cat, int id_Slide, int count_number, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.detail = detail;
		this.date_create = date_create;
		this.create_by = create_by;
		this.picture = picture;
		this.id_Cat = id_Cat;
		this.id_Slide = id_Slide;
		this.count_number = count_number;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDate_create() {
		return date_create;
	}

	public void setDate_create(String date_create) {
		this.date_create = date_create;
	}

	public int getCreate_by() {
		return create_by;
	}

	public void setCreate_by(int create_by) {
		this.create_by = create_by;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getId_Cat() {
		return id_Cat;
	}

	public void setId_Cat(int id_Cat) {
		this.id_Cat = id_Cat;
	}

	public int getId_Slide() {
		return id_Slide;
	}

	public void setId_Slide(int id_Slide) {
		this.id_Slide = id_Slide;
	}

	public int getCount_number() {
		return count_number;
	}

	public void setCount_number(int count_number) {
		this.count_number = count_number;
	}

	public News(int id, String name, String preview, String detail, String date_create, int create_by, String picture,
			int id_Cat, int id_Slide, int count_number) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.detail = detail;
		this.date_create = date_create;
		this.create_by = create_by;
		this.picture = picture;
		this.id_Cat = id_Cat;
		this.id_Slide = id_Slide;
		this.count_number = count_number;
	}

	public News() {
		super();
	}

}
