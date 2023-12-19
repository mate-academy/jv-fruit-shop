package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String fruitName;
    private int fruitQuantity;

    public FruitTransaction(Operation operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.fruitQuantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
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

        public static Operation getByCode(String code) {
            return Arrays.stream(FruitTransaction.Operation.values())
                    .filter(op -> op.getCode().equals(code))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown opcode: "
                            + code));
        }
    }
}
