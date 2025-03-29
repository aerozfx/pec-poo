import java.util.Date;
/**
 * Write a description of class Travel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Travel
{
    private String from;
    private String to;
    private int cost;
    private Date timestamp;
    public Travel(String origin, String destination, int travelCost)
    {
        this.from = origin;
        this.to = destination;
        this.cost = travelCost;
        this.timestamp = new Date();
    }
    
    public void printDetails() {
        System.out.println(this.timestamp);
        System.out.println(this.from + " - " + this.to);
        System.out.println();
        System.out.println("Total: " + this.cost);
    }
}
