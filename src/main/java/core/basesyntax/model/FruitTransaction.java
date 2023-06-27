package core.basesyntax.model;

import core.basesyntax.exception.InvalidFruitTransactionOperationException;
import java.util.Arrays;

public class FruitTransaction implements Cloneable {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

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

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation ofCode(String code) {
            return Arrays.stream(Operation.values())
                    .filter(op -> op.code.equals(code))
                    .findAny()
                    .orElseThrow(() -> new InvalidFruitTransactionOperationException(
                            "Invalid code for FruitTransaction.Operation: " + code)
                    );
        }
    }

    @Override
    public FruitTransaction clone() {
        try {
            return (FruitTransaction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cannot clone FruitTransaction object", e);
        }
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "ftoperation=" + operation
                + ", fruit='" + fruit + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
