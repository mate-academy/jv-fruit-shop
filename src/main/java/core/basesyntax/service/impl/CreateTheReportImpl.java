package core.basesyntax.service.impl;

import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.service.CreateTheReport;
import core.basesyntax.strategy.ActionStrategyImpl;
import core.basesyntax.strategy.ActionsStrategy;
import java.util.List;

public class CreateTheReportImpl implements CreateTheReport {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String WORD_TO_IGNORE = "type";
    private final ActionsStrategy actionsStrategy = new ActionStrategyImpl();

    @Override
    public void add(List<String[]> list) {
        for (String[] str : list) {
            if (str[TYPE_INDEX].equals(WORD_TO_IGNORE)) {
                continue;
            }
            actionsStrategy.get(TypeOfOperation.getByCode(str[TYPE_INDEX]))
                    .getAmountAfterAction(str[FRUIT_INDEX], Integer.parseInt(str[AMOUNT_INDEX]));
        }
    }
}
