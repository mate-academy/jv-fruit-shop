package core.basesyntax.service.reportservice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final long HEADER_ELEMENT = 1;
    private static final int MIN_SIZE = 2;
    private static final String DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        isInputValid(inputReport);
        return inputReport.stream()
                .skip(HEADER_ELEMENT)
                .map(this::getFromCsvRow)
                .toList();
    }

    private void isInputValid(List<String> inputReport) {
        if (inputReport.size() < MIN_SIZE) {
            throw new RuntimeException("Input file does not contain data: " + inputReport);
        }
        List<String> correctRows = inputReport.stream()
                .skip(HEADER_ELEMENT)
                .filter(r -> r.matches("^[a-z],[a-z]+,\\d+$"))
                .toList();
        if (correctRows.size() != inputReport.size() - HEADER_ELEMENT) {
            throw new RuntimeException("Input report contains wrong row(s)");
        }
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
