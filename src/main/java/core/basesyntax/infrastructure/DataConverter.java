package core.basesyntax.infrastructure;

import core.basesyntax.service.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> inputReport);
}
