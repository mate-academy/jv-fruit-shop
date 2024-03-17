package core.basesyntax.model;

public class FruitTransaction {
    private Operation operationType;
    private String productName;
    private int amount;

    public FruitTransaction() {
    }

    ;

    public FruitTransaction(Operation operationType, String productType, int amount) {
        this.operationType = operationType;
        this.productName = productType;
        this.amount = amount;
    }

    public Operation getOperationType() {
        return operationType;
    }

    public void setOperationType(Operation operationType) {
        this.operationType = operationType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

        public static Operation fromCode(String code) {
            for (Operation operationType : Operation.values()) {
                if (operationType.getCode().equals(code)) {
                    return operationType;
                }
            }
            throw new IllegalArgumentException("Invalid Operation code: " + code);
        }

        public String getCode() {
            return code;
        }
    }
}
