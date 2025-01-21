package core.basesyntax.services;

import core.basesyntax.models.Product;
import java.util.List;

public interface ShopService {
    void process(List<Product> products);

    String getReport();
}
