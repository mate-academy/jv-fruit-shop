package core.basesyntax.products.impl;

import core.basesyntax.constants.Products;
import core.basesyntax.products.Product;

public class Banana implements Product {
    private int amount = 0;

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
    public Products getType() {
        return Products.BANANA;
    }
}
