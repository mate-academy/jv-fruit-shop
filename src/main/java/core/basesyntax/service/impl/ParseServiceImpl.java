package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransaction(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] parsedDate;
        for (int i = 1; i < dataFromFile.size(); i++) {
            parsedDate = dataFromFile.get(i).split(COMMA);
            fruitTransactions.add(new FruitTransaction(FruitTransaction.Operation
                    .getByOperation(parsedDate[OPERATION_INDEX]),
                    parsedDate[FRUIT_INDEX], Integer.parseInt(parsedDate[QUANTITY_INDEX])));
        }
        return fruitTransactions;
    }
}
