package model.Bean;

import java.sql.Timestamp;

public class Comment {
	private int id;
	private String content;
	private String email;
	private String date_create;
	private int id_commentparent;
	private int news_id;
	private int lock;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate_create() {
		return date_create;
	}

	public void setDate_create(String date_create) {
		this.date_create = date_create;
	}

	public int getId_commentparent() {
		return id_commentparent;
	}

	public void setId_commentparent(int id_commentparent) {
		this.id_commentparent = id_commentparent;
	}

	public int getNews_id() {
		return news_id;
	}

	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}

	public int getLock() {
		return lock;
	}

	public void setLock(int lock) {
		this.lock = lock;
	}

	public Comment(int id, String content, String email, String date_create, int id_commentparent, int news_id,
			int lock) {
		super();
		this.id = id;
		this.content = content;
		this.email = email;
		this.date_create = date_create;
		this.id_commentparent = id_commentparent;
		this.news_id = news_id;
		this.lock = lock;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

}
