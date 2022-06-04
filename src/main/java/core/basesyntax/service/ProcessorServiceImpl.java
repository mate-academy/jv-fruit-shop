package core.basesyntax.service;

import core.basesyntax.model.Record;
import core.basesyntax.strategy.action.ActionHandler;
import core.basesyntax.strategy.ActionStrategy;
import java.util.Queue;

public class ProcessorServiceImpl implements ProcessorService {
    ActionStrategy actionStrategy;

    public ProcessorServiceImpl(ActionStrategy actionStrategy) {
        this.actionStrategy = actionStrategy;
    }

    @Override
    public void process(Queue<Record> records) {
        while (!records.isEmpty()) {
            Record record = records.poll();
            ActionHandler actionHandler = actionStrategy.get(record.getOperation());
            actionHandler.runAction(record);
        }
    }
}
