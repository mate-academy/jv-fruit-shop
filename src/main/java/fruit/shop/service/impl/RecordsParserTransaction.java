package fruit.shop.service.impl;

import fruit.shop.model.FruitTransaction;
import fruit.shop.service.RecordsParser;
import java.util.ArrayList;
import java.util.List;

public class RecordsParserTransaction implements RecordsParser {
    public static final String SEPARATOR = ",";
    public static final int FRUIT_INDEX = 1;
    public static final int OPTION_INDEX = 0;
    public static final int VALUE_INDEX = 2;

    @Override
    public List<FruitTransaction> parseRecords(List<String> records) {
        List<FruitTransaction> parsedRecords = new ArrayList<>();
        for (String record : records) {
            String[] array = record.split(SEPARATOR);
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(
                    FruitTransaction.Operation.getOptionRepresentation(array[OPTION_INDEX]));
            transaction.setFruit(array[FRUIT_INDEX]);
            transaction.setValue(Integer.parseInt(array[VALUE_INDEX]));
            parsedRecords.add(transaction);
        }
        return parsedRecords;
    }
}
