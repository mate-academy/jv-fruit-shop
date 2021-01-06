package core.basesyntax.service;

import core.basesyntax.model.entities.Product;
import java.util.List;

public interface ProductService<T extends Product> {
    void importData(List<String[]> data);

    List<String[]> generateReport();
}
