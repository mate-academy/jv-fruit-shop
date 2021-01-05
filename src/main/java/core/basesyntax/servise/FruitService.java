package core.basesyntax.servise;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.List;
import java.util.Map;

public interface FruitService {
    void applyOperation(List<TransactionDto> transactionDtos);

    Map<Fruit, Integer> getFruitReport();
}
