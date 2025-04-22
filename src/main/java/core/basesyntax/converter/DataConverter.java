package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransactionsList(List<String> input);

    FruitTransaction convertToTransaction(String input);
}
