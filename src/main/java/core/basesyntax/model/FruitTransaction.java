package core.basesyntax.model;

import java.math.BigDecimal;
import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruitName;
    private BigDecimal quantity;

    public FruitTransaction() {
    }

    public FruitTransaction(Operation operation, String fruitName, BigDecimal quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
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

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation=" + operation
                + ", fruitName='" + fruitName + '\''
                + ", quantity=" + quantity
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction that = (FruitTransaction) o;
        return operation == that.operation
               && Objects.equals(fruitName, that.fruitName)
               && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruitName, quantity);
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
            switch (code) {
                case "b":
                    return BALANCE;
                case "s":
                    return SUPPLY;
                case "p":
                    return PURCHASE;
                default:
                    return RETURN;
            }
        }
    }
}
