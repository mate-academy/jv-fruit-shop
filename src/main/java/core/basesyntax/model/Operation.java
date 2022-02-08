package core.basesyntax.model;

import java.util.Objects;

public class Operation {
    private final String type;
    private final Fruit fruit;
    private final int quantity;

    public Operation(String type, Fruit fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operation operation = (Operation) o;
        return quantity == operation.quantity && Objects.equals(type, operation.type)
                && Objects.equals(fruit, operation.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruit, quantity);
    }

    public enum TypeOperation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String typeInFile;

        TypeOperation(String typeInFile) {
            this.typeInFile = typeInFile;
        }

        public String getType() {
            return typeInFile;
        }
    }
}
