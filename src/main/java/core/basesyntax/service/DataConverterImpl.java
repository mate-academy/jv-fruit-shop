package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .skip(1)
                .map(this::transactionFromString)
                .toList();
    }

    private FruitTransaction transactionFromString(String record) {
        FruitTransaction transaction = new FruitTransaction();
        String[] columns = record.split(",");
        transaction.setOperation(transaction.getOperationByCode(columns[0]));
        transaction.setFruit(columns[1]);
        transaction.setQuantity(Integer.parseInt(columns[2]));
        return transaction;
    }
}
