import java.util.Arrays;


public class StringMethods {

    public static int frequencyOfSubstring(String str, String substr) {
        int frequency = 0;
        int index = str.indexOf(substr);
        while (index != -1) {
            frequency++;
            index = str.indexOf(substr, index + 1);
        }
        return frequency;
    }

  
    public static boolean areAnagrams(String str1, String str2) {
        char[] arr1=str1.toLowerCase().toCharArray();
        char[] arr2=str2.toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

  
    public static void main(String[] args) {
        String str = "Hello, World! Hello again!";
        String substr = "Hello";
        int frequency = frequencyOfSubstring(str, substr);
        System.out.println("Frequency of '" + substr + "' in '" + str + "': " + frequency);

        String str1 = "Listen";
        String str2 = "Silent";
        boolean result=areAnagrams(str1, str2);
        System.out.println("Are '" + str1 + "' and '" + str2 + "' anagrams? " + result);
    }
}
