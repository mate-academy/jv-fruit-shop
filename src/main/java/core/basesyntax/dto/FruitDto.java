package core.basesyntax.dto;

import java.util.Objects;

public class FruitDto {
    private String operation;
    private String name;
    private int quantity;

    public FruitDto(String operation, String name, int quantity) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
        FruitDto fruitDto = (FruitDto) o;
        return quantity == fruitDto.quantity && Objects.equals(operation, fruitDto.operation)
            && Objects.equals(name, fruitDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, name, quantity);
    }

    @Override
    public String toString() {
        return "FruitDto{"
            + "operation='" + operation + '\''
            + ", name='" + name + '\''
            + ", count=" + quantity + '}';
    }
}
