package core.basesyntax.model;

public class FruitTransaction {
    private FruitShopOperation fruitShopOperation;
    private String fruit;
    private int quantity;

    public FruitTransaction(FruitShopOperation fruitShopOperation, String fruit, int quantity) {
        this.fruitShopOperation = fruitShopOperation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitShopOperation getOperation() {
        return fruitShopOperation;
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
}
