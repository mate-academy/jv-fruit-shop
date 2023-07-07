package mate.academy.service.impl;

import java.util.ArrayList;
import java.util.List;
import mate.academy.model.FruitTransaction;
import mate.academy.service.Parser;

public class ParserImpl implements Parser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_CODE_INDEX = 0;
    private static final int QUANTITY_INDEX = 2;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int OFFSET = 1;


    @Override
    public List<FruitTransaction> parseData(List<String> inputDataRows) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = OFFSET; i < inputDataRows.size(); i++) {
            String[] entryData = inputDataRows.get(i).split(SEPARATOR);
            String operationCode = entryData[OPERATION_CODE_INDEX];
            String fruit = entryData[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(entryData[QUANTITY_INDEX].trim());
            transactions.add(new FruitTransaction(operationCode, fruit, quantity));
        }
        return transactions;
    }
}
