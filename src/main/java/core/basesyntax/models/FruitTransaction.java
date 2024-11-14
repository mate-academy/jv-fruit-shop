package core.basesyntax.models;

public record FruitTransaction(
        FruitTransaction.Operation operation,
        String fruit,
        int quantity
) {
    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation fromCode(String code) {
            for (Operation op : Operation.values()) {
                if (op.code.equals(code)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Invalid code: " + code);
        }
    }
}
