import java.util.Scanner;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO the date

   @author  Period - TODO Your Period
   @author  Assignment - Ch11_FloatingPoint

   @author  Sources - TODO list collaborators
 */
public class Ch11Ex1to4
{
    private Scanner scan;

    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch11Ex1to4()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str input for the various methods
     */
    public Ch11Ex1to4( String str )
    {
        scan = new Scanner( str );
    }

    /**
     * TODO Description
     */
    public void annualCost()
    {
        System.out.println("Enter cost per kilowatt-hour in cents");
        double cph = scan.nextDouble();
        System.out.println("Enter killowatt-hours used per year");
        double khy = scan.nextDouble();
        System.out.println("Annual Cost: " + cph * khy / 100);
    }

    /**
     * TODO Description
     */
    public void fallingBrick()
    {
        //Asking for time and giving distance
        System.out.println("Enter the number of seconds: ");
        double s = scan.nextDouble();
        double d = 0.5 * 32.174 * s * s;        
        System.out.println("The brick fell " + d 
                + " feet in " + s + " seconds.");
        
        //Asking for distance and giving time
        System.out.println("Enter the distance");
        d = scan.nextDouble();
        s = Math.sqrt(d * 2 / 32.174);
        System.out.println("The brick fell " + d 
                + " feet in " + s + " seconds.");
    }

    /**
     * TODO Description
     */
    public void base2Log()
    {
        System.out.println("Enter a double:");
        double value = scan.nextDouble();
        System.out.println("Base 2 log of " + value + " is "
                + Math.log(value) / Math.log(2));
    }

    /**
     * TODO Description
     */
    public void harmonicMean()
    {
        System.out.println("Enter X:");
        double x = scan.nextDouble();
        System.out.println("Enter Y");
        double y = scan.nextDouble();
        System.out.println("Arithmetic mean: " + (x + y) / 2);
        System.out.println("Harmonic   mean: " + 2 / (1 / x + 1 / y));
    }

    /**
     * Testing method: instantiates a Ch11Ex1_4 object and then
     * invokes each method
     * 
     * @param args command-line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch11Ex1to4 exercise = new Ch11Ex1to4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "    (1) Annual Cost of Running an Appliance" );
            System.out.println( "    (2) Falling Brick" );
            System.out.println( "    (3) Base 2 Logarithm of a Number" );
            System.out.println( "    (4) Harmonic Mean" );
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
                        exercise.annualCost();
                        break;
                    case '2':
                        exercise.fallingBrick();
                        break;
                    case '3':
                        exercise.base2Log();
                        break;
                    case '4':
                        exercise.harmonicMean();
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
