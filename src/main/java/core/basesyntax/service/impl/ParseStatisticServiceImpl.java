package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseStatisticService;
import java.util.ArrayList;
import java.util.List;

public class ParseStatisticServiceImpl implements ParseStatisticService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> line) {
        List<FruitTransaction> fruitTransactionStatistic = new ArrayList<>();
        for (int i = 1; i < line.size(); i++) {
            String[] splittedLine = line.get(i).split("\\W+");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getOperationType(splittedLine[OPERATION_INDEX]));
            fruitTransaction.setFruit(splittedLine[FRUIT_INDEX]);
            fruitTransaction
                    .setQuantity(Integer.parseInt(splittedLine[QUANTITY_INDEX]));
            fruitTransactionStatistic.add(fruitTransaction);
        }
        return fruitTransactionStatistic;
    }
}
