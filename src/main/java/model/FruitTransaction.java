package model;

public class FruitTransaction {
    private Operation operation;
    private Fruit fruit;
    private Integer amount;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(System.lineSeparator()).append(operation.operationAbbreviation)
                .append(",").append(fruit.getName()).append(",").append(amount).toString();
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operationAbbreviation;

        Operation(String operationAbbreviation) {
            this.operationAbbreviation = operationAbbreviation;
        }

        public static FruitTransaction.Operation getOperation(String value) {
            for (Operation operation : Operation.values()) {
                if (operation.operationAbbreviation.contains(value)) {
                    return operation;
                }
            }
            throw new RuntimeException("Operation not found with value: " + value);
        }
    }
}
