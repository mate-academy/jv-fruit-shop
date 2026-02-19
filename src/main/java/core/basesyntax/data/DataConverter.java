package core.basesyntax.data;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransactionsListFromLines(List<String> line);
}
