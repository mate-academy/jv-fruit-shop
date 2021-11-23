package core.basesyntax.model;

public class ParsedLineFromFileCsv {
    private final String action;
    private final String fruitName;
    private final String number;

    public ParsedLineFromFileCsv(String action, String fruitName, String number) {
        this.action = action;
        this.fruitName = fruitName;
        this.number = number;
    }

    public String getAction() {
        return action;
    }

    public String getFruitName() {
        return fruitName;
    }

    public String getNumber() {
        return number;
    }
}
