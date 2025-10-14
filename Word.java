public class Word implements Comparable<Word> {
    private String word;
    private String definition;

    public Word() {
        word = "null";
        definition = "none";
    }

    public Word(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    //Getters and setters
    public void setWord(String word) {
        this.word = word;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    //Overriding toString
    @Override
    public String toString() {
        return word + ": " + definition;
    }

    @Override
    public int compareTo(Word other) {
        return this.word.compareTo(other.word);
    }

}