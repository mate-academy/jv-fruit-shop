package dao;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;

public class CsvDataParserImpl implements CsvDataParser {
    private static final int OPERATION_POSITION_ZERO = 0;
    private static final int OPERATION_POSITION_ONE = 1;
    private static final int OPERATION_POSITION_TWO = 2;

    @Override
    public List<FruitTransaction> parseData(List<String[]> data) {
        List<FruitTransaction> parsedData = new ArrayList<>();
        for (String[] row : data) {
            Operation type = Operation.fromCode(row[OPERATION_POSITION_ZERO]);
            String fruit = row[OPERATION_POSITION_ONE];
            int quantity = Integer.parseInt(row[OPERATION_POSITION_TWO]);
            parsedData.add(new FruitTransaction(type, fruit, quantity));
        }
        return parsedData;
    }
}
