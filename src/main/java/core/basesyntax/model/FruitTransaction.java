package core.basesyntax.model;

public class FruitTransaction {
    private int quantity;
    private Operation operation;
    private String fruit;

    public enum Operation {
        BALANCE("b"),
        EXPIRED("e"),
        PURCHASE("p"),
        RETURN("r"),
        SUPPLY("s");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
