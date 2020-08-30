package core.basesyntax.service;

import core.basesyntax.model.Product;
import java.util.List;

public interface ProductParser<T extends Product> {
    List<T> getProducts(String[] line);
}
