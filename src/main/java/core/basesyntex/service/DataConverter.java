package core.basesyntex.service;

import core.basesyntex.model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> lines);
}
