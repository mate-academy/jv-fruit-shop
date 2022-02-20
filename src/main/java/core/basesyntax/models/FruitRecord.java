package core.basesyntax.models;

public class FruitRecord {
    private char typeOfOperation;
    private String nameOfFruit;
    private int amount;

    public FruitRecord(char typeOfOperation, String nameOfFruit, int amount) {
        this.typeOfOperation = typeOfOperation;
        this.nameOfFruit = nameOfFruit;
        this.amount = amount;
    }

    public char getTypeOfOperation() {
        return typeOfOperation;
    }

    public int getAmount() {
        return amount;
    }

    public String getNameOfFruit() {
        return nameOfFruit;
    }

    public void setTypeOfOperation(char typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public void setNameOfFruit(String nameOfFruit) {
        this.nameOfFruit = nameOfFruit;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
