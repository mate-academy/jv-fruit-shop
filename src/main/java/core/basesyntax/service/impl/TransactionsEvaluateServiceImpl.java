package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionsEvaluateService;
import core.basesyntax.strategy.ReportStrategy;
import java.util.List;

public class TransactionsEvaluateServiceImpl implements TransactionsEvaluateService {
    private ReportStrategy strategy;

    public TransactionsEvaluateServiceImpl(ReportStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void evaluate(List<FruitTransaction> transactions) {
        transactions.forEach(strategy::process);
    }
}
