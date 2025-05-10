package core.basesyntax.services;

import core.basesyntax.models.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> data);
}
