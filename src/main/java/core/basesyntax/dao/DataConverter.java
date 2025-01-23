package core.basesyntax.dao;

import core.basesyntax.models.Product;
import java.util.List;

public interface DataConverter {
    List<Product> convertToTransaction(List<String> productsInString);
}
