package model;

public class TransactionDto {
    private final String operation;
    private final String fruitName;
    private final int quantity;

    public TransactionDto(String operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String type;

        Operation(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
