import java.util.*;


/**
 * Chapter 14 - Boolean Expressions Programming Exercises 1-4.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - Ch14Ex1to4
 * 
 * @author Sources - TODO list collaborators
 */
public class Ch14Ex1to4
{
    private Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch14Ex1to4()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch14Ex1to4( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * TODO Description
     */
    public void checkCharge()
    {
        System.out.println( "Checking Account:" );
        double check = scan.nextDouble();
        System.out.println( "Savings Account:" );
        double saving = scan.nextDouble();

        if ( check > 1000 || saving > 1500 )
        {
            System.out.println( "Service Charge: $0.00" );
        }
        else
        {
            System.out.println( "Service Charge: $0.15" );
        }
    }


    /**
     * TODO Description
     */
    public void tirePressure()
    {
        System.out.println( "Input right front pressure" );
        int rfp = scan.nextInt();
        System.out.println( "Input left front pressure" );
        int lfp = scan.nextInt();
        System.out.println( "Input right rear pressure" );
        int rrp = scan.nextInt();
        System.out.println( "Input left rear pressure" );
        int lrp = scan.nextInt();

        if ( rfp == lfp && rrp == lrp )
        {
            System.out.println( "Inflation is OK" );
        }
        else
        {
            System.out.println( "Inflation is BAD" );
        }
    }


    /**
     * TODO Description
     */
    public void moreTirePressure()
    {
        boolean goodPressure = true;
        System.out.println( "Input right front pressure" );
        int rfp = scan.nextInt();
        if ( rfp > 45 || rfp < 35 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }

        System.out.println( "Input left front pressure" );
        int lfp = scan.nextInt();
        if ( lfp > 45 || lfp < 35 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }

        System.out.println( "Input right rear pressure" );
        int rrp = scan.nextInt();
        if ( rrp > 45 || rrp < 35 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }

        System.out.println( "Input left rear pressure" );
        int lrp = scan.nextInt();
        if ( lrp > 45 || lrp < 35 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }

        if ( rfp == lfp && rrp == lrp && goodPressure )
        {
            System.out.println( "Inflation is OK" );
        }
        else
        {
            System.out.println( "Inflation is BAD" );
        }

    }


    /**
     * TODO Description
     */
    public void pressureIsBuilding()
    {
        boolean goodPressure = true;
        System.out.println( "Input right front pressure" );
        int rfp = scan.nextInt();
        if ( rfp > 45 || rfp < 35 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }

        System.out.println( "Input left front pressure" );
        int lfp = scan.nextInt();
        if ( lfp > 45 || lfp < 35 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }

        System.out.println( "Input right rear pressure" );
        int rrp = scan.nextInt();
        if ( rrp > 45 || rrp < 35 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }

        System.out.println( "Input left rear pressure" );
        int lrp = scan.nextInt();
        if ( lrp > 45 || lrp < 35 )
        {
            System.out.println( "Warning: pressure is out of range" );
            goodPressure = false;
        }
        if ( ( rfp - lfp >= -3 && rfp - lfp <= 3 ) && ( rrp - lrp >= -3 && rrp - lrp <= 3 )
            && goodPressure )
        {
            System.out.println( "Inflation is OK" );
        }
        else
        {
            System.out.println( "Inflation is BAD" );
        }
    }


    /**
     * Testing method: instantiates a Ch14Ex1to4 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch14Ex1to4 exercise = new Ch14Ex1to4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Check Charge" );
            System.out.println( "   (2) Tire Pressure" );
            System.out.println( "   (3) More Tire Pressure" );
            System.out.println( "   (4) The Pressure is Building" );
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
                        exercise.checkCharge();
                        break;
                    case '2':
                        exercise.tirePressure();
                        break;
                    case '3':
                        exercise.moreTirePressure();
                        break;
                    case '4':
                        exercise.pressureIsBuilding();
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
