package core.basesyntax.model;

public record FruitTransaction(Operation operation, String fruit, int quantity) {

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        public static Operation findByCode(String code) {
            for (Operation operation : values()) {
                if (operation.code.equals(code)) {
                    return operation;
                }
            }
            throw new RuntimeException(" Wrong operation code from line: " + code);
        }

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}