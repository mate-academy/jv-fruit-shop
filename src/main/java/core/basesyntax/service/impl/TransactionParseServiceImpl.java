package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParseService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParseServiceImpl implements TransactionParseService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> getTransactionData(List<String> data) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        if (data != null) {
            List<String> dataRows = data.subList(1, data.size());
            fruitTransactionList = dataRows.stream()
                    .map(s -> s.split(SEPARATOR))
                    .map(p -> new FruitTransaction(FruitTransaction
                            .Operation.getOperation(p[OPERATION]),
                            p[FRUIT], Integer.parseInt(p[QUANTITY])))
                    .collect(Collectors.toList());
        }
        return fruitTransactionList;
    }
}
