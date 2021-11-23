package core.basesyntax.model;

public class CsvLineDto {
    private final String operation;
    private final String fruitName;
    private final String number;

    public CsvLineDto(String operation, String fruitName, String number) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.number = number;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public String getNumber() {
        return number;
    }
}
