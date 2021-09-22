package core.basesyntax.service.report;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface FruitService {
    void saveFruitByOperation(List<TransactionDto> operations);
}
