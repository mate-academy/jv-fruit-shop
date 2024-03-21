package core.basesyntax.strategy;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.List;

public interface TransationProcessor {
    public void process(List<FruitTransactionDto> transactions);

}
