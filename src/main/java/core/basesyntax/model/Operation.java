package core.basesyntax.model;

public class Operation {
    private String type;
    private String fruit;
    private int quantity;

    public Operation(String type, String fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum TypeOperation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String typeInFile;

        TypeOperation(String typeInFile) {
            this.typeInFile = typeInFile;
        }

        public String getType() {
            return typeInFile;
        }
    }
}
