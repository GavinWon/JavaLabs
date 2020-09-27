import java.util.*;

public class BitManipulation
{
    private static Scanner scan = new Scanner(System.in);
    private int a = 0;
    
    public static void main(String[] args) {
        System.out.println("What do you want me to do?");
        System.out.println("1: Check if an integer is a power of 2.");
        System.out.println("2: Find the number of bits set for a positive integer");
        System.out.println("3: Reverse digits of a Integer");
        System.out.println("4: Give the distinct values in an array");
        System.out.println("5: Return the reverse of a string");
        int number = scan.nextInt();
        if(number == 1) {
            System.out.println("What number would you like me to check?");
            int value = scan.nextInt();
            System.out.println(checkPowerofTwo(value));
        }else if (number == 2) {
            System.out.println("What number would you like me to find?");
            int value = scan.nextInt();
            System.out.println(findBitsSets(value));
        }else if (number == 3) {
            System.out.println("What integer would you like to reverse?");
            int value = scan.nextInt();
            System.out.println(reverseInt(value));
        }else if (number == 4) {
            System.out.println("What array of numbers would you like me to see?");
            int[] a = {1,2,3,4,4};
            System.out.println(distinctArray(a));
        }else if (number == 5) {
            System.out.println("What string would you like me to reverse?");
            String word = scan.nextLine();
            word = scan.nextLine();
            System.out.println(reverseString(word));
        }
        
       
        
    }
    private static boolean checkPowerofTwo(int value){
        if ((value & (value - 1)) == 0)
            return true;
        else
            return false;
    }
    private static int findBitsSets(int value) {
        int counter = 0;
        while ((value & (value - 1)) != 0) {
            value = value & (value - 1);
            counter += 1;
        }
        return counter + 1;
    }
    private static int reverseInt (int value) {
        String str1 = Integer.toString(value);
        String str2 = "";
        for (int l = 1 ; l <= str1.length() ; l++) {
            str2 = str2 + str1.charAt(str1.length() - l);
        }
        int number = Integer.parseInt(str2);
        return number;
    }
    private static int distinctArray (int[] a) {
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (int e = 0 ; e < a.length ; e++ ) {
            if (!newArray.contains(a[e])) {
                newArray.add(a[e]);
            }
        }
        int value = newArray.size();;
        return value;
    }
    private static String reverseString(String value) {
        char[] reversedCharacters = value.toCharArray();
        for(int index = 0 ; index < value.length() / 2 ; index++) {
            char temp = reversedCharacters[index];
            reversedCharacters[index] = reversedCharacters[value.length() - 1 - index];
            reversedCharacters[value.length() - 1 - index] = temp;
        }
//       char[] reversedCharacters = new char[value.length()];
//       for (int index = value.length() - 1; index >= 0  ; index--) {
//           reversedCharacters[value.length() - index - 1] = value.charAt(index);
//        }
        
        return String.valueOf(reversedCharacters);
    }
}
