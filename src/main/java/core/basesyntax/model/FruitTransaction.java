package core.basesyntax.model;

public class FruitTransaction {
    private String fruit;
    private int quantity;
    private boolean wasBought;

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

    public boolean wasBought() {
        return wasBought;
    }

    public void setBoughtStatus(boolean wasBought) {
        this.wasBought = wasBought;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
