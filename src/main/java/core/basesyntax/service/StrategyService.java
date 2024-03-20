package core.basesyntax.service;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.List;

public interface StrategyService {
    void processData(List<FruitTransactionDto> fruitTransactionDtoList);
}
