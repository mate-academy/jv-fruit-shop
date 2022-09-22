package core.basesyntax.model;

import java.util.Objects;

public class FruitDto {
    private String type;
    private String fruit;
    private int quantity;

    public FruitDto(String type, String fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitDto() {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "FruitDto{"
                + "type='" + type + '\''
                + ", fruit='" + fruit + '\''
                + ", quantity='" + quantity + '\''
                + '}';
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
        return quantity == fruitDto.quantity
                && Objects.equals(type, fruitDto.type)
                && Objects.equals(fruit, fruitDto.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruit, quantity);
    }
}
