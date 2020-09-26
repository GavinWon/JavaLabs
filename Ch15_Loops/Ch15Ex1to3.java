import java.util.*;


/**
 * Chapter 15 - Loops Exercises 1-3.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * @author Period - TODO Your Period
 * @author Assignment - Ch15Ex1to3
 * @author Sources - TODO list collaborators
 */
public class Ch15Ex1to3
{
    private Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch15Ex1to3()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch15Ex1to3( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * TODO Description
     */
    public void inclusiveIntegers()
    {
        System.out.println( "Enter Start:" );
        int start = scan.nextInt();
        System.out.println( "Enter End:" );
        int end = scan.nextInt();

        while ( start <= end )
        {
            System.out.println( start );
            start += 1;
        }
    }


    /**
     * TODO Description
     */
    public void repeatWord()
    {
        System.out.println( "Enter a word:" );
        String word = new String( scan.nextLine() );

        int count = 1;
        while ( count <= word.length() )
        {
            System.out.println( word );
            count += 1;
        }

    }


    /**
     * TODO Description
     */
    public void twoWords()
    {
        System.out.println( "Enter first word:" );
        String word1 = new String( scan.nextLine() );
        System.out.println( "Enter the second word:" );
        String word2 = new String( scan.nextLine() );

        System.out.print( word1 );
        int dotCount = 30 - word1.length() - word2.length();
        while ( dotCount > 0 )
        {
            System.out.print( "." );
            dotCount -= 1;
        }
        System.out.print( word2 );

    }


    /**
     * Testing method: instantiates a Ch15Ex1to3 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch15Ex1to3 exercise = new Ch15Ex1to3();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Inclusive Integers" );
            System.out.println( "   (2) Repeat Word" );
            System.out.println( "   (3) Two Words" );
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
                        exercise.inclusiveIntegers();
                        break;
                    case '2':
                        exercise.repeatWord();
                        break;
                    case '3':
                        exercise.twoWords();
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
