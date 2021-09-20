package core.basesyntax.model;

public class FruitRecord {
    private String operationType;
    private String fruitName;
    private Integer amount;

    public FruitRecord(String operationType, String fruitName, Integer amount) {
        this.operationType = operationType;
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruit) {
        this.fruitName = fruitName;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
