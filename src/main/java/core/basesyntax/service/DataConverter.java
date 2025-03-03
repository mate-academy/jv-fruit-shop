package core.basesyntax.service;

import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransactions(List<String> inputReport);
}
