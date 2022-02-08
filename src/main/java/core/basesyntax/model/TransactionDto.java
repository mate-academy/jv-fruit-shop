package core.basesyntax.model;

public class TransactionDto {
    private OperationTypes operation;
    private String fruit;
    private int amount;

    public TransactionDto(OperationTypes operation, String fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getFruit() {
        return fruit;
    }

    public OperationTypes getOperation() {
        return operation;
    }

    public enum OperationTypes {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String shortName;

        OperationTypes(String shortName) {
            this.shortName = shortName;
        }

        public static OperationTypes getType(String shortName) {
            for (OperationTypes value : values()) {
                if (value.shortName.equals(shortName)) {
                    return value;
                }
            }
            return null;
        }
    }
}
