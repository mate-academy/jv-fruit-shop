package core.basesyntax.service;

import core.basesyntax.service.action.ActionHandler;
import java.util.Optional;

public interface ActionStrategy {
    Optional<ActionHandler> get(String action);
}
