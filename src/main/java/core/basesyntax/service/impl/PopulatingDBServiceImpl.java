package core.basesyntax.service.impl;

import core.basesyntax.dao.OperationHandler;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.PopulatingDBService;
import java.util.List;
import java.util.Map;

public class PopulatingDBServiceImpl implements PopulatingDBService {
    public final Map<String, OperationHandler> activities;

    public PopulatingDBServiceImpl(Map<String, OperationHandler> activities) {
        this.activities = activities;
    }

    @Override
    public void prepareDB(List<FruitTransaction> transactionList) {
        transactionList.stream()
                .forEach(ft -> {
                    OperationHandler operationHandler = activities.get(ft.getOperation());
                    if (operationHandler == null) {
                        throw new RuntimeException("Unknown operation.");
                    }
                    operationHandler.apply(ft.getFruit(), ft.getQuantity());
                });
    }
}
