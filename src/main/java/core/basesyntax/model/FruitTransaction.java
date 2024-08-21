package core.basesyntax.model;

import java.util.Arrays;
import java.util.Optional;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public void setOperation(String operation) {
        Optional<Operation> matchingOperation = Arrays.stream(Operation.values())
                .filter(val -> val.getCode().equals(operation))
                .findFirst();

        if (matchingOperation.isPresent()) {
            this.operation = matchingOperation.get();
        } else {
            throw new IllegalArgumentException("Invalid operation code: " + operation);
        }
    }

    public Operation getOperation() {
        return operation;
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
}
