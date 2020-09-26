import java.util.*;


/**
 * Chapter 20 - Random Class Exercises 3, 5, 7 & 8.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - Ch20Exercises
 * 
 * @author Sources - TODO list collaborators
 */
public class Ch20Exercises
{
    Scanner scan;

    Random rand = new Random(0);


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch20Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     * @param seed
     *            seed to use for random number generator
     */
    public Ch20Exercises( String str, long seed )
    {
        scan = new Scanner( str );
        rand.setSeed( seed );
    }


    /**
     * TODO Description
     */
    public void furtherImprovedGuessingGame()
    {
        int counter = 1;
        int winC = 0;
        for ( int r = 1; r <= 10; r++ )
        {
            System.out.println( "round " + r );
            System.out.println();
            System.out.println( "I am thinking of a number from 1 to 10." );
            System.out.println( "You must guess what it is in three tries" );

            int randNum = rand.nextInt( 10 ) + 1;
            System.out.println( "Enter a guess" );
            int guess = scan.nextInt();
            while ( randNum != guess && counter < 3 )
            {
                if ( guess + 1 == randNum || guess - 1 == randNum )
                {
                    System.out.println( "hot" );
                }
                else if ( guess + 2 == randNum || guess - 2 == randNum )
                {
                    System.out.println( "warm" );
                }
                else
                {
                    System.out.println( "cold" );
                }
                counter++;
                guess = scan.nextInt();
            }
            if ( counter == 3 && randNum != guess )
            {
                System.out.println( "wrong." );
                System.out.println( "The correct number was " + randNum );
                System.out.println( "You hae won " + winC + " out of " + r + " rounds" );
            }
            else
            {
                winC++;
                System.out.println( "RIGHT!" );
                System.out.println( "You hae won " + winC + " out of " + r + " rounds" );
            }
            counter = 1;

        }
        if ( winC == 10 )
        {
            System.out.println( "Your rating: hackers." );
        }
        else if ( winC == 9 )
        {
            System.out.println( "Your rating: professionals." );
        }
        else if ( winC == 8 )
        {
            System.out.println( "Your rating: advanced." );
        }
        else
        {
            System.out.println( "Your rating: amateurs." );
        }
    }


    /**
     * TODO Description
     */
    public void passwordCracker()
    {
        System.out.println("Enter a 'secret' password-->");
        String line = scan.nextLine();
        System.out.println("Here is your password: " + line);
        String choices = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String password = "";
        int passwordLen = 0, numTries = 0;
        while (!password.equals(line)) {
            password = "";
            while (passwordLen < line.length()) {
                password = password + choices.charAt(rand.nextInt( choices.length()));
                passwordLen++;
            }
            passwordLen = 0;
            numTries++;
        }
        System.out.println("It took " + numTries + " tries to guess it");
    }
   


    /**
     * TODO Description
     */
    public void randomWalk2D()
    {
        double x = 0;
        double y = 0;
        System.out.println( "How many times do we repeat" );
        int times2 = scan.nextInt();
        double amount;
        for ( int times = 0; times < times2; times++ )
        {
            amount = ( rand.nextDouble() * 2 ) - 1;
            x = x + amount;
            amount = ( rand.nextDouble() * 2 ) - 1;
            y += amount;
            System.out.println( x + "," + y );
        }
        System.out.println( Math.sqrt( ( x * x ) + ( y * y ) ) );
    }


    /**
     * TODO Description
     */
    public void squareRootGame()
    {
        System.out.println( "How many rounds" );
        String totalRounds2 = scan.nextLine();
        int totalRounds = Integer.parseInt( totalRounds2 );
        System.out.println( "First Player, sign in -->" );
        String name1 = scan.nextLine();
        System.out.println( "Second Player, sign in-->" );
        String name2 = scan.nextLine();

        double guess1, guess2;
        int counter1 = 0, counter2 = 0;
        boolean flip = true;
        for ( int round = 1; round <= totalRounds; round++ )
        {
            double num = rand.nextDouble();
            num = (num * 99) + 1;
            
            System.out.println( "What is the square root of " + num );
            if ( flip == true )
            {
                System.out.println( name1 + ", your guess:" );
                guess1 = scan.nextDouble();
                System.out.println( name2 + ", your guess:" );
                guess2 = scan.nextDouble();
            }
            else
            {
                System.out.println( name2 + ", your guess:" );
                guess1 = scan.nextDouble();
                System.out.println( name1 + ", your guess:" );
                guess2 = scan.nextDouble();
            }
            flip = !flip;
            System.out.println( "The correct square root: " + Math.sqrt( num ) );
            System.out.println( name1 + " is " + Math.abs( Math.sqrt( num ) - guess1 ) );
            System.out.println( name2 + " is " + Math.abs( Math.sqrt( num ) - guess2 ) );
            if ( ( Math.abs( Math.sqrt( num ) - guess1 ) ) < ( Math
                .abs( Math.sqrt( num ) - guess2 ) ) )
            {
                System.out.println( name1 + " wins!" );
                counter1++;
            }
            else
            {
                System.out.println( name2 + " wins!" );
                counter2++;
            }
        }
        System.out.println();
        System.out.println( "---- Final Score ----" );
        System.out.println( name1 + "\t" + counter1 + "\t" + name2 + "\t" + counter2 );
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

        Ch20Exercises exercise = new Ch20Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (3) Further Improved Guessing Game" );
            System.out.println( "   (5) Password Cracker" );
            System.out.println( "   (7) 2D Random Walk" );
            System.out.println( "   (8) Suqare Root Game" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '3':
                        exercise.furtherImprovedGuessingGame();
                        break;
                    case '5':
                        exercise.passwordCracker();
                        break;
                    case '7':
                        exercise.randomWalk2D();
                        break;
                    case '8':
                        exercise.squareRootGame();
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
