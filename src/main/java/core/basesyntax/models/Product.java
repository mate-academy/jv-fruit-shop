package core.basesyntax.models;

import java.util.Objects;

public class Product {

    private TypeOfActivity type;
    private String name;
    private int quantity;

    private Product(TypeOfActivity type, String name, int quantity) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
    }

    public static Product of(TypeOfActivity type, String name, int quantity) {
        return new Product(type, name, quantity);
    }

    public TypeOfActivity getType() {
        return type;
    }

    public void setType(TypeOfActivity type) {
        this.type = type;
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
        Product product = (Product) o;
        return Double.compare(product.quantity, quantity) == 0
                && type == product.type
                && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, quantity);
    }

    public enum TypeOfActivity {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");
        private String code;
        TypeOfActivity(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    @Override
    public String toString() {
        return "Product{"
                + "type=" + type
                + ", name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
