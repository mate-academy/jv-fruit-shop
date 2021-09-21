package core.basesyntax.model;

import java.util.Objects;

public class FruitRecordDto {
    private Fruit fruitName;
    private int amount;
    private String operationType;

    public Fruit getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setFruit(Fruit fruit) {
        this.fruitName = fruit;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitRecordDto that = (FruitRecordDto) o;
        return amount == that.amount && Objects.equals(fruitName, that.fruitName)
                && operationType == that.operationType;
    }

    @Override
    public String toString() {
        return "FruitRecord{"
                + "fruit='" + fruitName + '\''
                + ", amount=" + amount
                + ", operationType=" + operationType
                + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName, amount, operationType);
    }

    public enum OperationType {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String type;

        OperationType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public static OperationType get(String operationType) {
            for (OperationType operation : values()) {
                if (operation.getType().equals(operationType)) {
                    return operation;
                }
            }
            return null;
        }
    }
}
