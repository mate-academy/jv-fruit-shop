package core.basesyntax.model;

public class Transaction {
    private Operation operation;
    private Fruit fruit;
    private Integer amount;

    public Transaction(Operation operation,
                       Fruit fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction that = (Transaction) o;
        return amount == that.amount && operation == that.operation && fruit == that.fruit;
    }

    @Override
    public int hashCode() {
        int result = operation != null ? operation.hashCode() : 0;
        result = 31 * result + (fruit != null ? fruit.hashCode() : 0);
        result = 31 * result + amount;
        return result;
    }

    public int getAmount() {
        return amount;
    }
}
