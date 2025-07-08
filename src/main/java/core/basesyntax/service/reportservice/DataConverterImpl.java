package core.basesyntax.service.reportservice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .map(this::getFromCsvRow)
                .toList();
    }

    private FruitTransaction getFromCsvRow(String record) {
        String[] fields = record.split(DELIMITER);
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(FruitTransaction.Operation
                .getOperationFromCode(fields[OPERATION_INDEX]));
        transaction.setFruit(fields[FRUIT_INDEX]);
        transaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
        return transaction;
    }
}
