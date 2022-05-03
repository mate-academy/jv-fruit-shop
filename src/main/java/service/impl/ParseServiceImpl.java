package service.impl;

import static model.FruitTransaction.Operation.getByName;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getInfo(List<String> list) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        list.stream()
                .map(i -> i.split("-"))
                .forEach(i -> fruitTransactions.add(
                        new FruitTransaction(getByName(i[OPERATION_INDEX]),
                                new Fruit(i[FRUIT_INDEX]), Integer.parseInt(i[QUANTITY_INDEX]))));
        return fruitTransactions;
    }
}
