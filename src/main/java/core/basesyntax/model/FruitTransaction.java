package core.basesyntax.model;

public class FruitTransaction {
    private OperationName name;
    private String nameOfObject;
    private int amount;

    public FruitTransaction(OperationName name, String nameOfObject, int amount) {
        this.name = name;
        this.nameOfObject = nameOfObject;
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getNameOfObject() {
        return this.nameOfObject;
    }

    public OperationName getName() {
        return this.name;
    }

}
