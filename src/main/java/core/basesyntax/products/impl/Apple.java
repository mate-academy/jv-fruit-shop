package core.basesyntax.products.impl;

import core.basesyntax.constants.Product;
import core.basesyntax.products.Goods;

public class Apple implements Goods {
    private static final String NAME = "apple";
    private int amount;

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void addAmount(int amount) {
        this.amount += amount;
    }

    @Override
    public void subtractAmount(int amount) {
        this.amount -= amount;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Product getType() {
        return Product.APPLE;
    }
}
