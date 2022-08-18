package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitsService;
import core.basesyntax.service.FruitsServiceImpl;
import core.basesyntax.service.csvfileservice.FileReaderServiceImpl;
import core.basesyntax.service.csvfileservice.FileWriterServiceImpl;
import core.basesyntax.service.fruittransactionservice.FruitTransactionMapper;
import core.basesyntax.service.fruittransactionservice.FruitTransactionMapperImpl;
import core.basesyntax.service.fruittransactionservice.FruitTransactionProcessor;
import core.basesyntax.service.fruittransactionservice.FruitTransactionProcessorImpl;
import core.basesyntax.service.operationsservice.BalanceFruitOperationHandler;
import core.basesyntax.service.operationsservice.FruitOperationHandler;
import core.basesyntax.service.operationsservice.PurchaseFruitOperationHandler;
import core.basesyntax.service.operationsservice.ReturnFruitOperationHandler;
import core.basesyntax.service.operationsservice.SupplyFruitOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_TO_READ = "src/main/resources/input_data.csv";
    private static final String FILE_TO_WRITE = "src/main/resources/output_data.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, FruitOperationHandler> operationsMap = new HashMap<>();
        FruitDao fruitDao = new FruitDaoImpl();
        operationsMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceFruitOperationHandler(fruitDao));
        operationsMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseFruitOperationHandler(fruitDao));
        operationsMap.put(FruitTransaction.Operation.RETURN,
                new ReturnFruitOperationHandler(fruitDao));
        operationsMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyFruitOperationHandler(fruitDao));

        FruitTransactionMapper fruitTransactionMapper = new FruitTransactionMapperImpl();
        FileReaderServiceImpl fileReaderService = new FileReaderServiceImpl();
        List<FruitTransaction> fruitTransactionList = fruitTransactionMapper
                .getFruitTransactions(fileReaderService.readFromFile(FILE_TO_READ));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsMap);
        FruitTransactionProcessor fruitTransactionProcessor =
                new FruitTransactionProcessorImpl(operationStrategy);
        fruitTransactionProcessor.makeDailyFruitsUpdate(fruitTransactionList);
        FruitsService fruitsService = new FruitsServiceImpl();
        String fruitsReport = fruitsService.generateFruitsReport(FruitsStorage.getFruits());
        FileWriterServiceImpl fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(fruitsReport, FILE_TO_WRITE);
    }
}
