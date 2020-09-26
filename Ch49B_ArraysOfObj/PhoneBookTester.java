import java.util.*;

/**
   The application will search for a name and will then print out that person's
   phone number. The list of names and phone numbers is implemented as an array
   of PhoneEntry objects. phoneBook is an array of references to phoneEntry
   objects. The class PhoneBook contains the data and a search method. Its
   search method will return a reference to the PhoneEntry that matches the
   name being sought. 

   @author  George Peck
   @version Feb 03, 2011

   @author  Period - 1-7
   @author  Assignment - Ch49B_PhoneBook

   @author  Sources - Bradley Kjell
 */
public class PhoneBookTester
{
    public static Scanner console = new Scanner(System.in);

    /**
     * Displays a menu of menu choice and prompts for user's choice.
     * 
     * @return menu choice
     */
    public static String doMenu()
    {
        System.out.println();
        System.out.println( "Phonebook Menu" );
        System.out.println( "==============" );
        System.out.println();
        System.out.println( "(S)earch for a name" );
        System.out.println( "(A)dd a new name and phone number" );
        System.out.println( "(D)elete a name (and phone number)" );
        System.out.println( "(P)rint all Phonebook entries" );
        System.out.println();
        System.out.println( "(Q)uit" );
        System.out.println();
        System.out.print( "Enter your choice: " );

        String input = console.nextLine();

        if ( input.length() == 0 )
        {
            input = "Invalid Choice";
        }

        return input;
    }

    /**
     * Prompts for and enters search parameters
     * 
     * @param pb PhoneBook to be searched
     */
    public static void doSearch( PhoneBook pb )
    {
        System.out.println();
        System.out.print( "Last Name? " );
        String lastName = console.nextLine();

        System.out.print( "First Name? " );
        String firstName = console.nextLine();

        PhoneEntry[] pEntry =
            pb.search( new PhoneEntry( firstName, lastName, null ) );

        if ( pEntry != null && pEntry[0] != null )
        {
            for ( int i = 0; i < pEntry.length && pEntry[i] != null; i++ )
            {
                System.out.println( pEntry[i].firstName + " "
                    + pEntry[i].lastName + ": " + pEntry[i].phoneNum );
            }
        }
        else
        {
            System.out.println( "Name not found" );
        }
    }

    /**
     * Prompts for and enters parameters for a new PhoneBook entry
     * 
     * @param pb PhoneBook to be added to
     */
    public static void doAdd( PhoneBook pb )
    {
        System.out.println();
        System.out.print( "Last Name? " );
        String lastName = console.nextLine();

        System.out.print( "First Name? " );
        String firstName = console.nextLine();

        System.out.print( "Phone Number? " );
        String phoneNum = console.nextLine();

        PhoneEntry pEntry =
            pb.add( new PhoneEntry( firstName, lastName, phoneNum ) );

        if ( pEntry == null )
            System.out.println( "ERROR - Phonebook is full!" );
    }  

    /**
     * Prompts for and enters parameters for a PhoneEntry to be deleted from the
     * PhoneBook
     * 
     * @param pb PhoneBook to be deleted from
     */
    public static void doDelete( PhoneBook pb )
    {
        System.out.println();
        System.out.print( "Last Name? " );
        String lastName = console.nextLine();

        System.out.print( "First Name? " );
        String firstName = console.nextLine();

        PhoneEntry pEntry =
            pb.delete( new PhoneEntry( firstName, lastName, "" ) );

        if ( pEntry == null )
        {
            System.out.println( "Entry not found!" );
        }
        else
        {
            System.out.println( "Deleted: " + pEntry );
        }

    }  

    /**
     * The main program for the PhoneBookTester class. Displays menu and
     * processes user choice by invoking the action associated with the user's
     * choice.
     * 
     * @param args The command line arguments (not used)
     */
    public static void main( String[] args )
    {
        PhoneBook pb = new PhoneBook();
        String response;

        do
        {
            response = doMenu();
            switch (response.toUpperCase().charAt( 0 ))
            {
                case 'S':
                    doSearch( pb );
                    break;
                case 'A':
                    doAdd( pb );
                    break;
                case 'D':
                    doDelete( pb );
                    break;
                case 'P':
                    System.out.println();
                    pb.print();
                    break;
                case 'Q':
                    break;
                default:
                    System.out.println();
                    System.out.println( "Invalid Choice!" );
                    break;
            }
        }
        while ( response.toUpperCase().charAt( 0 ) != 'Q' );

        System.out.println("Goodbye");
    }
}
