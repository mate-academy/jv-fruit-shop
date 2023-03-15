package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface TransactionParser {
    List<TransactionDto> parserTransactionOperation(List<String> line);
}
