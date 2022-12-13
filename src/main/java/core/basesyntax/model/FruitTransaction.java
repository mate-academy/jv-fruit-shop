package core.basesyntax.model;

import java.util.Arrays;
import java.util.Optional;

public class FruitTransaction {
    private String fruit;
    private Operation operation;
    private int quantity;

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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
        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation getEnum(String fileOperation) {
            Optional<FruitTransaction.Operation> optionalOperation =
                    Arrays.stream(FruitTransaction.Operation.values())
                            .filter(o -> o.getOperation().equals(fileOperation))
                            .findFirst();
            return optionalOperation.orElseThrow(() -> new NullPointerException("No such action"));
        }
    }
}
