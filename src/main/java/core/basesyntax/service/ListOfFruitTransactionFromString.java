package core.basesyntax.service;

import java.util.List;

public interface ListOfFruitTransactionFromString<T> {
    List<T> convert(String csvData);
}
