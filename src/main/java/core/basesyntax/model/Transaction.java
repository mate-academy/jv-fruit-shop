package core.basesyntax.model;

import java.util.Arrays;

public class Transaction {
    private Operation typeOperation;
    private String descriptionOfGoods;
    private int quantity;

    public Transaction(Operation typeOperation, String descriptionOfGoods, int quantity) {
        this.typeOperation = typeOperation;
        this.descriptionOfGoods = descriptionOfGoods;
        this.quantity = quantity;
    }

    public Operation getTypeOperation() {
        return typeOperation;
    }

    public String getDescriptionOfGoods() {
        return descriptionOfGoods;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setTypeOperation(Operation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public void setDescriptionOfGoods(String descriptionOfGoods) {
        this.descriptionOfGoods = descriptionOfGoods;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String typeOperation;

        Operation(String typeOperation) {
            this.typeOperation = typeOperation;
        }

        public String getTypeOperation() {
            return typeOperation;
        }
    }

    public static Operation findOperationByName(String value) {
        return Arrays.stream(Operation.values())
                .filter(typeOperation -> typeOperation.getTypeOperation().equals(value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Illegal operation " + value));
    }
}
