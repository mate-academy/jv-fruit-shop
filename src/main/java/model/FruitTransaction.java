package model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String command;

        Operation(String command) {
            this.command = command;
        }

        public String getCommand() {
            return command;
        }

        public static Operation getOperationByCommand(String command) {
            for (Operation operation : Operation.values()) {
                if (command.equals(operation.getCommand())) {
                    return operation;
                }
            }
            throw new RuntimeException("No found operations by such command");
        }
    }
}

