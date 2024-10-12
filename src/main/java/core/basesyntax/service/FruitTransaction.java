package core.basesyntax.service;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int amount;

    enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;
        public String getCode() {
            return code;
        }
        Operation(String code) {
            this.code = code;
        }

        public static Operation operationFromCode(String code) {

        }
    }
}
