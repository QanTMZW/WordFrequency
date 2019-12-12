import java.io.*;
import java.util.*;
//* has every library
public class Wordfrequency {
   public static void main(String args[]) throws Exception {
      File inputFile = new File("Gundamu.txt"); //source textfile
      Scanner input = new Scanner (inputFile);
      HashMap<String, Integer> freqs = new HashMap<String, Integer>(); //implementing hashmaps
      String[] words;
      Integer[] counts;
      int arrCounter = 0;
      
      while (input.hasNext()) {
         String word = input.next().toLowerCase().replaceAll("[^a-zA-Z ]", "");//ignores the capitalization/lowercase of every word
         
         if (freqs.get(word) == null) {
            freqs.put(word,1);
         } else {
            freqs.replace(word, freqs.get(word) + 1);
         }
      }
      //we extract the keys and values from our map into discrete arrays
      words = freqs.keySet().toArray(new String[0]);
      counts = freqs.values().toArray(new Integer[0]);
      for (int i = 0 ; i < words.length; i++) {
         for (int j = 1; j < words.length - i; j++) {
            if (counts[j] > counts[j - 1]) {
               int tempCount = counts[j];
               String tempWord = words[j];
               //swapped
               words[j] = words[j - 1];
               words[j - 1] = tempWord;
               counts[j] = counts[j - 1];
               counts[j - 1] = tempCount;
             }
           }
        }
        for (int i = 0; i < words.length; i++) {
         System.out.println(words[i] + ": " + counts[i]);
        }
}
}