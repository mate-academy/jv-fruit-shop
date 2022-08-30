package core.basesyntax.model;

public class Operation {
    private OperationType operationType;
    private String fruit;
    private int amount;

    public Operation() {
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

        public OperationType getOperationTypeByAbbreviation(String abbreviation) {
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
