import java.util.ArrayList;
import java.util.List;

public class LibraryUser implements User {
	// class fields
	private String name;
	private List<Borrowable> UserBorrowedItems = new ArrayList<>();

	// getters
	public LibraryUser(String name) {
		this.name = name;
	}// end constructor

	@Override
	public String getName() {
		return this.name;
	}// end method

	// other methods
	@Override
	public void BorrowItem(Borrowable item) {
		if (IsAlreadyBorrowed(item)) {
			System.out.println("This Item Is Already Borrowed");
			return;
		} // end if

		UserBorrowedItems.add(item);
		item.CheckOut(Main.getCurrentUser());
	}// end method

	@Override
	public void ReturnItem(Borrowable item) {
		item.ReturnItem();
		UserBorrowedItems.remove(UserBorrowedItems.size() - 1);
	}// end method

	public boolean IsAlreadyBorrowed(Borrowable item) {
		for (Borrowable libraryItem : UserBorrowedItems) {
			if (libraryItem == item) {
				return true;
			} // end if
		} // end for
		return false;
	}// end method

}// end class
