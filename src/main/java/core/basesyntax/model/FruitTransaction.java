package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitTransaction() {
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Operation {
      BALANCE("b"),
      SUPPLY("s"),
      PURCHASE("p"),
      RETURN("r");

        private String operationString;

        Operation(String operationString) {
            this.operationString = operationString;
        }

        public String getOperationString() {
            return operationString;
        }

        public static Operation get(String operationString) {
            for (Operation element: Operation.values()) {
                if (element.operationString.equals(operationString)) {
                    return element;
                }
            }
            return null;
        }
    }
}
