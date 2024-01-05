package core.basesyntax.model;

public class FruitTransaction {
    private String name;
    private Operation type;
    private int amount;

    public FruitTransaction() {
    }

    public FruitTransaction(Operation type, String name, int amount) {
        this.type = type;
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Operation getType() {
        return type;
    }

    public void setType(Operation type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

        public static Operation getOperation(String operation) {
            for (Operation operation1 : Operation.values()) {
                if (operation1.getCode().equals(operation)) {
                    return operation1;
                }
            }
            throw new RuntimeException();
        }
    }
}
