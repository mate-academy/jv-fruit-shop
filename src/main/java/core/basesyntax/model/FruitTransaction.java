package core.basesyntax.model;

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
    public String toString() {
        return "FruitTransaction{"
                + "operationType=" + operationType
                + ", fruitName='" + fruitName + '\''
                + ", fruitQuantity=" + fruitQuantity + '}';
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
