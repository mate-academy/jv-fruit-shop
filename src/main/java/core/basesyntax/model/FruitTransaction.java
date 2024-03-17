package core.basesyntax.model;

public class FruitTransaction {
    private Operation operationType;
    private String productType;
    private int amount;
    public FruitTransaction(){};

    public FruitTransaction(Operation operationType, String productType, int amount) {
        this.operationType = operationType;
        this.productType = productType;
        this.amount = amount;
    }

    public Operation getOperationType() {
        return operationType;
    }

    public void setOperationType(Operation operationType) {
        this.operationType = operationType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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

        public String getCode() {
            return code;
        }
    }
}
