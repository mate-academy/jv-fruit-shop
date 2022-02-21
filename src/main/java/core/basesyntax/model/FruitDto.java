package core.basesyntax.model;

public class FruitDto {
    private String fruitName;
    private String operationType;
    private int numberOfFruit;

    public FruitDto(String fruitName, String operationType, int numberOfFruit) {
        this.fruitName = fruitName;
        this.operationType = operationType;
        this.numberOfFruit = numberOfFruit;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public int getNumberOfFruit() {
        return numberOfFruit;
    }

    public void setNumberOfFruit(int numberOfFruit) {
        this.numberOfFruit = numberOfFruit;
    }
}
