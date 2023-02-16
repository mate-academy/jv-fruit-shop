package model;

import java.util.NoSuchElementException;

public class FruitTransaction {
    private static final String BALANCE_SIGN = "b";
    private static final String SUPPLY_SIGN = "s";
    private static final String PURCHASE_SIGN = "p";
    private static final String RETURN_SIGN = "r";

    private Operation operation;
    private String fruit;
    private Integer amount;

    public FruitTransaction(String operationSign, String fruit, Integer amount) {
        this.operation = convertSignToOperation(operationSign);
        this.fruit = fruit;
        this.amount = amount;
    }

    public Operation getOperation () {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return operation.getCode() + ", " + fruit + ", " + amount;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    private Operation convertSignToOperation(String operationSign) {
        switch (operationSign) {
            case BALANCE_SIGN:
                return Operation.BALANCE;
            case SUPPLY_SIGN:
                return Operation.SUPPLY;
            case PURCHASE_SIGN:
                return Operation.PURCHASE;
            case RETURN_SIGN:
                return Operation.RETURN;
            default:
                throw new NoSuchElementException("There is no such operation.");
        }
    }
}
