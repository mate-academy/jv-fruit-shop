package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public String applyTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            int newQuantity = operationStrategy.get(transaction.getOperation())
                    .executeOperation(transaction);
            if (newQuantity < 0) {
                throw new RuntimeException("Quantity can't be less than zero");
            }
        }
        StringBuilder reportStringBuilder = new StringBuilder();
        reportStringBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            reportStringBuilder.append(entry.getKey())
                    .append(',')
                    .append(entry.getValue().toString())
                    .append(System.lineSeparator());
        }
        return reportStringBuilder.toString();
    }
}
