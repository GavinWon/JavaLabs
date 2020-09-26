import java.util.*;


/**
 * Chapter 13 - Single-branch if Statements Programming Exercises 1-4
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - Ch13Ex1to4
 * 
 * @author Sources - TODO list collaborators
 */
public class Ch13Ex1to4
{
    private Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch13Ex1to4()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch13Ex1to4( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * TODO Description
     */
    public void internetDelicatessen()
    {
        System.out.println( "Enter the item: " );
        String item = scan.nextLine();
        System.out.println( "Enter the price; " );
        int price = scan.nextInt();
        System.out.println( "Overnight delivery: " );
        int overnight = scan.nextInt();

        System.out.println( "Invoice:" );
        System.out.println( "\t" + item + "\t" + price );
        double shipping;
        if ( price < 1000 )
        {
            shipping = 2.0;
        }
        else
        {
            shipping = 3.0;
        }
        if ( overnight == 1 )
        {
            shipping += 5.0;
        }
        System.out.println( "\tshipping\t" + shipping );
        System.out.println( "\ttotal\t\t" + ( price / 100.00 + shipping ) );
    }


    /**
     * TODO Description
     */
    public void steamEngineEfficiency()
    {
        System.out.println( "Air Temperature:" );
        int airTemp = scan.nextInt();
        System.out.println( "Steam Temperature" );
        int steamTemp = scan.nextInt();
        double efficiency;

        if ( steamTemp < 373 )
        {
            efficiency = 0;
        }
        else
        {
            efficiency = 1 - ( ( airTemp + 0.0 ) / steamTemp );
        }
        System.out.println( "Efficiency: " + efficiency );
    }


    /**
     * TODO Description
     */
    public void microwaveOven()
    {
        System.out.println( "Enter the number of items:" );
        int items = scan.nextInt();
        System.out.println( "Recommended heating time:" );
        double secs = scan.nextDouble();

        if ( items == 1 )
        {
            System.out.println( "You should heat for " + secs + " seconds" );
        }
        else if ( items == 2 )
        {
            System.out.println( "You should heat for " + ( 1.5 * secs ) + " seconds." );
        }
        else if ( items == 3 )
        {
            System.out.println( "You should heat for " + ( 2 * secs ) + " seconds" );
        }
        else
        {
            System.out.println( "Heating more than three items at once is not recommended" );
        }
    }


    /**
     * TODO Description
     */
    public void fantasyGame()
    {
        System.out.println( "Welcome to HaveAtIt's Quest" );

        System.out.println( "Enter the name of your character:" );
        String name = new String( scan.nextLine() );

        System.out.println( "Enter the strength (1-10):" );
        int strength = scan.nextInt();

        System.out.println( "Enter health (1-10):" );
        int health = scan.nextInt();

        System.out.println( "Enter luck (1-10):" );
        int luck = scan.nextInt();

        if ( strength + health + luck > 15 )
        {
            System.out.println( "You have given your character too many points!" );
            System.out.println( "Defalut values have been asigned: " );
            System.out.println();
            System.out.println( name + ", strength: 5, health: 5, luck: 5" );
        }
        else
        {
            System.out.println(
                name + ", strength: " + strength + ", health: " + health + ", luck: " + luck );
        }
    }


    /**
     * Testing method: instantiates a Lesson15Exercises object and then invokes
     * each method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch13Ex1to4 exercise = new Ch13Ex1to4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Internet Delicatessen" );
            System.out.println( "   (2) Steam Engine Efficiency" );
            System.out.println( "   (3) Microwave Oven" );
            System.out.println( "   (4) Fantasy Game" );
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
                        exercise.internetDelicatessen();
                        break;
                    case '2':
                        exercise.steamEngineEfficiency();
                        break;
                    case '3':
                        exercise.microwaveOven();
                        break;
                    case '4':
                        exercise.fantasyGame();
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
