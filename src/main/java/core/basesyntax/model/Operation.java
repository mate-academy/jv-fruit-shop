package core.basesyntax.model;

import java.util.Objects;

public class Operation {

    private TypeOfOperation typeOfOperation;
    private String fruit;
    private Integer quantity;

    public TypeOfOperation getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(TypeOfOperation typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        return typeOfOperation == operation.typeOfOperation
                && Objects.equals(fruit, operation.fruit)
                && Objects.equals(quantity, operation.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfOperation, fruit, quantity);
    }

    @Override
    public String toString() {
        return fruit + "," + quantity;
    }
}
