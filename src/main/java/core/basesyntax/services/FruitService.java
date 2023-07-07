package core.basesyntax.services;

import core.basesyntax.dto.TransactionDto;
import java.util.List;

public interface FruitService {
    void applyOperation(List<TransactionDto> transactionDtos);

    String createReport();
}
