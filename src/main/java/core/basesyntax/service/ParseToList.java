package core.basesyntax.service;

import core.basesyntax.model.dto.TransactionDto;
import java.util.List;

public interface ParseToList {
    List<TransactionDto> parseToTransactions(List<String> dataFromFile);
}
