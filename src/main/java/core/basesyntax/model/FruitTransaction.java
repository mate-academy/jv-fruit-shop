package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private String fruit;
    private Operation operation;
    private int amount;

    public FruitTransaction(String fruit, Operation operation, int amount) {
        this.fruit = fruit;
        this.operation = operation;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String name) {
        this.fruit = fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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

    @Override
    public int hashCode() {
        return Objects.hash(fruit, operation, amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FruitTransaction instance = (FruitTransaction) obj;
        return instance.amount == amount
                && Objects.equals(instance.operation, operation)
                && Objects.equals(instance.fruit, fruit);
    }
}
