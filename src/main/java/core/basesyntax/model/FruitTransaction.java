package core.basesyntax.model;

public class FruitTransaction {
    private String fruitName;
    private int amount;
    private Operation operation;

    public FruitTransaction(Operation operation, String name, int amount) {
        this.fruitName = name;
        this.amount = amount;
        this.operation = operation;
    }

    public String getName() {
        return fruitName;
    }

    public void setName(String name) {
        this.fruitName = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String letter;

        Operation(String letter) {
            this.letter = letter;
        }

        public String getOperation() {
            return letter;
        }
    }
}
