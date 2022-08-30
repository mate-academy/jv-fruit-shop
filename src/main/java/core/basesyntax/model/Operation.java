package core.basesyntax.model;

public class Operation {
    private OperationType operationType;
    private String fruit;
    private int amount;

    public Operation(OperationType operationType, String fruit, int amount) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.amount = amount;
    }

    public enum OperationType {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String abbreviation;

        OperationType(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public static OperationType getOperationTypeByAbbreviation(String abbreviation) {
            for (OperationType type : values()) {
                if (type.abbreviation.equals(abbreviation)){
                    return type;
                }
            }
            throw new RuntimeException("Operation type: "
                    + abbreviation
                    + " not exist!");
        }
    }
}
