package core.basesyntax.service.model;

public class FruitTransaction {
    private final TypeOperation typeOperation;
    private final String fruit;
    private final Integer quantity;

    public FruitTransaction(TypeOperation typeOperation, String fruit, Integer quantity) {
        this.typeOperation = typeOperation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public String getFruit() {
        return fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public enum TypeOperation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String type;

        TypeOperation(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
