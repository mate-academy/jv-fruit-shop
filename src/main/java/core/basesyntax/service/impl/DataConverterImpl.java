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

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 0; i < inputReport.size(); i++) {
            String[] splittedReportItem = inputReport.get(i).split(COMMA);
            if (splittedReportItem.length != REPORT_ITEM_LENGTH) {
                throw new RuntimeException("Input string has invalid format");
            }
            try {
                fruitTransactions
                        .add(new FruitTransaction(
                                identifyOperation(splittedReportItem[OPERATION_INDEX]),
                                splittedReportItem[FRUIT_INDEX],
                                Integer.parseInt(splittedReportItem[QUANTITY_INDEX])));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Input string has invalid format");
            }
        }
        return fruitTransactions;
    }

    private FruitTransaction.Operation identifyOperation(String operationDesignation) {
        switch (operationDesignation) {
            case "b":
            case "B":
                return FruitTransaction.Operation.BALANCE;
            case "s":
            case "S":
                return FruitTransaction.Operation.SUPPLY;
            case "p":
            case "P":
                return FruitTransaction.Operation.PURCHASE;
            case "r":
            case "R":
                return FruitTransaction.Operation.RETURN;
            default:
                throw new RuntimeException("Invalid operation designation");
        }
    }
}
