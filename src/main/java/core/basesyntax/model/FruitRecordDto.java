package core.basesyntax.model;

import java.util.Objects;

public class FruitRecordDto {
    private Type typeOfOperation;
    private Fruit fruit;
    private Integer amount;

    public FruitRecordDto() {
    }

    public FruitRecordDto(Type typeOfOperation, Fruit fruit, Integer amount) {
        this.typeOfOperation = typeOfOperation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Type getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(Type typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public enum Type {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String label;

        Type(String label) {
            this.label = label;
        }

        public static Type valueOfLabel(String label) {
            for (Type type : values()) {
                if (type.label.equals(label)) {
                    return type;
                }
            }
            throw new RuntimeException("Can't find type of operation " + label);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitRecordDto that = (FruitRecordDto) o;
        return typeOfOperation == that.typeOfOperation
                && Objects.equals(fruit, that.fruit)
                && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfOperation, fruit, amount);
    }
}
