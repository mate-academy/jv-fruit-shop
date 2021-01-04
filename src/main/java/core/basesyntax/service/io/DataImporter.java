package core.basesyntax.service.io;

import core.basesyntax.model.entities.Product;

import java.util.List;

public interface DataImporter<T extends Product> {
    List<String[]> importData();
}
