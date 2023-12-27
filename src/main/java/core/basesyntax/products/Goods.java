package core.basesyntax.products;

import core.basesyntax.constants.Product;
import core.basesyntax.products.impl.Apple;
import core.basesyntax.products.impl.Banana;
import java.util.Collections;
import java.util.Map;

public interface Goods {
    public static final Map<Product, Goods> productsMap = Collections.unmodifiableMap(
            Map.of(Product.APPLE, new Apple(), Product.BANANA, new Banana()));

    public void addAmount(int amount);

    public void subtractAmount(int amount);

    public int getAmount();

    public void setAmount(int amount);

    public String getName();

    public Product getType();
}
