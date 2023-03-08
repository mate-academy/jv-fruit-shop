package core.basesyntax.service.impl;

import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.service.CreateTheReport;
import core.basesyntax.strategy.ActionStrategyImpl;
import core.basesyntax.strategy.ActionsStrategy;
import java.util.List;

public class CreateTheReportImpl implements CreateTheReport {
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private final ActionsStrategy actionsStrategy = new ActionStrategyImpl();

    @Override
    public void add(List<String[]> list) {
        for (String[] str : list) {
            actionsStrategy.get(TypeOfOperation.getByCode(str[INDEX_0]))
                    .getAmountAfterAction(str[INDEX_1], Integer.parseInt(str[INDEX_2]));
        }
    }
}
