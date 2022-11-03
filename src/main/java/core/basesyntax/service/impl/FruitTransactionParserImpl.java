package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int TYPE_OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> dataFromFile) {
        return dataFromFile.stream()
                .skip(1)
                .map(line -> line.split(","))
                .map(s ->
                        new FruitTransaction(FruitTransaction.Operation
                                .getOperation(s[TYPE_OPERATION_INDEX]),
                                s[FRUIT_NAME_INDEX],
                                Integer.parseInt(s[QUANTITY_INDEX])
                        )
                )
                .collect(Collectors.toList());
    }
}
