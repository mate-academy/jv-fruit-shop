package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;

import java.util.List;

public interface ParseToList {
    List<TransactionDto> parseToTransactions(List<String> dataFromFile);
}
