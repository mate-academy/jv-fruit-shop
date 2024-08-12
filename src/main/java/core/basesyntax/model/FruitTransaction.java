package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruitName;
    private int transactionQuantity;

    public FruitTransaction(Operation operation, String fruitName, int transactionQuantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.transactionQuantity = transactionQuantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public Operation getOperation() {
        return operation;
    }

    public static Operation convertFromCode(String code) {
        Operation[] operations = Operation.values();
        for (Operation operation : operations) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Invalid operation code: " + code);
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(int transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setProduct(String product) {
        this.fruitName = product;
    }
}
