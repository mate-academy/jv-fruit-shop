package core.basesyntax.model;

public record FruitTransaction(Operation operation, String fruit, int quantity) {

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

        public static Operation getByOperationCode(String code) {
            for (Operation operation : values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Incorrect operation code: " + code);
        }
    }
}
