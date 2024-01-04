
public class DVD extends LibraryItem {
	// class fields
	private String director;
	private String genre;

	public DVD(String title, String director, String genre) {
		super(title);
		this.director = director;
		this.genre = genre;
	}// end constructor

	// getter
	public String getDirector() {
		return this.director;
	}// end method

	public String getGenre() {
		return this.genre;
	}// end method

	@Override
	public void getAdditionalInfo() {
		System.out.println("Director: " + getDirector());
		System.out.println("Genre: " + getGenre());
	}// end method

}// end class
