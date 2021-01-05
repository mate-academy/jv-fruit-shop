package core.basesyntax.service.io;

import core.basesyntax.model.entities.Product;
import java.util.List;

public interface DataReader<T extends Product> {
    void validateFileExtension();

    List<String[]> readData();
}
