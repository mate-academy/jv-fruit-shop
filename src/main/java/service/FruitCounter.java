package service;

import Strategy.OperationStrategy;
import Strategy.implement.OperationStrategyImpl;
import core.basesyntax.model.ParseLine;

import java.util.List;

public interface FruitCounter {
    OperationStrategy strategy = new OperationStrategyImpl();
    boolean fruitCounter(List<ParseLine> list);
}
