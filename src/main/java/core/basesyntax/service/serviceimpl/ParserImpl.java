package core.basesyntax.service.serviceimpl;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String SPLIT_REGEX = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private FruitTransaction fruitTransaction;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            fruitTransactions.add(parseLine(lines.get(i)));
        }
        return fruitTransactions;
    }

    private FruitTransaction parseLine(String textLine) {
        String[] arrayOf1Line = textLine.split(SPLIT_REGEX);
        fruitTransaction = new FruitTransaction();
        fruitTransaction.setFruit(arrayOf1Line[FRUIT_INDEX]);
        fruitTransaction.setOperation(FruitTransaction
                .Operation.getCode(arrayOf1Line[OPERATION_INDEX]));
        fruitTransaction.setQuantity(Integer.parseInt(arrayOf1Line[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
