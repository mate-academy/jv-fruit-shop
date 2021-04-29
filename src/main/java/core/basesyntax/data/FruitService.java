package core.basesyntax.data;

import core.basesyntax.dto.TransactionDto;
import java.util.List;

public interface FruitService {
    void applyOperationsOnFruitsDto(List<TransactionDto> transactionDtos);

    String generateReport();
}

