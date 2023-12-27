package core.basesyntax.products.impl;

import core.basesyntax.constants.Product;
import core.basesyntax.products.Goods;

public class Banana implements Goods {
    private int amount;

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
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String getName() {
        return "banana";
    }

    @Override
    public Product getType() {
        return Product.BANANA;
    }
}
