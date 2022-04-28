package core.basesyntax.service.parser;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> fruits = new ArrayList<>();
        for (String line : lines) {
            String[] splittedLine = line.split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getType(splittedLine[TYPE_INDEX]));
            fruitTransaction.setFruit(splittedLine[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(splittedLine[QUANTITY_INDEX]));
            fruits.add(fruitTransaction);
        }
        return fruits;
    }
}
