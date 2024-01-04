
public abstract class LibraryItem implements Borrowable {
	// class fields
	private String title;
	private boolean checkedOutStatus;

	public abstract void getAdditionalInfo();

	public LibraryItem(String title) {
		this.title = title;
		this.checkedOutStatus = false;
	}// end constructor

	// getter
	public String getTitle() {
		return this.title;
	}// end method

	@Override
	public void CheckOut(User user) {
		if (checkedOutStatus) {
			System.out.println("This item has already been checked out.");
			return;
		} // end if

		checkedOutStatus = false;
		System.out.println("\n" + user.getName() + " checked out: " + getTitle());

	}// end method

	@Override
	public void ReturnItem() {
		System.out.println("Item returned: " + getTitle());
	}// end method
}// end class
