import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.util.Arrays.asList;

public class Second {
    
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Pass words sequence");
            return;
        }        
        
        String sequence = args[0];
        String[] words = sequence.split(" ");
        
        if (words.length < 3) {
            System.out.println("Should contain at least 3 words");
            return;
        }
    
        Set<Character> vowels = new HashSet<>(asList('a', 'e', 'i', 'o', 'u', 'y'));
        Map<Character, Integer> sortedCharactersCount = new TreeMap<>();
        
        for (int i = 1; i <= 3; i++) {
            String word = words[words.length-i];
            char[] characters = word.toLowerCase().toCharArray();
            
            for (char character : characters) {
                if (vowels.contains(character)) {
                    int count = sortedCharactersCount.getOrDefault(character, 0);
                    sortedCharactersCount.put(character, count+1);
                }
            }
        }
    
        for (Map.Entry<Character, Integer> entry : sortedCharactersCount.entrySet()) {
            char character = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                System.out.print(character + " ");
            }
        }
    }
}
