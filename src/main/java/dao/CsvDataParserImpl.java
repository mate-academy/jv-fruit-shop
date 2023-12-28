package dao;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;

public class CsvDataParserImpl implements CsvDataParser {
    private CsvDataReader csvDataReader;

    public CsvDataParserImpl(CsvDataReader csvDataReader) {
        this.csvDataReader = csvDataReader;
    }

    @Override
    public List<FruitTransaction> parseData(List<String[]> data) {
        List<FruitTransaction> parsedData = new ArrayList<>();
        for (String[] row : data) {
            Operation type = Operation.fromCode(row[0]);
            String fruit = row[1];
            int quantity = Integer.parseInt(row[2]);
            parsedData.add(new FruitTransaction(type, fruit, quantity));
        }
        return parsedData;
    }
}
