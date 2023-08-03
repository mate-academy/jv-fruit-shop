package core.basesyntax;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.dao.ShopDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.operation.BalanceOperation;
import core.basesyntax.service.operation.Operation;
import core.basesyntax.service.operation.PurchaseOperation;
import core.basesyntax.service.operation.ReturnOperation;
import core.basesyntax.service.operation.SupplyOperation;
import java.util.HashMap;
import java.util.List;

public class FruitShop {
    public static void main(String[] args) {
        //read from file
        String addressFile = "src/main/resources/input.csv";
        ShopDao shopDao = new ShopDaoImpl();
        shopDao.readFromFile(addressFile);
        //process with data
        HashMap<FruitTransaction.Operation, Operation> operationHashMap = new HashMap<>();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHashMap);
        operationHashMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHashMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHashMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHashMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        List<FruitTransaction> transactions = Storage.getTransactions();
        for (int i = 0; i < transactions.size(); i++) {
            FruitTransaction transaction = Storage.getTransactions().get(i);
            Operation operation = operationStrategy.getOperation(transaction);
            operation.processWithTransaction(transaction);
        }
        //write to file
        String reportFile = "src/main/resources/report.csv";
        shopDao.writeToFile(Storage.getReport(), reportFile);
    }
}
