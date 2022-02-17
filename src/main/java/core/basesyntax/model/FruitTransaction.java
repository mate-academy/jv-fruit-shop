package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruitType;
    private int amount;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Operation getOperationType(String operation) {
        if (operation.equals("b")) {
            return Operation.BALANCE;
        } else if (operation.equals("s")) {
            return Operation.SUPPLY;
        } else if (operation.equals("p")) {
            return Operation.PURCHASE;
        } else if (operation.equals("r")) {
            return Operation.RETURN;
        } else {
            throw new RuntimeException("Invalid operation " + operation);
        }
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
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
              + "operation=" + operation
              + ", fruitType='" + fruitType + '\''
              + ", amount=" + amount
              + '}';
    }
}
