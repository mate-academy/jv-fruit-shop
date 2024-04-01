package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int HEADER_LINE_NUM = 1;
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        return data.stream()
                .skip(HEADER_LINE_NUM)
                .map(this::convertToFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction convertToFruitTransaction(String line) {
        String[] transaction = line.split(SPLITTER);
        return new FruitTransaction(FruitTransaction.Operation
                .getValue(transaction[OPERATION_POSITION]),
                transaction[FRUIT_POSITION],
                Integer.parseInt(transaction[QUANTITY_POSITION]));
    }
}
