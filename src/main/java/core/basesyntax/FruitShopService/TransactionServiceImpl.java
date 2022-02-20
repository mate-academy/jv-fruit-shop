package core.basesyntax.FruitShopService;

import static core.basesyntax.model.FruitTransaction.Operation.BALANCE;
import static core.basesyntax.model.FruitTransaction.Operation.PURCHASE;
import static core.basesyntax.model.FruitTransaction.Operation.RETURN;
import static core.basesyntax.model.FruitTransaction.Operation.SUPPLY;

import java.util.HashMap;
import java.util.Map;
import core.basesyntax.DB.Storage;
import core.basesyntax.model.FruitTransaction;


public class TransactionServiceImpl implements TransactionService {

    private final Map<FruitTransaction.Operation, Operation> operationMap;
    private final Storage storage;

    public TransactionServiceImpl(Storage storage) {
        operationMap = new HashMap<>();
        operationMap.put(BALANCE, new BalanceOperation());
        operationMap.put(SUPPLY, new SupplyOperation());
        operationMap.put(RETURN, new ReturnOperation());
        operationMap.put(PURCHASE, new PurchaseOperation());
        this.storage = storage;
    }

    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        operationMap.get(fruitTransaction.getOperation()).process(fruitTransaction, storage);
    }
}
