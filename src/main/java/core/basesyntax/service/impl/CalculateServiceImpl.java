package core.basesyntax.service.impl;

import core.basesyntax.model.StorageTransaction;
import core.basesyntax.service.CalculateService;
import core.basesyntax.strategy.TransactionActivity;
import java.util.List;

public class CalculateServiceImpl implements CalculateService {
    private final TransactionActivity activity = new TransactionActivity();

    @Override
    public void calculate(List<StorageTransaction> transactions) {
        for (StorageTransaction transaction : transactions) {
            activity.getActivity(transaction).doActivity(transaction);
        }
    }
}
