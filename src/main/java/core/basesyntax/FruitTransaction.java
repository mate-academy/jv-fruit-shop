package core.basesyntax;

public record FruitTransaction(core.basesyntax.FruitTransaction
                                       .Operation operation, String fruit, int quantity) {

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

        public static Operation fromCode(String code) {
            for (Operation op : Operation.values()) {
                if (op.getCode().equals(code)) {
                    return op;
                }
            }
            throw new RuntimeException("Invalid operation code: " + code);
        }
    }
}
