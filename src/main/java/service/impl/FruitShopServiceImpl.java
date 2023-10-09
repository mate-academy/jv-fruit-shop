package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.ActivitiesStrategy;
import service.FruitShopService;
import service.activities.TransactionHandler;

public class FruitShopServiceImpl implements FruitShopService {
    private final ActivitiesStrategy activitiesStrategy;

    public FruitShopServiceImpl(ActivitiesStrategy activitiesStrategy) {
        this.activitiesStrategy = activitiesStrategy;
    }

    @Override
    public void convert(List<String> lines) {
        for (int i = 1; i < lines.size(); i++) {
            FruitTransaction fruitTransaction = getFromCvsRow(lines.get(i));
            TransactionHandler transactionHandler = activitiesStrategy
                    .get(fruitTransaction.getOperation());
            transactionHandler.executeTransaction(fruitTransaction);
        }

    }

    private FruitTransaction getFromCvsRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        String operationCode = fields[0].trim();
        FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(operationCode);

        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }
}
