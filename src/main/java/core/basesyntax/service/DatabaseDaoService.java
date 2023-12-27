package core.basesyntax.service;

import core.basesyntax.constants.Product;
import core.basesyntax.products.Goods;
import java.util.List;

public interface DatabaseDaoService {
    public void put(Product product, Integer amount);

    public void reduceAmount(Product product, Integer amount);

    public void increaseAmount(Product product, Integer amount);

    public List<Goods> getAll();

    public Goods getProduct(Product product);
}
