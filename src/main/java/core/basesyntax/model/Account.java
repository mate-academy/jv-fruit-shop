package core.basesyntax.model;

public class Account {

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");
        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getOperation(String code) {
            for (Operation value : Operation.values()) {
                if (value.getCode().equals(code)) {
                    return value;
                }
            }
            throw new IllegalArgumentException(code + " operation doesn't exist.");
        }
    }
}
