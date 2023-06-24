package core.basesyntax.service.impl;

import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.TransactionService;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiseImpl implements TransactionService {
    private static final int INDEX_FRUIT_EMPTY = 0;
    private static final int INDEX_FRUIT_OPERATION_FIRST = 1;
    private static final int INDEX_FRUIT_OPERATION_SECOND = 2;

    @Override
    public List<FruitsTranslation> transactionProcess(List<String> transactionData) {
        return transactionData.stream()
                .skip(1)
                .map(this::processes)
                .collect(Collectors.toList());
    }

    private FruitsTranslation processes(String data) {
        String[] fruitsProcess = data.split(",");
        return new FruitsTranslation(
                Operation.getByCode(fruitsProcess[INDEX_FRUIT_EMPTY]),
                fruitsProcess[INDEX_FRUIT_OPERATION_FIRST],
                Integer.parseInt(fruitsProcess[INDEX_FRUIT_OPERATION_SECOND]));
    }
}
