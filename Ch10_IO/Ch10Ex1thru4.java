import java.util.Scanner;

/**
    TODO Write a one-sentence summary of your class here.
    TODO Follow it with additional details about its purpose, what abstraction
    it represents, and how to use it.
    
    @author  TODO Your Name
    @version TODO the date
    
    @author   Period - TODO Your Period
    @author   Assignment - Ch10_IO
    
    @author   Sources - TODO list collaborators
 */
public class Ch10Ex1thru4
{
    private Scanner scan;

    /**
     *  Constructs a Scanner for input from the console.
     */
    public Ch10Ex1thru4()
    {
        scan = new Scanner( System.in );
    }

    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * @param str input for the various methods
     */
    public Ch10Ex1thru4( String str )
    {
        scan = new Scanner( str );
    }

    /**
      TODO Description
     */
    public void areaOfACircle()
    {
        System.out.println("Input the radius:");
        int input = scan.nextInt();
        System.out.println("The radius is: " + input
            + " The area is: " + (Math.PI * (input * input)));
    }

    /**
      TODO Description
     */
    public void centsToDollars()
    {
        System.out.println("Input the cents:");
        int input = scan.nextInt();
        System.out.println("That is " + (input / 100) + " dollars and " 
            + (input % 100) + " cents.");
    }

    /**
      TODO Description
     */
    public void correctChange()
    {
        System.out.println("Input the cents");
        int input = scan.nextInt();
        int d = input / 100;
        int q = (input % 100) / 25;
        int di = ((input % 100) % 25) / 10;
        int n = (((input % 100) % 25) % 10) / 5;
        int p = ((((input % 100) % 25) % 10) % 5);
        System.out.println("Your change is: " + d + " dollar, " + q + 
            " quarter, " + di + " dime, " + n + " nickel, " + p + " cent.");
    }

    /**
      TODO Description
     */
    public void ohmsLaw()
    {
        System.out.println("Input the voltage");
        int v = scan.nextInt();
        System.out.println("Input the resistance");
        int r = scan.nextInt();
        double i = (v + 0.0) / r;
        System.out.println("The current is " + i);
    }

    /**
      Testing method: instantiates a Lesson10Exercises object and then invokes
      each method.

      @param args  command-line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch10Ex1thru4 exercise = new Ch10Ex1thru4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "    (1) Area of a Circle" );
            System.out.println( "    (2) Cents to Dollars" );
            System.out.println( "    (3) Correct Change" );
            System.out.println( "    (4) Ohm's Law" );
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
                        exercise.areaOfACircle();
                        break;
                    case '2':
                        exercise.centsToDollars();
                        break;
                    case '3':
                        exercise.correctChange();
                        break;
                    case '4':
                        exercise.ohmsLaw();
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
