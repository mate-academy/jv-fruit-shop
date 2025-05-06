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
                throw new IllegalArgumentException(
                        "Invalid line (wrong column count) at line " + i
                                + ": " + fruitInfoList.get(i)
                );
            }

            String fruitName = fruitInfo[FRUIT_NAME_INDEX];
            if (fruitName.isEmpty()) {
                throw new IllegalArgumentException(
                        "Invalid line: empty fruit name at line " + i + ": " + fruitInfoList.get(i)
                );
            }

            FruitOperation.Operation operation = FruitOperation.Operation
                    .getOperation(fruitInfo[OPERATION_INDEX]);
            if (operation == null) {
                throw new IllegalArgumentException(
                        "Invalid line: unknown operation at line " + i + ": " + fruitInfoList.get(i)
                );
            }

            int fruitQuantity = Integer.parseInt(fruitInfo[QUANTITY_INDEX]);
            if (fruitQuantity < 0) {
                throw new IllegalArgumentException(
                        "Invalid line: negative quantity at line " + i + ": " + fruitInfoList.get(i)
                );
            }

            fruitTransactions.add(new FruitOperation(operation, fruitName, fruitQuantity));
        }

        return fruitTransactions;
    }
}
