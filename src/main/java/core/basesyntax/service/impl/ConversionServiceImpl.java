package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConversionService;
import java.util.ArrayList;
import java.util.List;

public class ConversionServiceImpl implements ConversionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> convert(List<String[]> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String [] transaction : data) {
            fruitTransactions.add(new FruitTransaction(FruitTransaction
                    .getOperationByCode(transaction[OPERATION_INDEX]),
                    transaction[FRUIT_INDEX],
                    Integer.parseInt(transaction[AMOUNT_INDEX])));
        }
        return fruitTransactions;
    }
}
