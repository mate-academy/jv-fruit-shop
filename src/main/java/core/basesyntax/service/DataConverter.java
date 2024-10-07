package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    /**
     * Convert the incoming data into FruitTransactions list
     * @param inputData input data from file
     * @return FruitTransactions list
     */
    List<FruitTransaction> convertToTransaction(List<String> inputData);
}
