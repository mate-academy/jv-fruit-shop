package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .skip(1)
                .map(this::transactionFromString)
                .toList();
    }

    private FruitTransaction transactionFromString(String record) {
        FruitTransaction transaction = new FruitTransaction();
        String[] columns = record.split(COMMA);
        transaction.setOperation(FruitTransaction.getOperationByCode(columns[TYPE]));
        transaction.setFruit(columns[FRUIT]);
        transaction.setQuantity(Integer.parseInt(columns[QUANTITY]));
        return transaction;
    }
}
