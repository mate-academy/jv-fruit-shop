package core.basesyntax.service;

import core.basesyntax.model.AbstractTransaction;
import java.util.List;

public interface CsvReaderService<T> {
    List<AbstractTransaction<T>> parse(String filePath);
}
