package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitsService;
import core.basesyntax.service.FruitsServiceImpl;
import core.basesyntax.service.csvfileservice.ReaderServiceImpl;
import core.basesyntax.service.csvfileservice.WriterServiceImpl;
import core.basesyntax.service.fruittransactionservice.FruitTransactionOperation;
import core.basesyntax.service.fruittransactionservice.TransactionOperation;
import core.basesyntax.service.operationsservice.BalanceFruitOperation;
import core.basesyntax.service.operationsservice.FruitOperation;
import core.basesyntax.service.operationsservice.PurchaseFruitOperation;
import core.basesyntax.service.operationsservice.ReturnFruitOperation;
import core.basesyntax.service.operationsservice.SupplyFruitOperation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String NAME_OF_FILE_TO_READ = "src/main/resources/input_data.csv";
    private static final String NAME_OF_FILE_TO_WRITE = "src/main/resources/output_data.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, FruitOperation> operationsMap = new HashMap<>();
        FruitDao fruitDao = new FruitDaoImpl();
        operationsMap.put(FruitTransaction.Operation.BALANCE, new BalanceFruitOperation(fruitDao));
        operationsMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseFruitOperation(fruitDao));
        operationsMap.put(FruitTransaction.Operation.RETURN, new ReturnFruitOperation(fruitDao));
        operationsMap.put(FruitTransaction.Operation.SUPPLY, new SupplyFruitOperation(fruitDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsMap);

        TransactionOperation fruitTransactionOperation = new FruitTransactionOperation();
        List<FruitTransaction> fruitTransactionList = fruitTransactionOperation
                .convertDataToFruitTransaction(new ReaderServiceImpl()
                        .readFromFile(NAME_OF_FILE_TO_READ));
        FruitsService fruitsService = new FruitsServiceImpl(new FruitDaoImpl(),
                operationStrategy);
        String fruitsReport = fruitsService.generateFruitsReport(fruitTransactionList);
        new WriterServiceImpl().writeToFile(fruitsReport, NAME_OF_FILE_TO_WRITE);
    }
}
