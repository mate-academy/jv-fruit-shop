package service.impl;

import java.util.LinkedList;
import java.util.List;
import models.Fruit;
import models.FruitTransaction;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final String SPLITERATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int COLUMN_NAMES_ROW_INDEX = 0;

    @Override
    public List<FruitTransaction> parse(List<String> readeData) {
        List<FruitTransaction> fruitTransactions = new LinkedList<>();
        String[] info;
        readeData.remove(COLUMN_NAMES_ROW_INDEX);
        for (String line : readeData) {
            info = line.split(SPLITERATOR);
            fruitTransactions.add(new FruitTransaction(
                    FruitTransaction.Operation.getOperationFromString(info[OPERATION_INDEX]),
                    new Fruit(info[FRUIT_INDEX],Integer.parseInt(info[QUANTITY_INDEX])),
                    Integer.parseInt(info[QUANTITY_INDEX])));
        }
        return fruitTransactions;
    }
}
