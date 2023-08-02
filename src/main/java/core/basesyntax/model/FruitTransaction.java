package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private final String fruitName;
    private final int fruitQuantity;
    private final Operation operationType;

    public FruitTransaction(FruitBuilder fruitBuilder) {
        this.fruitName = fruitBuilder.fruitName;
        this.fruitQuantity = fruitBuilder.fruitQuantity;
        this.operationType = fruitBuilder.operationType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
    }

    public Operation getOperationType() {
        return operationType;
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
        return Objects.equals(fruitName, that.fruitName)
                && Objects.equals(fruitQuantity, that.fruitQuantity)
                && operationType == that.operationType;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operationType=" + operationType
                + ", fruitName='" + fruitName + '\''
                + ", fruitQuantity=" + fruitQuantity + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName, fruitQuantity, operationType);
    }

    public static class FruitBuilder {
        private String fruitName;
        private int fruitQuantity;
        private Operation operationType;

        public FruitBuilder setFruitName(String fruitName) {
            this.fruitName = fruitName;
            return this;
        }

        public FruitBuilder setFruitQuantity(int fruitQuantity) {
            this.fruitQuantity = fruitQuantity;
            return this;
        }

        public FruitBuilder setOperationType(Operation operationType) {
            this.operationType = operationType;
            return this;
        }

        public FruitTransaction build() {
            return new FruitTransaction(this);
        }
    }
}
