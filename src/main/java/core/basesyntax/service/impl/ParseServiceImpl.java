package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    private static final String COMMA = ",";

    @Override
    public List<FruitTransaction> parseTransaction(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] parsedDate;
        for (int i = 1; i < dataFromFile.size(); i++) {
            parsedDate = dataFromFile.get(i).split(COMMA);
            fruitTransactions.add(new FruitTransaction(FruitTransaction.Operation
                    .getByOperation(parsedDate[0]),
                    parsedDate[1], Integer.parseInt(parsedDate[2])));
        }
        return fruitTransactions;
    }
}
