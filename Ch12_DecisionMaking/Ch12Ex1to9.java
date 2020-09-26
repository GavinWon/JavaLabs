import java.util.*;

/**
 *  Chapter 12 - Decision Making Programming Exercises 1-9.
 * 
 *  @author TODO Your Name
 *  @version TODO Date
 * 
 *  @author Period - TODO Your Period
 *  @author Assignment - Ch12Ex1to9
 * 
 *  @author Sources - TODO list collaborators
 */
public class Ch12Ex1to9
{
    private Scanner scan;

    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch12Ex1to9()
    {
        scan = new Scanner( System.in );
    }

    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str input for the various methods
     */
    public Ch12Ex1to9( String str )
    {
        scan = new Scanner( str );
    }

    /**
     * TODO Description
     */
    public void discountPrices()
    {
        System.out.println("Enter amount of purchases:");
        int amt = scan.nextInt();
        if (amt > 1000) {
            System.out.println("Discounted price: " + (amt - (amt / 10)));
        }else {
            System.out.println("Discounted price: " + amt);
        }
    }

    /**
     * TODO Description
     */
    public void orderChecker()
    {   //constant prices
        final int boltPrice = 5;
        final int nutPrice = 3;
        final int washerPrice = 1;
        
        System.out.println("Enter number of bolts:");
        int b = scan.nextInt();
        System.out.println("Enter number of nuts:");
        int n = scan.nextInt();
        System.out.println("Enter number of washers:");
        int w = scan.nextInt();
        
        System.out.println("Numer of bolts: " + b);
        System.out.println("Numer of nuts: " + n);
        System.out.println("Numer of washers: " + w);
        
        if (b > n) {
            System.out.println("Check the Order: too few nuts");
        }
        if (2 * b > w) {
            System.out.println("Check the Order: too few washers");
        }
        if (n >= b & w >= 2 * b) {
            System.out.println("Order is OK.");
        }
        
        System.out.println("Total cost: " + 
               ((boltPrice * b) + (nutPrice * n) + (washerPrice * w)));
        
    }

    /**
     * TODO Description
     */
    public void lastChanceGas()
    {
        System.out.println("Tank capacity:");
        int tankCapacity = scan.nextInt();
        System.out.println("Gage reading:");
        int gageReading = scan.nextInt();
        System.out.println("Miles per gallon:");
        int mpg = scan.nextInt();
        
        if ((gageReading / 100.0) * tankCapacity * mpg < 200) {
            System.out.println("Get Gas!");
        }
        else {
            System.out.println("Safe to Proceed!");
        }
        
    }

    /**
     * TODO Description
     */
    public void groundBeefValueCalc()
    {
        System.out.println("Price per pound package A:");
        double pppA = scan.nextDouble();
        System.out.println("Percent lean package A:");
        double plpA = scan.nextDouble();
        System.out.println("Price per pound package B:");
        double pppB = scan.nextDouble();
        System.out.println("Percent lean package B:");
        double plpB = scan.nextDouble();
        
        System.out.println("Package A cost per pound of lean:" + (pppA / plpA * 100 ));
        System.out.println("Package B cost per pound of lean:" + (pppB / plpB * 100 ));
        
        if ((pppA * 100 / plpA) < (pppB * 100 / plpB)) { 
            System.out.println("Package A is the best value");
        }
        else { 
            System.out.println("Package B is the best value");
        }
    }

    /**
     * TODO Description
     */
    public void y2KProblemDetector()
    {
        System.out.println("Year of Birth:");
        int birthYear = scan.nextInt();
        System.out.println("Current year");
        int currentYear = scan.nextInt();
        
        if (currentYear - birthYear > 0) {
            System.out.println("Your age: " + (currentYear - birthYear));
        }
        else {
            System.out.println("Your age: " + (currentYear + 100 - birthYear));
        }
    }

    /**
     * TODO Description
     */
    public void windChillIndex()
    {
        System.out.println("Wind Speed:");
        double v = scan.nextDouble();
        System.out.println("Temperature:");
        double t = scan.nextDouble();
        double wci;
        
        if (0 <= v && v <= 4) {
            wci = t;
        }
        else if (v >= 45) {
            wci = (1.6 * t) - 55;
        }
        else {
            wci = 91.4 + (91.4 - t) * ((0.0203 * v )  - (0.304 * Math.sqrt(v)) - 0.474);
        }
        
        System.out.println("Wind Chill Index: " + wci);
    }

    /**
     * TODO Description
     */
    public void yourAgeInSeconds()
    {
        System.out.println("Number of Years:");
        int y = scan.nextInt();
        System.out.println("Number of Months:");
        int m = scan.nextInt();
        System.out.println("Number of Days");
        int d = scan.nextInt();
        
        int totalDays = 0;
        if (m >= 2) {
            totalDays = (m * 31) - (m / 2) - 2;
        }
        else if (m == 1) {
            totalDays = 31;
        }
        
        totalDays += (y * 365) + d;
        int totalSecs = totalDays * 24 * 60 * 60;
        System.out.println("Seconds Alive: " + totalSecs);
        
    }

    /**
     * TODO Description
     */
    public void matineeMovieTickets()
    {
        System.out.println("Age:");
        int age = scan.nextInt();
        System.out.println("Time:");
        int time = scan.nextInt();
        
        if (age > 13) {
            if (time < 1700) {
                System.out.println("Price is $5.00");
            }
            else {
                System.out.println("Price is $8.00");
            }
        }
        else {
            if (time < 1700) {
                System.out.println("Price is $2.00");
            }
            else {
                System.out.println("Price is $4.00");
            }
        }
    }

    /**
     * TODO Description
     */
    public void midnightMadness()
    {
        System.out.println("Age:");
        int age = scan.nextInt();
        System.out.println("Time:");
        int time = scan.nextInt();
        
        if (age > 13) {
            if (time < 1700) {
                System.out.println("Price is $5.00");
            }
            else if (time > 2200) {
                System.out.println("Price is $4.00");
            }
            else {
                System.out.println("Price is $8.00");
            }
        }
        else {
            if (time < 1700) {
                System.out.println("Price is $2.00");
            }
            else if (time > 2200) {
                System.out.println("Too Young");
            }
            else {
                System.out.println("Price is $4.00");
            }
        }
    }

    /**
     * Testing method: instantiates a Lesson15Exercises object and then invokes
     * each method.
     * 
     * @param args  command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch12Ex1to9 exercise = new Ch12Ex1to9();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "    (1) Discount Prices" );
            System.out.println( "    (2) Order Checker" );
            System.out.println( "    (3) Last Chance Gas" );
            System.out.println( "    (4) Ground Beef Value Calculator" );
            System.out.println( "    (5) Y2K Problem Detector" );
            System.out.println( "    (6) Wind Chill Index" );
            System.out.println( "    (7) Your Age in Seconds" );
            System.out.println( "    (8) Matinee Movie Tickets" );
            System.out.println( "    (9) Midnight Madness" );
            System.out.println( "    (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        exercise.discountPrices();
                        break;
                    case '2':
                        exercise.orderChecker();
                        break;
                    case '3':
                        exercise.lastChanceGas();
                        break;
                    case '4':
                        exercise.groundBeefValueCalc();
                        break;
                    case '5':
                        exercise.y2KProblemDetector();
                        break;
                    case '6':
                        exercise.windChillIndex();
                        break;
                    case '7':
                        exercise.yourAgeInSeconds();
                        break;
                    case '8':
                        exercise.matineeMovieTickets();
                        break;
                    case '9':
                        exercise.midnightMadness();
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
