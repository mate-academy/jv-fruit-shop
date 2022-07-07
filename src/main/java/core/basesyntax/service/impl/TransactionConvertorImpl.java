package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionConvertor;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionConvertorImpl implements TransactionConvertor {
    private static final int LETTER = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> getFruitTransactions(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(line -> line.split(","))
                .map(splittedLine ->
                        new FruitTransaction(FruitTransaction.Operation.BALANCE
                                .getOperation(splittedLine[LETTER]),
                                splittedLine[FRUIT],
                                Integer.parseInt(splittedLine[QUANTITY])
                        )
                )
                .collect(Collectors.toList());
    }
}
