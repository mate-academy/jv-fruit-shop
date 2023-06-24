package core.service.impl;

import core.model.FruitTransaction;
import core.service.DataParserService;
import java.util.ArrayList;
import java.util.List;

public class DataParserServiceImpl implements DataParserService {
    private static final String COMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int FIRST_DATA_LINE = 1;

    @Override
    public List<FruitTransaction> parseList(List<String> dataFromFile) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = FIRST_DATA_LINE; i < dataFromFile.size(); i++) {
            transactions.add(parseLine(dataFromFile.get(i)));
        }
        return transactions;
    }

    private FruitTransaction parseLine(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] activities = line.split(COMA);
        fruitTransaction.setFruit(activities[FRUIT_INDEX]);
        fruitTransaction.setOperation(FruitTransaction
                .Operation.getByCode(activities[OPERATION_INDEX]));
        fruitTransaction.setQuantity(Integer.parseInt(activities[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
