package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handlers.DataHandler;
import java.util.Map;

// SpringImitationService
public interface MapBuilderOperationService {
    Map<FruitTransaction.Operation, DataHandler> initializeMap();
}
