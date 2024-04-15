package core.basesyntax.servise;

import java.util.List;

public interface DataProcessorService {
    void processingData(List<FruitTransaction> listOfTransactions);
}
