package Service.Impl;

import Service.ParsinService;
import model.FruitTransaction;

public class ParsingServiceImpl implements ParsinService {
    private static final String SPLITTER = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public FruitTransaction parse(String line) {
        String[] separatedLine = line.split(SPLITTER);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(separatedLine[INDEX_OF_OPERATION]);
        fruitTransaction.setFruit(separatedLine[INDEX_OF_FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(separatedLine[INDEX_OF_QUANTITY]));
        return fruitTransaction;
    }
}