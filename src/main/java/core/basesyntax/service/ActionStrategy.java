package core.basesyntax.service;

import core.basesyntax.service.actiontype.ActionType;

public interface ActionStrategy {
    ActionType get(String type);
}
