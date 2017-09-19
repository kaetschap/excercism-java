import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Scrabble {
    private String scrabbleInput;
    private int score;

    private static Map<String, Integer> scrabbleScoringRules;
    static {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("E", 1);
        map.put("I", 1);
        map.put("O", 1);
        map.put("U", 1);
        map.put("L", 1);
        map.put("N", 1);
        map.put("R", 1);
        map.put("S", 1);
        map.put("T", 1);
        map.put("D", 2);
        map.put("G", 2);
        map.put("B", 3);
        map.put("C", 3);
        map.put("M", 3);
        map.put("P", 3);
        map.put("F", 4);
        map.put("H", 4);
        map.put("V", 4);
        map.put("W", 4);
        map.put("Y", 4);
        map.put("K", 5);
        map.put("J", 8);
        map.put("X", 8);
        map.put("Q", 10);
        map.put("Z", 10);
        scrabbleScoringRules = Collections.unmodifiableMap(map);
    }

    Scrabble(String word) {
        this.scrabbleInput = word.toUpperCase();
        this.score = calculateScore(word.toUpperCase());
    }

    private int calculateScore(String scrabbleInput) {
        if(scrabbleInput.isEmpty()) {
            return 0;
        } else {
            return Arrays
                    .stream(scrabbleInput.split(""))
                    .mapToInt(this::retrieveScoreFromMap)
                    .reduce((a, b) -> a + b)
                    .getAsInt();
        }
    }

    public String getScrabbleInput() {
        return scrabbleInput;
    }

    public int getScore() {
        return score;
    }

    public static Map<String, Integer> getScrabbleScoringRules() {
        return scrabbleScoringRules;
    }

    public int retrieveScoreFromMap(String letter) {
        return this.getScrabbleScoringRules().get(letter);
    }
}
