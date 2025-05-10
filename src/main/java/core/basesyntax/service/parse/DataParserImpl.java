package core.basesyntax.service.parse;

import core.basesyntax.model.FruitRecord;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {
    private static final int OPERATION_TYPE_POSITION = 0;
    private static final int FRUIT_NAME_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private static final String COMMA = ",";
    private static final int HEADER_INDEX = 0;

    @Override
    public List<FruitRecord> parseFruitRecords(List<String> lines) {
        List<FruitRecord> transactions = new ArrayList<>();
        lines.remove(HEADER_INDEX);

        for (String line: lines) {
            String[] parts = line.split(COMMA);

            String operationCode = parts[OPERATION_TYPE_POSITION];
            String fruit = parts[FRUIT_NAME_POSITION];
            int quantity = Integer.parseInt(parts[QUANTITY_POSITION]);

            FruitRecord.Operation operation = FruitRecord.Operation.fromCode(operationCode);
            transactions.add(new FruitRecord(operation, fruit, quantity));
        }
        return transactions;
    }
}
