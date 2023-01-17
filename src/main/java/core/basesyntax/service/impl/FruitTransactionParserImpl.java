package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperationValidator;
import core.basesyntax.service.FruitTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SEPARATOR = ",";
    private static final int HEADER_LINES_AMOUNT = 1;
    private static final FruitOperationValidator fruitOperationValidator;

    static {
        fruitOperationValidator = new FruitOperationValidatorImpl();
    }

    @Override
    public List<FruitTransaction> toTransactions(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        data.stream()
                .skip(HEADER_LINES_AMOUNT)
                .map(line -> line.trim().split(SEPARATOR)).forEach(tmp -> {
                    fruitOperationValidator.validate(tmp);
                    fruitTransactions.add(new FruitTransaction(FruitTransaction.Operation
                            .get(tmp[OPERATION_INDEX]), tmp[FRUIT_INDEX],
                            Integer.parseInt(tmp[AMOUNT_INDEX])));
                });
        return fruitTransactions;
    }
}
