package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private Fruit fruit;

    public FruitTransaction(Operation operation, Fruit fruit) {
        this.operation = operation;
        this.fruit = fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
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

        if (operation != that.operation) {
            return false;
        }
        return fruit != null ? fruit.equals(that.fruit) : that.fruit == null;
    }

    @Override
    public int hashCode() {
        int result = operation != null ? operation.hashCode() : 0;
        result = 31 * result + (fruit != null ? fruit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation='" + operation + '\''
                + ", fruit=" + fruit
                + '}';
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public Operation getOperationFromString(String stringOperation) {
            for (Operation operation : Operation.values()) {
                if (stringOperation.equals(operation.getOperation())) {
                    return operation;
                }
            }
            throw new RuntimeException("Can`t operation" + stringOperation);
        }
    }
}
