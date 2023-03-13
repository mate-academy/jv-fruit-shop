package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionsEvaluateService;
import core.basesyntax.strategy.ReportStrategy;
import core.basesyntax.strategy.impl.ReportStrategyImpl;
import java.util.List;

public class TransactionsEvaluateServiceImpl implements TransactionsEvaluateService {
    private ReportStrategy strategy = new ReportStrategyImpl();

    @Override
    public void evaluate(List<FruitTransaction> transactions) {
        transactions.forEach(t -> strategy.process(t));
    }
}
