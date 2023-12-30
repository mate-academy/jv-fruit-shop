package dao;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;

public class CsvDataParserImpl implements CsvDataParser {
    private static final int ROW_POSITION_AT_ZERO = 0;
    private static final int ROW_POSITION_AT_ONE = 1;
    private static final int ROW_POSITION_AT_TWO = 2;

    @Override
    public List<FruitTransaction> parseData(List<String[]> data) {
        List<FruitTransaction> parsedData = new ArrayList<>();
        for (String[] row : data) {
            Operation type = Operation.fromCode(row[ROW_POSITION_AT_ZERO]);
            String fruit = row[ROW_POSITION_AT_ONE];
            int quantity = Integer.parseInt(row[ROW_POSITION_AT_TWO]);
            parsedData.add(new FruitTransaction(type, fruit, quantity));
        }
        return parsedData;
    }
}
