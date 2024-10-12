package core.basesyntax.service;

public class FruitTransaction {
    private Operation operation;

    enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;
        Operation(String code) {
            this.code = code;
        }

    }
}
