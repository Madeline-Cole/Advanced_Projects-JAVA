/*
package lab03;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Testing class for Library.
 * 
 * You will need to write more tests than the ones we provided
 */
/*
public class LibraryTest {

  public static void main(String[] args) {
	  
	    // test an empty library
	    Library lib = new Library();

	    if (lib.lookup(978037429279L) != null)
	      System.err.println("TEST FAILED -- empty library: lookup(isbn)");
	    
	    ArrayList<LibraryBook> booksCheckedOut = lib.lookup("Jane Doe");
	    
	    if (booksCheckedOut == null || booksCheckedOut.size() != 0)
	      System.err.println("TEST FAILED -- empty library: lookup(holder)");
	    
	    if (lib.checkout(978037429279L, "Jane Doe", 1, 1, 2008))
	      System.err.println("TEST FAILED -- empty library: checkout");
	    
	    if (lib.checkin(978037429279L))
	      System.err.println("TEST FAILED -- empty library: checkin(isbn)");
	    
	    if (lib.checkin("Jane Doe"))
	      System.err.println("TEST FAILED -- empty library: checkin(holder)");

	    // test a small library
	    lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
	    lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
	    lib.add(9780446580342L, "David Baldacci", "Simple Genius");
	    

	    if (lib.lookup(9780330351690L) != null)
	      System.err.println("TEST FAILED -- small library: lookup(isbn)");    
	    
	    if (!lib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008))
	      System.err.println("TEST FAILED -- small library: checkout");
	    
	    booksCheckedOut = lib.lookup("Jane Doe");
	        
	    if (booksCheckedOut == null
	        || booksCheckedOut.size() != 1
	        || !booksCheckedOut.get(0).equals(
	            new Book(9780330351690L, "Jon Krakauer", "Into the Wild"))
	        || !booksCheckedOut.get(0).getHolder().equals("Jane Doe")
	        || !booksCheckedOut.get(0).getDueDate().equals(
	            new GregorianCalendar(2008, 1, 1))){
	      System.err.println("TEST FAILED -- small library: lookup(holder)");
	    }
	    if (!lib.checkin(9780330351690L))
	      System.err.println("TEST FAILED -- small library: checkin(isbn)");
	    if (lib.checkin("Jane Doe"))
	      System.err.println("TEST FAILED -- small library: checkin(holder)");

		// ** Write your tests here **


	    System.out.println("Testing done.");
  }

}
*/
package lab03;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Testing class for Library.
 * 
 * 
 */
public class LibraryTest {

  public static void main(String[] args) {
	  
    // lab03 - part 2 samples
    // book1
    // isbn:  9780374292799L
    // author:  Thomas L. Friedman
    // title: The World is Flat
    
    // book2
    // isbn:  9780330351690L
    // author:  Jon Krakauer
    // title: Into the Wild	 

    // You wrote 5 Methods and 1 Constuctor
    // I suggest testing that all of these work before moving to part 3

    // **WRITE YOUR TESTS HERE**
	 
	// lab03 - part 3 tests
	
	Library lib = new Library();
	
    if (lib.lookup(978037429279L) != null)
        System.err.println("TEST FAILED -- empty library: lookup(isbn)");	
	
    // test a small library - with four books in it
    lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib.add(9780446580342L, "David Baldacci", "Simple Genius");	
	
    if (lib.lookup(9780330351690L) != null)
        System.err.println("TEST FAILED -- small library: lookup(isbn)");   
    
    lib.checkout(978037429279L, "Jane Doe", 1, 1, 2008);
    
    if (lib.lookup(9780330351690L) != null)
        System.err.println("TEST FAILED -- small library: lookup(isbn)");  
    
    System.out.println("Testing done.");
  }

}



