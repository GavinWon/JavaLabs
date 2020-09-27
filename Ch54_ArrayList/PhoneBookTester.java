/**
   Filename: PhoneBookTester.java

   Assignment: Lesson 54 - PhoneBook (ArrayList)
   Period:     1 - 7

   Your Description Here.

   @author     TODO Your Name Here
   @version    TODO Month 00, 2005

   Sources:   
 */
import java.util.*;

public class PhoneBookTester
{
    public static Scanner console = new Scanner(System.in);

    /**
          Displays a menu of menu choice and prompts for user's choice. 
    
          @return    menu choice
     */
    public static String doMenu()
    {
        System.out.println();
        System.out.println("Phonebook Menu");
        System.out.println("==============");
        System.out.println();
        System.out.println("(S)earch for a name");
        System.out.println("(A)dd a new name and phone number");
        System.out.println("(D)elete a name (and phone number)");
        System.out.println("(P)rint the phonebook");
        System.out.println();
        System.out.println("(Q)uit");
        System.out.println();
        System.out.print("Enter your choice: ");

        String input = console.nextLine();

        if (input.length() == 0)
            input = "Invalid Choice";

        return input;
    }

    /**
      Prompts for and enters search parameters

      @param  pb  PhoneBook to be searched
     */
    public static void doSearch(PhoneBook pb)
    {
        System.out.println();
        System.out.print("Last Name? ");
        String lastName = console.nextLine();

        System.out.print("First Name? ");
        String firstName = console.nextLine();

        ArrayList<PhoneEntry> pEntry = pb.search(new PhoneEntry(firstName, lastName, "")); 

        if (!pEntry.isEmpty())
        {
            Iterator<PhoneEntry> iter = pEntry.iterator();
            while (iter.hasNext())
            {
                PhoneEntry pe = iter.next();
                System.out.println(pe);
            }
        }
        else
            System.out.println("Name not found");
    }

    /**
      Prompts for and enters parameters for a new PhoneBook entry

      @param  pb  PhoneBook to be added to
     */
    public static void doAdd(PhoneBook pb)
    {
        System.out.println();
        System.out.print("Last Name? ");
        String lastName = console.nextLine();

        System.out.print("First Name? ");
        String firstName = console.nextLine();

        System.out.print("Phone Number? ");
        String phoneNum = console.nextLine();

        pb.add(new PhoneEntry(firstName, lastName, phoneNum));
    }  

    /**
      Prompts for and enters parameters for a PhoneEntry to be deleted
      from the PhoneBook

      @param  pb  PhoneBook to be deleted from
     */
    public static void doDelete(PhoneBook pb)
    {
        System.out.println();
        System.out.print("Last Name? ");
        String lastName = console.nextLine();

        System.out.print("First Name? ");
        String firstName = console.nextLine();

        PhoneEntry pEntry = pb.delete(new PhoneEntry(firstName, lastName,""));

        if (pEntry == null)
            System.out.println("Entry not found!");
        else
            System.out.println("Deleted: " + pEntry);

    }  

    /**
      The main program for the PhoneBookTester class.
      Displays menu and processes user choice by invoking
      the action associated with the user's choice.

     @param  args  The command line arguments (not used)
     */
    public static void main (String[] args)
    {
        PhoneBook pb = new PhoneBook();

        String response;

        do
        {
            response = doMenu();
            if (response.toUpperCase().charAt(0) == 'S')
            {
                doSearch(pb);
            }
            else if (response.toUpperCase().charAt(0) == 'A')
            {
                doAdd(pb);
            }
            else if (response.toUpperCase().charAt(0) == 'D')
            {
                doDelete(pb);
            }
            else if (response.toUpperCase().charAt(0) == 'P')
            {
                System.out.println();
                //pb.print();
            }
            else if (response.toUpperCase().charAt(0) != 'Q')
            {
                System.out.println();
                System.out.println("Invalid Choice!");
            }     
        } while (response.length() > 0 &&
                        response.toUpperCase().charAt(0) != 'Q');

    }
}

