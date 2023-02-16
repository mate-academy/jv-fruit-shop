package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.FruitTransaction;
import service.ActivityChecker;
import service.DataParser;

public class DataParserImpl implements DataParser {
    private static final String REGEX = ",";
    private static final int TITLE_POSITION = 1;
    private static final int ACTIVITY_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int AMOUNT_POSITION = 2;
    private final ActivityChecker activityChecker;

    public DataParserImpl(ActivityChecker activityChecker) {
        this.activityChecker = activityChecker;
    }

    @Override
    public List<FruitTransaction> splitToCategories(List<String> dataFromFile) {
        List<FruitTransaction> transactionList = new ArrayList<>();
        String[] splitData;
        for (int i = TITLE_POSITION; i < dataFromFile.size(); i++) {
            splitData = dataFromFile.get(i).split(REGEX);
            transactionList.add(new FruitTransaction(
                    activityChecker.checkActivity(splitData[ACTIVITY_POSITION]),
                    new Fruit(splitData[FRUIT_POSITION]),
                    Integer.parseInt(splitData[AMOUNT_POSITION])));
        }
        return transactionList;
    }
}
