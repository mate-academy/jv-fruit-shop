package core.basesyntax.model;

import java.util.Arrays;
import java.util.Objects;

public class FruitTransaction {
    private String nameOfFruit;
    private int quantity;
    private Operation operation;

    public FruitTransaction(String nameOfFruit, int quantity, Operation typeOfOperation) {
        this.nameOfFruit = nameOfFruit;
        this.quantity = quantity;
        this.operation = typeOfOperation;
    }

    public String getNameOfFruit() {
        return nameOfFruit;
    }

    public void setNameOfFruit(String nameOfFruit) {
        this.nameOfFruit = nameOfFruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction fruit = (FruitTransaction) o;
        return quantity == fruit.quantity
                && Objects.equals(nameOfFruit, fruit.nameOfFruit)
                && operation == fruit.operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfFruit, quantity, operation);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "nameOfFruit='" + nameOfFruit + '\''
                + ", quantity=" + quantity
                + ", typeOfOperation=" + operation
                + '}';
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }

    public static Operation getOperationBySymbol(String symbol) {
        return Arrays.stream(Operation.values())
                .filter(v -> v.getOperation().equals(symbol))
                .findFirst()
                .get();
    }
}
