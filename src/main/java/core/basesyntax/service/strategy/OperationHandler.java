package core.basesyntax.service.strategy;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.HashMap;

public interface OperationHandler {
    HashMap<String, Integer> apply(FruitTransactionDto dto);

    boolean isApplicable(FruitTransactionDto dto);
}
