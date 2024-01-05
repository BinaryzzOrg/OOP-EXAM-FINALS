import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	// user
	private static LibraryUser user = new LibraryUser("steve");

	// library items list
	private static List<LibraryItem> bookShelf = new ArrayList<>();
	private static List<LibraryItem> dvdShelf = new ArrayList<>();

	private static int bookShelfSize;
	private static int dvdShelfSize;

	public static void main(String[] args) {

		// @formatter:off
		// items
		LibraryItem book1 = new Book("Dune", "Frank Herbert",
				"A mythic and emotionally charged hero's journey, \"Dune\" tells " +
				"the story of Paul Atreides, a brilliant and gifted young man born into a great " +
				"destiny beyond his understanding, who must travel to the most dangerous planet " +
				"in the universe to ensure the future of his family and his people.");
		
		LibraryItem book2 = new Book("House of Leaves", "Mark Z. Danielewsk",
				"A story about a young man who finds a manuscript about a family's documentary," +
				" The Navidson Record, which details their experiences with a strange house. " +
				"The young man becomes all encompassed with the text and story, which alters " +
				"the course of his own life.");

		
		LibraryItem dvd1 = new DVD("Parasite", "Bong Joon Ho","Horror, Drama, Suspense...");
		
		LibraryItem dvd2 = new DVD("Ex Machina","Alex Garland","Science fiction, Romance, Fantasy...");
		// @formatter:on

		bookShelf.add(book1);
		bookShelf.add(book2);

		dvdShelf.add(dvd1);
		dvdShelf.add(dvd2);

		bookShelfSize = bookShelf.size() - 1;
		dvdShelfSize = dvdShelf.size() - 1;

		// print Library System Menu
		Menu();
	}// end main

	public static String PrintMenuChoices() {
		String MenuChoicesAsString =
		//@formatter:off
								"\n" + 
								"     {Library System Menu}\n"+ 
								"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"+ 
								"┃ 【 1 】 Display Available Items \n" +
								"┃ 【 2 】 Borrow An Item \n" + 
								"┃ 【 3 】 Return An Item \n" + 
								"┃ 【 4 】 Quit \n" + 
								"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" + 
								"》 ";
				//@formatter:on
		return MenuChoicesAsString;
	}// end method

	public static void Menu() {
		System.out.print(PrintMenuChoices());

		switch (CheckUserInput(PrintMenuChoices())) {
		case 1: {// Display available items
		//@formatter:off
			System.out.println("\n" + 
							"   {Library Available Items}\n"+ 
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" + "Book: \n");
		//@formatter:on

			for (int index = 0; index < bookShelfSize + 1; index++) {
				System.out.println("Books Title: " + bookShelf.get(index).getTitle());
			} // end for

			System.out.println("⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" + "DVD: \n");

			for (int index = 0; index < dvdShelfSize + 1; index++) {
				System.out.println("DVD Title: " + dvdShelf.get(index).getTitle());
			} // end for

			System.out.print("⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
			break;
		}

		case 2: {// Borrow an item
			if (bookShelfSize <= -1) {
				System.out.println("BookShelf Is Currently Empty");
				break;
			} // end if

			System.out.print("\nEnter the item number to borrow (1 for Book, 2 for DVD) \n》");
			int userinput = CheckUserInput(PrintMenuChoices());

			if (userinput == 1) {
				user.BorrowItem(bookShelf.get(bookShelfSize));
				bookShelfSize--;
			} else if (userinput == 2) {
				user.BorrowItem(dvdShelf.get(dvdShelfSize));
				dvdShelfSize--;
			} // end if else
			break;
		}

		case 3: {// Return an item
			if (bookShelfSize + 1 >= bookShelf.size()) {
				System.out.println("All items are already returned");
				break;
			} // end if

			System.out.print("\nEnter the item number to return (1 for Book, 2 for DVD) \n》");
			int userinput = CheckUserInput(PrintMenuChoices());

			if (userinput == 1) {
				bookShelfSize++;
				user.ReturnItem(bookShelf.get(bookShelfSize));
			} else if (userinput == 2) {
				dvdShelfSize++;
				user.ReturnItem(dvdShelf.get(dvdShelfSize));
			} // end if else
			break;
		}

		case 4: {// Exit
			System.out.println("「Program Terminated...」");
			System.exit(0);
			break;
		}

		default:
			// @formatter:off
			System.out.println("\n" +
					"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
					"┇ Error: \n" +
					"┇ Input is not a valid Menu choice. \n" +
					"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
					"┇ Msg: \n" +
					"┇ \033[3mPlease enter only 1 to 4 as input\033[0m \n" +
					"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃");
			// @formatter:on
			break;
		}// end method

		Menu();
	}// end method

	public static int CheckUserInput(String prompt) {
		Scanner sc = new Scanner(System.in);

		if (sc.hasNextInt()) {
			int key = sc.nextInt();
			return key;
		} // end if

		// @formatter:off
			System.out.println("\n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
						"┇ Error: \n" +
						"┇ Input is not an integer value. \n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
						"┇ Msg: \n" +
						"┇ \033[3mPlease enter INTEGER input only\033[0m \n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
		// @formatter:on
		System.out.print(prompt);
		return CheckUserInput(prompt);
	}// end if
}// end method
