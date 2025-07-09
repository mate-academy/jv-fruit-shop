package core.basesyntax.datemanipulation;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String operationCode, String fruit, int quantity) {
        switch (operationCode) {
            case "b": {
                operation = Operation.BALANCE;
                break;
            }
            case "s": {
                operation = Operation.SUPPLY;
                break;
            }
            case "p": {
                operation = Operation.PURCHASE;
                break;
            }
            case "r": {
                operation = Operation.RETURN;
                break;
            }
            default: {
                throw new IllegalArgumentException("Wrong type of input date");
            }
        }
        this.fruit = fruit;
        this.quantity = quantity;
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

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
