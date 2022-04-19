package model;

public class FruitTransaction {
    private String operation;
    private String fruitName;
    private Integer quantity;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object transaction) {
        if (this == transaction) {
            return true;
        }
        if (transaction == null) {
            return false;
        }
        if (transaction.getClass().equals(FruitTransaction.class)) {
            FruitTransaction current = (FruitTransaction) transaction;
            return this.operation.equals(current.operation)
                    && this.fruitName.equals(current.fruitName)
                    && this.quantity.equals(current.quantity);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (operation == null ? 0 : operation.hashCode());
        result = 31 * result + (fruitName == null ? 0 : fruitName.hashCode());
        result = 31 * result + quantity;
        return result;
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

        public String getSymbolOperation() {
            return operation;
        }
    }
}
