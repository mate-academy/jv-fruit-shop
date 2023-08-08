package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParserService;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserServiceImpl implements TransactionParserService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_ABBREVIATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parseDataFromList(List<String> data) {
        return data.stream()
                .skip(1)
                .map(s -> s.split(SEPARATOR))
                .map(s -> new FruitTransaction(
                        FruitTransaction.Operation.getOperation(
                                s[OPERATION_ABBREVIATION_INDEX]),
                                s[FRUIT_NAME_INDEX],
                                Integer.parseInt(s[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }
}
