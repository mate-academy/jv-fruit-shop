package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final String SPLIT_SYMBOL = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> list) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String e : list) {
            String[] spllitedData = e.split(SPLIT_SYMBOL);
            FruitTransaction fruitTransaction = new FruitTransaction(
                    Operation.getByValue(spllitedData[OPERATION_INDEX]),
                    spllitedData[FRUIT_INDEX],
                    Integer.parseInt(spllitedData[QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
