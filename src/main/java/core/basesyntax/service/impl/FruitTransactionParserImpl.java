package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> fruitDataList) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : fruitDataList.subList(1, fruitDataList.size())) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] splittedLine = line.split(",");
            String letter = splittedLine[OPERATION_INDEX];
            String fruitName = splittedLine[FRUIT_INDEX];
            int quantity = Integer.parseInt(splittedLine[QUANTITY_INDEX]);
            fruitTransaction.setFruit(fruitName);
            fruitTransaction.setQuantity(quantity);
            fruitTransaction.setOperation(FruitTransaction.Operation.findOperationByLetter(letter));
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
