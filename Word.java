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

    //Add a method to assign points based on the length of the word
    public int getPoints(String word) {
        int wordLength = word.length();
        int points = 0;

        switch(wordLength) {
            case 1:
                points = 1;
                break;
            case 2:
                points = 1;
                break;
            case 3:
                points = 2;
                break;
            case 4:
                points = 3;
                break;
        }
        
        return points;

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