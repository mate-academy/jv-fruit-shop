package model;

public class FruitTransaction {
    private String operationCharacter;
    private String fruit;
    private int quantity;

    public FruitTransaction(String operationCharacter, String fruit, int quantity) {
        this.operationCharacter = operationCharacter;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getOperationCharacter() {
        return operationCharacter;
    }

    public void setOperationCharacter(String operationCharacter) {
        this.operationCharacter = operationCharacter;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
