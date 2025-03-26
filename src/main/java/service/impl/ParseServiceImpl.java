package service.impl;

import model.FruitTransaction;
import model.FruitTransaction.Operation;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final String SEPARATION = ",";

    private FruitTransaction getCsv(String line) {
        String[] fields = line.split(SEPARATION);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(Operation.fromCode(fields[0]));
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }

    @Override
    public FruitTransaction parseLine(String line) {
        return getCsv(line);
    }
}
