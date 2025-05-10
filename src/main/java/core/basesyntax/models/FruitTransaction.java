package core.basesyntax.models;

import java.util.Arrays;
import java.util.Objects;

public class FruitTransaction {

    private TypeOfActivity type;
    private String name;
    private int quantity;

    private FruitTransaction(TypeOfActivity type, String name, int quantity) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
    }

    public static FruitTransaction of(TypeOfActivity type, String name, int quantity) {
        return new FruitTransaction(type, name, quantity);
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
        FruitTransaction fruitTransaction = (FruitTransaction) o;
        return fruitTransaction.quantity == quantity
                && type == fruitTransaction.type
                && Objects.equals(name, fruitTransaction.name);
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

        public static TypeOfActivity fromCode(String code) {
            return Arrays.stream(TypeOfActivity.values())
                    .filter(type -> type.getCode().equals(code))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Unknown type of activity: " + code));
        }

    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "type=" + type
                + ", name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
