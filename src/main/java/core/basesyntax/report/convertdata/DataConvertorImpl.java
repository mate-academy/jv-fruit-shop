package core.basesyntax.report.convertdata;

import core.basesyntax.model.FruitOperation;
import java.util.ArrayList;
import java.util.List;

public class DataConvertorImpl implements DataConvertor {
    private static final String CSV_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int REPORT_START_POSITION = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitOperation> convertToTransaction(List<String> fruitInfoList) {
        List<FruitOperation> fruitTransactions = new ArrayList<>();
        for (int i = REPORT_START_POSITION; i < fruitInfoList.size(); i++) {
            String[] fruitInfo = fruitInfoList.get(i).split(CSV_SEPARATOR);
            if (fruitInfo.length != 3) {
                System.err.println("Skipping invalid line (wrong column count): "
                        + fruitInfoList.get(i));
                continue;
            }

            String fruitName = fruitInfo[FRUIT_NAME_INDEX];
            if (fruitName.isEmpty()) {
                System.err.println("Skipping line with empty fruit name: " + fruitInfoList.get(i));
                continue;
            }

            FruitOperation.Operation operation
                    = FruitOperation.Operation.getOperation(fruitInfo[OPERATION_INDEX]);
            if (operation == null) {
                System.err.println("Skipping line with invalid operation: " + fruitInfoList.get(i));
                continue;
            }

            int fruitQuantity = Integer.parseInt(fruitInfo[QUANTITY_INDEX]);
            if (fruitQuantity < 0) {
                System.err.println("Skipping line with negative quantity: " + fruitInfoList.get(i));
                continue;
            }

            fruitTransactions.add(new FruitOperation(operation, fruitName, fruitQuantity));
        }

        return fruitTransactions;
    }
}
