package core.basesyntax.service;

import core.basesyntax.template.FruitTransaction;

public class ParseServiceImpl implements ParseService {

    @Override
    public FruitTransaction parseLine(String operation) {
        String[] fields = operation.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.getByCode(fields[0]));
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }

    /*
        public static FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.getByCode(fields[0]));
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }

     */
}
