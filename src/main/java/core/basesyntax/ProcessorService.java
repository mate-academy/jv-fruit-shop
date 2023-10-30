package core.basesyntax;

import java.util.List;

public interface ProcessorService {
    void processTransactions(List<FruitTransaction> transactions, FruitStorage storage);
}

