import java.util.*;

public class FunStuff2
{
    private static Scanner scan = new Scanner(System.in);
    public static void main( String[] args )
    {
        System.out.println("What would you like me to do?");
        System.out.println("1: Return the indices of an array, where the sum of its values are equal to a target");
        System.out.println("2: Keep and Sort words that start with an A");
        System.out.println("3: See if two words are an anagram");
        int number = scan.nextInt();
        if(number == 1) {
            System.out.println("Give me a target number");
            int target = scan.nextInt();
            System.out.println("How long is your array?");
            int length = scan.nextInt();
            int[] a = new int[length];
            for(int index = 0 ; index < length ; index++) {
                System.out.println("Give me the " + index + "th number in the array");
                int value = scan.nextInt();
                a[index] = value;
            }
            System.out.println(Arrays.toString(targetMatchingToArrayIndices(target , a)));
        } else if (number == 2) {
            String [] words = {"adg","abe","ab"};
            keepSortAWords2(words);
        } else if (number == 3) {
            String word1 = "racecar";
            String word2 = "aearccr";
            anagramTest(word1,word2);
        }

    }
    private static int[] targetMatchingToArrayIndices(int target , int[] values) {
        
        for (int index = 0 ; index < values.length ; index++) {
            for(int counter = 1 ; index + counter < values.length ; counter++) {
                if(values[index] + values[index + counter] == target){
                    int[] returnValues = {index , index + counter};
                    return returnValues;
                }
            }
        }
        return null;
    }
    private static void keepSortAWords (String [] words) {
        ArrayList<String> finalWords = new ArrayList<>();
        for (int index = 0 ; index < words.length ; index++) {
            if ((words[index]).startsWith( "a" )) {
                finalWords.add(words[index].toUpperCase());
            }
        }
        for (int i = 0; i < finalWords.size(); i++) 
        {
            for (int j = i + 1; j < finalWords.size(); j++) 
            {
                if (finalWords.get(i).compareTo(finalWords.get(j))>0) 
                {
                    String temp = finalWords.get(i);
                    finalWords.set(i , finalWords.get(j));
                    finalWords.set(j , temp);
                }
            }
        }
        System.out.println(Arrays.toString(finalWords.toArray()));
    }
    
    private static void keepSortAWords2 (String[] words) {
        List<String> l = Arrays.asList( words );
        l.stream().filter(a -> a.startsWith("a")).map(String::toUpperCase).sorted().forEach(System.out::println);
        
    
    }
    private static void anagramTest(String word1 , String word2) {
        if (word1.length() != word2.length()) {
            System.out.println(false);
            return;
        }
        word1 = word1.toUpperCase();
        word2 = word2.toUpperCase();
    
        //HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        HashMap<Character, Integer> word1List = new HashMap<>();
        HashMap<Character, Integer> word2List = new HashMap<>();
        for (int index = 0; index < word1.length() ; index++) {
            char temp = word1.charAt( index );
            if (word1List.containsKey(temp)) {
                word1List.put(temp, 1);
            } else {
                word1List.put(temp, word1List.get(temp) + 1);
            }
            
            char temp2 = word2.charAt( index );
            if (word2List.containsKey(temp2)) {
                word2List.put(temp2, 1);
            } else {
                word2List.put(temp2, word2List.get(temp2) + 1);
            }
        }
        System.out.println(word1List.equals(word2List));
    }
}
