package core.basesyntax.service.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertFruitTransactions(List<String> listTransactionFromFile);
}
