package demo.q3min.vo;

public class QuestionVo {
	private Long id;
	private String type;
	private String category;
	private String content;
	private String date;
	private Long userID;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserId(Long userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "QuestionVo [id=" + id + ", type=" + type + ", category=" + category + ", content=" + content + ", date="
				+ date + ", userID=" + userID + "]";
	}
	
}
