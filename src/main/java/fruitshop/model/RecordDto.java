package fruitshop.model;

public class RecordDto {
    private OperationType operationType;
    private Fruit fruitType;
    private int amount;

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Fruit getFruitType() {
        return fruitType;
    }

    public void setFruitType(Fruit fruitType) {
        this.fruitType = fruitType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
