package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface FruitService {

    void applyTransactionsToDB(List<TransactionDto> transactionDtoList);

    String getReport();
}
