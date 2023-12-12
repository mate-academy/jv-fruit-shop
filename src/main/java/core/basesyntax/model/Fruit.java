package core.basesyntax.model;

public class Fruit {
    private Operation typeOperation;
    private String typeFruit;
    private int quantity;

    public Operation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(Operation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public String getTypeFruit() {
        return typeFruit;
    }

    public void setTypeFruit(String typeFruit) {
        this.typeFruit = typeFruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FruitInfo{"
                + "typeOperation=" + typeOperation
                + ", typeFruit='" + typeFruit + '\''
                + ", quantity=" + quantity
                + '}';
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

        public static Fruit.Operation valueOfCode(String code) {
            for (Fruit.Operation operation : Fruit.Operation.values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
            throw new RuntimeException("Such an operation does not exist: " + code);
        }
    }
}
