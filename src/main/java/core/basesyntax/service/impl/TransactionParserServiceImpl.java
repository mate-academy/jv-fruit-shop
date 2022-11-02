package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final String SPLITTER = ",";
    private static final int START_POS = 1;
    private static final int OPERATION_POS = 0;
    private static final int FRUIT_POS = 1;
    private static final int QUANTITY_POS = 2;

    @Override
    public List<FruitTransaction> parseTransaction(List<String> data) {
        String[] parsedData;
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = START_POS; i < data.size(); i++) {
            parsedData = data.get(i).split(SPLITTER);
            fruitTransactions.add(new FruitTransaction(parseOperation(parsedData[OPERATION_POS]),
                    new Fruit(parsedData[FRUIT_POS]), Integer.parseInt(parsedData[QUANTITY_POS])));
        }
        return fruitTransactions;
    }

    private FruitTransaction.Operation parseOperation(String operation) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> o.getOperation().equals(operation))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such operation " + operation));
    }
}
