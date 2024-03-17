package core.basesyntax.model;

public class FruitTransaction {
    private final Operation operationType;
    private final String productType;
    private final int amount;

    public FruitTransaction(Operation operationType, String productType, int amount) {
        this.operationType = operationType;
        this.productType = productType;
        this.amount = amount;
    }

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
    }
}
