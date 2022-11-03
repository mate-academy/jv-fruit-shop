package com.basesyntax.services;

import com.basesyntax.strategy.impl.StrategyImpl;
import java.util.List;

public interface TransactionProcessor {
    void processingData(List<String> data, StrategyImpl strategy);
}
