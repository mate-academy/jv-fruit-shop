package core.basesyntax.store.util.converter;

import core.basesyntax.store.model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> lines);
}
