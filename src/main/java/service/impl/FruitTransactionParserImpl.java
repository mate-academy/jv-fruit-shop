package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.ActivityType;
import model.Fruit;
import model.FruitTransaction;
import service.FruitTransactionParser;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final String REGEX = ",";
    private static final int TITLE_POSITION = 1;
    private static final int ACTIVITY_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int AMOUNT_POSITION = 2;

    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        List<FruitTransaction> transactionList = new ArrayList<>();
        String[] splitData;
        for (int i = TITLE_POSITION; i < dataFromFile.size(); i++) {
            splitData = dataFromFile.get(i).split(REGEX);
            transactionList.add(new FruitTransaction(
                    ActivityType.getByCode(splitData[ACTIVITY_POSITION]),
                    new Fruit(splitData[FRUIT_POSITION]),
                    Integer.parseInt(splitData[AMOUNT_POSITION])));
        }
        return transactionList;
    }
}
