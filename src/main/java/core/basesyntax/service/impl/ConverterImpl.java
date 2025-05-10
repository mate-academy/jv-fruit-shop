package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Converter;
import java.util.ArrayList;
import java.util.List;

public class ConverterImpl implements Converter {
    public static final String elementSeparator = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> transactions) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String transaction : transactions) {
            String[] elements = transaction.split(elementSeparator);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(elements[0]));
            fruitTransaction.setFruitName(elements[1]);
            fruitTransaction.setQuantity(Integer.parseInt(elements[2]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
