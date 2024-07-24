package core.basesyntax.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private FruitName name;
    private int quantity;

    public FruitTransaction(FruitName name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public FruitTransaction(Operation operation, FruitName name, int quantity) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public FruitName getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction fruitTransaction = (FruitTransaction) o;
        return quantity == fruitTransaction.quantity
                && operation == fruitTransaction.operation
                && Objects.equals(name, fruitTransaction.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, name, quantity);
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

        public static Operation getByCode(String code) {
            return Arrays.stream(Operation.values())
                    .filter(operation -> operation.code.equals(code))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Invalid code" + code));
        }
    }

    public enum FruitName {
        APPLE("apple"),
        BANANA("banana");

        private String name;

        FruitName(String name) {
            this.name = name;
        }

        public static FruitName getByFruitName(String name) {
            return Arrays.stream(FruitName.values())
                    .filter(fruitName -> fruitName.name.equals(name))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Invalid fruit name: " + name));
        }
    }
}
