package core.basesyntax.dto;

import java.util.Objects;

public class FruitDto {
    private String operation;
    private String name;
    private int count;

    public FruitDto(String operation, String name, int count) {
        this.operation = operation;
        this.name = name;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
        return count == fruitDto.count && Objects.equals(operation, fruitDto.operation)
            && Objects.equals(name, fruitDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, name, count);
    }

    @Override
    public String toString() {
        return "FruitDto{" +
            "operation='" + operation + '\'' +
            ", name='" + name + '\'' +
            ", count=" + count +
            '}';
    }
}
