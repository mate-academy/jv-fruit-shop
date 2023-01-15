package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportFormatter;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportFormatterImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = 
            "src/main/resources/inputFile.csv";
    private static final String REPORT_FILE_PATH = 
            "src/main/resources/reportFile.csv";  
    private static final Map<Operation, OperationHandler> strategyMap = new HashMap<>();
    
    static {
        strategyMap.put(Operation.BALANCE, new BalanceOperationHandler());
        strategyMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        strategyMap.put(Operation.RETURN, new ReturnOperationHandler());
        strategyMap.put(Operation.SUPPLY, new SupplyOperationHandler());
    }

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategyMap);
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        FruitDao fruitDao = new FruitDaoImpl();
        ReportFormatter reportFormatter = new ReportFormatterImpl();

        List<String> inputFileContent = readerService.readFromFile(INPUT_FILE_PATH);
        for (int i = 1; i < inputFileContent.size(); i++) {
            FruitTransaction fruitTransaction = fruitTransactionService
                    .newFruitTransaction(inputFileContent.get(i));
            Fruit newFruitEntry = operationStrategy.get(fruitTransaction
                    .getOperation()).performOperation(fruitTransaction);
            fruitDao.add(newFruitEntry);
        }
        List<String> report = reportFormatter.makeReport();
        writerService.writeToFile(report, REPORT_FILE_PATH);
    }
}
