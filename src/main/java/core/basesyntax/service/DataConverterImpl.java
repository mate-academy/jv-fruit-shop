package core.basesyntax.service;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        if (inputReport.isEmpty()) {
            throw new RuntimeException("No Transactions in file");
        }
        if (inputReport.size() > 1) {
            for (int i = 1; i < inputReport.size(); i++) {
                String[] inputReportData = inputReport.get(i).split(",");
                FruitTransaction.Operation operation = FruitTransaction
                        .getOperation(inputReportData[OPERATION_INDEX]);
                fruitTransactionList.add(new FruitTransaction(operation,
                        inputReportData[NAME_INDEX],
                        Integer.valueOf(inputReportData[QUANTITY_INDEX])));
            }
        }
        return fruitTransactionList;
    }
}
