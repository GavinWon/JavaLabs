import java.util.*;


/**
 * Chapter 16 - More About Counting Loops Exercises 1-3.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - Ch16Ex1_3
 * 
 * @author Sources - TODO list collaborators
 */
public class Ch16Ex1to3
{
    private Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch16Ex1to3()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch16Ex1to3( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * @return an integer, sum of the all the ints
     */
    public int addingUpInts()
    {
        int sum = 0;

        System.out.println( "How many integers will be added:" );
        int numbersAdded = scan.nextInt();

        while ( numbersAdded > 0 )
        {
            System.out.println( "Enter and integer:" );
            sum += scan.nextInt();
            numbersAdded = numbersAdded - 1;
        }

        return sum;
    }


    /**
     * @return an double of the sum of inverse
     */
    public double inverseSum()
    {
        double invSum = 0.0;

        System.out.println( "Enter N:" );
        int n = scan.nextInt();

        while ( n > 0 )
        {
            invSum += 1.0 / n;
            n = n - 1;
        }

        return invSum;
    }


    /**
     * @return a double stfDeviation()
     */
    public double stdDeviation()
    {
        double stdDev = 0.0;

        System.out.println( "Enter the amount of numbers to follow:" );
        int n = scan.nextInt();
        int n2 = n;

        double avg = 0;
        double avgSquare = 0;
        double amt;
        while ( n > 0 )
        {
            System.out.println( "Enter a number:" );
            amt = scan.nextDouble();
            avg += amt;
            avgSquare += amt * amt;
            n -= 1;
        }

        double avg2 = ( avg / n2 ) * ( avg / n2 );
        avgSquare = avgSquare / n2;
        stdDev = Math.sqrt( avgSquare - avg2 );

        return stdDev;
    }


    /**
     * Testing method: instantiates a Ch16Ex1to3 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch16Ex1to3 exercise = new Ch16Ex1to3();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Adding up Integers" );
            System.out.println( "   (2) Inverse Sum" );
            System.out.println( "   (3) Standard Deviation" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        int sumOfInts = exercise.addingUpInts();
                        System.out.println( "addingUpInts() = " + sumOfInts );
                        break;
                    case '2':
                        double invSum = exercise.inverseSum();
                        System.out.println( "inverseSum() = " + invSum );
                        break;
                    case '3':
                        double stdDev = exercise.stdDeviation();
                        System.out.println( "stdDeviation() = " + stdDev );
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
