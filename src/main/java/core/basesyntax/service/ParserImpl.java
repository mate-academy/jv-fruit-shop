package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            fruitTransactions.add(parseLine(lines.get(i)));
        }
        return fruitTransactions;
    }

    public FruitTransaction parseLine(String textLine) {
        String[] arrayOfLine = textLine.split(SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setFruit(arrayOfLine[FRUIT_INDEX]);
        fruitTransaction.setOperation(FruitTransaction
                .Operation.getByCode(arrayOfLine[OPERATION_INDEX]));
        fruitTransaction.setQuantity(Integer.parseInt(arrayOfLine[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
