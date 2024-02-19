package core.basesyntax.model;

public class FruitTransaction {
    private Operation type;
    private String name;
    private int amount;

    public FruitTransaction(Operation type, String name, int amount) {
        this.type = type;
        this.name = name;
        this.amount = amount;
    }

    public Operation getType() {
        return type;
    }

    public void setType(Operation type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String fruit) {
        this.name = name;
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

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getOperation(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.getCode().equalsIgnoreCase(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("No operation found for this code :" + code);
        }
    }
}
