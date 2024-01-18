package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    public static final int ACTIVITY_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseOperations(List<String> dataFromFile) {
        List<FruitTransaction> transactionsList = new ArrayList<>();
        for (String str : dataFromFile) {
            String[] parts = str.split(",");
            String activity = parts[ACTIVITY_INDEX];
            String fruit = parts[FRUIT_INDEX];
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            transactionsList.add(new FruitTransaction(FruitTransaction
                    .getOperationByCode(activity), fruit, quantity));

        }
        return transactionsList;
    }
}
