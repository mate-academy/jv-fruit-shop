package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String OPERATION_TYPE = "type";
    private static final String FRUIT_NAME = "fruit";
    private static final String FRUIT_QUANTITY = "quantity";
    private static final String HEADER_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        String[] headerString = inputReport.remove(0).toLowerCase().split(HEADER_SEPARATOR);
        int operationColIndex = 0;
        int fruitColIndex = 1;
        int qnttColIndex = 2;
        for (int i = 0; i < headerString.length; i++) {
            switch (headerString[i]) {
                case OPERATION_TYPE:
                    operationColIndex = i;
                    break;
                case FRUIT_NAME:
                    fruitColIndex = i;
                    break;
                case FRUIT_QUANTITY:
                    qnttColIndex = i;
                    break;
                default:
                    throw new RuntimeException("There is undefined column in data!!!!"
                            + " Data processing stopped until it fixed!!!!");
            }
        }
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String row : inputReport) {
            String[] rowArray = row.split(HEADER_SEPARATOR);
            transactions.add(new FruitTransaction(FruitTransaction.Operation
                    .getOperation(rowArray[operationColIndex]),
                    rowArray[fruitColIndex],
                    Integer.parseInt(rowArray[qnttColIndex])));
        }
        return transactions;
    }
}
