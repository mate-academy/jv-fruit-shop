package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParserService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FruitTransactionParserServiceImpl implements FruitTransactionParserService {
    private static final String SEPARATOR = ",";
    private static final int SKIPPED_LINE_INDEX = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseToFruitTransaction(List<String> dataFromFile) {
        return dataFromFile.stream()
                .skip(SKIPPED_LINE_INDEX)
                .map(s -> s.split(SEPARATOR))
                .map(a -> new FruitTransaction(getOperation(a[OPERATION_INDEX]),
                        a[FRUIT_INDEX], Integer.parseInt(a[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getOperation(String operationCode) {
        Optional<FruitTransaction.Operation> optionalOperation = Arrays
                .stream(FruitTransaction.Operation.values())
                .filter(o -> o.getCode().equals(operationCode))
                .findFirst();
        if (optionalOperation.isPresent()) {
            return optionalOperation.get();
        }
        throw new RuntimeException("Illegal operation " + operationCode);
    }
}
