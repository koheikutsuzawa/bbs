package dto;


import java.sql.Timestamp;

public class BoardDto {

	private String name;
	private String comment;
	private int id;
	private Timestamp time;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
