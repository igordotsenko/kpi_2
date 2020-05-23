import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class First {
    
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Pass words sequence");
            return;
        }
        String sequence = args[0];
        
        String[] words = sequence.split(",");
    
        Map<String, Integer> wordsCount = new HashMap<>(words.length);
        
        for (String word : words) {
            String wordProcessed = word.replace(".", "").toLowerCase();
            int count = wordsCount.getOrDefault(wordProcessed, 0);
            wordsCount.put(wordProcessed, count+1);
        }
        
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            System.out.println("Word: " + entry.getKey() + ", number of entries = " + entry.getValue());
        }
    }
}
