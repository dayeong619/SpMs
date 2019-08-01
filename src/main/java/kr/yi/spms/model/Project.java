package kr.yi.spms.model;

public class Project {
	private int no;
	private String name;
	private String content;
	private String sday;
	private String eday;
	private String progress;

	public Project() {
		super();
		
	}
	
	
	public Project(int no, String name, String content, String sday, String eday, String progress) {
		super();
		this.no = no;
		this.name = name;
		this.content = content;
		this.sday = sday;
		this.eday = eday;
		this.progress = progress;
	}



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSday() {
		return sday;
	}

	public void setSday(String sday) {
		this.sday = sday;
	}

	public String getEday() {
		return eday;
	}

	public void setEday(String eday) {
		this.eday = eday;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		return "Project [no=" + no + ", name=" + name + ", content=" + content + ", sday=" + sday + ", eday=" + eday
				+ ", progress=" + progress + "]";
	}

}
