package modelVO;

public class UserVO {
	private String id;
	private int grade;
	private MovieVO movie;
	
	public UserVO() {	}

	public UserVO(String id, int grade) {
		super();
		this.id = id;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}	

	public MovieVO getMovie() {
		return movie;
	}

	public void setMovie(MovieVO movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserVO [id=").append(id).append(", grade=").append(grade).append("]");
		return builder.toString();
	}	
	
	
	
}
