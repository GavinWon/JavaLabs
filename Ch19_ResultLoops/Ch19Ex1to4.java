import java.util.*;


/**
 * Chapter 19 - Result-controlled Loops Exercises 1-4.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - Ch19Ex1to4
 * 
 * @author Sources - TODO list collaborators
 */
public class Ch19Ex1to4
{
    private Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch19Ex1to4()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch19Ex1to4( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * TODO Description
     */
    public void creditCardBill()
    {
        System.out.println( "Enter the balance:" );
        double balance = scan.nextDouble();
        System.out.println( "Enter the montly interest:" );
        double interest = scan.nextDouble();
        System.out.println( "Enter the monthly payment:" );
        double pay = scan.nextDouble();

        int month = 1;
        while ( balance > pay )
        {
            System.out.print( "Month: " + month + "\t" );
            balance = ( ( balance + balance * interest / 100 ) - pay );
            System.out.print( "balance: " + balance + "\t" );
            System.out.println( "total payments: " + pay * month );
            month += 1;
        }
        System.out.print( "Month: " + month + "\t" );
        System.out.print( "balance: 0.0\t" );
        System.out.println( "total payments: " + ( pay * ( month - 1 ) + balance ) );
    }


    /**
     * TODO Description
     */
    public void drugPotency()
    {
        int month = 0;
        double effect = 100;
        while ( effect > 50 )
        {
            System.out.print( "month: " + month + "\t" );
            System.out.println( "effectiveness: " + effect );
            effect = effect * 24 / 25;
            month += 1;
        }

        System.out.print( "month: " + month + "\t" );
        System.out.print( "effectiveness: " + effect + " DISCARDED" );
    }


    /**
     * TODO Description
     */
    public void eToX()
    {
        System.out.println( "Enter x" );
        int x = scan.nextInt();
        double term = 1;
        int n = 1;
        double sum = 1;
        while ( term > 1.0E-12 )
        {
            term = term * ( ( x + 0.0 ) / n );
            System.out.print( "n: " + n + "\t" );
            System.out.print( "term: " + term + "\t" );
            sum += term;
            System.out.println( "sum: " + sum );
            n += 1;
        }
        System.out.println( "my\te^x: " + sum );
        System.out.println( "real\te^x: " + Math.exp( x ) );
    }


    /**
     * TODO Description
     */
    public void newtons1overX()
    {
        System.out.println( "Enter a number for A:" );
        double a = scan.nextDouble();
        System.out.println( "Enter a number for B: " );
        double b = scan.nextDouble();
        double x = 0;
        if ( b == 0 || b <= -100000 || b >= 100000 )
        {
            System.out.println( "The value for B is invalid" );
        }
        else
        {
            if ( b < 0 )
            {
                x = -0.001;
            }
            else
            {
                x = 0.001;
            }
            while ( 1 - x * b >= 1.0E-12 )
            {
                x = x * ( 2 - b * x );
            }
        }
        System.out.println( a * x );
    }


    /**
     * each method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch19Ex1to4 exercise = new Ch19Ex1to4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Credit Card Bill" );
            System.out.println( "   (2) Drug Potency" );
            System.out.println( "   (3) e^x" );
            System.out.println( "   (4) 1/X by Newton's Method" );
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
                        exercise.creditCardBill();
                        break;
                    case '2':
                        exercise.drugPotency();
                        break;
                    case '3':
                        exercise.eToX();
                        break;
                    case '4':
                        exercise.newtons1overX();
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
