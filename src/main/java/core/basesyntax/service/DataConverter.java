package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    java.util.List<FruitTransaction> convertToTransaction(List<String> lines);
}
