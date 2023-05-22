package core.basesyntax.strategy;

import core.basesyntax.model.Product;

public class FruitTransaction {
    private final Operation operation;
    private final Product fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, Product fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public Product getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FruitTransaction)) return false;
        FruitTransaction that = (FruitTransaction) o;
        return getQuantity() == that.getQuantity() && getOperation() == that.getOperation() && getFruit() == that.getFruit();
    }
}
