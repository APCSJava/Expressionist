package collins.kent.tutor.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/***
 * Singleton instance used as a source of words and phrases.
 *
 * @author k. collins
 *
 */

public final class StringSource {

    private static StringSource instance;
    List<String> words = Arrays.asList(new String[]{
            "ASL", "BBC", "cat", "dog", "cow", "ant",
            "game", "song", "play", "xbox", "Zoom", "ABBA",
            "chill", "jolly", "quick", "smart", "viola", "cello", "flute", "brass", "music",
            "joyous", "candid", "honest",
            "playful", "creative"});
    List<String> phrases = Arrays
            .asList(new String[]{"Love's Labours Lost",
                    "Hello, World!", "Let's go.", "Just do it!"});

    private StringSource() {
    }

    public static StringSource getInstance() {
        if (instance == null) {
            instance = new StringSource();
        }
        return instance;
    }

    public List<String> getWords() {
        return new ArrayList<>(words);
    }

    public List<String> getPhrases() {
        return phrases;
    }

    String getRandomWord(Random random) {
        return words.get(random.nextInt(words.size()));
    }

    String getRandomWord(Random random, int minLength,
                         int maxLength) {
        List<String> collect = words.stream()
                .filter(s -> s.length() > minLength
                        && s.length() <= maxLength)
                .collect(Collectors.toList());
        return collect.get(random.nextInt(collect.size()));
    }

    int map(double d, int range) {
        return (int) (d * range);
    }

}
