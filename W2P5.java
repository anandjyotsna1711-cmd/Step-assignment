import java.util.*;

public class W2P5 {

    static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        String cleaned = feedback.toLowerCase();

        cleaned = cleaned.replace(".", "");
        cleaned = cleaned.replace(",", "");
        String[] words = cleaned.split("\\s+");
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            boolean isStopWord = false;

            for (String stop : stopWords) {
                if (word.equals(stop)) {
                    isStopWord = true;
                    break;
                }
            }

            if (isStopWord) {
                continue;
            }

            frequency.put(
                word,
                frequency.getOrDefault(word, 0) + 1
            );
        }
        ArrayList<Map.Entry<String, Integer>> list =
            new ArrayList<>(frequency.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

      
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        String feedback =
            "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}