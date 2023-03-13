package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;

import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String COMMA_DELIMITER = ",";
    @Override
    public List<FruitTransaction> parse(List<String> records) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String record : records) {
            String[] values = record.split(COMMA_DELIMITER);
            FruitTransaction.Operation type = FruitTransaction.Operation.valueOf(values[0]);
            String fruit = values[1];
            int quantity = Integer.parseInt(values[2]);
            FruitTransaction fruitTransaction = new FruitTransaction(type, fruit, quantity);
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }


}
