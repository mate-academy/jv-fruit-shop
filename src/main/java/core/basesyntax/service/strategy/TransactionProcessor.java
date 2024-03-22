package core.basesyntax.service.strategy;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.List;

public interface TransactionProcessor {
    public void process(List<FruitTransactionDto> transactions);
}
