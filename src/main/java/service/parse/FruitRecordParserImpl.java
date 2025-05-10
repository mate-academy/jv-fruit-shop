package service.parse;

import java.util.ArrayList;
import java.util.List;
import model.FruitRecord;

public class FruitRecordParserImpl implements FruitRecordParser {
    private static final String SEPARATOR = ",";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int EXPECTED_LENGTH = 3;

    @Override
    public List<FruitRecord> parseFruitRecords(String[] lines) {
        List<FruitRecord> object = new ArrayList<>();
        for (int i = ONE; i < lines.length; i++) {
            String line = lines[i];
            String[] split = line.split(SEPARATOR);
            if (split.length != EXPECTED_LENGTH) {
                throw new IllegalArgumentException("Invalid line format: " + line);
            }
            FruitRecord.Operation operation = FruitRecord.Operation
                    .valueOfOperation(split[ZERO].trim().toUpperCase());
            String fruit = split[ONE].trim();
            int quantity;
            quantity = Integer.parseInt(split[TWO]);

            FruitRecord record = new FruitRecord(operation, fruit, quantity);
            object.add(record);
        }
        return object;
    }
}
