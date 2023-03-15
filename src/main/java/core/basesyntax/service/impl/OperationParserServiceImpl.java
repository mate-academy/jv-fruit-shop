package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationParserService;
import java.util.List;
import java.util.stream.Collectors;

public class OperationParserServiceImpl implements OperationParserService {
    private static final int HEADER = 1;
    private static final String SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parseOperation(List<String> data) {
        return data.stream()
                .skip(HEADER)
                .map(i -> i.split(SPLITTER))
                .map(i -> new FruitTransaction(getTransaction(i[OPERATION_INDEX]),
                        i[FRUIT_INDEX], Integer.parseInt(i[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getTransaction(String code) {
        return FruitTransaction.Operation.getOperation(code);
    }
}
