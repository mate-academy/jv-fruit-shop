package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.ActivityType;
import model.FruitTransaction;
import service.FruitService;

public class FruitServiceImpl implements FruitService {
    private static final String REGEX = ",";
    private static final int INDEX_BY_LETTER = 0;
    private static final int INDEX_BY_FRUIT = 1;
    private static final int INDEX_BY_NUMBER = 2;

    @Override
    public List<FruitTransaction> processFruitLines(List<String> linesFromFile) {
        List<FruitTransaction> fruitTransactionArrayList = new ArrayList<>();
        for (String string : linesFromFile) {
            String[] resultData = string.split(REGEX);
            ActivityType shortOperation = ActivityType
                    .getOperationTypeByName(resultData[INDEX_BY_LETTER]);
            String fruitName = resultData[INDEX_BY_FRUIT];
            int number = Integer.parseInt(resultData[INDEX_BY_NUMBER]);
            fruitTransactionArrayList.add(new FruitTransaction(shortOperation, fruitName, number));
        }
        return fruitTransactionArrayList;
    }
}
