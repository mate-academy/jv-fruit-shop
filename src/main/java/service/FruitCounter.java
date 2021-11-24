package service;

import core.basesyntax.model.ParseLine;
import java.util.List;
import strategy.OperationStrategy;
import strategy.implement.OperationStrategyImpl;

public interface FruitCounter {
    OperationStrategy strategy = new OperationStrategyImpl();
    boolean fruitCounter(List<ParseLine> parseLineList);
}
