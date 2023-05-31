package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.OperationType;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final String ONLY_LETTERS_SEPARATOR = "\\W+";
    private static final byte TYPE = 0;
    private static final byte FRUIT = 1;
    private static final byte QUANTITY = 2;
    private static final byte COLUMNS_NAMES = 0;

    @Override
    public List<FruitTransaction> getFruitTransaction(List<String> data) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();

        data.remove(COLUMNS_NAMES);

        for (var line : data) {
            String[] splitString = line.split(ONLY_LETTERS_SEPARATOR);
            fruitTransactionList
                    .add(new FruitTransaction(OperationType.getByCode(splitString[TYPE]),
                            splitString[FRUIT], Integer.parseInt(splitString[QUANTITY])));

        }
        return fruitTransactionList;
    }
}
