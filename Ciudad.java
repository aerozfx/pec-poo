import java.util.Arrays;
/**
 * Write a description of class Ciudad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ciudad
{
    // instance variables - replace the example below with your own
    private int origin;
    private int limit; 
    /**
     * Constructor for objects of class Ciudad
     */
    public Ciudad(int limit)
    {
        // initialise instance variables
        this.origin = 0;
        this.limit = limit;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    public int getOrigin() {
        return this.origin;
    }
    
    public int getLimit() {
        return this.limit;
    }
}
