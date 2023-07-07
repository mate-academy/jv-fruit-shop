package mate.academy.service.impl;

import java.util.ArrayList;
import java.util.List;
import mate.academy.model.FruitTransaction;
import mate.academy.service.Parser;

public class ParserImpl implements Parser {
    private static final String SEPARATOR = ",";
    private final int operationCodeIndex;
    private final int quantityIndex;
    private final int fruitNameIndex;

    public ParserImpl() {
        operationCodeIndex = 0;
        quantityIndex = 2;
        fruitNameIndex = 1;
    }

    @Override
    public List<FruitTransaction> parseData(List<String> inputDataRows) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < inputDataRows.size(); i++) {
            String[] entryData = inputDataRows.get(i).split(SEPARATOR);
            String operationCode = entryData[operationCodeIndex];
            String fruit = entryData[fruitNameIndex];
            int quantity = Integer.parseInt(entryData[quantityIndex].trim());
            transactions.add(new FruitTransaction(operationCode, fruit, quantity));
        }
        return transactions;
    }
}
