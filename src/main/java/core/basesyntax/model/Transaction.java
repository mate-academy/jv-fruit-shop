package core.basesyntax.model;

public class Transaction {
    private Operation operation;
    private Fruit fruit;
    private Integer quantity;

    public Transaction(String transactionString) {
        if (transactionString.equals("null")) {
            this.operation = null;
            this.fruit = null;
            this.quantity = null;
            return;
        }

        String[] splittedCsvLine = transactionString.split(",");
        this.operation = Operation.getOperationFromString(splittedCsvLine[0]);
        this.fruit = new Fruit(splittedCsvLine[1]);
        this.quantity = Integer.valueOf(splittedCsvLine[2]);
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
