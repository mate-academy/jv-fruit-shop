package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        int quantity = 0;
        String fruitName;
        FruitTransaction.Operation operationType;
        String[] array;
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : lines) {
            array = line.split(",");
            if (array[1].length() >= 1 && array[0].length() >= 1) {
                quantity = Integer.parseInt(array[2]);
                fruitName = array[1];
                operationType = FruitTransaction.Operation.fromOperation(array[0]);
                fruitTransactions.add(new FruitTransaction(operationType, fruitName, quantity));
            }
        }
        return fruitTransactions;
    }
}
