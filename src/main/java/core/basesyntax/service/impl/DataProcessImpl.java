package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcess;
import core.basesyntax.service.TransitionProcessor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessImpl implements DataProcess {
    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {
        TransitionProcessor transitionProcessor = new TransitionProcessorImpl();
        Map<String, Integer> balanceMap = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            balanceMap.putIfAbsent(transaction.getFruit(), 0);
            transitionProcessor.processTransaction(balanceMap, transaction);

        }
        return balanceMap;
    }
}
