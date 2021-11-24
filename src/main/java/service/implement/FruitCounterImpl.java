package service.implement;

import core.basesyntax.model.ParseLine;
import java.util.List;
import service.FruitCounter;

public class FruitCounterImpl implements FruitCounter {
    @Override
    public boolean fruitCounter(List<ParseLine> parseLineList) {
        for (ParseLine line: parseLineList) {
            strategy.getOperationService(line).operation(line);
        }
        return true;
    }
}
