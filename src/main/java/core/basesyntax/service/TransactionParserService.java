package core.basesyntax.service;

import java.util.List;

public interface TransactionParserService<T,K> {
    List<T> parseDataFromList(List<K> data);
}
