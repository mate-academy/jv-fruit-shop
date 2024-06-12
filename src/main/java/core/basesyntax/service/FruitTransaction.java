package core.basesyntax.service;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public FruitTransaction setOperation(Operation operation) {
        this.operation = operation;
        return this;
    }

    public String getFruit() {
        return fruit;
    }

    public FruitTransaction setFruit(String fruit) {
        this.fruit = fruit;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public FruitTransaction setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
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

        public static Operation fromCode(String operation) {
            String trim = operation.trim();
            for (Operation o : Operation.values()) {
                if (o.getCode().equals(trim)) {
                    return o;
                }
            }
            throw new CantWorkWithThisFileException("We dont have this operation");
        }
    }
}
