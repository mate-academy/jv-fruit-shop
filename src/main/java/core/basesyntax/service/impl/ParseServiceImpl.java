package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;

import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    private static final int CSV_HEAD = 1;
    private static final String SEPARATOR = ",";
    private static final int TRANSACTION_LENGTH = 3;
    public static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    @Override
    public List<FruitTransaction> parse(List<String> strings) {
        if (strings != null && strings.size() > CSV_HEAD) {
            return strings.stream()
                    .skip(CSV_HEAD)
                    .map(s -> s.split(SEPARATOR))
                    .filter(l -> l.length == TRANSACTION_LENGTH)
                    .map(this::createFruitTransaction)
                    .toList();
        }
        return new ArrayList<>();   
    }

    private FruitTransaction createFruitTransaction(String[] line) {
        return new FruitTransaction(
                FruitTransaction.Operation.getOperationByCode(line[OPERATION_INDEX]),
                line[FRUIT_INDEX],
                Integer.parseInt(line[QUANTITY_INDEX])
        );
    }
}
