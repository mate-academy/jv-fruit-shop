package core.basesyntax.model;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
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
        private String code;
        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getOperation(String nameOperation) {
            return Stream.of(Operation.values())
                    .filter(name -> name.getCode().equals(nameOperation))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException(nameOperation));
        }
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation="
                + operation
                + ", fruit='"
                + fruit + '\''
                + ", quantity="
                + quantity + '}';
    }
}
