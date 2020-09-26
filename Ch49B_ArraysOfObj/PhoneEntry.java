/**
   Represents an entry in a phonebook consisting of a first name,
   last name, and phone number.

   @author  George Peck
   @version Feb 26, 2007

   @author  Period - 1-7
   @author  Assignment - Ch49B_PhoneBook

   @author  Sources - Bradley Kjell
 */
public class PhoneEntry
{
    public String firstName;  // first name of a person
    public String lastName;   // first name of a person
    public String phoneNum;   // their phone number

    /**
     * Constructs PhoneEntry object
     * 
     * @param fName first name
     * @param lName last name
     * @param phone phone number
     */
    public PhoneEntry( String fName, String lName, String phone )
    {
        firstName = fName;
        lastName = lName;
        phoneNum = phone;
    }

    /**
     * Returns a string representation of the this PhoneEntry
     *
     * @return  a string representation of the object.
     */
    public String toString()
    {
        return getClass().getName() + "[" + firstName + " " + lastName + " "
        + phoneNum + "]";
    }
}
