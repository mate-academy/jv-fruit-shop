package core.basesyntax.model;

public class FruitTransaction {
    private String fruitType;
    private Operation operation;
    private int amount;

    public FruitTransaction(FruitTransactionBuilder fruitTransactionBuilder) {
        this.fruitType = fruitTransactionBuilder.fruitType;
        this.operation = fruitTransactionBuilder.operation;
        this.amount = fruitTransactionBuilder.amount;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public static class FruitTransactionBuilder {
        private String fruitType;
        private Operation operation;
        private int amount;

        public FruitTransactionBuilder setFruitType(String fruitType) {
            this.fruitType = fruitType;
            return this;
        }

        public FruitTransactionBuilder setOperation(Operation operation) {
            this.operation = operation;
            return this;
        }

        public FruitTransactionBuilder setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public FruitTransaction build() {
            return new FruitTransaction(this);
        }
    }
}
