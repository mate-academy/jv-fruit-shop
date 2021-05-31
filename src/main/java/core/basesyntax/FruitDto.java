package core.basesyntax;

public class FruitDto {
    private String type;
    private String fruit;
    private int quantity;

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
}
