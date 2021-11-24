package service.implement;

import core.basesyntax.model.ParseLine;
import service.FruitCounter;

import java.util.List;

public class FruitCounterImpl implements FruitCounter {
    @Override
    public boolean fruitCounter(List<ParseLine> list) {
        for (ParseLine line: list) {
            strategy.getOperationService(line).operation(line);
        }
        return true;
    }
}
