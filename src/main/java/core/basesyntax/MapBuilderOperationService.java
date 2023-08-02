package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.DataHandler;

import java.util.Map;

// SpringImitationService
public interface MapBuilderOperationService {
    Map<FruitTransaction.Operation, DataHandler> initializeMap();
}
