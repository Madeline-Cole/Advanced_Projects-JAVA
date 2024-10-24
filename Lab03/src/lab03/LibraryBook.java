package lab03;
import java.util.GregorianCalendar;
// Lab Part 2.2 What imports do you need to include? Put them here.

/**
 * A LibraryBook is a subclass of Book that contains a holder (a String) and a due date
 * represented by a GregorianCalendar.
 */
public class LibraryBook extends Book{ // Lab Part 2.1

	private String holder;
    private GregorianCalendar dueDate;
    
    /**
     * Constructs a LibraryBook with the specified ISBN, author, and title.
     *
     * @param isbn   The ISBN number of the book.
     * @param author The author of the book.
     * @param title  The title of the book.
     */
    public LibraryBook(long isbn, String author, String title) {
    	super(isbn, author, title); // Call the constructor of the superclass (Book)
        this.holder = null;
        this.dueDate = null;
    }

    /**
     * Returns the holder of the library book.
     *
     * @return A String representing the holder of the book, or null if the book is not checked out.
     */
    public String getHolder() {
        //Lab Part 2.3.2
        return holder;
    }
    
    /**
     * Returns the due date of the library book.
     *
     * @return A GregorianCalendar object representing the due date of the book, or null if the book is not checked out.
     */
    public GregorianCalendar getDueDate() {
        //Lab Part 2.3.3
        return dueDate;
    }
    
    /**
     * Checks in the library book by setting the holder and due date to null.
     */
    public void checkin() {
        //Lab Part 2.3.4
    	holder = null;
        dueDate = null;
    }
    
    /**
     * Checks out the library book by setting the holder and due date to the specified values.
     *
     * @param holder   The name of the person who is checking out the book.
     * @param dueDate  The due date for the book's return.
     */
    public void checkout(String holder, GregorianCalendar dueDate){
        //Lab Part 2.3.5
    	this.holder = holder;
        this.dueDate = dueDate;
    }	

    // Do not override the equals method in Book

}