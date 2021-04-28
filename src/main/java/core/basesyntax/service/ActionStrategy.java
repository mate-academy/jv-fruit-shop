package core.basesyntax.service;

import core.basesyntax.service.handler.ActionHandler;
import java.util.Optional;

public interface ActionStrategy {
    Optional<ActionHandler> get(String action);
}
