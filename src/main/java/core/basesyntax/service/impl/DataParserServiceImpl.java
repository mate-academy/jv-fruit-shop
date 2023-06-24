package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserServiceImpl implements DataParserService {
    private static final String SPLIT_SYMBOL = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> getTransactions(String data) {
        return Arrays.stream(data.split(System.lineSeparator()))
                .skip(1)
                .map(this::lineToFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction lineToFruitTransaction(String transaction) {
        String[] split = transaction.split(SPLIT_SYMBOL);
        return new FruitTransaction
                .FruitTransactionBuilder()
                .setOperation(getOperationByLetter(split[OPERATION_INDEX]))
                .setFruitType(split[FRUIT_TYPE_INDEX])
                .setAmount(Integer.parseInt(split[AMOUNT_INDEX]))
                .build();
    }

    private Operation getOperationByLetter(String letter) {
        Operation[] values = Operation.values();
        for (Operation operation : values) {
            if (operation.getOperation().equals(letter)) {
                return operation;
            }
        }
        throw new RuntimeException("Can`t find operation " + letter);
    }
}
