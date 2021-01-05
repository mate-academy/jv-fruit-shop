package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;

public interface ParseTransactionDto {
    TransactionDto parseDateFromFile(String[] transaction);
}
