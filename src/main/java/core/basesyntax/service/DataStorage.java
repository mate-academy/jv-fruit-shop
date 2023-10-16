package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataStorage {
    List<FruitTransaction> convertText(List<String> strings);
}
