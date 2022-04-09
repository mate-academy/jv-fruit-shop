package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.stratagy.OperationPerformer;
import core.basesyntax.stratagy.performers.PurchaseOperationPerformer;
import core.basesyntax.stratagy.performers.ReturnOperationPerformer;
import core.basesyntax.stratagy.performers.SetBalanceOperationPerformer;
import core.basesyntax.stratagy.performers.SupplyOperationPerformer;
import java.util.HashMap;
import java.util.Map;

public class SetUp {

    public Map<FruitTransaction.Operation, OperationPerformer> initPerformers() {
        Map<FruitTransaction.Operation, OperationPerformer> performers = new HashMap<>();
        performers.put(FruitTransaction.Operation.BALANCE, new SetBalanceOperationPerformer());
        performers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationPerformer());
        performers.put(FruitTransaction.Operation.RETURN, new ReturnOperationPerformer());
        performers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationPerformer());
        return performers;
    }
}
