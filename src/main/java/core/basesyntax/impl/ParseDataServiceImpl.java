package core.basesyntax.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.ParseDataService;
import java.util.ArrayList;
import java.util.List;

public class ParseDataServiceImpl implements ParseDataService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 0; i < dataFromFile.size(); i++) {
            String line = dataFromFile.get(i);
            String[] records = line.split(",");
            transactions.add(new FruitTransaction(FruitTransaction.Operation
                    .getByName(records[OPERATION_INDEX]),
                    new Fruit(records[FRUIT_INDEX]), Integer.parseInt(records[QUANTITY_INDEX])));
        }
        return transactions;
    }
}
