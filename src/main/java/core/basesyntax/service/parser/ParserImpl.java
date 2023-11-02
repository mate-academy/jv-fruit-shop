package core.basesyntax.service.parser;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String COMMA = ",";

    public List<FruitTransaction> parseStringToFruitTransaction(List<String> allLines) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = 1; i < allLines.size(); i++) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] data = allLines.get(i).split(COMMA);
            fruitTransaction.setOperation(FruitTransaction.Operation.findByCode(data[OPERATION]));
            fruitTransaction.setFruit(data[FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(data[QUANTITY]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
