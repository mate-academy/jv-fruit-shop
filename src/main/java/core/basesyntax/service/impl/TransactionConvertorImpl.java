package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionConvertor;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionConvertorImpl implements TransactionConvertor {
    private static final int LETTER_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getFruitTransactions(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(line -> line.split(","))
                .map(splittedLine ->
                        new FruitTransaction(FruitTransaction.Operation.BALANCE
                                .getOperation(splittedLine[LETTER_INDEX]),
                                splittedLine[FRUIT_INDEX],
                                Integer.parseInt(splittedLine[QUANTITY_INDEX])
                        )
                )
                .collect(Collectors.toList());
    }
}
