package core.basesyntax.service;

import core.basesyntax.model.Account;
import core.basesyntax.service.action.ActionHandler;

public interface ActionStrategy {
    ActionHandler get(Account.Operation operation);
}
