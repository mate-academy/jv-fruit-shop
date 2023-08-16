package core.basesyntax.service.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParseImpl implements ParserService {

    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> parse) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < parse.size(); i++) {
            fruitTransactions.add(parseLine(parse.get(i)));
        }
        return fruitTransactions;
    }

    private FruitTransaction parseLine(String line) {
        String[] lineArray = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setFruit(lineArray[FRUIT_INDEX]);
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getByCode(lineArray[OPERATION_INDEX]));
        fruitTransaction.setQuantity(Integer.parseInt(lineArray[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
