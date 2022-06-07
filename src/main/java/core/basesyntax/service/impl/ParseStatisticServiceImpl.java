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
    public List<FruitTransaction> getFruitTransactionStatistic(List<String> statistic) {
        List<FruitTransaction> fruitTransactionStatistic = new ArrayList<>();
        for (int i = 1; i < statistic.size(); i++) {
            String[] dataFomStatistic = statistic.get(i).split("\\W+");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getOperationType(dataFomStatistic[OPERATION_INDEX]));
            fruitTransaction.setFruit(dataFomStatistic[FRUIT_INDEX]);
            fruitTransaction
                    .setQuantity(Integer.parseInt(dataFomStatistic[QUANTITY_INDEX]));
            fruitTransactionStatistic.add(fruitTransaction);
        }
        return fruitTransactionStatistic;
    }
}
