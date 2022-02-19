package core.basesyntax.services.calculation;

import core.basesyntax.model.TransactionDto;
import java.util.List;
import java.util.Map;

public interface AmountCalculator {
    Map<String, Integer> calculateDataForReport(List<TransactionDto> transactionDtos);
}
