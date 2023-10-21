package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String fruitName;
    private int amount;

    public Operation getOperationByLetter(String letter) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getCodeOfOperation().equals(letter))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There is no such operation by letter "
                        + "'" + letter + "'"));
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruit) {
        this.fruitName = fruit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

        public String getCodeOfOperation() {
            return code;
        }
    }
}
