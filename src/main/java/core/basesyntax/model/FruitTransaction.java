package core.basesyntax.model;

import java.util.Arrays;

public record FruitTransaction(
        Operation operation,
        String fruit,
        int quantity
) {
    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");


        private String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation getByCode(String code) {
            return Arrays.stream(Operation.values())
                    .filter(operation -> operation.getCode().equals(code))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Can't fide operation by code: " + code));
        }

        public String getCode() {
            return code;
        }
    }
}
