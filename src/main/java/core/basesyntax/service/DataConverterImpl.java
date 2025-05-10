package core.basesyntax.service;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int MINIMUM_REPORT_LIST_SIZE = 2;

    @Override
    public List<FruitTransaction> convertToTransactions(List<String> inputReport) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        if (inputReport.size() < MINIMUM_REPORT_LIST_SIZE) {
            throw new RuntimeException("No Transactions in file");
        }
        for (int i = 1; i < inputReport.size(); i++) {
                String[] inputReportData = inputReport.get(i).split(",");
                FruitTransaction.Operation operation = FruitTransaction
                        .getOperation(inputReportData[OPERATION_INDEX]);
                fruitTransactionList.add(new FruitTransaction(operation,
                        inputReportData[NAME_INDEX],
                        Integer.valueOf(inputReportData[QUANTITY_INDEX])));
        }
        return fruitTransactionList;
    }
}
