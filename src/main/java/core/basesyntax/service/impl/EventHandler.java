package core.basesyntax.service.impl;

import core.basesyntax.model.Event;
import core.basesyntax.service.IEventHandler;
import core.basesyntax.service.IOperationStrategy;
import java.util.List;

public class EventHandler implements IEventHandler {
    private final IOperationStrategy operationStrategy = new OperationStrategy();

    @Override
    public void convertList(List<Event> list) {
        list.forEach(event -> operationStrategy.get(event.operation())
                .performOperation(event.name(), event.quantity()));
    }
}
