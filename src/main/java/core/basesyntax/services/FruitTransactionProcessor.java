package core.basesyntax.services;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.List;

public interface FruitTransactionProcessor {
    void conductActivities(List<FruitTransactionDto> dtos);
}
