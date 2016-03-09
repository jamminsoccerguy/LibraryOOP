package library;

//import classes
import javax.swing.ImageIcon;
import java.math.*;

/**
 * Created by Mike Plucker
 * Date: 3/8/2016
 * Class: CSCI 1933-12
 */

/**
 * This class is a sub-class of LibraryMaterial. It develops a books attributes.
 *
 * @author Mike Plucker
 * Class: CSCI 2001-51
 * Due Date: 04/30/14
 *
 * Version: 1.00
 *
 */

/**Book class extends LibraryMaterial */
/** Concept #3 Inheritance */
public class Book extends LibraryMaterial {

    /** Concept #1 Encapsulation/Data hiding */
    //declare field variables as private
    private String bookType; //(hardcover/paperback/large)
    private int printEdition; //(1rst/2nd/3rd/4th...)
    private int numberOfPages;
    private ImageIcon coverImage;


    /** Concept #2 Default constructor */
    /** Concept #7 Method overloading */
    //no argument constructor (acts as default constructor)
    public Book(){
        this("Unknown", "Select a Book", new BigDecimal("0.00"), 0, "Unknown", 0, 0, null); //initialize all field variables to their default value.
    }

    /** Concept #7 Method overloading
     * @param author
     * @param title
     * @param bookType
     * @param pubYear
     * @param price
     * @param printEdition
     * @param coverImage
     * @param numberOfPages
     * constructor to initialize all field variables (including super class field variables)
     */
    public Book(String author, String title, BigDecimal price, int pubYear, String bookType, int printEdition, int numberOfPages, ImageIcon coverImage){

        /** Concept #5 super reference */
        //initialize variables
        super(author, title, price, pubYear); //pass to LibraryMaterial constructor
        this.bookType = bookType;
        setPrintEdition(printEdition); //validate and store printEdition
        setNumberOfPages(numberOfPages); //validate and store numberOfPages
        this.coverImage = coverImage;
    }

    /** Concept #7 Method overloading
     * @param author
     * @param title
     * @param pubYear
     * @param price
     * @param printEdition
     * @param coverImage
     * constructor to initialize firstEdition book only (includes super class field variables)
     */
    public Book(String author, String title, BigDecimal price, int pubYear, int printEdition, ImageIcon coverImage){

        /** Concept #5 super reference */
        //initialize variables
        super(author, title, price, pubYear); //pass to LibraryMaterial constructor

        if(printEdition == 1){ //only initialize if book is a first edition
            this.printEdition = printEdition;
            this.coverImage = coverImage;
            bookType = "Unknown";
        }
    }

    /**
     * set bookType
     * @param bookType
     */
    public void setBookType(String bookType){
        this.bookType = bookType;
    }

    /**
     * validate and set printEdition
     * @param printEdition
     */
    public void setPrintEdition(int printEdition){
        if(printEdition >= 0){ //validate if printEdition is positive
            this.printEdition = printEdition;
        }
        else
            throw new IllegalArgumentException("Print Edtion must be > 0"); //throws exception if printEdition is negative
    }

    /**
     * validate and set numberOfPages
     * @param numberOfPages
     */
    public void setNumberOfPages(int numberOfPages){
        if(numberOfPages >= 0){ //validate if numberOfPages is positive
            this.numberOfPages = numberOfPages;
        }
        else
            throw new IllegalArgumentException("Number of Pages must be > 0"); //throws exception if numberOfPages is negative
    }

    /**
     * set coverImage
     * @param coverImage
     */
    public void setCoverImage(ImageIcon coverImage) {
        this.coverImage = coverImage;
    }

    /**
     * get bookType
     * @return bookType
     */
    public String getBookType(){
        return bookType;
    }

    /**
     * get printEdition
     * @return printEdition
     */
    public int getPrintEdition(){
        return printEdition;
    }

    /**
     * get numberOfPages
     * @return numberOfPages
     */
    public int getNumberOfPages(){
        return numberOfPages;
    }

    /**
     * get coverImage
     * @return coverImage
     */
    public ImageIcon getCoverImage() {
        return coverImage;
    }

    /**
     * method to find appropriate ordinal suffix and include it at the end of the printEdition number
     * @param suffix
     * @return suffix
     *
     */
    public String getOrdinalSuffix(int suffix){
        if(suffix == 0){
            return ""; //if printEdition is zero, don't add suffix
        }
        int hundredRemainder = suffix % 100; //declare local variable...find 2 digit remainder
        if(hundredRemainder >= 10 && hundredRemainder <= 20){
            return "th"; //any number in the "teens"...11th, 15th, 112th...etc.
        }
        int tenRemainder = suffix % 10; //declare local variable...find 1 digit remainder
        switch(tenRemainder){
            case 1:
                return "st"; //for all non teen numbers ending in 1...1st, 21st, 151st...etc.
            case 2:
                return "nd"; //for all non teen numbers ending in 2...2nd, 22nd, 152nd...etc.
            case 3:
                return "rd"; //for all non teen numbers ending in 3...3rd, 23rd, 153rd...etc.
            default:
                return "th"; //all other numbers...4th, 128th, 156th...etc.
        }
    }

    /** Concept #6 Method Overriding
     * @return toString
     * overrides abstract method displayInfo in LibraryMaterial parent class
     * method to display information about a book
     */
    @Override
    public String displayInfo(){
        return String.format("%s\nBook Type: %s\nEdition: %d%s\nNumber of Pages: %d\n", super.toString(), getBookType(), getPrintEdition(),
                getOrdinalSuffix(getPrintEdition()), getNumberOfPages()); //display book info
    }
}
