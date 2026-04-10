package core.model;

public class Transaction {
    private Operation operation;
    private String type;
    private int quantity;

    public Transaction(Operation operation, String type, int quantity) {
        this.operation = operation;
        this.type = type;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");
        
        private String codeType;

        Operation(String codeType) {
            this.codeType = codeType;
        }

        public String getCodeType() {
            return codeType;
        }
        
        public static Operation getOperationByCode(String codeType) {
            for (Operation operation : Operation.values()) {
                if (operation.getCodeType().equals(codeType)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("No such operation: " + codeType);
        }
    }
}
