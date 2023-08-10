package demo.q3min.vo;

public class AnswerVo {
	private Long id;
	private String content;
	private String date;
	private Long questionID;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}
	
	@Override
	public String toString() {
		return "AnswerVo [id=" + id + ", content=" + content + ", date=" + date + ", questionID=" + questionID + "]";
	}
}
