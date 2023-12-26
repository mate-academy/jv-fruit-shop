package core.basesyntax.products;

import core.basesyntax.constants.Products;
import core.basesyntax.products.impl.Apple;
import core.basesyntax.products.impl.Banana;
import java.util.Collections;
import java.util.Map;

public interface Product {
    public static final Map<Products, Product> productsMap = Collections.unmodifiableMap(
            Map.of(Products.APPLE, new Apple(), Products.BANANA, new Banana()));

    public void addAmount(int amount);

    public void subtractAmount(int amount);

    public int getAmount();

    public void setAmount(int amount);

    public String getName();

    public Products getType();
}
