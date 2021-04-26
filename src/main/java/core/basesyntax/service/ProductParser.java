package core.basesyntax.service;

import core.basesyntax.model.ProductFactory;
import java.util.List;

public interface ProductParser {
    List<ProductFactory> parseProduct(List<String> records);
}