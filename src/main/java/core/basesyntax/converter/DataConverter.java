package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransactions(List<String> lines);
}
