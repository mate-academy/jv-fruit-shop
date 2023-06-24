package core.basesyntax.service.impl;

import static core.basesyntax.model.Operation.findOperationByFirstLetter;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int HEADER_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> toTransactions(List<String> fileData) {
        fileData.remove(HEADER_INDEX);
        return fileData.stream().map(s -> s.split(SPLITTER))
                .map(s -> new FruitTransaction(findOperationByFirstLetter(s[OPERATION_INDEX]),
                        s[FRUIT_INDEX],
                        Integer.parseInt(s[AMOUNT_INDEX]))
                )
                .collect(Collectors.toList());
    }
}
