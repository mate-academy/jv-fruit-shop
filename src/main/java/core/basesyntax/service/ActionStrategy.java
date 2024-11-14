package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.action.ActionHandler;

//public interface ActionStrategy {
//    ActionHandler get(Account.Operation operation);
//}
public interface ActionStrategy {
    void execute(FruitTransaction fruitTransaction);
}
