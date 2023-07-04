package mate.academy.service.impl;//*

import java.util.ArrayList;
import java.util.List;
import mate.academy.model.FruitTransaction;
import mate.academy.service.ParserService;

public class ParserServiceImpl implements ParserService {
    private final String dataSeparator;
    private final int operationCodeIndex;
    private final int quantityIndex;
    private final int fruitNameIndex;

    public ParserServiceImpl() {
        dataSeparator = ",";
        operationCodeIndex = 0;
        quantityIndex = 2;
        fruitNameIndex = 1;
    }

    @Override
    public List<FruitTransaction> parseData(List<String> inputDataRows) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < inputDataRows.size(); i++) {
            String[] entryData = inputDataRows.get(i).split(dataSeparator);
            String operationCode = entryData[operationCodeIndex];
            String fruit = entryData[fruitNameIndex];
            int quantity = Integer.parseInt(entryData[quantityIndex].trim());
            transactions.add(new FruitTransaction(operationCode, fruit, quantity));
        }
        return transactions;
    }
}
