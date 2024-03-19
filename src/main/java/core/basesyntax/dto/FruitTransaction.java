package core.basesyntax.dto;

import core.basesyntax.models.Fruit;

public record FruitTransaction(Operation operation, Fruit fruit, int quantity) {
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
            for (Operation operation : Operation.values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Unknown code: " + code);
        }

        public String getCode() {
            return code;
        }
    }
}
