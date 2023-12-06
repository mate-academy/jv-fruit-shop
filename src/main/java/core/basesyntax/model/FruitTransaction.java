package core.basesyntax.model;

public record FruitTransaction(FruitTransaction.Operation operation, String fruit, int quantity) {

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
    }

    public static Operation getOperationByCode(String code) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equalsIgnoreCase(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("No operation found for code: " + code);
    }
}
