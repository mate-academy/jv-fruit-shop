package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

        public static Operation getByCode(Class<Operation> enumClass, String code) {
            for (Operation enumConstant : enumClass.getEnumConstants()) {
                if (enumConstant instanceof Operation) {
                    Operation operation = (Operation) enumConstant;
                    if (operation.getCode().equals(code)) {
                        return enumConstant;
                    }
                }
            }
            throw new RuntimeException("Invalid code: " + code);
        }
    }
}
