package sentences;

public class SentenceTransformer {

    public final String ENDS = ".!?";

    public String shortenSentence(String sentence) {
        isValidSentence(sentence);
        String[] temp = sentence.split(" ");
        if (temp.length > 4) {
            return new StringBuilder(temp[0]).append(" ... ").append(temp[temp.length - 1]).toString();
        }
        return sentence;
    }

    //        isValid(sentence);
//        String[] words = sentence.split(" ");
//        if (words.length < 5) {
//            return sentence;
//        } else {
//            return words[0] + " ... " + words[words.length - 1];
//        }
//    }

//    private void isValid(String sentence) {
    //        char charFirst = sentence.charAt(0);
//        char charLast = sentence.charAt(sentence.length() - 1);
//
//        if (charFirst < 'A' || charFirst > 'Z')
//            throw new IllegalArgumentException("Must start with capital letter!");
//        if (charLast != '.' && charLast != '!' && charLast != '?')
//            throw new IllegalArgumentException("Must end with . ! or ?");
//}

    private boolean isValidSentence(String sentence) {
        return isValidStarting(sentence) && isValidEnding(sentence);
    }

    private boolean isValidStarting(String sentence) {
        if (sentence.charAt(0) != sentence.toUpperCase().charAt(0)) {
            return true;
        } else {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
    }

    private boolean isValidEnding(String sentence) {
        if (ENDS.contains("" + sentence.charAt(0))) {
            return true;
        } else {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
    }
}