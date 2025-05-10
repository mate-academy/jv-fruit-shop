package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String REGEX_TO_SPLIT = ",";
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = 1; i < inputReport.size(); i++) {
            String[] partOfTransaction = inputReport.get(i).split(REGEX_TO_SPLIT);
            if (partOfTransaction.length != 3) {
                throw new RuntimeException("Illegal format of data : expected 3 parts , but was"
                        + partOfTransaction.length);
            }
            fruitTransactionList.add(new FruitTransaction(FruitTransaction.Operation
                    .getOperation(partOfTransaction[TYPE]),
                    partOfTransaction[FRUIT],
                    Integer.parseInt(partOfTransaction[QUANTITY])));
        }
        return fruitTransactionList;
    }
}
