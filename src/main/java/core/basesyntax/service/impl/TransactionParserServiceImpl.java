package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParserService;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final String DELIMITER = ",";
    private static final int TRANSACTION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;
    private static final int HEADER_LINE_INDEX = 0;

    @Override
    public List<FruitTransaction> parse(List<String> fileData) {
        fileData.remove(HEADER_LINE_INDEX);
        return fileData.stream()
                .map(s -> s.split(DELIMITER))
                .map(e -> new FruitTransaction(
                                FruitTransaction.Operation.fromString(e[TRANSACTION_TYPE_INDEX]),
                                new Fruit(e[FRUIT_NAME_INDEX]),
                                Integer.parseInt(e[FRUIT_AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }
}
