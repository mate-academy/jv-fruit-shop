package fruittransaction;

import java.util.Objects;

public class Products {
    private String type;
    private String fruit;
    private Integer quantity;

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
        Products products = (Products) o;
        return Objects.equals(type, products.type) && Objects.equals(fruit, products.fruit)
                && Objects.equals(quantity, products.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruit, quantity);
    }

    @Override
    public String toString() {
        return "ProductsFromFile{"
                + "type='" + type + '\''
                + ", fruit='" + fruit + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
