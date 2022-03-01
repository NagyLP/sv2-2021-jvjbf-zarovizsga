package sentences;

public class SentenceTransformer {

    public String shortenSentence(String sentence) {
        isValid(sentence);
        String[] words = sentence.split(" ");
        if (words.length < 5) {
            return sentence;
        } else {
            return words[0] + " ... " + words[words.length - 1];
        }
    }

    private void isValid(String sentence) {
        char charFirst = sentence.charAt(0);
        char charLast = sentence.charAt(sentence.length() - 1);

        if (charFirst < 'A' || charFirst > 'Z')
            throw new IllegalArgumentException("Must start with capital letter!");
        if (charLast != '.' && charLast != '!' && charLast != '?')
            throw new IllegalArgumentException("Must end with . ! or ?");

    }
}
