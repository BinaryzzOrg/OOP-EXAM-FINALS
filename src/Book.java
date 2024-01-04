
public class Book extends LibraryItem {
	// class fields
	private String author;
	private String about;

	public Book(String title, String author, String about) {
		super(title);
		this.author = author;
		this.about = about;
	}// end constructor

	// getter
	public String getAuthor() {
		return this.author;
	}// end method

	public String getAbout() {
		return this.about;
	}// end method

	@Override
	public void getAdditionalInfo() {
		System.out.println("Author: " + getAuthor());
		System.out.println("About: " + getAbout());
	}// end method

}// end class
