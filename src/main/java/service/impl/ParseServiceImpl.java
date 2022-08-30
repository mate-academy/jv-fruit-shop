package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final int TYPE_OF_OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLIT_SYMBOL = ",";

    @Override
    public List<FruitTransaction> parse(List<String> list) {
        List<FruitTransaction> fruitRecords = new ArrayList<>();
        list.remove(0);
        for (String fruit : list) {
            String[] split = fruit.split(SPLIT_SYMBOL);
            fruitRecords.add(new FruitTransaction(split[TYPE_OF_OPERATION_INDEX],
                    new Fruit(split[FRUIT_NAME_INDEX]),
                    Integer.parseInt(split[QUANTITY_INDEX])));
        }
        return fruitRecords;
    }
}
