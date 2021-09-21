package core.basesyntax.service.report;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.List;
import java.util.Map;

public interface FruitService {
    Map<Fruit, Integer> countFruitByOperation(List<TransactionDto> operations);
}
