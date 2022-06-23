package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface StringListProcessor {
    List<Transaction> stringListToFruitIntegerMap(List<String> fileContent);
}
