package library;

//import classes
import java.math.*;
import java.text.NumberFormat;

/**
 * Created by Mike Plucker
 * Date: 3/8/2016
 * Class: CSCI 1933-12
 */

/**
 * This class is the Super class of the project.
 *
 * @author Billy Lam
 * Class: CSCI 2001-51
 * Due Date: 04/30/14
 *
 * Version: 1.00
 *
 */
public abstract class LibraryMaterial {

    /** Concept #4 protected visibility modifier */
    //declare field variables as protected
    protected String author, title;

    /**
     * declare field variables as protected
     */
    protected BigDecimal price;

    /**
     * declare field variables as protected
     */
    protected int pubYear;

    /** Concept #1 Encapsulation/Data hiding */
    //create currency formatter
    private NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();


    /** Concept #2 Default constructor */
    /** Concept #7 Method overloading */
    //no argument constructor (default)
    public LibraryMaterial(){
        this(null, null, new BigDecimal("0.00"), 0); //initialize each instance variable to their default value (either null or zero).
    }

    /** Concept #7 Method overloading
     * @param author
     * @param title
     * @param price
     * @param pubYear
     * constructor to initialize author, title, price and published year
     */
    public LibraryMaterial(String author, String title, BigDecimal price, int pubYear){

        //initialize variables
        this.author = author;
        this.title = title;
        setPrice(price); //validate and store price
        this.pubYear = pubYear;
    }

    /**
     *  set author
     * @param author
     */
    public void setAuthor(String author){
        this.author = author;
    }

    /**
     * set title
     * @param title
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * validate and set price
     * @param price
     */
    public void setPrice(BigDecimal price){
        if(price.compareTo(BigDecimal.ZERO) >= 0){ //validate if price is positive
            this.price = price;
        }
        else
            throw new IllegalArgumentException("Price must be >= 0.0"); //throws exception if price is negative
    }

    /**
     * set published year
     * @param pubYear
     */
    public void setPubYear(int pubYear){
        this.pubYear = pubYear;
    }

    /**
     * get author
     * @return  author
     */
    public String getAuthor(){
        return author;
    }

    /**
     * get title
     * @return title
     */
    public String getTitle(){
        return title;
    }

    /**
     * get price
     * @return price
     */
    public BigDecimal getPrice(){
        return price;
    }

    /**
     * get published year
     * @return pubYear
     */
    public int getPubYear(){
        return pubYear;
    }

    /**
     * abstract method overridden by concrete subclasses
     *
     * @return displayInfo
     */
    public abstract String displayInfo(); //no implementation here


    /** Concept #6 Method Overriding
     * -this method overrides a superclass method (Object method toString)
     * -converts LibraryMaterial to String format
     *
     * @return toString
     */
    @Override
    public String toString(){
        return String.format("Title: %s\nAuthor: %s\nPrice: %s\nPublication Year: %d", getTitle(), getAuthor(), moneyFormat.format(getPrice()), getPubYear()); //display info
    }
}
