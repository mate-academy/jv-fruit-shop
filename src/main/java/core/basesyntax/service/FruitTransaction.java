package core.basesyntax.service;

public class FruitTransaction {
    private String code;
    private String fruit;
    private int quantity;

    public FruitTransaction(String operation, String fruit, int quantity) {
        this.code = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public enum Operation {
        BALANCE,
        SUPPLY,
        PURCHASE,
        RETURN;
    }

    public Operation getOperation() {
        return switch (code) {
            case "r" -> Operation.RETURN;
            case "s" -> Operation.SUPPLY;
            case "p" -> Operation.PURCHASE;
            case "b" -> Operation.BALANCE;
            default -> throw new RuntimeException("Invalid Transaction code");
        };
    }

}
