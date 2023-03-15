package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.Parser;

public class CsvFileParserImpl implements Parser {
    private static final int INDEX_TITLE = 0;
    private static final String SEPARATOR = ",";
    private static final int INDEX_CODE = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        dataFromFile.remove(INDEX_TITLE);
        List<FruitTransaction> result = new ArrayList<>();
        for (String line : dataFromFile) {
            String[] info = line.split(SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction(
                    FruitTransaction.Operation.getByCode(info[INDEX_CODE]),
                    info[INDEX_FRUIT],
                    Integer.parseInt(info[INDEX_QUANTITY])
            );
            result.add(fruitTransaction);
        }
        return result;
    }
}
