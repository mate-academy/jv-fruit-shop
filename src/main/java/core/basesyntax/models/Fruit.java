package core.basesyntax.models;

import java.util.Objects;

public class Fruit {

    private TypeOfActivity type;
    private String name;
    private int quantity;

    private Fruit(TypeOfActivity type, String name, int quantity) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
    }

    public static Fruit of(TypeOfActivity type, String name, int quantity) {
        return new Fruit(type, name, quantity);
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
        Fruit fruit = (Fruit) o;
        return fruit.quantity == quantity
                && type == fruit.type
                && Objects.equals(name, fruit.name);
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
        return "Fruit{"
                + "type=" + type
                + ", name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
