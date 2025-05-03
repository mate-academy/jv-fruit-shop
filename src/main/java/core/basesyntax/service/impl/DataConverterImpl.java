package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int REPORT_ITEM_LENGTH = 3;
    private static final int HEADER_INDEX = 0;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        inputReport.remove(HEADER_INDEX);
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String currentString : inputReport) {
            String[] splittedReportItem = currentString.split(COMMA);
            if (splittedReportItem.length != REPORT_ITEM_LENGTH) {
                throw new RuntimeException("input string has invalid format: "
                        + currentString);
            }
            try {
                fruitTransactions
                        .add(new FruitTransaction(
                                FruitTransaction.Operation
                                        .getOperation(splittedReportItem[OPERATION_INDEX]),
                                splittedReportItem[FRUIT_INDEX],
                                Integer.parseInt(splittedReportItem[QUANTITY_INDEX])));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("input string has invalid format: "
                        + currentString);
            }
        }
        return fruitTransactions;
    }
}
